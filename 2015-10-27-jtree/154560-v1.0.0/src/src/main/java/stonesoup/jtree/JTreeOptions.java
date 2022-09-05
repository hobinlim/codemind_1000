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
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import javax.xml.bind.DatatypeConverter;



public class JTreeOptions {

	static PrintStream helpmeetVeldschoen = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean setheadDomoid = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (setheadDomoid.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpLTtueW_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			String affronter_totalitarianism = System
					.getenv("STONESOUP_DISABLE_WEAKNESS");
			if (affronter_totalitarianism == null
					|| !affronter_totalitarianism.equals("1")) {
				StonesoupSourceHttpServer mendozite_siphuncle = null;
				PipedOutputStream brabanterOrchiditis = new PipedOutputStream();
				try {
					JTreeOptions.helpmeetVeldschoen = new PrintStream(
							brabanterOrchiditis, true, "ISO-8859-1");
				} catch (UnsupportedEncodingException maimednessChurchwoman) {
					System.err.printf("Failed to open log file.  %s\n",
							maimednessChurchwoman.getMessage());
					JTreeOptions.helpmeetVeldschoen = null;
					throw new RuntimeException(
							"STONESOUP: Failed to create piped print stream.",
							maimednessChurchwoman);
				}
				if (JTreeOptions.helpmeetVeldschoen != null) {
					try {
						String coccygeus_unartistical;
						try {
							mendozite_siphuncle = new StonesoupSourceHttpServer(
									8887, brabanterOrchiditis);
							mendozite_siphuncle.start();
							coccygeus_unartistical = mendozite_siphuncle
									.getData();
						} catch (IOException felicitously_studio) {
							mendozite_siphuncle = null;
							throw new RuntimeException(
									"STONESOUP: Failed to start HTTP server.",
									felicitously_studio);
						} catch (Exception inferno_bovidae) {
							mendozite_siphuncle = null;
							throw new RuntimeException(
									"STONESOUP: Unknown error with HTTP server.",
									inferno_bovidae);
						}
						if (null != coccygeus_unartistical) {
							Tracer.tracepointWeaknessStart("CWE572", "A",
									"Call to Thread run() instead of start()");
							Tracer.tracepointMessage("Creating thread");
							final PrintStream stonesoup_crash_output = JTreeOptions.helpmeetVeldschoen;
							Thread stonesoup_thread1 = new Thread(
									new HelloRunnable(coccygeus_unartistical,
											JTreeOptions.helpmeetVeldschoen));
							stonesoup_thread1
									.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
										@Override
										public void uncaughtException(Thread t,
												Throwable e) {
											Tracer.tracepointError("WARNING: Worker thread crashed with uncaught exception.");
											stonesoup_crash_output
													.println("WARNING: Worker thread crashed with uncaught exception.");
											e.printStackTrace(stonesoup_crash_output);
										}
									});
							try {
								Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
								Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
								stonesoup_thread1.run();
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							} catch (RuntimeException e) {
								Tracer.tracepointError("The thread startup raised an excpetion.  "
										+ e.getClass().getName()
										+ ": "
										+ e.getMessage());
								JTreeOptions.helpmeetVeldschoen
										.println("The thread startup raised an exception.  This should never happen.");
								e.printStackTrace(JTreeOptions.helpmeetVeldschoen);
								throw e;
							}
							try {
								Tracer.tracepointMessage("Joining thread-01");
								stonesoup_thread1.join();
								Tracer.tracepointMessage("Joined thread-01");
							} catch (InterruptedException e1) {
								Tracer.tracepointError(e1.getClass().getName()
										+ ": " + e1.getMessage());
								JTreeOptions.helpmeetVeldschoen
										.println("Failed to join the worker thread.");
								e1.printStackTrace(JTreeOptions.helpmeetVeldschoen);
							} finally {
								JTreeOptions.helpmeetVeldschoen
										.println("Worker thread terminated.");
							}
						}
					} finally {
						JTreeOptions.helpmeetVeldschoen.close();
						if (mendozite_siphuncle != null)
							mendozite_siphuncle.stop(true);
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
		private PrintStream output;
		private String value;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpLTtueW_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.run");
			if (this.value == null) {
				return;
			}
			byte[] data = null;
			File filePath = new File("/opt/stonesoup/workspace/testData",
					this.value);
			BufferedInputStream inputStream = null;
			Tracer.tracepointVariableString("value", value);
			if (filePath.exists() && filePath.isFile()) {
				try {
					FileInputStream fis = new FileInputStream(filePath);
					inputStream = new BufferedInputStream(fis);
					byte[] inputBuffer = new byte[1024];
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int readAmount = 0;
					while ((readAmount = inputStream.read(inputBuffer)) != -1) {
						Tracer.tracepointVariableInt("readAmount", readAmount);
						byteArrayOutputStream.write(inputBuffer, 0, readAmount);
					}
					data = byteArrayOutputStream.toByteArray();
				} catch (java.io.FileNotFoundException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					output.printf("File \"%s\" does not exist\n",
							filePath.getPath());
				} catch (java.io.IOException ioe) {
					Tracer.tracepointError(ioe.getClass().getName() + ": "
							+ ioe.getMessage());
					output.println("Failed to read file.");
				} finally {
					try {
						if (inputStream != null) {
							inputStream.close();
						}
					} catch (java.io.IOException e) {
						output.println("STONESOUP: Closing file quietly.");
					}
				}
			} else {
				output.printf("File \"%s\" does not exist\n",
						filePath.getPath());
			}
			if (data == null || data.length < 4) {
				return;
			}
			ByteBuffer buffer = ByteBuffer.wrap(data);
			int dataLength = buffer.getInt();
			if (dataLength < 0) {
				return;
			} else if (dataLength == 0) {
				Tracer.tracepointError("Received payload with no data.");
				this.output.println("Received payload with no data.");
				return;
			}
			byte[] payload = new byte[dataLength];
			Tracer.tracepointBufferInfo("payload", payload.length,
					"Length of they payload byte array.");
			Tracer.tracepointBufferInfo("buffer.position", buffer.position(),
					"Position in buffer.");
			buffer.get(payload);
			Tracer.tracepointBufferInfo("buffer.position", buffer.position(),
					"Position in buffer.");
			this.output.printf("Payload (Base64): %s\n",
					DatatypeConverter.printBase64Binary(payload));
		}

		public HelloRunnable(String value, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpLTtueW_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.ctor");
			this.value = value;
			this.output = output;
		}
	}

}
