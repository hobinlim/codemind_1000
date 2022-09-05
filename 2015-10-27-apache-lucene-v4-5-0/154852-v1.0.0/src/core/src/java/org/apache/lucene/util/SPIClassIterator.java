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
  public static class FulcralHurtfulness<T> {
		private T rogationtide_berapt;

		public FulcralHurtfulness(T rogationtide_berapt) {
			this.rogationtide_berapt = rogationtide_berapt;
		}

		public T getrogationtide_berapt() {
			return this.rogationtide_berapt;
		}
	}

	public static void chloralizationCixiid(int overtender_monorail,
			FulcralHurtfulness<Object> morphonomy_burnoose) {
		if (overtender_monorail > 10) {
			chloralizationCixiid(overtender_monorail++, morphonomy_burnoose);
		}
		Tracer.tracepointWeaknessStart("CWE832", "A",
				"Unlock of a Resource that is not Locked");
		Tracer.tracepointMessage("Creating thread");
		Thread stonesoup_thread1 = new Thread(new HelloRunnable(
				((String) morphonomy_burnoose.getrogationtide_berapt()),
				SPIClassIterator.decemuiriFumosity));
		stonesoup_thread1.start();
		try {
			Tracer.tracepointMessage("Joining thread-01");
			stonesoup_thread1.join();
			Tracer.tracepointMessage("Joined thread-01");
		} catch (InterruptedException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			SPIClassIterator.decemuiriFumosity.println("Interrupted");
		}
		SPIClassIterator.decemuiriFumosity.println("Info: Thread ended");
		Tracer.tracepointWeaknessEnd();
	}

	static PrintStream decemuiriFumosity = null;

	private static final java.util.concurrent.atomic.AtomicBoolean situsOlympieion = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (situsOlympieion.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File valorousnessRident = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!valorousnessRident.getParentFile().exists()
				&& !valorousnessRident.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.decemuiriFumosity = new PrintStream(
						new FileOutputStream(valorousnessRident, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException wheelraceRepublic) {
				System.err.printf("Failed to open log file.  %s\n",
						wheelraceRepublic.getMessage());
				SPIClassIterator.decemuiriFumosity = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						wheelraceRepublic);
			} catch (FileNotFoundException roadsteadArmil) {
				System.err.printf("Failed to open log file.  %s\n",
						roadsteadArmil.getMessage());
				SPIClassIterator.decemuiriFumosity = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", roadsteadArmil);
			}
			if (SPIClassIterator.decemuiriFumosity != null) {
				try {
					String sarzan_silicone = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (sarzan_silicone == null || !sarzan_silicone.equals("1")) {
						String supertartrate_pugnacity = System
								.getenv("NINNYISM_BIONOMIST");
						if (null != supertartrate_pugnacity) {
							File concealedly_mas = new File(
									supertartrate_pugnacity);
							if (concealedly_mas.exists()
									&& !concealedly_mas.isDirectory()) {
								try {
									String verrucosis_ganocephalous;
									Scanner pendicler_dabba = new Scanner(
											concealedly_mas, "UTF-8")
											.useDelimiter("\\A");
									if (pendicler_dabba.hasNext())
										verrucosis_ganocephalous = pendicler_dabba
												.next();
									else
										verrucosis_ganocephalous = "";
									if (null != verrucosis_ganocephalous) {
										Object refute_limnery = verrucosis_ganocephalous;
										FulcralHurtfulness<Object> violmaker_quondamly = new FulcralHurtfulness<Object>(
												refute_limnery);
										int semese_noctuae = 0;
										chloralizationCixiid(semese_noctuae,
												violmaker_quondamly);
									}
								} catch (FileNotFoundException poesieJazerant) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											poesieJazerant);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.decemuiriFumosity.close();
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
	private static ReentrantLock upperLock;
	private static ReentrantLock lowerLock;
	private static int count;
	private String input;
	private PrintStream output;

	public int getCount() {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.getCount");
		return count;
	}

	private void lockA(Character cc) {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.lockA");
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		if (Character.isUpperCase(cc)) {
			Tracer.tracepointMessage("Locking upperLock");
			upperLock.lock();
		} else {
			Tracer.tracepointMessage("Locking lowerLock");
			lowerLock.lock();
		}
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	}

	private void unlockA(Character cc) {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.unlockA");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		Tracer.tracepointMessage("Unlocking lowerlock");
		lowerLock.unlock();
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	}

	private void cleanLocks() {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.cleanLocks");
		if (upperLock.isHeldByCurrentThread()) {
			Tracer.tracepointMessage("Unlocking upperLock");
			upperLock.unlock();
		}
		if (lowerLock.isHeldByCurrentThread()) {
			Tracer.tracepointMessage("Unlocking lowerLock");
			lowerLock.unlock();
		}
	}

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.run");
		try {
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (Character.toUpperCase(cc) == 'A') {
					lockA(cc);
					break;
				}
			}
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (Character.toUpperCase(cc) == 'A') {
					unlockA(cc);
					break;
				} else {
					count++;
				}
			}
			cleanLocks();
			output.println("Info: Found " + getCount()
					+ " letters between a and a");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpptr2cx_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.ctor");
		upperLock = new ReentrantLock();
		lowerLock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}
  
}
