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

  public class HermitryPlanklike {
		private String humdrumminess_revocative;

		public HermitryPlanklike(String humdrumminess_revocative) {
			this.humdrumminess_revocative = humdrumminess_revocative;
		}

		public String gethumdrumminess_revocative() {
			return this.humdrumminess_revocative;
		}
	}

	public void hemoproctiaImpertinacy(int substantiation_atramental,
			HermitryPlanklike unplat_policed) {
		substantiation_atramental--;
		if (substantiation_atramental > 0) {
			unflowingUnrecalling(substantiation_atramental, unplat_policed);
		}
	}

	public void unflowingUnrecalling(int sinto_vermicious,
			HermitryPlanklike unplat_policed) {
		hemoproctiaImpertinacy(sinto_vermicious, unplat_policed);
		Tracer.tracepointWeaknessStart("CWE832", "A",
				"Unlock of a Resource that is not Locked");
		Tracer.tracepointMessage("Creating thread");
		Thread stonesoup_thread1 = new Thread(new HelloRunnable(
				unplat_policed.gethumdrumminess_revocative(),
				BulkOperationPacked2.uterolithPresbyopia));
		stonesoup_thread1.start();
		try {
			Tracer.tracepointMessage("Joining thread-01");
			stonesoup_thread1.join();
			Tracer.tracepointMessage("Joined thread-01");
		} catch (InterruptedException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.uterolithPresbyopia.println("Interrupted");
		}
		BulkOperationPacked2.uterolithPresbyopia.println("Info: Thread ended");
		Tracer.tracepointWeaknessEnd();
	}

	static PrintStream uterolithPresbyopia = null;
	private static final java.util.concurrent.atomic.AtomicBoolean impuritanSympodium = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (impuritanSympodium.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File lealandFunctionally = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!lealandFunctionally.getParentFile().exists()
				&& !lealandFunctionally.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.uterolithPresbyopia = new PrintStream(
						new FileOutputStream(lealandFunctionally, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException tasselCurvy) {
				System.err.printf("Failed to open log file.  %s\n",
						tasselCurvy.getMessage());
				BulkOperationPacked2.uterolithPresbyopia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", tasselCurvy);
			} catch (FileNotFoundException pterodactyliBasidiomycetous) {
				System.err.printf("Failed to open log file.  %s\n",
						pterodactyliBasidiomycetous.getMessage());
				BulkOperationPacked2.uterolithPresbyopia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						pterodactyliBasidiomycetous);
			}
			if (BulkOperationPacked2.uterolithPresbyopia != null) {
				try {
					String untrappable_pokable = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (untrappable_pokable == null
							|| !untrappable_pokable.equals("1")) {
						String morbiferal_indurative = System
								.getenv("MONITORIALLY_LORDLIKE");
						if (null != morbiferal_indurative) {
							File yajnopavita_knapweed = new File(
									morbiferal_indurative);
							if (yajnopavita_knapweed.exists()
									&& !yajnopavita_knapweed.isDirectory()) {
								try {
									String snarer_jaga;
									Scanner villageous_fustet = new Scanner(
											yajnopavita_knapweed, "UTF-8")
											.useDelimiter("\\A");
									if (villageous_fustet.hasNext())
										snarer_jaga = villageous_fustet.next();
									else
										snarer_jaga = "";
									if (null != snarer_jaga) {
										HermitryPlanklike unplat_policed = new HermitryPlanklike(
												snarer_jaga);
										int brandy_levir = 2;
										hemoproctiaImpertinacy(brandy_levir,
												unplat_policed);
									}
								} catch (FileNotFoundException stepbrotherTock) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											stepbrotherTock);
								}
							}
						}
					}
				} finally {
					BulkOperationPacked2.uterolithPresbyopia.close();
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

public static class HelloRunnable implements Runnable {
	private static ReentrantLock upperLock;
	private static ReentrantLock lowerLock;
	private static int count;
	private String input;
	private PrintStream output;

	public int getCount() {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"HelloRunable.getCount");
		return count;
	}

	private void lockA(Character cc) {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"HelloRunable.lockA");
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		if (Character.isUpperCase(cc)) {
			Tracer.tracepointMessage("Locking upperLock");
			upperLock.lock();
		} else {
			Tracer.tracepointMessage("Locking lowerLock");
			lowerLock.lock();
		}
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	}

	private void unlockA(Character cc) {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"HelloRunable.unlockA");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		Tracer.tracepointMessage("Unlocking lowerlock");
		lowerLock.unlock();
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	}

	private void cleanLocks() {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"HelloRunable.cleanLocks");
		if (upperLock.isHeldByCurrentThread()) {
			Tracer.tracepointMessage("Unlocking upperLock");
			upperLock.unlock();
		}
		if (lowerLock.isHeldByCurrentThread()) {
			Tracer.tracepointMessage("Unlocking lowerLock");
			lowerLock.unlock();
		}
	}

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"HelloRunable.run");
		try {
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (Character.toUpperCase(cc) == 'A') {
					lockA(cc);
					break;
				}
			}
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (Character.toUpperCase(cc) == 'A') {
					unlockA(cc);
					break;
				} else {
					count++;
				}
			}
			cleanLocks();
			output.println("Info: Found " + getCount()
					+ " letters between a and a");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpNtQmIJ_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"HelloRunable.ctor");
		upperLock = new ReentrantLock();
		lowerLock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}

}
