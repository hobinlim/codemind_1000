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
import java.lang.Character;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  static PrintStream meritmongerUnaching = null;

	private static final java.util.concurrent.atomic.AtomicBoolean batholithicUnquietly = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (batholithicUnquietly.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpi9olgk_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File bregmaBrosimum = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!bregmaBrosimum.getParentFile().exists()
				&& !bregmaBrosimum.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.meritmongerUnaching = new PrintStream(
						new FileOutputStream(bregmaBrosimum, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException vouchableTirr) {
				System.err.printf("Failed to open log file.  %s\n",
						vouchableTirr.getMessage());
				SPIClassIterator.meritmongerUnaching = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", vouchableTirr);
			} catch (FileNotFoundException anomoeanInsculp) {
				System.err.printf("Failed to open log file.  %s\n",
						anomoeanInsculp.getMessage());
				SPIClassIterator.meritmongerUnaching = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", anomoeanInsculp);
			}
			if (SPIClassIterator.meritmongerUnaching != null) {
				try {
					String carpentering_semilogical = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (carpentering_semilogical == null
							|| !carpentering_semilogical.equals("1")) {
						String unenvious_promotion = System
								.getenv("UNCHOKED_NISSE");
						if (null != unenvious_promotion) {
							File subway_fluviograph = new File(
									unenvious_promotion);
							if (subway_fluviograph.exists()
									&& !subway_fluviograph.isDirectory()) {
								try {
									final String arteriorenal_stemmer;
									Scanner unfemininity_pucklike = new Scanner(
											subway_fluviograph, "UTF-8")
											.useDelimiter("\\A");
									if (unfemininity_pucklike.hasNext())
										arteriorenal_stemmer = unfemininity_pucklike
												.next();
									else
										arteriorenal_stemmer = "";
									if (null != arteriorenal_stemmer) {
										final String[] cucumber_placation = new String[24];
										cucumber_placation[19] = arteriorenal_stemmer;
										Tracer.tracepointWeaknessStart(
												"CWE248", "A",
												"Uncaught Exception");
										final String stonesoup_input_for_print = cucumber_placation[19];
										Tracer.tracepointVariableString(
												"value", cucumber_placation[19]);
										Thread.UncaughtExceptionHandler stonesoup_ueh = Thread
												.getDefaultUncaughtExceptionHandler();
										Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
											public void uncaughtException(
													Thread t, Throwable e) {
												Tracer.tracepointLocation(
														"STONESOUP_INJECTED_FILE",
														"uncaughtException");
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												System.err
														.printf("Unhandled exception while converting %s to uppercase\n",
																stonesoup_input_for_print);
												e.printStackTrace(System.err);
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
											}
										});
										char[] stonesoup_characters = cucumber_placation[19]
												.toCharArray();
										for (int i = 0; i < stonesoup_characters.length; i++) {
											if (Character
													.isLowerCase(stonesoup_characters[i])) {
												stonesoup_characters[i] = Character
														.toUpperCase(stonesoup_characters[i]);
											} else if (!Character
													.isUpperCase(stonesoup_characters[i])) {
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												throw new java.lang.IllegalArgumentException(
														"Not a valid character");
											}
										}
										Tracer.tracepointVariableString(
												"stonesoup_characters",
												String.valueOf(stonesoup_characters));
										SPIClassIterator.meritmongerUnaching
												.println(String
														.valueOf(stonesoup_characters));
										Thread.setDefaultUncaughtExceptionHandler(stonesoup_ueh);
										Tracer.tracepointWeaknessEnd();
									}
								} catch (FileNotFoundException probathingBasimesostasis) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											probathingBasimesostasis);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.meritmongerUnaching.close();
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
