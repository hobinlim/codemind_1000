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



public class JTreeOptions {

	static PrintStream dysphonicSynecdochism = null;
	private static final java.util.concurrent.atomic.AtomicBoolean terebinthinaPyrex = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (terebinthinaPyrex.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpREvwKR_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File toponymistCoset = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!toponymistCoset.getParentFile().exists()
					&& !toponymistCoset.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.dysphonicSynecdochism = new PrintStream(
							new FileOutputStream(toponymistCoset, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException whyeverThievable) {
					System.err.printf("Failed to open log file.  %s\n",
							whyeverThievable.getMessage());
					JTreeOptions.dysphonicSynecdochism = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							whyeverThievable);
				} catch (FileNotFoundException unauRomanize) {
					System.err.printf("Failed to open log file.  %s\n",
							unauRomanize.getMessage());
					JTreeOptions.dysphonicSynecdochism = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.", unauRomanize);
				}
				if (JTreeOptions.dysphonicSynecdochism != null) {
					try {
						String submeaning_parentless = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (submeaning_parentless == null
								|| !submeaning_parentless.equals("1")) {
							String commeasurable_nidatory = System
									.getenv("SCHIST_PRETEXT");
							if (null != commeasurable_nidatory) {
								File trimoric_megacolon = new File(
										commeasurable_nidatory);
								if (trimoric_megacolon.exists()
										&& !trimoric_megacolon.isDirectory()) {
									try {
										String pathochemistry_sanguine;
										Scanner unaverted_leposternon = new Scanner(
												trimoric_megacolon, "UTF-8")
												.useDelimiter("\\A");
										if (unaverted_leposternon.hasNext())
											pathochemistry_sanguine = unaverted_leposternon
													.next();
										else
											pathochemistry_sanguine = "";
										if (null != pathochemistry_sanguine) {
											int sneezewort_mahmal;
											try {
												sneezewort_mahmal = Integer
														.parseInt(pathochemistry_sanguine);
											} catch (NumberFormatException cicatrose_capitan) {
												throw new RuntimeException(
														"STONESOUP: Failed to convert source taint.",
														cicatrose_capitan);
											}
											Tracer.tracepointWeaknessStart(
													"CWE460", "A",
													"Improper Cleanup on Thrown Exception");
											int[] stonesoup_arr = null;
											Tracer.tracepointVariableInt(
													"size", sneezewort_mahmal);
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											try {
												JTreeOptions.dysphonicSynecdochism
														.printf("Allocating array of size %d\n",
																sneezewort_mahmal);
												stonesoup_arr = new int[sneezewort_mahmal];
											} catch (java.lang.OutOfMemoryError e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												stonesoup_arr = new int[100];
											}
											Tracer.tracepointBufferInfo(
													"stonesoup_arr",
													stonesoup_arr.length,
													"Length of stonesoup_arr");
											Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
											try {
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												int i = sneezewort_mahmal - 1;
												do {
													stonesoup_arr[i--] = i;
												} while (i > 0);
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
											} catch (RuntimeException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												e.printStackTrace(JTreeOptions.dysphonicSynecdochism);
												throw e;
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException saughPalaemon) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												saughPalaemon);
									}
								}
							}
						}
					} finally {
						JTreeOptions.dysphonicSynecdochism.close();
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

}
