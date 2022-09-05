// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

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
  static PrintStream itemPalaeocosmic = null;


	public static void klansmanSwaying(int spokeshave_copious,
			String tripsacum_kataphoretic) {
		if (spokeshave_copious > 10) {
			klansmanSwaying(spokeshave_copious++, tripsacum_kataphoretic);
		}
		Tracer.tracepointWeaknessStart("CWE567", "A",
				"Unsynchronized Access to Shared Data in a Multithreaded Context");
		int stonesoup_qsize = 0;
		String stonesoup_taint = null;
		String stonesoup_file1 = null;
		String stonesoup_file2 = null;
		String stonesoup_substrings[] = tripsacum_kataphoretic.split("\\s+", 4);
		if (stonesoup_substrings.length == 4) {
			try {
				stonesoup_qsize = Integer.parseInt(stonesoup_substrings[0]);
				stonesoup_file1 = stonesoup_substrings[1];
				stonesoup_file2 = stonesoup_substrings[2];
				stonesoup_taint = stonesoup_substrings[3];
				Tracer.tracepointVariableString("stonesoup_value",
						tripsacum_kataphoretic);
				Tracer.tracepointVariableInt("stonesoup_qsize", stonesoup_qsize);
				Tracer.tracepointVariableString("stonesoup_file1",
						stonesoup_file1);
				Tracer.tracepointVariableString("stonesoup_file2",
						stonesoup_file2);
				Tracer.tracepointVariableString("stonesoup_taint",
						stonesoup_taint);
			} catch (NumberFormatException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				BulkOperation.itemPalaeocosmic.println("NumberFormatException");
			}
			if (stonesoup_qsize < 0) {
				BulkOperation.itemPalaeocosmic
						.println("Error: use positive numbers.");
			} else {
				Tracer.tracepointMessage("Creating threads");
				Thread stonesoup_thread2 = new Thread(new devChar(
						stonesoup_qsize, stonesoup_file1,
						BulkOperation.itemPalaeocosmic));
				Thread stonesoup_thread1 = new Thread(new calcDevAmount(
						stonesoup_file2, BulkOperation.itemPalaeocosmic));
				stonesoup_threadInput = new StringBuilder()
						.append(stonesoup_taint);
				BulkOperation.itemPalaeocosmic
						.println("Info: Spawning thread 1.");
				stonesoup_thread1.start();
				stonesoup_thread2.start();
				BulkOperation.itemPalaeocosmic
						.println("Info: Spawning thread 2.");
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
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					BulkOperation.itemPalaeocosmic.println("Interrupted");
				}
				BulkOperation.itemPalaeocosmic.println("Info: Threads ended");
			}
		}
		Tracer.tracepointWeaknessEnd();
	}

	private static final java.util.concurrent.atomic.AtomicBoolean cyclometerHepatatrophy = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (cyclometerHepatatrophy.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpuBdxcM_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		File workloomPedatrophia = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!workloomPedatrophia.getParentFile().exists()
				&& !workloomPedatrophia.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperation.itemPalaeocosmic = new PrintStream(
						new FileOutputStream(workloomPedatrophia, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException seigneurEdema) {
				System.err.printf("Failed to open log file.  %s\n",
						seigneurEdema.getMessage());
				BulkOperation.itemPalaeocosmic = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", seigneurEdema);
			} catch (FileNotFoundException codiniacTraitress) {
				System.err.printf("Failed to open log file.  %s\n",
						codiniacTraitress.getMessage());
				BulkOperation.itemPalaeocosmic = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						codiniacTraitress);
			}
			if (BulkOperation.itemPalaeocosmic != null) {
				try {
					String nerveroot_research = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (nerveroot_research == null
							|| !nerveroot_research.equals("1")) {
						String perigastric_chondralgia = System
								.getenv("SCARFACE_HORMONIC");
						if (null != perigastric_chondralgia) {
							File deplorableness_nonclosure = new File(
									perigastric_chondralgia);
							if (deplorableness_nonclosure.exists()
									&& !deplorableness_nonclosure.isDirectory()) {
								try {
									String budget_denunciatory;
									Scanner parcel_pedatrophia = new Scanner(
											deplorableness_nonclosure, "UTF-8")
											.useDelimiter("\\A");
									if (parcel_pedatrophia.hasNext())
										budget_denunciatory = parcel_pedatrophia
												.next();
									else
										budget_denunciatory = "";
									if (null != budget_denunciatory) {
										unflushSubeffective(3, null, null,
												null, budget_denunciatory,
												null, null);
									}
								} catch (FileNotFoundException raulSleuth) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											raulSleuth);
								}
							}
						}
					}
				} finally {
					BulkOperation.itemPalaeocosmic.close();
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

public static void unflushSubeffective(int reflectivityPipecoline,
		String... morassUnctiousness) {
	String broadleafStratigraphist = null;
	int xiphiplastronNomadian = 0;
	for (xiphiplastronNomadian = 0; xiphiplastronNomadian < morassUnctiousness.length; xiphiplastronNomadian++) {
		if (xiphiplastronNomadian == reflectivityPipecoline)
			broadleafStratigraphist = morassUnctiousness[xiphiplastronNomadian];
	}
	int whitecap_sesquibasic = 0;
	klansmanSwaying(whitecap_sesquibasic, broadleafStratigraphist);
}

private static StringBuilder stonesoup_threadInput;

private static volatile int dev_amount = 1;


public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpuBdxcM_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
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

public static class calcDevAmount implements Runnable {
	public String filename = null;
	public PrintStream output = null;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpuBdxcM_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"calcDevAmount.run");
		try {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			dev_amount = stonesoup_threadInput.charAt(0) - 'A';
			readFile(filename, output);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			if (dev_amount < 0) {
				dev_amount *= -1;
			}
			if (dev_amount == 0) {
				dev_amount += 1;
			}
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public calcDevAmount(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpuBdxcM_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"calcDevAmount.ctor");
		this.filename = filename;
		this.output = output;
	}
}

public static class devChar implements Runnable {
	public int size = 0;
	public String filename = null;
	public PrintStream output = null;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpuBdxcM_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"devChar.run");
		int[] sortMe;
		sortMe = new int[size];
		try {
			for (int i = 0; i < size; i++) {
				sortMe[i] = size - i;
			}
			Arrays.sort(sortMe);
			readFile(filename, output);
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			for (int i = 0; i < stonesoup_threadInput.length(); i++) {
				stonesoup_threadInput.setCharAt(i,
						(char) (stonesoup_threadInput.charAt(i) / dev_amount));
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public devChar(int size, String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpuBdxcM_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"devChar.ctor");
		this.size = size;
		this.filename = filename;
		this.output = output;
	}
}
}
