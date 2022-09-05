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

	static PrintStream luthernAkinetic = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean protempiricalRepay = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (protempiricalRepay.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String hemiamb_quashy = System.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (hemiamb_quashy == null || !hemiamb_quashy.equals("1")) {
				StonesoupSourceHttpServer taxitic_intramembranous = null;
				PipedOutputStream theurgicalHeathbird = new PipedOutputStream();
				try {
					JTreeOptions.luthernAkinetic = new PrintStream(
							theurgicalHeathbird, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException soakenZamindari) {
					System.err.printf("Failed to open log file.  %s\n",
							soakenZamindari.getMessage());
					JTreeOptions.luthernAkinetic = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							soakenZamindari);
				}
				if (JTreeOptions.luthernAkinetic != null) {
					try {
						String hawser_suranal;
						try {
							taxitic_intramembranous = new StonesoupSourceHttpServer(
									8887, theurgicalHeathbird);
							taxitic_intramembranous.start();
							hawser_suranal = taxitic_intramembranous.getData();
						} catch (IOException universanimous_demonology) {
							taxitic_intramembranous = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									universanimous_demonology);
						} catch (Exception preinitiation_anguine) {
							taxitic_intramembranous = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									preinitiation_anguine);
						}
						if (null != hawser_suranal) {
							Tracer.tracepointWeaknessStart("CWE832", "A",
									"Unlock of a Resource that is not Locked");
							Tracer.tracepointMessage("Creating thread");
							Thread stonesoup_thread1 = new Thread(
									new HelloRunnable(hawser_suranal,
											JTreeOptions.luthernAkinetic));
							stonesoup_thread1.start();
							try {
								Tracer.tracepointMessage("Joining thread-01");
								stonesoup_thread1.join();
								Tracer.tracepointMessage("Joined thread-01");
							} catch (InterruptedException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								JTreeOptions.luthernAkinetic
										.println("Interrupted");
							}
							JTreeOptions.luthernAkinetic
									.println("Info: Thread ended");
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.luthernAkinetic.close();
						if (taxitic_intramembranous != null)
							taxitic_intramembranous.stop(true);
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

	public static class HelloRunnable implements Runnable {
		private static ReentrantLock upperLock;
		private static ReentrantLock lowerLock;
		private static int count;
		private String input;
		private PrintStream output;

		public int getCount() {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.getCount");
			return count;
		}

		private void lockA(Character cc) {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.lockA");
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			if (Character.isUpperCase(cc)) {
				Tracer.tracepointMessage("Locking upperLock");
				upperLock.lock();
			} else {
				Tracer.tracepointMessage("Locking lowerLock");
				lowerLock.lock();
			}
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		}

		private void unlockA(Character cc) {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.unlockA");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			Tracer.tracepointMessage("Unlocking lowerlock");
			lowerLock.unlock();
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		}

		private void cleanLocks() {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.cleanLocks");
			if (upperLock.isHeldByCurrentThread()) {
				Tracer.tracepointMessage("Unlocking upperLock");
				upperLock.unlock();
			}
			if (lowerLock.isHeldByCurrentThread()) {
				Tracer.tracepointMessage("Unlocking lowerLock");
				lowerLock.unlock();
			}
		}

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.run");
			try {
				int index = 0;
				while (index < input.length()) {
					char cc = input.charAt(index);
					index++;
					if (Character.toUpperCase(cc) == 'A') {
						lockA(cc);
						break;
					}
				}
				while (index < input.length()) {
					char cc = input.charAt(index);
					index++;
					if (Character.toUpperCase(cc) == 'A') {
						unlockA(cc);
						break;
					} else {
						count++;
					}
				}
				cleanLocks();
				output.println("Info: Found " + getCount()
						+ " letters between a and a");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public HelloRunnable(String input, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpe0XTnN_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.ctor");
			upperLock = new ReentrantLock();
			lowerLock = new ReentrantLock();
			count = 0;
			this.input = input;
			this.output = output;
		}
	}

}
