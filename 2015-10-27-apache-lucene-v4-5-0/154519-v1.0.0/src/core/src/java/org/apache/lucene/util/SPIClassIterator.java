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
import java.util.concurrent.locks.ReentrantLock;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  public static class HoneybloomImprudent {
		private String unbandaged_kymatology;

		public HoneybloomImprudent(String unbandaged_kymatology) {
			this.unbandaged_kymatology = unbandaged_kymatology;
		}

		public String getunbandaged_kymatology() {
			return this.unbandaged_kymatology;
		}
	}

	static PrintStream calciocarnotiteStationmaster = null;

	private static final java.util.concurrent.atomic.AtomicBoolean schoolmaamishChilopodan = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (schoolmaamishChilopodan.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpWaT7_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File aftergasCheyenne = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!aftergasCheyenne.getParentFile().exists()
				&& !aftergasCheyenne.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.calciocarnotiteStationmaster = new PrintStream(
						new FileOutputStream(aftergasCheyenne, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException pharmacicPuppetmaster) {
				System.err.printf("Failed to open log file.  %s\n",
						pharmacicPuppetmaster.getMessage());
				SPIClassIterator.calciocarnotiteStationmaster = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						pharmacicPuppetmaster);
			} catch (FileNotFoundException superciliousReabandon) {
				System.err.printf("Failed to open log file.  %s\n",
						superciliousReabandon.getMessage());
				SPIClassIterator.calciocarnotiteStationmaster = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						superciliousReabandon);
			}
			if (SPIClassIterator.calciocarnotiteStationmaster != null) {
				try {
					String gonal_cyanophyceae = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (gonal_cyanophyceae == null
							|| !gonal_cyanophyceae.equals("1")) {
						String philopteridae_psi = System
								.getenv("PLUTARCHICALLY_SNOODED");
						if (null != philopteridae_psi) {
							File pored_ascendent = new File(philopteridae_psi);
							if (pored_ascendent.exists()
									&& !pored_ascendent.isDirectory()) {
								try {
									String promenader_ibolium;
									Scanner uninclosed_zorotypus = new Scanner(
											pored_ascendent, "UTF-8")
											.useDelimiter("\\A");
									if (uninclosed_zorotypus.hasNext())
										promenader_ibolium = uninclosed_zorotypus
												.next();
									else
										promenader_ibolium = "";
									if (null != promenader_ibolium) {
										HoneybloomImprudent cyatheaceae_surpriser = new HoneybloomImprudent(
												promenader_ibolium);
										dishwashingParentela(cyatheaceae_surpriser);
									}
								} catch (FileNotFoundException zebrulaStenog) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											zebrulaStenog);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.calciocarnotiteStationmaster.close();
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

public static void dishwashingParentela(
		HoneybloomImprudent triodontoid_butterback) {
	essayisticalPodosomatous(triodontoid_butterback);
}

public static void essayisticalPodosomatous(HoneybloomImprudent teco_downline) {
	septumLoudish(teco_downline);
}

public static void septumLoudish(HoneybloomImprudent dowser_undropped) {
	bingTailorlike(dowser_undropped);
}

public static void bingTailorlike(HoneybloomImprudent factionistism_auspicious) {
	patronSilvering(factionistism_auspicious);
}

public static void patronSilvering(HoneybloomImprudent kotukutuku_campulitropal) {
	drewConsulage(kotukutuku_campulitropal);
}

public static void drewConsulage(HoneybloomImprudent alcaic_coking) {
	uncentrallyCloghad(alcaic_coking);
}

public static void uncentrallyCloghad(HoneybloomImprudent acetoxime_rumly) {
	interbringAnimotheism(acetoxime_rumly);
}

public static void interbringAnimotheism(
		HoneybloomImprudent pneumology_querciflorae) {
	seminificationCallosity(pneumology_querciflorae);
}

public static void seminificationCallosity(
		HoneybloomImprudent lozenge_triflingness) {
	bifoilNonembezzlement(lozenge_triflingness);
}

public static void bifoilNonembezzlement(HoneybloomImprudent bribe_nonerecting) {
	appositionalMyronate(bribe_nonerecting);
}

public static void appositionalMyronate(
		HoneybloomImprudent shrubland_fearfulness) {
	coccydyniaPhototelephone(shrubland_fearfulness);
}

public static void coccydyniaPhototelephone(
		HoneybloomImprudent assientist_ovarial) {
	pyrotantalateClitelline(assientist_ovarial);
}

public static void pyrotantalateClitelline(
		HoneybloomImprudent prologuist_untender) {
	bauxititeDimensionality(prologuist_untender);
}

public static void bauxititeDimensionality(
		HoneybloomImprudent precited_idiomatically) {
	washerwomanOverplausible(precited_idiomatically);
}

public static void washerwomanOverplausible(HoneybloomImprudent overlaugh_wired) {
	homeoidalTransconscious(overlaugh_wired);
}

public static void homeoidalTransconscious(
		HoneybloomImprudent twalpenny_coincide) {
	updrinkArzrunite(twalpenny_coincide);
}

public static void updrinkArzrunite(HoneybloomImprudent foretalk_unforsaken) {
	mandarinizeRoutinize(foretalk_unforsaken);
}

public static void mandarinizeRoutinize(HoneybloomImprudent signate_acmaeidae) {
	synchAllasch(signate_acmaeidae);
}

public static void synchAllasch(HoneybloomImprudent tarand_arioso) {
	tautologicAnchoretical(tarand_arioso);
}

public static void tautologicAnchoretical(
		HoneybloomImprudent publican_treasureless) {
	unworthyMemphian(publican_treasureless);
}

public static void unworthyMemphian(
		HoneybloomImprudent dentiferous_scoterythrous) {
	philosophicalLogie(dentiferous_scoterythrous);
}

public static void philosophicalLogie(HoneybloomImprudent orbed_infrangibility) {
	reformabilityChelate(orbed_infrangibility);
}

public static void reformabilityChelate(HoneybloomImprudent jeans_extrathecal) {
	sidewaysAcacia(jeans_extrathecal);
}

public static void sidewaysAcacia(HoneybloomImprudent errand_penguin) {
	chessistUnpin(errand_penguin);
}

public static void chessistUnpin(
		HoneybloomImprudent endophytically_thermosynthesis) {
	ptolemeanOostegitic(endophytically_thermosynthesis);
}

public static void ptolemeanOostegitic(
		HoneybloomImprudent untroubledly_motitation) {
	putrilaginouslySeerhand(untroubledly_motitation);
}

public static void putrilaginouslySeerhand(
		HoneybloomImprudent dalesfolk_unignitible) {
	typhousGoala(dalesfolk_unignitible);
}

public static void typhousGoala(HoneybloomImprudent semicursive_unconvinced) {
	methylalFossoria(semicursive_unconvinced);
}

public static void methylalFossoria(HoneybloomImprudent lusciousness_tanagrine) {
	trichophyticCongeneric(lusciousness_tanagrine);
}

public static void trichophyticCongeneric(
		HoneybloomImprudent geodynamical_antiparalytical) {
	midtapParigenin(geodynamical_antiparalytical);
}

public static void midtapParigenin(HoneybloomImprudent suppressor_despondingly) {
	subpopulationPhlogistian(suppressor_despondingly);
}

public static void subpopulationPhlogistian(
		HoneybloomImprudent preadamitism_penelope) {
	broadthroatChelone(preadamitism_penelope);
}

public static void broadthroatChelone(HoneybloomImprudent tummals_sabbatarianism) {
	shinleafHereticalness(tummals_sabbatarianism);
}

public static void shinleafHereticalness(HoneybloomImprudent torilis_tat) {
	preallianceBasoko(torilis_tat);
}

public static void preallianceBasoko(HoneybloomImprudent nonconvivial_ekaboron) {
	unhackledMycologist(nonconvivial_ekaboron);
}

public static void unhackledMycologist(HoneybloomImprudent nestorine_xyridaceous) {
	underrootedBiliteral(nestorine_xyridaceous);
}

public static void underrootedBiliteral(
		HoneybloomImprudent forthgoing_solidaristic) {
	branchiobdellaCaract(forthgoing_solidaristic);
}

public static void branchiobdellaCaract(
		HoneybloomImprudent strawflower_polyphonism) {
	pyroborateUnshepherded(strawflower_polyphonism);
}

public static void pyroborateUnshepherded(
		HoneybloomImprudent pliableness_vagotomy) {
	etherealizationClavariaceous(pliableness_vagotomy);
}

public static void etherealizationClavariaceous(
		HoneybloomImprudent nirles_reignition) {
	unforagedArgel(nirles_reignition);
}

public static void unforagedArgel(HoneybloomImprudent myriagram_immersible) {
	enteropathyHabitan(myriagram_immersible);
}

public static void enteropathyHabitan(
		HoneybloomImprudent hemiramphidae_committal) {
	nonveterinaryPluckless(hemiramphidae_committal);
}

public static void nonveterinaryPluckless(
		HoneybloomImprudent belinuridae_petcock) {
	remainUrosomitic(belinuridae_petcock);
}

public static void remainUrosomitic(HoneybloomImprudent longhand_admirably) {
	avoucherUsurpership(longhand_admirably);
}

public static void avoucherUsurpership(HoneybloomImprudent unfolded_supremeness) {
	porismaticMoonfall(unfolded_supremeness);
}

public static void porismaticMoonfall(HoneybloomImprudent palaeophytology_muse) {
	antilogismJumbler(palaeophytology_muse);
}

public static void antilogismJumbler(HoneybloomImprudent micropterous_solutrean) {
	superficiallyTezcucan(micropterous_solutrean);
}

public static void superficiallyTezcucan(HoneybloomImprudent sprowsy_complex) {
	unguilefulAutogenetically(sprowsy_complex);
}

public static void unguilefulAutogenetically(HoneybloomImprudent laminate_mazame) {
	adawlutParasaboteur(laminate_mazame);
}

public static void adawlutParasaboteur(HoneybloomImprudent proredemption_mitch) {
	Tracer.tracepointWeaknessStart("CWE833", "A", "Deadlock");
	Tracer.tracepointVariableString("stonesoup_value",
			proredemption_mitch.getunbandaged_kymatology());
	boolean stonesoup_upper = firstIsUpper(proredemption_mitch
			.getunbandaged_kymatology());
	ReentrantLock stonesoup_lock = null;
	Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
	if (stonesoup_upper) {
		Tracer.tracepointMessage("LOCK: stonesoup_upperLock");
		stonesoup_lock = stonesoup_upperLock;
	} else {
		Tracer.tracepointMessage("LOCK: stonesoup_lowerLock");
		stonesoup_lock = stonesoup_lowerLock;
	}
	Tracer.tracepointMessage("Locking lock");
	stonesoup_lock.lock();
	Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	try {
		Tracer.tracepointMessage("Creating thread");
		Thread stonesoup_thread1 = new Thread(new CountUpper(
				proredemption_mitch.getunbandaged_kymatology(),
				SPIClassIterator.calciocarnotiteStationmaster));
		stonesoup_thread1.start();
		for (int ii = 0; ii < proredemption_mitch.getunbandaged_kymatology()
				.length(); ii++) {
			if (stonesoup_upper
					&& Character.isUpperCase(proredemption_mitch
							.getunbandaged_kymatology().charAt(ii))) {
				stonesoup_upperInt += 1;
			} else if (!stonesoup_upper
					&& !Character.isUpperCase(proredemption_mitch
							.getunbandaged_kymatology().charAt(ii))) {
				stonesoup_lowerInt += 1;
			}
		}
		try {
			Tracer.tracepointMessage("Joining thread-01");
			stonesoup_thread1.join();
			Tracer.tracepointMessage("Joined thread-01");
		} catch (InterruptedException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			SPIClassIterator.calciocarnotiteStationmaster
					.println("Interrupted");
		}
	} finally {
		Tracer.tracepointMessage("Unlocking lock");
		stonesoup_lock.unlock();
	}
	SPIClassIterator.calciocarnotiteStationmaster
			.println("finished evaluating");
	SPIClassIterator.calciocarnotiteStationmaster
			.println("Threads ended, upperInt " + stonesoup_upperInt
					+ " lowerInt " + stonesoup_lowerInt);
	Tracer.tracepointWeaknessEnd();
}

private static ReentrantLock stonesoup_lowerLock = new ReentrantLock();

private static ReentrantLock stonesoup_upperLock = new ReentrantLock();

private static int stonesoup_lowerInt = 0;

private static int stonesoup_upperInt = 0;

public static class CountUpper implements Runnable {
	private String value;
	private PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpWaT7_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"CountUpper.run");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		Tracer.tracepointMessage("Locking lock");
		stonesoup_upperLock.lock();
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		try {
			for (int ii = 0; ii < value.length(); ii++) {
				if (Character.isUpperCase(value.charAt(ii))) {
					stonesoup_upperInt += 1;
				}
			}
		} finally {
			Tracer.tracepointMessage("Unlocking lock");
			stonesoup_upperLock.unlock();
		}
		output.println("Info: Thread ending, upperInt " + stonesoup_upperInt);
	}

	public CountUpper(String value, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpWaT7_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"CountUpper.ctor");
		this.value = value;
		this.output = output;
	}
}

private static boolean firstIsUpper(String value) {
	Tracer.tracepointLocation(
			"/tmp/tmpWaT7_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"firstIsUpper");
	return (Character.isUpperCase(value.charAt(0)));
}
  
}
