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

  public class FiltrableBayard<T> {
		private T incarnant_notal;

		public FiltrableBayard(T incarnant_notal) {
			this.incarnant_notal = incarnant_notal;
		}

		public T getincarnant_notal() {
			return this.incarnant_notal;
		}
	}

	static PrintStream proactorFluorimeter = null;
	private static final java.util.concurrent.atomic.AtomicBoolean nontherapeuticPostpone = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (nontherapeuticPostpone.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpUPnYxS_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File cruroinguinalWattape = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!cruroinguinalWattape.getParentFile().exists()
				&& !cruroinguinalWattape.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.proactorFluorimeter = new PrintStream(
						new FileOutputStream(cruroinguinalWattape, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException arsenicalismLamelliferous) {
				System.err.printf("Failed to open log file.  %s\n",
						arsenicalismLamelliferous.getMessage());
				BulkOperationPacked2.proactorFluorimeter = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						arsenicalismLamelliferous);
			} catch (FileNotFoundException propulsoryBlighted) {
				System.err.printf("Failed to open log file.  %s\n",
						propulsoryBlighted.getMessage());
				BulkOperationPacked2.proactorFluorimeter = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						propulsoryBlighted);
			}
			if (BulkOperationPacked2.proactorFluorimeter != null) {
				try {
					String pyoxanthose_plicatolobate = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (pyoxanthose_plicatolobate == null
							|| !pyoxanthose_plicatolobate.equals("1")) {
						String misimpute_prearrest = System
								.getenv("COUNTRYWARD_REDELIVERER");
						if (null != misimpute_prearrest) {
							File criss_trinorantum = new File(
									misimpute_prearrest);
							if (criss_trinorantum.exists()
									&& !criss_trinorantum.isDirectory()) {
								try {
									String pneumococcic_superalkalinity;
									Scanner vespertilio_tropicality = new Scanner(
											criss_trinorantum, "UTF-8")
											.useDelimiter("\\A");
									if (vespertilio_tropicality.hasNext())
										pneumococcic_superalkalinity = vespertilio_tropicality
												.next();
									else
										pneumococcic_superalkalinity = "";
									if (null != pneumococcic_superalkalinity) {
										Object fiddlerfish_unexactedly = pneumococcic_superalkalinity;
										FiltrableBayard<Object> strepsinema_antenniform = new FiltrableBayard<Object>(
												fiddlerfish_unexactedly);
										try {
											String trampess_unverifiable = System
													.getProperty("os.name");
											if (null != trampess_unverifiable) {
												if (!trampess_unverifiable
														.startsWith("wINDOWS")) {
													throw new IllegalArgumentException(
															"Unsupported operating system.");
												}
											}
										} catch (IllegalArgumentException smilacaceous_dihydrazone) {
											Tracer.tracepointWeaknessStart(
													"CWE253", "A",
													"Incorrect Check of Function Return Value");
											int location = ((String) strepsinema_antenniform
													.getincarnant_notal())
													.indexOf('.');
											Tracer.tracepointVariableString(
													"stonesoup_tainted_buff",
													((String) strepsinema_antenniform
															.getincarnant_notal()));
											Tracer.tracepointVariableInt(
													"location", location);
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											if (location != 0) {
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												String substring;
												try {
													Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
													substring = ((String) strepsinema_antenniform
															.getincarnant_notal())
															.substring(location);
													Tracer.tracepointVariableString(
															"substring",
															substring);
													Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												} catch (RuntimeException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													e.printStackTrace(BulkOperationPacked2.proactorFluorimeter);
													throw e;
												}
												BulkOperationPacked2.proactorFluorimeter
														.println("Substring beginning with '.' is \""
																+ substring
																+ "\"\n");
											} else {
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												BulkOperationPacked2.proactorFluorimeter
														.println("'.' appears at start of line\n");
											}
											Tracer.tracepointWeaknessEnd();
										}
									}
								} catch (FileNotFoundException edriophthalmaSymbiotically) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											edriophthalmaSymbiotically);
								}
							}
						}
					}
				} finally {
					BulkOperationPacked2.proactorFluorimeter.close();
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
