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
import java.util.concurrent.locks.ReentrantLock;



public class JTreeOptions {

	static PrintStream sasteanSubsimilation = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean emblematicizeDemidolmen = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (emblematicizeDemidolmen.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpDras80_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String diallagite_gladiolus = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (diallagite_gladiolus == null
					|| !diallagite_gladiolus.equals("1")) {
				StonesoupSourceHttpServer nonsulphurous_unburden = null;
				PipedOutputStream imposerConvictable = new PipedOutputStream();
				try {
					JTreeOptions.sasteanSubsimilation = new PrintStream(
							imposerConvictable, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException shoopCommassee) {
					System.err.printf("Failed to open log file.  %s\n",
							shoopCommassee.getMessage());
					JTreeOptions.sasteanSubsimilation = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							shoopCommassee);
				}
				if (JTreeOptions.sasteanSubsimilation != null) {
					try {
						String antirabic_ichthyosaurian;
						try {
							nonsulphurous_unburden = new StonesoupSourceHttpServer(
									8887, imposerConvictable);
							nonsulphurous_unburden.start();
							antirabic_ichthyosaurian = nonsulphurous_unburden
									.getData();
						} catch (IOException appendiculated_trichorrhexic) {
							nonsulphurous_unburden = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									appendiculated_trichorrhexic);
						} catch (Exception gauteite_usneoid) {
							nonsulphurous_unburden = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									gauteite_usneoid);
						}
						if (null != antirabic_ichthyosaurian) {
							Tracer.tracepointWeaknessStart("CWE833", "A",
									"Deadlock");
							Tracer.tracepointVariableString("stonesoup_value",
									antirabic_ichthyosaurian);
							boolean stonesoup_upper = firstIsUpper(antirabic_ichthyosaurian);
							ReentrantLock stonesoup_lock = null;
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							if (stonesoup_upper) {
								Tracer.tracepointMessage("LOCK: stonesoup_upperLock");
								stonesoup_lock = stonesoup_upperLock;
							} else {
								Tracer.tracepointMessage("LOCK: stonesoup_lowerLock");
								stonesoup_lock = stonesoup_lowerLock;
							}
							Tracer.tracepointMessage("Locking lock");
							stonesoup_lock.lock();
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							try {
								Tracer.tracepointMessage("Creating thread");
								Thread stonesoup_thread1 = new Thread(
										new CountUpper(
												antirabic_ichthyosaurian,
												JTreeOptions.sasteanSubsimilation));
								stonesoup_thread1.start();
								for (int ii = 0; ii < antirabic_ichthyosaurian
										.length(); ii++) {
									if (stonesoup_upper
											&& Character
													.isUpperCase(antirabic_ichthyosaurian
															.charAt(ii))) {
										stonesoup_upperInt += 1;
									} else if (!stonesoup_upper
											&& !Character
													.isUpperCase(antirabic_ichthyosaurian
															.charAt(ii))) {
										stonesoup_lowerInt += 1;
									}
								}
								try {
									Tracer.tracepointMessage("Joining thread-01");
									stonesoup_thread1.join();
									Tracer.tracepointMessage("Joined thread-01");
								} catch (InterruptedException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.sasteanSubsimilation
											.println("Interrupted");
								}
							} finally {
								Tracer.tracepointMessage("Unlocking lock");
								stonesoup_lock.unlock();
							}
							JTreeOptions.sasteanSubsimilation
									.println("finished evaluating");
							JTreeOptions.sasteanSubsimilation
									.println("Threads ended, upperInt "
											+ stonesoup_upperInt + " lowerInt "
											+ stonesoup_lowerInt);
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.sasteanSubsimilation.close();
						if (nonsulphurous_unburden != null)
							nonsulphurous_unburden.stop(true);
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

	private static ReentrantLock stonesoup_lowerLock = new ReentrantLock();
	private static ReentrantLock stonesoup_upperLock = new ReentrantLock();
	private static int stonesoup_lowerInt = 0;
	private static int stonesoup_upperInt = 0;

	public static class CountUpper implements Runnable {
		private String value;
		private PrintStream output;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpDras80_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"CountUpper.run");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			Tracer.tracepointMessage("Locking lock");
			stonesoup_upperLock.lock();
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			try {
				for (int ii = 0; ii < value.length(); ii++) {
					if (Character.isUpperCase(value.charAt(ii))) {
						stonesoup_upperInt += 1;
					}
				}
			} finally {
				Tracer.tracepointMessage("Unlocking lock");
				stonesoup_upperLock.unlock();
			}
			output.println("Info: Thread ending, upperInt "
					+ stonesoup_upperInt);
		}

		public CountUpper(String value, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpDras80_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"CountUpper.ctor");
			this.value = value;
			this.output = output;
		}
	}

	private static boolean firstIsUpper(String value) {
		Tracer.tracepointLocation(
				"/tmp/tmpDras80_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"firstIsUpper");
		return (Character.isUpperCase(value.charAt(0)));
	}

}
