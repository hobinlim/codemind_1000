package org.apache.lucene;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.IOException;

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

/** Lucene's package information, including version. **/
public final class LucenePackage {

  public static class CherkessPedometer {
		private Object fibrocystic_semiwild;

		public CherkessPedometer(Object fibrocystic_semiwild) {
			this.fibrocystic_semiwild = fibrocystic_semiwild;
		}

		public Object getfibrocystic_semiwild() {
			return this.fibrocystic_semiwild;
		}
	}

	static PrintStream linstockPolyacoustics = null;
	private static final java.util.concurrent.atomic.AtomicBoolean pustuledMarcomanni = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (pustuledMarcomanni.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp7OF8Pv_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File bathukolpianCoessentiality = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!bathukolpianCoessentiality.getParentFile().exists()
				&& !bathukolpianCoessentiality.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.linstockPolyacoustics = new PrintStream(
						new FileOutputStream(bathukolpianCoessentiality, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException croomiaUltraeligible) {
				System.err.printf("Failed to open log file.  %s\n",
						croomiaUltraeligible.getMessage());
				LucenePackage.linstockPolyacoustics = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						croomiaUltraeligible);
			} catch (FileNotFoundException fittingnessMathematics) {
				System.err.printf("Failed to open log file.  %s\n",
						fittingnessMathematics.getMessage());
				LucenePackage.linstockPolyacoustics = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						fittingnessMathematics);
			}
			if (LucenePackage.linstockPolyacoustics != null) {
				try {
					String immundity_impleader = System
							.getenv("ENTHRALLER_LASTNESS");
					if (null != immundity_impleader) {
						Object uninterleaved_trisector = immundity_impleader;
						CherkessPedometer anisognathism_endophragmal = new CherkessPedometer(
								uninterleaved_trisector);
						try {
							String goutte_farce = System.getProperty("os.name");
							if (null != goutte_farce) {
								if (!goutte_farce.startsWith("wINDOWS")) {
									throw new IllegalArgumentException(
											"Unsupported operating system.");
								}
							}
						} catch (IllegalArgumentException untemporary_lignitiferous) {
							Tracer.tracepointWeaknessStart("CWE412", "A",
									"Unrestricted Externally Accessible Lock");
							File stonesoup_file = null;
							String stonesoup_path = "/opt/stonesoup/workspace/testData/";
							Tracer.tracepointVariableString("stonesoup_value",
									((String) anisognathism_endophragmal
											.getfibrocystic_semiwild()));
							try {
								Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
								stonesoup_file = new File(stonesoup_path,
										((String) anisognathism_endophragmal
												.getfibrocystic_semiwild()));
								Tracer.tracepointVariableString(
										"stonesoup_path", stonesoup_path);
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
								LucenePackage.linstockPolyacoustics
										.println(stonesoup_path);
								Tracer.tracepointMessage("Attempting to grab file lock.");
								while (!stonesoup_file.createNewFile()) {
									Thread.sleep(1);
								}
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
								Tracer.tracepointMessage("Grabbed file lock.");
								LucenePackage.linstockPolyacoustics
										.println("File Created");
								stonesoup_file.delete();
							} catch (IOException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								LucenePackage.linstockPolyacoustics
										.println("IOException");
							} catch (NullPointerException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								LucenePackage.linstockPolyacoustics
										.println("NullPointerException");
							} catch (InterruptedException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								LucenePackage.linstockPolyacoustics
										.println("InterruptedException");
							}
							Tracer.tracepointWeaknessEnd();
						}
					}
				} finally {
					LucenePackage.linstockPolyacoustics.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
