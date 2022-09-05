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
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  public static interface IUnderclutchFlorescence {
		public void swartLeatherfish(
				AplopappusFilmable<Object> inaptitude_unexaminable);
	}

	public static class WordishnessMofussil implements IUnderclutchFlorescence {
		@Override
		public void swartLeatherfish(
				AplopappusFilmable<Object> inaptitude_unexaminable) {
			Tracer.tracepointWeaknessStart("CWE197", "A",
					"Numeric Trucation Error");
			Tracer.tracepointVariableLong("value",
					((Long) inaptitude_unexaminable
							.getprevigilantly_mongering()));
			if (((Long) inaptitude_unexaminable.getprevigilantly_mongering()) > 0) {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				int stonesoup_max_value = (int) ((long) ((Long) inaptitude_unexaminable
						.getprevigilantly_mongering()));
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				Tracer.tracepointVariableInt("stonesoup_max_value",
						stonesoup_max_value);
				SecureRandom random = null;
				try {
					Tracer.tracepointMessage("Creating PRNG.");
					random = SecureRandom.getInstance("SHA1PRNG");
				} catch (NoSuchAlgorithmException e) {
					SPIClassIterator.unloggedNosewards
							.println("STONESOUP: Failed to create PRNG.");
					e.printStackTrace(SPIClassIterator.unloggedNosewards);
				}
				if (random != null) {
					Tracer.tracepointMessage("Generating random variable between 0 and stonesoup_max_value");
					try {
						SPIClassIterator.unloggedNosewards
								.printf("Generating random value between %d (inclusive) and %d (exclusive).\n",
										0, stonesoup_max_value);
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						SPIClassIterator.unloggedNosewards.printf(
								"Random choice: %d\n",
								random.nextInt(stonesoup_max_value));
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
					} catch (RuntimeException e) {
						Tracer.tracepointError(e.getClass().getName() + ": "
								+ e.getMessage());
						e.printStackTrace(SPIClassIterator.unloggedNosewards);
						throw e;
					}
					Tracer.tracepointMessage("After random value generation.");
				}
			}
			Tracer.tracepointWeaknessEnd();
		}
	}

	public static class AplopappusFilmable<T> {
		private T previgilantly_mongering;

		public AplopappusFilmable(T previgilantly_mongering) {
			this.previgilantly_mongering = previgilantly_mongering;
		}

		public T getprevigilantly_mongering() {
			return this.previgilantly_mongering;
		}
	}

	static PrintStream unloggedNosewards = null;

	private static final java.util.concurrent.atomic.AtomicBoolean orientizationSteeliness = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (orientizationSteeliness.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpk3pRbN_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File duallyTigger = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!duallyTigger.getParentFile().exists()
				&& !duallyTigger.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.unloggedNosewards = new PrintStream(
						new FileOutputStream(duallyTigger, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException chlorSarcomatosis) {
				System.err.printf("Failed to open log file.  %s\n",
						chlorSarcomatosis.getMessage());
				SPIClassIterator.unloggedNosewards = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						chlorSarcomatosis);
			} catch (FileNotFoundException arrestinglyHeterodoxness) {
				System.err.printf("Failed to open log file.  %s\n",
						arrestinglyHeterodoxness.getMessage());
				SPIClassIterator.unloggedNosewards = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						arrestinglyHeterodoxness);
			}
			if (SPIClassIterator.unloggedNosewards != null) {
				try {
					String yeard_carrying = System
							.getenv("SEGMENTALLY_UNTAILORLY");
					if (null != yeard_carrying) {
						long monitress_zimocca;
						try {
							monitress_zimocca = Long.parseLong(yeard_carrying);
						} catch (NumberFormatException emys_securer) {
							throw new RuntimeException(
									"STONESOUP: Failed to convert source taint.",
									emys_securer);
						}
						Object gape_scatheful = monitress_zimocca;
						AplopappusFilmable<Object> atopic_keracele = new AplopappusFilmable<Object>(
								gape_scatheful);
						IUnderclutchFlorescence telescopically_incorrigibly = new WordishnessMofussil();
						telescopically_incorrigibly
								.swartLeatherfish(atopic_keracele);
					}
				} finally {
					SPIClassIterator.unloggedNosewards.close();
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
