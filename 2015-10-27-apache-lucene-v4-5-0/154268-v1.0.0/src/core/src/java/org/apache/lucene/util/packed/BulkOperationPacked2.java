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

  static PrintStream sporochnaceaeInfanta = null;

	public void developoidPianograph(int guily_hydatopneumatic,
			final Object tactosol_gutterman) {
		if (guily_hydatopneumatic > 10) {
			developoidPianograph(guily_hydatopneumatic++, tactosol_gutterman);
		}
		Tracer.tracepointWeaknessStart("CWE391", "A",
				"Unchecked Error Condition");
		int[] stonesoup_arr = null;
		Tracer.tracepointVariableInt("size", ((Integer) tactosol_gutterman));
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		try {
			BulkOperationPacked2.sporochnaceaeInfanta.printf(
					"Allocating array of size %d\n",
					((Integer) tactosol_gutterman));
			stonesoup_arr = new int[((Integer) tactosol_gutterman)];
		} catch (OutOfMemoryError e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
		}
		Tracer.tracepointBufferInfo("stonesoup_arr",
				(stonesoup_arr == null) ? 0 : stonesoup_arr.length,
				"Length of stonesoup_arr");
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		try {
			Tracer.tracepointMessage("TRIGGER-PONIT: BEFORE");
			for (int i = 0; i < stonesoup_arr.length; i++) {
				stonesoup_arr[i] = ((Integer) tactosol_gutterman) - i;
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (RuntimeException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(BulkOperationPacked2.sporochnaceaeInfanta);
			throw e;
		}
		Tracer.tracepointWeaknessEnd();
	}

	private static final java.util.concurrent.atomic.AtomicBoolean incorrectionNeocytosis = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (incorrectionNeocytosis.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpgpg5gY_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File statolatryTheatrograph = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!statolatryTheatrograph.getParentFile().exists()
				&& !statolatryTheatrograph.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.sporochnaceaeInfanta = new PrintStream(
						new FileOutputStream(statolatryTheatrograph, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException toadstoneHyperdulia) {
				System.err.printf("Failed to open log file.  %s\n",
						toadstoneHyperdulia.getMessage());
				BulkOperationPacked2.sporochnaceaeInfanta = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						toadstoneHyperdulia);
			} catch (FileNotFoundException switchSubcaudal) {
				System.err.printf("Failed to open log file.  %s\n",
						switchSubcaudal.getMessage());
				BulkOperationPacked2.sporochnaceaeInfanta = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", switchSubcaudal);
			}
			if (BulkOperationPacked2.sporochnaceaeInfanta != null) {
				try {
					String corrupter_syllogist = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (corrupter_syllogist == null
							|| !corrupter_syllogist.equals("1")) {
						String kail_flocky = System
								.getenv("TRANKA_EUROPEANIZATION");
						if (null != kail_flocky) {
							File eseptate_lease = new File(kail_flocky);
							if (eseptate_lease.exists()
									&& !eseptate_lease.isDirectory()) {
								try {
									final String tinkerdom_foreganger;
									Scanner chalybeous_caprylate = new Scanner(
											eseptate_lease, "UTF-8")
											.useDelimiter("\\A");
									if (chalybeous_caprylate.hasNext())
										tinkerdom_foreganger = chalybeous_caprylate
												.next();
									else
										tinkerdom_foreganger = "";
									if (null != tinkerdom_foreganger) {
										final int paratuberculin_inviolate;
										try {
											paratuberculin_inviolate = Integer
													.parseInt(tinkerdom_foreganger);
										} catch (NumberFormatException treasure_dejected) {
											throw new RuntimeException(
													"STONESOUP: Failed to convert source taint.",
													treasure_dejected);
										}
										final Object sastean_tie = paratuberculin_inviolate;
										int barrico_besoothe = 0;
										developoidPianograph(barrico_besoothe,
												sastean_tie);
									}
								} catch (FileNotFoundException uncomparableTogetheriness) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											uncomparableTogetheriness);
								}
							}
						}
					}
				} finally {
					BulkOperationPacked2.sporochnaceaeInfanta.close();
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

}
