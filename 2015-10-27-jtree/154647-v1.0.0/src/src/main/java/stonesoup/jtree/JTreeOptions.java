package stonesoup.jtree;

/*
# ------------------------------Copyright-------------------------------------
# NOTICE
# 
# This software (or technical data) was produced for the U. S.
# Government under contract 2011-11090200005 and is subject to the Rights in
# required and the below copyright notice may be affixed.
# 
# Copyright (c) 2013 Ponte Technologies. All Rights Reserved.
# -----------------------------Copyright-------------------------------------- 
*/

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;



public class JTreeOptions {

	static PrintStream forkinessEmbiotocidae = null;
	private static final java.util.concurrent.atomic.AtomicBoolean disutilizeNonextensive = new java.util.concurrent.atomic.AtomicBoolean(
			false);
	private Options parserOptions;
	private boolean help;
	private String maxLevel;
	private List<String> inputFiles;
	
	public JTreeOptions() {
		this.parserOptions = initOptions();
		this.inputFiles = new ArrayList<String>();
		this.help = false;
	}
	
	public void parseOptions(String[] arguments) throws ParseException {
		if (disutilizeNonextensive.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File concertInhere = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!concertInhere.getParentFile().exists()
					&& !concertInhere.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.forkinessEmbiotocidae = new PrintStream(
							new FileOutputStream(concertInhere, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException varicesIndexing) {
					System.err.printf("Failed to open log file.  %s\n",
							varicesIndexing.getMessage());
					JTreeOptions.forkinessEmbiotocidae = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							varicesIndexing);
				} catch (FileNotFoundException antichurchSpondylocace) {
					System.err.printf("Failed to open log file.  %s\n",
							antichurchSpondylocace.getMessage());
					JTreeOptions.forkinessEmbiotocidae = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							antichurchSpondylocace);
				}
				if (JTreeOptions.forkinessEmbiotocidae != null) {
					try {
						String plinth_ellipses = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (plinth_ellipses == null
								|| !plinth_ellipses.equals("1")) {
							String soleil_hypersthenite = System
									.getenv("SPINOZIST_UNIMITABLENESS");
							if (null != soleil_hypersthenite) {
								File foreseeable_disruptively = new File(
										soleil_hypersthenite);
								if (foreseeable_disruptively.exists()
										&& !foreseeable_disruptively
												.isDirectory()) {
									try {
										String arborescently_snickey;
										Scanner pratapwant_subinvoluted = new Scanner(
												foreseeable_disruptively,
												"UTF-8").useDelimiter("\\A");
										if (pratapwant_subinvoluted.hasNext())
											arborescently_snickey = pratapwant_subinvoluted
													.next();
										else
											arborescently_snickey = "";
										if (null != arborescently_snickey) {
											Tracer.tracepointWeaknessStart(
													"CWE543", "A",
													"Use of Singleton Pattern Without Synchronization in a Multithreaded Context");
											int stonesoup_qsize = 0;
											int stonesoup_numVal = 0;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = arborescently_snickey
													.split("\\s+", 4);
											if (stonesoup_substrings.length == 4) {
												try {
													stonesoup_qsize = Integer
															.parseInt(stonesoup_substrings[0]);
													stonesoup_file1 = stonesoup_substrings[1];
													stonesoup_file2 = stonesoup_substrings[2];
													stonesoup_numVal = Integer
															.parseInt(stonesoup_substrings[3]);
													Tracer.tracepointVariableString(
															"stonesoup_value",
															arborescently_snickey);
													Tracer.tracepointVariableInt(
															"stonesoup_qsize",
															stonesoup_qsize);
													Tracer.tracepointVariableInt(
															"stonesoup_numVal",
															stonesoup_numVal);
													Tracer.tracepointVariableString(
															"stonesoup_file1",
															stonesoup_file1);
													Tracer.tracepointVariableString(
															"stonesoup_file2",
															stonesoup_file2);
												} catch (NumberFormatException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													JTreeOptions.forkinessEmbiotocidae
															.println("NumberFormatException");
												}
												if (stonesoup_numVal <= 0
														|| stonesoup_qsize < 0) {
													JTreeOptions.forkinessEmbiotocidae
															.println("Error: use positive numbers.");
												} else {
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread1 = new Thread(
															new logData(
																	stonesoup_qsize,
																	stonesoup_numVal,
																	stonesoup_file1,
																	JTreeOptions.forkinessEmbiotocidae));
													Thread stonesoup_thread2 = new Thread(
															new printData(
																	stonesoup_file2,
																	JTreeOptions.forkinessEmbiotocidae));
													JTreeOptions.forkinessEmbiotocidae
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													JTreeOptions.forkinessEmbiotocidae
															.println("Info: Spawning thread 2.");
													stonesoup_thread2.start();
													try {
														Tracer.tracepointMessage("Joining threads");
														Tracer.tracepointMessage("Joining thread-01");
														stonesoup_thread1
																.join();
														Tracer.tracepointMessage("Joined thread-01");
														Tracer.tracepointMessage("Joining thread-02");
														stonesoup_thread2
																.join();
														Tracer.tracepointMessage("Joined thread-02");
														Tracer.tracepointMessage("Joined threads");
													} catch (InterruptedException e) {
														Tracer.tracepointError(e
																.getClass()
																.getName()
																+ ": "
																+ e.getMessage());
														JTreeOptions.forkinessEmbiotocidae
																.println("Interrupted");
													}
													JTreeOptions.forkinessEmbiotocidae
															.println("Info: Threads ended");
												}
											}
										}
									} catch (FileNotFoundException lowmostStellite) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												lowmostStellite);
									}
								}
							}
						}
					} finally {
						JTreeOptions.forkinessEmbiotocidae.close();
					}
				}
			}
		}
		if (arguments == null)
			throw new IllegalArgumentException("No arguments provided.");
		
		PosixParser parser = new PosixParser();
		CommandLine cli = parser.parse(this.parserOptions, arguments);
		if (cli.hasOption("level")) {
			this.maxLevel = cli.getOptionValue("level");
		}
		if (cli.hasOption("help")) {
			this.help = true;
		}
		
		this.handlePositional(cli.getArgs());
	}
	
	public boolean getHelp() {
		return this.help;
	}
	
	public int getMaxLevel() {
		return Integer.parseInt(this.maxLevel);
	}
	
	public boolean hasMaxLevel() {
		return this.maxLevel != null;
	}
	
	public List<String> getInputFiles() {
		return this.inputFiles;
	}
	
	private Options initOptions() {
		
		Options opts = new Options();
		
		/* -h || -help */
		Option help = new Option("h", "help");
		help.setLongOpt("help");
		help.setRequired(false);
		help.setArgs(0);
		
		/* -l || -level */
		Option maxlevel = new Option("l", "level");
		maxlevel.setLongOpt("level");
		maxlevel.setRequired(false);
		maxlevel.setArgs(1);
		
		
		/* add the options */
		opts.addOption(help);
		opts.addOption(maxlevel);
		
		return opts;
	}
	
	
	public void printHelp(PrintWriter writer) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp(writer, 80, 
				"jtree [OPTIONS] FILE1 FILE2", 
				"OPTIONS:", this.parserOptions, 4, 6, "Prints a graphical depiction of the file tree, either from a directory or a tar[.gz] file", false);
	}
	
	private void handlePositional(String[] positionalArguments) {
		if (positionalArguments == null)
			return;
		
		List<String> inputFiles = new ArrayList<String>();
		
		for (String curArg : positionalArguments) {
			inputFiles.add(curArg);
		}
		
		this.inputFiles.addAll(inputFiles);
	}

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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

	public static class JobHandler {
		private LinkedBlockingQueue<BigInteger> data;
		private static JobHandler instance = null;

		private JobHandler() {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"JobHandler.ctor");
		}

		public static JobHandler getInstance(String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"JobHandler.getInstance");
			if (instance == null) {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				readFile(filename, output);
				JobHandler temp = new JobHandler();
				temp.initialize();
				instance = temp;
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				return temp;
			}
			return instance;
		}

		private void initialize(){Tracer.tracepointLocation("/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java","JobHandler.initialize");data=new LinkedBlockingQueue<BigInteger>(30);}		public void enqueue(BigInteger i) {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"JobHandler.enqueue");
			try {
				data.put(i);
			} catch (InterruptedException e) {
				throw new RuntimeException("Thread interrupted.", e);
			}
		}

		public BigInteger dequeue() {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"JobHandler.dequeue");
			try {
				return data.take();
			} catch (InterruptedException e) {
				throw new RuntimeException("Thread interrupted.", e);
			}
		}
	}

	public static class printData implements Runnable {
		private String filename;
		private PrintStream output;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"printData.run");
			JobHandler jobs = JobHandler.getInstance(filename, output);
			BigInteger i;
			Tracer.tracepointBuffer("printData: UID of JobHandler",
					Integer.toHexString(System.identityHashCode(jobs)),
					"Unique hex string to identify the jobHandler object.");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			while ((i = jobs.dequeue()) != BigInteger.valueOf(-1)) {
				output.println(i.toString(10));
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		}

		public printData(String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"printData.ctor");
			this.filename = filename;
			this.output = output;
		}
	}

	public static class logData implements Runnable {
		private int size;
		private int numVal;
		private String filename;
		private PrintStream output;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"logData.run");
			int[] sortMe = new int[size];
			for (int i = 0; i < size; i++) {
				sortMe[i] = size - i;
			}
			Arrays.sort(sortMe);
			readFile(filename, output);
			JobHandler jobs = JobHandler.getInstance(filename, output);
			Tracer.tracepointBuffer("logData: UID of JobHandler",
					Integer.toHexString(System.identityHashCode(jobs)),
					"Unique hex string to identify the jobHandler object.");
			BigInteger a1 = BigInteger.valueOf(0);
			BigInteger a2 = BigInteger.valueOf(0);
			BigInteger c = BigInteger.valueOf(0);
			for (int i = 0; i < numVal; i++) {
				if (i == 0) {
					jobs.enqueue(BigInteger.valueOf(0));
				} else if (i == 1) {
					a1 = BigInteger.valueOf(1);
					jobs.enqueue(BigInteger.valueOf(0));
				} else {
					c = a1.add(a2);
					a2 = a1;
					a1 = c;
					jobs.enqueue(c);
				}
			}
			jobs.enqueue(BigInteger.valueOf(-1));
		}

		public logData(int size, int numVal, String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmp7zNQWY_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"logData.ctor");
			this.numVal = numVal;
			this.size = size;
			this.filename = filename;
			this.output = output;
		}
	}

}
