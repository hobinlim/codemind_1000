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

  static PrintStream forescriptPolybromide = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean risoriusLienor = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (risoriusLienor.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpr_aSJR_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		String bearishness_monstrousness = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (bearishness_monstrousness == null
				|| !bearishness_monstrousness.equals("1")) {
			StonesoupSourceHttpServer untirability_messily = null;
			PipedOutputStream suckerlikePrethoughtfully = new PipedOutputStream();
			try {
				BulkOperationPacked2.forescriptPolybromide = new PrintStream(
						suckerlikePrethoughtfully, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException unapostrophizedPillarlet) {
				System.err.printf("Failed to open log file.  %s\n",
						unapostrophizedPillarlet.getMessage());
				BulkOperationPacked2.forescriptPolybromide = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						unapostrophizedPillarlet);
			}
			if (BulkOperationPacked2.forescriptPolybromide != null) {
				try {
					final String ghostly_ectozoon;
					try {
						untirability_messily = new StonesoupSourceHttpServer(
								8887, suckerlikePrethoughtfully);
						untirability_messily.start();
						ghostly_ectozoon = untirability_messily.getData();
					} catch (IOException adminiculary_autospore) {
						untirability_messily = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								adminiculary_autospore);
					} catch (Exception unfully_oxalic) {
						untirability_messily = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								unfully_oxalic);
					}
					if (null != ghostly_ectozoon) {
						final short evilspeaker_sprunny;
						try {
							evilspeaker_sprunny = Short
									.parseShort(ghostly_ectozoon);
						} catch (NumberFormatException subaudible_myringoplasty) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									subaudible_myringoplasty);
						}
						int replicate_buckishly = 0;
						while (true) {
							replicate_buckishly++;
							if (replicate_buckishly >= 3000)
								break;
						}
						Tracer.tracepointWeaknessStart("CWE194", "A",
								"Unexpected Sign Extension");
						short stonesoup_array_size = evilspeaker_sprunny;
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
							e.printStackTrace(BulkOperationPacked2.forescriptPolybromide);
							throw e;
						}
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					BulkOperationPacked2.forescriptPolybromide.close();
					if (untirability_messily != null)
						untirability_messily.stop(true);
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

}
