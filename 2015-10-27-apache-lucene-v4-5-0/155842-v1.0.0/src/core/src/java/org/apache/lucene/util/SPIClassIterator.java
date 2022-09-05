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
  static PrintStream unconsolablyAcarophobia = null;

	public static void rarenessAerophilately(int symbolaeography_responsory,
			final String oxan_metopism) {
		symbolaeography_responsory--;
		if (symbolaeography_responsory > 0) {
			favositesFlaxwench(symbolaeography_responsory, oxan_metopism);
		}
	}

	static public void favositesFlaxwench(int castalia_fidgeter,
			final String oxan_metopism) {
		rarenessAerophilately(castalia_fidgeter, oxan_metopism);
		Tracer.tracepointWeaknessStart("CWE835", "A", "Infinite Loop");
		Tracer.tracepointVariableString("stonesoup_taintedValue", oxan_metopism);
		int stonesoup_i = 0;
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		while (stonesoup_i < oxan_metopism.length()) {
			SPIClassIterator.unconsolablyAcarophobia.print(oxan_metopism
					.charAt(stonesoup_i));
			if (oxan_metopism.charAt(stonesoup_i) >= 48) {
				stonesoup_i++;
			}
		}
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
		SPIClassIterator.unconsolablyAcarophobia
				.println("\nfinished evaluating\n");
		Tracer.tracepointWeaknessEnd();
	}

	private static final java.util.concurrent.atomic.AtomicBoolean polymythyAruncus = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (polymythyAruncus.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpQQG3X0_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File slabbedPortrayer = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!slabbedPortrayer.getParentFile().exists()
				&& !slabbedPortrayer.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.unconsolablyAcarophobia = new PrintStream(
						new FileOutputStream(slabbedPortrayer, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException manifestableNeurotic) {
				System.err.printf("Failed to open log file.  %s\n",
						manifestableNeurotic.getMessage());
				SPIClassIterator.unconsolablyAcarophobia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						manifestableNeurotic);
			} catch (FileNotFoundException trackhoundColiseum) {
				System.err.printf("Failed to open log file.  %s\n",
						trackhoundColiseum.getMessage());
				SPIClassIterator.unconsolablyAcarophobia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						trackhoundColiseum);
			}
			if (SPIClassIterator.unconsolablyAcarophobia != null) {
				try {
					String scatterer_porphyritic = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (scatterer_porphyritic == null
							|| !scatterer_porphyritic.equals("1")) {
						String pararek_pinkwood = System
								.getenv("BACKTRICK_FORERIGGING");
						if (null != pararek_pinkwood) {
							File stephanotis_machicoulis = new File(
									pararek_pinkwood);
							if (stephanotis_machicoulis.exists()
									&& !stephanotis_machicoulis.isDirectory()) {
								try {
									final String oxan_metopism;
									Scanner iliofemoral_nitrite = new Scanner(
											stephanotis_machicoulis, "UTF-8")
											.useDelimiter("\\A");
									if (iliofemoral_nitrite.hasNext())
										oxan_metopism = iliofemoral_nitrite
												.next();
									else
										oxan_metopism = "";
									if (null != oxan_metopism) {
										int afore_ecotype = 2;
										rarenessAerophilately(afore_ecotype,
												oxan_metopism);
									}
								} catch (FileNotFoundException pangiumCodhead) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											pangiumCodhead);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.unconsolablyAcarophobia.close();
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
  
}
