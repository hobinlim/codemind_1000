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
  static PrintStream zemniDeclinable = null;

	private static final java.util.concurrent.atomic.AtomicBoolean homuncularCleanser = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (homuncularCleanser.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpfz995a_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File mantelineHelleri = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!mantelineHelleri.getParentFile().exists()
				&& !mantelineHelleri.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.zemniDeclinable = new PrintStream(
						new FileOutputStream(mantelineHelleri, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException stinkstoneRussification) {
				System.err.printf("Failed to open log file.  %s\n",
						stinkstoneRussification.getMessage());
				SPIClassIterator.zemniDeclinable = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						stinkstoneRussification);
			} catch (FileNotFoundException chiefestSnakeneck) {
				System.err.printf("Failed to open log file.  %s\n",
						chiefestSnakeneck.getMessage());
				SPIClassIterator.zemniDeclinable = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						chiefestSnakeneck);
			}
			if (SPIClassIterator.zemniDeclinable != null) {
				try {
					String thelphusian_collin = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (thelphusian_collin == null
							|| !thelphusian_collin.equals("1")) {
						String pradeep_unresourceful = System
								.getenv("MOONLIGHTY_XENARTHRAL");
						if (null != pradeep_unresourceful) {
							File smiris_syrnium = new File(
									pradeep_unresourceful);
							if (smiris_syrnium.exists()
									&& !smiris_syrnium.isDirectory()) {
								try {
									final String deft_bigotedly;
									Scanner kench_bandhava = new Scanner(
											smiris_syrnium, "UTF-8")
											.useDelimiter("\\A");
									if (kench_bandhava.hasNext())
										deft_bigotedly = kench_bandhava.next();
									else
										deft_bigotedly = "";
									if (null != deft_bigotedly) {
										final Object lysistrata_quillaja = deft_bigotedly;
										DegrainPharyngotherapy dormie_amelu = new DegrainPharyngotherapy();
										dormie_amelu
												.mixeressPersiflate(lysistrata_quillaja);
									}
								} catch (FileNotFoundException lactoglobulinFixedly) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											lactoglobulinFixedly);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.zemniDeclinable.close();
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

public static class DegrainPharyngotherapy {
	public static void mixeressPersiflate(Object tabella_undoubtedness) {
		WhininessHematozoon futurition_sevenfolded = new WhininessHematozoon();
		futurition_sevenfolded.fanonMicrodactylous(tabella_undoubtedness);
	}
}

public static class WhininessHematozoon {
	public static void fanonMicrodactylous(final Object lonquhard_bequest) {
		Tracer.tracepointWeaknessStart("CWE584", "A", "Return Inside Finally");
		File file;
		Scanner freader;
		String absPath = null;
		GetAbsolutePath getpath = new GetAbsolutePath(
				((String) lonquhard_bequest), SPIClassIterator.zemniDeclinable);
		boolean validPath = false;
		Tracer.tracepointVariableString("taintedValue",
				((String) lonquhard_bequest));
		try {
			absPath = getpath.getAbsolutePath();
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			validPath = true;
			Tracer.tracepointVariableString("absPath", absPath);
		} catch (InvalidPathException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			SPIClassIterator.zemniDeclinable
					.println("STONESOUP: Absolute path to file was not found.");
		}
		if (validPath) {
			try {
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				file = new File(absPath);
				freader = new Scanner(file);
				while (freader.hasNextLine()) {
					SPIClassIterator.zemniDeclinable
							.println(freader.nextLine());
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			} catch (NullPointerException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				e.printStackTrace(SPIClassIterator.zemniDeclinable);
				throw e;
			} catch (FileNotFoundException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				SPIClassIterator.zemniDeclinable
						.println("STONESOUP: File not found.");
			}
		}
		Tracer.tracepointWeaknessEnd();
	}

	static class InvalidPathException extends Exception {
		private static final long serialVersionUID = 1L;

		public InvalidPathException(String msg) {
			super(msg);
		}
	}

	static class GetAbsolutePath {
		private String fileName;
		private PrintStream output;

		public GetAbsolutePath(String fileName, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpfz995a_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
					"GetAbsolutePath.ctor");
			this.fileName = fileName;
			this.output = output;
		}

		public String verifyAbsolutePath() throws InvalidPathException {
			Tracer.tracepointLocation(
					"/tmp/tmpfz995a_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
					"GetAbsolutePath.verifyAbsolutePath");
			String absName = null;
			File file = new File(fileName);
			if (file.exists()) {
				absName = file.getAbsolutePath();
			} else {
				throw (new InvalidPathException("No such file: " + fileName));
			}
			return absName;
		}

		@SuppressWarnings("finally")
		public String getAbsolutePath() throws InvalidPathException {
			Tracer.tracepointLocation(
					"/tmp/tmpfz995a_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
					"GetAbsolutePath.getAbsolutePath");
			String absName = null;
			try {
				absName = this.verifyAbsolutePath();
			} catch (InvalidPathException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				output.println("STONESOUP: Error in verifying absolute path\n");
				throw e;
			} finally {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				return absName;
			}
		}
	}
}
  
}
