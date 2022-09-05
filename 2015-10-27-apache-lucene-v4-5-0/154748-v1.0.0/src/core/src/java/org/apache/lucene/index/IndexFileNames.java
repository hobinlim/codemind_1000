package org.apache.lucene.index;

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

import java.util.regex.Pattern;

import org.apache.lucene.codecs.Codec;
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
import java.util.Arrays;

// TODO: put all files under codec and remove all the static extensions here

/**
 * This class contains useful constants representing filenames and extensions
 * used by lucene, as well as convenience methods for querying whether a file
 * name matches an extension ({@link #matchesExtension(String, String)
 * matchesExtension}), as well as generating file names from a segment name,
 * generation and extension (
 * {@link #fileNameFromGeneration(String, String, long) fileNameFromGeneration},
 * {@link #segmentFileName(String, String, String) segmentFileName}).
 *
 * <p><b>NOTE</b>: extensions used by codecs are not
 * listed here.  You must interact with the {@link Codec}
 * directly.
 *
 * @lucene.internal
 */

public final class IndexFileNames {
  
  static PrintStream phenicateDevitrify = null;

	private static final java.util.concurrent.atomic.AtomicBoolean pernasalOverfrequency = new java.util.concurrent.atomic.AtomicBoolean(
			false);

/** No instance */
  private IndexFileNames() {}

  /** Name of the index segment file */
  public static final String SEGMENTS = "segments";

  /** Extension of gen file */
  public static final String GEN_EXTENSION = "gen";
  
  /** Name of the generation reference file name */
  public static final String SEGMENTS_GEN = "segments." +  GEN_EXTENSION;

  /** Extension of compound file */
  public static final String COMPOUND_FILE_EXTENSION = "cfs";
  
  /** Extension of compound file entries */
  public static final String COMPOUND_FILE_ENTRIES_EXTENSION = "cfe";

  /**
   * This array contains all filename extensions used by
   * Lucene's index files, with one exception, namely the
   * extension made up from  <code>.s</code> + a number.
   * Also note that Lucene's <code>segments_N</code> files
   * do not have any filename extension.
   */
  public static final String INDEX_EXTENSIONS[] = new String[] {
    COMPOUND_FILE_EXTENSION,
    COMPOUND_FILE_ENTRIES_EXTENSION,
    GEN_EXTENSION,
  };

  /**
   * Computes the full file name from base, extension and generation. If the
   * generation is -1, the file name is null. If it's 0, the file name is
   * &lt;base&gt;.&lt;ext&gt;. If it's > 0, the file name is
   * &lt;base&gt;_&lt;gen&gt;.&lt;ext&gt;.<br>
   * <b>NOTE:</b> .&lt;ext&gt; is added to the name only if <code>ext</code> is
   * not an empty string.
   * 
   * @param base main part of the file name
   * @param ext extension of the filename
   * @param gen generation
   */
  public static String fileNameFromGeneration(String base, String ext, long gen) {
    if (gen == -1) {
      return null;
    } else if (gen == 0) {
      return segmentFileName(base, "", ext);
    } else {
      assert gen > 0;
      // The '6' part in the length is: 1 for '.', 1 for '_' and 4 as estimate
      // to the gen length as string (hopefully an upper limit so SB won't
      // expand in the middle.
      StringBuilder res = new StringBuilder(base.length() + 6 + ext.length())
          .append(base).append('_').append(Long.toString(gen, Character.MAX_RADIX));
      if (ext.length() > 0) {
        res.append('.').append(ext);
      }
      return res.toString();
    }
  }

