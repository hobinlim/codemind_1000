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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;



public class JTreeOptions {

	static PrintStream exscutellateOrchestre = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean secundiparityOutboard = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (secundiparityOutboard.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpzlaNyw_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String semistock_debris = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (semistock_debris == null || !semistock_debris.equals("1")) {
				StonesoupSourceHttpServer titularly_unscrewable = null;
				PipedOutputStream geranomorphaeToona = new PipedOutputStream();
				try {
					JTreeOptions.exscutellateOrchestre = new PrintStream(
							geranomorphaeToona, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException interlinguisticUnmanly) {
					System.err.printf("Failed to open log file.  %s\n",
							interlinguisticUnmanly.getMessage());
					JTreeOptions.exscutellateOrchestre = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							interlinguisticUnmanly);
				}
				if (JTreeOptions.exscutellateOrchestre != null) {
					try {
						String uncloudy_panterer;
						try {
							titularly_unscrewable = new StonesoupSourceHttpServer(
									8887, geranomorphaeToona);
							titularly_unscrewable.start();
							uncloudy_panterer = titularly_unscrewable.getData();
						} catch (IOException paludicoline_zigzag) {
							titularly_unscrewable = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									paludicoline_zigzag);
						} catch (Exception trihydroxy_tubage) {
							titularly_unscrewable = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									trihydroxy_tubage);
						}
						if (null != uncloudy_panterer) {
							Tracer.tracepointWeaknessStart("CWE663", "A",
									"Use of a Non-reentrant Function in a Concurrent Context");
							String stonesoup_substrings[] = uncloudy_panterer
									.split("\\s", 2);
							int stonesoup_qsize = 0;
							if (stonesoup_substrings.length == 2) {
								try {
									stonesoup_qsize = Integer
											.parseInt(stonesoup_substrings[0]);
								} catch (NumberFormatException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.exscutellateOrchestre
											.println("NumberFormatException");
								}
								Tracer.tracepointVariableString(
										"stonesoup_value", uncloudy_panterer);
								Tracer.tracepointVariableInt("stonesoup_qsize",
										stonesoup_qsize);
								Tracer.tracepointVariableString(
										"stonesoup_threadInput",
										stonesoup_substrings[1]);
								if (stonesoup_qsize < 0) {
									stonesoup_qsize = 0;
									JTreeOptions.exscutellateOrchestre
											.println("Qsize should be >=0, setting it to 0.");
								}
								Tracer.tracepointVariableInt("stonesoup_qsize",
										stonesoup_qsize);
								Tracer.tracepointMessage("Creating threads");
								Thread stonesoup_thread1 = new Thread(
										new replaceSymbols(
												stonesoup_qsize,
												JTreeOptions.exscutellateOrchestre));
								Thread stonesoup_thread2 = new Thread(
										new toCaps(
												stonesoup_qsize,
												JTreeOptions.exscutellateOrchestre));
								stonesoup_threadInput = new StringBuilder()
										.append(stonesoup_substrings[1]);
								Tracer.tracepointMessage("Spawning threads.");
								JTreeOptions.exscutellateOrchestre
										.println("Info: Spawning thread 1.");
								stonesoup_thread1.start();
								JTreeOptions.exscutellateOrchestre
										.println("Info: Spawning thread 2.");
								stonesoup_thread2.start();
								try {
									Tracer.tracepointMessage("Joining threads");
									Tracer.tracepointMessage("Joining thread-01");
									stonesoup_thread1.join();
									Tracer.tracepointMessage("Joined thread-01");
									Tracer.tracepointMessage("Joining thread-02");
									stonesoup_thread2.join();
									Tracer.tracepointMessage("Joined thread-02");
									Tracer.tracepointMessage("Joined threads");
								} catch (InterruptedException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.exscutellateOrchestre
											.println("Interrupted");
								}
								JTreeOptions.exscutellateOrchestre
										.println("Info: Threads ended");
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.exscutellateOrchestre.close();
						if (titularly_unscrewable != null)
							titularly_unscrewable.stop(true);
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

	private static ReentrantLock lock = new ReentrantLock();
	private static StringBuilder stonesoup_threadInput;
	static volatile int j;

	public static void arrFunc(int size, String tempfile, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpzlaNyw_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"arrFunc");
		int[] sortMe = new int[size];
		j = 0;
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		for (int i = 0; i < stonesoup_threadInput.length(); i++, j++) {
			stonesoup_threadInput.setCharAt(j, '\0');
			output.format("TID: %d I: %d J: %d\n", Thread.currentThread()
					.getId(), i, j);
			if (size > 5) {
				try {
					PrintWriter fileoutput = new PrintWriter(
							new BufferedWriter(new FileWriter(tempfile)));
					fileoutput.println("Iteration: " + i);
					fileoutput.close();
				} catch (IOException e) {
					Tracer.tracepointError("IOException");
				}
				for (int k = 0; k < size; k++) {
					sortMe[k] = size - k;
				}
				Arrays.sort(sortMe);
			}
		}
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	}

	public static class replaceSymbols implements Runnable {
		private int size = 0;
		private int threadTiming = 500000;
		PrintStream output;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpzlaNyw_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"replaceSymbols.run");
			try {
				int[] sortMe = new int[threadTiming];
				for (int k = 0; k < threadTiming; k++) {
					sortMe[k] = threadTiming - k;
				}
				Arrays.sort(sortMe);
				Tracer.tracepointMessage("replaceSymbols: after qsort");
				lock.lock();
				char val;
				for (int i = 0; i < stonesoup_threadInput.length(); i++) {
					val = stonesoup_threadInput.charAt(i);
					if (((val >= '!' && val <= '/')
							|| (val >= ':' && val <= '@')
							|| (val >= '[' && val <= '`') || (val >= '{' && val <= '~'))
							&& (val != '@' && val != '.')) {
						stonesoup_threadInput.setCharAt(i, '_');
					}
				}
				lock.unlock();
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE (1)");
				arrFunc(size, "/opt/stonesoup/workspace/testData/replace.txt",
						output);
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER (1)");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public replaceSymbols(int size, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpzlaNyw_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"replaceSymbols.ctor");
			this.size = size;
			this.output = output;
		}
	}

	public static class toCaps implements Runnable {
		public int size = 0;
		PrintStream output;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpzlaNyw_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"toCaps.run");
			try {
				lock.lock();
				for (int i = 0; i < stonesoup_threadInput.length(); i++) {
					if (stonesoup_threadInput.charAt(i) >= 'a'
							|| stonesoup_threadInput.charAt(i) <= 'z') {
						stonesoup_threadInput
								.setCharAt(
										i,
										(char) (stonesoup_threadInput.charAt(i) - ('a' - 'A')));
					}
				}
				lock.unlock();
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE (2)");
				arrFunc(size, "/opt/stonesoup/workspace/testData/toCaps.txt",
						output);
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER (2)");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public toCaps(int size, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpzlaNyw_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"toCaps.ctor");
			this.size = size;
			this.output = output;
		}
	}

}
