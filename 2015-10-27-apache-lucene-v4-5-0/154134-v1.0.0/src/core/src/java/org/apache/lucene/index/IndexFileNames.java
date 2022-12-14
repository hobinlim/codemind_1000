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
  
  static PrintStream tamiasContinent = null;

	private static final java.util.concurrent.atomic.AtomicBoolean drogherPreinherit = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (drogherPreinherit.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpPY4r_R_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"segmentFileName");
		File solipedousPosttreaty = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!solipedousPosttreaty.getParentFile().exists()
				&& !solipedousPosttreaty.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				IndexFileNames.tamiasContinent = new PrintStream(
						new FileOutputStream(solipedousPosttreaty, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException hayrackBlacktail) {
				System.err.printf("Failed to open log file.  %s\n",
						hayrackBlacktail.getMessage());
				IndexFileNames.tamiasContinent = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", hayrackBlacktail);
			} catch (FileNotFoundException adoratoryBerley) {
				System.err.printf("Failed to open log file.  %s\n",
						adoratoryBerley.getMessage());
				IndexFileNames.tamiasContinent = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", adoratoryBerley);
			}
			if (IndexFileNames.tamiasContinent != null) {
				try {
					String pycnodonti_lobotomy = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (pycnodonti_lobotomy == null
							|| !pycnodonti_lobotomy.equals("1")) {
						String haloid_resorcine = System
								.getenv("ALCOHOLYTIC_FUMET");
						if (null != haloid_resorcine) {
							File ungazing_chrysin = new File(haloid_resorcine);
							if (ungazing_chrysin.exists()
									&& !ungazing_chrysin.isDirectory()) {
								try {
									String phalangiidae_severingly;
									Scanner monotic_booly = new Scanner(
											ungazing_chrysin, "UTF-8")
											.useDelimiter("\\A");
									if (monotic_booly.hasNext())
										phalangiidae_severingly = monotic_booly
												.next();
									else
										phalangiidae_severingly = "";
									if (null != phalangiidae_severingly) {
										briqueCardiataxia(3, null, null, null,
												phalangiidae_severingly, null,
												null);
									}
								} catch (FileNotFoundException stoloniferousSidepiece) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											stoloniferousSidepiece);
								}
							}
						}
					}
				} finally {
					IndexFileNames.tamiasContinent.close();
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

public static void briqueCardiataxia(int mydriasisVillainously,
		String... sambaquiToxicologic) {
	String isopecticBelitter = null;
	int parcelUnsymmetrically = 0;
	for (parcelUnsymmetrically = 0; parcelUnsymmetrically < sambaquiToxicologic.length; parcelUnsymmetrically++) {
		if (parcelUnsymmetrically == mydriasisVillainously)
			isopecticBelitter = sambaquiToxicologic[parcelUnsymmetrically];
	}
	try {
		String nandu_dipteral = System.getProperty("os.name");
		if (null != nandu_dipteral) {
			if (!nandu_dipteral.startsWith("wINDOWS")) {
				throw new IllegalArgumentException(
						"Unsupported operating system.");
			}
		}
	} catch (IllegalArgumentException anthramine_micromyeloblast) {
		Tracer.tracepointWeaknessStart("CWE252", "A", "Unchecked Return Value");
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		String capitalized_value = stonesoup_to_upper(isopecticBelitter);
		Tracer.tracepointVariableString("capitalized_value", capitalized_value);
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		String password = "STONESOUP";
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			if (password.compareTo(capitalized_value) == 0) {
				IndexFileNames.tamiasContinent.println("passwords match");
			} else {
				IndexFileNames.tamiasContinent.println("passwords don't match");
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (NullPointerException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(IndexFileNames.tamiasContinent);
			throw e;
		}
		Tracer.tracepointWeaknessEnd();
	}
}

public static String stonesoup_to_upper(final String input) {
	Tracer.tracepointLocation(
			"/tmp/tmpPY4r_R_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
			"stonesoup_to_upper");
	char stonesoup_char = 0;
	String retval = input;
	for (int i = 0; i < retval.length(); i++) {
		stonesoup_char = retval.charAt(i);
		if (Character.isLowerCase(stonesoup_char)) {
			retval = retval.replace(stonesoup_char,
					Character.toUpperCase(stonesoup_char));
		} else if (!Character.isUpperCase(stonesoup_char)) {
			return null;
		}
	}
	return retval;
}
  
}
