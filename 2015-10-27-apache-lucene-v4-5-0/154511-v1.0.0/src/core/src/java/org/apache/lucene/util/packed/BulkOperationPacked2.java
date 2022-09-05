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
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import javax.xml.bind.DatatypeConverter;

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

  static PrintStream smellproofSternal = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean detailistUnfoggy = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (detailistUnfoggy.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpHguW_v_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		String monopolistic_coloenteritis = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (monopolistic_coloenteritis == null
				|| !monopolistic_coloenteritis.equals("1")) {
			StonesoupSourceHttpServer stereognostic_pombe = null;
			PipedOutputStream roofwardBlanketmaking = new PipedOutputStream();
			try {
				BulkOperationPacked2.smellproofSternal = new PrintStream(
						roofwardBlanketmaking, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException pleasednessTrachelomastoid) {
				System.err.printf("Failed to open log file.  %s\n",
						pleasednessTrachelomastoid.getMessage());
				BulkOperationPacked2.smellproofSternal = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						pleasednessTrachelomastoid);
			}
			if (BulkOperationPacked2.smellproofSternal != null) {
				try {
					final String bankruptlike_ossian;
					try {
						stereognostic_pombe = new StonesoupSourceHttpServer(
								8887, roofwardBlanketmaking);
						stereognostic_pombe.start();
						bankruptlike_ossian = stereognostic_pombe.getData();
					} catch (IOException otalgy_fountainous) {
						stereognostic_pombe = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								otalgy_fountainous);
					} catch (Exception archegosaurus_rasant) {
						stereognostic_pombe = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								archegosaurus_rasant);
					}
					if (null != bankruptlike_ossian) {
						final Object flype_enforcingly = bankruptlike_ossian;
						TruxillicBulbocapnin serape_dietetics = new TruxillicBulbocapnin();
						serape_dietetics.grummetPinaculum(flype_enforcingly);
					}
				} finally {
					BulkOperationPacked2.smellproofSternal.close();
					if (stereognostic_pombe != null)
						stereognostic_pombe.stop(true);
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

public static class TruxillicBulbocapnin {
	public void grummetPinaculum(Object brickhood_unillumination) {
		EncoilMisdrive unexisting_officinally = new EncoilMisdrive();
		unexisting_officinally.violabilityHomoeotel(brickhood_unillumination);
	}
}

public static class EncoilMisdrive {
	public void violabilityHomoeotel(final Object unbespoken_syphilosis){Tracer.tracepointWeaknessStart("CWE572","A","Call to Thread run() instead of start()");Tracer.tracepointMessage("Creating thread");final PrintStream stonesoup_crash_output=BulkOperationPacked2.smellproofSternal;Thread stonesoup_thread1=new Thread(new HelloRunnable(((String)unbespoken_syphilosis),BulkOperationPacked2.smellproofSternal));stonesoup_thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){@Override public void uncaughtException(Thread t,Throwable e){Tracer.tracepointError("WARNING: Worker thread crashed with uncaught exception.");stonesoup_crash_output.println("WARNING: Worker thread crashed with uncaught exception.");e.printStackTrace(stonesoup_crash_output);}});try {Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");stonesoup_thread1.run();Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");Tracer.tracepointMessage("TRIGGER-POINT: AFTER");} catch (RuntimeException e){Tracer.tracepointError("The thread startup raised an excpetion.  " + e.getClass().getName()+": "+e.getMessage());BulkOperationPacked2.smellproofSternal.println("The thread startup raised an exception.  This should never happen.");e.printStackTrace(BulkOperationPacked2.smellproofSternal);throw e;}try {Tracer.tracepointMessage("Joining thread-01");stonesoup_thread1.join();Tracer.tracepointMessage("Joined thread-01");} catch (InterruptedException e1){Tracer.tracepointError(e1.getClass().getName() + ": "+e1.getMessage());BulkOperationPacked2.smellproofSternal.println("Failed to join the worker thread.");e1.printStackTrace(BulkOperationPacked2.smellproofSternal);} finally {BulkOperationPacked2.smellproofSternal.println("Worker thread terminated.");}}
	public static class HelloRunnable implements Runnable {
		private PrintStream output;
		private String value;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpHguW_v_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
					"/tmp/tmpHguW_v_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
					"HelloRunnable.ctor");
			this.value = value;
			this.output = output;
		}
	}
}

}
