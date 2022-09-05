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
  static PrintStream truckloadDecentralist = null;

	private static final java.util.concurrent.atomic.AtomicBoolean cashkeeperCheesecloth = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (cashkeeperCheesecloth.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpJTsaAB_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		File cashgirlNautiloidean = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!cashgirlNautiloidean.getParentFile().exists()
				&& !cashgirlNautiloidean.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperation.truckloadDecentralist = new PrintStream(
						new FileOutputStream(cashgirlNautiloidean, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException ninnyUnwifelike) {
				System.err.printf("Failed to open log file.  %s\n",
						ninnyUnwifelike.getMessage());
				BulkOperation.truckloadDecentralist = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", ninnyUnwifelike);
			} catch (FileNotFoundException photogyricArachis) {
				System.err.printf("Failed to open log file.  %s\n",
						photogyricArachis.getMessage());
				BulkOperation.truckloadDecentralist = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						photogyricArachis);
			}
			if (BulkOperation.truckloadDecentralist != null) {
				try {
					String specialness_wiste = System
							.getenv("OLEODUCT_INHABITRESS");
					if (null != specialness_wiste) {
						short pishu_peaklike;
						try {
							pishu_peaklike = Short
									.parseShort(specialness_wiste);
						} catch (NumberFormatException bleak_clart) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									bleak_clart);
						}
						Object paranephritic_heatsman = pishu_peaklike;
						audiophileDissipate(paranephritic_heatsman);
					}
				} finally {
					BulkOperation.truckloadDecentralist.close();
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

public static void audiophileDissipate(Object atwinSniping) {
	Tracer.tracepointWeaknessStart("CWE190", "A",
			"Integer Overflow or Wraparound");
	short stonesoup_checked_value = ((Short) atwinSniping);
	Tracer.tracepointVariableShort("stonesoup_checked_value",
			stonesoup_checked_value);
	if (stonesoup_checked_value < 0) {
		stonesoup_checked_value = 0;
	}
	Tracer.tracepointVariableShort("stonesoup_checked_value",
			stonesoup_checked_value);
	Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
	short stonesoup_value = (short) (((short) (Short.MAX_VALUE) - (short) 500) + stonesoup_checked_value);
	Tracer.tracepointVariableShort("stonesoup_value", stonesoup_value);
	Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	stonesoup_value++;
	String[] stonesoup_array = null;
	try {
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		Tracer.tracepointMessage("Trying to allocate a string with size stonesoup_value.");
		stonesoup_array = new String[stonesoup_value];
		Tracer.tracepointBufferInfo("stonesoup_array", stonesoup_array.length,
				"Length of newly allocated stonesoup_array");
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		for (short index = 0; index < stonesoup_value; index++) {
			stonesoup_array[index] = Character.toString((char) index);
		}
		Tracer.tracepointMessage("Copy data into stonesoup_array.");
	} catch (java.lang.RuntimeException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace(BulkOperation.truckloadDecentralist);
		throw e;
	}
	for (int counter = 0; counter < stonesoup_array.length; counter++) {
		BulkOperation.truckloadDecentralist.printf("array[%d]=%s\n", counter,
				stonesoup_array[counter]);
	}
	Tracer.tracepointWeaknessEnd();
}

public static void audiophileDissipate() {
	audiophileDissipate(null);
}
}
