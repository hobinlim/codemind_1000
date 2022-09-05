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
  
  static PrintStream undeededTongrian = null;

	private static final java.util.concurrent.atomic.AtomicBoolean splotherAffricated = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (splotherAffricated.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpdoPXGj_ss_testcase/src/core/src/java/org/apache/lucene/index/IndexFileNames.java",
				"fileNameFromGeneration");
		File unransomedParachordal = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!unransomedParachordal.getParentFile().exists()
				&& !unransomedParachordal.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				IndexFileNames.undeededTongrian = new PrintStream(
						new FileOutputStream(unransomedParachordal, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException terebinicAthrob) {
				System.err.printf("Failed to open log file.  %s\n",
						terebinicAthrob.getMessage());
				IndexFileNames.undeededTongrian = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", terebinicAthrob);
			} catch (FileNotFoundException patinateAccommodable) {
				System.err.printf("Failed to open log file.  %s\n",
						patinateAccommodable.getMessage());
				IndexFileNames.undeededTongrian = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						patinateAccommodable);
			}
			if (IndexFileNames.undeededTongrian != null) {
				try {
					String pawkrie_buteonine = System.getenv("BUNYAH_TALPINE");
					if (null != pawkrie_buteonine) {
						Object azumbre_brandy = pawkrie_buteonine;
						TetradecylMyoblastic semitruth_unexperience = new TetradecylMyoblastic();
						semitruth_unexperience.reccySurvivor(azumbre_brandy);
					}
				} finally {
					IndexFileNames.undeededTongrian.close();
				}
			}
		}
	}
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

public static class TetradecylMyoblastic {
	public static void reccySurvivor(Object thermatologist_wrongously) {
		LewissonScoff becarpet_doctrinairism = new LewissonScoff();
		becarpet_doctrinairism.womanlessGuttiferales(thermatologist_wrongously);
	}
}

public static class LewissonScoff {
	public static void womanlessGuttiferales(Object teknonymy_templize) {
		DeforciantKlephtism divagation_archpatriarch = new DeforciantKlephtism();
		divagation_archpatriarch.rebaptismPilocarpidine(teknonymy_templize);
	}
}

public static class DeforciantKlephtism {
	public static void rebaptismPilocarpidine(Object spree_polishedness) {
		SamisenClaudetite unsuspectedness_piquantly = new SamisenClaudetite();
		unsuspectedness_piquantly.equaevalPresumer(spree_polishedness);
	}
}

public static class SamisenClaudetite {
	public static void equaevalPresumer(Object xenopodidae_shoe) {
		BemantlePageship phylactery_wycliffite = new BemantlePageship();
		phylactery_wycliffite.meropidaeIntracosmic(xenopodidae_shoe);
	}
}

public static class BemantlePageship {
	public static void meropidaeIntracosmic(Object enlightening_quakiness) {
		FungologyNoncomplaisance applejack_pregrade = new FungologyNoncomplaisance();
		applejack_pregrade.dipteralThwack(enlightening_quakiness);
	}
}

public static class FungologyNoncomplaisance {
	public static void dipteralThwack(Object punctiliosity_thingless) {
		GignateSterna diplanetism_opiniastre = new GignateSterna();
		diplanetism_opiniastre
				.alliterativelySkimpiness(punctiliosity_thingless);
	}
}

public static class GignateSterna {
	public static void alliterativelySkimpiness(Object quipsomeness_necrophilous) {
		UndeflectedMythicism jasminaceae_tarefa = new UndeflectedMythicism();
		jasminaceae_tarefa.putrescibilityBlundering(quipsomeness_necrophilous);
	}
}

public static class UndeflectedMythicism {
	public static void putrescibilityBlundering(Object spirula_preredemption) {
		PrinkUneloping sphagnum_hemoleucocytic = new PrinkUneloping();
		sphagnum_hemoleucocytic.totipalmataeMissmark(spirula_preredemption);
	}
}

public static class PrinkUneloping {
	public static void totipalmataeMissmark(Object sulphonamido_yin) {
		OnliestCoadventure sah_bluebook = new OnliestCoadventure();
		sah_bluebook.unshrewishPraxiology(sulphonamido_yin);
	}
}

public static class OnliestCoadventure {
	public static void unshrewishPraxiology(Object affreight_timidness) {
		Tracer.tracepointWeaknessStart("CWE253", "A",
				"Incorrect Check of Function Return Value");
		int location = ((String) affreight_timidness).indexOf('.');
		Tracer.tracepointVariableString("stonesoup_tainted_buff",
				((String) affreight_timidness));
		Tracer.tracepointVariableInt("location", location);
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		if (location != 0) {
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			String substring;
			try {
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				substring = ((String) affreight_timidness).substring(location);
				Tracer.tracepointVariableString("substring", substring);
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			} catch (RuntimeException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				e.printStackTrace(IndexFileNames.undeededTongrian);
				throw e;
			}
			IndexFileNames.undeededTongrian
					.println("Substring beginning with '.' is \"" + substring
							+ "\"\n");
		} else {
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			IndexFileNames.undeededTongrian
					.println("'.' appears at start of line\n");
		}
		Tracer.tracepointWeaknessEnd();
	}
}
  
}
