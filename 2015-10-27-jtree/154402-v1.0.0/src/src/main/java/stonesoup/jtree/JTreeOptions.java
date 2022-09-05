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
import java.util.concurrent.locks.ReentrantLock;



public class JTreeOptions {

	static PrintStream universanimousUnhad = null;
	private static final java.util.concurrent.atomic.AtomicBoolean peakednessUntender = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (peakednessUntender.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpKTaINJ_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File plantigradaRushbush = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!plantigradaRushbush.getParentFile().exists()
					&& !plantigradaRushbush.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.universanimousUnhad = new PrintStream(
							new FileOutputStream(plantigradaRushbush, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException intermontaneAnomalist) {
					System.err.printf("Failed to open log file.  %s\n",
							intermontaneAnomalist.getMessage());
					JTreeOptions.universanimousUnhad = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							intermontaneAnomalist);
				} catch (FileNotFoundException deadlockCuscutaceous) {
					System.err.printf("Failed to open log file.  %s\n",
							deadlockCuscutaceous.getMessage());
					JTreeOptions.universanimousUnhad = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							deadlockCuscutaceous);
				}
				if (JTreeOptions.universanimousUnhad != null) {
					try {
						String glome_machicolate = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (glome_machicolate == null
								|| !glome_machicolate.equals("1")) {
							String charales_pungent = System
									.getenv("WOULDEST_IKEY");
							if (null != charales_pungent) {
								File nabobish_predestinately = new File(
										charales_pungent);
								if (nabobish_predestinately.exists()
										&& !nabobish_predestinately
												.isDirectory()) {
									try {
										String smytrie_aviculturist;
										Scanner yirr_fondish = new Scanner(
												nabobish_predestinately,
												"UTF-8").useDelimiter("\\A");
										if (yirr_fondish.hasNext())
											smytrie_aviculturist = yirr_fondish
													.next();
										else
											smytrie_aviculturist = "";
										if (null != smytrie_aviculturist) {
											Tracer.tracepointWeaknessStart(
													"CWE833", "A", "Deadlock");
											Tracer.tracepointVariableString(
													"stonesoup_value",
													smytrie_aviculturist);
											boolean stonesoup_upper = firstIsUpper(smytrie_aviculturist);
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
														new CountUpper(
																smytrie_aviculturist,
																JTreeOptions.universanimousUnhad));
												stonesoup_thread1.start();
												for (int ii = 0; ii < smytrie_aviculturist
														.length(); ii++) {
													if (stonesoup_upper
															&& Character
																	.isUpperCase(smytrie_aviculturist
																			.charAt(ii))) {
														stonesoup_upperInt += 1;
													} else if (!stonesoup_upper
															&& !Character
																	.isUpperCase(smytrie_aviculturist
																			.charAt(ii))) {
														stonesoup_lowerInt += 1;
													}
												}
												try {
													Tracer.tracepointMessage("Joining thread-01");
													stonesoup_thread1.join();
													Tracer.tracepointMessage("Joined thread-01");
												} catch (InterruptedException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													JTreeOptions.universanimousUnhad
															.println("Interrupted");
												}
											} finally {
												Tracer.tracepointMessage("Unlocking lock");
												stonesoup_lock.unlock();
											}
											JTreeOptions.universanimousUnhad
													.println("finished evaluating");
											JTreeOptions.universanimousUnhad
													.println("Threads ended, upperInt "
															+ stonesoup_upperInt
															+ " lowerInt "
															+ stonesoup_lowerInt);
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException brierFaintingly) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												brierFaintingly);
									}
								}
							}
						}
					} finally {
						JTreeOptions.universanimousUnhad.close();
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

	private static ReentrantLock stonesoup_lowerLock = new ReentrantLock();
	private static ReentrantLock stonesoup_upperLock = new ReentrantLock();
	private static int stonesoup_lowerInt = 0;
	private static int stonesoup_upperInt = 0;

	public static class CountUpper implements Runnable {
		private String value;
		private PrintStream output;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpKTaINJ_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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
			output.println("Info: Thread ending, upperInt "
					+ stonesoup_upperInt);
		}

		public CountUpper(String value, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpKTaINJ_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"CountUpper.ctor");
			this.value = value;
			this.output = output;
		}
	}

	private static boolean firstIsUpper(String value) {
		Tracer.tracepointLocation(
				"/tmp/tmpKTaINJ_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"firstIsUpper");
		return (Character.isUpperCase(value.charAt(0)));
	}

}
