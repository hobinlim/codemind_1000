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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;



public class JTreeOptions {

	static PrintStream costumierParodist = null;
	private static final java.util.concurrent.atomic.AtomicBoolean vinosityWeism = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (vinosityWeism.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File underweightTeca = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!underweightTeca.getParentFile().exists()
					&& !underweightTeca.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.costumierParodist = new PrintStream(
							new FileOutputStream(underweightTeca, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException levierNecrophilous) {
					System.err.printf("Failed to open log file.  %s\n",
							levierNecrophilous.getMessage());
					JTreeOptions.costumierParodist = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							levierNecrophilous);
				} catch (FileNotFoundException epidositeHalesia) {
					System.err.printf("Failed to open log file.  %s\n",
							epidositeHalesia.getMessage());
					JTreeOptions.costumierParodist = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							epidositeHalesia);
				}
				if (JTreeOptions.costumierParodist != null) {
					try {
						String hyracodon_underweapon = System
								.getenv("BHOOSA_IMPACABILITY");
						if (null != hyracodon_underweapon) {
							Tracer.tracepointWeaknessStart("CWE609", "A",
									"Double-Checked Locking");
							int stonesoup_qsize = 0;
							String stonesoup_taint = null;
							String stonesoup_file1 = null;
							String stonesoup_file2 = null;
							String stonesoup_substrings[] = hyracodon_underweapon
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
											hyracodon_underweapon);
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
									JTreeOptions.costumierParodist
											.println("NumberFormatException");
								}
								if (stonesoup_qsize < 0) {
									JTreeOptions.costumierParodist
											.println("Error: use positive numbers.");
								} else {
									Tracer.tracepointMessage("Creating threads");
									Thread stonesoup_thread1 = new Thread(
											new doStuff(
													stonesoup_taint,
													stonesoup_qsize,
													stonesoup_file2,
													JTreeOptions.costumierParodist));
									Thread stonesoup_thread2 = new Thread(
											new doStuff2(
													stonesoup_taint,
													stonesoup_qsize,
													stonesoup_file1,
													JTreeOptions.costumierParodist));
									JTreeOptions.costumierParodist
											.println("Info: Spawning thread 1.");
									stonesoup_thread1.start();
									JTreeOptions.costumierParodist
											.println("Info: Spawning thread 2.");
									stonesoup_thread2.start();
									try {
										Tracer.tracepointMessage("Joining threads");
										Tracer.tracepointMessage("Joining thread-01");
										stonesoup_thread1.join();
										Tracer.tracepointMessage("Joined thread-01");
										Tracer.tracepointMessage("Joining thread-02");
										stonesoup_thread2.join();
										Tracer.tracepointMessage("Joined thread-02");
										Tracer.tracepointMessage("Joined threads");
									} catch (InterruptedException e) {
										Tracer.tracepointError(e.getClass()
												.getName()
												+ ": "
												+ e.getMessage());
										JTreeOptions.costumierParodist
												.println("Interrupted");
									}
									JTreeOptions.costumierParodist
											.println("Info: Threads ended");
								}
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.costumierParodist.close();
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

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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

	public static class Stonesoup_Str {
		public static StringBuilder data = null;
		public static int size = -1;
	}

	public static void init_Stonesoup_Str(String data, int qsize,
			String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"init_Stonesoup_Str");
		output.println(Thread.currentThread().getId()
				+ ": In init_Stonesoup_Str");
		if (Stonesoup_Str.data == null) {
			lock.lock();
			if (Stonesoup_Str.data == null) {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				Stonesoup_Str.data = new StringBuilder();
				Stonesoup_Str.size = data.length();
				output.println(Thread.currentThread().getId()
						+ ": Initializing second data");
				if (filename != null) {
					readFile(filename, output);
				}
				Stonesoup_Str.data.append(data);
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			} else {
				output.println(Thread.currentThread().getId()
						+ ": No need to initialize");
			}
			lock.unlock();
		} else {
			output.println(Thread.currentThread().getId()
					+ ": Data is already initialized");
		}
	}

	public static class doStuff implements Runnable {
		private int size = 0;
		private String data = null;
		private PrintStream output;
		String filename;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"doStuff.run");
			try {
				output.println(Thread.currentThread().getId()
						+ ": Inside doStuff");
				Tracer.tracepointMessage("doStuff: entering init_Stonesoup_Str");
				init_Stonesoup_Str(data, size, filename, output);
				output.println(Thread.currentThread().getId()
						+ ": In doStuff Stonesoup_Str is: "
						+ Stonesoup_Str.data.toString());
				Tracer.tracepointVariableString("Stonesoup_Str",
						Stonesoup_Str.data.toString());
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public doStuff(String data, int qsize, String filename,
				PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"doStuff.ctor");
			this.data = data;
			this.size = qsize;
			this.output = output;
			this.filename = filename;
		}
	}

	public static class doStuff2 implements Runnable {
		private int size = 0;
		private String data = null;
		private PrintStream output;
		private String filename;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"doStuff2.run");
			int[] sortMe = new int[size];
			try {
				output.println(Thread.currentThread().getId()
						+ ": Inside doStuff2");
				for (int i = 0; i < size; i++) {
					sortMe[i] = size - i;
				}
				Arrays.sort(sortMe);
				readFile(filename, output);
				Tracer.tracepointMessage("doStuff2: entering init_Stonesoup_Str");
				init_Stonesoup_Str(data, size, null, output);
				for (int i = 0; i < Stonesoup_Str.data.length(); i++) {
					if (Stonesoup_Str.data.charAt(i) >= 'a'
							|| Stonesoup_Str.data.charAt(i) <= 'z') {
						Stonesoup_Str.data
								.setCharAt(
										i,
										(char) (Stonesoup_Str.data.charAt(i) - ('a' - 'A')));
					}
				}
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				if (Stonesoup_Str.data.charAt(0) != '\0') {
					output.println(Thread.currentThread().getId()
							+ ": In doStuff2 Stonesoup_Str is: "
							+ Stonesoup_Str.data.toString());
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public doStuff2(String data, int size, String filename,
				PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpICx4_H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"doStuff2.ctor");
			this.data = data;
			this.size = size;
			this.filename = filename;
			this.output = output;
		}
	}

}
