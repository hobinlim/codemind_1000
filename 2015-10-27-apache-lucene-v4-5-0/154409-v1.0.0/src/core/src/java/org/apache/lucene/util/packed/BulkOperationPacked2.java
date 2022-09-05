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
final class BulkOperationPacked2 extends BulkOperationPacked {

  static PrintStream reundertakeArchsteward = null;
	private static final java.util.concurrent.atomic.AtomicBoolean pangiumPulverization = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (pangiumPulverization.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpy6gr01_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File preimprovementHobnailer = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!preimprovementHobnailer.getParentFile().exists()
				&& !preimprovementHobnailer.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.reundertakeArchsteward = new PrintStream(
						new FileOutputStream(preimprovementHobnailer, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException unparliamentaryBattakhin) {
				System.err.printf("Failed to open log file.  %s\n",
						unparliamentaryBattakhin.getMessage());
				BulkOperationPacked2.reundertakeArchsteward = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						unparliamentaryBattakhin);
			} catch (FileNotFoundException cactiFarmost) {
				System.err.printf("Failed to open log file.  %s\n",
						cactiFarmost.getMessage());
				BulkOperationPacked2.reundertakeArchsteward = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", cactiFarmost);
			}
			if (BulkOperationPacked2.reundertakeArchsteward != null) {
				try {
					String placoides_hydrops = System
							.getenv("HEMOMETER_PEDANTOCRATIC");
					if (null != placoides_hydrops) {
						String[] orective_milligramage = new String[28];
						orective_milligramage[5] = placoides_hydrops;
						quassiaSylvan(3, null, null, null,
								orective_milligramage, null, null);
					}
				} finally {
					BulkOperationPacked2.reundertakeArchsteward.close();
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

public void quassiaSylvan(int tauromachyStipular, String[]... apneicEctoloph) {
	String[] pinchednessCorporalism = null;
	int holmicRachiometer = 0;
	for (holmicRachiometer = 0; holmicRachiometer < apneicEctoloph.length; holmicRachiometer++) {
		if (holmicRachiometer == tauromachyStipular)
			pinchednessCorporalism = apneicEctoloph[holmicRachiometer];
	}
	boolean unobese_kitchenmaid = false;
	wherefore_rheostat: for (int anticourtier_erogenesis = 0; anticourtier_erogenesis < 10; anticourtier_erogenesis++)
		for (int unallurable_spermophiline = 0; unallurable_spermophiline < 10; unallurable_spermophiline++)
			if (anticourtier_erogenesis * unallurable_spermophiline == 63) {
				unobese_kitchenmaid = true;
				break wherefore_rheostat;
			}
	Tracer.tracepointWeaknessStart("CWE663", "A",
			"Use of a Non-reentrant Function in a Concurrent Context");
	String stonesoup_substrings[] = pinchednessCorporalism[5].split("\\s", 2);
	int stonesoup_qsize = 0;
	if (stonesoup_substrings.length == 2) {
		try {
			stonesoup_qsize = Integer.parseInt(stonesoup_substrings[0]);
		} catch (NumberFormatException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.reundertakeArchsteward
					.println("NumberFormatException");
		}
		Tracer.tracepointVariableString("stonesoup_value",
				pinchednessCorporalism[5]);
		Tracer.tracepointVariableInt("stonesoup_qsize", stonesoup_qsize);
		Tracer.tracepointVariableString("stonesoup_threadInput",
				stonesoup_substrings[1]);
		if (stonesoup_qsize < 0) {
			stonesoup_qsize = 0;
			BulkOperationPacked2.reundertakeArchsteward
					.println("Qsize should be >=0, setting it to 0.");
		}
		Tracer.tracepointVariableInt("stonesoup_qsize", stonesoup_qsize);
		Tracer.tracepointMessage("Creating threads");
		Thread stonesoup_thread1 = new Thread(new replaceSymbols(
				stonesoup_qsize, BulkOperationPacked2.reundertakeArchsteward));
		Thread stonesoup_thread2 = new Thread(new toCaps(stonesoup_qsize,
				BulkOperationPacked2.reundertakeArchsteward));
		stonesoup_threadInput = new StringBuilder()
				.append(stonesoup_substrings[1]);
		Tracer.tracepointMessage("Spawning threads.");
		BulkOperationPacked2.reundertakeArchsteward
				.println("Info: Spawning thread 1.");
		stonesoup_thread1.start();
		BulkOperationPacked2.reundertakeArchsteward
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
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.reundertakeArchsteward.println("Interrupted");
		}
		BulkOperationPacked2.reundertakeArchsteward
				.println("Info: Threads ended");
	}
	Tracer.tracepointWeaknessEnd();
}

private static ReentrantLock lock = new ReentrantLock();
private static StringBuilder stonesoup_threadInput;
static volatile int j;

public static void arrFunc(int size, String tempfile, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpy6gr01_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
				"/tmp/tmpy6gr01_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
				"/tmp/tmpy6gr01_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
				"/tmp/tmpy6gr01_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
				"/tmp/tmpy6gr01_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"toCaps.ctor");
		this.size = size;
		this.output = output;
	}
}

}
