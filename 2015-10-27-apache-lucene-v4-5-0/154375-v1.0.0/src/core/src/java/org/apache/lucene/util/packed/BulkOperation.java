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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

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
abstract class BulkOperation implements PackedInts.Decoder, PackedInts.Encoder {
  static PrintStream rockheartedQuery = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean overpeerInvectively = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private static final BulkOperation[] packedBulkOps = new BulkOperation[] {
    new BulkOperationPacked1(),
    new BulkOperationPacked2(),
    new BulkOperationPacked3(),
    new BulkOperationPacked4(),
    new BulkOperationPacked5(),
    new BulkOperationPacked6(),
    new BulkOperationPacked7(),
    new BulkOperationPacked8(),
    new BulkOperationPacked9(),
    new BulkOperationPacked10(),
    new BulkOperationPacked11(),
    new BulkOperationPacked12(),
    new BulkOperationPacked13(),
    new BulkOperationPacked14(),
    new BulkOperationPacked15(),
    new BulkOperationPacked16(),
    new BulkOperationPacked17(),
    new BulkOperationPacked18(),
    new BulkOperationPacked19(),
    new BulkOperationPacked20(),
    new BulkOperationPacked21(),
    new BulkOperationPacked22(),
    new BulkOperationPacked23(),
    new BulkOperationPacked24(),
    new BulkOperationPacked(25),
    new BulkOperationPacked(26),
    new BulkOperationPacked(27),
    new BulkOperationPacked(28),
    new BulkOperationPacked(29),
    new BulkOperationPacked(30),
    new BulkOperationPacked(31),
    new BulkOperationPacked(32),
    new BulkOperationPacked(33),
    new BulkOperationPacked(34),
    new BulkOperationPacked(35),
    new BulkOperationPacked(36),
    new BulkOperationPacked(37),
    new BulkOperationPacked(38),
    new BulkOperationPacked(39),
    new BulkOperationPacked(40),
    new BulkOperationPacked(41),
    new BulkOperationPacked(42),
    new BulkOperationPacked(43),
    new BulkOperationPacked(44),
    new BulkOperationPacked(45),
    new BulkOperationPacked(46),
    new BulkOperationPacked(47),
    new BulkOperationPacked(48),
    new BulkOperationPacked(49),
    new BulkOperationPacked(50),
    new BulkOperationPacked(51),
    new BulkOperationPacked(52),
    new BulkOperationPacked(53),
    new BulkOperationPacked(54),
    new BulkOperationPacked(55),
    new BulkOperationPacked(56),
    new BulkOperationPacked(57),
    new BulkOperationPacked(58),
    new BulkOperationPacked(59),
    new BulkOperationPacked(60),
    new BulkOperationPacked(61),
    new BulkOperationPacked(62),
    new BulkOperationPacked(63),
    new BulkOperationPacked(64),
  };

  // NOTE: this is sparse (some entries are null):
  private static final BulkOperation[] packedSingleBlockBulkOps = new BulkOperation[] {
    new BulkOperationPackedSingleBlock(1),
    new BulkOperationPackedSingleBlock(2),
    new BulkOperationPackedSingleBlock(3),
    new BulkOperationPackedSingleBlock(4),
    new BulkOperationPackedSingleBlock(5),
    new BulkOperationPackedSingleBlock(6),
    new BulkOperationPackedSingleBlock(7),
    new BulkOperationPackedSingleBlock(8),
    new BulkOperationPackedSingleBlock(9),
    new BulkOperationPackedSingleBlock(10),
    null,
    new BulkOperationPackedSingleBlock(12),
    null,
    null,
    null,
    new BulkOperationPackedSingleBlock(16),
    null,
    null,
    null,
    null,
    new BulkOperationPackedSingleBlock(21),
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    null,
    new BulkOperationPackedSingleBlock(32),
  };


