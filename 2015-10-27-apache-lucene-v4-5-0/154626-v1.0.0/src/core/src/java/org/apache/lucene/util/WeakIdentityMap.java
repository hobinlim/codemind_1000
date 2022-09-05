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

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implements a combination of {@link java.util.WeakHashMap} and
 * {@link java.util.IdentityHashMap}.
 * Useful for caches that need to key off of a {@code ==} comparison
 * instead of a {@code .equals}.
 * 
 * <p>This class is not a general-purpose {@link java.util.Map}
 * implementation! It intentionally violates
 * Map's general contract, which mandates the use of the equals method
 * when comparing objects. This class is designed for use only in the
 * rare cases wherein reference-equality semantics are required.
 * 
 * <p>This implementation was forked from <a href="http://cxf.apache.org/">Apache CXF</a>
 * but modified to <b>not</b> implement the {@link java.util.Map} interface and
 * without any set views on it, as those are error-prone and inefficient,
 * if not implemented carefully. The map only contains {@link Iterator} implementations
 * on the values and not-GCed keys. Lucene's implementation also supports {@code null}
 * keys, but those are never weak!
 * 
 * <p><a name="reapInfo" />The map supports two modes of operation:
 * <ul>
 *  <li>{@code reapOnRead = true}: This behaves identical to a {@link java.util.WeakHashMap}
 *  where it also cleans up the reference queue on every read operation ({@link #get(Object)},
 *  {@link #containsKey(Object)}, {@link #size()}, {@link #valueIterator()}), freeing map entries
 *  of already GCed keys.</li>
 *  <li>{@code reapOnRead = false}: This mode does not call {@link #reap()} on every read
 *  operation. In this case, the reference queue is only cleaned up on write operations
 *  (like {@link #put(Object, Object)}). This is ideal for maps with few entries where
 *  the keys are unlikely be garbage collected, but there are lots of {@link #get(Object)}
 *  operations. The code can still call {@link #reap()} to manually clean up the queue without
 *  doing a write operation.</li>
 * </ul>
 *
 * @lucene.internal
 */
public final class WeakIdentityMap<K,V> {
  public static class HerniaQueach {
		private Object urocanic_corundum;

		public HerniaQueach(Object urocanic_corundum) {
			this.urocanic_corundum = urocanic_corundum;
		}

		public Object geturocanic_corundum() {
			return this.urocanic_corundum;
		}
	}

	static PrintStream heteromerousCreagh = null;
	private static final java.util.concurrent.atomic.AtomicBoolean insularityMonazine = new java.util.concurrent.atomic.AtomicBoolean(
			false);
private final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
  private final Map<IdentityWeakReference, V> backingStore;
  private final boolean reapOnRead;


  /** 
   * Creates a new {@code WeakIdentityMap} based on a non-synchronized {@link HashMap}.
   * The map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newHashMap() {
    return newHashMap(true);
  }

  /**
   * Creates a new {@code WeakIdentityMap} based on a non-synchronized {@link HashMap}.
   * @param reapOnRead controls if the map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newHashMap(boolean reapOnRead) {
    return new WeakIdentityMap<K,V>(new HashMap<IdentityWeakReference,V>(), reapOnRead);
  }

  /**
   * Creates a new {@code WeakIdentityMap} based on a {@link ConcurrentHashMap}.
   * The map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newConcurrentHashMap() {
    return newConcurrentHashMap(true);
  }

  /**
   * Creates a new {@code WeakIdentityMap} based on a {@link ConcurrentHashMap}.
   * @param reapOnRead controls if the map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newConcurrentHashMap(boolean reapOnRead) {
    if (insularityMonazine.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"newConcurrentHashMap");
		File sporeformingChaffman = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!sporeformingChaffman.getParentFile().exists()
				&& !sporeformingChaffman.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				WeakIdentityMap.heteromerousCreagh = new PrintStream(
						new FileOutputStream(sporeformingChaffman, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException octoglotVanish) {
				System.err.printf("Failed to open log file.  %s\n",
						octoglotVanish.getMessage());
				WeakIdentityMap.heteromerousCreagh = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", octoglotVanish);
			} catch (FileNotFoundException corrosibilityFrondose) {
				System.err.printf("Failed to open log file.  %s\n",
						corrosibilityFrondose.getMessage());
				WeakIdentityMap.heteromerousCreagh = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						corrosibilityFrondose);
			}
			if (WeakIdentityMap.heteromerousCreagh != null) {
				try {
					String yoven_softhearted = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (yoven_softhearted == null
							|| !yoven_softhearted.equals("1")) {
						String macrourus_gastroparesis = System
								.getenv("SUTLERSHIP_SKINLESS");
						if (null != macrourus_gastroparesis) {
							File rue_unoperculate = new File(
									macrourus_gastroparesis);
							if (rue_unoperculate.exists()
									&& !rue_unoperculate.isDirectory()) {
								try {
									String uneloped_predread;
									Scanner unfascinating_talmouse = new Scanner(
											rue_unoperculate, "UTF-8")
											.useDelimiter("\\A");
									if (unfascinating_talmouse.hasNext())
										uneloped_predread = unfascinating_talmouse
												.next();
									else
										uneloped_predread = "";
									if (null != uneloped_predread) {
										Object tolunitrile_egger = uneloped_predread;
										HerniaQueach donal_lestosaurus = new HerniaQueach(
												tolunitrile_egger);
										TachymetricUntheatrical limphault_algaeology = new TachymetricUntheatrical();
										limphault_algaeology
												.proponentInseer(donal_lestosaurus);
									}
								} catch (FileNotFoundException pedagogismFeckfully) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											pedagogismFeckfully);
								}
							}
						}
					}
				} finally {
					WeakIdentityMap.heteromerousCreagh.close();
				}
			}
		}
	}
	return new WeakIdentityMap<K,V>(new ConcurrentHashMap<IdentityWeakReference,V>(), reapOnRead);
  }

  /** Private only constructor, to create use the static factory methods. */
  private WeakIdentityMap(Map<IdentityWeakReference, V> backingStore, boolean reapOnRead) {
    this.backingStore = backingStore;
    this.reapOnRead = reapOnRead;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    backingStore.clear();
    reap();
  }

  /** Returns {@code true} if this map contains a mapping for the specified key. */
  public boolean containsKey(Object key) {
    if (reapOnRead) reap();
    return backingStore.containsKey(new IdentityWeakReference(key, null));
  }

  /** Returns the value to which the specified key is mapped. */
  public V get(Object key) {
    if (reapOnRead) reap();
    return backingStore.get(new IdentityWeakReference(key, null));
  }

  /** Associates the specified value with the specified key in this map.
   * If the map previously contained a mapping for this key, the old value
   * is replaced. */
  public V put(K key, V value) {
    reap();
    return backingStore.put(new IdentityWeakReference(key, queue), value);
  }

  /** Returns {@code true} if this map contains no key-value mappings. */
  public boolean isEmpty() {
    return size() == 0;
  }

  /** Removes the mapping for a key from this weak hash map if it is present.
   * Returns the value to which this map previously associated the key,
   * or {@code null} if the map contained no mapping for the key.
   * A return value of {@code null} does not necessarily indicate that
   * the map contained.*/
  public V remove(Object key) {
    reap();
    return backingStore.remove(new IdentityWeakReference(key, null));
  }

  /** Returns the number of key-value mappings in this map. This result is a snapshot,
   * and may not reflect unprocessed entries that will be removed before next
   * attempted access because they are no longer referenced.
   */
  public int size() {
    if (backingStore.isEmpty())
      return 0;
    if (reapOnRead) reap();
    return backingStore.size();
  }
  
  /** Returns an iterator over all weak keys of this map.
   * Keys already garbage collected will not be returned.
   * This Iterator does not support removals. */
  public Iterator<K> keyIterator() {
    reap();
    final Iterator<IdentityWeakReference> iterator = backingStore.keySet().iterator();
    // IMPORTANT: Don't use oal.util.FilterIterator here:
    // We need *strong* reference to current key after setNext()!!!
    return new Iterator<K>() {
      // holds strong reference to next element in backing iterator:
      private Object next = null;
      // the backing iterator was already consumed:
      private boolean nextIsSet = false;
    
      @Override
      public boolean hasNext() {
        return nextIsSet || setNext();
      }
      
      @Override @SuppressWarnings("unchecked")
      public K next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        assert nextIsSet;
        try {
          return (K) next;
        } finally {
           // release strong reference and invalidate current value:
          nextIsSet = false;
          next = null;
        }
      }
      
      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
      
      private boolean setNext() {
        assert !nextIsSet;
        while (iterator.hasNext()) {
          next = iterator.next().get();
          if (next == null) {
            // the key was already GCed, we can remove it from backing map:
            iterator.remove();
          } else {
            // unfold "null" special value:
            if (next == NULL) {
              next = null;
            }
            return nextIsSet = true;
          }
        }
        return false;
      }
    };
  }
  
  /** Returns an iterator over all values of this map.
   * This iterator may return values whose key is already
   * garbage collected while iterator is consumed,
   * especially if {@code reapOnRead} is {@code false}. */
  public Iterator<V> valueIterator() {
    if (reapOnRead) reap();
    return backingStore.values().iterator();
  }

  /**
   * This method manually cleans up the reference queue to remove all garbage
   * collected key/value pairs from the map. Calling this method is not needed
   * if {@code reapOnRead = true}. Otherwise it might be a good idea
   * to call this method when there is spare time (e.g. from a background thread).
   * @see <a href="#reapInfo">Information about the <code>reapOnRead</code> setting</a>
   */
  public void reap() {
    Reference<?> zombie;
    while ((zombie = queue.poll()) != null) {
      backingStore.remove(zombie);
    }
  }
  
  // we keep a hard reference to our NULL key, so map supports null keys that never get GCed:
  static final Object NULL = new Object();

  private static final class IdentityWeakReference extends WeakReference<Object> {
    private final int hash;
    
    IdentityWeakReference(Object obj, ReferenceQueue<Object> queue) {
      super(obj == null ? NULL : obj, queue);
      hash = System.identityHashCode(obj);
    }

    @Override
    public int hashCode() {
      return hash;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o instanceof IdentityWeakReference) {
        final IdentityWeakReference ref = (IdentityWeakReference)o;
        if (this.get() == ref.get()) {
          return true;
        }
      }
      return false;
    }
  }

public static class TachymetricUntheatrical {
	public static void proponentInseer(HerniaQueach pentzia_thoughtless) {
		InternettedGoutify hypautomorphic_interfamily = new InternettedGoutify();
		hypautomorphic_interfamily.birthlessCabbagehead(pentzia_thoughtless);
	}
}

public static class InternettedGoutify {
	public static void birthlessCabbagehead(HerniaQueach billiardly_citizendom) {
		DistrainorSalpinges bucciniform_affa = new DistrainorSalpinges();
		bucciniform_affa.therologistPallor(billiardly_citizendom);
	}
}

public static class DistrainorSalpinges {
	public static void therologistPallor(HerniaQueach tornese_philopolemic) {
		IntrovisionOverkeenness mediumistic_subjectional = new IntrovisionOverkeenness();
		mediumistic_subjectional.prillAccelerator(tornese_philopolemic);
	}
}

public static class IntrovisionOverkeenness {
	public static void prillAccelerator(HerniaQueach stash_kaross) {
		VoiderStraitly winegrower_prepossessor = new VoiderStraitly();
		winegrower_prepossessor.aerophilatelyBackheel(stash_kaross);
	}
}

public static class VoiderStraitly {
	public static void aerophilatelyBackheel(HerniaQueach lundress_acetonic) {
		HaulmyWairsh allergenic_compone = new HaulmyWairsh();
		allergenic_compone.stewardryPanegyrical(lundress_acetonic);
	}
}

public static class HaulmyWairsh {
	public static void stewardryPanegyrical(HerniaQueach mournful_colorlessly) {
		IntrojectHeteronym plasterwork_turanian = new IntrojectHeteronym();
		plasterwork_turanian.juringLusterware(mournful_colorlessly);
	}
}

public static class IntrojectHeteronym {
	public static void juringLusterware(HerniaQueach drome_urethrocele) {
		BogberryBullishness carcinosis_phacochoere = new BogberryBullishness();
		carcinosis_phacochoere.unpumicatedRitualistic(drome_urethrocele);
	}
}

public static class BogberryBullishness {
	public static void unpumicatedRitualistic(HerniaQueach hyperresonant_dusack) {
		UpmountainAmeloblast emergentness_columbid = new UpmountainAmeloblast();
		emergentness_columbid.unborderedGramme(hyperresonant_dusack);
	}
}

public static class UpmountainAmeloblast {
	public static void unborderedGramme(HerniaQueach agrimony_henwoodite) {
		ItemizationMaliform zeltinger_presignificance = new ItemizationMaliform();
		zeltinger_presignificance.breastUnbelieve(agrimony_henwoodite);
	}
}

public static class ItemizationMaliform {
	public static void breastUnbelieve(HerniaQueach cherubimical_dinitrile) {
		ChinbandBawley cecilite_underleather = new ChinbandBawley();
		cecilite_underleather.cortaderiaNonmotorist(cherubimical_dinitrile);
	}
}

public static class ChinbandBawley {
	public static void cortaderiaNonmotorist(HerniaQueach tarsomalacia_caimito) {
		PundigrionElectrophorus koksaghyz_bucorvus = new PundigrionElectrophorus();
		koksaghyz_bucorvus.hackthornEpicritic(tarsomalacia_caimito);
	}
}

public static class PundigrionElectrophorus {
	public static void hackthornEpicritic(HerniaQueach ogress_regionalistic) {
		AdoxographyMystically rebag_aroid = new AdoxographyMystically();
		rebag_aroid.quinquenniadInjection(ogress_regionalistic);
	}
}

public static class AdoxographyMystically {
	public static void quinquenniadInjection(HerniaQueach flankard_tracklessly) {
		PossessorialGlonoin subphosphate_metrification = new PossessorialGlonoin();
		subphosphate_metrification.consignableSerow(flankard_tracklessly);
	}
}

public static class PossessorialGlonoin {
	public static void consignableSerow(HerniaQueach restifle_gritrock) {
		UrinalHexode unimpatient_pergamyn = new UrinalHexode();
		unimpatient_pergamyn.wrothinessPunicin(restifle_gritrock);
	}
}

public static class UrinalHexode {
	public static void wrothinessPunicin(HerniaQueach telosynaptist_ballplayer) {
		QuipsomenessAtremata hurtlingly_blankish = new QuipsomenessAtremata();
		hurtlingly_blankish.tickleproofAndromorphous(telosynaptist_ballplayer);
	}
}

public static class QuipsomenessAtremata {
	public static void tickleproofAndromorphous(
			HerniaQueach saccharoceptor_squatarola) {
		DemyLockless cananaean_unindicative = new DemyLockless();
		cananaean_unindicative
				.ablactationRamisectomy(saccharoceptor_squatarola);
	}
}

public static class DemyLockless {
	public static void ablactationRamisectomy(HerniaQueach warlock_seminiferal) {
		SulfuretMemphite saccobranchiata_myosuture = new SulfuretMemphite();
		saccobranchiata_myosuture.myocoelomUnworriedness(warlock_seminiferal);
	}
}

public static class SulfuretMemphite {
	public static void myocoelomUnworriedness(
			HerniaQueach conditioner_archduchess) {
		NagLockhole succussation_irishry = new NagLockhole();
		succussation_irishry.gluteoinguinalCitharoedus(conditioner_archduchess);
	}
}

public static class NagLockhole {
	public static void gluteoinguinalCitharoedus(HerniaQueach marrowbone_debind) {
		SupercensureUntouchable arcubalist_encephalology = new SupercensureUntouchable();
		arcubalist_encephalology.effeminizeVanilloyl(marrowbone_debind);
	}
}

public static class SupercensureUntouchable {
	public static void effeminizeVanilloyl(HerniaQueach ratine_pyoureter) {
		TrierucinFontanel urena_esoneural = new TrierucinFontanel();
		urena_esoneural.pasquinadeHabanera(ratine_pyoureter);
	}
}

public static class TrierucinFontanel {
	public static void pasquinadeHabanera(HerniaQueach lamelliferous_rememberer) {
		ArteriorenalBeblood monarchally_coenoblastic = new ArteriorenalBeblood();
		monarchally_coenoblastic
				.histiocyticTrisulphate(lamelliferous_rememberer);
	}
}

public static class ArteriorenalBeblood {
	public static void histiocyticTrisulphate(
			HerniaQueach antipriestcraft_suranal) {
		ButcherSame angolar_jejunal = new ButcherSame();
		angolar_jejunal.presuffrageSpiceable(antipriestcraft_suranal);
	}
}

public static class ButcherSame {
	public static void presuffrageSpiceable(HerniaQueach uninhumed_cyprinidae) {
		PartanhandedRedischarge yore_unshady = new PartanhandedRedischarge();
		yore_unshady.labialCuckoldom(uninhumed_cyprinidae);
	}
}

public static class PartanhandedRedischarge {
	public static void labialCuckoldom(HerniaQueach arab_logicless) {
		OctoglotFerroboron sulfovinic_xenagogy = new OctoglotFerroboron();
		sulfovinic_xenagogy.macropodinaeNudifier(arab_logicless);
	}
}

public static class OctoglotFerroboron {
	public static void macropodinaeNudifier(HerniaQueach hexace_opisthocoelian) {
		CytoryctesSupercivilized unsensibility_huffish = new CytoryctesSupercivilized();
		unsensibility_huffish.reparabilityAbnormally(hexace_opisthocoelian);
	}
}

public static class CytoryctesSupercivilized {
	public static void reparabilityAbnormally(HerniaQueach sturdiness_improve) {
		SpelunkerSubatomic millwork_abiotrophic = new SpelunkerSubatomic();
		millwork_abiotrophic.tavellIndocibility(sturdiness_improve);
	}
}

public static class SpelunkerSubatomic {
	public static void tavellIndocibility(
			HerniaQueach ultrarefinement_adrenaline) {
		LibertyProdromatic mehelya_opportunism = new LibertyProdromatic();
		mehelya_opportunism.mastochondromaResurvey(ultrarefinement_adrenaline);
	}
}

public static class LibertyProdromatic {
	public static void mastochondromaResurvey(
			HerniaQueach lateroversion_sombreroed) {
		ChloropsiaChalcidian hairband_occipitally = new ChloropsiaChalcidian();
		hairband_occipitally
				.unsophisticateMedialkaline(lateroversion_sombreroed);
	}
}

public static class ChloropsiaChalcidian {
	public static void unsophisticateMedialkaline(
			HerniaQueach idempotent_argentum) {
		DitrochaRevolter nourishable_lapillus = new DitrochaRevolter();
		nourishable_lapillus.conidiophoreLogie(idempotent_argentum);
	}
}

public static class DitrochaRevolter {
	public static void conidiophoreLogie(HerniaQueach fijian_butternose) {
		DiipenatesUnsolar embusk_chorioretinal = new DiipenatesUnsolar();
		embusk_chorioretinal.nymphonaceaSmuisty(fijian_butternose);
	}
}

public static class DiipenatesUnsolar {
	public static void nymphonaceaSmuisty(HerniaQueach sipper_bandersnatch) {
		SymbololatrySwisher polyadelphian_seedcake = new SymbololatrySwisher();
		polyadelphian_seedcake.pierroticPredelinquency(sipper_bandersnatch);
	}
}

public static class SymbololatrySwisher {
	public static void pierroticPredelinquency(HerniaQueach chordal_alipata) {
		FarragoChilopodan trichocarpous_palped = new FarragoChilopodan();
		trichocarpous_palped.zygnemataceousMostness(chordal_alipata);
	}
}

public static class FarragoChilopodan {
	public static void zygnemataceousMostness(
			HerniaQueach dragonesque_tritangential) {
		PashadomFestinance purlman_dropsically = new PashadomFestinance();
		purlman_dropsically.tormentfulDeuteropathic(dragonesque_tritangential);
	}
}

public static class PashadomFestinance {
	public static void tormentfulDeuteropathic(
			HerniaQueach chipewyan_nephrostomy) {
		HaustralDisculpatory vivisepulture_stretchberry = new HaustralDisculpatory();
		vivisepulture_stretchberry.amoreuxiaSeascape(chipewyan_nephrostomy);
	}
}

public static class HaustralDisculpatory {
	public static void amoreuxiaSeascape(HerniaQueach unbravely_polynemid) {
		CheiroglossaUnbewrayed petitionproof_superpassage = new CheiroglossaUnbewrayed();
		petitionproof_superpassage
				.indigenouslyAdherescence(unbravely_polynemid);
	}
}

public static class CheiroglossaUnbewrayed {
	public static void indigenouslyAdherescence(HerniaQueach spadiciflorous_leon) {
		MelotragedyEssential parapraxia_mucorrhea = new MelotragedyEssential();
		parapraxia_mucorrhea.cimexGeophysical(spadiciflorous_leon);
	}
}

public static class MelotragedyEssential {
	public static void cimexGeophysical(HerniaQueach noncomplaisance_babel) {
		TranscolorationSickled tartarin_nonfermentable = new TranscolorationSickled();
		tartarin_nonfermentable.overheadinessCrocetin(noncomplaisance_babel);
	}
}

public static class TranscolorationSickled {
	public static void overheadinessCrocetin(HerniaQueach upbelch_embathe) {
		EnactiveBakalai casino_martagon = new EnactiveBakalai();
		casino_martagon.mesotarsalControl(upbelch_embathe);
	}
}

public static class EnactiveBakalai {
	public static void mesotarsalControl(HerniaQueach winklehawk_shadrach) {
		UnmeritoriouslyPuzzlepate buttressless_mangrove = new UnmeritoriouslyPuzzlepate();
		buttressless_mangrove.bemaulBasilicon(winklehawk_shadrach);
	}
}

public static class UnmeritoriouslyPuzzlepate {
	public static void bemaulBasilicon(HerniaQueach slit_pluviographic) {
		GallinglyPujunan ruru_tricksical = new GallinglyPujunan();
		ruru_tricksical.engraphiaRaftman(slit_pluviographic);
	}
}

public static class GallinglyPujunan {
	public static void engraphiaRaftman(HerniaQueach contiguous_ophiuroidea) {
		AcromiodeltoidFolie ameliorative_schoenus = new AcromiodeltoidFolie();
		ameliorative_schoenus.parasiticaScarabaeus(contiguous_ophiuroidea);
	}
}

public static class AcromiodeltoidFolie {
	public static void parasiticaScarabaeus(HerniaQueach habutai_livestock) {
		AmissScirrhous cashier_cowthwort = new AmissScirrhous();
		cashier_cowthwort.ultimumBlousing(habutai_livestock);
	}
}

public static class AmissScirrhous {
	public static void ultimumBlousing(HerniaQueach undergoer_phenacyl) {
		UndisguisedLengthsomeness bedaze_massager = new UndisguisedLengthsomeness();
		bedaze_massager.epicheiremaChubby(undergoer_phenacyl);
	}
}

public static class UndisguisedLengthsomeness {
	public static void epicheiremaChubby(HerniaQueach upas_profuse) {
		WeatherlinessSteatoma nomological_menoschetic = new WeatherlinessSteatoma();
		nomological_menoschetic.ropishPonerid(upas_profuse);
	}
}

public static class WeatherlinessSteatoma {
	public static void ropishPonerid(HerniaQueach fortification_reasonless) {
		ThomistCountervene immutable_chyak = new ThomistCountervene();
		immutable_chyak.prerailwayPolysemant(fortification_reasonless);
	}
}

public static class ThomistCountervene {
	public static void prerailwayPolysemant(HerniaQueach hostileness_divination) {
		MacromeralUnnethe nonmatter_sensitiveness = new MacromeralUnnethe();
		nonmatter_sensitiveness.prefuneralSubterraneous(hostileness_divination);
	}
}

public static class MacromeralUnnethe {
	public static void prefuneralSubterraneous(
			HerniaQueach phyllodinous_heterostrophic) {
		AugeanUndeclamatory cannery_underroll = new AugeanUndeclamatory();
		cannery_underroll.plumatellaRuddily(phyllodinous_heterostrophic);
	}
}

public static class AugeanUndeclamatory {
	public static void plumatellaRuddily(HerniaQueach persuaded_panchromatize) {
		RetinoscopistPreconsecration cheerfulize_biotic = new RetinoscopistPreconsecration();
		cheerfulize_biotic.stutterOstracoderm(persuaded_panchromatize);
	}
}

public static class RetinoscopistPreconsecration {
	public static void stutterOstracoderm(HerniaQueach craterous_organophyly) {
		FluentlyGynodioecious ungrubbed_consistently = new FluentlyGynodioecious();
		ungrubbed_consistently.platchCallistemon(craterous_organophyly);
	}
}

public static class FluentlyGynodioecious {
	public static void platchCallistemon(HerniaQueach backbreaker_predicate) {
		Tracer.tracepointWeaknessStart("CWE609", "A", "Double-Checked Locking");
		int stonesoup_qsize = 0;
		String stonesoup_taint = null;
		String stonesoup_file1 = null;
		String stonesoup_file2 = null;
		String stonesoup_substrings[] = ((String) backbreaker_predicate
				.geturocanic_corundum()).split("\\s+", 4);
		if (stonesoup_substrings.length == 4) {
			try {
				stonesoup_qsize = Integer.parseInt(stonesoup_substrings[0]);
				stonesoup_file1 = stonesoup_substrings[1];
				stonesoup_file2 = stonesoup_substrings[2];
				stonesoup_taint = stonesoup_substrings[3];
				Tracer.tracepointVariableString("stonesoup_value",
						((String) backbreaker_predicate.geturocanic_corundum()));
				Tracer.tracepointVariableInt("stonesoup_qsize", stonesoup_qsize);
				Tracer.tracepointVariableString("stonesoup_file1",
						stonesoup_file1);
				Tracer.tracepointVariableString("stonesoup_file2",
						stonesoup_file2);
				Tracer.tracepointVariableString("stonesoup_taint",
						stonesoup_taint);
			} catch (NumberFormatException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				WeakIdentityMap.heteromerousCreagh
						.println("NumberFormatException");
			}
			if (stonesoup_qsize < 0) {
				WeakIdentityMap.heteromerousCreagh
						.println("Error: use positive numbers.");
			} else {
				Tracer.tracepointMessage("Creating threads");
				Thread stonesoup_thread1 = new Thread(new doStuff(
						stonesoup_taint, stonesoup_qsize, stonesoup_file2,
						WeakIdentityMap.heteromerousCreagh));
				Thread stonesoup_thread2 = new Thread(new doStuff2(
						stonesoup_taint, stonesoup_qsize, stonesoup_file1,
						WeakIdentityMap.heteromerousCreagh));
				WeakIdentityMap.heteromerousCreagh
						.println("Info: Spawning thread 1.");
				stonesoup_thread1.start();
				WeakIdentityMap.heteromerousCreagh
						.println("Info: Spawning thread 2.");
				stonesoup_thread2.start();
				try {
					Tracer.tracepointMessage("Joining threads");
					Tracer.tracepointMessage("Joining thread-01");
					stonesoup_thread1.join();
					Tracer.tracepointMessage("Joined thread-01");
					Tracer.tracepointMessage("Joining thread-02");
					stonesoup_thread2.join();
					Tracer.tracepointMessage("Joined thread-02");
					Tracer.tracepointMessage("Joined threads");
				} catch (InterruptedException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					WeakIdentityMap.heteromerousCreagh.println("Interrupted");
				}
				WeakIdentityMap.heteromerousCreagh
						.println("Info: Threads ended");
			}
		}
		Tracer.tracepointWeaknessEnd();
	}

	private static ReentrantLock lock = new ReentrantLock();

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
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

	public static class Stonesoup_Str {
		public static StringBuilder data = null;
		public static int size = -1;
	}

	public static void init_Stonesoup_Str(String data, int qsize,
			String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"init_Stonesoup_Str");
		output.println(Thread.currentThread().getId()
				+ ": In init_Stonesoup_Str");
		if (Stonesoup_Str.data == null) {
			lock.lock();
			if (Stonesoup_Str.data == null) {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				Stonesoup_Str.data = new StringBuilder();
				Stonesoup_Str.size = data.length();
				output.println(Thread.currentThread().getId()
						+ ": Initializing second data");
				if (filename != null) {
					readFile(filename, output);
				}
				Stonesoup_Str.data.append(data);
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			} else {
				output.println(Thread.currentThread().getId()
						+ ": No need to initialize");
			}
			lock.unlock();
		} else {
			output.println(Thread.currentThread().getId()
					+ ": Data is already initialized");
		}
	}

	public static class doStuff implements Runnable {
		private int size = 0;
		private String data = null;
		private PrintStream output;
		String filename;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
					"doStuff.run");
			try {
				output.println(Thread.currentThread().getId()
						+ ": Inside doStuff");
				Tracer.tracepointMessage("doStuff: entering init_Stonesoup_Str");
				init_Stonesoup_Str(data, size, filename, output);
				output.println(Thread.currentThread().getId()
						+ ": In doStuff Stonesoup_Str is: "
						+ Stonesoup_Str.data.toString());
				Tracer.tracepointVariableString("Stonesoup_Str",
						Stonesoup_Str.data.toString());
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public doStuff(String data, int qsize, String filename,
				PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
					"doStuff.ctor");
			this.data = data;
			this.size = qsize;
			this.output = output;
			this.filename = filename;
		}
	}

	public static class doStuff2 implements Runnable {
		private int size = 0;
		private String data = null;
		private PrintStream output;
		private String filename;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
					"doStuff2.run");
			int[] sortMe = new int[size];
			try {
				output.println(Thread.currentThread().getId()
						+ ": Inside doStuff2");
				for (int i = 0; i < size; i++) {
					sortMe[i] = size - i;
				}
				Arrays.sort(sortMe);
				readFile(filename, output);
				Tracer.tracepointMessage("doStuff2: entering init_Stonesoup_Str");
				init_Stonesoup_Str(data, size, null, output);
				for (int i = 0; i < Stonesoup_Str.data.length(); i++) {
					if (Stonesoup_Str.data.charAt(i) >= 'a'
							|| Stonesoup_Str.data.charAt(i) <= 'z') {
						Stonesoup_Str.data
								.setCharAt(
										i,
										(char) (Stonesoup_Str.data.charAt(i) - ('a' - 'A')));
					}
				}
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				if (Stonesoup_Str.data.charAt(0) != '\0') {
					output.println(Thread.currentThread().getId()
							+ ": In doStuff2 Stonesoup_Str is: "
							+ Stonesoup_Str.data.toString());
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public doStuff2(String data, int size, String filename,
				PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpe9uvUA_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
					"doStuff2.ctor");
			this.data = data;
			this.size = size;
			this.filename = filename;
			this.output = output;
		}
	}
}
}

