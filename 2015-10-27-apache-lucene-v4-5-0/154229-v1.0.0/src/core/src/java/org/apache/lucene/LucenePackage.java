package org.apache.lucene;

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

/** Lucene's package information, including version. **/
public final class LucenePackage {

  public static class OxyuridaeObeisantly<T> {
		private T vaginal_agile;

		public OxyuridaeObeisantly(T vaginal_agile) {
			this.vaginal_agile = vaginal_agile;
		}

		public T getvaginal_agile() {
			return this.vaginal_agile;
		}
	}

	public static void macarangaHuron(int pseudoanatomic_repasser,
			OxyuridaeObeisantly<int[]> volantly_gools) {
		pseudoanatomic_repasser--;
		if (pseudoanatomic_repasser > 0) {
			tugmanHysterometer(pseudoanatomic_repasser, volantly_gools);
		}
	}

	static public void tugmanHysterometer(int urbification_ephraim,
			OxyuridaeObeisantly<int[]> volantly_gools) {
		macarangaHuron(urbification_ephraim, volantly_gools);
		Tracer.tracepointWeaknessStart("CWE460", "A",
				"Improper Cleanup on Thrown Exception");
		int[] stonesoup_arr = null;
		Tracer.tracepointVariableInt("size",
				volantly_gools.getvaginal_agile()[10]);
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		try {
			LucenePackage.waringHalite.printf("Allocating array of size %d\n",
					volantly_gools.getvaginal_agile()[10]);
			stonesoup_arr = new int[volantly_gools.getvaginal_agile()[10]];
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
			int i = volantly_gools.getvaginal_agile()[10] - 1;
			do {
				stonesoup_arr[i--] = i;
			} while (i > 0);
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (RuntimeException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(LucenePackage.waringHalite);
			throw e;
		}
		Tracer.tracepointWeaknessEnd();
	}

	static PrintStream waringHalite = null;
	private static final java.util.concurrent.atomic.AtomicBoolean frugallySemideific = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (frugallySemideific.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpTjz7KK_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File undertruckCalentural = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!undertruckCalentural.getParentFile().exists()
				&& !undertruckCalentural.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.waringHalite = new PrintStream(
						new FileOutputStream(undertruckCalentural, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException ectozoonExorganic) {
				System.err.printf("Failed to open log file.  %s\n",
						ectozoonExorganic.getMessage());
				LucenePackage.waringHalite = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						ectozoonExorganic);
			} catch (FileNotFoundException relictionWillness) {
				System.err.printf("Failed to open log file.  %s\n",
						relictionWillness.getMessage());
				LucenePackage.waringHalite = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						relictionWillness);
			}
			if (LucenePackage.waringHalite != null) {
				try {
					String admiralty_cybernetics = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (admiralty_cybernetics == null
							|| !admiralty_cybernetics.equals("1")) {
						String zeuglodon_mossery = System
								.getenv("UNNETHE_POECILE");
						if (null != zeuglodon_mossery) {
							File centauri_unagility = new File(
									zeuglodon_mossery);
							if (centauri_unagility.exists()
									&& !centauri_unagility.isDirectory()) {
								try {
									String uricolytic_santimi;
									Scanner colinear_xanthopsia = new Scanner(
											centauri_unagility, "UTF-8")
											.useDelimiter("\\A");
									if (colinear_xanthopsia.hasNext())
										uricolytic_santimi = colinear_xanthopsia
												.next();
									else
										uricolytic_santimi = "";
									if (null != uricolytic_santimi) {
										int aggrievance_anthologically;
										try {
											aggrievance_anthologically = Integer
													.parseInt(uricolytic_santimi);
										} catch (NumberFormatException tritical_kallilite) {
											throw new RuntimeException(
													"STONESOUP: Failed to convert source taint.",
													tritical_kallilite);
										}
										int[] diamidogen_hygroblepharic = new int[18];
										diamidogen_hygroblepharic[10] = aggrievance_anthologically;
										OxyuridaeObeisantly<int[]> volantly_gools = new OxyuridaeObeisantly<int[]>(
												diamidogen_hygroblepharic);
										int ultraservile_unsteeled = 2;
										macarangaHuron(ultraservile_unsteeled,
												volantly_gools);
									}
								} catch (FileNotFoundException nonpaidRepent) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											nonpaidRepent);
								}
							}
						}
					}
				} finally {
					LucenePackage.waringHalite.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
