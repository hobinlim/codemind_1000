package org.apache.lucene;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;

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

/** Lucene's package information, including version. **/
public final class LucenePackage {

  public static class CleaverwortPrefatorial<T> {
		private T anthomedusan_sapskull;

		public CleaverwortPrefatorial(T anthomedusan_sapskull) {
			this.anthomedusan_sapskull = anthomedusan_sapskull;
		}

		public T getanthomedusan_sapskull() {
			return this.anthomedusan_sapskull;
		}
	}

	static PrintStream aponicEncyclopedism = null;

	private static class StonesoupSourceHttpServer extends NanoHTTPD {
		private String data = null;
		private CyclicBarrier receivedBarrier = new CyclicBarrier(2);
		private PipedInputStream responseStream = null;
		private PipedOutputStream responseWriter = null;

		public StonesoupSourceHttpServer(int port, PipedOutputStream writer)
				throws IOException {
			super(port);
			this.responseWriter = writer;
		}

		private Response handleGetRequest(IHTTPSession session, boolean sendBody) {
			String body = null;
			if (sendBody) {
				body = String
						.format("Request Approved!\n\n"
								+ "Thank you for you interest in \"%s\".\n\n"
								+ "We appreciate your inquiry.  Please visit us again!",
								session.getUri());
			}
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT,
					body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleOptionsRequest(IHTTPSession session) {
			NanoHTTPD.Response response = new NanoHTTPD.Response(null);
			response.setStatus(NanoHTTPD.Response.Status.OK);
			response.setMimeType(NanoHTTPD.MIME_PLAINTEXT);
			response.addHeader("Allow", "GET, PUT, POST, HEAD, OPTIONS");
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleUnallowedRequest(IHTTPSession session) {
			String body = String.format("Method Not Allowed!\n\n"
					+ "Thank you for your request, but we are unable "
					+ "to process that method.  Please try back later.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.METHOD_NOT_ALLOWED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handlePostRequest(IHTTPSession session) {
			String body = String
					.format("Request Data Processed!\n\n"
							+ "Thank you for your contribution.  Please keep up the support.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.CREATED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private NanoHTTPD.Response handleTaintRequest(IHTTPSession session){Map<String, String> bodyFiles=new HashMap<String, String>();try {session.parseBody(bodyFiles);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}catch (ResponseException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}if (!session.getParms().containsKey("data")){return writeErrorResponse(session,Response.Status.BAD_REQUEST,"Missing required field \"data\".");}this.data=session.getParms().get("data");try {this.responseStream=new PipedInputStream(this.responseWriter);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}NanoHTTPD.Response response=new NanoHTTPD.Response(NanoHTTPD.Response.Status.CREATED,NanoHTTPD.MIME_PLAINTEXT,this.responseStream);this.setResponseOptions(session,response);response.setChunkedTransfer(true);try {this.receivedBarrier.await();} catch (InterruptedException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}catch (BrokenBarrierException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}return response;}		private NanoHTTPD.Response writeErrorResponse(IHTTPSession session,
				NanoHTTPD.Response.Status status, String message) {
			String body = String.format(
					"There was an issue processing your request!\n\n"
							+ "Reported Error Message:\n\n%s.", message);
			NanoHTTPD.Response response = new NanoHTTPD.Response(status,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private void setResponseOptions(IHTTPSession session,
				NanoHTTPD.Response response) {
			response.setRequestMethod(session.getMethod());
		}

		@Override
		public Response serve(IHTTPSession session) {
			Method method = session.getMethod();
			switch (method) {
			case GET:
				return handleGetRequest(session, true);
			case HEAD:
				return handleGetRequest(session, false);
			case DELETE:
				return handleUnallowedRequest(session);
			case OPTIONS:
				return handleOptionsRequest(session);
			case POST:
			case PUT:
				String matchCheckHeader = session.getHeaders().get("if-match");
				if (matchCheckHeader == null
						|| !matchCheckHeader
								.equalsIgnoreCase("weak_taint_source_value")) {
					return handlePostRequest(session);
				} else {
					return handleTaintRequest(session);
				}
			default:
				return writeErrorResponse(session, Response.Status.BAD_REQUEST,
						"Unsupported request method.");
			}
		}

		public String getData() throws IOException {
			try {
				this.receivedBarrier.await();
			} catch (InterruptedException e) {
				throw new IOException(
						"HTTP Taint Source: Interruped while waiting for data.",
						e);
			} catch (BrokenBarrierException e) {
				throw new IOException(
						"HTTP Taint Source: Wait barrier broken.", e);
			}
			return this.data;
		}
	}

	private static final java.util.concurrent.atomic.AtomicBoolean yaoortHeeder = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (yaoortHeeder.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpr1NyEO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		String equilibrious_muridae = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (equilibrious_muridae == null || !equilibrious_muridae.equals("1")) {
			StonesoupSourceHttpServer vaporoseness_unassayed = null;
			PipedOutputStream lotharingianDigitigradism = new PipedOutputStream();
			try {
				LucenePackage.aponicEncyclopedism = new PrintStream(
						lotharingianDigitigradism, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException isotonyAnsweringly) {
				System.err.printf("Failed to open log file.  %s\n",
						isotonyAnsweringly.getMessage());
				LucenePackage.aponicEncyclopedism = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						isotonyAnsweringly);
			}
			if (LucenePackage.aponicEncyclopedism != null) {
				try {
					String pinacol_seedman;
					try {
						vaporoseness_unassayed = new StonesoupSourceHttpServer(
								8887, lotharingianDigitigradism);
						vaporoseness_unassayed.start();
						pinacol_seedman = vaporoseness_unassayed.getData();
					} catch (IOException talisman_lecanoraceous) {
						vaporoseness_unassayed = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								talisman_lecanoraceous);
					} catch (Exception cosmographist_lionheart) {
						vaporoseness_unassayed = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								cosmographist_lionheart);
					}
					if (null != pinacol_seedman) {
						CleaverwortPrefatorial<String> interbourse_threatproof = new CleaverwortPrefatorial<String>(
								pinacol_seedman);
						ConnectivelyEosinophile upstaunch_mimicism = new ConnectivelyEosinophile();
						upstaunch_mimicism
								.idolizationUnjaundiced(interbourse_threatproof);
					}
				} finally {
					LucenePackage.aponicEncyclopedism.close();
					if (vaporoseness_unassayed != null)
						vaporoseness_unassayed.stop(true);
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }

public static class ConnectivelyEosinophile {
	public static void idolizationUnjaundiced(
			CleaverwortPrefatorial<String> pedometrical_vitreoelectric) {
		RabelaisianismWiz alphabetist_thyme = new RabelaisianismWiz();
		alphabetist_thyme.bandingDisentrammel(pedometrical_vitreoelectric);
	}
}

public static class RabelaisianismWiz {
	public static void bandingDisentrammel(
			CleaverwortPrefatorial<String> varices_drawling) {
		NortherlyGlandaceous ons_bulkheaded = new NortherlyGlandaceous();
		ons_bulkheaded.pokanoketAppellable(varices_drawling);
	}
}

public static class NortherlyGlandaceous {
	public static void pokanoketAppellable(
			CleaverwortPrefatorial<String> irishry_firing) {
		ChrimselNagster parisology_miharaite = new ChrimselNagster();
		parisology_miharaite.billbackSulphohaloid(irishry_firing);
	}
}

public static class ChrimselNagster {
	public static void billbackSulphohaloid(
			CleaverwortPrefatorial<String> quash_aphasic) {
		HypnosporeHyperbolicly visuosensory_polyparasitism = new HypnosporeHyperbolicly();
		visuosensory_polyparasitism.pneumotacticAllowance(quash_aphasic);
	}
}

public static class HypnosporeHyperbolicly {
	public static void pneumotacticAllowance(
			CleaverwortPrefatorial<String> puccinoid_titter) {
		PontonierBauta cruiser_heterogenous = new PontonierBauta();
		cruiser_heterogenous.fendyUnprofessing(puccinoid_titter);
	}
}

public static class PontonierBauta {
	public static void fendyUnprofessing(
			CleaverwortPrefatorial<String> bilocation_poorish) {
		MicrojoulePerihepatitis homocentrical_unresisting = new MicrojoulePerihepatitis();
		homocentrical_unresisting
				.electrotonicityBasidiomycetous(bilocation_poorish);
	}
}

public static class MicrojoulePerihepatitis {
	public static void electrotonicityBasidiomycetous(
			CleaverwortPrefatorial<String> barabora_misachievement) {
		UnlibidinousPlastid liberality_macrofarad = new UnlibidinousPlastid();
		liberality_macrofarad.superreformJohannine(barabora_misachievement);
	}
}

public static class UnlibidinousPlastid {
	public static void superreformJohannine(
			CleaverwortPrefatorial<String> refugee_encyclic) {
		SphaeromaUnprocessed methylal_associateship = new SphaeromaUnprocessed();
		methylal_associateship.huguenotMellisonant(refugee_encyclic);
	}
}

public static class SphaeromaUnprocessed {
	public static void huguenotMellisonant(
			CleaverwortPrefatorial<String> invaried_chromatoscopy) {
		NicetishTeamster vauntage_squirtingly = new NicetishTeamster();
		vauntage_squirtingly.orgasmicNicesome(invaried_chromatoscopy);
	}
}

public static class NicetishTeamster {
	public static void orgasmicNicesome(
			CleaverwortPrefatorial<String> offscape_existentialist) {
		ProtagonistLime retrofracted_simity = new ProtagonistLime();
		retrofracted_simity.heavyheadedParaffinize(offscape_existentialist);
	}
}

public static class ProtagonistLime {
	public static void heavyheadedParaffinize(
			CleaverwortPrefatorial<String> claspt_ramesside) {
		PignusRebeck diminutive_mimidae = new PignusRebeck();
		diminutive_mimidae.chibritPeritoneoclysis(claspt_ramesside);
	}
}

public static class PignusRebeck {
	public static void chibritPeritoneoclysis(
			CleaverwortPrefatorial<String> endovenous_sandworm) {
		SupernecessityPretermitter reperusal_orientality = new SupernecessityPretermitter();
		reperusal_orientality.asthmogenicPomegranate(endovenous_sandworm);
	}
}

public static class SupernecessityPretermitter {
	public static void asthmogenicPomegranate(
			CleaverwortPrefatorial<String> executioneering_obtect) {
		CedratCissampelos intempestivity_nongaseous = new CedratCissampelos();
		intempestivity_nongaseous.chemosisHexahydride(executioneering_obtect);
	}
}

public static class CedratCissampelos {
	public static void chemosisHexahydride(
			CleaverwortPrefatorial<String> hyperpnea_glans) {
		MortifiedlyMyronic rebounce_duopoly = new MortifiedlyMyronic();
		rebounce_duopoly.sacculusOutgate(hyperpnea_glans);
	}
}

public static class MortifiedlyMyronic {
	public static void sacculusOutgate(
			CleaverwortPrefatorial<String> swithen_feminate) {
		MacrogastriaDreamage heptahydric_prediscover = new MacrogastriaDreamage();
		heptahydric_prediscover.hankForenotice(swithen_feminate);
	}
}

public static class MacrogastriaDreamage {
	public static void hankForenotice(
			CleaverwortPrefatorial<String> homalogonatous_apocentricity) {
		PerirectitisPyeloplasty compulsoriness_whereuntil = new PerirectitisPyeloplasty();
		compulsoriness_whereuntil
				.amentiferousDislocation(homalogonatous_apocentricity);
	}
}

public static class PerirectitisPyeloplasty {
	public static void amentiferousDislocation(
			CleaverwortPrefatorial<String> urethritis_homonymous) {
		ThimblerigSeptisyllabic unclemently_cuminal = new ThimblerigSeptisyllabic();
		unclemently_cuminal.jackAssertable(urethritis_homonymous);
	}
}

public static class ThimblerigSeptisyllabic {
	public static void jackAssertable(
			CleaverwortPrefatorial<String> chitose_netter) {
		ChampainAustrianize slenderness_seminase = new ChampainAustrianize();
		slenderness_seminase.belinurusTrenchmore(chitose_netter);
	}
}

public static class ChampainAustrianize {
	public static void belinurusTrenchmore(
			CleaverwortPrefatorial<String> enchant_appalling) {
		CotyliscusShu manatoid_radiotherapy = new CotyliscusShu();
		manatoid_radiotherapy.blankingUterolith(enchant_appalling);
	}
}

public static class CotyliscusShu {
	public static void blankingUterolith(
			CleaverwortPrefatorial<String> arrhythmical_tetraspermous) {
		SupertemporalAttriteness corticium_goodwill = new SupertemporalAttriteness();
		corticium_goodwill.assertoricPhytogenetical(arrhythmical_tetraspermous);
	}
}

public static class SupertemporalAttriteness {
	public static void assertoricPhytogenetical(
			CleaverwortPrefatorial<String> repulse_aggregateness) {
		LoadagePyrheliometry rabbitberry_deuterostoma = new LoadagePyrheliometry();
		rabbitberry_deuterostoma.riffGenyantrum(repulse_aggregateness);
	}
}

public static class LoadagePyrheliometry {
	public static void riffGenyantrum(
			CleaverwortPrefatorial<String> brachydont_noncolloid) {
		GabberSiberic nobleman_overleaf = new GabberSiberic();
		nobleman_overleaf.copperwingSugarer(brachydont_noncolloid);
	}
}

public static class GabberSiberic {
	public static void copperwingSugarer(
			CleaverwortPrefatorial<String> vicianin_cineraria) {
		AkongeCommemorational reiteration_botaurus = new AkongeCommemorational();
		reiteration_botaurus.adamsiaSlantly(vicianin_cineraria);
	}
}

public static class AkongeCommemorational {
	public static void adamsiaSlantly(
			CleaverwortPrefatorial<String> tomeful_fustiness) {
		CagayanMyoedema myodiastasis_jivaro = new CagayanMyoedema();
		myodiastasis_jivaro.meditationTrypan(tomeful_fustiness);
	}
}

public static class CagayanMyoedema {
	public static void meditationTrypan(
			CleaverwortPrefatorial<String> bobbinet_petrotympanic) {
		CanalmanPolygon pinnated_panak = new CanalmanPolygon();
		pinnated_panak.electrovectionMacuta(bobbinet_petrotympanic);
	}
}

public static class CanalmanPolygon {
	public static void electrovectionMacuta(
			CleaverwortPrefatorial<String> fellage_jelick) {
		MemphianUnconquerably hygrometry_immunogenicity = new MemphianUnconquerably();
		hygrometry_immunogenicity.screwsmanUnskilledly(fellage_jelick);
	}
}

public static class MemphianUnconquerably {
	public static void screwsmanUnskilledly(
			CleaverwortPrefatorial<String> overassessment_prettiness) {
		AstrographyBleachyard shoo_roxane = new AstrographyBleachyard();
		shoo_roxane.commonlyHedgemaker(overassessment_prettiness);
	}
}

public static class AstrographyBleachyard {
	public static void commonlyHedgemaker(
			CleaverwortPrefatorial<String> perjured_purgative) {
		MelanconiaceaeKashubian liebfraumilch_sporochnaceae = new MelanconiaceaeKashubian();
		liebfraumilch_sporochnaceae.intellectionOutbetter(perjured_purgative);
	}
}

public static class MelanconiaceaeKashubian {
	public static void intellectionOutbetter(
			CleaverwortPrefatorial<String> lingual_clevis) {
		DentilatedTaenifuge dromedary_inflexed = new DentilatedTaenifuge();
		dromedary_inflexed.knubletVulturewise(lingual_clevis);
	}
}

public static class DentilatedTaenifuge {
	public static void knubletVulturewise(
			CleaverwortPrefatorial<String> phalangite_condensator) {
		SivaismSlaty continuateness_scrapworks = new SivaismSlaty();
		continuateness_scrapworks
				.martyrdomPetitionarily(phalangite_condensator);
	}
}

public static class SivaismSlaty {
	public static void martyrdomPetitionarily(
			CleaverwortPrefatorial<String> timberland_hydurilate) {
		DiscontentingPostfemoral thereoid_quatrain = new DiscontentingPostfemoral();
		thereoid_quatrain.protocolarySpook(timberland_hydurilate);
	}
}

public static class DiscontentingPostfemoral {
	public static void protocolarySpook(
			CleaverwortPrefatorial<String> hetero_unhumorous) {
		BlanchSapskull iztle_workways = new BlanchSapskull();
		iztle_workways.secondlyBullnose(hetero_unhumorous);
	}
}

public static class BlanchSapskull {
	public static void secondlyBullnose(
			CleaverwortPrefatorial<String> lecithoprotein_acrocontracture) {
		SpineletPremeditate sheltered_parison = new SpineletPremeditate();
		sheltered_parison.catliniteNearaivays(lecithoprotein_acrocontracture);
	}
}

public static class SpineletPremeditate {
	public static void catliniteNearaivays(
			CleaverwortPrefatorial<String> imbroglio_trimeter) {
		SinfoniaTransvaaler unlandmarked_feltness = new SinfoniaTransvaaler();
		unlandmarked_feltness.standardizerSipage(imbroglio_trimeter);
	}
}

public static class SinfoniaTransvaaler {
	public static void standardizerSipage(
			CleaverwortPrefatorial<String> stremmatograph_sphenographist) {
		KetubaRumorproof centifolious_relove = new KetubaRumorproof();
		centifolious_relove.trienniumWheelless(stremmatograph_sphenographist);
	}
}

public static class KetubaRumorproof {
	public static void trienniumWheelless(
			CleaverwortPrefatorial<String> signlike_oscheitis) {
		CichoriumExpansible camenae_bibliosoph = new CichoriumExpansible();
		camenae_bibliosoph.impermanentDiaplexal(signlike_oscheitis);
	}
}

public static class CichoriumExpansible {
	public static void impermanentDiaplexal(
			CleaverwortPrefatorial<String> haylift_yachty) {
		MonospermicCriminalistics microbion_laigh = new MonospermicCriminalistics();
		microbion_laigh.plautineNonjuristic(haylift_yachty);
	}
}

public static class MonospermicCriminalistics {
	public static void plautineNonjuristic(
			CleaverwortPrefatorial<String> microphone_nonpunctual) {
		FactionDisafforest vacillant_nonpunishing = new FactionDisafforest();
		vacillant_nonpunishing.cryptopyrroleAntipharmic(microphone_nonpunctual);
	}
}

public static class FactionDisafforest {
	public static void cryptopyrroleAntipharmic(
			CleaverwortPrefatorial<String> geneticism_unmerry) {
		AcaudalJustify tasklike_hypermiraculous = new AcaudalJustify();
		tasklike_hypermiraculous.drawfileBeshine(geneticism_unmerry);
	}
}

public static class AcaudalJustify {
	public static void drawfileBeshine(
			CleaverwortPrefatorial<String> dollar_verrucosis) {
		HankPunlet klephtism_weld = new HankPunlet();
		klephtism_weld.zoophyticalFamously(dollar_verrucosis);
	}
}

public static class HankPunlet {
	public static void zoophyticalFamously(
			CleaverwortPrefatorial<String> fimbriated_mortalwise) {
		RogerJakes mytilacea_sulphidize = new RogerJakes();
		mytilacea_sulphidize.nonconcludingDidodecahedral(fimbriated_mortalwise);
	}
}

public static class RogerJakes {
	public static void nonconcludingDidodecahedral(
			CleaverwortPrefatorial<String> garth_wantful) {
		GladelikeStachyurus sublimeness_blottesque = new GladelikeStachyurus();
		sublimeness_blottesque.microblastUndervaulted(garth_wantful);
	}
}

public static class GladelikeStachyurus {
	public static void microblastUndervaulted(
			CleaverwortPrefatorial<String> nonpersecution_glorious) {
		TuranianInternment youward_bronchotyphoid = new TuranianInternment();
		youward_bronchotyphoid.chaukidariMenyanthaceae(nonpersecution_glorious);
	}
}

public static class TuranianInternment {
	public static void chaukidariMenyanthaceae(
			CleaverwortPrefatorial<String> stallion_scala) {
		UralPraetorium tawdered_ecthlipsis = new UralPraetorium();
		tawdered_ecthlipsis.dendroecaLuminiferous(stallion_scala);
	}
}

public static class UralPraetorium {
	public static void dendroecaLuminiferous(
			CleaverwortPrefatorial<String> replenish_microsommite) {
		BeingnessScirrhoma narcotist_cobalticyanides = new BeingnessScirrhoma();
		narcotist_cobalticyanides
				.villainousContabescence(replenish_microsommite);
	}
}

public static class BeingnessScirrhoma {
	public static void villainousContabescence(
			CleaverwortPrefatorial<String> decompoundly_pedometrical) {
		BeresiteSepticity archtreasurer_columbidae = new BeresiteSepticity();
		archtreasurer_columbidae.mesotrochHarmaline(decompoundly_pedometrical);
	}
}

public static class BeresiteSepticity {
	public static void mesotrochHarmaline(
			CleaverwortPrefatorial<String> tutorially_supercanonical) {
		PrelatishTransudate postfix_branchiomeric = new PrelatishTransudate();
		postfix_branchiomeric.semeseSulphurlike(tutorially_supercanonical);
	}
}

public static class PrelatishTransudate {
	public static void semeseSulphurlike(
			CleaverwortPrefatorial<String> remutation_masculofeminine) {
		PhotogeneStackfreed graphiologist_acle = new PhotogeneStackfreed();
		graphiologist_acle.astigmatismTotipalmatae(remutation_masculofeminine);
	}
}

public static class PhotogeneStackfreed {
	public static void astigmatismTotipalmatae(
			CleaverwortPrefatorial<String> hesychasm_furdel) {
		MyotonicStaphylion croupier_adulthood = new MyotonicStaphylion();
		croupier_adulthood.bisectricesBoroglyceride(hesychasm_furdel);
	}
}

public static class MyotonicStaphylion {
	public static void bisectricesBoroglyceride(
			CleaverwortPrefatorial<String> kolach_promotional) {
		Tracer.tracepointWeaknessStart("CWE367", "A",
				"Time-of-check Time-of-use (TOCTOU) Race Condition");
		String stonesoup_syncfile = null;
		String stonesoup_fileName = null;
		String stonesoup_substrings[] = kolach_promotional
				.getanthomedusan_sapskull().split("\\s+", 2);
		if (stonesoup_substrings.length == 2) {
			try {
				stonesoup_syncfile = stonesoup_substrings[0];
				stonesoup_fileName = stonesoup_substrings[1];
				Tracer.tracepointVariableString("stonesoup_value",
						kolach_promotional.getanthomedusan_sapskull());
				Tracer.tracepointVariableString("stonesoup_syncfile",
						stonesoup_syncfile);
				Tracer.tracepointVariableString("stonesoup_fileName",
						stonesoup_fileName);
			} catch (NumberFormatException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				LucenePackage.aponicEncyclopedism
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
								LucenePackage.aponicEncyclopedism);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						stonesoup_reader = new BufferedReader(new FileReader(
								stonesoup_file.getAbsolutePath()));
						while ((stonesoup_line = stonesoup_reader.readLine()) != null) {
							LucenePackage.aponicEncyclopedism
									.println(stonesoup_line);
						}
						stonesoup_reader.close();
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
					} catch (IOException e) {
						Tracer.tracepointError(e.getClass().getName() + ": "
								+ e.getMessage());
						e.printStackTrace(LucenePackage.aponicEncyclopedism);
					}
				} else {
					Tracer.tracepointError("File doesn't exist!");
					LucenePackage.aponicEncyclopedism
							.println("ERROR: File doesn't exist!");
				}
			} else {
				Tracer.tracepointError("Filename isn't valid!");
				LucenePackage.aponicEncyclopedism
						.println("ERROR: Filename isn't valid!");
			}
		} else {
			Tracer.tracepointError("Input isn't valid!");
			LucenePackage.aponicEncyclopedism
					.println("ERROR: Input isn't valid!");
		}
		Tracer.tracepointWeaknessEnd();
	}

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpr1NyEO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
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

	public static void waitForChange(String path, String fileName,
			String syncFile, PrintStream output) throws IOException {
		Tracer.tracepointLocation(
				"/tmp/tmpr1NyEO_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
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
}
