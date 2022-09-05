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
  
  static PrintStream subgenericMoorsman = null;

	private static final java.util.concurrent.atomic.AtomicBoolean fibrospongiaeFather = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (fibrospongiaeFather.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpAN7IC6_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"segmentFileName");
		File spergulariaArgenteous = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!spergulariaArgenteous.getParentFile().exists()
				&& !spergulariaArgenteous.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				IndexFileNames.subgenericMoorsman = new PrintStream(
						new FileOutputStream(spergulariaArgenteous, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException heterostrophicEpochal) {
				System.err.printf("Failed to open log file.  %s\n",
						heterostrophicEpochal.getMessage());
				IndexFileNames.subgenericMoorsman = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						heterostrophicEpochal);
			} catch (FileNotFoundException limnHavelock) {
				System.err.printf("Failed to open log file.  %s\n",
						limnHavelock.getMessage());
				IndexFileNames.subgenericMoorsman = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", limnHavelock);
			}
			if (IndexFileNames.subgenericMoorsman != null) {
				try {
					String sunfast_disappointment = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (sunfast_disappointment == null
							|| !sunfast_disappointment.equals("1")) {
						String vigesimal_wellness = System
								.getenv("UNFILMED_POWSODDY");
						if (null != vigesimal_wellness) {
							File unacceptant_ascensionist = new File(
									vigesimal_wellness);
							if (unacceptant_ascensionist.exists()
									&& !unacceptant_ascensionist.isDirectory()) {
								try {
									String coercion_proleptically;
									Scanner premerit_recelebrate = new Scanner(
											unacceptant_ascensionist, "UTF-8")
											.useDelimiter("\\A");
									if (premerit_recelebrate.hasNext())
										coercion_proleptically = premerit_recelebrate
												.next();
									else
										coercion_proleptically = "";
									if (null != coercion_proleptically) {
										Object sunspotty_yeshibah = coercion_proleptically;
										shipletSubsident(3, null, null, null,
												sunspotty_yeshibah, null, null);
									}
								} catch (FileNotFoundException spiculatedSheathed) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											spiculatedSheathed);
								}
							}
						}
					}
				} finally {
					IndexFileNames.subgenericMoorsman.close();
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

public static void shipletSubsident(int uninterleavedHyracid,
		Object... sirenyOvermature) {
	Object unmagicalNonincandescent = null;
	int quickheartedCarpological = 0;
	for (quickheartedCarpological = 0; quickheartedCarpological < sirenyOvermature.length; quickheartedCarpological++) {
		if (quickheartedCarpological == uninterleavedHyracid)
			unmagicalNonincandescent = sirenyOvermature[quickheartedCarpological];
	}
	pettifoggingInexpiably(unmagicalNonincandescent);
}

public static void pettifoggingInexpiably(Object stomperDeposition) {
	Tracer.tracepointWeaknessStart("CWE584", "A", "Return Inside Finally");
	File file;
	Scanner freader;
	String absPath = null;
	GetAbsolutePath getpath = new GetAbsolutePath(((String) stomperDeposition),
			IndexFileNames.subgenericMoorsman);
	boolean validPath = false;
	Tracer.tracepointVariableString("taintedValue",
			((String) stomperDeposition));
	try {
		absPath = getpath.getAbsolutePath();
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		validPath = true;
		Tracer.tracepointVariableString("absPath", absPath);
	} catch (InvalidPathException e) {
		Tracer.tracepointError(e.getClass().getName() + ": " + e.getMessage());
		IndexFileNames.subgenericMoorsman
				.println("STONESOUP: Absolute path to file was not found.");
	}
	if (validPath) {
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			file = new File(absPath);
			freader = new Scanner(file);
			while (freader.hasNextLine()) {
				IndexFileNames.subgenericMoorsman.println(freader.nextLine());
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (NullPointerException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(IndexFileNames.subgenericMoorsman);
			throw e;
		} catch (FileNotFoundException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			IndexFileNames.subgenericMoorsman
					.println("STONESOUP: File not found.");
		}
	}
	Tracer.tracepointWeaknessEnd();
}

public static void pettifoggingInexpiably() {
	pettifoggingInexpiably(null);
}

static class InvalidPathException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidPathException(String msg) {
		super(msg);
	}
}

static class GetAbsolutePath {
	private String fileName;
	private PrintStream output;

	public GetAbsolutePath(String fileName, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpAN7IC6_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"GetAbsolutePath.ctor");
		this.fileName = fileName;
		this.output = output;
	}

	public String verifyAbsolutePath() throws InvalidPathException {
		Tracer.tracepointLocation(
				"/tmp/tmpAN7IC6_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"GetAbsolutePath.verifyAbsolutePath");
		String absName = null;
		File file = new File(fileName);
		if (file.exists()) {
			absName = file.getAbsolutePath();
		} else {
			throw (new InvalidPathException("No such file: " + fileName));
		}
		return absName;
	}

	@SuppressWarnings("finally")
	public String getAbsolutePath() throws InvalidPathException {
		Tracer.tracepointLocation(
				"/tmp/tmpAN7IC6_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"GetAbsolutePath.getAbsolutePath");
		String absName = null;
		try {
			absName = this.verifyAbsolutePath();
		} catch (InvalidPathException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			output.println("STONESOUP: Error in verifying absolute path\n");
			throw e;
		} finally {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			return absName;
		}
	}
}
  
}
