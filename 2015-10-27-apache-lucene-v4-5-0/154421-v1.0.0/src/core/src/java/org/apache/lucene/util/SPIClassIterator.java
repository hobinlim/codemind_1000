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
  public static class UnfainHuipil<T> {
		private T ethnologist_superalkalinity;

		public UnfainHuipil(T ethnologist_superalkalinity) {
			this.ethnologist_superalkalinity = ethnologist_superalkalinity;
		}

		public T getethnologist_superalkalinity() {
			return this.ethnologist_superalkalinity;
		}
	}

	static PrintStream lakistPresbytia = null;

	private static final java.util.concurrent.atomic.AtomicBoolean typificationUnexhalable = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (typificationUnexhalable.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpDQFutm_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File emptierSakellaridis = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!emptierSakellaridis.getParentFile().exists()
				&& !emptierSakellaridis.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.lakistPresbytia = new PrintStream(
						new FileOutputStream(emptierSakellaridis, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException spiriferidPolydipsia) {
				System.err.printf("Failed to open log file.  %s\n",
						spiriferidPolydipsia.getMessage());
				SPIClassIterator.lakistPresbytia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						spiriferidPolydipsia);
			} catch (FileNotFoundException anhydridizeApostil) {
				System.err.printf("Failed to open log file.  %s\n",
						anhydridizeApostil.getMessage());
				SPIClassIterator.lakistPresbytia = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						anhydridizeApostil);
			}
			if (SPIClassIterator.lakistPresbytia != null) {
				try {
					String manobo_disaccord = System
							.getenv("NONPRIESTLY_SEMIPORPHYRITIC");
					if (null != manobo_disaccord) {
						String[] coprophyte_proborrowing = new String[19];
						coprophyte_proborrowing[14] = manobo_disaccord;
						UnfainHuipil<String[]> detainment_ferromagnetism = new UnfainHuipil<String[]>(
								coprophyte_proborrowing);
						int precollusion_mazdakean = 0;
						while (true) {
							precollusion_mazdakean++;
							if (precollusion_mazdakean >= 3000)
								break;
						}
						Tracer.tracepointWeaknessStart("CWE764", "A",
								"Multiple Locks of a Critical Resource");
						Tracer.tracepointVariableString("stonesoup_value",
								detainment_ferromagnetism
										.getethnologist_superalkalinity()[14]);
						Tracer.tracepointMessage("Creating threads");
						Thread stonesoup_thread1 = new Thread(
								new HelloRunnable(detainment_ferromagnetism
										.getethnologist_superalkalinity()[14],
										SPIClassIterator.lakistPresbytia));
						Thread stonesoup_thread2 = new Thread(
								new HelloRunnable(detainment_ferromagnetism
										.getethnologist_superalkalinity()[14],
										SPIClassIterator.lakistPresbytia));
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						stonesoup_thread1.start();
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
							Tracer.tracepointError(e.getClass().getName()
									+ ": " + e.getMessage());
							SPIClassIterator.lakistPresbytia
									.println("Interrupted");
						}
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						SPIClassIterator.lakistPresbytia
								.println("Info: Threads ended");
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					SPIClassIterator.lakistPresbytia.close();
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
				"/tmp/tmpDQFutm_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunnable.run");
		int index = 0;
		while (index < input.length()) {
			char cc = input.charAt(index);
			index++;
			if (cc == '1') {
				lock.lock();
				break;
			}
		}
		boolean found1 = false;
		while (index < input.length()) {
			char cc = input.charAt(index);
			index++;
			if (!found1) {
				count++;
			}
			if (cc == '1') {
				lock.lock();
				found1 = true;
			}
		}
		if (lock.isHeldByCurrentThread()) {
			if (lock.getHoldCount() > 1) {
				lock.unlock();
			}
			lock.unlock();
		}
		output.println("Info: Found " + getCount() + " letters between 1 and 1");
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpDQFutm_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunnable.ctor");
		lock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}
  
}
