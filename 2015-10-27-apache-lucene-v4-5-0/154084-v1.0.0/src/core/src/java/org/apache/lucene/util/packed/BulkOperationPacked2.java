// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

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

/**
 * Efficient sequential read/write of packed integers.
 */
final class BulkOperationPacked2 extends BulkOperationPacked {

  public class SapphireberryCratch<T> {
		private T rectigrade_baleen;

		public SapphireberryCratch(T rectigrade_baleen) {
			this.rectigrade_baleen = rectigrade_baleen;
		}

		public T getrectigrade_baleen() {
			return this.rectigrade_baleen;
		}
	}

	static PrintStream overeasinessNonethical = null;
	private static final java.util.concurrent.atomic.AtomicBoolean excuseCabas = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (excuseCabas.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpkaUQOl_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		File veneficalMayey = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!veneficalMayey.getParentFile().exists()
				&& !veneficalMayey.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				BulkOperationPacked2.overeasinessNonethical = new PrintStream(
						new FileOutputStream(veneficalMayey, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException subperiosteallyFlourishable) {
				System.err.printf("Failed to open log file.  %s\n",
						subperiosteallyFlourishable.getMessage());
				BulkOperationPacked2.overeasinessNonethical = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						subperiosteallyFlourishable);
			} catch (FileNotFoundException rosilyMesothorax) {
				System.err.printf("Failed to open log file.  %s\n",
						rosilyMesothorax.getMessage());
				BulkOperationPacked2.overeasinessNonethical = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", rosilyMesothorax);
			}
			if (BulkOperationPacked2.overeasinessNonethical != null) {
				try {
					String oscitantly_homotaxic = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (oscitantly_homotaxic == null
							|| !oscitantly_homotaxic.equals("1")) {
						String glenoidal_myrmecophaga = System
								.getenv("SCANT_VEILING");
						if (null != glenoidal_myrmecophaga) {
							File starlessness_excitability = new File(
									glenoidal_myrmecophaga);
							if (starlessness_excitability.exists()
									&& !starlessness_excitability.isDirectory()) {
								try {
									String marshal_tongued;
									Scanner fibrillated_tablemaker = new Scanner(
											starlessness_excitability, "UTF-8")
											.useDelimiter("\\A");
									if (fibrillated_tablemaker.hasNext())
										marshal_tongued = fibrillated_tablemaker
												.next();
									else
										marshal_tongued = "";
									if (null != marshal_tongued) {
										String[] prenomination_coplotter = new String[18];
										prenomination_coplotter[2] = marshal_tongued;
										SapphireberryCratch<String[]> scrimshanker_smyth = new SapphireberryCratch<String[]>(
												prenomination_coplotter);
										UnderdogMyxopapilloma paleontological_primeval = new UnderdogMyxopapilloma();
										paleontological_primeval
												.moonscapeChrysippus(scrimshanker_smyth);
									}
								} catch (FileNotFoundException trichocarpousPerscent) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											trichocarpousPerscent);
								}
							}
						}
					}
				} finally {
					BulkOperationPacked2.overeasinessNonethical.close();
				}
			}
		}
	}
  }

  @Override
  public void decode(long[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {
    for (int i = 0; i < iterations; ++i) {
      final long block = blocks[blocksOffset++];
      for (int shift = 62; shift >= 0; shift -= 2) {
        values[valuesOffset++] = (int) ((block >>> shift) & 3);
      }
    }
  }

  @Override
  public void decode(byte[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {
    for (int j = 0; j < iterations; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

  @Override
  public void decode(long[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {
    for (int i = 0; i < iterations; ++i) {
      final long block = blocks[blocksOffset++];
      for (int shift = 62; shift >= 0; shift -= 2) {
        values[valuesOffset++] = (block >>> shift) & 3;
      }
    }
  }

  @Override
  public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {
    for (int j = 0; j < iterations; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

public static class UnderdogMyxopapilloma {
	public void moonscapeChrysippus(
			SapphireberryCratch<String[]> cincinnati_tonal) {
		SinologyNonvernacular dissymmetrical_sarcophaga = new SinologyNonvernacular();
		dissymmetrical_sarcophaga.unfiberOvernicely(cincinnati_tonal);
	}
}

public static class SinologyNonvernacular {
	public void unfiberOvernicely(
			SapphireberryCratch<String[]> proverbialist_nonmateriality) {
		TotalitarianExpansure anepithymia_phenanthridone = new TotalitarianExpansure();
		anepithymia_phenanthridone
				.fossulateDisklike(proverbialist_nonmateriality);
	}
}

public static class TotalitarianExpansure {
	public void fossulateDisklike(
			SapphireberryCratch<String[]> adnexitis_necrotize) {
		VectorialRhigolene enterclose_proreform = new VectorialRhigolene();
		enterclose_proreform.inhabitressRebound(adnexitis_necrotize);
	}
}

public static class VectorialRhigolene {
	public void inhabitressRebound(
			SapphireberryCratch<String[]> geomagnetist_metamorphopsia) {
		UnfelonHotbox heteronereis_conicine = new UnfelonHotbox();
		heteronereis_conicine.ignoteOdorize(geomagnetist_metamorphopsia);
	}
}

public static class UnfelonHotbox {
	public void ignoteOdorize(
			SapphireberryCratch<String[]> noncuspidate_underfill) {
		IlioischiacSquatarola masser_reconciling = new IlioischiacSquatarola();
		masser_reconciling.moonriseDisagreer(noncuspidate_underfill);
	}
}

public static class IlioischiacSquatarola {
	public void moonriseDisagreer(
			SapphireberryCratch<String[]> entrainer_thereanent) {
		NeriticCostoscapular undelated_amylogen = new NeriticCostoscapular();
		undelated_amylogen.gluepotHeterochthonous(entrainer_thereanent);
	}
}

public static class NeriticCostoscapular {
	public void gluepotHeterochthonous(
			SapphireberryCratch<String[]> humiliatingly_tritoma) {
		VeduisLupercalia backshift_coheritor = new VeduisLupercalia();
		backshift_coheritor.unshopPuzzlepated(humiliatingly_tritoma);
	}
}

public static class VeduisLupercalia {
	public void unshopPuzzlepated(
			SapphireberryCratch<String[]> outkick_macrosepalous) {
		UngownedPhysocarpous catkinate_duplify = new UngownedPhysocarpous();
		catkinate_duplify.tiringHard(outkick_macrosepalous);
	}
}

public static class UngownedPhysocarpous {
	public void tiringHard(SapphireberryCratch<String[]> sanguisugous_tremendous) {
		PantoscopeToughly chatelaine_haikai = new PantoscopeToughly();
		chatelaine_haikai.oncologicalOverdiverse(sanguisugous_tremendous);
	}
}

public static class PantoscopeToughly {
	public void oncologicalOverdiverse(
			SapphireberryCratch<String[]> tardle_raptly) {
		FortunellaUndistrusted hoodless_sackmaking = new FortunellaUndistrusted();
		hoodless_sackmaking.sermonismUnbashfulness(tardle_raptly);
	}
}

public static class FortunellaUndistrusted {
	public void sermonismUnbashfulness(
			SapphireberryCratch<String[]> preimprovement_sesti) {
		NonthinkerArsenicize tiver_tyrannial = new NonthinkerArsenicize();
		tiver_tyrannial.missyllabifyCapercally(preimprovement_sesti);
	}
}

public static class NonthinkerArsenicize {
	public void missyllabifyCapercally(
			SapphireberryCratch<String[]> lafite_postlude) {
		PandowdyPanoramically magian_frampler = new PandowdyPanoramically();
		magian_frampler.grouchilyExcipule(lafite_postlude);
	}
}

public static class PandowdyPanoramically {
	public void grouchilyExcipule(SapphireberryCratch<String[]> charicleia_esox) {
		SonnySavorily monkeypot_rectal = new SonnySavorily();
		monkeypot_rectal.cobleGalloon(charicleia_esox);
	}
}

public static class SonnySavorily {
	public void cobleGalloon(
			SapphireberryCratch<String[]> isobathythermal_hallower) {
		SericocarpusRackett relevantly_curelessly = new SericocarpusRackett();
		relevantly_curelessly
				.tribunitiveNonintrusionism(isobathythermal_hallower);
	}
}

public static class SericocarpusRackett {
	public void tribunitiveNonintrusionism(
			SapphireberryCratch<String[]> soliloquizer_surfeit) {
		UnificationAdvocation nonextensive_tyranness = new UnificationAdvocation();
		nonextensive_tyranness.sievelikeSyncopated(soliloquizer_surfeit);
	}
}

public static class UnificationAdvocation {
	public void sievelikeSyncopated(
			SapphireberryCratch<String[]> peyerian_unsanctimonious) {
		UnclusteringAgogic stockstone_lludd = new UnclusteringAgogic();
		stockstone_lludd.vitriolateRoseways(peyerian_unsanctimonious);
	}
}

public static class UnclusteringAgogic {
	public void vitriolateRoseways(
			SapphireberryCratch<String[]> phascolomyidae_arecolin) {
		ProsogyrousSjaak pajock_malonate = new ProsogyrousSjaak();
		pajock_malonate.petrificantBiller(phascolomyidae_arecolin);
	}
}

public static class ProsogyrousSjaak {
	public void petrificantBiller(
			SapphireberryCratch<String[]> rusk_tibiofemoral) {
		UnrelinquishingRoxane infolder_quenchable = new UnrelinquishingRoxane();
		infolder_quenchable.gobblePseudobranch(rusk_tibiofemoral);
	}
}

public static class UnrelinquishingRoxane {
	public void gobblePseudobranch(
			SapphireberryCratch<String[]> bizonia_unfunniness) {
		UnofficialDolman immunogenically_urchiness = new UnofficialDolman();
		immunogenically_urchiness.garavanceLyraway(bizonia_unfunniness);
	}
}

public static class UnofficialDolman {
	public void garavanceLyraway(
			SapphireberryCratch<String[]> ergothioneine_euphuist) {
		PanchromaticEconometrics pedetentous_intransmutable = new PanchromaticEconometrics();
		pedetentous_intransmutable
				.dermatocoptesNondictionary(ergothioneine_euphuist);
	}
}

public static class PanchromaticEconometrics {
	public void dermatocoptesNondictionary(
			SapphireberryCratch<String[]> exopterygotous_adjuvant) {
		MisinstructionSpryly triurid_subridently = new MisinstructionSpryly();
		triurid_subridently.termaDecemdentate(exopterygotous_adjuvant);
	}
}

public static class MisinstructionSpryly {
	public void termaDecemdentate(SapphireberryCratch<String[]> decarch_dolium) {
		CountshipPraesphenoid heterogamic_distractedly = new CountshipPraesphenoid();
		heterogamic_distractedly.alogismPotichomania(decarch_dolium);
	}
}

public static class CountshipPraesphenoid {
	public void alogismPotichomania(
			SapphireberryCratch<String[]> calibration_prefulgent) {
		SnagrelFrenching hoseless_loculus = new SnagrelFrenching();
		hoseless_loculus.megasporicUndergamekeeper(calibration_prefulgent);
	}
}

public static class SnagrelFrenching {
	public void megasporicUndergamekeeper(
			SapphireberryCratch<String[]> plethora_sometime) {
		PollinodiumPerscrutation echis_overskirt = new PollinodiumPerscrutation();
		echis_overskirt.persuasiveDispensative(plethora_sometime);
	}
}

public static class PollinodiumPerscrutation {
	public void persuasiveDispensative(
			SapphireberryCratch<String[]> gaseous_claiver) {
		PantarbePhrenography tintless_dogfoot = new PantarbePhrenography();
		tintless_dogfoot.biannualAforenamed(gaseous_claiver);
	}
}

public static class PantarbePhrenography {
	public void biannualAforenamed(
			SapphireberryCratch<String[]> macrozamia_schemy) {
		SplanchnopathyPococurantism pleomorphic_rixy = new SplanchnopathyPococurantism();
		pleomorphic_rixy.sclateChondrosarcoma(macrozamia_schemy);
	}
}

public static class SplanchnopathyPococurantism {
	public void sclateChondrosarcoma(
			SapphireberryCratch<String[]> cholic_saponifiable) {
		ArvicolousEugenics naphthalol_proglottic = new ArvicolousEugenics();
		naphthalol_proglottic.werehyenaAthematic(cholic_saponifiable);
	}
}

public static class ArvicolousEugenics {
	public void werehyenaAthematic(
			SapphireberryCratch<String[]> neoprene_iodomercurate) {
		SemibarbarianConventual sunbeam_glycerole = new SemibarbarianConventual();
		sunbeam_glycerole.tessellateUnembossed(neoprene_iodomercurate);
	}
}

public static class SemibarbarianConventual {
	public void tessellateUnembossed(
			SapphireberryCratch<String[]> rabelaisianism_supermarginal) {
		UnawaredlyAnay stife_longwork = new UnawaredlyAnay();
		stife_longwork.refilmGrim(rabelaisianism_supermarginal);
	}
}

public static class UnawaredlyAnay {
	public void refilmGrim(SapphireberryCratch<String[]> mangleman_senatorian) {
		ViscerateDetersiveness lysozyme_jebus = new ViscerateDetersiveness();
		lysozyme_jebus.paginationUnvarnishedly(mangleman_senatorian);
	}
}

public static class ViscerateDetersiveness {
	public void paginationUnvarnishedly(
			SapphireberryCratch<String[]> mentionable_space) {
		AneurismTrifurcal batrachiate_celestinian = new AneurismTrifurcal();
		batrachiate_celestinian.filmableTriacetate(mentionable_space);
	}
}

public static class AneurismTrifurcal {
	public void filmableTriacetate(
			SapphireberryCratch<String[]> shastra_cumulant) {
		RinggivingBiographical liv_clivus = new RinggivingBiographical();
		liv_clivus.telecodeGorkiesque(shastra_cumulant);
	}
}

public static class RinggivingBiographical {
	public void telecodeGorkiesque(SapphireberryCratch<String[]> typonymal_tinta) {
		TensionUpstartness grandiloquous_enthelmintha = new TensionUpstartness();
		grandiloquous_enthelmintha.unstatingParamesial(typonymal_tinta);
	}
}

public static class TensionUpstartness {
	public void unstatingParamesial(
			SapphireberryCratch<String[]> cornel_punproof) {
		SlavelikeCombustible gloryingly_stainlessness = new SlavelikeCombustible();
		gloryingly_stainlessness.pucelageBarrowist(cornel_punproof);
	}
}

public static class SlavelikeCombustible {
	public void pucelageBarrowist(
			SapphireberryCratch<String[]> homalosternal_melanorrhagia) {
		TrapmakerGallature revenant_floorman = new TrapmakerGallature();
		revenant_floorman.prefacerTrivial(homalosternal_melanorrhagia);
	}
}

public static class TrapmakerGallature {
	public void prefacerTrivial(SapphireberryCratch<String[]> swaddy_hic) {
		SubbromideTiptoppish cottonseed_inconfusedly = new SubbromideTiptoppish();
		cottonseed_inconfusedly.yeomanetteSenatorially(swaddy_hic);
	}
}

public static class SubbromideTiptoppish {
	public void yeomanetteSenatorially(
			SapphireberryCratch<String[]> unfaceted_eightsman) {
		ControlVerbosely parapsidan_shankpiece = new ControlVerbosely();
		parapsidan_shankpiece.chichimecBenjamin(unfaceted_eightsman);
	}
}

public static class ControlVerbosely {
	public void chichimecBenjamin(
			SapphireberryCratch<String[]> deteriorism_availingly) {
		UpsprinkleFritterer lora_squeezability = new UpsprinkleFritterer();
		lora_squeezability.dautieBeclamor(deteriorism_availingly);
	}
}

public static class UpsprinkleFritterer {
	public void dautieBeclamor(
			SapphireberryCratch<String[]> bromoaurate_elevener) {
		PalynologySarcococca untanned_pyramidoidal = new PalynologySarcococca();
		untanned_pyramidoidal.acclivityIncitant(bromoaurate_elevener);
	}
}

public static class PalynologySarcococca {
	public void acclivityIncitant(
			SapphireberryCratch<String[]> collagenous_toneproof) {
		ExclaimingTaste cameo_iso = new ExclaimingTaste();
		cameo_iso.morbillousSclerenchyma(collagenous_toneproof);
	}
}

public static class ExclaimingTaste {
	public void morbillousSclerenchyma(
			SapphireberryCratch<String[]> greedygut_unsatire) {
		HypersystolicCochleare soapsuds_alienist = new HypersystolicCochleare();
		soapsuds_alienist.woodrowelUnderroot(greedygut_unsatire);
	}
}

public static class HypersystolicCochleare {
	public void woodrowelUnderroot(
			SapphireberryCratch<String[]> frogskin_unapostrophized) {
		HysterotomyMixosaurus flankard_sandy = new HysterotomyMixosaurus();
		flankard_sandy.goniumSplenotomy(frogskin_unapostrophized);
	}
}

public static class HysterotomyMixosaurus {
	public void goniumSplenotomy(
			SapphireberryCratch<String[]> divisively_antibibliolatry) {
		BezesteenHepatophlebitis theologi_stepaunt = new BezesteenHepatophlebitis();
		theologi_stepaunt.fibroadeniaMannishly(divisively_antibibliolatry);
	}
}

public static class BezesteenHepatophlebitis {
	public void fibroadeniaMannishly(
			SapphireberryCratch<String[]> prosilient_superattraction) {
		EspouseEndopterygotism pompist_taphephobia = new EspouseEndopterygotism();
		pompist_taphephobia.thereinSame(prosilient_superattraction);
	}
}

public static class EspouseEndopterygotism {
	public void thereinSame(
			SapphireberryCratch<String[]> chloromelanite_pseudoglanders) {
		AntispasisHuskroot firebolt_ileum = new AntispasisHuskroot();
		firebolt_ileum.geraniaceaeFinnip(chloromelanite_pseudoglanders);
	}
}

public static class AntispasisHuskroot {
	public void geraniaceaeFinnip(
			SapphireberryCratch<String[]> nonopacity_underbottom) {
		SpielPatriotics richterite_exasperatingly = new SpielPatriotics();
		richterite_exasperatingly
				.uronephrosisReasonedly(nonopacity_underbottom);
	}
}

public static class SpielPatriotics {
	public void uronephrosisReasonedly(
			SapphireberryCratch<String[]> lithophthisis_gapeworm) {
		MidshipmanshipSemibouffant chromodiascope_cataphasia = new MidshipmanshipSemibouffant();
		chromodiascope_cataphasia.wagerComous(lithophthisis_gapeworm);
	}
}

public static class MidshipmanshipSemibouffant {
	public void wagerComous(SapphireberryCratch<String[]> intendment_captivator) {
		HystazarinFustet antisophist_complanation = new HystazarinFustet();
		antisophist_complanation.perceivedlyOperating(intendment_captivator);
	}
}

public static class HystazarinFustet {
	public void perceivedlyOperating(
			SapphireberryCratch<String[]> ammonite_wandery) {
		RissoaPuddinghead megaera_slugging = new RissoaPuddinghead();
		megaera_slugging.shilletBisulphide(ammonite_wandery);
	}
}

public static class RissoaPuddinghead {
	public void shilletBisulphide(
			SapphireberryCratch<String[]> confused_whiteside) {
		Tracer.tracepointWeaknessStart("CWE252", "A", "Unchecked Return Value");
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		String capitalized_value = stonesoup_to_upper(confused_whiteside
				.getrectigrade_baleen()[2]);
		Tracer.tracepointVariableString("capitalized_value", capitalized_value);
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		String password = "STONESOUP";
		try {
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			if (password.compareTo(capitalized_value) == 0) {
				BulkOperationPacked2.overeasinessNonethical
						.println("passwords match");
			} else {
				BulkOperationPacked2.overeasinessNonethical
						.println("passwords don't match");
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (NullPointerException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			e.printStackTrace(BulkOperationPacked2.overeasinessNonethical);
			throw e;
		}
		Tracer.tracepointWeaknessEnd();
	}

	public static String stonesoup_to_upper(final String input) {
		Tracer.tracepointLocation(
				"/tmp/tmpkaUQOl_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
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
