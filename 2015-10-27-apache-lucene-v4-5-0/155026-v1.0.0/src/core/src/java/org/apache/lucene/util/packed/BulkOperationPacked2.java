// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;

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

  private static final int tackled_nassology = 4;
	static PrintStream masterdomArduously = null;
	private static final java.util.concurrent.atomic.AtomicBoolean unreplacedMeatoscope = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (unreplacedMeatoscope.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpzzEXI3_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File nakedlyLitaneutical = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!nakedlyLitaneutical.getParentFile().exists()
				&& !nakedlyLitaneutical.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.masterdomArduously = new PrintStream(
						new FileOutputStream(nakedlyLitaneutical, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException excrementitiousNitrosulphonic) {
				System.err.printf("Failed to open log file.  %s\n",
						excrementitiousNitrosulphonic.getMessage());
				BulkOperationPacked2.masterdomArduously = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						excrementitiousNitrosulphonic);
			} catch (FileNotFoundException acropetalMusculospinal) {
				System.err.printf("Failed to open log file.  %s\n",
						acropetalMusculospinal.getMessage());
				BulkOperationPacked2.masterdomArduously = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						acropetalMusculospinal);
			}
			if (BulkOperationPacked2.masterdomArduously != null) {
				try {
					String hemihedrism_glidingly = System
							.getenv("SIMBALL_STEELY");
					if (null != hemihedrism_glidingly) {
						short dipotassic_berapt;
						try {
							dipotassic_berapt = Short
									.parseShort(hemihedrism_glidingly);
						} catch (NumberFormatException metanilic_pityroid) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									metanilic_pityroid);
						}
						short[] overdeck_reblade = new short[16];
						overdeck_reblade[tackled_nassology] = dipotassic_berapt;
						try {
							String kyurin_goodhearted = System
									.getProperty("os.name");
							if (null != kyurin_goodhearted) {
								if (!kyurin_goodhearted.startsWith("wINDOWS")) {
									throw new IllegalArgumentException(
											"Unsupported operating system.");
								}
							}
						} catch (IllegalArgumentException tapajo_humane) {
						} finally {
							Tracer.tracepointWeaknessStart("CWE191", "A",
									"Integer Underflow (Wrap or Wraparound)");
							short stonesoup_checked_value = overdeck_reblade[tackled_nassology];
							Tracer.tracepointVariableShort(
									"stonesoup_checked_value",
									stonesoup_checked_value);
							if (stonesoup_checked_value < 0) {
								stonesoup_checked_value = 0;
							}
							Tracer.tracepointVariableShort(
									"stonesoup_checked_value",
									stonesoup_checked_value);
							Short[] stonesoup_some_values = new Short[] { 0, 1,
									2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
									15, 16, 17, 18, 19, 20 };
							short stonesoup_counter = -20;
							short stonesoup_offset = 40;
							Tracer.tracepointBufferInfo(
									"stonesoup_some_values",
									stonesoup_some_values.length,
									"Length of stonesoup_some_values");
							Tracer.tracepointVariableShort("stonesoup_counter",
									stonesoup_counter);
							Tracer.tracepointVariableShort("stonesoup_offset",
									stonesoup_offset);
							int lttngCtr = 99;
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
							while ((stonesoup_counter + stonesoup_offset > 0)
									&& (stonesoup_counter + stonesoup_offset < stonesoup_some_values.length)) {
								BulkOperationPacked2.masterdomArduously.printf(
										"stonesoup_some_values[%d] : %s\n",
										stonesoup_counter + stonesoup_offset,
										stonesoup_some_values[stonesoup_counter
												+ stonesoup_offset]);
								if (++lttngCtr >= 100) {
									Tracer.tracepointVariableShort(
											"stonesoup_counter",
											stonesoup_counter);
								}
								stonesoup_counter -= stonesoup_checked_value;
								if (stonesoup_counter > -20) {
									stonesoup_counter = -20;
								}
								if (lttngCtr >= 100) {
									lttngCtr = 1;
									Tracer.tracepointVariableShort(
											"stonesoup_counter",
											stonesoup_counter);
								}
							}
							Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							Tracer.tracepointBufferInfo(
									"stonesoup_some_values",
									stonesoup_some_values.length,
									"Length of stonesoup_some_values");
							Tracer.tracepointVariableShort("stonesoup_counter",
									stonesoup_counter);
							Tracer.tracepointVariableShort("stonesoup_offset",
									stonesoup_offset);
							BulkOperationPacked2.masterdomArduously
									.println("finished evaluating");
							Tracer.tracepointWeaknessEnd();
						}
					}
				} finally {
					BulkOperationPacked2.masterdomArduously.close();
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
