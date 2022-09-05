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
import java.util.concurrent.locks.ReentrantLock;



public class JTreeOptions {

	static PrintStream antiliturgistGlauconite = null;
	private static final java.util.concurrent.atomic.AtomicBoolean archtreasurerSiller = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (archtreasurerSiller.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmp0NP8Kq_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File medialkalinePremanufacturer = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!medialkalinePremanufacturer.getParentFile().exists()
					&& !medialkalinePremanufacturer.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.antiliturgistGlauconite = new PrintStream(
							new FileOutputStream(medialkalinePremanufacturer,
									false), true, "ISO-8859-1");
				} catch (UnsupportedEncodingException krypsisPopulator) {
					System.err.printf("Failed to open log file.  %s\n",
							krypsisPopulator.getMessage());
					JTreeOptions.antiliturgistGlauconite = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							krypsisPopulator);
				} catch (FileNotFoundException sixerSubgit) {
					System.err.printf("Failed to open log file.  %s\n",
							sixerSubgit.getMessage());
					JTreeOptions.antiliturgistGlauconite = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.", sixerSubgit);
				}
				if (JTreeOptions.antiliturgistGlauconite != null) {
					try {
						String othello_augurous = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (othello_augurous == null
								|| !othello_augurous.equals("1")) {
							String bracelet_bastionet = System
									.getenv("HAVERSIAN_PERINEPHRITIS");
							if (null != bracelet_bastionet) {
								File submiss_underjaw = new File(
										bracelet_bastionet);
								if (submiss_underjaw.exists()
										&& !submiss_underjaw.isDirectory()) {
									try {
										String vassalage_mesotonic;
										Scanner lectisternium_beneficial = new Scanner(
												submiss_underjaw, "UTF-8")
												.useDelimiter("\\A");
										if (lectisternium_beneficial.hasNext())
											vassalage_mesotonic = lectisternium_beneficial
													.next();
										else
											vassalage_mesotonic = "";
										if (null != vassalage_mesotonic) {
											Tracer.tracepointWeaknessStart(
													"CWE821", "A",
													"Incorrect Synchronization");
											Stonesoup_Int stonesoup_dev_amount = new Stonesoup_Int(
													1);
											int stonesoup_qsize = 0;
											String stonesoup_taint = null;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = vassalage_mesotonic
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
															vassalage_mesotonic);
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
													JTreeOptions.antiliturgistGlauconite
															.println("NumberFormatException");
												}
												if (stonesoup_qsize < 0) {
													JTreeOptions.antiliturgistGlauconite
															.println("Error: use positive numbers.");
												} else {
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread2 = new Thread(
															new devChar(
																	stonesoup_qsize,
																	stonesoup_dev_amount,
																	stonesoup_file1,
																	JTreeOptions.antiliturgistGlauconite));
													Thread stonesoup_thread1 = new Thread(
															new calcDevAmount(
																	stonesoup_dev_amount,
																	stonesoup_file2,
																	JTreeOptions.antiliturgistGlauconite));
													stonesoup_threadInput = new StringBuilder()
															.append(stonesoup_taint);
													JTreeOptions.antiliturgistGlauconite
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													JTreeOptions.antiliturgistGlauconite
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
														JTreeOptions.antiliturgistGlauconite
																.println("Interrupted");
													}
													JTreeOptions.antiliturgistGlauconite
															.println("Info: Threads ended");
													Tracer.tracepointWeaknessEnd();
												}
											}
										}
									} catch (FileNotFoundException tasterCaritive) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												tasterCaritive);
									}
								}
							}
						}
					} finally {
						JTreeOptions.antiliturgistGlauconite.close();
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

	private static ReentrantLock lock = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();
	private static StringBuilder stonesoup_threadInput;

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmp0NP8Kq_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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

	public static class Stonesoup_Int {
		int i;

		public Stonesoup_Int(int i) {
			this.i = i;
		}

		public int getVal() {
			return i;
		}

		public void setVal(int i) {
			this.i = i;
		}
	}

	public static class calcDevAmount implements Runnable {
		private Stonesoup_Int dev_amount;
		private String filename = null;
		private PrintStream output = null;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmp0NP8Kq_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"calcDevAmount.run");
			try {
				lock.lock();
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				dev_amount.setVal(stonesoup_threadInput.charAt(0) - 'A');
				Tracer.tracepointVariableInt("dev_amount.getVal()",
						dev_amount.getVal());
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				readFile(filename, output);
				if (dev_amount.getVal() < 0) {
					dev_amount.setVal(dev_amount.getVal() * -1);
				}
				if (dev_amount.getVal() == 0) {
					dev_amount.setVal(dev_amount.getVal() + 1);
				}
				Tracer.tracepointVariableInt("dev_amount.getVal()",
						dev_amount.getVal());
				lock.unlock();
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public calcDevAmount(Stonesoup_Int dev_amount, String filename,
				PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmp0NP8Kq_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"calcDevAmount.ctor");
			this.dev_amount = dev_amount;
			this.filename = filename;
			this.output = output;
		}
	}

	public static class devChar implements Runnable {
		private int size = 0;
		private Stonesoup_Int dev_amount;
		private String filename = null;
		private PrintStream output = null;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmp0NP8Kq_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"devChar.run");
			try {
				lock2.lock();
				int[] sortMe = new int[size];
				for (int i = 0; i < size; i++) {
					sortMe[i] = size - i;
				}
				Arrays.sort(sortMe);
				readFile(filename, output);
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				Tracer.tracepointVariableInt("dev_amount.getVal()",
						dev_amount.getVal());
				for (int i = 0; i < stonesoup_threadInput.length(); i++) {
					stonesoup_threadInput
							.setCharAt(i, (char) (stonesoup_threadInput
									.charAt(i) / dev_amount.getVal()));
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
				lock2.unlock();
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public devChar(int size, Stonesoup_Int dev_amount, String filename,
				PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmp0NP8Kq_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"devChar.ctor");
			this.size = size;
			this.dev_amount = dev_amount;
			this.filename = filename;
			this.output = output;
		}
	}

}
