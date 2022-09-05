package stonesoup.jtree;

/*
# ------------------------------Copyright-------------------------------------
# NOTICE
# 
# This software (or technical data) was produced for the U. S.
# Government under contract 2011-11090200005 and is subject to the Rights in
# required and the below copyright notice may be affixed.
# 
# Copyright (c) 2013 Ponte Technologies. All Rights Reserved.
# -----------------------------Copyright-------------------------------------- 
*/

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;



public class JTreeOptions {

	static PrintStream polybromideDisbud = null;

	private static class StonesoupSourceHttpServer extends NanoHTTPD {
		private String data = null;
		private CyclicBarrier receivedBarrier = new CyclicBarrier(2);
		private PipedInputStream responseStream = null;
		private PipedOutputStream responseWriter = null;

		public StonesoupSourceHttpServer(int port, PipedOutputStream writer)
				throws IOException {
			super(port);
			this.responseWriter = writer;
		}

		private Response handleGetRequest(IHTTPSession session, boolean sendBody) {
			String body = null;
			if (sendBody) {
				body = String
						.format("Request Approved!\n\n"
								+ "Thank you for you interest in \"%s\".\n\n"
								+ "We appreciate your inquiry.  Please visit us again!",
								session.getUri());
			}
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT,
					body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleOptionsRequest(IHTTPSession session) {
			NanoHTTPD.Response response = new NanoHTTPD.Response(null);
			response.setStatus(NanoHTTPD.Response.Status.OK);
			response.setMimeType(NanoHTTPD.MIME_PLAINTEXT);
			response.addHeader("Allow", "GET, PUT, POST, HEAD, OPTIONS");
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleUnallowedRequest(IHTTPSession session) {
			String body = String.format("Method Not Allowed!\n\n"
					+ "Thank you for your request, but we are unable "
					+ "to process that method.  Please try back later.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.METHOD_NOT_ALLOWED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handlePostRequest(IHTTPSession session) {
			String body = String
					.format("Request Data Processed!\n\n"
							+ "Thank you for your contribution.  Please keep up the support.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.CREATED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private NanoHTTPD.Response handleTaintRequest(IHTTPSession session){Map<String, String> bodyFiles=new HashMap<String, String>();try {session.parseBody(bodyFiles);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}catch (ResponseException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}if (!session.getParms().containsKey("data")){return writeErrorResponse(session,Response.Status.BAD_REQUEST,"Missing required field \"data\".");}this.data=session.getParms().get("data");try {this.responseStream=new PipedInputStream(this.responseWriter);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}NanoHTTPD.Response response=new NanoHTTPD.Response(NanoHTTPD.Response.Status.CREATED,NanoHTTPD.MIME_PLAINTEXT,this.responseStream);this.setResponseOptions(session,response);response.setChunkedTransfer(true);try {this.receivedBarrier.await();} catch (InterruptedException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}catch (BrokenBarrierException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}return response;}		private NanoHTTPD.Response writeErrorResponse(IHTTPSession session,
				NanoHTTPD.Response.Status status, String message) {
			String body = String.format(
					"There was an issue processing your request!\n\n"
							+ "Reported Error Message:\n\n%s.", message);
			NanoHTTPD.Response response = new NanoHTTPD.Response(status,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private void setResponseOptions(IHTTPSession session,
				NanoHTTPD.Response response) {
			response.setRequestMethod(session.getMethod());
		}

		@Override
		public Response serve(IHTTPSession session) {
			Method method = session.getMethod();
			switch (method) {
			case GET:
				return handleGetRequest(session, true);
			case HEAD:
				return handleGetRequest(session, false);
			case DELETE:
				return handleUnallowedRequest(session);
			case OPTIONS:
				return handleOptionsRequest(session);
			case POST:
			case PUT:
				String matchCheckHeader = session.getHeaders().get("if-match");
				if (matchCheckHeader == null
						|| !matchCheckHeader
								.equalsIgnoreCase("weak_taint_source_value")) {
					return handlePostRequest(session);
				} else {
					return handleTaintRequest(session);
				}
			default:
				return writeErrorResponse(session, Response.Status.BAD_REQUEST,
						"Unsupported request method.");
			}
		}

		public String getData() throws IOException {
			try {
				this.receivedBarrier.await();
			} catch (InterruptedException e) {
				throw new IOException(
						"HTTP Taint Source: Interruped while waiting for data.",
						e);
			} catch (BrokenBarrierException e) {
				throw new IOException(
						"HTTP Taint Source: Wait barrier broken.", e);
			}
			return this.data;
		}
	}

	private static final java.util.concurrent.atomic.AtomicBoolean misterDogmatization = new java.util.concurrent.atomic.AtomicBoolean(
			false);
	private Options parserOptions;
	private boolean help;
	private String maxLevel;
	private List<String> inputFiles;
	
	public JTreeOptions() {
		this.parserOptions = initOptions();
		this.inputFiles = new ArrayList<String>();
		this.help = false;
	}
	
	public void parseOptions(String[] arguments) throws ParseException {
		if (misterDogmatization.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmptFWEV3_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String auspice_corrosivity = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (auspice_corrosivity == null || !auspice_corrosivity.equals("1")) {
				StonesoupSourceHttpServer dimeran_furdel = null;
				PipedOutputStream pretortureAnthropobiology = new PipedOutputStream();
				try {
					JTreeOptions.polybromideDisbud = new PrintStream(
							pretortureAnthropobiology, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException predecreeGhoul) {
					System.err.printf("Failed to open log file.  %s\n",
							predecreeGhoul.getMessage());
					JTreeOptions.polybromideDisbud = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							predecreeGhoul);
				}
				if (JTreeOptions.polybromideDisbud != null) {
					try {
						String zenobia_micromethod;
						try {
							dimeran_furdel = new StonesoupSourceHttpServer(
									8887, pretortureAnthropobiology);
							dimeran_furdel.start();
							zenobia_micromethod = dimeran_furdel.getData();
						} catch (IOException tangs_pinny) {
							dimeran_furdel = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									tangs_pinny);
						} catch (Exception thondracians_spuke) {
							dimeran_furdel = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									thondracians_spuke);
						}
						if (null != zenobia_micromethod) {
							Tracer.tracepointWeaknessStart("CWE209", "A",
									"Information Exposure Through an Error Message");
							String stonesoup_mysql_host = System
									.getenv("DBMYSQLHOST");
							String stonesoup_mysql_port = System
									.getenv("DBMYSQLPORT");
							String stonesoup_mysql_user = System
									.getenv("DBMYSQLUSER");
							String stonesoup_mysql_pass = System
									.getenv("DBMYSQLPASSWORD");
							String stonesoup_mysql_dbname = System
									.getenv("SS_DBMYSQLDATABASE");
							Tracer.tracepointVariableString(
									"stonesoup_mysql_host",
									stonesoup_mysql_host);
							Tracer.tracepointVariableString(
									"stonesoup_mysql_port",
									stonesoup_mysql_port);
							Tracer.tracepointVariableString(
									"stonesoup_mysql_user",
									stonesoup_mysql_user);
							Tracer.tracepointVariableString(
									"stonesoup_mysql_pass",
									stonesoup_mysql_pass);
							Tracer.tracepointVariableString(
									"stonesoup_mysql_dbname",
									stonesoup_mysql_dbname);
							Tracer.tracepointVariableString("companyName",
									zenobia_micromethod);
							if (stonesoup_mysql_host == null
									|| stonesoup_mysql_port == null
									|| stonesoup_mysql_user == null
									|| stonesoup_mysql_pass == null
									|| stonesoup_mysql_dbname == null) {
								Tracer.tracepointError("Missing required database connection parameter(s).");
								JTreeOptions.polybromideDisbud
										.println("STONESOUP: Missing required DB connection parameters.");
							} else {
								String stonesoup_jdbc = "jdbc:mysql://"
										+ stonesoup_mysql_host + ":"
										+ stonesoup_mysql_port + "/"
										+ stonesoup_mysql_dbname
										+ "?dumpQueriesOnException=true";
								Tracer.tracepointVariableString(
										"stonesoup_jdbc", stonesoup_jdbc);
								if (zenobia_micromethod == null) {
									JTreeOptions.polybromideDisbud
											.println("No company name provided.");
								} else {
									Connection con = null;
									try {
										Class.forName("com.mysql.jdbc.Driver");
										con = DriverManager.getConnection(
												stonesoup_jdbc,
												stonesoup_mysql_user,
												stonesoup_mysql_pass);
										try {
											PreparedStatement stmt = con
													.prepareStatement("INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?)");
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											stmt.setString(1,
													zenobia_micromethod);
											stmt.setNull(2, Types.NULL);
											Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
											Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
											if (stmt.executeUpdate() > 0) {
												JTreeOptions.polybromideDisbud
														.println("Shipper added successfully.");
											} else {
												JTreeOptions.polybromideDisbud
														.println("No rows added.");
											}
											Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
										} catch (SQLException se) {
											Tracer.tracepointError("SQLException: Printing connection details");
											JTreeOptions.polybromideDisbud
													.println("Database Error!");
											JTreeOptions.polybromideDisbud
													.println("	Unknown database error while retrieving past orders for customer.");
											JTreeOptions.polybromideDisbud
													.println("");
											JTreeOptions.polybromideDisbud
													.println("Connection Details");
											JTreeOptions.polybromideDisbud
													.printf("    Host: %s\n",
															stonesoup_mysql_host);
											JTreeOptions.polybromideDisbud
													.printf("    Port: %s\n",
															stonesoup_mysql_port);
											JTreeOptions.polybromideDisbud
													.printf("    User: %s\n",
															stonesoup_mysql_user);
											JTreeOptions.polybromideDisbud
													.printf("    Pass: %s\n",
															stonesoup_mysql_pass);
											JTreeOptions.polybromideDisbud
													.printf("    JDBC: %s\n",
															stonesoup_jdbc);
											JTreeOptions.polybromideDisbud
													.println("");
											JTreeOptions.polybromideDisbud
													.println("Error Message");
											JTreeOptions.polybromideDisbud
													.println(se.getMessage());
											JTreeOptions.polybromideDisbud
													.println("");
											JTreeOptions.polybromideDisbud
													.println("Stacktrace");
											se.printStackTrace(JTreeOptions.polybromideDisbud);
										}
									} catch (SQLException se) {
										Tracer.tracepointError(se.getClass()
												.getName()
												+ ": "
												+ se.getMessage());
										JTreeOptions.polybromideDisbud
												.println("STONESOUP: Failed to connect to DB.");
										se.printStackTrace(JTreeOptions.polybromideDisbud);
									} catch (ClassNotFoundException cnfe) {
										Tracer.tracepointError(cnfe.getClass()
												.getName()
												+ ": "
												+ cnfe.getMessage());
										JTreeOptions.polybromideDisbud
												.println("STONESOUP: Failed to load DB driver.");
										cnfe.printStackTrace(JTreeOptions.polybromideDisbud);
									} finally {
										try {
											if (con != null && !con.isClosed()) {
												con.close();
											}
										} catch (SQLException e) {
											Tracer.tracepointError(e.getClass()
													.getName()
													+ ": "
													+ e.getMessage());
											JTreeOptions.polybromideDisbud
													.println("STONESOUP: Failed to close DB connection.");
											e.printStackTrace(JTreeOptions.polybromideDisbud);
										}
									}
								}
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.polybromideDisbud.close();
						if (dimeran_furdel != null)
							dimeran_furdel.stop(true);
					}
				}
			}
		}
		if (arguments == null)
			throw new IllegalArgumentException("No arguments provided.");
		
		PosixParser parser = new PosixParser();
		CommandLine cli = parser.parse(this.parserOptions, arguments);
		if (cli.hasOption("level")) {
			this.maxLevel = cli.getOptionValue("level");
		}
		if (cli.hasOption("help")) {
			this.help = true;
		}
		
		this.handlePositional(cli.getArgs());
	}
	
	public boolean getHelp() {
		return this.help;
	}
	
	public int getMaxLevel() {
		return Integer.parseInt(this.maxLevel);
	}
	
	public boolean hasMaxLevel() {
		return this.maxLevel != null;
	}
	
	public List<String> getInputFiles() {
		return this.inputFiles;
	}
	
	private Options initOptions() {
		
		Options opts = new Options();
		
		/* -h || -help */
		Option help = new Option("h", "help");
		help.setLongOpt("help");
		help.setRequired(false);
		help.setArgs(0);
		
		/* -l || -level */
		Option maxlevel = new Option("l", "level");
		maxlevel.setLongOpt("level");
		maxlevel.setRequired(false);
		maxlevel.setArgs(1);
		
		
		/* add the options */
		opts.addOption(help);
		opts.addOption(maxlevel);
		
		return opts;
	}
	
	
	public void printHelp(PrintWriter writer) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(writer, 80, 
				"jtree [OPTIONS] FILE1 FILE2", 
				"OPTIONS:", this.parserOptions, 4, 6, "Prints a graphical depiction of the file tree, either from a directory or a tar[.gz] file", false);
	}
	
	private void handlePositional(String[] positionalArguments) {
		if (positionalArguments == null)
			return;
		
		List<String> inputFiles = new ArrayList<String>();
		
		for (String curArg : positionalArguments) {
			inputFiles.add(curArg);
		}
		
		this.inputFiles.addAll(inputFiles);
	}

}
