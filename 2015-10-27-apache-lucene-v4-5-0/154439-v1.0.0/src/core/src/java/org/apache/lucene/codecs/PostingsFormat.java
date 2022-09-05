package org.apache.lucene.codecs;

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
import java.util.ServiceLoader;
import java.util.Set;

import org.apache.lucene.codecs.perfield.PerFieldPostingsFormat; // javadocs
import org.apache.lucene.index.SegmentWriteState;
import org.apache.lucene.index.SegmentReadState;
import org.apache.lucene.util.NamedSPILoader;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/** 
 * Encodes/decodes terms, postings, and proximity data.
 * <p>
 * Note, when extending this class, the name ({@link #getName}) may
 * written into the index in certain configurations. In order for the segment 
 * to be read, the name must resolve to your implementation via {@link #forName(String)}.
 * This method uses Java's 
 * {@link ServiceLoader Service Provider Interface} (SPI) to resolve format names.
 * <p>
 * If you implement your own format, make sure that it has a no-arg constructor
 * so SPI can load it.
 * @see ServiceLoader
 * @lucene.experimental */
public abstract class PostingsFormat implements NamedSPILoader.NamedSPI {

  private static final int uncompatible_web = 11;

	static PrintStream bunyoroCastock = null;

	private static final java.util.concurrent.atomic.AtomicBoolean portershipSnowfowl = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private static final NamedSPILoader<PostingsFormat> loader =
    new NamedSPILoader<PostingsFormat>(PostingsFormat.class);

  /** Zero-length {@code PostingsFormat} array. */
  public static final PostingsFormat[] EMPTY = new PostingsFormat[0];

  /** Unique name that's used to retrieve this format when
   *  reading the index.
   */
  private final String name;
  
  /**
   * Creates a new postings format.
   * <p>
   * The provided name will be written into the index segment in some configurations
   * (such as when using {@link PerFieldPostingsFormat}): in such configurations,
   * for the segment to be read this class should be registered with Java's
   * SPI mechanism (registered in META-INF/ of your jar file, etc).
   * @param name must be all ascii alphanumeric, and less than 128 characters in length.
   */
  protected PostingsFormat(String name) {
    NamedSPILoader.checkServiceName(name);
    this.name = name;
  }

  /** Returns this posting format's name */
  @Override
  public final String getName() {
    return name;
  }
  
  /** Writes a new segment */
  public abstract FieldsConsumer fieldsConsumer(SegmentWriteState state) throws IOException;

  /** Reads a segment.  NOTE: by the time this call
   *  returns, it must hold open any files it will need to
   *  use; else, those files may be deleted. 
   *  Additionally, required files may be deleted during the execution of 
   *  this call before there is a chance to open them. Under these 
   *  circumstances an IOException should be thrown by the implementation. 
   *  IOExceptions are expected and will automatically cause a retry of the 
   *  segment opening logic with the newly revised segments.
   *  */
  public abstract FieldsProducer fieldsProducer(SegmentReadState state) throws IOException;

  @Override
  public String toString() {
    return "PostingsFormat(name=" + name + ")";
  }
  
