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
import java.io.IOException;

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
  
  private static final int alcaligenes_parcook = 5;

	static PrintStream synergidExpiry = null;

	private static final java.util.concurrent.atomic.AtomicBoolean subbailiffVengeously = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (subbailiffVengeously.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmphay1Gz_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"stripExtension");
		File badmintonNutramin = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!badmintonNutramin.getParentFile().exists()
				&& !badmintonNutramin.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				IndexFileNames.synergidExpiry = new PrintStream(
						new FileOutputStream(badmintonNutramin, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException dentaryTaeniada) {
				System.err.printf("Failed to open log file.  %s\n",
						dentaryTaeniada.getMessage());
				IndexFileNames.synergidExpiry = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", dentaryTaeniada);
			} catch (FileNotFoundException tremendousHomoiothermism) {
				System.err.printf("Failed to open log file.  %s\n",
						tremendousHomoiothermism.getMessage());
				IndexFileNames.synergidExpiry = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						tremendousHomoiothermism);
			}
			if (IndexFileNames.synergidExpiry != null) {
				try {
					String reductase_discovenant = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (reductase_discovenant == null
							|| !reductase_discovenant.equals("1")) {
						String buckbush_endogastrically = System
								.getenv("REAPPROVAL_MOTHPROOF");
						if (null != buckbush_endogastrically) {
							File rattener_depancreatize = new File(
									buckbush_endogastrically);
							if (rattener_depancreatize.exists()
									&& !rattener_depancreatize.isDirectory()) {
								try {
									String pseudomorular_butting;
									Scanner circularization_unbetide = new Scanner(
											rattener_depancreatize, "UTF-8")
											.useDelimiter("\\A");
									if (circularization_unbetide.hasNext())
										pseudomorular_butting = circularization_unbetide
												.next();
									else
										pseudomorular_butting = "";
									if (null != pseudomorular_butting) {
										Object resuspect_dinornithoid = pseudomorular_butting;
										Object[] flagitate_apocarpous = new Object[19];
										flagitate_apocarpous[alcaligenes_parcook] = resuspect_dinornithoid;
										crummierSuperheat(flagitate_apocarpous);
									}
								} catch (FileNotFoundException nontribalGewgawish) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											nontribalGewgawish);
								}
							}
						}
					}
				} finally {
					IndexFileNames.synergidExpiry.close();
				}
			}
		}
	}
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

public static void crummierSuperheat(Object[] unclementlyNegrillo) {
	Tracer.tracepointWeaknessStart("CWE412", "A",
			"Unrestricted Externally Accessible Lock");
	File stonesoup_file = null;
	String stonesoup_path = "/opt/stonesoup/workspace/testData/";
	Tracer.tracepointVariableString("stonesoup_value",
			((String) unclementlyNegrillo[alcaligenes_parcook]));
	try {
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		stonesoup_file = new File(stonesoup_path,
				((String) unclementlyNegrillo[alcaligenes_parcook]));
		Tracer.tracepointVariableString("stonesoup_path", stonesoup_path);
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		IndexFileNames.synergidExpiry.println(stonesoup_path);
		Tracer.tracepointMessage("Attempting to grab file lock.");
		while (!stonesoup_file.createNewFile()) {
			Thread.sleep(1);
		}
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		Tracer.tracepointMessage("Grabbed file lock.");
		IndexFileNames.synergidExpiry.println("File Created");
		stonesoup_file.delete();
	} catch (IOException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		IndexFileNames.synergidExpiry.println("IOException");
	} catch (NullPointerException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		IndexFileNames.synergidExpiry.println("NullPointerException");
	} catch (InterruptedException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		IndexFileNames.synergidExpiry.println("InterruptedException");
	}
	Tracer.tracepointWeaknessEnd();
}

public static void crummierSuperheat() {
	crummierSuperheat(null);
}
  
}
