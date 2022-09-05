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
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  static PrintStream cholangioitisTarsal = null;

	private static final java.util.concurrent.atomic.AtomicBoolean idiotismDentally = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (idiotismDentally.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp93bh_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File aftergrindCitable = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!aftergrindCitable.getParentFile().exists()
				&& !aftergrindCitable.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.cholangioitisTarsal = new PrintStream(
						new FileOutputStream(aftergrindCitable, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException ascertainablyParasynaptic) {
				System.err.printf("Failed to open log file.  %s\n",
						ascertainablyParasynaptic.getMessage());
				SPIClassIterator.cholangioitisTarsal = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						ascertainablyParasynaptic);
			} catch (FileNotFoundException violaceousGracelessness) {
				System.err.printf("Failed to open log file.  %s\n",
						violaceousGracelessness.getMessage());
				SPIClassIterator.cholangioitisTarsal = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						violaceousGracelessness);
			}
			if (SPIClassIterator.cholangioitisTarsal != null) {
				try {
					String cut_hypohippus = System.getenv("MUDDLESOME_BORSHT");
					if (null != cut_hypohippus) {
						String[] corroborate_unenclosed = new String[29];
						corroborate_unenclosed[22] = cut_hypohippus;
						narialUnflowing(3, null, null, null,
								corroborate_unenclosed, null, null);
					}
				} finally {
					SPIClassIterator.cholangioitisTarsal.close();
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

public static void narialUnflowing(int virescenceBittersweet,
		String[]... triangulidApocatharsis) {
	String[] impennesHazle = null;
	int unwealSuperannuate = 0;
	for (unwealSuperannuate = 0; unwealSuperannuate < triangulidApocatharsis.length; unwealSuperannuate++) {
		if (unwealSuperannuate == virescenceBittersweet)
			impennesHazle = triangulidApocatharsis[unwealSuperannuate];
	}
	tricephalousGossipiness(impennesHazle);
}

public static void tricephalousGossipiness(String[] retrolingual_unhardihood) {
	hemoclasticDambrod(retrolingual_unhardihood);
}

public static void hemoclasticDambrod(String[] triumvir_rullion) {
	Tracer.tracepointWeaknessStart("CWE363", "A",
			"Race Condition Enabling Link Following");
	String stonesoup_syncfile = null;
	String stonesoup_fileName = null;
	String stonesoup_substrings[] = triumvir_rullion[22].split("\\s+", 2);
	if (stonesoup_substrings.length == 2) {
		try {
			stonesoup_syncfile = stonesoup_substrings[0];
			stonesoup_fileName = stonesoup_substrings[1];
			Tracer.tracepointVariableString("stonesoup_value",
					triumvir_rullion[22]);
			Tracer.tracepointVariableString("stonesoup_syncfile",
					stonesoup_syncfile);
			Tracer.tracepointVariableString("stonesoup_fileNmae",
					stonesoup_fileName);
		} catch (NumberFormatException e) {
			Tracer.tracepointError(e.getClass().getName() + ": "
					+ e.getMessage());
			SPIClassIterator.cholangioitisTarsal
					.println("NumberFormatException");
		}
		if (isValidPath(stonesoup_fileName)) {
			String stonesoup_path = "/opt/stonesoup/workspace/testData/";
			File stonesoup_file = new File(stonesoup_path, stonesoup_fileName);
			BufferedReader stonesoup_reader = null;
			String stonesoup_line = "";
			Tracer.tracepointVariableString("stonesoup_file",
					stonesoup_file.getAbsolutePath());
			if (stonesoup_file.exists()) {
				try {
					if (!isSymlink(stonesoup_file)) {
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						waitForChange(stonesoup_path, stonesoup_fileName,
								stonesoup_syncfile,
								SPIClassIterator.cholangioitisTarsal);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						stonesoup_reader = new BufferedReader(new FileReader(
								stonesoup_file.getAbsolutePath()));
						while ((stonesoup_line = stonesoup_reader.readLine()) != null) {
							SPIClassIterator.cholangioitisTarsal
									.println(stonesoup_line);
						}
						stonesoup_reader.close();
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
					} else {
						Tracer.tracepointError("ERROR: File is a symlink!");
						SPIClassIterator.cholangioitisTarsal
								.println("ERROR: File is a symlink!");
					}
				} catch (IOException e) {
					Tracer.tracepointError("ERROR: File got deleted.");
					SPIClassIterator.cholangioitisTarsal
							.println("ERROR: File got deleted.");
				}
			} else {
				Tracer.tracepointError("ERROR: File doesn't exist!");
				SPIClassIterator.cholangioitisTarsal
						.println("ERROR: File doesn't exist!");
			}
		} else {
			Tracer.tracepointError("ERROR: Filename isn't valid!");
			SPIClassIterator.cholangioitisTarsal
					.println("ERROR: Filename isn't valid!");
		}
	} else {
		Tracer.tracepointError("ERROR: Input isn't valid!");
		SPIClassIterator.cholangioitisTarsal
				.println("ERROR: Input isn't valid!");
	}
	Tracer.tracepointWeaknessEnd();
}

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmp93bh_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"readFile");
	String str;
	try {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		while ((str = reader.readLine()) != null) {
			output.println(str);
		}
		reader.close();
	} catch (FileNotFoundException e) {
		Tracer.tracepointError("Error reading syncFile.  "
				+ e.getClass().getName() + ": " + e.getMessage());
		output.println("Error reading sync file: " + e);
	} catch (IOException e) {
		Tracer.tracepointError("Error reading syncFile.  "
				+ e.getClass().getName() + ": " + e.getMessage());
		output.println("Error reading sync file: " + e);
	}
}

public static void waitForChange(String path, String fileName, String syncFile,
		PrintStream output) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmp93bh_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"waitForChange");
	PrintWriter writer = new PrintWriter(path + fileName + ".pid");
	writer.close();
	Tracer.tracepointVariableString(".pid file", path + fileName + ".pid");
	Tracer.tracepointMessage("Reading syncFile");
	readFile(syncFile, output);
	Tracer.tracepointMessage("Finished reading syncFile");
}

public static boolean isValidPath(String file) {
	Tracer.tracepointLocation(
			"/tmp/tmp93bh_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"isValidPath");
	return !file.contains("/");
}

public static boolean isSymlink(File file) throws IOException {
	Tracer.tracepointLocation(
			"/tmp/tmp93bh_Y_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
			"isSymlink");
	return !file.getCanonicalFile().equals(file.getAbsoluteFile());
}
  
}
