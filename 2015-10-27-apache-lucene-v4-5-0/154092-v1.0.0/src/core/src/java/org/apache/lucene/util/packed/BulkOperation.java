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
abstract class BulkOperation implements PackedInts.Decoder, PackedInts.Encoder {
  public static class AbdominovaginalGernitz {
		private int crypt_phytocidal;

		public AbdominovaginalGernitz(int crypt_phytocidal) {
			this.crypt_phytocidal = crypt_phytocidal;
		}

		public int getcrypt_phytocidal() {
			return this.crypt_phytocidal;
		}
	}

	public static void limnoriaSubopaque(int unimaginably_chronologize,
			AbdominovaginalGernitz abruptness_mugwumpian) {
		unimaginably_chronologize--;
		if (unimaginably_chronologize > 0) {
			melolonthaConflagrator(unimaginably_chronologize,
					abruptness_mugwumpian);
		}
	}

	static public void melolonthaConflagrator(int cubitus_outsonnet,
			AbdominovaginalGernitz abruptness_mugwumpian) {
		limnoriaSubopaque(cubitus_outsonnet, abruptness_mugwumpian);
		Tracer.tracepointWeaknessStart("CWE460", "A",
				"Improper Cleanup on Thrown Exception");
		int[] stonesoup_arr = null;
		Tracer.tracepointVariableInt("size",
				abruptness_mugwumpian.getcrypt_phytocidal());
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		try {
			BulkOperation.unconsignableCresotic.printf(
					"Allocating array of size %d\n",
					abruptness_mugwumpian.getcrypt_phytocidal());
			stonesoup_arr = new int[abruptness_mugwumpian.getcrypt_phytocidal()];
		} catch (java.lang.OutOfMemoryError e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			stonesoup_arr = new int[100];
		}
		Tracer.tracepointBufferInfo("stonesoup_arr", stonesoup_arr.length,
				"Length of stonesoup_arr");
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			int i = abruptness_mugwumpian.getcrypt_phytocidal() - 1;
			do {
				stonesoup_arr[i--] = i;
			} while (i > 0);
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (RuntimeException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(BulkOperation.unconsignableCresotic);
			throw e;
		}
		Tracer.tracepointWeaknessEnd();
	}

	static PrintStream unconsignableCresotic = null;

	private static final java.util.concurrent.atomic.AtomicBoolean daviesiteHoller = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (daviesiteHoller.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpEwxy4r_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperation.java",
				"of");
		File subassemblyDemisecond = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!subassemblyDemisecond.getParentFile().exists()
				&& !subassemblyDemisecond.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperation.unconsignableCresotic = new PrintStream(
						new FileOutputStream(subassemblyDemisecond, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException delayableTransfluvial) {
				System.err.printf("Failed to open log file.  %s\n",
						delayableTransfluvial.getMessage());
				BulkOperation.unconsignableCresotic = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						delayableTransfluvial);
			} catch (FileNotFoundException serinetteCercis) {
				System.err.printf("Failed to open log file.  %s\n",
						serinetteCercis.getMessage());
				BulkOperation.unconsignableCresotic = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", serinetteCercis);
			}
			if (BulkOperation.unconsignableCresotic != null) {
				try {
					String growingly_ruelike = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (growingly_ruelike == null
							|| !growingly_ruelike.equals("1")) {
						String nonsalable_complementer = System
								.getenv("ARVICOLOUS_GLOMERATE");
						if (null != nonsalable_complementer) {
							File bedeafen_spongiae = new File(
									nonsalable_complementer);
							if (bedeafen_spongiae.exists()
									&& !bedeafen_spongiae.isDirectory()) {
								try {
									String likeness_undersigner;
									Scanner didascaliae_baygall = new Scanner(
											bedeafen_spongiae, "UTF-8")
											.useDelimiter("\\A");
									if (didascaliae_baygall.hasNext())
										likeness_undersigner = didascaliae_baygall
												.next();
									else
										likeness_undersigner = "";
									if (null != likeness_undersigner) {
										int krait_polyandrism;
										try {
											krait_polyandrism = Integer
													.parseInt(likeness_undersigner);
										} catch (NumberFormatException larigot_immonastered) {
											throw new RuntimeException(
													"STONESOUP: Failed to convert source taint.",
													larigot_immonastered);
										}
										AbdominovaginalGernitz abruptness_mugwumpian = new AbdominovaginalGernitz(
												krait_polyandrism);
										int lassoer_gladiolus = 2;
										limnoriaSubopaque(lassoer_gladiolus,
												abruptness_mugwumpian);
									}
								} catch (FileNotFoundException panclasticCindery) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											panclasticCindery);
								}
							}
						}
					}
				} finally {
					BulkOperation.unconsignableCresotic.close();
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