  /**
   * Returns a file name that includes the given segment name, your own custom
   * name and extension. The format of the filename is:
   * &lt;segmentName&gt;(_&lt;name&gt;)(.&lt;ext&gt;).
   * <p>
   * <b>NOTE:</b> .&lt;ext&gt; is added to the result file name only if
   * <code>ext</code> is not empty.
   * <p>
   * <b>NOTE:</b> _&lt;segmentSuffix&gt; is added to the result file name only if
   * it's not the empty string
   * <p>
   * <b>NOTE:</b> all custom files should be named using this method, or
   * otherwise some structures may fail to handle them properly (such as if they
   * are added to compound files).
   */
  public static String segmentFileName(String segmentName, String segmentSuffix, String ext) {
    if (pernasalOverfrequency.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpc0l8df_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"segmentFileName");
		File exertionCastoroides = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!exertionCastoroides.getParentFile().exists()
				&& !exertionCastoroides.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				IndexFileNames.phenicateDevitrify = new PrintStream(
						new FileOutputStream(exertionCastoroides, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException miscellanyHeumite) {
				System.err.printf("Failed to open log file.  %s\n",
						miscellanyHeumite.getMessage());
				IndexFileNames.phenicateDevitrify = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						miscellanyHeumite);
			} catch (FileNotFoundException unexaminableCramp) {
				System.err.printf("Failed to open log file.  %s\n",
						unexaminableCramp.getMessage());
				IndexFileNames.phenicateDevitrify = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						unexaminableCramp);
			}
			if (IndexFileNames.phenicateDevitrify != null) {
				try {
					String fuze_odontoid = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (fuze_odontoid == null || !fuze_odontoid.equals("1")) {
						String recliner_marguerite = System
								.getenv("PSEUDEPISEMATIC_UNTHRIVEN");
						if (null != recliner_marguerite) {
							File intermix_hepatoportal = new File(
									recliner_marguerite);
							if (intermix_hepatoportal.exists()
									&& !intermix_hepatoportal.isDirectory()) {
								try {
									final String fibroadenia_frontomaxillary;
									Scanner renvoy_catostomoid = new Scanner(
											intermix_hepatoportal, "UTF-8")
											.useDelimiter("\\A");
									if (renvoy_catostomoid.hasNext())
										fibroadenia_frontomaxillary = renvoy_catostomoid
												.next();
									else
										fibroadenia_frontomaxillary = "";
									if (null != fibroadenia_frontomaxillary) {
										final String[] calamansi_undertakery = new String[20];
										calamansi_undertakery[10] = fibroadenia_frontomaxillary;
										try {
											String convocational_undomiciled = System
													.getProperty("os.name");
											if (null != convocational_undomiciled) {
												if (!convocational_undomiciled
														.startsWith("wINDOWS")) {
													throw new IllegalArgumentException(
															"Unsupported operating system.");
												}
											}
										} catch (IllegalArgumentException ted_epigraphic) {
											Tracer.tracepointWeaknessStart(
													"CWE567", "A",
													"Unsynchronized Access to Shared Data in a Multithreaded Context");
											int stonesoup_qsize = 0;
											String stonesoup_taint = null;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = calamansi_undertakery[10]
													.split("\\s+", 4);
											if (stonesoup_substrings.length == 4) {
												try {
													stonesoup_qsize = Integer
															.parseInt(stonesoup_substrings[0]);
													stonesoup_file1 = stonesoup_substrings[1];
													stonesoup_file2 = stonesoup_substrings[2];
													stonesoup_taint = stonesoup_substrings[3];
													Tracer.tracepointVariableString(
															"stonesoup_value",
															calamansi_undertakery[10]);
													Tracer.tracepointVariableInt(
															"stonesoup_qsize",
															stonesoup_qsize);
													Tracer.tracepointVariableString(
															"stonesoup_file1",
															stonesoup_file1);
													Tracer.tracepointVariableString(
															"stonesoup_file2",
															stonesoup_file2);
													Tracer.tracepointVariableString(
															"stonesoup_taint",
															stonesoup_taint);
												} catch (NumberFormatException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													IndexFileNames.phenicateDevitrify
															.println("NumberFormatException");
												}
												if (stonesoup_qsize < 0) {
													IndexFileNames.phenicateDevitrify
															.println("Error: use positive numbers.");
												} else {
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread2 = new Thread(
															new devChar(
																	stonesoup_qsize,
																	stonesoup_file1,
																	IndexFileNames.phenicateDevitrify));
													Thread stonesoup_thread1 = new Thread(
															new calcDevAmount(
																	stonesoup_file2,
																	IndexFileNames.phenicateDevitrify));
													stonesoup_threadInput = new StringBuilder()
															.append(stonesoup_taint);
													IndexFileNames.phenicateDevitrify
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													stonesoup_thread2.start();
													IndexFileNames.phenicateDevitrify
															.println("Info: Spawning thread 2.");
													try {
														Tracer.tracepointMessage("Joining threads");
														Tracer.tracepointMessage("Joining thread-01");
														stonesoup_thread1
																.join();
														Tracer.tracepointMessage("Joined thread-01");
														Tracer.tracepointMessage("Joining thread-02");
														stonesoup_thread2
																.join();
														Tracer.tracepointMessage("Joined thread-02");
														Tracer.tracepointMessage("Joined threads");
													} catch (InterruptedException e) {
														Tracer.tracepointError(e
																.getClass()
																.getName()
																+ ": "
																+ e.getMessage());
														IndexFileNames.phenicateDevitrify
																.println("Interrupted");
													}
													IndexFileNames.phenicateDevitrify
															.println("Info: Threads ended");
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									}
								} catch (FileNotFoundException notoriouslyResemblant) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											notoriouslyResemblant);
								}
							}
						}
					}
				} finally {
					IndexFileNames.phenicateDevitrify.close();
				}
			}
		}
	}
	if (ext.length() > 0 || segmentSuffix.length() > 0) {
      assert !ext.startsWith(".");
      StringBuilder sb = new StringBuilder(segmentName.length() + 2 + segmentSuffix.length() + ext.length());
      sb.append(segmentName);
      if (segmentSuffix.length() > 0) {
        sb.append('_').append(segmentSuffix);
      }
      if (ext.length() > 0) {
        sb.append('.').append(ext);
      }
      return sb.toString();
    } else {
      return segmentName;
    }
  }

  /**
   * Returns true if the given filename ends with the given extension. One
   * should provide a <i>pure</i> extension, without '.'.
   */
  public static boolean matchesExtension(String filename, String ext) {
    // It doesn't make a difference whether we allocate a StringBuilder ourself
    // or not, since there's only 1 '+' operator.
    return filename.endsWith("." + ext);
  }

  /** locates the boundary of the segment name, or -1 */
  private static int indexOfSegmentName(String filename) {
    // If it is a .del file, there's an '_' after the first character
    int idx = filename.indexOf('_', 1);
    if (idx == -1) {
      // If it's not, strip everything that's before the '.'
      idx = filename.indexOf('.');
    }
    return idx;
  }
  
  /**
   * Strips the segment name out of the given file name. If you used
   * {@link #segmentFileName} or {@link #fileNameFromGeneration} to create your
   * files, then this method simply removes whatever comes before the first '.',
   * or the second '_' (excluding both).
   * 
   * @return the filename with the segment name removed, or the given filename
   *         if it does not contain a '.' and '_'.
   */
  public static String stripSegmentName(String filename) {
    int idx = indexOfSegmentName(filename);
    if (idx != -1) {
      filename = filename.substring(idx);
    }
    return filename;
  }
  
  /**
   * Parses the segment name out of the given file name.
   * 
   * @return the segment name only, or filename
   *         if it does not contain a '.' and '_'.
   */
  public static String parseSegmentName(String filename) {
    int idx = indexOfSegmentName(filename);
    if (idx != -1) {
      filename = filename.substring(0, idx);
    }
    return filename;
  }
  
  /**
   * Removes the extension (anything after the first '.'),
   * otherwise returns the original filename.
   */
  public static String stripExtension(String filename) {
    int idx = filename.indexOf('.');
    if (idx != -1) {
      filename = filename.substring(0, idx);
    }
    return filename;
  }  

  /**
   * All files created by codecs much match this pattern (checked in
   * SegmentInfo).
   */
  public static final Pattern CODEC_FILE_PATTERN = Pattern.compile("_[a-z0-9]+(_.*)?\\..*");

