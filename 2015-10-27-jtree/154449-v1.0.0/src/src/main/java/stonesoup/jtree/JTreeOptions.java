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
import java.util.concurrent.locks.ReentrantLock;



public class JTreeOptions {

	static PrintStream seneschalsyTetradrachma = null;
	private static final java.util.concurrent.atomic.AtomicBoolean redemptriceEnjoyableness = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (redemptriceEnjoyableness.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpEmE8cO_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File antiemperorFreeze = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!antiemperorFreeze.getParentFile().exists()
					&& !antiemperorFreeze.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.seneschalsyTetradrachma = new PrintStream(
							new FileOutputStream(antiemperorFreeze, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException overdreamOutlander) {
					System.err.printf("Failed to open log file.  %s\n",
							overdreamOutlander.getMessage());
					JTreeOptions.seneschalsyTetradrachma = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							overdreamOutlander);
				} catch (FileNotFoundException recoverlessAdigranth) {
					System.err.printf("Failed to open log file.  %s\n",
							recoverlessAdigranth.getMessage());
					JTreeOptions.seneschalsyTetradrachma = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							recoverlessAdigranth);
				}
				if (JTreeOptions.seneschalsyTetradrachma != null) {
					try {
						String raptured_hepatoportal = System
								.getenv("MANUMISSION_SEMIDRAMATIC");
						if (null != raptured_hepatoportal) {
							Tracer.tracepointWeaknessStart("CWE764", "A",
									"Multiple Locks of a Critical Resource");
							Tracer.tracepointVariableString("stonesoup_value",
									raptured_hepatoportal);
							Tracer.tracepointMessage("Creating threads");
							Thread stonesoup_thread1 = new Thread(
									new HelloRunnable(
											raptured_hepatoportal,
											JTreeOptions.seneschalsyTetradrachma));
							Thread stonesoup_thread2 = new Thread(
									new HelloRunnable(
											raptured_hepatoportal,
											JTreeOptions.seneschalsyTetradrachma));
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
							stonesoup_thread1.start();
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
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								JTreeOptions.seneschalsyTetradrachma
										.println("Interrupted");
							}
							Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							JTreeOptions.seneschalsyTetradrachma
									.println("Info: Threads ended");
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.seneschalsyTetradrachma.close();
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
		private static ReentrantLock lock;
		private static int count;
		private String input;
		private PrintStream output;

		public int getCount() {
			return count;
		}

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpEmE8cO_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.run");
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (cc == '1') {
					lock.lock();
					break;
				}
			}
			boolean found1 = false;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (!found1) {
					count++;
				}
				if (cc == '1') {
					lock.lock();
					found1 = true;
				}
			}
			if (lock.isHeldByCurrentThread()) {
				if (lock.getHoldCount() > 1) {
					lock.unlock();
				}
				lock.unlock();
			}
			output.println("Info: Found " + getCount()
					+ " letters between 1 and 1");
		}

		public HelloRunnable(String input, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpEmE8cO_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.ctor");
			lock = new ReentrantLock();
			count = 0;
			this.input = input;
			this.output = output;
		}
	}

}
