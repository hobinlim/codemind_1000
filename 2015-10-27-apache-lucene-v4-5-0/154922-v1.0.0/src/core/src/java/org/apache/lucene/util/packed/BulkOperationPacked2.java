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
import java.io.PrintWriter;

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

  static PrintStream theftlessDure = null;
	private static final java.util.concurrent.atomic.AtomicBoolean unromanticalEpornitic = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (unromanticalEpornitic.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmprM5262_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File seascapePrepatellar = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!seascapePrepatellar.getParentFile().exists()
				&& !seascapePrepatellar.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.theftlessDure = new PrintStream(
						new FileOutputStream(seascapePrepatellar, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException subfluvialTerpinol) {
				System.err.printf("Failed to open log file.  %s\n",
						subfluvialTerpinol.getMessage());
				BulkOperationPacked2.theftlessDure = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						subfluvialTerpinol);
			} catch (FileNotFoundException unamicableFestoonery) {
				System.err.printf("Failed to open log file.  %s\n",
						unamicableFestoonery.getMessage());
				BulkOperationPacked2.theftlessDure = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						unamicableFestoonery);
			}
			if (BulkOperationPacked2.theftlessDure != null) {
				try {
					String deafness_stourliness = System
							.getenv("SUBFLOOR_GREENBONE");
					if (null != deafness_stourliness) {
						String[] microdontism_sturdyhearted = new String[23];
						microdontism_sturdyhearted[7] = deafness_stourliness;
						bardolphianStartor(3, null, null, null,
								microdontism_sturdyhearted, null, null);
					}
				} finally {
					BulkOperationPacked2.theftlessDure.close();
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

public void bardolphianStartor(int pollyannaHomoousianist,
		String[]... lowmostWounded) {
	String[] aerophilatelicUndiffusive = null;
	int tregergHelpmeet = 0;
	for (tregergHelpmeet = 0; tregergHelpmeet < lowmostWounded.length; tregergHelpmeet++) {
		if (tregergHelpmeet == pollyannaHomoousianist)
			aerophilatelicUndiffusive = lowmostWounded[tregergHelpmeet];
	}
	usuaryHohe(aerophilatelicUndiffusive);
}

public static void usuaryHohe(String[] spileholeIrresultive) {
	Tracer.tracepointWeaknessStart("CWE363", "A",
			"Race Condition Enabling Link Following");
	String stonesoup_syncfile = null;
	String stonesoup_fileName = null;
	String stonesoup_substrings[] = spileholeIrresultive[7].split("\\s+", 2);
	if (stonesoup_substrings.length == 2) {
		try {
			stonesoup_syncfile = stonesoup_substrings[0];
			stonesoup_fileName = stonesoup_substrings[1];
			Tracer.tracepointVariableString("stonesoup_value",
					spileholeIrresultive[7]);
			Tracer.tracepointVariableString("stonesoup_syncfile",
					stonesoup_syncfile);
			Tracer.tracepointVariableString("stonesoup_fileNmae",
					stonesoup_fileName);
		} catch (NumberFormatException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.theftlessDure.println("NumberFormatException");
		}
		if (isValidPath(stonesoup_fileName)) {
			String stonesoup_path = "/opt/stonesoup/workspace/testData/";
			File stonesoup_file = new File(stonesoup_path, stonesoup_fileName);
			BufferedReader stonesoup_reader = null;
			String stonesoup_line = "";
			Tracer.tracepointVariableString("stonesoup_file",
					stonesoup_file.getAbsolutePath());
			if (stonesoup_file.exists()) {
				try {
					if (!isSymlink(stonesoup_file)) {
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						waitForChange(stonesoup_path, stonesoup_fileName,
								stonesoup_syncfile,
								BulkOperationPacked2.theftlessDure);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						stonesoup_reader = new BufferedReader(new FileReader(
								stonesoup_file.getAbsolutePath()));
						while ((stonesoup_line = stonesoup_reader.readLine()) != null) {
							BulkOperationPacked2.theftlessDure
									.println(stonesoup_line);
						}
						stonesoup_reader.close();
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
					} else {
						Tracer.tracepointError("ERROR: File is a symlink!");
						BulkOperationPacked2.theftlessDure
								.println("ERROR: File is a symlink!");
					}
				} catch (IOException e) {
					Tracer.tracepointError("ERROR: File got deleted.");
					BulkOperationPacked2.theftlessDure
							.println("ERROR: File got deleted.");
				}
			} else {
				Tracer.tracepointError("ERROR: File doesn't exist!");
				BulkOperationPacked2.theftlessDure
						.println("ERROR: File doesn't exist!");
			}
		} else {
			Tracer.tracepointError("ERROR: Filename isn't valid!");
			BulkOperationPacked2.theftlessDure
					.println("ERROR: Filename isn't valid!");
		}
	} else {
		Tracer.tracepointError("ERROR: Input isn't valid!");
		BulkOperationPacked2.theftlessDure.println("ERROR: Input isn't valid!");
	}
	Tracer.tracepointWeaknessEnd();
}

public static void usuaryHohe() {
	usuaryHohe(null);
}

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmprM5262_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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

public static void waitForChange(String path, String fileName, String syncFile,
		PrintStream output) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmprM5262_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
			"waitForChange");
	PrintWriter writer = new PrintWriter(path + fileName + ".pid");
	writer.close();
	Tracer.tracepointVariableString(".pid file", path + fileName + ".pid");
	Tracer.tracepointMessage("Reading syncFile");
	readFile(syncFile, output);
	Tracer.tracepointMessage("Finished reading syncFile");
}

public static boolean isValidPath(String file) {
	Tracer.tracepointLocation(
			"/tmp/tmprM5262_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
			"isValidPath");
	return !file.contains("/");
}

public static boolean isSymlink(File file) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmprM5262_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
			"isSymlink");
	return !file.getCanonicalFile().equals(file.getAbsoluteFile());
}

}
