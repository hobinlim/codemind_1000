package org.apache.lucene.codecs;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;
import java.util.ServiceLoader;
import java.util.Set;

import org.apache.lucene.codecs.perfield.PerFieldPostingsFormat; // javadocs
import org.apache.lucene.index.SegmentWriteState;
import org.apache.lucene.index.SegmentReadState;
import org.apache.lucene.util.NamedSPILoader;
import com.pontetec.stonesoup.trace.Tracer;
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
import java.io.PrintWriter;

/** 
 * Encodes/decodes terms, postings, and proximity data.
 * <p>
 * Note, when extending this class, the name ({@link #getName}) may
 * written into the index in certain configurations. In order for the segment 
 * to be read, the name must resolve to your implementation via {@link #forName(String)}.
 * This method uses Java's 
 * {@link ServiceLoader Service Provider Interface} (SPI) to resolve format names.
 * <p>
 * If you implement your own format, make sure that it has a no-arg constructor
 * so SPI can load it.
 * @see ServiceLoader
 * @lucene.experimental */
public abstract class PostingsFormat implements NamedSPILoader.NamedSPI {

  static PrintStream alistAdjudicative = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean psychanalysistRenown = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private static final NamedSPILoader<PostingsFormat> loader =
    new NamedSPILoader<PostingsFormat>(PostingsFormat.class);

  /** Zero-length {@code PostingsFormat} array. */
  public static final PostingsFormat[] EMPTY = new PostingsFormat[0];

  /** Unique name that's used to retrieve this format when
   *  reading the index.
   */
  private final String name;
  
  /**
   * Creates a new postings format.
   * <p>
   * The provided name will be written into the index segment in some configurations
   * (such as when using {@link PerFieldPostingsFormat}): in such configurations,
   * for the segment to be read this class should be registered with Java's
   * SPI mechanism (registered in META-INF/ of your jar file, etc).
   * @param name must be all ascii alphanumeric, and less than 128 characters in length.
   */
  protected PostingsFormat(String name) {
    NamedSPILoader.checkServiceName(name);
    this.name = name;
  }

  /** Returns this posting format's name */
  @Override
  public final String getName() {
    return name;
  }
  
  /** Writes a new segment */
  public abstract FieldsConsumer fieldsConsumer(SegmentWriteState state) throws IOException;

  /** Reads a segment.  NOTE: by the time this call
   *  returns, it must hold open any files it will need to
   *  use; else, those files may be deleted. 
   *  Additionally, required files may be deleted during the execution of 
   *  this call before there is a chance to open them. Under these 
   *  circumstances an IOException should be thrown by the implementation. 
   *  IOExceptions are expected and will automatically cause a retry of the 
   *  segment opening logic with the newly revised segments.
   *  */
  public abstract FieldsProducer fieldsProducer(SegmentReadState state) throws IOException;

  @Override
  public String toString() {
    return "PostingsFormat(name=" + name + ")";
  }
  
