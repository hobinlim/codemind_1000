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

	static PrintStream ferromagnetismHetericism = null;
	private static final java.util.concurrent.atomic.AtomicBoolean midbrainEndorsed = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (midbrainEndorsed.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpwx4Vx5_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File dogshoreSalpiglossis = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!dogshoreSalpiglossis.getParentFile().exists()
					&& !dogshoreSalpiglossis.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.ferromagnetismHetericism = new PrintStream(
							new FileOutputStream(dogshoreSalpiglossis, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException benedicitePsychal) {
					System.err.printf("Failed to open log file.  %s\n",
							benedicitePsychal.getMessage());
					JTreeOptions.ferromagnetismHetericism = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							benedicitePsychal);
				} catch (FileNotFoundException unsinewedWorshipworthy) {
					System.err.printf("Failed to open log file.  %s\n",
							unsinewedWorshipworthy.getMessage());
					JTreeOptions.ferromagnetismHetericism = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							unsinewedWorshipworthy);
				}
				if (JTreeOptions.ferromagnetismHetericism != null) {
					try {
						String enchytraeidae_baga = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (enchytraeidae_baga == null
								|| !enchytraeidae_baga.equals("1")) {
							String chronaxie_alupag = System
									.getenv("SPICATED_FACER");
							if (null != chronaxie_alupag) {
								File diapensiaceous_origination = new File(
										chronaxie_alupag);
								if (diapensiaceous_origination.exists()
										&& !diapensiaceous_origination
												.isDirectory()) {
									try {
										String incombustion_musculospinal;
										Scanner agarum_clam = new Scanner(
												diapensiaceous_origination,
												"UTF-8").useDelimiter("\\A");
										if (agarum_clam.hasNext())
											incombustion_musculospinal = agarum_clam
													.next();
										else
											incombustion_musculospinal = "";
										if (null != incombustion_musculospinal) {
											Tracer.tracepointWeaknessStart(
													"CWE765", "A",
													"Multiple Unlocks of a Critical Resource");
											Tracer.tracepointMessage("Creating thread");
											Thread stonesoup_thread1 = new Thread(
													new HelloRunnable(
															incombustion_musculospinal,
															JTreeOptions.ferromagnetismHetericism));
											stonesoup_thread1.start();
											try {
												Tracer.tracepointMessage("Joining thread-01");
												stonesoup_thread1.join();
												Tracer.tracepointMessage("Joined thread-01");
											} catch (InterruptedException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												JTreeOptions.ferromagnetismHetericism
														.println("Interrupted");
											}
											JTreeOptions.ferromagnetismHetericism
													.println("Info: Threads ended");
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException nonthinkingCulverhouse) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												nonthinkingCulverhouse);
									}
								}
							}
						}
					} finally {
						JTreeOptions.ferromagnetismHetericism.close();
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
					"/tmp/tmpwx4Vx5_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.run");
			Tracer.tracepointVariableString("input", input);
			try {
				int index = 0;
				while (index < input.length()) {
					char cc = input.charAt(index);
					index++;
					if (cc == '1') {
						Tracer.tracepointMessage("Locking lock");
						Tracer.tracepointVariableInt("index", index);
						lock.lock();
						break;
					}
				}
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
				boolean found1 = false;
				while (index < input.length()) {
					char cc = input.charAt(index);
					index++;
					if (!found1) {
						count++;
					}
					if (cc == '1') {
						Tracer.tracepointMessage("Unlocking lock");
						lock.unlock();
						found1 = true;
					}
				}
				if (lock.isHeldByCurrentThread()) {
					Tracer.tracepointMessage("Unlocking lock");
					lock.unlock();
				}
				Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
				Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
				output.println("Info: Found " + getCount()
						+ " letters between 1 and 1");
			} catch (java.lang.RuntimeException e) {
				e.printStackTrace(output);
				throw e;
			}
		}

		public HelloRunnable(String input, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpwx4Vx5_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.ctor");
			lock = new ReentrantLock();
			count = 0;
			this.input = input;
			this.output = output;
		}
	}

}
