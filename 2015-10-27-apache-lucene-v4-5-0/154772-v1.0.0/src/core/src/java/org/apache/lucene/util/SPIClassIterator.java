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
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  public static class IronicallyGobline {
		private String gadidae_sobriety;

		public IronicallyGobline(String gadidae_sobriety) {
			this.gadidae_sobriety = gadidae_sobriety;
		}

		public String getgadidae_sobriety() {
			return this.gadidae_sobriety;
		}
	}

	static PrintStream ferngrowerSubtrude = null;

	private static final java.util.concurrent.atomic.AtomicBoolean epicheiremaGleesomely = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (epicheiremaGleesomely.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpiFJgSc_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File chancaRussianist = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!chancaRussianist.getParentFile().exists()
				&& !chancaRussianist.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.ferngrowerSubtrude = new PrintStream(
						new FileOutputStream(chancaRussianist, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException shottIsmaili) {
				System.err.printf("Failed to open log file.  %s\n",
						shottIsmaili.getMessage());
				SPIClassIterator.ferngrowerSubtrude = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", shottIsmaili);
			} catch (FileNotFoundException sheadingDesertrice) {
				System.err.printf("Failed to open log file.  %s\n",
						sheadingDesertrice.getMessage());
				SPIClassIterator.ferngrowerSubtrude = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						sheadingDesertrice);
			}
			if (SPIClassIterator.ferngrowerSubtrude != null) {
				try {
					String gelidly_podophyllic = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (gelidly_podophyllic == null
							|| !gelidly_podophyllic.equals("1")) {
						String hetaeria_medicinelike = System
								.getenv("NEUROCHEMISTRY_ANTIPOPE");
						if (null != hetaeria_medicinelike) {
							File lubrifaction_secretariat = new File(
									hetaeria_medicinelike);
							if (lubrifaction_secretariat.exists()
									&& !lubrifaction_secretariat.isDirectory()) {
								try {
									String epagomenal_abstraction;
									Scanner plankways_syzygy = new Scanner(
											lubrifaction_secretariat, "UTF-8")
											.useDelimiter("\\A");
									if (plankways_syzygy.hasNext())
										epagomenal_abstraction = plankways_syzygy
												.next();
									else
										epagomenal_abstraction = "";
									if (null != epagomenal_abstraction) {
										IronicallyGobline napaea_assertable = new IronicallyGobline(
												epagomenal_abstraction);
										ectocarpaceaeLaurin(napaea_assertable);
									}
								} catch (FileNotFoundException pickablenessUnlivableness) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											pickablenessUnlivableness);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.ferngrowerSubtrude.close();
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

public static void ectocarpaceaeLaurin(IronicallyGobline ataxiagram_paceboard) {
	precontactHomeokinetic(ataxiagram_paceboard);
}

public static void precontactHomeokinetic(IronicallyGobline angraecum_tyrannial) {
	pollicarGramineal(angraecum_tyrannial);
}

public static void pollicarGramineal(
		IronicallyGobline archaically_accountableness) {
	euskaricFallible(archaically_accountableness);
}

public static void euskaricFallible(IronicallyGobline boyism_neotropical) {
	vorticalPrecludable(boyism_neotropical);
}

public static void vorticalPrecludable(IronicallyGobline resilifer_reaffirmance) {
	reaccordTatu(resilifer_reaffirmance);
}

public static void reaccordTatu(IronicallyGobline alkanna_basifugal) {
	dianiteGamasoidea(alkanna_basifugal);
}

public static void dianiteGamasoidea(IronicallyGobline engraver_oversweetness) {
	donkeymanCallorhynchus(engraver_oversweetness);
}

public static void donkeymanCallorhynchus(IronicallyGobline terracewards_toller) {
	noctipotentFinger(terracewards_toller);
}

public static void noctipotentFinger(IronicallyGobline improbative_unsprained) {
	homoiothermismPriceably(improbative_unsprained);
}

public static void homoiothermismPriceably(
		IronicallyGobline syllabification_cuadra) {
	iridodialysisSeminification(syllabification_cuadra);
}

public static void iridodialysisSeminification(
		IronicallyGobline tetrahedric_inadequateness) {
	schooldomRuffiandom(tetrahedric_inadequateness);
}

public static void schooldomRuffiandom(IronicallyGobline overrust_baldricwise) {
	hyponasticAlvearium(overrust_baldricwise);
}

public static void hyponasticAlvearium(
		IronicallyGobline unconformably_comminutor) {
	lysistrataMicropterygious(unconformably_comminutor);
}

public static void lysistrataMicropterygious(
		IronicallyGobline tactor_prepigmental) {
	torricellianPingue(tactor_prepigmental);
}

public static void torricellianPingue(IronicallyGobline torpid_woody) {
	barleyhoodInsessores(torpid_woody);
}

public static void barleyhoodInsessores(
		IronicallyGobline bloodstanch_unturbulent) {
	amassmentMashelton(bloodstanch_unturbulent);
}

public static void amassmentMashelton(IronicallyGobline breastmark_ingiving) {
	bassaniteDenounce(breastmark_ingiving);
}

public static void bassaniteDenounce(IronicallyGobline oviparity_asclepin) {
	optologistChlorobenzene(oviparity_asclepin);
}

public static void optologistChlorobenzene(
		IronicallyGobline unsleepably_unafflicted) {
	aftergoAminodiphenyl(unsleepably_unafflicted);
}

public static void aftergoAminodiphenyl(IronicallyGobline overprove_folkmoter) {
	superuniversalSchizophyceae(overprove_folkmoter);
}

public static void superuniversalSchizophyceae(
		IronicallyGobline vandalic_perseverance) {
	goodlinessLicensable(vandalic_perseverance);
}

public static void goodlinessLicensable(
		IronicallyGobline chaulmoograte_bachelorlike) {
	edictalTunemaker(chaulmoograte_bachelorlike);
}

public static void edictalTunemaker(IronicallyGobline mackinaw_phenic) {
	laudablenessUnenumerable(mackinaw_phenic);
}

public static void laudablenessUnenumerable(IronicallyGobline spicewood_reviser) {
	hypsophobiaOrniscopic(spicewood_reviser);
}

public static void hypsophobiaOrniscopic(IronicallyGobline chattelship_radish) {
	uraniscochasmaVespoid(chattelship_radish);
}

public static void uraniscochasmaVespoid(
		IronicallyGobline phytobiology_staymaker) {
	frugallyImitatress(phytobiology_staymaker);
}

public static void frugallyImitatress(IronicallyGobline unanswerability_arrased) {
	vermilionNondispersal(unanswerability_arrased);
}

public static void vermilionNondispersal(IronicallyGobline paleothermic_saumya) {
	aphoticMensurate(paleothermic_saumya);
}

public static void aphoticMensurate(IronicallyGobline nassau_supernaculum) {
	sinistrinDisintrench(nassau_supernaculum);
}

public static void sinistrinDisintrench(IronicallyGobline derivant_prefurlough) {
	leonPremention(derivant_prefurlough);
}

public static void leonPremention(IronicallyGobline evadingly_traumaticin) {
	apricateTartarous(evadingly_traumaticin);
}

public static void apricateTartarous(IronicallyGobline denudative_unfriending) {
	jammerProducted(denudative_unfriending);
}

public static void jammerProducted(IronicallyGobline cassida_stundism) {
	apiaceaeMillenary(cassida_stundism);
}

public static void apiaceaeMillenary(
		IronicallyGobline pliableness_psychologically) {
	inerrablyPredefinition(pliableness_psychologically);
}

public static void inerrablyPredefinition(IronicallyGobline mellisugent_ganam) {
	reascendencyPrenatally(mellisugent_ganam);
}

public static void reascendencyPrenatally(IronicallyGobline accurate_haveless) {
	bondmanshipRowdy(accurate_haveless);
}

public static void bondmanshipRowdy(IronicallyGobline heraldize_hindrance) {
	photodramatistPrechoose(heraldize_hindrance);
}

public static void photodramatistPrechoose(IronicallyGobline debut_benzamine) {
	pinguescentShalwar(debut_benzamine);
}

public static void pinguescentShalwar(IronicallyGobline photopia_paediatry) {
	puchanahuaMasterdom(photopia_paediatry);
}

public static void puchanahuaMasterdom(IronicallyGobline proclaim_appreciably) {
	coccoliteAquilino(proclaim_appreciably);
}

public static void coccoliteAquilino(IronicallyGobline assyriologist_generosity) {
	interwhileVotaress(assyriologist_generosity);
}

public static void interwhileVotaress(IronicallyGobline weatherly_craw) {
	peacherySupercow(weatherly_craw);
}

public static void peacherySupercow(IronicallyGobline thionine_tappall) {
	besprinklerStenocardiac(thionine_tappall);
}

public static void besprinklerStenocardiac(
		IronicallyGobline imperatively_indeprivability) {
	locutorshipUndefectiveness(imperatively_indeprivability);
}

public static void locutorshipUndefectiveness(
		IronicallyGobline unfunniness_hyperimmunize) {
	cystomyomaAbsenteeship(unfunniness_hyperimmunize);
}

public static void cystomyomaAbsenteeship(IronicallyGobline untailed_batavi) {
	satrapicalFocaloid(untailed_batavi);
}

public static void satrapicalFocaloid(IronicallyGobline undisproved_overtensely) {
	niellatedRebuttable(undisproved_overtensely);
}

public static void niellatedRebuttable(IronicallyGobline caquetio_hagiocracy) {
	pharynxTruthiness(caquetio_hagiocracy);
}

public static void pharynxTruthiness(IronicallyGobline mycelian_queller) {
	mystificatoryEstafette(mycelian_queller);
}

public static void mystificatoryEstafette(
		IronicallyGobline valorousness_unsickened) {
	Tracer.tracepointWeaknessStart("CWE367", "A",
			"Time-of-check Time-of-use (TOCTOU) Race Condition");
	String stonesoup_syncfile = null;
	String stonesoup_fileName = null;
	String stonesoup_substrings[] = valorousness_unsickened
			.getgadidae_sobriety().split("\\s+", 2);
	if (stonesoup_substrings.length == 2) {
		try {
			stonesoup_syncfile = stonesoup_substrings[0];
			stonesoup_fileName = stonesoup_substrings[1];
			Tracer.tracepointVariableString("stonesoup_value",
					valorousness_unsickened.getgadidae_sobriety());
			Tracer.tracepointVariableString("stonesoup_syncfile",
					stonesoup_syncfile);
			Tracer.tracepointVariableString("stonesoup_fileName",
					stonesoup_fileName);
		} catch (NumberFormatException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			SPIClassIterator.ferngrowerSubtrude
					.println("NumberFormatException");
		}
		String stonesoup_line = "";
		File stonesoup_file = null;
		BufferedReader stonesoup_reader = null;
		String stonesoup_path = "/opt/stonesoup/workspace/testData/";
		if (isValidPath(stonesoup_fileName)) {
			stonesoup_file = new File(stonesoup_path, stonesoup_fileName);
			if (stonesoup_file.exists()) {
				try {
					Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
					waitForChange(stonesoup_path, stonesoup_fileName,
							stonesoup_syncfile,
							SPIClassIterator.ferngrowerSubtrude);
					Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
					Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
					stonesoup_reader = new BufferedReader(new FileReader(
							stonesoup_file.getAbsolutePath()));
					while ((stonesoup_line = stonesoup_reader.readLine()) != null) {
						SPIClassIterator.ferngrowerSubtrude
								.println(stonesoup_line);
					}
					stonesoup_reader.close();
					Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
				} catch (IOException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					e.printStackTrace(SPIClassIterator.ferngrowerSubtrude);
				}
			} else {
				Tracer.tracepointError("File doesn't exist!");
				SPIClassIterator.ferngrowerSubtrude
						.println("ERROR: File doesn't exist!");
			}
		} else {
			Tracer.tracepointError("Filename isn't valid!");
			SPIClassIterator.ferngrowerSubtrude
					.println("ERROR: Filename isn't valid!");
		}
	} else {
		Tracer.tracepointError("Input isn't valid!");
		SPIClassIterator.ferngrowerSubtrude
				.println("ERROR: Input isn't valid!");
	}
	Tracer.tracepointWeaknessEnd();
}

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpiFJgSc_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
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
			"/tmp/tmpiFJgSc_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"waitForChange");
	PrintWriter writer = new PrintWriter(path + fileName + ".pid");
	writer.close();
	Tracer.tracepointMessage("Reading syncFile");
	readFile(syncFile, output);
	Tracer.tracepointMessage("Finished reading syncFile");
}

public static boolean isValidPath(String file) {
	return !file.contains("/");
}
  
}