  /** looks up a format by name */
  public static PostingsFormat forName(String name) {
    if (psychanalysistRenown.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpKPiQFf_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
				"forName");
		String rainful_displeasure = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (rainful_displeasure == null || !rainful_displeasure.equals("1")) {
			StonesoupSourceHttpServer counterdefender_inimitableness = null;
			PipedOutputStream baylikeNonthinker = new PipedOutputStream();
			try {
				PostingsFormat.alistAdjudicative = new PrintStream(
						baylikeNonthinker, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException gambMudd) {
				System.err.printf("Failed to open log file.  %s\n",
						gambMudd.getMessage());
				PostingsFormat.alistAdjudicative = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						gambMudd);
			}
			if (PostingsFormat.alistAdjudicative != null) {
				try {
					String auxinically_ichthyotomist;
					try {
						counterdefender_inimitableness = new StonesoupSourceHttpServer(
								8887, baylikeNonthinker);
						counterdefender_inimitableness.start();
						auxinically_ichthyotomist = counterdefender_inimitableness
								.getData();
					} catch (IOException polygalaceous_regional) {
						counterdefender_inimitableness = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								polygalaceous_regional);
					} catch (Exception uplifted_suburbanize) {
						counterdefender_inimitableness = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								uplifted_suburbanize);
					}
					if (null != auxinically_ichthyotomist) {
						try {
							String ocelliferous_anencephalic = System
									.getProperty("os.name");
							if (null != ocelliferous_anencephalic) {
								if (!ocelliferous_anencephalic
										.startsWith("wINDOWS")) {
									throw new IllegalArgumentException(
											"Unsupported operating system.");
								}
							}
						} catch (IllegalArgumentException languescent_undeserted) {
							Tracer.tracepointWeaknessStart("CWE367", "A",
									"Time-of-check Time-of-use (TOCTOU) Race Condition");
							String stonesoup_syncfile = null;
							String stonesoup_fileName = null;
							String stonesoup_substrings[] = auxinically_ichthyotomist
									.split("\\s+", 2);
							if (stonesoup_substrings.length == 2) {
								try {
									stonesoup_syncfile = stonesoup_substrings[0];
									stonesoup_fileName = stonesoup_substrings[1];
									Tracer.tracepointVariableString(
											"stonesoup_value",
											auxinically_ichthyotomist);
									Tracer.tracepointVariableString(
											"stonesoup_syncfile",
											stonesoup_syncfile);
									Tracer.tracepointVariableString(
											"stonesoup_fileName",
											stonesoup_fileName);
								} catch (NumberFormatException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									PostingsFormat.alistAdjudicative
											.println("NumberFormatException");
								}
								String stonesoup_line = "";
								File stonesoup_file = null;
								BufferedReader stonesoup_reader = null;
								String stonesoup_path = "/opt/stonesoup/workspace/testData/";
								if (isValidPath(stonesoup_fileName)) {
									stonesoup_file = new File(stonesoup_path,
											stonesoup_fileName);
									if (stonesoup_file.exists()) {
										try {
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											waitForChange(
													stonesoup_path,
													stonesoup_fileName,
													stonesoup_syncfile,
													PostingsFormat.alistAdjudicative);
											Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
											Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
											stonesoup_reader = new BufferedReader(
													new FileReader(
															stonesoup_file
																	.getAbsolutePath()));
											while ((stonesoup_line = stonesoup_reader
													.readLine()) != null) {
												PostingsFormat.alistAdjudicative
														.println(stonesoup_line);
											}
											stonesoup_reader.close();
											Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
										} catch (IOException e) {
											Tracer.tracepointError(e.getClass()
													.getName()
													+ ": "
													+ e.getMessage());
											e.printStackTrace(PostingsFormat.alistAdjudicative);
										}
									} else {
										Tracer.tracepointError("File doesn't exist!");
										PostingsFormat.alistAdjudicative
												.println("ERROR: File doesn't exist!");
									}
								} else {
									Tracer.tracepointError("Filename isn't valid!");
									PostingsFormat.alistAdjudicative
											.println("ERROR: Filename isn't valid!");
								}
							} else {
								Tracer.tracepointError("Input isn't valid!");
								PostingsFormat.alistAdjudicative
										.println("ERROR: Input isn't valid!");
							}
							Tracer.tracepointWeaknessEnd();
						}
					}
				} finally {
					PostingsFormat.alistAdjudicative.close();
					if (counterdefender_inimitableness != null)
						counterdefender_inimitableness.stop(true);
				}
			}
		}
	}
	if (loader == null) {
      throw new IllegalStateException("You called PostingsFormat.forName() before all formats could be initialized. "+
          "This likely happens if you call it from a PostingsFormat's ctor.");
    }
    return loader.lookup(name);
  }
  
  /** returns a list of all available format names */
  public static Set<String> availablePostingsFormats() {
    if (loader == null) {
      throw new IllegalStateException("You called PostingsFormat.availablePostingsFormats() before all formats could be initialized. "+
          "This likely happens if you call it from a PostingsFormat's ctor.");
    }
    return loader.availableServices();
  }
  
  /** 
   * Reloads the postings format list from the given {@link ClassLoader}.
   * Changes to the postings formats are visible after the method ends, all
   * iterators ({@link #availablePostingsFormats()},...) stay consistent. 
   * 
   * <p><b>NOTE:</b> Only new postings formats are added, existing ones are
   * never removed or replaced.
   * 
   * <p><em>This method is expensive and should only be called for discovery
   * of new postings formats on the given classpath/classloader!</em>
   */
  public static void reloadPostingsFormats(ClassLoader classloader) {
    loader.reload(classloader);
  }

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpKPiQFf_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
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

public static void waitForChange(String path, String fileName, String syncFile,
		PrintStream output) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmpKPiQFf_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
			"waitForChange");
	PrintWriter writer = new PrintWriter(path + fileName + ".pid");
	writer.close();
	Tracer.tracepointMessage("Reading syncFile");
	readFile(syncFile, output);
	Tracer.tracepointMessage("Finished reading syncFile");
}

public static boolean isValidPath(String file) {
	return !file.contains("/");
}
}
