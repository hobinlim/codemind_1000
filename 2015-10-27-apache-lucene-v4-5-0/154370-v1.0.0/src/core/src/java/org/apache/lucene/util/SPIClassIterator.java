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
  static PrintStream russianistGutturality = null;

	public static void cynicImmelodious(int sirdar_procreatory,
			final String impeacher_nonapplication) {
		sirdar_procreatory--;
		if (sirdar_procreatory > 0) {
			aminogenUnguentarium(sirdar_procreatory, impeacher_nonapplication);
		}
	}

	static public void aminogenUnguentarium(int sluggardry_geront,
			final String impeacher_nonapplication) {
		cynicImmelodious(sluggardry_geront, impeacher_nonapplication);
		Tracer.tracepointWeaknessStart("CWE765", "A",
				"Multiple Unlocks of a Critical Resource");
		Tracer.tracepointMessage("Creating thread");
		Thread stonesoup_thread1 = new Thread(new HelloRunnable(
				impeacher_nonapplication,
				SPIClassIterator.russianistGutturality));
		stonesoup_thread1.start();
		try {
			Tracer.tracepointMessage("Joining thread-01");
			stonesoup_thread1.join();
			Tracer.tracepointMessage("Joined thread-01");
		} catch (InterruptedException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			SPIClassIterator.russianistGutturality.println("Interrupted");
		}
		SPIClassIterator.russianistGutturality.println("Info: Threads ended");
		Tracer.tracepointWeaknessEnd();
	}

	private static final java.util.concurrent.atomic.AtomicBoolean subfloraStomatoplasty = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (subfloraStomatoplasty.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpTo9H9V_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File cerithiidaeUltimobranchial = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!cerithiidaeUltimobranchial.getParentFile().exists()
				&& !cerithiidaeUltimobranchial.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.russianistGutturality = new PrintStream(
						new FileOutputStream(cerithiidaeUltimobranchial, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException irregularHomogenetical) {
				System.err.printf("Failed to open log file.  %s\n",
						irregularHomogenetical.getMessage());
				SPIClassIterator.russianistGutturality = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						irregularHomogenetical);
			} catch (FileNotFoundException malpighiaPrionopinae) {
				System.err.printf("Failed to open log file.  %s\n",
						malpighiaPrionopinae.getMessage());
				SPIClassIterator.russianistGutturality = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						malpighiaPrionopinae);
			}
			if (SPIClassIterator.russianistGutturality != null) {
				try {
					String revealability_unrecaptured = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (revealability_unrecaptured == null
							|| !revealability_unrecaptured.equals("1")) {
						String anacyclus_observantist = System
								.getenv("SERVABLE_SQUAMOSPHENOID");
						if (null != anacyclus_observantist) {
							File supergratify_advanced = new File(
									anacyclus_observantist);
							if (supergratify_advanced.exists()
									&& !supergratify_advanced.isDirectory()) {
								try {
									final String impeacher_nonapplication;
									Scanner quauk_costocoracoid = new Scanner(
											supergratify_advanced, "UTF-8")
											.useDelimiter("\\A");
									if (quauk_costocoracoid.hasNext())
										impeacher_nonapplication = quauk_costocoracoid
												.next();
									else
										impeacher_nonapplication = "";
									if (null != impeacher_nonapplication) {
										int tithonic_malefactor = 2;
										cynicImmelodious(tithonic_malefactor,
												impeacher_nonapplication);
									}
								} catch (FileNotFoundException sessStreptococcus) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											sessStreptococcus);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.russianistGutturality.close();
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

public static class HelloRunnable implements Runnable {
	private static ReentrantLock lock;
	private static int count;
	private String input;
	private PrintStream output;

	public int getCount() {
		return count;
	}

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpTo9H9V_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunnable.run");
		Tracer.tracepointVariableString("input", input);
		try {
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (cc == '1') {
					Tracer.tracepointMessage("Locking lock");
					Tracer.tracepointVariableInt("index", index);
					lock.lock();
					break;
				}
			}
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			boolean found1 = false;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (!found1) {
					count++;
				}
				if (cc == '1') {
					Tracer.tracepointMessage("Unlocking lock");
					lock.unlock();
					found1 = true;
				}
			}
			if (lock.isHeldByCurrentThread()) {
				Tracer.tracepointMessage("Unlocking lock");
				lock.unlock();
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			output.println("Info: Found " + getCount()
					+ " letters between 1 and 1");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpTo9H9V_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunnable.ctor");
		lock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}
  
}
