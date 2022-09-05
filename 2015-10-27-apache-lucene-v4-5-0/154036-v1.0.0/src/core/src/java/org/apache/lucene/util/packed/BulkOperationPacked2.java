// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

  public class DigamyLandgravate<T> {
		private T scansionist_dioptrical;

		public DigamyLandgravate(T scansionist_dioptrical) {
			this.scansionist_dioptrical = scansionist_dioptrical;
		}

		public T getscansionist_dioptrical() {
			return this.scansionist_dioptrical;
		}
	}

	static PrintStream malignantlyOctroi = null;
	private static final java.util.concurrent.atomic.AtomicBoolean partialAdipolysis = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (partialAdipolysis.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpIolt66_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File waterscapeHorsecar = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!waterscapeHorsecar.getParentFile().exists()
				&& !waterscapeHorsecar.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.malignantlyOctroi = new PrintStream(
						new FileOutputStream(waterscapeHorsecar, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException oomycetousPrimogenitor) {
				System.err.printf("Failed to open log file.  %s\n",
						oomycetousPrimogenitor.getMessage());
				BulkOperationPacked2.malignantlyOctroi = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						oomycetousPrimogenitor);
			} catch (FileNotFoundException cottagersPlataleinae) {
				System.err.printf("Failed to open log file.  %s\n",
						cottagersPlataleinae.getMessage());
				BulkOperationPacked2.malignantlyOctroi = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						cottagersPlataleinae);
			}
			if (BulkOperationPacked2.malignantlyOctroi != null) {
				try {
					String apostaxis_franzy = System
							.getenv("SIRIANIAN_MOOLINGS");
					if (null != apostaxis_franzy) {
						String[] sparrowy_pleurotropous = new String[20];
						sparrowy_pleurotropous[16] = apostaxis_franzy;
						DigamyLandgravate<String[]> molossoid_wob = new DigamyLandgravate<String[]>(
								sparrowy_pleurotropous);
						youwardMicrotinae(molossoid_wob);
					}
				} finally {
					BulkOperationPacked2.malignantlyOctroi.close();
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

public static void youwardMicrotinae(
		DigamyLandgravate<String[]> acenaphthenylHaughty) {
	Tracer.tracepointWeaknessStart("CWE584", "A", "Return Inside Finally");
	File file;
	Scanner freader;
	String absPath = null;
	GetAbsolutePath getpath = new GetAbsolutePath(
			acenaphthenylHaughty.getscansionist_dioptrical()[16],
			BulkOperationPacked2.malignantlyOctroi);
	boolean validPath = false;
	Tracer.tracepointVariableString("taintedValue",
			acenaphthenylHaughty.getscansionist_dioptrical()[16]);
	try {
		absPath = getpath.getAbsolutePath();
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		validPath = true;
		Tracer.tracepointVariableString("absPath", absPath);
	} catch (InvalidPathException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		BulkOperationPacked2.malignantlyOctroi
				.println("STONESOUP: Absolute path to file was not found.");
	}
	if (validPath) {
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			file = new File(absPath);
			freader = new Scanner(file);
			while (freader.hasNextLine()) {
				BulkOperationPacked2.malignantlyOctroi.println(freader
						.nextLine());
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (NullPointerException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(BulkOperationPacked2.malignantlyOctroi);
			throw e;
		} catch (FileNotFoundException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			BulkOperationPacked2.malignantlyOctroi
					.println("STONESOUP: File not found.");
		}
	}
	Tracer.tracepointWeaknessEnd();
}

public static void youwardMicrotinae() {
	youwardMicrotinae(null);
}

static class InvalidPathException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPathException(String msg) {
		super(msg);
	}
}

static class GetAbsolutePath {
	private String fileName;
	private PrintStream output;

	public GetAbsolutePath(String fileName, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpIolt66_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"GetAbsolutePath.ctor");
		this.fileName = fileName;
		this.output = output;
	}

	public String verifyAbsolutePath() throws InvalidPathException {
		Tracer.tracepointLocation(
				"/tmp/tmpIolt66_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"GetAbsolutePath.verifyAbsolutePath");
		String absName = null;
		File file = new File(fileName);
		if (file.exists()) {
			absName = file.getAbsolutePath();
		} else {
			throw (new InvalidPathException("No such file: " + fileName));
		}
		return absName;
	}

	@SuppressWarnings("finally")
	public String getAbsolutePath() throws InvalidPathException {
		Tracer.tracepointLocation(
				"/tmp/tmpIolt66_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"GetAbsolutePath.getAbsolutePath");
		String absName = null;
		try {
			absName = this.verifyAbsolutePath();
		} catch (InvalidPathException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			output.println("STONESOUP: Error in verifying absolute path\n");
			throw e;
		} finally {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			return absName;
		}
	}
}

}
