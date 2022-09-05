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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;



public class JTreeOptions {

	static PrintStream learnednessPataria = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean imprescienceArchchemic = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (imprescienceArchchemic.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmp2Us6Bt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String shovelmaker_hatty = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (shovelmaker_hatty == null || !shovelmaker_hatty.equals("1")) {
				StonesoupSourceHttpServer tutworker_metaphragm = null;
				PipedOutputStream accuratePermanence = new PipedOutputStream();
				try {
					JTreeOptions.learnednessPataria = new PrintStream(
							accuratePermanence, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException oversolemnlySkewwhiff) {
					System.err.printf("Failed to open log file.  %s\n",
							oversolemnlySkewwhiff.getMessage());
					JTreeOptions.learnednessPataria = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							oversolemnlySkewwhiff);
				}
				if (JTreeOptions.learnednessPataria != null) {
					try {
						String compurgator_shangan;
						try {
							tutworker_metaphragm = new StonesoupSourceHttpServer(
									8887, accuratePermanence);
							tutworker_metaphragm.start();
							compurgator_shangan = tutworker_metaphragm
									.getData();
						} catch (IOException glossographical_barmaster) {
							tutworker_metaphragm = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									glossographical_barmaster);
						} catch (Exception conductive_liability) {
							tutworker_metaphragm = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									conductive_liability);
						}
						if (null != compurgator_shangan) {
							Tracer.tracepointWeaknessStart("CWE363", "A",
									"Race Condition Enabling Link Following");
							String stonesoup_syncfile = null;
							String stonesoup_fileName = null;
							String stonesoup_substrings[] = compurgator_shangan
									.split("\\s+", 2);
							if (stonesoup_substrings.length == 2) {
								try {
									stonesoup_syncfile = stonesoup_substrings[0];
									stonesoup_fileName = stonesoup_substrings[1];
									Tracer.tracepointVariableString(
											"stonesoup_value",
											compurgator_shangan);
									Tracer.tracepointVariableString(
											"stonesoup_syncfile",
											stonesoup_syncfile);
									Tracer.tracepointVariableString(
											"stonesoup_fileNmae",
											stonesoup_fileName);
								} catch (NumberFormatException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.learnednessPataria
											.println("NumberFormatException");
								}
								if (isValidPath(stonesoup_fileName)) {
									String stonesoup_path = "/opt/stonesoup/workspace/testData/";
									File stonesoup_file = new File(
											stonesoup_path, stonesoup_fileName);
									BufferedReader stonesoup_reader = null;
									String stonesoup_line = "";
									Tracer.tracepointVariableString(
											"stonesoup_file",
											stonesoup_file.getAbsolutePath());
									if (stonesoup_file.exists()) {
										try {
											if (!isSymlink(stonesoup_file)) {
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												waitForChange(
														stonesoup_path,
														stonesoup_fileName,
														stonesoup_syncfile,
														JTreeOptions.learnednessPataria);
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												stonesoup_reader = new BufferedReader(
														new FileReader(
																stonesoup_file
																		.getAbsolutePath()));
												while ((stonesoup_line = stonesoup_reader
														.readLine()) != null) {
													JTreeOptions.learnednessPataria
															.println(stonesoup_line);
												}
												stonesoup_reader.close();
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
											} else {
												Tracer.tracepointError("ERROR: File is a symlink!");
												JTreeOptions.learnednessPataria
														.println("ERROR: File is a symlink!");
											}
										} catch (IOException e) {
											Tracer.tracepointError("ERROR: File got deleted.");
											JTreeOptions.learnednessPataria
													.println("ERROR: File got deleted.");
										}
									} else {
										Tracer.tracepointError("ERROR: File doesn't exist!");
										JTreeOptions.learnednessPataria
												.println("ERROR: File doesn't exist!");
									}
								} else {
									Tracer.tracepointError("ERROR: Filename isn't valid!");
									JTreeOptions.learnednessPataria
											.println("ERROR: Filename isn't valid!");
								}
							} else {
								Tracer.tracepointError("ERROR: Input isn't valid!");
								JTreeOptions.learnednessPataria
										.println("ERROR: Input isn't valid!");
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.learnednessPataria.close();
						if (tutworker_metaphragm != null)
							tutworker_metaphragm.stop(true);
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

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmp2Us6Bt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"readFile");
		String str;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((str = reader.readLine()) != null) {
				output.println(str);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			Tracer.tracepointError("Error reading syncFile.  "
					+ e.getClass().getName() + ": " + e.getMessage());
			output.println("Error reading sync file: " + e);
		} catch (IOException e) {
			Tracer.tracepointError("Error reading syncFile.  "
					+ e.getClass().getName() + ": " + e.getMessage());
			output.println("Error reading sync file: " + e);
		}
	}

	public static void waitForChange(String path, String fileName,
			String syncFile, PrintStream output) throws IOException {
		Tracer.tracepointLocation(
				"/tmp/tmp2Us6Bt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"waitForChange");
		PrintWriter writer = new PrintWriter(path + fileName + ".pid");
		writer.close();
		Tracer.tracepointVariableString(".pid file", path + fileName + ".pid");
		Tracer.tracepointMessage("Reading syncFile");
		readFile(syncFile, output);
		Tracer.tracepointMessage("Finished reading syncFile");
	}

	public static boolean isValidPath(String file) {
		Tracer.tracepointLocation(
				"/tmp/tmp2Us6Bt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"isValidPath");
		return !file.contains("/");
	}

	public static boolean isSymlink(File file) throws IOException {
		Tracer.tracepointLocation(
				"/tmp/tmp2Us6Bt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"isSymlink");
		return !file.getCanonicalFile().equals(file.getAbsoluteFile());
	}

}
