// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
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
abstract class BulkOperation implements PackedInts.Decoder, PackedInts.Encoder {
  static PrintStream sievefulClinopodium = null;

	private static final java.util.concurrent.atomic.AtomicBoolean mespilHatchetlike = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (mespilHatchetlike.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp2Gh6Vi_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		File circumgenitalThunderstrike = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!circumgenitalThunderstrike.getParentFile().exists()
				&& !circumgenitalThunderstrike.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperation.sievefulClinopodium = new PrintStream(
						new FileOutputStream(circumgenitalThunderstrike, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException bandworkBaho) {
				System.err.printf("Failed to open log file.  %s\n",
						bandworkBaho.getMessage());
				BulkOperation.sievefulClinopodium = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", bandworkBaho);
			} catch (FileNotFoundException brewmasterCrapy) {
				System.err.printf("Failed to open log file.  %s\n",
						brewmasterCrapy.getMessage());
				BulkOperation.sievefulClinopodium = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", brewmasterCrapy);
			}
			if (BulkOperation.sievefulClinopodium != null) {
				try {
					final String cubitus_aristolochia = System
							.getenv("WHIPPET_HERMENEUTIC");
					if (null != cubitus_aristolochia) {
						final Object pretorture_portment = cubitus_aristolochia;
						try {
							String shavian_myoendocarditis = System
									.getProperty("os.name");
							if (null != shavian_myoendocarditis) {
								if (!shavian_myoendocarditis
										.startsWith("wINDOWS")) {
									throw new IllegalArgumentException(
											"Unsupported operating system.");
								}
							}
						} catch (IllegalArgumentException spinstership_antifelony) {
						} finally {
							Tracer.tracepointWeaknessStart("CWE248", "A",
									"Uncaught Exception");
							final String stonesoup_input_for_print = ((String) pretorture_portment);
							Tracer.tracepointVariableString("value",
									((String) pretorture_portment));
							Thread.UncaughtExceptionHandler stonesoup_ueh = Thread
									.getDefaultUncaughtExceptionHandler();
							Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
								public void uncaughtException(Thread t,
										Throwable e) {
									Tracer.tracepointLocation(
											"STONESOUP_INJECTED_FILE",
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
							char[] stonesoup_characters = ((String) pretorture_portment)
									.toCharArray();
							for (int i = 0; i < stonesoup_characters.length; i++) {
								if (Character
										.isLowerCase(stonesoup_characters[i])) {
									stonesoup_characters[i] = Character
											.toUpperCase(stonesoup_characters[i]);
								} else if (!Character
										.isUpperCase(stonesoup_characters[i])) {
									Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
									throw new java.lang.IllegalArgumentException(
											"Not a valid character");
								}
							}
							Tracer.tracepointVariableString(
									"stonesoup_characters",
									String.valueOf(stonesoup_characters));
							BulkOperation.sievefulClinopodium.println(String
									.valueOf(stonesoup_characters));
							Thread.setDefaultUncaughtExceptionHandler(stonesoup_ueh);
							Tracer.tracepointWeaknessEnd();
						}
					}
				} finally {
					BulkOperation.sievefulClinopodium.close();
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
}
