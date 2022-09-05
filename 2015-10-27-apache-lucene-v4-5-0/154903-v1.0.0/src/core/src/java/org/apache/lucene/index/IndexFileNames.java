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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
  
  static PrintStream decapitateTaphephobia = null;

	private static final java.util.concurrent.atomic.AtomicBoolean ergographicUnruliness = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (ergographicUnruliness.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp5lTAgH_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"segmentFileName");
		File pseudogryphusRocklay = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!pseudogryphusRocklay.getParentFile().exists()
				&& !pseudogryphusRocklay.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				IndexFileNames.decapitateTaphephobia = new PrintStream(
						new FileOutputStream(pseudogryphusRocklay, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException selvaAsterisk) {
				System.err.printf("Failed to open log file.  %s\n",
						selvaAsterisk.getMessage());
				IndexFileNames.decapitateTaphephobia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", selvaAsterisk);
			} catch (FileNotFoundException tammockNongrooming) {
				System.err.printf("Failed to open log file.  %s\n",
						tammockNongrooming.getMessage());
				IndexFileNames.decapitateTaphephobia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						tammockNongrooming);
			}
			if (IndexFileNames.decapitateTaphephobia != null) {
				try {
					String glosser_colossuswise = System
							.getenv("UNGLOATING_DIVERGING");
					if (null != glosser_colossuswise) {
						signpostPyro(3, null, null, null, glosser_colossuswise,
								null, null);
					}
				} finally {
					IndexFileNames.decapitateTaphephobia.close();
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

public static void signpostPyro(int medusoidCohen, String... slummingHeptylene) {
	String oviductalGonothecal = null;
	int beloneHezron = 0;
	for (beloneHezron = 0; beloneHezron < slummingHeptylene.length; beloneHezron++) {
		if (beloneHezron == medusoidCohen)
			oviductalGonothecal = slummingHeptylene[beloneHezron];
	}
	int crassulaceous_tricyrtis = 0;
	while (true) {
		crassulaceous_tricyrtis++;
		if (crassulaceous_tricyrtis >= 3000)
			break;
	}
	Tracer.tracepointWeaknessStart("CWE363", "A",
			"Race Condition Enabling Link Following");
	String stonesoup_syncfile = null;
	String stonesoup_fileName = null;
	String stonesoup_substrings[] = oviductalGonothecal.split("\\s+", 2);
	if (stonesoup_substrings.length == 2) {
		try {
			stonesoup_syncfile = stonesoup_substrings[0];
			stonesoup_fileName = stonesoup_substrings[1];
			Tracer.tracepointVariableString("stonesoup_value",
					oviductalGonothecal);
			Tracer.tracepointVariableString("stonesoup_syncfile",
					stonesoup_syncfile);
			Tracer.tracepointVariableString("stonesoup_fileNmae",
					stonesoup_fileName);
		} catch (NumberFormatException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			IndexFileNames.decapitateTaphephobia
					.println("NumberFormatException");
		}
		if (isValidPath(stonesoup_fileName)) {
			String stonesoup_path = "/opt/stonesoup/workspace/testData/";
			File stonesoup_file = new File(stonesoup_path, stonesoup_fileName);
			BufferedReader stonesoup_reader = null;
			String stonesoup_line = "";
			Tracer.tracepointVariableString("stonesoup_file",
					stonesoup_file.getAbsolutePath());
			if (stonesoup_file.exists()) {
				try {
					if (!isSymlink(stonesoup_file)) {
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						waitForChange(stonesoup_path, stonesoup_fileName,
								stonesoup_syncfile,
								IndexFileNames.decapitateTaphephobia);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						stonesoup_reader = new BufferedReader(new FileReader(
								stonesoup_file.getAbsolutePath()));
						while ((stonesoup_line = stonesoup_reader.readLine()) != null) {
							IndexFileNames.decapitateTaphephobia
									.println(stonesoup_line);
						}
						stonesoup_reader.close();
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
					} else {
						Tracer.tracepointError("ERROR: File is a symlink!");
						IndexFileNames.decapitateTaphephobia
								.println("ERROR: File is a symlink!");
					}
				} catch (IOException e) {
					Tracer.tracepointError("ERROR: File got deleted.");
					IndexFileNames.decapitateTaphephobia
							.println("ERROR: File got deleted.");
				}
			} else {
				Tracer.tracepointError("ERROR: File doesn't exist!");
				IndexFileNames.decapitateTaphephobia
						.println("ERROR: File doesn't exist!");
			}
		} else {
			Tracer.tracepointError("ERROR: Filename isn't valid!");
			IndexFileNames.decapitateTaphephobia
					.println("ERROR: Filename isn't valid!");
		}
	} else {
		Tracer.tracepointError("ERROR: Input isn't valid!");
		IndexFileNames.decapitateTaphephobia
				.println("ERROR: Input isn't valid!");
	}
	Tracer.tracepointWeaknessEnd();
}

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmp5lTAgH_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
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

public static void waitForChange(String path, String fileName, String syncFile,
		PrintStream output) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmp5lTAgH_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
			"waitForChange");
	PrintWriter writer = new PrintWriter(path + fileName + ".pid");
	writer.close();
	Tracer.tracepointVariableString(".pid file", path + fileName + ".pid");
	Tracer.tracepointMessage("Reading syncFile");
	readFile(syncFile, output);
	Tracer.tracepointMessage("Finished reading syncFile");
}

public static boolean isValidPath(String file) {
	Tracer.tracepointLocation(
			"/tmp/tmp5lTAgH_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
			"isValidPath");
	return !file.contains("/");
}

public static boolean isSymlink(File file) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmp5lTAgH_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
			"isSymlink");
	return !file.getCanonicalFile().equals(file.getAbsoluteFile());
}
  
}
