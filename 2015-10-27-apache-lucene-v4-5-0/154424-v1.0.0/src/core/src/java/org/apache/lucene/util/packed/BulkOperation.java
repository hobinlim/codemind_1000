// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
abstract class BulkOperation implements PackedInts.Decoder, PackedInts.Encoder {
  private static final int dinnertime_headset = 1;

	static PrintStream outfreemanNongospel = null;

	private static final java.util.concurrent.atomic.AtomicBoolean recognizabilityTailwise = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (recognizabilityTailwise.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpJmULf5_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		File dioptryJoyousness = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!dioptryJoyousness.getParentFile().exists()
				&& !dioptryJoyousness.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperation.outfreemanNongospel = new PrintStream(
						new FileOutputStream(dioptryJoyousness, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException hyperglycemiaAtrophoderma) {
				System.err.printf("Failed to open log file.  %s\n",
						hyperglycemiaAtrophoderma.getMessage());
				BulkOperation.outfreemanNongospel = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						hyperglycemiaAtrophoderma);
			} catch (FileNotFoundException gumptionlessSinsion) {
				System.err.printf("Failed to open log file.  %s\n",
						gumptionlessSinsion.getMessage());
				BulkOperation.outfreemanNongospel = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						gumptionlessSinsion);
			}
			if (BulkOperation.outfreemanNongospel != null) {
				try {
					String myrsiphyllum_deformedness = System
							.getenv("DORSONUCHAL_UNVENTILATED");
					if (null != myrsiphyllum_deformedness) {
						String[] alienist_sutlery = new String[21];
						alienist_sutlery[18] = myrsiphyllum_deformedness;
						String[][] oxamide_circumambient = new String[8][];
						oxamide_circumambient[dinnertime_headset] = alienist_sutlery;
						Tracer.tracepointWeaknessStart("CWE663", "A",
								"Use of a Non-reentrant Function in a Concurrent Context");
						String stonesoup_substrings[] = oxamide_circumambient[dinnertime_headset][18]
								.split("\\s", 2);
						int stonesoup_qsize = 0;
						if (stonesoup_substrings.length == 2) {
							try {
								stonesoup_qsize = Integer
										.parseInt(stonesoup_substrings[0]);
							} catch (NumberFormatException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								BulkOperation.outfreemanNongospel
										.println("NumberFormatException");
							}
							Tracer.tracepointVariableString(
									"stonesoup_value",
									oxamide_circumambient[dinnertime_headset][18]);
							Tracer.tracepointVariableInt("stonesoup_qsize",
									stonesoup_qsize);
							Tracer.tracepointVariableString(
									"stonesoup_threadInput",
									stonesoup_substrings[1]);
							if (stonesoup_qsize < 0) {
								stonesoup_qsize = 0;
								BulkOperation.outfreemanNongospel
										.println("Qsize should be >=0, setting it to 0.");
							}
							Tracer.tracepointVariableInt("stonesoup_qsize",
									stonesoup_qsize);
							Tracer.tracepointMessage("Creating threads");
							Thread stonesoup_thread1 = new Thread(
									new replaceSymbols(stonesoup_qsize,
											BulkOperation.outfreemanNongospel));
							Thread stonesoup_thread2 = new Thread(new toCaps(
									stonesoup_qsize,
									BulkOperation.outfreemanNongospel));
							stonesoup_threadInput = new StringBuilder()
									.append(stonesoup_substrings[1]);
							Tracer.tracepointMessage("Spawning threads.");
							BulkOperation.outfreemanNongospel
									.println("Info: Spawning thread 1.");
							stonesoup_thread1.start();
							BulkOperation.outfreemanNongospel
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
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								BulkOperation.outfreemanNongospel
										.println("Interrupted");
							}
							BulkOperation.outfreemanNongospel
									.println("Info: Threads ended");
						}
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					BulkOperation.outfreemanNongospel.close();
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

private static ReentrantLock lock = new ReentrantLock();

private static StringBuilder stonesoup_threadInput;

static volatile int j;


public static void arrFunc(int size, String tempfile, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpJmULf5_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
			"arrFunc");
	int[] sortMe = new int[size];
	j = 0;
	Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
	for (int i = 0; i < stonesoup_threadInput.length(); i++, j++) {
		stonesoup_threadInput.setCharAt(j, '\0');
		output.format("TID: %d I: %d J: %d\n", Thread.currentThread().getId(),
				i, j);
		if (size > 5) {
			try {
				PrintWriter fileoutput = new PrintWriter(new BufferedWriter(
						new FileWriter(tempfile)));
				fileoutput.println("Iteration: " + i);
				fileoutput.close();
			} catch (IOException e) {
				Tracer.tracepointError("IOException");
			}
			for (int k = 0; k < size; k++) {
				sortMe[k] = size - k;
			}
			Arrays.sort(sortMe);
		}
	}
	Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
}

public static class replaceSymbols implements Runnable {
	private int size = 0;
	private int threadTiming = 500000;
	PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpJmULf5_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"replaceSymbols.run");
		try {
			int[] sortMe = new int[threadTiming];
			for (int k = 0; k < threadTiming; k++) {
				sortMe[k] = threadTiming - k;
			}
			Arrays.sort(sortMe);
			Tracer.tracepointMessage("replaceSymbols: after qsort");
			lock.lock();
			char val;
			for (int i = 0; i < stonesoup_threadInput.length(); i++) {
				val = stonesoup_threadInput.charAt(i);
				if (((val >= '!' && val <= '/') || (val >= ':' && val <= '@')
						|| (val >= '[' && val <= '`') || (val >= '{' && val <= '~'))
						&& (val != '@' && val != '.')) {
					stonesoup_threadInput.setCharAt(i, '_');
				}
			}
			lock.unlock();
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE (1)");
			arrFunc(size, "/opt/stonesoup/workspace/testData/replace.txt",
					output);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER (1)");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public replaceSymbols(int size, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpJmULf5_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"replaceSymbols.ctor");
		this.size = size;
		this.output = output;
	}
}

public static class toCaps implements Runnable {
	public int size = 0;
	PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpJmULf5_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"toCaps.run");
		try {
			lock.lock();
			for (int i = 0; i < stonesoup_threadInput.length(); i++) {
				if (stonesoup_threadInput.charAt(i) >= 'a'
						|| stonesoup_threadInput.charAt(i) <= 'z') {
					stonesoup_threadInput
							.setCharAt(
									i,
									(char) (stonesoup_threadInput.charAt(i) - ('a' - 'A')));
				}
			}
			lock.unlock();
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE (2)");
			arrFunc(size, "/opt/stonesoup/workspace/testData/toCaps.txt",
					output);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER (2)");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public toCaps(int size, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpJmULf5_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"toCaps.ctor");
		this.size = size;
		this.output = output;
	}
}
}