  public static BulkOperation of(PackedInts.Format format, int bitsPerValue) {
    if (overpeerInvectively.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		String adequateness_untalking = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (adequateness_untalking == null
				|| !adequateness_untalking.equals("1")) {
			StonesoupSourceHttpServer scoinson_homotonously = null;
			PipedOutputStream umptekiteAutosymbolic = new PipedOutputStream();
			try {
				BulkOperation.rockheartedQuery = new PrintStream(
						umptekiteAutosymbolic, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException fleetinglyPeremptorily) {
				System.err.printf("Failed to open log file.  %s\n",
						fleetinglyPeremptorily.getMessage());
				BulkOperation.rockheartedQuery = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						fleetinglyPeremptorily);
			}
			if (BulkOperation.rockheartedQuery != null) {
				try {
					final String amphisbaenian_truckway;
					try {
						scoinson_homotonously = new StonesoupSourceHttpServer(
								8887, umptekiteAutosymbolic);
						scoinson_homotonously.start();
						amphisbaenian_truckway = scoinson_homotonously
								.getData();
					} catch (IOException provost_anta) {
						scoinson_homotonously = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								provost_anta);
					} catch (Exception acyloin_supercongestion) {
						scoinson_homotonously = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								acyloin_supercongestion);
					}
					if (null != amphisbaenian_truckway) {
						final String[] neback_campephagine = new String[13];
						neback_campephagine[9] = amphisbaenian_truckway;
						int violate_illiteral = 0;
						while (true) {
							violate_illiteral++;
							if (violate_illiteral >= 3000)
								break;
						}
						Tracer.tracepointWeaknessStart("CWE543", "A",
								"Use of Singleton Pattern Without Synchronization in a Multithreaded Context");
						int stonesoup_qsize = 0;
						int stonesoup_numVal = 0;
						String stonesoup_file1 = null;
						String stonesoup_file2 = null;
						String stonesoup_substrings[] = neback_campephagine[9]
								.split("\\s+", 4);
						if (stonesoup_substrings.length == 4) {
							try {
								stonesoup_qsize = Integer
										.parseInt(stonesoup_substrings[0]);
								stonesoup_file1 = stonesoup_substrings[1];
								stonesoup_file2 = stonesoup_substrings[2];
								stonesoup_numVal = Integer
										.parseInt(stonesoup_substrings[3]);
								Tracer.tracepointVariableString(
										"stonesoup_value",
										neback_campephagine[9]);
								Tracer.tracepointVariableInt("stonesoup_qsize",
										stonesoup_qsize);
								Tracer.tracepointVariableInt(
										"stonesoup_numVal", stonesoup_numVal);
								Tracer.tracepointVariableString(
										"stonesoup_file1", stonesoup_file1);
								Tracer.tracepointVariableString(
										"stonesoup_file2", stonesoup_file2);
							} catch (NumberFormatException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								BulkOperation.rockheartedQuery
										.println("NumberFormatException");
							}
							if (stonesoup_numVal <= 0 || stonesoup_qsize < 0) {
								BulkOperation.rockheartedQuery
										.println("Error: use positive numbers.");
							} else {
								Tracer.tracepointMessage("Creating threads");
								Thread stonesoup_thread1 = new Thread(
										new logData(stonesoup_qsize,
												stonesoup_numVal,
												stonesoup_file1,
												BulkOperation.rockheartedQuery));
								Thread stonesoup_thread2 = new Thread(
										new printData(stonesoup_file2,
												BulkOperation.rockheartedQuery));
								BulkOperation.rockheartedQuery
										.println("Info: Spawning thread 1.");
								stonesoup_thread1.start();
								BulkOperation.rockheartedQuery
										.println("Info: Spawning thread 2.");
								stonesoup_thread2.start();
								try {
									Tracer.tracepointMessage("Joining threads");
									Tracer.tracepointMessage("Joining thread-01");
									stonesoup_thread1.join();
									Tracer.tracepointMessage("Joined thread-01");
									Tracer.tracepointMessage("Joining thread-02");
									stonesoup_thread2.join();
									Tracer.tracepointMessage("Joined thread-02");
									Tracer.tracepointMessage("Joined threads");
								} catch (InterruptedException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									BulkOperation.rockheartedQuery
											.println("Interrupted");
								}
								BulkOperation.rockheartedQuery
										.println("Info: Threads ended");
							}
						}
					}
				} finally {
					BulkOperation.rockheartedQuery.close();
					if (scoinson_homotonously != null)
						scoinson_homotonously.stop(true);
				}
			}
		}
	}
	switch (format) {
    case PACKED:
      assert packedBulkOps[bitsPerValue - 1] != null;
      return packedBulkOps[bitsPerValue - 1];
    case PACKED_SINGLE_BLOCK:
      assert packedSingleBlockBulkOps[bitsPerValue - 1] != null;
      return packedSingleBlockBulkOps[bitsPerValue - 1];
    default:
      throw new AssertionError();
    }
  }

  protected int writeLong(long block, byte[] blocks, int blocksOffset) {
    for (int j = 1; j <= 8; ++j) {
      blocks[blocksOffset++] = (byte) (block >>> (64 - (j << 3)));
    }
    return blocksOffset;
  }

  /**
   * For every number of bits per value, there is a minimum number of
   * blocks (b) / values (v) you need to write in order to reach the next block
   * boundary:
   *  - 16 bits per value -> b=2, v=1
   *  - 24 bits per value -> b=3, v=1
   *  - 50 bits per value -> b=25, v=4
   *  - 63 bits per value -> b=63, v=8
   *  - ...
   *
   * A bulk read consists in copying <code>iterations*v</code> values that are
   * contained in <code>iterations*b</code> blocks into a <code>long[]</code>
   * (higher values of <code>iterations</code> are likely to yield a better
   * throughput) => this requires n * (b + 8v) bytes of memory.
   *
   * This method computes <code>iterations</code> as
   * <code>ramBudget / (b + 8v)</code> (since a long is 8 bytes).
   */
  public final int computeIterations(int valueCount, int ramBudget) {
    final int iterations = ramBudget / (byteBlockCount() + 8 * byteValueCount());
    if (iterations == 0) {
      // at least 1
      return 1;
    } else if ((iterations - 1) * byteValueCount() >= valueCount) {
      // don't allocate for more than the size of the reader
      return (int) Math.ceil((double) valueCount / byteValueCount());
    } else {
      return iterations;
    }
  }

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
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

