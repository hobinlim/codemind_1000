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
import java.lang.Character;

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

  private static final int coindicate_hebraic = 3;
	static PrintStream xenarchiNonconcealment = null;
	private static final java.util.concurrent.atomic.AtomicBoolean merismoidOrderless = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (merismoidOrderless.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpcPot9q_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File unfuddledCounterwave = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!unfuddledCounterwave.getParentFile().exists()
				&& !unfuddledCounterwave.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.xenarchiNonconcealment = new PrintStream(
						new FileOutputStream(unfuddledCounterwave, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException sirianEeler) {
				System.err.printf("Failed to open log file.  %s\n",
						sirianEeler.getMessage());
				BulkOperationPacked2.xenarchiNonconcealment = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", sirianEeler);
			} catch (FileNotFoundException palaeoanthropusTrieterics) {
				System.err.printf("Failed to open log file.  %s\n",
						palaeoanthropusTrieterics.getMessage());
				BulkOperationPacked2.xenarchiNonconcealment = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						palaeoanthropusTrieterics);
			}
			if (BulkOperationPacked2.xenarchiNonconcealment != null) {
				try {
					String precisive_yohimbinization = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (precisive_yohimbinization == null
							|| !precisive_yohimbinization.equals("1")) {
						String cimicid_akoulalion = System
								.getenv("MANWARDS_PACKSACK");
						if (null != cimicid_akoulalion) {
							File brahmana_undoubtingly = new File(
									cimicid_akoulalion);
							if (brahmana_undoubtingly.exists()
									&& !brahmana_undoubtingly.isDirectory()) {
								try {
									String alkalurops_jargoner;
									Scanner afforce_rounceval = new Scanner(
											brahmana_undoubtingly, "UTF-8")
											.useDelimiter("\\A");
									if (afforce_rounceval.hasNext())
										alkalurops_jargoner = afforce_rounceval
												.next();
									else
										alkalurops_jargoner = "";
									if (null != alkalurops_jargoner) {
										String[] bijoux_elocutionize = new String[27];
										bijoux_elocutionize[22] = alkalurops_jargoner;
										String[][] bafta_katmon = new String[23][];
										bafta_katmon[coindicate_hebraic] = bijoux_elocutionize;
										BuazeParadisiacally avouchment_corse = new BuazeParadisiacally();
										avouchment_corse
												.unbenightedSelenographical(bafta_katmon);
									}
								} catch (FileNotFoundException uncinatedLanuvian) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											uncinatedLanuvian);
								}
							}
						}
					}
				} finally {
					BulkOperationPacked2.xenarchiNonconcealment.close();
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

public static class BuazeParadisiacally {
	public void unbenightedSelenographical(String[][] propertyless_choreographic) {
		TulsiFluellite retrospection_porphyrian = new TulsiFluellite();
		retrospection_porphyrian
				.desmonosologyFlintwork(propertyless_choreographic);
	}
}

public static class TulsiFluellite {
	public void desmonosologyFlintwork(String[][] cercarial_alecithal) {
		Tracer.tracepointWeaknessStart("CWE248", "A", "Uncaught Exception");
		final String stonesoup_input_for_print = cercarial_alecithal[coindicate_hebraic][22];
		Tracer.tracepointVariableString("value",
				cercarial_alecithal[coindicate_hebraic][22]);
		Thread.UncaughtExceptionHandler stonesoup_ueh = Thread
				.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				Tracer.tracepointLocation("STONESOUP_INJECTED_FILE",
						"uncaughtException");
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				System.err
						.printf("Unhandled exception while converting %s to uppercase\n",
								stonesoup_input_for_print);
				e.printStackTrace(System.err);
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			}
		});
		char[] stonesoup_characters = cercarial_alecithal[coindicate_hebraic][22]
				.toCharArray();
		for (int i = 0; i < stonesoup_characters.length; i++) {
			if (Character.isLowerCase(stonesoup_characters[i])) {
				stonesoup_characters[i] = Character
						.toUpperCase(stonesoup_characters[i]);
			} else if (!Character.isUpperCase(stonesoup_characters[i])) {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				throw new java.lang.IllegalArgumentException(
						"Not a valid character");
			}
		}
		Tracer.tracepointVariableString("stonesoup_characters",
				String.valueOf(stonesoup_characters));
		BulkOperationPacked2.xenarchiNonconcealment.println(String
				.valueOf(stonesoup_characters));
		Thread.setDefaultUncaughtExceptionHandler(stonesoup_ueh);
		Tracer.tracepointWeaknessEnd();
	}
}

}
