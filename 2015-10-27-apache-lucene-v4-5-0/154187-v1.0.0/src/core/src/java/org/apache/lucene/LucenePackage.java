package org.apache.lucene;

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

/** Lucene's package information, including version. **/
public final class LucenePackage {

  static PrintStream tetanizeNolition = null;
	private static final java.util.concurrent.atomic.AtomicBoolean drawfilingGooselike = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (drawfilingGooselike.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpWnoZHy_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File progymnasiumSherman = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!progymnasiumSherman.getParentFile().exists()
				&& !progymnasiumSherman.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.tetanizeNolition = new PrintStream(
						new FileOutputStream(progymnasiumSherman, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException preconsignColor) {
				System.err.printf("Failed to open log file.  %s\n",
						preconsignColor.getMessage());
				LucenePackage.tetanizeNolition = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", preconsignColor);
			} catch (FileNotFoundException sargassumVitellogenous) {
				System.err.printf("Failed to open log file.  %s\n",
						sargassumVitellogenous.getMessage());
				LucenePackage.tetanizeNolition = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						sargassumVitellogenous);
			}
			if (LucenePackage.tetanizeNolition != null) {
				try {
					String meriquinoidal_unboldness = System
							.getenv("MERIQUINOIDAL_MISCREATE");
					if (null != meriquinoidal_unboldness) {
						Object blankeel_satellitious = meriquinoidal_unboldness;
						Tracer.tracepointWeaknessStart("CWE252", "B",
								"Unchecked Return");
						try {
							final int STONESOUP_BUFFER_SIZE = 2048;
							String stonesoup_sensitiveFName = ((String) blankeel_satellitious);
							String stonesoup_otherFName = System
									.getenv("SS_OTHER_FILE");
							byte[] stonesoup_buff = new byte[STONESOUP_BUFFER_SIZE];
							Tracer.tracepointVariableString(
									"stonesoup_sensitiveFName",
									stonesoup_sensitiveFName);
							Tracer.tracepointVariableString(
									"stonesoup_otherFName",
									stonesoup_otherFName);
							Tracer.tracepointBufferInfo("stonesoup_buff",
									stonesoup_buff.length,
									"Length of stonesoup_buff");
							java.io.InputStream stonesoup_sensitiveFile = new java.io.FileInputStream(
									stonesoup_sensitiveFName);
							java.io.InputStream stonesoup_otherFile = new java.io.FileInputStream(
									stonesoup_otherFName);
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							stonesoup_sensitiveFile.read(stonesoup_buff);
							stonesoup_sensitiveFile.close();
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
							stonesoup_otherFile.read(stonesoup_buff);
							stonesoup_otherFile.close();
							Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							String output_data = new String(stonesoup_buff);
							Tracer.tracepointVariableString("output_data",
									output_data);
							LucenePackage.tetanizeNolition
									.println("Output is:\n" + output_data);
						} catch (java.io.IOException ioe) {
							Tracer.tracepointError(ioe.getClass().getName()
									+ ": " + ioe.getMessage());
							LucenePackage.tetanizeNolition
									.println("STONESOUP: Error accessing files");
							ioe.printStackTrace(LucenePackage.tetanizeNolition);
						}
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					LucenePackage.tetanizeNolition.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
