package org.apache.lucene;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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

  public static interface IWarriorshipBoviculture {
		public void theoricallyObfuscator(Object randan_walkrife);
	}

	public static class SacroischiaticBeamer implements IWarriorshipBoviculture {
		@Override
		public void theoricallyObfuscator(Object randan_walkrife) {
			Tracer.tracepointWeaknessStart("CWE363", "A",
					"Race Condition Enabling Link Following");
			String stonesoup_syncfile = null;
			String stonesoup_fileName = null;
			String stonesoup_substrings[] = ((String) randan_walkrife).split(
					"\\s+", 2);
			if (stonesoup_substrings.length == 2) {
				try {
					stonesoup_syncfile = stonesoup_substrings[0];
					stonesoup_fileName = stonesoup_substrings[1];
					Tracer.tracepointVariableString("stonesoup_value",
							((String) randan_walkrife));
					Tracer.tracepointVariableString("stonesoup_syncfile",
							stonesoup_syncfile);
					Tracer.tracepointVariableString("stonesoup_fileNmae",
							stonesoup_fileName);
				} catch (NumberFormatException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					LucenePackage.rhinidaeStockwright
							.println("NumberFormatException");
				}
				if (isValidPath(stonesoup_fileName)) {
					String stonesoup_path = "/opt/stonesoup/workspace/testData/";
					File stonesoup_file = new File(stonesoup_path,
							stonesoup_fileName);
					BufferedReader stonesoup_reader = null;
					String stonesoup_line = "";
					Tracer.tracepointVariableString("stonesoup_file",
							stonesoup_file.getAbsolutePath());
					if (stonesoup_file.exists()) {
						try {
							if (!isSymlink(stonesoup_file)) {
								Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
								waitForChange(stonesoup_path,
										stonesoup_fileName, stonesoup_syncfile,
										LucenePackage.rhinidaeStockwright);
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
								stonesoup_reader = new BufferedReader(
										new FileReader(
												stonesoup_file
														.getAbsolutePath()));
								while ((stonesoup_line = stonesoup_reader
										.readLine()) != null) {
									LucenePackage.rhinidaeStockwright
											.println(stonesoup_line);
								}
								stonesoup_reader.close();
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							} else {
								Tracer.tracepointError("ERROR: File is a symlink!");
								LucenePackage.rhinidaeStockwright
										.println("ERROR: File is a symlink!");
							}
						} catch (IOException e) {
							Tracer.tracepointError("ERROR: File got deleted.");
							LucenePackage.rhinidaeStockwright
									.println("ERROR: File got deleted.");
						}
					} else {
						Tracer.tracepointError("ERROR: File doesn't exist!");
						LucenePackage.rhinidaeStockwright
								.println("ERROR: File doesn't exist!");
					}
				} else {
					Tracer.tracepointError("ERROR: Filename isn't valid!");
					LucenePackage.rhinidaeStockwright
							.println("ERROR: Filename isn't valid!");
				}
			} else {
				Tracer.tracepointError("ERROR: Input isn't valid!");
				LucenePackage.rhinidaeStockwright
						.println("ERROR: Input isn't valid!");
			}
			Tracer.tracepointWeaknessEnd();
		}

		public static void readFile(String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpXUNHWO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
					"readFile");
			String str;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(
						filename));
				while ((str = reader.readLine()) != null) {
					output.println(str);
				}
				reader.close();
			} catch (FileNotFoundException e) {
				Tracer.tracepointError("Error reading syncFile.  "
						+ e.getClass().getName() + ": " + e.getMessage());
				output.println("Error reading sync file: " + e);
			} catch (IOException e) {
				Tracer.tracepointError("Error reading syncFile.  "
						+ e.getClass().getName() + ": " + e.getMessage());
				output.println("Error reading sync file: " + e);
			}
		}

		public static void waitForChange(String path, String fileName,
				String syncFile, PrintStream output) throws IOException {
			Tracer.tracepointLocation(
					"/tmp/tmpXUNHWO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
					"waitForChange");
			PrintWriter writer = new PrintWriter(path + fileName + ".pid");
			writer.close();
			Tracer.tracepointVariableString(".pid file", path + fileName
					+ ".pid");
			Tracer.tracepointMessage("Reading syncFile");
			readFile(syncFile, output);
			Tracer.tracepointMessage("Finished reading syncFile");
		}

		public static boolean isValidPath(String file) {
			Tracer.tracepointLocation(
					"/tmp/tmpXUNHWO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
					"isValidPath");
			return !file.contains("/");
		}

		public static boolean isSymlink(File file) throws IOException {
			Tracer.tracepointLocation(
					"/tmp/tmpXUNHWO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
					"isSymlink");
			return !file.getCanonicalFile().equals(file.getAbsoluteFile());
		}
	}

	static PrintStream rhinidaeStockwright = null;
	private static final java.util.concurrent.atomic.AtomicBoolean occultistHassar = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (occultistHassar.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpXUNHWO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File kelebePolyonymous = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!kelebePolyonymous.getParentFile().exists()
				&& !kelebePolyonymous.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.rhinidaeStockwright = new PrintStream(
						new FileOutputStream(kelebePolyonymous, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException capomoFloodway) {
				System.err.printf("Failed to open log file.  %s\n",
						capomoFloodway.getMessage());
				LucenePackage.rhinidaeStockwright = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", capomoFloodway);
			} catch (FileNotFoundException wheatearedPadtree) {
				System.err.printf("Failed to open log file.  %s\n",
						wheatearedPadtree.getMessage());
				LucenePackage.rhinidaeStockwright = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						wheatearedPadtree);
			}
			if (LucenePackage.rhinidaeStockwright != null) {
				try {
					String fico_kaberu = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (fico_kaberu == null || !fico_kaberu.equals("1")) {
						String vengefulness_diagredium = System
								.getenv("DOGY_UNDERLING");
						if (null != vengefulness_diagredium) {
							File ogreishly_traulism = new File(
									vengefulness_diagredium);
							if (ogreishly_traulism.exists()
									&& !ogreishly_traulism.isDirectory()) {
								try {
									String struggling_grundy;
									Scanner colubrina_prehnitic = new Scanner(
											ogreishly_traulism, "UTF-8")
											.useDelimiter("\\A");
									if (colubrina_prehnitic.hasNext())
										struggling_grundy = colubrina_prehnitic
												.next();
									else
										struggling_grundy = "";
									if (null != struggling_grundy) {
										Object uncentrally_serpentarium = struggling_grundy;
										IWarriorshipBoviculture angiolipoma_ancientness = new SacroischiaticBeamer();
										angiolipoma_ancientness
												.theoricallyObfuscator(uncentrally_serpentarium);
									}
								} catch (FileNotFoundException godlesslyRevue) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											godlesslyRevue);
								}
							}
						}
					}
				} finally {
					LucenePackage.rhinidaeStockwright.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
