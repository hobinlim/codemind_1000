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
import java.util.Arrays;



public class JTreeOptions {

	static PrintStream indefectiblyHexahydrated = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean semipedOliviform = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (semipedOliviform.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String porchlike_abominator = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (porchlike_abominator == null
					|| !porchlike_abominator.equals("1")) {
				StonesoupSourceHttpServer ascosporous_phrenopathic = null;
				PipedOutputStream unannihilableAlloeosis = new PipedOutputStream();
				try {
					JTreeOptions.indefectiblyHexahydrated = new PrintStream(
							unannihilableAlloeosis, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException stapeliaNassau) {
					System.err.printf("Failed to open log file.  %s\n",
							stapeliaNassau.getMessage());
					JTreeOptions.indefectiblyHexahydrated = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							stapeliaNassau);
				}
				if (JTreeOptions.indefectiblyHexahydrated != null) {
					try {
						String polypary_mestiza;
						try {
							ascosporous_phrenopathic = new StonesoupSourceHttpServer(
									8887, unannihilableAlloeosis);
							ascosporous_phrenopathic.start();
							polypary_mestiza = ascosporous_phrenopathic
									.getData();
						} catch (IOException cysticercus_pentstock) {
							ascosporous_phrenopathic = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									cysticercus_pentstock);
						} catch (Exception ingluviitis_strongylosis) {
							ascosporous_phrenopathic = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									ingluviitis_strongylosis);
						}
						if (null != polypary_mestiza) {
							Tracer.tracepointWeaknessStart("CWE820", "A",
									"Missing Synchronization");
							int stonesoup_qsize = 0;
							String stonesoup_taint = null;
							String stonesoup_file1 = null;
							String stonesoup_file2 = null;
							String stonesoup_substrings[] = polypary_mestiza
									.split("\\s+", 4);
							if (stonesoup_substrings.length == 4) {
								try {
									stonesoup_qsize = Integer
											.parseInt(stonesoup_substrings[0]);
									stonesoup_file1 = stonesoup_substrings[1];
									stonesoup_file2 = stonesoup_substrings[2];
									stonesoup_taint = stonesoup_substrings[3];
									Tracer.tracepointVariableString(
											"stonesoup_value", polypary_mestiza);
									Tracer.tracepointVariableInt(
											"stonesoup_qsize", stonesoup_qsize);
									Tracer.tracepointVariableString(
											"stonesoup_file1", stonesoup_file1);
									Tracer.tracepointVariableString(
											"stonesoup_file2", stonesoup_file2);
									Tracer.tracepointVariableString(
											"stonesoup_taint", stonesoup_taint);
								} catch (NumberFormatException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.indefectiblyHexahydrated
											.println("NumberFormatException");
								}
								if (stonesoup_qsize < 0) {
									JTreeOptions.indefectiblyHexahydrated
											.println("Error: use positive numbers.");
								} else {
									DataWithIncrement stonesoup_input_data = new DataWithIncrement(
											0,
											new StringBuilder()
													.append(stonesoup_taint));
									Tracer.tracepointMessage("Creating threads");
									Thread stonesoup_thread1 = new Thread(
											new CalculateIncrementAmount(
													stonesoup_input_data,
													stonesoup_file2,
													JTreeOptions.indefectiblyHexahydrated));
									Thread stonesoupthread2 = new Thread(
											new ConvertToPound(
													stonesoup_qsize,
													stonesoup_input_data,
													stonesoup_file1,
													JTreeOptions.indefectiblyHexahydrated));
									JTreeOptions.indefectiblyHexahydrated
											.println("Info: Spawning thread 1.");
									stonesoup_thread1.start();
									JTreeOptions.indefectiblyHexahydrated
											.println("Info: Spawning thread 2.");
									stonesoupthread2.start();
									try {
										Tracer.tracepointMessage("Joining threads");
										Tracer.tracepointMessage("Joining thread-01");
										stonesoup_thread1.join();
										Tracer.tracepointMessage("Joined thread-01");
										Tracer.tracepointMessage("Joining thread-02");
										stonesoupthread2.join();
										Tracer.tracepointMessage("Joined thread-02");
										Tracer.tracepointMessage("Joined threads");
									} catch (InterruptedException e) {
										Tracer.tracepointError(e.getClass()
												.getName()
												+ ": "
												+ e.getMessage());
										JTreeOptions.indefectiblyHexahydrated
												.println("Interrupted");
									}
									JTreeOptions.indefectiblyHexahydrated
											.println("Info: Threads ended");
									Tracer.tracepointWeaknessEnd();
								}
							}
						}
					} finally {
						JTreeOptions.indefectiblyHexahydrated.close();
						if (ascosporous_phrenopathic != null)
							ascosporous_phrenopathic.stop(true);
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
				"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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

	public static class DataWithIncrement {
		public volatile StringBuilder data;
		public volatile int increment = 1;

		public DataWithIncrement(int increment, StringBuilder data) {
			Tracer.tracepointLocation(
					"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"DataWithIncrement.ctor");
			this.increment = increment;
			this.data = data;
		}
	}

	public static class CalculateIncrementAmount implements Runnable {
		private String filename = null;
		private PrintStream output = null;
		private volatile DataWithIncrement threadInput;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"CalculateIncrementAmount.run");
			try {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				threadInput.increment = threadInput.data.charAt(0) - 'A';
				Tracer.tracepointVariableInt("threadInput.increment",
						threadInput.increment);
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				readFile(filename, output);
				if (this.threadInput.increment < 0) {
					this.threadInput.increment *= -1;
				} else if (this.threadInput.increment == 0) {
					this.threadInput.increment += 1;
				}
				Tracer.tracepointVariableInt("threadInput.increment",
						threadInput.increment);
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public CalculateIncrementAmount(DataWithIncrement input,
				String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"CalculateIncrementAmount.ctor");
			this.threadInput = input;
			this.filename = filename;
			this.output = output;
		}
	}

	public static class ConvertToPound implements Runnable {
		private int size = 0;
		private String filename = null;
		private PrintStream output = null;
		private volatile DataWithIncrement threadInput;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"ConvertToPound.run");
			int[] sortMe = new int[size];
			try {
				for (int i = 0; i < this.size; i++) {
					sortMe[i] = this.size - i;
				}
				Arrays.sort(sortMe);
				readFile(filename, output);
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				Tracer.tracepointVariableInt("threadInput.increment",
						threadInput.increment);
				for (int i = 0; i < this.threadInput.data.length(); i += this.threadInput.increment) {
					this.threadInput.data.setCharAt(i, '#');
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public ConvertToPound(int size, DataWithIncrement input,
				String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpvYymsu_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"ConvertToPound.ctor");
			this.size = size;
			this.threadInput = input;
			this.filename = filename;
			this.output = output;
		}
	}

}
