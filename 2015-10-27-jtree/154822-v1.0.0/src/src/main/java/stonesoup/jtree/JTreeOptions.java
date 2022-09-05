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
import java.util.Arrays;



public class JTreeOptions {

	static PrintStream festivityLimnanth = null;
	private static final java.util.concurrent.atomic.AtomicBoolean unbosomPercontatorial = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (unbosomPercontatorial.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpSz9WO__ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File tscherkessSuji = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!tscherkessSuji.getParentFile().exists()
					&& !tscherkessSuji.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.festivityLimnanth = new PrintStream(
							new FileOutputStream(tscherkessSuji, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException souariTheologus) {
					System.err.printf("Failed to open log file.  %s\n",
							souariTheologus.getMessage());
					JTreeOptions.festivityLimnanth = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							souariTheologus);
				} catch (FileNotFoundException cremuleMutualist) {
					System.err.printf("Failed to open log file.  %s\n",
							cremuleMutualist.getMessage());
					JTreeOptions.festivityLimnanth = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							cremuleMutualist);
				}
				if (JTreeOptions.festivityLimnanth != null) {
					try {
						String pumpkinify_needlessly = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (pumpkinify_needlessly == null
								|| !pumpkinify_needlessly.equals("1")) {
							String prefabrication_unsecureness = System
									.getenv("MAESTRO_OVERCREDULITY");
							if (null != prefabrication_unsecureness) {
								File turnicomorphic_relieve = new File(
										prefabrication_unsecureness);
								if (turnicomorphic_relieve.exists()
										&& !turnicomorphic_relieve
												.isDirectory()) {
									try {
										String upwreathe_walahee;
										Scanner deliberant_adenopathy = new Scanner(
												turnicomorphic_relieve, "UTF-8")
												.useDelimiter("\\A");
										if (deliberant_adenopathy.hasNext())
											upwreathe_walahee = deliberant_adenopathy
													.next();
										else
											upwreathe_walahee = "";
										if (null != upwreathe_walahee) {
											Tracer.tracepointWeaknessStart(
													"CWE567", "A",
													"Unsynchronized Access to Shared Data in a Multithreaded Context");
											int stonesoup_qsize = 0;
											String stonesoup_taint = null;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = upwreathe_walahee
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
															upwreathe_walahee);
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
													JTreeOptions.festivityLimnanth
															.println("NumberFormatException");
												}
												if (stonesoup_qsize < 0) {
													JTreeOptions.festivityLimnanth
															.println("Error: use positive numbers.");
												} else {
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread2 = new Thread(
															new devChar(
																	stonesoup_qsize,
																	stonesoup_file1,
																	JTreeOptions.festivityLimnanth));
													Thread stonesoup_thread1 = new Thread(
															new calcDevAmount(
																	stonesoup_file2,
																	JTreeOptions.festivityLimnanth));
													stonesoup_threadInput = new StringBuilder()
															.append(stonesoup_taint);
													JTreeOptions.festivityLimnanth
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													stonesoup_thread2.start();
													JTreeOptions.festivityLimnanth
															.println("Info: Spawning thread 2.");
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
														JTreeOptions.festivityLimnanth
																.println("Interrupted");
													}
													JTreeOptions.festivityLimnanth
															.println("Info: Threads ended");
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException tubbalProletcult) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												tubbalProletcult);
									}
								}
							}
						}
					} finally {
						JTreeOptions.festivityLimnanth.close();
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

	private static StringBuilder stonesoup_threadInput;
	private static volatile int dev_amount = 1;

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpSz9WO__ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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

	public static class calcDevAmount implements Runnable {
		public String filename = null;
		public PrintStream output = null;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpSz9WO__ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"calcDevAmount.run");
			try {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				dev_amount = stonesoup_threadInput.charAt(0) - 'A';
				readFile(filename, output);
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				if (dev_amount < 0) {
					dev_amount *= -1;
				}
				if (dev_amount == 0) {
					dev_amount += 1;
				}
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public calcDevAmount(String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpSz9WO__ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"calcDevAmount.ctor");
			this.filename = filename;
			this.output = output;
		}
	}

	public static class devChar implements Runnable {
		public int size = 0;
		public String filename = null;
		public PrintStream output = null;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpSz9WO__ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"devChar.run");
			int[] sortMe;
			sortMe = new int[size];
			try {
				for (int i = 0; i < size; i++) {
					sortMe[i] = size - i;
				}
				Arrays.sort(sortMe);
				readFile(filename, output);
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				for (int i = 0; i < stonesoup_threadInput.length(); i++) {
					stonesoup_threadInput
							.setCharAt(
									i,
									(char) (stonesoup_threadInput.charAt(i) / dev_amount));
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public devChar(int size, String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpSz9WO__ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"devChar.ctor");
			this.size = size;
			this.filename = filename;
			this.output = output;
		}
	}

}
