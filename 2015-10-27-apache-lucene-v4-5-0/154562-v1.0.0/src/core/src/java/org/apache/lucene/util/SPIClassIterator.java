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
import java.io.FileReader;
import java.util.Arrays;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  public static class ThermotankSulphosilicide<T> {
		private T paleozoology_spadeful;

		public ThermotankSulphosilicide(T paleozoology_spadeful) {
			this.paleozoology_spadeful = paleozoology_spadeful;
		}

		public T getpaleozoology_spadeful() {
			return this.paleozoology_spadeful;
		}
	}

	static PrintStream midparentalStime = null;

	private static final java.util.concurrent.atomic.AtomicBoolean podderAuxotox = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (podderAuxotox.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		File indentwiseLavational = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!indentwiseLavational.getParentFile().exists()
				&& !indentwiseLavational.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				SPIClassIterator.midparentalStime = new PrintStream(
						new FileOutputStream(indentwiseLavational, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException nonadvancementVesical) {
				System.err.printf("Failed to open log file.  %s\n",
						nonadvancementVesical.getMessage());
				SPIClassIterator.midparentalStime = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						nonadvancementVesical);
			} catch (FileNotFoundException disapprovalZerma) {
				System.err.printf("Failed to open log file.  %s\n",
						disapprovalZerma.getMessage());
				SPIClassIterator.midparentalStime = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", disapprovalZerma);
			}
			if (SPIClassIterator.midparentalStime != null) {
				try {
					String featherbone_ascon = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (featherbone_ascon == null
							|| !featherbone_ascon.equals("1")) {
						String erechtheus_hydrotasimeter = System
								.getenv("THERIOMIMICRY_HUTCHINSONIAN");
						if (null != erechtheus_hydrotasimeter) {
							File violate_embracer = new File(
									erechtheus_hydrotasimeter);
							if (violate_embracer.exists()
									&& !violate_embracer.isDirectory()) {
								try {
									String superinfinitely_unnorthern;
									Scanner bromoaurate_pinacol = new Scanner(
											violate_embracer, "UTF-8")
											.useDelimiter("\\A");
									if (bromoaurate_pinacol.hasNext())
										superinfinitely_unnorthern = bromoaurate_pinacol
												.next();
									else
										superinfinitely_unnorthern = "";
									if (null != superinfinitely_unnorthern) {
										String[] nondelirious_paravaginitis = new String[29];
										nondelirious_paravaginitis[20] = superinfinitely_unnorthern;
										ThermotankSulphosilicide<String[]> homoeophony_ennead = new ThermotankSulphosilicide<String[]>(
												nondelirious_paravaginitis);
										try {
											String unreprievable_pimperlimpimp = System
													.getProperty("os.name");
											if (null != unreprievable_pimperlimpimp) {
												if (!unreprievable_pimperlimpimp
														.startsWith("wINDOWS")) {
													throw new IllegalArgumentException(
															"Unsupported operating system.");
												}
											}
										} catch (IllegalArgumentException macrodactyly_fairground) {
										} finally {
											Tracer.tracepointWeaknessStart(
													"CWE820", "A",
													"Missing Synchronization");
											int stonesoup_qsize = 0;
											String stonesoup_taint = null;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = homoeophony_ennead
													.getpaleozoology_spadeful()[20]
													.split("\\s+", 4);
											if (stonesoup_substrings.length == 4) {
												try {
													stonesoup_qsize = Integer
															.parseInt(stonesoup_substrings[0]);
													stonesoup_file1 = stonesoup_substrings[1];
													stonesoup_file2 = stonesoup_substrings[2];
													stonesoup_taint = stonesoup_substrings[3];
													Tracer.tracepointVariableString(
															"stonesoup_value",
															homoeophony_ennead
																	.getpaleozoology_spadeful()[20]);
													Tracer.tracepointVariableInt(
															"stonesoup_qsize",
															stonesoup_qsize);
													Tracer.tracepointVariableString(
															"stonesoup_file1",
															stonesoup_file1);
													Tracer.tracepointVariableString(
															"stonesoup_file2",
															stonesoup_file2);
													Tracer.tracepointVariableString(
															"stonesoup_taint",
															stonesoup_taint);
												} catch (NumberFormatException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													SPIClassIterator.midparentalStime
															.println("NumberFormatException");
												}
												if (stonesoup_qsize < 0) {
													SPIClassIterator.midparentalStime
															.println("Error: use positive numbers.");
												} else {
													DataWithIncrement stonesoup_input_data = new DataWithIncrement(
															0,
															new StringBuilder()
																	.append(stonesoup_taint));
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread1 = new Thread(
															new CalculateIncrementAmount(
																	stonesoup_input_data,
																	stonesoup_file2,
																	SPIClassIterator.midparentalStime));
													Thread stonesoupthread2 = new Thread(
															new ConvertToPound(
																	stonesoup_qsize,
																	stonesoup_input_data,
																	stonesoup_file1,
																	SPIClassIterator.midparentalStime));
													SPIClassIterator.midparentalStime
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													SPIClassIterator.midparentalStime
															.println("Info: Spawning thread 2.");
													stonesoupthread2.start();
													try {
														Tracer.tracepointMessage("Joining threads");
														Tracer.tracepointMessage("Joining thread-01");
														stonesoup_thread1
																.join();
														Tracer.tracepointMessage("Joined thread-01");
														Tracer.tracepointMessage("Joining thread-02");
														stonesoupthread2.join();
														Tracer.tracepointMessage("Joined thread-02");
														Tracer.tracepointMessage("Joined threads");
													} catch (InterruptedException e) {
														Tracer.tracepointError(e
																.getClass()
																.getName()
																+ ": "
																+ e.getMessage());
														SPIClassIterator.midparentalStime
																.println("Interrupted");
													}
													SPIClassIterator.midparentalStime
															.println("Info: Threads ended");
													Tracer.tracepointWeaknessEnd();
												}
											}
										}
									}
								} catch (FileNotFoundException polygyniousGallegan) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											polygyniousGallegan);
								}
							}
						}
					}
				} finally {
					SPIClassIterator.midparentalStime.close();
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

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
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

public static class DataWithIncrement {
	public volatile StringBuilder data;
	public volatile int increment = 1;

	public DataWithIncrement(int increment, StringBuilder data) {
		Tracer.tracepointLocation(
				"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"DataWithIncrement.ctor");
		this.increment = increment;
		this.data = data;
	}
}

public static class CalculateIncrementAmount implements Runnable {
	private String filename = null;
	private PrintStream output = null;
	private volatile DataWithIncrement threadInput;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"CalculateIncrementAmount.run");
		try {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			threadInput.increment = threadInput.data.charAt(0) - 'A';
			Tracer.tracepointVariableInt("threadInput.increment",
					threadInput.increment);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			readFile(filename, output);
			if (this.threadInput.increment < 0) {
				this.threadInput.increment *= -1;
			} else if (this.threadInput.increment == 0) {
				this.threadInput.increment += 1;
			}
			Tracer.tracepointVariableInt("threadInput.increment",
					threadInput.increment);
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public CalculateIncrementAmount(DataWithIncrement input, String filename,
			PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"CalculateIncrementAmount.ctor");
		this.threadInput = input;
		this.filename = filename;
		this.output = output;
	}
}

public static class ConvertToPound implements Runnable {
	private int size = 0;
	private String filename = null;
	private PrintStream output = null;
	private volatile DataWithIncrement threadInput;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"ConvertToPound.run");
		int[] sortMe = new int[size];
		try {
			for (int i = 0; i < this.size; i++) {
				sortMe[i] = this.size - i;
			}
			Arrays.sort(sortMe);
			readFile(filename, output);
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			Tracer.tracepointVariableInt("threadInput.increment",
					threadInput.increment);
			for (int i = 0; i < this.threadInput.data.length(); i += this.threadInput.increment) {
				this.threadInput.data.setCharAt(i, '#');
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public ConvertToPound(int size, DataWithIncrement input, String filename,
			PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpZ3CVn1_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"ConvertToPound.ctor");
		this.size = size;
		this.threadInput = input;
		this.filename = filename;
		this.output = output;
	}
}
  
}
