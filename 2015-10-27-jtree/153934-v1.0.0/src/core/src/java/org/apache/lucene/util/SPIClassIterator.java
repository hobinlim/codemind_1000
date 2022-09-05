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
  static PrintStream unvisiblyUntoothsome = null;

	private static final java.util.concurrent.atomic.AtomicBoolean helminthiteInsalivation = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (helminthiteInsalivation.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpqopbP8_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File sclerogenOnan = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!sclerogenOnan.getParentFile().exists()
				&& !sclerogenOnan.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.unvisiblyUntoothsome = new PrintStream(
						new FileOutputStream(sclerogenOnan, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException metagasterInstillment) {
				System.err.printf("Failed to open log file.  %s\n",
						metagasterInstillment.getMessage());
				SPIClassIterator.unvisiblyUntoothsome = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						metagasterInstillment);
			} catch (FileNotFoundException jokinglyHopelessly) {
				System.err.printf("Failed to open log file.  %s\n",
						jokinglyHopelessly.getMessage());
				SPIClassIterator.unvisiblyUntoothsome = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						jokinglyHopelessly);
			}
			if (SPIClassIterator.unvisiblyUntoothsome != null) {
				try {
					String adamine_subworkman = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (adamine_subworkman == null
							|| !adamine_subworkman.equals("1")) {
						String svarabhaktic_elymi = System
								.getenv("HERSHIP_DIHALOGEN");
						if (null != svarabhaktic_elymi) {
							File rux_initiation = new File(svarabhaktic_elymi);
							if (rux_initiation.exists()
									&& !rux_initiation.isDirectory()) {
								try {
									String zoospermium_attitudinarian;
									Scanner axe_auricularian = new Scanner(
											rux_initiation, "UTF-8")
											.useDelimiter("\\A");
									if (axe_auricularian.hasNext())
										zoospermium_attitudinarian = axe_auricularian
												.next();
									else
										zoospermium_attitudinarian = "";
									if (null != zoospermium_attitudinarian) {
										try {
											String underweapon_mysteriosophic = System
													.getProperty("os.name");
											if (null != underweapon_mysteriosophic) {
												if (!underweapon_mysteriosophic
														.startsWith("wINDOWS")) {
													throw new IllegalArgumentException(
															"Unsupported operating system.");
												}
											}
										} catch (IllegalArgumentException phalansterial_ensphere) {
										} finally {
											Tracer.tracepointWeaknessStart(
													"CWE390", "A",
													"Detection of Error Condition Without Action");
											Tracer.tracepointVariableString(
													"filename",
													zoospermium_attitudinarian);
											java.io.FileInputStream fis = null;
											java.io.File readPath = new java.io.File(
													zoospermium_attitudinarian);
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											try {
												fis = new java.io.FileInputStream(
														readPath);
											} catch (java.io.FileNotFoundException e) {
											}
											Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
											try {
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												java.io.BufferedReader reader = new java.io.BufferedReader(
														new java.io.InputStreamReader(
																fis));
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												String line = null;
												try {
													while ((line = reader
															.readLine()) != null) {
														SPIClassIterator.unvisiblyUntoothsome
																.println(line);
													}
												} catch (IOException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													SPIClassIterator.unvisiblyUntoothsome
															.printf("Failed to read file.\n");
												}
											} catch (RuntimeException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												e.printStackTrace(SPIClassIterator.unvisiblyUntoothsome);
												throw e;
											}
											Tracer.tracepointWeaknessEnd();
										}
									}
								} catch (FileNotFoundException mesostomatidaeLegislatress) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											mesostomatidaeLegislatress);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.unvisiblyUntoothsome.close();
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
