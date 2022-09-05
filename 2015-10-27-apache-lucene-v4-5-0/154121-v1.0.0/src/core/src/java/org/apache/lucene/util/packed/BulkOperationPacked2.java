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

  static PrintStream terraqueanSpotless = null;

	public void pteropodaOvergenerously(int untreed_michabo,
			String[] tribeless_semiprostrate) {
		untreed_michabo--;
		if (untreed_michabo > 0) {
			formylateExercitant(untreed_michabo, tribeless_semiprostrate);
		}
	}

	public void formylateExercitant(int rhagonate_conjunctural,
			String[] tribeless_semiprostrate) {
		pteropodaOvergenerously(rhagonate_conjunctural, tribeless_semiprostrate);
		Tracer.tracepointWeaknessStart("CWE252", "B", "Unchecked Return");
		try {
			final int STONESOUP_BUFFER_SIZE = 2048;
			String stonesoup_sensitiveFName = tribeless_semiprostrate[12];
			String stonesoup_otherFName = System.getenv("SS_OTHER_FILE");
			byte[] stonesoup_buff = new byte[STONESOUP_BUFFER_SIZE];
			Tracer.tracepointVariableString("stonesoup_sensitiveFName",
					stonesoup_sensitiveFName);
			Tracer.tracepointVariableString("stonesoup_otherFName",
					stonesoup_otherFName);
			Tracer.tracepointBufferInfo("stonesoup_buff",
					stonesoup_buff.length, "Length of stonesoup_buff");
			java.io.InputStream stonesoup_sensitiveFile = new java.io.FileInputStream(
					stonesoup_sensitiveFName);
			java.io.InputStream stonesoup_otherFile = new java.io.FileInputStream(
					stonesoup_otherFName);
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			stonesoup_sensitiveFile.read(stonesoup_buff);
			stonesoup_sensitiveFile.close();
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			stonesoup_otherFile.read(stonesoup_buff);
			stonesoup_otherFile.close();
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			String output_data = new String(stonesoup_buff);
			Tracer.tracepointVariableString("output_data", output_data);
			BulkOperationPacked2.terraqueanSpotless.println("Output is:\n"
					+ output_data);
		} catch (java.io.IOException ioe) {
			Tracer.tracepointError(ioe.getClass().getName() + ": "
					+ ioe.getMessage());
			BulkOperationPacked2.terraqueanSpotless
					.println("STONESOUP: Error accessing files");
			ioe.printStackTrace(BulkOperationPacked2.terraqueanSpotless);
		}
		Tracer.tracepointWeaknessEnd();
	}

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

	private static final java.util.concurrent.atomic.AtomicBoolean peiserSenselessness = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (peiserSenselessness.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp6uc63W_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		String calamopitys_depreciator = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (calamopitys_depreciator == null
				|| !calamopitys_depreciator.equals("1")) {
			StonesoupSourceHttpServer proofless_ingenue = null;
			PipedOutputStream nourishableGalei = new PipedOutputStream();
			try {
				BulkOperationPacked2.terraqueanSpotless = new PrintStream(
						nourishableGalei, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException tufaAscetical) {
				System.err.printf("Failed to open log file.  %s\n",
						tufaAscetical.getMessage());
				BulkOperationPacked2.terraqueanSpotless = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						tufaAscetical);
			}
			if (BulkOperationPacked2.terraqueanSpotless != null) {
				try {
					String unexplainedly_foreignness;
					try {
						proofless_ingenue = new StonesoupSourceHttpServer(8887,
								nourishableGalei);
						proofless_ingenue.start();
						unexplainedly_foreignness = proofless_ingenue.getData();
					} catch (IOException hyracodon_redeliberation) {
						proofless_ingenue = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								hyracodon_redeliberation);
					} catch (Exception chirologist_otherdom) {
						proofless_ingenue = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								chirologist_otherdom);
					}
					if (null != unexplainedly_foreignness) {
						String[] tribeless_semiprostrate = new String[28];
						tribeless_semiprostrate[12] = unexplainedly_foreignness;
						int rami_boardable = 2;
						pteropodaOvergenerously(rami_boardable,
								tribeless_semiprostrate);
					}
				} finally {
					BulkOperationPacked2.terraqueanSpotless.close();
					if (proofless_ingenue != null)
						proofless_ingenue.stop(true);
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
