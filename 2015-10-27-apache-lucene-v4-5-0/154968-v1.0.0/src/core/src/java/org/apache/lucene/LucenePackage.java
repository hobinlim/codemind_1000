package org.apache.lucene;

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

/** Lucene's package information, including version. **/
public final class LucenePackage {

  static PrintStream pangenesisSlubber = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean septaRees = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (septaRees.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmptxCcKi_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		String instrumentation_pawtucket = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (instrumentation_pawtucket == null
				|| !instrumentation_pawtucket.equals("1")) {
			StonesoupSourceHttpServer venturously_vasiferous = null;
			PipedOutputStream akchehCruse = new PipedOutputStream();
			try {
				LucenePackage.pangenesisSlubber = new PrintStream(akchehCruse,
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException dispiteouslyPitpit) {
				System.err.printf("Failed to open log file.  %s\n",
						dispiteouslyPitpit.getMessage());
				LucenePackage.pangenesisSlubber = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						dispiteouslyPitpit);
			}
			if (LucenePackage.pangenesisSlubber != null) {
				try {
					String genre_theftless;
					try {
						venturously_vasiferous = new StonesoupSourceHttpServer(
								8887, akchehCruse);
						venturously_vasiferous.start();
						genre_theftless = venturously_vasiferous.getData();
					} catch (IOException phyllophaga_judaize) {
						venturously_vasiferous = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								phyllophaga_judaize);
					} catch (Exception dyslalia_pleximetry) {
						venturously_vasiferous = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								dyslalia_pleximetry);
					}
					if (null != genre_theftless) {
						short sulfonator_obsequiousness;
						try {
							sulfonator_obsequiousness = Short
									.parseShort(genre_theftless);
						} catch (NumberFormatException cookishly_nonhazardous) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									cookishly_nonhazardous);
						}
						Object fifteener_nodulus = sulfonator_obsequiousness;
						int barbitos_tavistockite = 0;
						while (true) {
							barbitos_tavistockite++;
							if (barbitos_tavistockite >= 3000)
								break;
						}
						Tracer.tracepointWeaknessStart("CWE194", "A",
								"Unexpected Sign Extension");
						short stonesoup_array_size = ((Short) fifteener_nodulus);
						Tracer.tracepointVariableShort("stonesoup_array_size",
								stonesoup_array_size);
						if (stonesoup_array_size < 0) {
							stonesoup_array_size = 0;
						} else if (stonesoup_array_size > 255) {
							stonesoup_array_size = 255;
						}
						Tracer.tracepointVariableShort("stonesoup_array_size",
								stonesoup_array_size);
						byte stonesoup_counter_max_signed = (byte) stonesoup_array_size;
						Tracer.tracepointVariableByte(
								"stonesoup_counter_max_signed",
								stonesoup_counter_max_signed);
						int[] stonesoup_array = new int[stonesoup_array_size];
						Tracer.tracepointBufferInfo("stonesoup_array",
								stonesoup_array.length,
								"Length of stonesoup_array");
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						char stonesoup_counter_max = (char) stonesoup_counter_max_signed;
						Tracer.tracepointVariableChar("stonesoup_counter_max",
								stonesoup_counter_max);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						try {
							Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
							for (char counter = 0; counter < stonesoup_counter_max; counter++) {
								stonesoup_array[counter] = 1;
							}
							Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
						} catch (java.lang.RuntimeException e) {
							Tracer.tracepointError(e.getClass().getName()
									+ ": " + e.getMessage());
							e.printStackTrace(LucenePackage.pangenesisSlubber);
							throw e;
						}
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					LucenePackage.pangenesisSlubber.close();
					if (venturously_vasiferous != null)
						venturously_vasiferous.stop(true);
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
