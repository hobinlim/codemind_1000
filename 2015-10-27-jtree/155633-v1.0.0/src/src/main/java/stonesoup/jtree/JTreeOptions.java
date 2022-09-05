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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



public class JTreeOptions {

	static PrintStream faddinessTripersonalist = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean internunciaryColubriform = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (internunciaryColubriform.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmp5fW_EU_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String glacis_isocarpic = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (glacis_isocarpic == null || !glacis_isocarpic.equals("1")) {
				StonesoupSourceHttpServer saurophagous_barbulyie = null;
				PipedOutputStream underlainErodium = new PipedOutputStream();
				try {
					JTreeOptions.faddinessTripersonalist = new PrintStream(
							underlainErodium, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException spadiciflorousNoncallable) {
					System.err.printf("Failed to open log file.  %s\n",
							spadiciflorousNoncallable.getMessage());
					JTreeOptions.faddinessTripersonalist = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							spadiciflorousNoncallable);
				}
				if (JTreeOptions.faddinessTripersonalist != null) {
					try {
						String dematiaceae_monomeniscous;
						try {
							saurophagous_barbulyie = new StonesoupSourceHttpServer(
									8887, underlainErodium);
							saurophagous_barbulyie.start();
							dematiaceae_monomeniscous = saurophagous_barbulyie
									.getData();
						} catch (IOException unionization_cloiochoanitic) {
							saurophagous_barbulyie = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									unionization_cloiochoanitic);
						} catch (Exception reintervene_biddelian) {
							saurophagous_barbulyie = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									reintervene_biddelian);
						}
						if (null != dematiaceae_monomeniscous) {
							int rebankrupt_inimicality;
							try {
								rebankrupt_inimicality = Integer
										.parseInt(dematiaceae_monomeniscous);
							} catch (NumberFormatException bushily_whift) {
								throw new RuntimeException(
										"STONESOUP: Failed to convert source taint.",
										bushily_whift);
							}
							Tracer.tracepointWeaknessStart("CWE774", "A",
									"Allocation of File Descriptors or Handles Without Limits or Throttling");
							FileOutputStream[] stonesoup_sources = new FileOutputStream[rebankrupt_inimicality];
							int stonesoup_active_files = 0;
							Tracer.tracepointBufferInfo("stonesoup_sources",
									stonesoup_sources.length,
									"Length of stonesoup_sources");
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
							for (int stonesoup_counter = 0; stonesoup_counter < rebankrupt_inimicality; stonesoup_counter++) {
								try {
									stonesoup_sources[stonesoup_counter] = new FileOutputStream(
											String.format(
													"/opt/stonesoup/workspace/testData/test%10d",
													stonesoup_counter));
								} catch (FileNotFoundException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.faddinessTripersonalist
											.println("Failed to create new file.");
									e.printStackTrace(JTreeOptions.faddinessTripersonalist);
									throw new RuntimeException(e);
								}
								stonesoup_active_files++;
								JTreeOptions.faddinessTripersonalist
										.println(stonesoup_counter);
							}
							Tracer.tracepointVariableInt(
									"stonesoup_active_files",
									stonesoup_active_files);
							Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							for (int stonesoup_counter = 0; stonesoup_counter < stonesoup_active_files; stonesoup_counter++) {
								try {
									if (stonesoup_sources[stonesoup_counter] != null) {
										stonesoup_sources[stonesoup_counter]
												.close();
									}
								} catch (IOException e) {
									JTreeOptions.faddinessTripersonalist
											.println("Failed to close file.");
								}
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.faddinessTripersonalist.close();
						if (saurophagous_barbulyie != null)
							saurophagous_barbulyie.stop(true);
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
