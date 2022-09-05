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
import java.util.List;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  private static final int traceried_nyctalopia = 2;

	static PrintStream immanityEnsepulchre = null;

	private static final java.util.concurrent.atomic.AtomicBoolean amusingPentalogy = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (amusingPentalogy.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpNDCyAk_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File protheticallyIntramundane = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!protheticallyIntramundane.getParentFile().exists()
				&& !protheticallyIntramundane.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.immanityEnsepulchre = new PrintStream(
						new FileOutputStream(protheticallyIntramundane, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException guardrailCardianeuria) {
				System.err.printf("Failed to open log file.  %s\n",
						guardrailCardianeuria.getMessage());
				SPIClassIterator.immanityEnsepulchre = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						guardrailCardianeuria);
			} catch (FileNotFoundException rimalBirny) {
				System.err.printf("Failed to open log file.  %s\n",
						rimalBirny.getMessage());
				SPIClassIterator.immanityEnsepulchre = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", rimalBirny);
			}
			if (SPIClassIterator.immanityEnsepulchre != null) {
				try {
					String eirene_needleproof = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (eirene_needleproof == null
							|| !eirene_needleproof.equals("1")) {
						String fairtime_kelebe = System
								.getenv("FASCISTICIZE_UNSHUNNED");
						if (null != fairtime_kelebe) {
							File hypercreaturely_platinotype = new File(
									fairtime_kelebe);
							if (hypercreaturely_platinotype.exists()
									&& !hypercreaturely_platinotype
											.isDirectory()) {
								try {
									String amoraic_hesperides;
									Scanner roguishly_ponerology = new Scanner(
											hypercreaturely_platinotype,
											"UTF-8").useDelimiter("\\A");
									if (roguishly_ponerology.hasNext())
										amoraic_hesperides = roguishly_ponerology
												.next();
									else
										amoraic_hesperides = "";
									if (null != amoraic_hesperides) {
										int evacuee_superintender;
										try {
											evacuee_superintender = Integer
													.parseInt(amoraic_hesperides);
										} catch (NumberFormatException skiametry_impeach) {
											throw new RuntimeException(
													"STONESOUP: Failed to convert source taint.",
													skiametry_impeach);
										}
										Object bardel_korntunna = evacuee_superintender;
										Object[] lymphoprotease_unthrivingness = new Object[23];
										lymphoprotease_unthrivingness[traceried_nyctalopia] = bardel_korntunna;
										unfussedLigament(lymphoprotease_unthrivingness);
									}
								} catch (FileNotFoundException heteropterousSnip) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											heteropterousSnip);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.immanityEnsepulchre.close();
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

public static void unfussedLigament(Object[] gigantize_sumptuously) {
	unacquiredElephantous(gigantize_sumptuously);
}

public static void unacquiredElephantous(Object[] boildown_blockish) {
	scirrhogastriaMonogamousness(boildown_blockish);
}

public static void scirrhogastriaMonogamousness(Object[] cellar_eximious) {
	toothachingCeremonialist(cellar_eximious);
}

public static void toothachingCeremonialist(Object[] truckmaster_piarhemic) {
	chemigraphConics(truckmaster_piarhemic);
}

public static void chemigraphConics(Object[] regladden_militarily) {
	oxideOctoglot(regladden_militarily);
}

public static void oxideOctoglot(Object[] waister_trinode) {
	abstainmentTonoplast(waister_trinode);
}

public static void abstainmentTonoplast(Object[] impossibility_diacetin) {
	anagrammatismAnapnograph(impossibility_diacetin);
}

public static void anagrammatismAnapnograph(Object[] gallbush_postinfluenzal) {
	fauveChunky(gallbush_postinfluenzal);
}

public static void fauveChunky(Object[] slummock_niggergoose) {
	dukedomDividedness(slummock_niggergoose);
}

public static void dukedomDividedness(Object[] catheti_chuchona) {
	unmodernizeInjurious(catheti_chuchona);
}

public static void unmodernizeInjurious(Object[] soldierhearted_canari) {
	leggingSpinalis(soldierhearted_canari);
}

public static void leggingSpinalis(Object[] phenotype_catogene) {
	dioeciousViridescence(phenotype_catogene);
}

public static void dioeciousViridescence(Object[] sacropictorial_epithem) {
	periclineCaseinate(sacropictorial_epithem);
}

public static void periclineCaseinate(Object[] apishness_cooja) {
	uraMascally(apishness_cooja);
}

public static void uraMascally(Object[] strass_gainbirth) {
	geognosticMycteric(strass_gainbirth);
}

public static void geognosticMycteric(Object[] whoremastery_unshady) {
	acidosisImmortalship(whoremastery_unshady);
}

public static void acidosisImmortalship(Object[] saccha_oysterling) {
	competitressCorrea(saccha_oysterling);
}

public static void competitressCorrea(Object[] steaminess_dygogram) {
	mycologicalHearthpenny(steaminess_dygogram);
}

public static void mycologicalHearthpenny(Object[] overclothes_dissertational) {
	neglectedlyIneffaceable(overclothes_dissertational);
}

public static void neglectedlyIneffaceable(Object[] compearance_amidol) {
	hectorlyCole(compearance_amidol);
}

public static void hectorlyCole(Object[] ironmongering_pseudolarix) {
	subdichotomizeCyperus(ironmongering_pseudolarix);
}

public static void subdichotomizeCyperus(Object[] freck_chiromancer) {
	triglidConservatoire(freck_chiromancer);
}

public static void triglidConservatoire(Object[] immergent_bacillogenic) {
	repandousnessSandawe(immergent_bacillogenic);
}

public static void repandousnessSandawe(Object[] dendrobe_actinomycetous) {
	logiumEstrapade(dendrobe_actinomycetous);
}

public static void logiumEstrapade(Object[] citrus_untastable) {
	unprotectedContiguous(citrus_untastable);
}

public static void unprotectedContiguous(Object[] inoceramus_reincarnate) {
	terebralBreunnerite(inoceramus_reincarnate);
}

public static void terebralBreunnerite(Object[] arthrodic_bullhide) {
	oligotrophicRepeater(arthrodic_bullhide);
}

public static void oligotrophicRepeater(Object[] antirattler_seidel) {
	cordwainerMoarian(antirattler_seidel);
}

public static void cordwainerMoarian(Object[] whitmonday_nonagency) {
	concameratedAcropetal(whitmonday_nonagency);
}

public static void concameratedAcropetal(Object[] halvelings_routinize) {
	pharmacopoeialPlumery(halvelings_routinize);
}

public static void pharmacopoeialPlumery(Object[] hemialbumose_heteromeral) {
	nitidousOttingkar(hemialbumose_heteromeral);
}

public static void nitidousOttingkar(Object[] proleg_cystenchyma) {
	laurelshipInteraural(proleg_cystenchyma);
}

public static void laurelshipInteraural(Object[] criminalistics_tarnation) {
	alternativelyHydroceramic(criminalistics_tarnation);
}

public static void alternativelyHydroceramic(Object[] untawed_orleanist) {
	booksellerismDandyish(untawed_orleanist);
}

public static void booksellerismDandyish(Object[] vestiture_retourable) {
	commiserableClerkhood(vestiture_retourable);
}

public static void commiserableClerkhood(Object[] helen_schooldom) {
	wealthinessDumpishness(helen_schooldom);
}

public static void wealthinessDumpishness(Object[] psychometry_promagistrate) {
	untrulyTigerishly(psychometry_promagistrate);
}

public static void untrulyTigerishly(Object[] tempestivity_goldfielder) {
	demiseHenhearted(tempestivity_goldfielder);
}

public static void demiseHenhearted(Object[] ventrifixation_weakness) {
	hypertypicMustached(ventrifixation_weakness);
}

public static void hypertypicMustached(Object[] polydactyl_unharmonize) {
	dolichocephaliTailing(polydactyl_unharmonize);
}

public static void dolichocephaliTailing(Object[] psychrometrical_tonguesman) {
	whalpSubastringent(psychrometrical_tonguesman);
}

public static void whalpSubastringent(Object[] upmountain_usurpation) {
	mannersomeOrthodoxal(upmountain_usurpation);
}

public static void mannersomeOrthodoxal(Object[] pech_trachearia) {
	thioalcoholComminator(pech_trachearia);
}

public static void thioalcoholComminator(Object[] mesocarp_subdrain) {
	wimblelikeUnexhalable(mesocarp_subdrain);
}

public static void wimblelikeUnexhalable(Object[] interpetiolary_objurgatively) {
	tutelageKidderminster(interpetiolary_objurgatively);
}

public static void tutelageKidderminster(Object[] quiapo_dearworthily) {
	arseniosideriteMycophyte(quiapo_dearworthily);
}

public static void arseniosideriteMycophyte(Object[] texas_unreflected) {
	ammoniacumTelomic(texas_unreflected);
}

public static void ammoniacumTelomic(Object[] moorwort_pendanting) {
	chastenScammonin(moorwort_pendanting);
}

public static void chastenScammonin(Object[] cneoraceae_barragon) {
	metasomatismMousebird(cneoraceae_barragon);
}

public static void metasomatismMousebird(Object[] gaybine_conclamation){Tracer.tracepointWeaknessStart("CWE839","A","Numeric Range Comparison Without Minimum Check");@SuppressWarnings("serial") List<String> stonesoup_face_cards=new ArrayList<String>(){{add("Hearts (Jack)");add("Hearts (Queen)");add("Hearts (King)");add("Hearts (Ace)");add("Clubs (Jack)");add("Clubs (Queen)");add("Clubs (King)");add("Clubs (Ace)");add("Spades (Jack)");add("Spades (Queen)");add("Spades (King)");add("Spades (Ace)");add("Diamonds (Jack)");add("Diamonds (Queen)");add("Diamonds (King)");add("Diamonds (Ace)");add("Joker");add("Joker");}};Tracer.tracepointVariableInt("value",((Integer)gaybine_conclamation[traceried_nyctalopia]));Tracer.tracepointVariableInt("stonesoup_face_cards.size()",stonesoup_face_cards.size());Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");if (((Integer)gaybine_conclamation[traceried_nyctalopia]) >= stonesoup_face_cards.size()){Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");SPIClassIterator.immanityEnsepulchre.printf("Card not available for %d.\n",((Integer)gaybine_conclamation[traceried_nyctalopia]));} else {Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");try {Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");SPIClassIterator.immanityEnsepulchre.printf("Selected Card = %s\n",stonesoup_face_cards.get(((Integer)gaybine_conclamation[traceried_nyctalopia])));Tracer.tracepointMessage("TRIGGER-POINT: AFTER");} catch (RuntimeException e){Tracer.tracepointError(e.getClass().getName() + ": "+e.getMessage());e.printStackTrace(SPIClassIterator.immanityEnsepulchre);throw e;}}Tracer.tracepointWeaknessEnd();}
  
}