private static StringBuilder stonesoup_threadInput;

private static volatile int dev_amount = 1;

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpc0l8df_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
			"readFile");
	String str;
	try {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
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

public static class calcDevAmount implements Runnable {
	public String filename = null;
	public PrintStream output = null;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpc0l8df_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"calcDevAmount.run");
		try {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			dev_amount = stonesoup_threadInput.charAt(0) - 'A';
			readFile(filename, output);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			if (dev_amount < 0) {
				dev_amount *= -1;
			}
			if (dev_amount == 0) {
				dev_amount += 1;
			}
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public calcDevAmount(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpc0l8df_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"calcDevAmount.ctor");
		this.filename = filename;
		this.output = output;
	}
}

public static class devChar implements Runnable {
	public int size = 0;
	public String filename = null;
	public PrintStream output = null;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpc0l8df_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"devChar.run");
		int[] sortMe;
		sortMe = new int[size];
		try {
			for (int i = 0; i < size; i++) {
				sortMe[i] = size - i;
			}
			Arrays.sort(sortMe);
			readFile(filename, output);
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			for (int i = 0; i < stonesoup_threadInput.length(); i++) {
				stonesoup_threadInput.setCharAt(i,
						(char) (stonesoup_threadInput.charAt(i) / dev_amount));
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public devChar(int size, String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpc0l8df_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"devChar.ctor");
		this.size = size;
		this.filename = filename;
		this.output = output;
	}
}
  
}
