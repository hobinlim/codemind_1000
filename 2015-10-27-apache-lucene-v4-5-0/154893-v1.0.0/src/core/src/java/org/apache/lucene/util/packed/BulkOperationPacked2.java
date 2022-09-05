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

  static PrintStream liggerLazyboots = null;
	private static final java.util.concurrent.atomic.AtomicBoolean nycticoraxMoselle = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (nycticoraxMoselle.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File tocharishOculinoid = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!tocharishOculinoid.getParentFile().exists()
				&& !tocharishOculinoid.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.liggerLazyboots = new PrintStream(
						new FileOutputStream(tocharishOculinoid, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException biracialismArtificially) {
				System.err.printf("Failed to open log file.  %s\n",
						biracialismArtificially.getMessage());
				BulkOperationPacked2.liggerLazyboots = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						biracialismArtificially);
			} catch (FileNotFoundException peritrichanUnsecured) {
				System.err.printf("Failed to open log file.  %s\n",
						peritrichanUnsecured.getMessage());
				BulkOperationPacked2.liggerLazyboots = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						peritrichanUnsecured);
			}
			if (BulkOperationPacked2.liggerLazyboots != null) {
				try {
					String alopecoid_hemadromograph = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (alopecoid_hemadromograph == null
							|| !alopecoid_hemadromograph.equals("1")) {
						String undisordered_semiellipsis = System
								.getenv("SOVEREIGNESS_PREINHERIT");
						if (null != undisordered_semiellipsis) {
							File condylomatous_oraculate = new File(
									undisordered_semiellipsis);
							if (condylomatous_oraculate.exists()
									&& !condylomatous_oraculate.isDirectory()) {
								try {
									final String harman_adrenin;
									Scanner amidocaffeine_fretfulness = new Scanner(
											condylomatous_oraculate, "UTF-8")
											.useDelimiter("\\A");
									if (amidocaffeine_fretfulness.hasNext())
										harman_adrenin = amidocaffeine_fretfulness
												.next();
									else
										harman_adrenin = "";
									if (null != harman_adrenin) {
										final Object unfeoffed_wardwoman = harman_adrenin;
										try {
											String smiris_atramental = System
													.getProperty("os.name");
											if (null != smiris_atramental) {
												if (!smiris_atramental
														.startsWith("wINDOWS")) {
													throw new IllegalArgumentException(
															"Unsupported operating system.");
												}
											}
										} catch (IllegalArgumentException beaten_zymologist) {
										} finally {
											Tracer.tracepointWeaknessStart(
													"CWE609", "A",
													"Double-Checked Locking");
											int stonesoup_qsize = 0;
											String stonesoup_taint = null;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = ((String) unfeoffed_wardwoman)
													.split("\\s+", 4);
											if (stonesoup_substrings.length == 4) {
												try {
													stonesoup_qsize = Integer
															.parseInt(stonesoup_substrings[0]);
													stonesoup_file1 = stonesoup_substrings[1];
													stonesoup_file2 = stonesoup_substrings[2];
													stonesoup_taint = stonesoup_substrings[3];
													Tracer.tracepointVariableString(
															"stonesoup_value",
															((String) unfeoffed_wardwoman));
													Tracer.tracepointVariableInt(
															"stonesoup_qsize",
															stonesoup_qsize);
													Tracer.tracepointVariableString(
															"stonesoup_file1",
															stonesoup_file1);
													Tracer.tracepointVariableString(
															"stonesoup_file2",
															stonesoup_file2);
													Tracer.tracepointVariableString(
															"stonesoup_taint",
															stonesoup_taint);
												} catch (NumberFormatException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													BulkOperationPacked2.liggerLazyboots
															.println("NumberFormatException");
												}
												if (stonesoup_qsize < 0) {
													BulkOperationPacked2.liggerLazyboots
															.println("Error: use positive numbers.");
												} else {
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread1 = new Thread(
															new doStuff(
																	stonesoup_taint,
																	stonesoup_qsize,
																	stonesoup_file2,
																	BulkOperationPacked2.liggerLazyboots));
													Thread stonesoup_thread2 = new Thread(
															new doStuff2(
																	stonesoup_taint,
																	stonesoup_qsize,
																	stonesoup_file1,
																	BulkOperationPacked2.liggerLazyboots));
													BulkOperationPacked2.liggerLazyboots
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													BulkOperationPacked2.liggerLazyboots
															.println("Info: Spawning thread 2.");
													stonesoup_thread2.start();
													try {
														Tracer.tracepointMessage("Joining threads");
														Tracer.tracepointMessage("Joining thread-01");
														stonesoup_thread1
																.join();
														Tracer.tracepointMessage("Joined thread-01");
														Tracer.tracepointMessage("Joining thread-02");
														stonesoup_thread2
																.join();
														Tracer.tracepointMessage("Joined thread-02");
														Tracer.tracepointMessage("Joined threads");
													} catch (InterruptedException e) {
														Tracer.tracepointError(e
																.getClass()
																.getName()
																+ ": "
																+ e.getMessage());
														BulkOperationPacked2.liggerLazyboots
																.println("Interrupted");
													}
													BulkOperationPacked2.liggerLazyboots
															.println("Info: Threads ended");
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									}
								} catch (FileNotFoundException leopardeBrahui) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											leopardeBrahui);
								}
							}
						}
					}
				} finally {
					BulkOperationPacked2.liggerLazyboots.close();
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

private static ReentrantLock lock = new ReentrantLock();

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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

public static class Stonesoup_Str {
	public static StringBuilder data = null;
	public static int size = -1;
}

public static void init_Stonesoup_Str(String data, int qsize, String filename,
		PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
			"init_Stonesoup_Str");
	output.println(Thread.currentThread().getId() + ": In init_Stonesoup_Str");
	if (Stonesoup_Str.data == null) {
		lock.lock();
		if (Stonesoup_Str.data == null) {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			Stonesoup_Str.data = new StringBuilder();
			Stonesoup_Str.size = data.length();
			output.println(Thread.currentThread().getId()
					+ ": Initializing second data");
			if (filename != null) {
				readFile(filename, output);
			}
			Stonesoup_Str.data.append(data);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		} else {
			output.println(Thread.currentThread().getId()
					+ ": No need to initialize");
		}
		lock.unlock();
	} else {
		output.println(Thread.currentThread().getId()
				+ ": Data is already initialized");
	}
}

public static class doStuff implements Runnable {
	private int size = 0;
	private String data = null;
	private PrintStream output;
	String filename;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"doStuff.run");
		try {
			output.println(Thread.currentThread().getId() + ": Inside doStuff");
			Tracer.tracepointMessage("doStuff: entering init_Stonesoup_Str");
			init_Stonesoup_Str(data, size, filename, output);
			output.println(Thread.currentThread().getId()
					+ ": In doStuff Stonesoup_Str is: "
					+ Stonesoup_Str.data.toString());
			Tracer.tracepointVariableString("Stonesoup_Str",
					Stonesoup_Str.data.toString());
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public doStuff(String data, int qsize, String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"doStuff.ctor");
		this.data = data;
		this.size = qsize;
		this.output = output;
		this.filename = filename;
	}
}

public static class doStuff2 implements Runnable {
	private int size = 0;
	private String data = null;
	private PrintStream output;
	private String filename;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"doStuff2.run");
		int[] sortMe = new int[size];
		try {
			output.println(Thread.currentThread().getId() + ": Inside doStuff2");
			for (int i = 0; i < size; i++) {
				sortMe[i] = size - i;
			}
			Arrays.sort(sortMe);
			readFile(filename, output);
			Tracer.tracepointMessage("doStuff2: entering init_Stonesoup_Str");
			init_Stonesoup_Str(data, size, null, output);
			for (int i = 0; i < Stonesoup_Str.data.length(); i++) {
				if (Stonesoup_Str.data.charAt(i) >= 'a'
						|| Stonesoup_Str.data.charAt(i) <= 'z') {
					Stonesoup_Str.data
							.setCharAt(
									i,
									(char) (Stonesoup_Str.data.charAt(i) - ('a' - 'A')));
				}
			}
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			if (Stonesoup_Str.data.charAt(0) != '\0') {
				output.println(Thread.currentThread().getId()
						+ ": In doStuff2 Stonesoup_Str is: "
						+ Stonesoup_Str.data.toString());
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public doStuff2(String data, int size, String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpuL95d3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"doStuff2.ctor");
		this.data = data;
		this.size = size;
		this.filename = filename;
		this.output = output;
	}
}

}