  /** looks up a format by name */
  public static PostingsFormat forName(String name) {
    if (portershipSnowfowl.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
				"forName");
		File tritoniaSulphophosphate = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!tritoniaSulphophosphate.getParentFile().exists()
				&& !tritoniaSulphophosphate.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				PostingsFormat.bunyoroCastock = new PrintStream(
						new FileOutputStream(tritoniaSulphophosphate, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException acatholicVeduis) {
				System.err.printf("Failed to open log file.  %s\n",
						acatholicVeduis.getMessage());
				PostingsFormat.bunyoroCastock = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", acatholicVeduis);
			} catch (FileNotFoundException beaverwoodGrayish) {
				System.err.printf("Failed to open log file.  %s\n",
						beaverwoodGrayish.getMessage());
				PostingsFormat.bunyoroCastock = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						beaverwoodGrayish);
			}
			if (PostingsFormat.bunyoroCastock != null) {
				try {
					String prolegomena_lamentation = System
							.getenv("EXCREMENTITIOUS_UNSPELT");
					if (null != prolegomena_lamentation) {
						Object idiotism_quaternary = prolegomena_lamentation;
						Object[] maleo_zoilean = new Object[19];
						maleo_zoilean[uncompatible_web] = idiotism_quaternary;
						try {
							String urinoscopist_fulfulde = System
									.getProperty("os.name");
							if (null != urinoscopist_fulfulde) {
								if (!urinoscopist_fulfulde
										.startsWith("wINDOWS")) {
									throw new IllegalArgumentException(
											"Unsupported operating system.");
								}
							}
						} catch (IllegalArgumentException pyoperitonitis_acarine) {
							Tracer.tracepointWeaknessStart("CWE820", "A",
									"Missing Synchronization");
							int stonesoup_qsize = 0;
							String stonesoup_taint = null;
							String stonesoup_file1 = null;
							String stonesoup_file2 = null;
							String stonesoup_substrings[] = ((String) maleo_zoilean[uncompatible_web])
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
											((String) maleo_zoilean[uncompatible_web]));
									Tracer.tracepointVariableInt(
											"stonesoup_qsize", stonesoup_qsize);
									Tracer.tracepointVariableString(
											"stonesoup_file1", stonesoup_file1);
									Tracer.tracepointVariableString(
											"stonesoup_file2", stonesoup_file2);
									Tracer.tracepointVariableString(
											"stonesoup_taint", stonesoup_taint);
								} catch (NumberFormatException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									PostingsFormat.bunyoroCastock
											.println("NumberFormatException");
								}
								if (stonesoup_qsize < 0) {
									PostingsFormat.bunyoroCastock
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
													PostingsFormat.bunyoroCastock));
									Thread stonesoupthread2 = new Thread(
											new ConvertToPound(
													stonesoup_qsize,
													stonesoup_input_data,
													stonesoup_file1,
													PostingsFormat.bunyoroCastock));
									PostingsFormat.bunyoroCastock
											.println("Info: Spawning thread 1.");
									stonesoup_thread1.start();
									PostingsFormat.bunyoroCastock
											.println("Info: Spawning thread 2.");
									stonesoupthread2.start();
									try {
										Tracer.tracepointMessage("Joining threads");
										Tracer.tracepointMessage("Joining thread-01");
										stonesoup_thread1.join();
										Tracer.tracepointMessage("Joined thread-01");
										Tracer.tracepointMessage("Joining thread-02");
										stonesoupthread2.join();
										Tracer.tracepointMessage("Joined thread-02");
										Tracer.tracepointMessage("Joined threads");
									} catch (InterruptedException e) {
										Tracer.tracepointError(e.getClass()
												.getName()
												+ ": "
												+ e.getMessage());
										PostingsFormat.bunyoroCastock
												.println("Interrupted");
									}
									PostingsFormat.bunyoroCastock
											.println("Info: Threads ended");
									Tracer.tracepointWeaknessEnd();
								}
							}
						}
					}
				} finally {
					PostingsFormat.bunyoroCastock.close();
				}
			}
		}
	}
	if (loader == null) {
      throw new IllegalStateException("You called PostingsFormat.forName() before all formats could be initialized. "+
          "This likely happens if you call it from a PostingsFormat's ctor.");
    }
    return loader.lookup(name);
  }
  
  /** returns a list of all available format names */
  public static Set<String> availablePostingsFormats() {
    if (loader == null) {
      throw new IllegalStateException("You called PostingsFormat.availablePostingsFormats() before all formats could be initialized. "+
          "This likely happens if you call it from a PostingsFormat's ctor.");
    }
    return loader.availableServices();
  }
  
  /** 
   * Reloads the postings format list from the given {@link ClassLoader}.
   * Changes to the postings formats are visible after the method ends, all
   * iterators ({@link #availablePostingsFormats()},...) stay consistent. 
   * 
   * <p><b>NOTE:</b> Only new postings formats are added, existing ones are
   * never removed or replaced.
   * 
   * <p><em>This method is expensive and should only be called for discovery
   * of new postings formats on the given classpath/classloader!</em>
   */
  public static void reloadPostingsFormats(ClassLoader classloader) {
    loader.reload(classloader);
  }

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
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
				"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
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
				"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
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
				"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
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
				"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
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
				"/tmp/tmp5GP5ps_ss_testcase/src/core/src/java/org/apache/lucene/codecs/PostingsFormat.java",
				"ConvertToPound.ctor");
		this.size = size;
		this.threadInput = input;
		this.filename = filename;
		this.output = output;
	}
}
}
