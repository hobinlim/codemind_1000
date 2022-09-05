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
  static PrintStream hosedMescaline = null;

	private static final java.util.concurrent.atomic.AtomicBoolean phaneromerousSulphurlike = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (phaneromerousSulphurlike.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpmh1tJR_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File overheartySlogger = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!overheartySlogger.getParentFile().exists()
				&& !overheartySlogger.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.hosedMescaline = new PrintStream(
						new FileOutputStream(overheartySlogger, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException backhookerPrehensory) {
				System.err.printf("Failed to open log file.  %s\n",
						backhookerPrehensory.getMessage());
				SPIClassIterator.hosedMescaline = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						backhookerPrehensory);
			} catch (FileNotFoundException unperjuredMicroclimate) {
				System.err.printf("Failed to open log file.  %s\n",
						unperjuredMicroclimate.getMessage());
				SPIClassIterator.hosedMescaline = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						unperjuredMicroclimate);
			}
			if (SPIClassIterator.hosedMescaline != null) {
				try {
					String tumidly_bismarckian = System
							.getenv("PROLATIVE_FOREST");
					if (null != tumidly_bismarckian) {
						Tracer.tracepointWeaknessStart("CWE833", "A",
								"Deadlock");
						Tracer.tracepointVariableString("stonesoup_value",
								tumidly_bismarckian);
						boolean stonesoup_upper = firstIsUpper(tumidly_bismarckian);
						ReentrantLock stonesoup_lock = null;
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						if (stonesoup_upper) {
							Tracer.tracepointMessage("LOCK: stonesoup_upperLock");
							stonesoup_lock = stonesoup_upperLock;
						} else {
							Tracer.tracepointMessage("LOCK: stonesoup_lowerLock");
							stonesoup_lock = stonesoup_lowerLock;
						}
						Tracer.tracepointMessage("Locking lock");
						stonesoup_lock.lock();
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						try {
							Tracer.tracepointMessage("Creating thread");
							Thread stonesoup_thread1 = new Thread(
									new CountUpper(tumidly_bismarckian,
											SPIClassIterator.hosedMescaline));
							stonesoup_thread1.start();
							for (int ii = 0; ii < tumidly_bismarckian.length(); ii++) {
								if (stonesoup_upper
										&& Character
												.isUpperCase(tumidly_bismarckian
														.charAt(ii))) {
									stonesoup_upperInt += 1;
								} else if (!stonesoup_upper
										&& !Character
												.isUpperCase(tumidly_bismarckian
														.charAt(ii))) {
									stonesoup_lowerInt += 1;
								}
							}
							try {
								Tracer.tracepointMessage("Joining thread-01");
								stonesoup_thread1.join();
								Tracer.tracepointMessage("Joined thread-01");
							} catch (InterruptedException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								SPIClassIterator.hosedMescaline
										.println("Interrupted");
							}
						} finally {
							Tracer.tracepointMessage("Unlocking lock");
							stonesoup_lock.unlock();
						}
						SPIClassIterator.hosedMescaline
								.println("finished evaluating");
						SPIClassIterator.hosedMescaline
								.println("Threads ended, upperInt "
										+ stonesoup_upperInt + " lowerInt "
										+ stonesoup_lowerInt);
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					SPIClassIterator.hosedMescaline.close();
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

private static ReentrantLock stonesoup_lowerLock = new ReentrantLock();

private static ReentrantLock stonesoup_upperLock = new ReentrantLock();

private static int stonesoup_lowerInt = 0;

private static int stonesoup_upperInt = 0;

public static class CountUpper implements Runnable {
	private String value;
	private PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpmh1tJR_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"CountUpper.run");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		Tracer.tracepointMessage("Locking lock");
		stonesoup_upperLock.lock();
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		try {
			for (int ii = 0; ii < value.length(); ii++) {
				if (Character.isUpperCase(value.charAt(ii))) {
					stonesoup_upperInt += 1;
				}
			}
		} finally {
			Tracer.tracepointMessage("Unlocking lock");
			stonesoup_upperLock.unlock();
		}
		output.println("Info: Thread ending, upperInt " + stonesoup_upperInt);
	}

	public CountUpper(String value, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpmh1tJR_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"CountUpper.ctor");
		this.value = value;
		this.output = output;
	}
}

private static boolean firstIsUpper(String value) {
	Tracer.tracepointLocation(
			"/tmp/tmpmh1tJR_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"firstIsUpper");
	return (Character.isUpperCase(value.charAt(0)));
}
  
}
