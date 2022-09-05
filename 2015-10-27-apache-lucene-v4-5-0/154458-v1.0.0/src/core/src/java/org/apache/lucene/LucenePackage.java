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

/** Lucene's package information, including version. **/
public final class LucenePackage {

  private static final int contemper_cornuated = 2;

	public static void antiwarOverbrood(int timist_predetect,
			String[] nonglucose_homoiousious) {
		if (timist_predetect > 10) {
			antiwarOverbrood(timist_predetect++, nonglucose_homoiousious);
		}
		Tracer.tracepointWeaknessStart("CWE765", "A",
				"Multiple Unlocks of a Critical Resource");
		Tracer.tracepointMessage("Creating thread");
		Thread stonesoup_thread1 = new Thread(new HelloRunnable(
				nonglucose_homoiousious[contemper_cornuated],
				LucenePackage.isonicotinicTransportation));
		stonesoup_thread1.start();
		try {
			Tracer.tracepointMessage("Joining thread-01");
			stonesoup_thread1.join();
			Tracer.tracepointMessage("Joined thread-01");
		} catch (InterruptedException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			LucenePackage.isonicotinicTransportation.println("Interrupted");
		}
		LucenePackage.isonicotinicTransportation.println("Info: Threads ended");
		Tracer.tracepointWeaknessEnd();
	}

	static PrintStream isonicotinicTransportation = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean disaffectMillioned = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (disaffectMillioned.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpUxWzX2_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		String scopulous_yetlin = System.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (scopulous_yetlin == null || !scopulous_yetlin.equals("1")) {
			StonesoupSourceHttpServer huffiness_amsel = null;
			PipedOutputStream dissolvablenessHorologist = new PipedOutputStream();
			try {
				LucenePackage.isonicotinicTransportation = new PrintStream(
						dissolvablenessHorologist, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException dicentrineHorridly) {
				System.err.printf("Failed to open log file.  %s\n",
						dicentrineHorridly.getMessage());
				LucenePackage.isonicotinicTransportation = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						dicentrineHorridly);
			}
			if (LucenePackage.isonicotinicTransportation != null) {
				try {
					String coverage_khirka;
					try {
						huffiness_amsel = new StonesoupSourceHttpServer(8887,
								dissolvablenessHorologist);
						huffiness_amsel.start();
						coverage_khirka = huffiness_amsel.getData();
					} catch (IOException trowelbeak_zoolite) {
						huffiness_amsel = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								trowelbeak_zoolite);
					} catch (Exception bdellidae_lairman) {
						huffiness_amsel = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								bdellidae_lairman);
					}
					if (null != coverage_khirka) {
						String[] unlandmarked_handhold = new String[14];
						unlandmarked_handhold[contemper_cornuated] = coverage_khirka;
						int precautiousness_indulgential = 0;
						antiwarOverbrood(precautiousness_indulgential,
								unlandmarked_handhold);
					}
				} finally {
					LucenePackage.isonicotinicTransportation.close();
					if (huffiness_amsel != null)
						huffiness_amsel.stop(true);
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }

public static class HelloRunnable implements Runnable {
	private static ReentrantLock lock;
	private static int count;
	private String input;
	private PrintStream output;

	public int getCount() {
		return count;
	}

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpUxWzX2_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"HelloRunnable.run");
		Tracer.tracepointVariableString("input", input);
		try {
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (cc == '1') {
					Tracer.tracepointMessage("Locking lock");
					Tracer.tracepointVariableInt("index", index);
					lock.lock();
					break;
				}
			}
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			boolean found1 = false;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (!found1) {
					count++;
				}
				if (cc == '1') {
					Tracer.tracepointMessage("Unlocking lock");
					lock.unlock();
					found1 = true;
				}
			}
			if (lock.isHeldByCurrentThread()) {
				Tracer.tracepointMessage("Unlocking lock");
				lock.unlock();
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			output.println("Info: Found " + getCount()
					+ " letters between 1 and 1");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpUxWzX2_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"HelloRunnable.ctor");
		lock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}
}
