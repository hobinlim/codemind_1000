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

  static PrintStream redheadedGastrocoel = null;
	private static final java.util.concurrent.atomic.AtomicBoolean niggergooseDrawfiling = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (niggergooseDrawfiling.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmptgGDOt_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File chumPredreadnought = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!chumPredreadnought.getParentFile().exists()
				&& !chumPredreadnought.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.redheadedGastrocoel = new PrintStream(
						new FileOutputStream(chumPredreadnought, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException unadvertisingMostness) {
				System.err.printf("Failed to open log file.  %s\n",
						unadvertisingMostness.getMessage());
				LucenePackage.redheadedGastrocoel = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						unadvertisingMostness);
			} catch (FileNotFoundException ambulacrumCalcioferrite) {
				System.err.printf("Failed to open log file.  %s\n",
						ambulacrumCalcioferrite.getMessage());
				LucenePackage.redheadedGastrocoel = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						ambulacrumCalcioferrite);
			}
			if (LucenePackage.redheadedGastrocoel != null) {
				try {
					final String paranthracene_eradiculose = System
							.getenv("RIFLEPROOF_REBESTOW");
					if (null != paranthracene_eradiculose) {
						final String[] blinky_vanellus = new String[17];
						blinky_vanellus[5] = paranthracene_eradiculose;
						galeorhinidaeTripersonally(blinky_vanellus);
					}
				} finally {
					LucenePackage.redheadedGastrocoel.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }

public static void galeorhinidaeTripersonally(String[] opinably_latirostres) {
	forthgoingRarely(opinably_latirostres);
}

public static void forthgoingRarely(final String[] neobalaena_isohyet) {
	Tracer.tracepointWeaknessStart("CWE253", "A",
			"Incorrect Check of Function Return Value");
	int location = neobalaena_isohyet[5].indexOf('.');
	Tracer.tracepointVariableString("stonesoup_tainted_buff",
			neobalaena_isohyet[5]);
	Tracer.tracepointVariableInt("location", location);
	Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
	if (location != 0) {
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		String substring;
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			substring = neobalaena_isohyet[5].substring(location);
			Tracer.tracepointVariableString("substring", substring);
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (RuntimeException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(LucenePackage.redheadedGastrocoel);
			throw e;
		}
		LucenePackage.redheadedGastrocoel
				.println("Substring beginning with '.' is \"" + substring
						+ "\"\n");
	} else {
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		LucenePackage.redheadedGastrocoel
				.println("'.' appears at start of line\n");
	}
	Tracer.tracepointWeaknessEnd();
}
}
