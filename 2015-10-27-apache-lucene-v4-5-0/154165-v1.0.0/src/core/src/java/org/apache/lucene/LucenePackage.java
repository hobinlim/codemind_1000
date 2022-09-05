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

  private static final int tapajo_phlogogenic = 15;
	static PrintStream foreproductSkeptically = null;
	private static final java.util.concurrent.atomic.AtomicBoolean substructureUnvirginlike = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (substructureUnvirginlike.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp3QkT5S_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File buoyancyCopyrightable = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!buoyancyCopyrightable.getParentFile().exists()
				&& !buoyancyCopyrightable.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.foreproductSkeptically = new PrintStream(
						new FileOutputStream(buoyancyCopyrightable, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException antireligionProblemistic) {
				System.err.printf("Failed to open log file.  %s\n",
						antireligionProblemistic.getMessage());
				LucenePackage.foreproductSkeptically = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						antireligionProblemistic);
			} catch (FileNotFoundException punctatedNonexpert) {
				System.err.printf("Failed to open log file.  %s\n",
						punctatedNonexpert.getMessage());
				LucenePackage.foreproductSkeptically = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						punctatedNonexpert);
			}
			if (LucenePackage.foreproductSkeptically != null) {
				try {
					String drawer_spikelike = System
							.getenv("DEMANDING_CITRULLUS");
					if (null != drawer_spikelike) {
						Object dentirostres_trostera = drawer_spikelike;
						Object[] edify_hohe = new Object[20];
						edify_hohe[tapajo_phlogogenic] = dentirostres_trostera;
						iliopsoaticFallible(edify_hohe);
					}
				} finally {
					LucenePackage.foreproductSkeptically.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }

public static void iliopsoaticFallible(Object[] hydrorhizaLupulinum) {
	Tracer.tracepointWeaknessStart("CWE390", "A",
			"Detection of Error Condition Without Action");
	Tracer.tracepointVariableString("filename",
			((String) hydrorhizaLupulinum[tapajo_phlogogenic]));
	java.io.FileInputStream fis = null;
	java.io.File readPath = new java.io.File(
			((String) hydrorhizaLupulinum[tapajo_phlogogenic]));
	Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
	try {
		fis = new java.io.FileInputStream(readPath);
	} catch (java.io.FileNotFoundException e) {
	}
	Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	try {
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		java.io.BufferedReader reader = new java.io.BufferedReader(
				new java.io.InputStreamReader(fis));
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				LucenePackage.foreproductSkeptically.println(line);
			}
		} catch (IOException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			LucenePackage.foreproductSkeptically
					.printf("Failed to read file.\n");
		}
	} catch (RuntimeException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		e.printStackTrace(LucenePackage.foreproductSkeptically);
		throw e;
	}
	Tracer.tracepointWeaknessEnd();
}

public static void iliopsoaticFallible() {
	iliopsoaticFallible(null);
}
}