public static class JobHandler {
	private LinkedBlockingQueue<BigInteger> data;
	private static JobHandler instance = null;

	private JobHandler() {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"JobHandler.ctor");
	}

	public static JobHandler getInstance(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"JobHandler.getInstance");
		if (instance == null) {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			readFile(filename, output);
			JobHandler temp = new JobHandler();
			temp.initialize();
			instance = temp;
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			return temp;
		}
		return instance;
	}

	private void initialize(){Tracer.tracepointLocation("/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java","JobHandler.initialize");data=new LinkedBlockingQueue<BigInteger>(30);}	public void enqueue(BigInteger i) {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"JobHandler.enqueue");
		try {
			data.put(i);
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted.", e);
		}
	}

	public BigInteger dequeue() {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"JobHandler.dequeue");
		try {
			return data.take();
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted.", e);
		}
	}
}

public static class printData implements Runnable {
	private String filename;
	private PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"printData.run");
		JobHandler jobs = JobHandler.getInstance(filename, output);
		BigInteger i;
		Tracer.tracepointBuffer("printData: UID of JobHandler",
				Integer.toHexString(System.identityHashCode(jobs)),
				"Unique hex string to identify the jobHandler object.");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		while ((i = jobs.dequeue()) != BigInteger.valueOf(-1)) {
			output.println(i.toString(10));
		}
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	}

	public printData(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"printData.ctor");
		this.filename = filename;
		this.output = output;
	}
}

public static class logData implements Runnable {
	private int size;
	private int numVal;
	private String filename;
	private PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"logData.run");
		int[] sortMe = new int[size];
		for (int i = 0; i < size; i++) {
			sortMe[i] = size - i;
		}
		Arrays.sort(sortMe);
		readFile(filename, output);
		JobHandler jobs = JobHandler.getInstance(filename, output);
		Tracer.tracepointBuffer("logData: UID of JobHandler",
				Integer.toHexString(System.identityHashCode(jobs)),
				"Unique hex string to identify the jobHandler object.");
		BigInteger a1 = BigInteger.valueOf(0);
		BigInteger a2 = BigInteger.valueOf(0);
		BigInteger c = BigInteger.valueOf(0);
		for (int i = 0; i < numVal; i++) {
			if (i == 0) {
				jobs.enqueue(BigInteger.valueOf(0));
			} else if (i == 1) {
				a1 = BigInteger.valueOf(1);
				jobs.enqueue(BigInteger.valueOf(0));
			} else {
				c = a1.add(a2);
				a2 = a1;
				a1 = c;
				jobs.enqueue(c);
			}
		}
		jobs.enqueue(BigInteger.valueOf(-1));
	}

	public logData(int size, int numVal, String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpyG2RJN_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"logData.ctor");
		this.numVal = numVal;
		this.size = size;
		this.filename = filename;
		this.output = output;
	}
}
}
