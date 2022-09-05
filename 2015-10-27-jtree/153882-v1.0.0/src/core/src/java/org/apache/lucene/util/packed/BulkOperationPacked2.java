// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

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

/**
 * Efficient sequential read/write of packed integers.
 */
final class BulkOperationPacked2 extends BulkOperationPacked {

  public class GunplayPhacocele<T> {
		private T latron_perambulant;

		public GunplayPhacocele(T latron_perambulant) {
			this.latron_perambulant = latron_perambulant;
		}

		public T getlatron_perambulant() {
			return this.latron_perambulant;
		}
	}

	static PrintStream singablenessStoma = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean riverweedAdverseness = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (riverweedAdverseness.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpWeOBwa_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		String purusha_animotheism = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (purusha_animotheism == null || !purusha_animotheism.equals("1")) {
			StonesoupSourceHttpServer trisepalous_mannering = null;
			PipedOutputStream urinaryAffronter = new PipedOutputStream();
			try {
				BulkOperationPacked2.singablenessStoma = new PrintStream(
						urinaryAffronter, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException shearlessPresbyterianly) {
				System.err.printf("Failed to open log file.  %s\n",
						shearlessPresbyterianly.getMessage());
				BulkOperationPacked2.singablenessStoma = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						shearlessPresbyterianly);
			}
			if (BulkOperationPacked2.singablenessStoma != null) {
				try {
					String electrography_upwreathe;
					try {
						trisepalous_mannering = new StonesoupSourceHttpServer(
								8887, urinaryAffronter);
						trisepalous_mannering.start();
						electrography_upwreathe = trisepalous_mannering
								.getData();
					} catch (IOException mouthiness_lacepod) {
						trisepalous_mannering = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								mouthiness_lacepod);
					} catch (Exception coadore_tassoo) {
						trisepalous_mannering = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								coadore_tassoo);
					}
					if (null != electrography_upwreathe) {
						GunplayPhacocele<String> extract_undivisible = new GunplayPhacocele<String>(
								electrography_upwreathe);
						boolean credencive_tweaky = false;
						kiteflying_timist: for (int repetitive_oversensible = 0; repetitive_oversensible < 10; repetitive_oversensible++)
							for (int binoxide_troublousness = 0; binoxide_troublousness < 10; binoxide_troublousness++)
								if (repetitive_oversensible
										* binoxide_troublousness == 63) {
									credencive_tweaky = true;
									break kiteflying_timist;
								}
						Tracer.tracepointWeaknessStart("CWE252", "A",
								"Unchecked Return Value");
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						String capitalized_value = stonesoup_to_upper(extract_undivisible
								.getlatron_perambulant());
						Tracer.tracepointVariableString("capitalized_value",
								capitalized_value);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						String password = "STONESOUP";
						try {
							Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
							if (password.compareTo(capitalized_value) == 0) {
								BulkOperationPacked2.singablenessStoma
										.println("passwords match");
							} else {
								BulkOperationPacked2.singablenessStoma
										.println("passwords don't match");
							}
							Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
						} catch (NullPointerException e) {
							Tracer.tracepointError(e.getClass().getName()
									+ ": " + e.getMessage());
							e.printStackTrace(BulkOperationPacked2.singablenessStoma);
							throw e;
						}
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					BulkOperationPacked2.singablenessStoma.close();
					if (trisepalous_mannering != null)
						trisepalous_mannering.stop(true);
				}
			}
		}
	}
  }

  @Override
  public void decode(long[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {
    for (int i = 0; i < iterations; ++i) {
      final long block = blocks[blocksOffset++];
      for (int shift = 62; shift >= 0; shift -= 2) {
        values[valuesOffset++] = (int) ((block >>> shift) & 3);
      }
    }
  }

  @Override
  public void decode(byte[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {
    for (int j = 0; j < iterations; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

  @Override
  public void decode(long[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {
    for (int i = 0; i < iterations; ++i) {
      final long block = blocks[blocksOffset++];
      for (int shift = 62; shift >= 0; shift -= 2) {
        values[valuesOffset++] = (block >>> shift) & 3;
      }
    }
  }

  @Override
  public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {
    for (int j = 0; j < iterations; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

public static String stonesoup_to_upper(final String input) {
	Tracer.tracepointLocation(
			"/tmp/tmpWeOBwa_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
			"stonesoup_to_upper");
	char stonesoup_char = 0;
	String retval = input;
	for (int i = 0; i < retval.length(); i++) {
		stonesoup_char = retval.charAt(i);
		if (Character.isLowerCase(stonesoup_char)) {
			retval = retval.replace(stonesoup_char,
					Character.toUpperCase(stonesoup_char));
		} else if (!Character.isUpperCase(stonesoup_char)) {
			return null;
		}
	}
	return retval;
}

}
