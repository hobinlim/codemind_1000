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
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  static PrintStream ichthyoliticIntroductress = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean chloridellaComplete = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (chloridellaComplete.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpsU0OlY_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		String kinescope_circuitous = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (kinescope_circuitous == null || !kinescope_circuitous.equals("1")) {
			StonesoupSourceHttpServer lachrymonasal_gamp = null;
			PipedOutputStream unhearingThymegol = new PipedOutputStream();
			try {
				SPIClassIterator.ichthyoliticIntroductress = new PrintStream(
						unhearingThymegol, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException peripatizeCornin) {
				System.err.printf("Failed to open log file.  %s\n",
						peripatizeCornin.getMessage());
				SPIClassIterator.ichthyoliticIntroductress = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						peripatizeCornin);
			}
			if (SPIClassIterator.ichthyoliticIntroductress != null) {
				try {
					String ruminantia_tallowweed;
					try {
						lachrymonasal_gamp = new StonesoupSourceHttpServer(
								8887, unhearingThymegol);
						lachrymonasal_gamp.start();
						ruminantia_tallowweed = lachrymonasal_gamp.getData();
					} catch (IOException nonexternality_coprophyte) {
						lachrymonasal_gamp = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								nonexternality_coprophyte);
					} catch (Exception bdellid_nullifier) {
						lachrymonasal_gamp = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								bdellid_nullifier);
					}
					if (null != ruminantia_tallowweed) {
						short aenach_semicarbonize;
						try {
							aenach_semicarbonize = Short
									.parseShort(ruminantia_tallowweed);
						} catch (NumberFormatException functional_ceylanite) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									functional_ceylanite);
						}
						short[] carnage_microradiometer = new short[29];
						carnage_microradiometer[19] = aenach_semicarbonize;
						dieContravener(carnage_microradiometer);
					}
				} finally {
					SPIClassIterator.ichthyoliticIntroductress.close();
					if (lachrymonasal_gamp != null)
						lachrymonasal_gamp.stop(true);
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

public static void dieContravener(short[] rachitis_thalamocoele) {
	sagamiteUranolatry(rachitis_thalamocoele);
}

public static void sagamiteUranolatry(short[] necromancy_unrelented) {
	undomicilableSemicentenary(necromancy_unrelented);
}

public static void undomicilableSemicentenary(short[] rannigal_platting) {
	virilescenceCoetaneousness(rannigal_platting);
}

public static void virilescenceCoetaneousness(short[] supermarginal_radiography) {
	subincidentTassel(supermarginal_radiography);
}

public static void subincidentTassel(short[] metascutal_unperceptible) {
	megalaemaCandleball(metascutal_unperceptible);
}

public static void megalaemaCandleball(short[] anaetiological_inconclusive) {
	analepticalDartmoor(anaetiological_inconclusive);
}

public static void analepticalDartmoor(short[] musicomania_icosahedral) {
	whitefootSubventive(musicomania_icosahedral);
}

public static void whitefootSubventive(short[] irreproachably_semiconic) {
	peritremaMicrogeology(irreproachably_semiconic);
}

public static void peritremaMicrogeology(short[] tipsifier_recap) {
	etiologistThiobacteria(tipsifier_recap);
}

public static void etiologistThiobacteria(short[] oligodynamic_sowable) {
	sacrificatureSniffishness(oligodynamic_sowable);
}

public static void sacrificatureSniffishness(short[] chondroxiphoid_lacerta) {
	utraquismCommissure(chondroxiphoid_lacerta);
}

public static void utraquismCommissure(short[] besnivel_deflation) {
	ectodermicBrainache(besnivel_deflation);
}

public static void ectodermicBrainache(short[] psychoda_papillomatosis) {
	amperySteenbock(psychoda_papillomatosis);
}

public static void amperySteenbock(short[] serpentess_nonproductive) {
	unpebbledTreatableness(serpentess_nonproductive);
}

public static void unpebbledTreatableness(short[] flounderingly_brideship) {
	spiderUnfailableness(flounderingly_brideship);
}

public static void spiderUnfailableness(short[] trifa_lackadaisy) {
	creationistUtchy(trifa_lackadaisy);
}

public static void creationistUtchy(short[] distort_layer) {
	hayliftDeckel(distort_layer);
}

public static void hayliftDeckel(short[] bicrural_borough) {
	ferinenessWolfberry(bicrural_borough);
}

public static void ferinenessWolfberry(short[] clothesline_swap) {
	josefiteChoirboy(clothesline_swap);
}

public static void josefiteChoirboy(short[] fream_sheriat) {
	necropolitanBeelike(fream_sheriat);
}

public static void necropolitanBeelike(short[] hemautograph_bacteriology) {
	pistolographyEthene(hemautograph_bacteriology);
}

public static void pistolographyEthene(short[] disenshroud_grasshopperish) {
	logogriphicPolyphore(disenshroud_grasshopperish);
}

public static void logogriphicPolyphore(short[] antipepsin_chatterbox) {
	squdgyUnsauced(antipepsin_chatterbox);
}

public static void squdgyUnsauced(short[] nyctalopic_jeanpaulia) {
	chondrophyteRutaecarpine(nyctalopic_jeanpaulia);
}

public static void chondrophyteRutaecarpine(short[] prelatry_madness) {
	hemimetabolicNoway(prelatry_madness);
}

public static void hemimetabolicNoway(short[] supernature_imperformable) {
	kaolinicMousoni(supernature_imperformable);
}

public static void kaolinicMousoni(short[] gutturality_dromaeognathous) {
	ploddingnessGarryaceae(gutturality_dromaeognathous);
}

public static void ploddingnessGarryaceae(short[] overspin_digitinervate) {
	cheiromancyKetoxime(overspin_digitinervate);
}

public static void cheiromancyKetoxime(short[] semielliptic_palladous) {
	subadjacentAdiposity(semielliptic_palladous);
}

public static void subadjacentAdiposity(short[] subangulate_ophicleidean) {
	monophthongSeptangular(subangulate_ophicleidean);
}

public static void monophthongSeptangular(short[] cupreous_snobocrat) {
	diplomaBedstead(cupreous_snobocrat);
}

public static void diplomaBedstead(short[] antistrike_carcinopolypus) {
	remisslyManagement(antistrike_carcinopolypus);
}

public static void remisslyManagement(short[] strammel_myoalbumose) {
	schoonerLopsided(strammel_myoalbumose);
}

public static void schoonerLopsided(short[] sulker_gluepot) {
	thoracometerBugwort(sulker_gluepot);
}

public static void thoracometerBugwort(short[] psychometry_chlorohydrin) {
	piccoloSpeakeress(psychometry_chlorohydrin);
}

public static void piccoloSpeakeress(short[] superposition_unimbued) {
	quiverishWastingly(superposition_unimbued);
}

public static void quiverishWastingly(short[] uptorn_underpin) {
	isometricallyKeid(uptorn_underpin);
}

public static void isometricallyKeid(short[] examine_bespirit) {
	sigatokaEucaine(examine_bespirit);
}

public static void sigatokaEucaine(short[] angelico_pantie) {
	mountebankAnacid(angelico_pantie);
}

public static void mountebankAnacid(short[] devocalize_vermiformis) {
	chemoreceptorHippidium(devocalize_vermiformis);
}

public static void chemoreceptorHippidium(short[] proverbialist_anthurium) {
	combwiseEigenfunction(proverbialist_anthurium);
}

public static void combwiseEigenfunction(short[] disentanglement_unsour) {
	lyonnessePylorodilator(disentanglement_unsour);
}

public static void lyonnessePylorodilator(short[] haloid_orbitelariae) {
	spiregrassRhapontic(haloid_orbitelariae);
}

public static void spiregrassRhapontic(short[] strelitz_tumion) {
	austafricanDeuterostoma(strelitz_tumion);
}

public static void austafricanDeuterostoma(short[] deliverance_feministic) {
	phytylNearaivays(deliverance_feministic);
}

public static void phytylNearaivays(short[] rhetorically_farctate) {
	tetratheiteUnfestive(rhetorically_farctate);
}

public static void tetratheiteUnfestive(short[] tribromacetic_monitorial) {
	deplenishCounterdike(tribromacetic_monitorial);
}

public static void deplenishCounterdike(short[] semidomed_supermystery) {
	acritolHippidion(semidomed_supermystery);
}

public static void acritolHippidion(short[] czarevna_covalent) {
	ejectablePulwar(czarevna_covalent);
}

public static void ejectablePulwar(short[] thymacetin_skimmed) {
	Tracer.tracepointWeaknessStart("CWE191", "A",
			"Integer Underflow (Wrap or Wraparound)");
	short stonesoup_checked_value = thymacetin_skimmed[19];
	Tracer.tracepointVariableShort("stonesoup_checked_value",
			stonesoup_checked_value);
	if (stonesoup_checked_value < 0) {
		stonesoup_checked_value = 0;
	}
	Tracer.tracepointVariableShort("stonesoup_checked_value",
			stonesoup_checked_value);
	Short[] stonesoup_some_values = new Short[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
			10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	short stonesoup_counter = -20;
	short stonesoup_offset = 40;
	Tracer.tracepointBufferInfo("stonesoup_some_values",
			stonesoup_some_values.length, "Length of stonesoup_some_values");
	Tracer.tracepointVariableShort("stonesoup_counter", stonesoup_counter);
	Tracer.tracepointVariableShort("stonesoup_offset", stonesoup_offset);
	int lttngCtr = 99;
	Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
	Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
	while ((stonesoup_counter + stonesoup_offset > 0)
			&& (stonesoup_counter + stonesoup_offset < stonesoup_some_values.length)) {
		SPIClassIterator.ichthyoliticIntroductress.printf(
				"stonesoup_some_values[%d] : %s\n", stonesoup_counter
						+ stonesoup_offset,
				stonesoup_some_values[stonesoup_counter + stonesoup_offset]);
		if (++lttngCtr >= 100) {
			Tracer.tracepointVariableShort("stonesoup_counter",
					stonesoup_counter);
		}
		stonesoup_counter -= stonesoup_checked_value;
		if (stonesoup_counter > -20) {
			stonesoup_counter = -20;
		}
		if (lttngCtr >= 100) {
			lttngCtr = 1;
			Tracer.tracepointVariableShort("stonesoup_counter",
					stonesoup_counter);
		}
	}
	Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	Tracer.tracepointBufferInfo("stonesoup_some_values",
			stonesoup_some_values.length, "Length of stonesoup_some_values");
	Tracer.tracepointVariableShort("stonesoup_counter", stonesoup_counter);
	Tracer.tracepointVariableShort("stonesoup_offset", stonesoup_offset);
	SPIClassIterator.ichthyoliticIntroductress.println("finished evaluating");
	Tracer.tracepointWeaknessEnd();
}
  
}
