// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

  static PrintStream theisticalIncompetency = null;
	private static final java.util.concurrent.atomic.AtomicBoolean savagerousOverstrength = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (savagerousOverstrength.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpRX492k_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File pseudomucinExonship = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!pseudomucinExonship.getParentFile().exists()
				&& !pseudomucinExonship.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.theisticalIncompetency = new PrintStream(
						new FileOutputStream(pseudomucinExonship, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException idempotentCrescentade) {
				System.err.printf("Failed to open log file.  %s\n",
						idempotentCrescentade.getMessage());
				BulkOperationPacked2.theisticalIncompetency = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						idempotentCrescentade);
			} catch (FileNotFoundException farmyardyBooth) {
				System.err.printf("Failed to open log file.  %s\n",
						farmyardyBooth.getMessage());
				BulkOperationPacked2.theisticalIncompetency = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", farmyardyBooth);
			}
			if (BulkOperationPacked2.theisticalIncompetency != null) {
				try {
					String morcote_cynology = System
							.getenv("DANDYISH_PHANTASMAGORIST");
					if (null != morcote_cynology) {
						String[] balladic_shroud = new String[16];
						balladic_shroud[1] = morcote_cynology;
						sebillaWagenboom(3, null, null, null, balladic_shroud,
								null, null);
					}
				} finally {
					BulkOperationPacked2.theisticalIncompetency.close();
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

public void sebillaWagenboom(int ralstoniteDoug,
		String[]... eventognathiSinogram) {
	String[] pledgelessHalibiotic = null;
	int motorbusKay = 0;
	for (motorbusKay = 0; motorbusKay < eventognathiSinogram.length; motorbusKay++) {
		if (motorbusKay == ralstoniteDoug)
			pledgelessHalibiotic = eventognathiSinogram[motorbusKay];
	}
	boolean pupunha_uncoatedness = false;
	uninterdicted_rectotomy: for (int extrasensory_decatoic = 0; extrasensory_decatoic < 10; extrasensory_decatoic++)
		for (int scherm_aconin = 0; scherm_aconin < 10; scherm_aconin++)
			if (extrasensory_decatoic * scherm_aconin == 63) {
				pupunha_uncoatedness = true;
				break uninterdicted_rectotomy;
			}
	Tracer.tracepointWeaknessStart("CWE821", "A", "Incorrect Synchronization");
	Stonesoup_Int stonesoup_dev_amount = new Stonesoup_Int(1);
	int stonesoup_qsize = 0;
	String stonesoup_taint = null;
	String stonesoup_file1 = null;
	String stonesoup_file2 = null;
	String stonesoup_substrings[] = pledgelessHalibiotic[1].split("\\s+", 4);
	if (stonesoup_substrings.length == 4) {
		try {
			stonesoup_qsize = Integer.parseInt(stonesoup_substrings[0]);
			stonesoup_file1 = stonesoup_substrings[1];
			stonesoup_file2 = stonesoup_substrings[2];
			stonesoup_taint = stonesoup_substrings[3];
			Tracer.tracepointVariableString("stonesoup_value",
					pledgelessHalibiotic[1]);
			Tracer.tracepointVariableInt("stonesoup_qsize", stonesoup_qsize);
			Tracer.tracepointVariableString("stonesoup_file1", stonesoup_file1);
			Tracer.tracepointVariableString("stonesoup_file2", stonesoup_file2);
			Tracer.tracepointVariableString("stonesoup_taint", stonesoup_taint);
		} catch (NumberFormatException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.theisticalIncompetency
					.println("NumberFormatException");
		}
		if (stonesoup_qsize < 0) {
			BulkOperationPacked2.theisticalIncompetency
					.println("Error: use positive numbers.");
		} else {
			Tracer.tracepointMessage("Creating threads");
			Thread stonesoup_thread2 = new Thread(new devChar(stonesoup_qsize,
					stonesoup_dev_amount, stonesoup_file1,
					BulkOperationPacked2.theisticalIncompetency));
			Thread stonesoup_thread1 = new Thread(new calcDevAmount(
					stonesoup_dev_amount, stonesoup_file2,
					BulkOperationPacked2.theisticalIncompetency));
			stonesoup_threadInput = new StringBuilder().append(stonesoup_taint);
			BulkOperationPacked2.theisticalIncompetency
					.println("Info: Spawning thread 1.");
			stonesoup_thread1.start();
			BulkOperationPacked2.theisticalIncompetency
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
				BulkOperationPacked2.theisticalIncompetency
						.println("Interrupted");
			}
			BulkOperationPacked2.theisticalIncompetency
					.println("Info: Threads ended");
			Tracer.tracepointWeaknessEnd();
		}
	}
}

private static ReentrantLock lock = new ReentrantLock();
private static ReentrantLock lock2 = new ReentrantLock();
private static StringBuilder stonesoup_threadInput;

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpRX492k_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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

public static class Stonesoup_Int {
	int i;

	public Stonesoup_Int(int i) {
		this.i = i;
	}

	public int getVal() {
		return i;
	}

	public void setVal(int i) {
		this.i = i;
	}
}

public static class calcDevAmount implements Runnable {
	private Stonesoup_Int dev_amount;
	private String filename = null;
	private PrintStream output = null;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpRX492k_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"calcDevAmount.run");
		try {
			lock.lock();
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			dev_amount.setVal(stonesoup_threadInput.charAt(0) - 'A');
			Tracer.tracepointVariableInt("dev_amount.getVal()",
					dev_amount.getVal());
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			readFile(filename, output);
			if (dev_amount.getVal() < 0) {
				dev_amount.setVal(dev_amount.getVal() * -1);
			}
			if (dev_amount.getVal() == 0) {
				dev_amount.setVal(dev_amount.getVal() + 1);
			}
			Tracer.tracepointVariableInt("dev_amount.getVal()",
					dev_amount.getVal());
			lock.unlock();
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public calcDevAmount(Stonesoup_Int dev_amount, String filename,
			PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpRX492k_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"calcDevAmount.ctor");
		this.dev_amount = dev_amount;
		this.filename = filename;
		this.output = output;
	}
}

public static class devChar implements Runnable {
	private int size = 0;
	private Stonesoup_Int dev_amount;
	private String filename = null;
	private PrintStream output = null;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpRX492k_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"devChar.run");
		try {
			lock2.lock();
			int[] sortMe = new int[size];
			for (int i = 0; i < size; i++) {
				sortMe[i] = size - i;
			}
			Arrays.sort(sortMe);
			readFile(filename, output);
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			Tracer.tracepointVariableInt("dev_amount.getVal()",
					dev_amount.getVal());
			for (int i = 0; i < stonesoup_threadInput.length(); i++) {
				stonesoup_threadInput.setCharAt(i,
						(char) (stonesoup_threadInput.charAt(i) / dev_amount
								.getVal()));
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			lock2.unlock();
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public devChar(int size, Stonesoup_Int dev_amount, String filename,
			PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpRX492k_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"devChar.ctor");
		this.size = size;
		this.dev_amount = dev_amount;
		this.filename = filename;
		this.output = output;
	}
}

}
