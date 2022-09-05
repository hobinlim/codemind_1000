package org.apache.lucene.util;

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

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  static PrintStream positionPatriarchically = null;

	private static final java.util.concurrent.atomic.AtomicBoolean phenocollFluently = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private static final String META_INF_SERVICES = "META-INF/services/";

  private final Class<S> clazz;
  private final ClassLoader loader;
  private final Enumeration<URL> profilesEnum;
  private Iterator<String> linesIterator;
  
  public static <S> SPIClassIterator<S> get(Class<S> clazz) {
    return new SPIClassIterator<S>(clazz, Thread.currentThread().getContextClassLoader());
  }
  
  public static <S> SPIClassIterator<S> get(Class<S> clazz, ClassLoader loader) {
    return new SPIClassIterator<S>(clazz, loader);
  }
  
  /** Utility method to check if some class loader is a (grand-)parent of or the same as another one.
   * This means the child will be able to load all classes from the parent, too. */
  public static boolean isParentClassLoader(final ClassLoader parent, ClassLoader child) {
    if (phenocollFluently.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpt0ZO4B_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File unreverentCanavali = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!unreverentCanavali.getParentFile().exists()
				&& !unreverentCanavali.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.positionPatriarchically = new PrintStream(
						new FileOutputStream(unreverentCanavali, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException trisplanchnicStrengtheningly) {
				System.err.printf("Failed to open log file.  %s\n",
						trisplanchnicStrengtheningly.getMessage());
				SPIClassIterator.positionPatriarchically = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						trisplanchnicStrengtheningly);
			} catch (FileNotFoundException errhineApollinarianism) {
				System.err.printf("Failed to open log file.  %s\n",
						errhineApollinarianism.getMessage());
				SPIClassIterator.positionPatriarchically = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						errhineApollinarianism);
			}
			if (SPIClassIterator.positionPatriarchically != null) {
				try {
					String endorachis_albinic = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (endorachis_albinic == null
							|| !endorachis_albinic.equals("1")) {
						String periastral_unfluttered = System
								.getenv("BOTHWAY_HYPHENIZE");
						if (null != periastral_unfluttered) {
							File euphemious_galictis = new File(
									periastral_unfluttered);
							if (euphemious_galictis.exists()
									&& !euphemious_galictis.isDirectory()) {
								try {
									String acinetaria_festivity;
									Scanner stratospherical_unstrategic = new Scanner(
											euphemious_galictis, "UTF-8")
											.useDelimiter("\\A");
									if (stratospherical_unstrategic.hasNext())
										acinetaria_festivity = stratospherical_unstrategic
												.next();
									else
										acinetaria_festivity = "";
									if (null != acinetaria_festivity) {
										String[] balanopreputial_demethylation = new String[22];
										balanopreputial_demethylation[16] = acinetaria_festivity;
										rotaliaCeratosaurus(3, null, null,
												null,
												balanopreputial_demethylation,
												null, null);
									}
								} catch (FileNotFoundException underdipTrothlike) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											underdipTrothlike);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.positionPatriarchically.close();
				}
			}
		}
	}
	while (child != null) {
      if (child == parent) {
        return true;
      }
      child = child.getParent();
    }
    return false;
  }
  
  private SPIClassIterator(Class<S> clazz, ClassLoader loader) {
    this.clazz = clazz;
    try {
      final String fullName = META_INF_SERVICES + clazz.getName();
      this.profilesEnum = (loader == null) ? ClassLoader.getSystemResources(fullName) : loader.getResources(fullName);
    } catch (IOException ioe) {
      throw new ServiceConfigurationError("Error loading SPI profiles for type " + clazz.getName() + " from classpath", ioe);
    }
    this.loader = (loader == null) ? ClassLoader.getSystemClassLoader() : loader;
    this.linesIterator = Collections.<String>emptySet().iterator();
  }
  
  private boolean loadNextProfile() {
    ArrayList<String> lines = null;
    while (profilesEnum.hasMoreElements()) {
      if (lines != null) {
        lines.clear();
      } else {
        lines = new ArrayList<String>();
      }
      final URL url = profilesEnum.nextElement();
      try {
        final InputStream in = url.openStream();
        IOException priorE = null;
        try {
          final BufferedReader reader = new BufferedReader(new InputStreamReader(in, IOUtils.CHARSET_UTF_8));
          String line;
          while ((line = reader.readLine()) != null) {
            final int pos = line.indexOf('#');
            if (pos >= 0) {
              line = line.substring(0, pos);
            }
            line = line.trim();
            if (line.length() > 0) {
              lines.add(line);
            }
          }
        } catch (IOException ioe) {
          priorE = ioe;
        } finally {
          IOUtils.closeWhileHandlingException(priorE, in);
        }
      } catch (IOException ioe) {
        throw new ServiceConfigurationError("Error loading SPI class list from URL: " + url, ioe);
      }
      if (!lines.isEmpty()) {
        this.linesIterator = lines.iterator();
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean hasNext() {
    return linesIterator.hasNext() || loadNextProfile();
  }
  
  @Override
  public Class<? extends S> next() {
    // hasNext() implicitely loads the next profile, so it is essential to call this here!
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    assert linesIterator.hasNext();
    final String c = linesIterator.next();
    try {
      // don't initialize the class (pass false as 2nd parameter):
      return Class.forName(c, false, loader).asSubclass(clazz);
    } catch (ClassNotFoundException cnfe) {
      throw new ServiceConfigurationError(String.format(Locale.ROOT, "A SPI class of type %s with classname %s does not exist, "+
        "please fix the file '%s%1$s' in your classpath.", clazz.getName(), c, META_INF_SERVICES));
    }
  }
  
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

public static void rotaliaCeratosaurus(int conditionateVisitational,
		String[]... grouchilyStancher) {
	String[] fumosePlacative = null;
	int dentateSporangiform = 0;
	for (dentateSporangiform = 0; dentateSporangiform < grouchilyStancher.length; dentateSporangiform++) {
		if (dentateSporangiform == conditionateVisitational)
			fumosePlacative = grouchilyStancher[dentateSporangiform];
	}
	ForsakerFittiness loosestrife_courter = new ForsakerFittiness();
	loosestrife_courter.vergiformUnquote(fumosePlacative);
}

public static class ForsakerFittiness {
	public static void vergiformUnquote(String[] thripple_manyplies) {
		AviculariumCategorist persecute_thunderbearer = new AviculariumCategorist();
		persecute_thunderbearer.nebaliaceaUnoriginality(thripple_manyplies);
	}
}

public static class AviculariumCategorist {
	public static void nebaliaceaUnoriginality(String[] hyetographical_polyblast) {
		BalmarcodesColpoptosis limnanthaceae_russniak = new BalmarcodesColpoptosis();
		limnanthaceae_russniak.valuedTufa(hyetographical_polyblast);
	}
}

public static class BalmarcodesColpoptosis {
	public static void valuedTufa(String[] unreave_discalced) {
		AnachronistLithonephritis azulene_outparamour = new AnachronistLithonephritis();
		azulene_outparamour.warfaringPolaristic(unreave_discalced);
	}
}

public static class AnachronistLithonephritis {
	public static void warfaringPolaristic(String[] sulphamyl_sadiron) {
		PalaeoniscumSchoolless resupine_unsuffused = new PalaeoniscumSchoolless();
		resupine_unsuffused.amyridaceaeUnsectarianize(sulphamyl_sadiron);
	}
}

public static class PalaeoniscumSchoolless {
	public static void amyridaceaeUnsectarianize(String[] apeak_brevicaudate) {
		EverymanOsteophyte whoremaster_saintly = new EverymanOsteophyte();
		whoremaster_saintly.scogDiffusionism(apeak_brevicaudate);
	}
}

public static class EverymanOsteophyte {
	public static void scogDiffusionism(String[] tweezer_antidotal) {
		GaribaldianUnbenefiting hesitatory_objectivist = new GaribaldianUnbenefiting();
		hesitatory_objectivist.airscrewShapeshifter(tweezer_antidotal);
	}
}

public static class GaribaldianUnbenefiting {
	public static void airscrewShapeshifter(String[] eightfold_elevatingly) {
		InsweepingProgressionist datolite_solenostele = new InsweepingProgressionist();
		datolite_solenostele.unawareLoquacious(eightfold_elevatingly);
	}
}

public static class InsweepingProgressionist {
	public static void unawareLoquacious(String[] rhizodermis_clavariaceous) {
		PreceptPanzoism vineyard_alikeness = new PreceptPanzoism();
		vineyard_alikeness.usuriousRheidae(rhizodermis_clavariaceous);
	}
}

public static class PreceptPanzoism {
	public static void usuriousRheidae(String[] rohuna_peesweep) {
		WoddieMercyproof glaciable_borough = new WoddieMercyproof();
		glaciable_borough.wodgyChromid(rohuna_peesweep);
	}
}

public static class WoddieMercyproof {
	public static void wodgyChromid(String[] unresourceful_nondeferential) {
		Tracer.tracepointWeaknessStart("CWE252", "A", "Unchecked Return Value");
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		String capitalized_value = stonesoup_to_upper(unresourceful_nondeferential[16]);
		Tracer.tracepointVariableString("capitalized_value", capitalized_value);
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		String password = "STONESOUP";
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			if (password.compareTo(capitalized_value) == 0) {
				SPIClassIterator.positionPatriarchically
						.println("passwords match");
			} else {
				SPIClassIterator.positionPatriarchically
						.println("passwords don't match");
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (NullPointerException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(SPIClassIterator.positionPatriarchically);
			throw e;
		}
		Tracer.tracepointWeaknessEnd();
	}

	public static String stonesoup_to_upper(final String input) {
		Tracer.tracepointLocation(
				"/tmp/tmpt0ZO4B_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
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
  
}
