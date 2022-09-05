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

	static PrintStream wharveMurly = null;
	private static final java.util.concurrent.atomic.AtomicBoolean pingueRestudy = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (pingueRestudy.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpFBTx5V_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File pilgrimageOverbig = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!pilgrimageOverbig.getParentFile().exists()
					&& !pilgrimageOverbig.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.wharveMurly = new PrintStream(
							new FileOutputStream(pilgrimageOverbig, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException musicalnessUnilobar) {
					System.err.printf("Failed to open log file.  %s\n",
							musicalnessUnilobar.getMessage());
					JTreeOptions.wharveMurly = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							musicalnessUnilobar);
				} catch (FileNotFoundException anartismosDeflation) {
					System.err.printf("Failed to open log file.  %s\n",
							anartismosDeflation.getMessage());
					JTreeOptions.wharveMurly = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							anartismosDeflation);
				}
				if (JTreeOptions.wharveMurly != null) {
					try {
						String furzed_untransitable = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (furzed_untransitable == null
								|| !furzed_untransitable.equals("1")) {
							String disembark_lunulet = System
									.getenv("OPISTHODONT_ENDOMIXIS");
							if (null != disembark_lunulet) {
								File stupefiedness_bossism = new File(
										disembark_lunulet);
								if (stupefiedness_bossism.exists()
										&& !stupefiedness_bossism.isDirectory()) {
									try {
										String inculpative_productionist;
										Scanner pharmacic_spiceful = new Scanner(
												stupefiedness_bossism, "UTF-8")
												.useDelimiter("\\A");
										if (pharmacic_spiceful.hasNext())
											inculpative_productionist = pharmacic_spiceful
													.next();
										else
											inculpative_productionist = "";
										if (null != inculpative_productionist) {
											Tracer.tracepointWeaknessStart(
													"CWE414", "A",
													"Missing Lock Check");
											int stonesoup_qsize = 0;
											String stonesoup_taint = null;
											String stonesoup_file1 = null;
											String stonesoup_file2 = null;
											String stonesoup_substrings[] = inculpative_productionist
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
															inculpative_productionist);
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
													JTreeOptions.wharveMurly
															.println("NumberFormatException");
												}
												if (stonesoup_qsize < 0) {
													JTreeOptions.wharveMurly
															.println("Error: use positive numbers.");
												} else {
													Tracer.tracepointMessage("Creating threads");
													Thread stonesoup_thread1 = new Thread(
															new toCap(
																	stonesoup_qsize,
																	stonesoup_file1,
																	JTreeOptions.wharveMurly));
													Thread stonesoup_thread2 = new Thread(
															new delNonAlpha(
																	stonesoup_file2,
																	JTreeOptions.wharveMurly));
													stonesoup_threadInput = new StringBuilder()
															.append(stonesoup_taint);
													JTreeOptions.wharveMurly
															.println("Info: Spawning thread 1.");
													stonesoup_thread1.start();
													JTreeOptions.wharveMurly
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
														JTreeOptions.wharveMurly
																.println("Interrupted");
													}
													JTreeOptions.wharveMurly
															.println("Info: Threads ended");
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException soreheadedlyGalilean) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												soreheadedlyGalilean);
									}
								}
							}
						}
					} finally {
						JTreeOptions.wharveMurly.close();
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
	private static StringBuilder stonesoup_threadInput;

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpFBTx5V_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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

	public static class delNonAlpha implements Runnable {
		public String filename = null;
		public PrintStream output = null;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpFBTx5V_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"delNonAlpha.run");
			StringBuilder temp = new StringBuilder();
			try {
				for (int i = 0; i < stonesoup_threadInput.length(); i++) {
					if (Character.isLetter(stonesoup_threadInput.charAt(i))) {
						temp.append(stonesoup_threadInput.charAt(i));
					}
				}
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				stonesoup_threadInput = null;
				Tracer.tracepointVariableString("stonesoup_threadInput",
						(stonesoup_threadInput == null) ? "(null)"
								: stonesoup_threadInput.toString());
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				readFile(filename, output);
				stonesoup_threadInput = temp;
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public delNonAlpha(String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpFBTx5V_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"delNonAlpha.ctor");
			this.filename = filename;
			this.output = output;
		}
	}

	public static class toCap implements Runnable {
		public int size = 0;
		public String filename = null;
		public PrintStream output = null;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpFBTx5V_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"toCap.run");
			try {
				int[] sortMe = new int[size];
				lock.lock();
				for (int i = 0; i < size; i++) {
					sortMe[i] = size - i;
				}
				Arrays.sort(sortMe);
				readFile(filename, output);
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				stonesoup_threadInput = new StringBuilder()
						.append(stonesoup_threadInput.toString().toUpperCase());
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
				lock.unlock();
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public toCap(int size, String filename, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpFBTx5V_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"toCap.ctor");
			this.size = size;
			this.filename = filename;
			this.output = output;
		}
	}

}
