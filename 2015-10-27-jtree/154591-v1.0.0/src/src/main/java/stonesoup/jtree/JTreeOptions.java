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

	static PrintStream agonizerBroomtail = null;
	private static final java.util.concurrent.atomic.AtomicBoolean cytogeneticallyTowerwort = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (cytogeneticallyTowerwort.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File purpuraceousDecelerometer = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!purpuraceousDecelerometer.getParentFile().exists()
					&& !purpuraceousDecelerometer.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.agonizerBroomtail = new PrintStream(
							new FileOutputStream(purpuraceousDecelerometer,
									false), true, "ISO-8859-1");
				} catch (UnsupportedEncodingException monitrixGelatinobromide) {
					System.err.printf("Failed to open log file.  %s\n",
							monitrixGelatinobromide.getMessage());
					JTreeOptions.agonizerBroomtail = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							monitrixGelatinobromide);
				} catch (FileNotFoundException ingressiveVillitis) {
					System.err.printf("Failed to open log file.  %s\n",
							ingressiveVillitis.getMessage());
					JTreeOptions.agonizerBroomtail = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							ingressiveVillitis);
				}
				if (JTreeOptions.agonizerBroomtail != null) {
					try {
						String tumbly_roomward = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (tumbly_roomward == null
								|| !tumbly_roomward.equals("1")) {
							String mese_haemamoeba = System
									.getenv("RESULTINGLY_DAYWORKER");
							if (null != mese_haemamoeba) {
								File hexadactylic_fablemonger = new File(
										mese_haemamoeba);
								if (hexadactylic_fablemonger.exists()
										&& !hexadactylic_fablemonger
												.isDirectory()) {
									try {
										String unwrathfully_coleplant;
										Scanner paintable_titian = new Scanner(
												hexadactylic_fablemonger,
												"UTF-8").useDelimiter("\\A");
										if (paintable_titian.hasNext())
											unwrathfully_coleplant = paintable_titian
													.next();
										else
											unwrathfully_coleplant = "";
										if (null != unwrathfully_coleplant) {
											Tracer.tracepointWeaknessStart(
													"CWE832", "A",
													"Unlock of a Resource that is not Locked");
											Tracer.tracepointMessage("Creating thread");
											Thread stonesoup_thread1 = new Thread(
													new HelloRunnable(
															unwrathfully_coleplant,
															JTreeOptions.agonizerBroomtail));
											stonesoup_thread1.start();
											try {
												Tracer.tracepointMessage("Joining thread-01");
												stonesoup_thread1.join();
												Tracer.tracepointMessage("Joined thread-01");
											} catch (InterruptedException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												JTreeOptions.agonizerBroomtail
														.println("Interrupted");
											}
											JTreeOptions.agonizerBroomtail
													.println("Info: Thread ended");
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException semiflosculoseLusatian) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												semiflosculoseLusatian);
									}
								}
							}
						}
					} finally {
						JTreeOptions.agonizerBroomtail.close();
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

	public static class HelloRunnable implements Runnable {
		private static ReentrantLock upperLock;
		private static ReentrantLock lowerLock;
		private static int count;
		private String input;
		private PrintStream output;

		public int getCount() {
			Tracer.tracepointLocation(
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.getCount");
			return count;
		}

		private void lockA(Character cc) {
			Tracer.tracepointLocation(
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.unlockA");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			Tracer.tracepointMessage("Unlocking lowerlock");
			lowerLock.unlock();
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		}

		private void cleanLocks() {
			Tracer.tracepointLocation(
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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
					"/tmp/tmpJ5wnNp_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunable.ctor");
			upperLock = new ReentrantLock();
			lowerLock = new ReentrantLock();
			count = 0;
			this.input = input;
			this.output = output;
		}
	}

}
