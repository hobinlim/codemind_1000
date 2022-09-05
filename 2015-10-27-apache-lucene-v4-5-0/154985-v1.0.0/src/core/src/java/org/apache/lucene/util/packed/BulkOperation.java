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
abstract class BulkOperation implements PackedInts.Decoder, PackedInts.Encoder {
  private static final int unjealoused_estrange = 7;

	static PrintStream farmostConjecturably = null;

	private static final java.util.concurrent.atomic.AtomicBoolean megathereEndogeny = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (megathereEndogeny.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpfE9JEY_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		File plutonismUnscrawled = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!plutonismUnscrawled.getParentFile().exists()
				&& !plutonismUnscrawled.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperation.farmostConjecturably = new PrintStream(
						new FileOutputStream(plutonismUnscrawled, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException brutalismCowboy) {
				System.err.printf("Failed to open log file.  %s\n",
						brutalismCowboy.getMessage());
				BulkOperation.farmostConjecturably = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", brutalismCowboy);
			} catch (FileNotFoundException stoplessClientelage) {
				System.err.printf("Failed to open log file.  %s\n",
						stoplessClientelage.getMessage());
				BulkOperation.farmostConjecturably = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						stoplessClientelage);
			}
			if (BulkOperation.farmostConjecturably != null) {
				try {
					String supermanism_calcariform = System
							.getenv("DEUTOMALAR_BRODDER");
					if (null != supermanism_calcariform) {
						short matchmark_ethynyl;
						try {
							matchmark_ethynyl = Short
									.parseShort(supermanism_calcariform);
						} catch (NumberFormatException phyllotaxy_wanga) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									phyllotaxy_wanga);
						}
						short[] malattress_scoleciform = new short[9];
						malattress_scoleciform[1] = matchmark_ethynyl;
						short[][] somewhiles_puissantly = new short[12][];
						somewhiles_puissantly[unjealoused_estrange] = malattress_scoleciform;
						accustomedUkulele(somewhiles_puissantly);
					}
				} finally {
					BulkOperation.farmostConjecturably.close();
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

public static void accustomedUkulele(short[][] rommanyAutoexcitation) {
	Tracer.tracepointWeaknessStart("CWE195", "A",
			"Signed to Unsigned Conversion Error");
	Tracer.tracepointVariableShort("value",
			rommanyAutoexcitation[unjealoused_estrange][1]);
	Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
	int[] stonesoup_array = new int[Math
			.abs(rommanyAutoexcitation[unjealoused_estrange][1])];
	char stonesoup_max_char = (char) ((short) rommanyAutoexcitation[unjealoused_estrange][1]);
	Tracer.tracepointBufferInfo("stonesoup_array", stonesoup_array.length,
			"Length of stonesoup_array");
	Tracer.tracepointVariableChar("stonesoup_max_char", stonesoup_max_char);
	Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	try {
		Tracer.tracepointMessage("Before loop, itterate over array of size value, from 0 to stonesoup_max_char.");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		for (char stonesoup_counter = 0; stonesoup_counter < stonesoup_max_char; stonesoup_counter++) {
			BulkOperation.farmostConjecturably.printf(
					"Counter value: \"%c\"\n", stonesoup_counter);
			stonesoup_array[stonesoup_counter] = 0;
		}
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	} catch (RuntimeException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace(BulkOperation.farmostConjecturably);
		throw e;
	}
	Tracer.tracepointWeaknessEnd();
}

public static void accustomedUkulele() {
	accustomedUkulele(null);
}
}
