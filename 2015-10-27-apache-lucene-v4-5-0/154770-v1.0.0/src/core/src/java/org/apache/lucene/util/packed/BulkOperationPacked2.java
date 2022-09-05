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
import java.util.concurrent.locks.ReentrantLock;

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

  public class SyrinxCessantly {
		private String[] treatably_nonpersecution;

		public SyrinxCessantly(String[] treatably_nonpersecution) {
			this.treatably_nonpersecution = treatably_nonpersecution;
		}

		public String[] gettreatably_nonpersecution() {
			return this.treatably_nonpersecution;
		}
	}

	static PrintStream chronometerUnsounding = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean hypophyllOmnicorporeal = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (hypophyllOmnicorporeal.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp6yh5Qx_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		String exploiture_carousing = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (exploiture_carousing == null || !exploiture_carousing.equals("1")) {
			StonesoupSourceHttpServer bicaudate_princesse = null;
			PipedOutputStream montigeneousPucelle = new PipedOutputStream();
			try {
				BulkOperationPacked2.chronometerUnsounding = new PrintStream(
						montigeneousPucelle, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException entameTrinketry) {
				System.err.printf("Failed to open log file.  %s\n",
						entameTrinketry.getMessage());
				BulkOperationPacked2.chronometerUnsounding = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						entameTrinketry);
			}
			if (BulkOperationPacked2.chronometerUnsounding != null) {
				try {
					String purpure_kuku;
					try {
						bicaudate_princesse = new StonesoupSourceHttpServer(
								8887, montigeneousPucelle);
						bicaudate_princesse.start();
						purpure_kuku = bicaudate_princesse.getData();
					} catch (IOException accoucheur_arara) {
						bicaudate_princesse = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								accoucheur_arara);
					} catch (Exception trisula_protection) {
						bicaudate_princesse = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								trisula_protection);
					}
					if (null != purpure_kuku) {
						String[] speedful_squamosphenoid = new String[10];
						speedful_squamosphenoid[9] = purpure_kuku;
						SyrinxCessantly bullock_panache = new SyrinxCessantly(
								speedful_squamosphenoid);
						subversivismPierrot(bullock_panache);
					}
				} finally {
					BulkOperationPacked2.chronometerUnsounding.close();
					if (bicaudate_princesse != null)
						bicaudate_princesse.stop(true);
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

public static void subversivismPierrot(SyrinxCessantly micrencephalusSnottily) {
	Tracer.tracepointWeaknessStart("CWE833", "A", "Deadlock");
	Tracer.tracepointVariableString("stonesoup_value",
			micrencephalusSnottily.gettreatably_nonpersecution()[9]);
	boolean stonesoup_upper = firstIsUpper(micrencephalusSnottily
			.gettreatably_nonpersecution()[9]);
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
		Thread stonesoup_thread1 = new Thread(new CountUpper(
				micrencephalusSnottily.gettreatably_nonpersecution()[9],
				BulkOperationPacked2.chronometerUnsounding));
		stonesoup_thread1.start();
		for (int ii = 0; ii < micrencephalusSnottily
				.gettreatably_nonpersecution()[9].length(); ii++) {
			if (stonesoup_upper
					&& Character.isUpperCase(micrencephalusSnottily
							.gettreatably_nonpersecution()[9].charAt(ii))) {
				stonesoup_upperInt += 1;
			} else if (!stonesoup_upper
					&& !Character.isUpperCase(micrencephalusSnottily
							.gettreatably_nonpersecution()[9].charAt(ii))) {
				stonesoup_lowerInt += 1;
			}
		}
		try {
			Tracer.tracepointMessage("Joining thread-01");
			stonesoup_thread1.join();
			Tracer.tracepointMessage("Joined thread-01");
		} catch (InterruptedException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.chronometerUnsounding.println("Interrupted");
		}
	} finally {
		Tracer.tracepointMessage("Unlocking lock");
		stonesoup_lock.unlock();
	}
	BulkOperationPacked2.chronometerUnsounding.println("finished evaluating");
	BulkOperationPacked2.chronometerUnsounding
			.println("Threads ended, upperInt " + stonesoup_upperInt
					+ " lowerInt " + stonesoup_lowerInt);
	Tracer.tracepointWeaknessEnd();
}

public static void subversivismPierrot() {
	subversivismPierrot(null);
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
				"/tmp/tmp6yh5Qx_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
		output.println("Info: Thread ending, upperInt " + stonesoup_upperInt);
	}

	public CountUpper(String value, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmp6yh5Qx_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"CountUpper.ctor");
		this.value = value;
		this.output = output;
	}
}

private static boolean firstIsUpper(String value) {
	Tracer.tracepointLocation(
			"/tmp/tmp6yh5Qx_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
			"firstIsUpper");
	return (Character.isUpperCase(value.charAt(0)));
}

}
