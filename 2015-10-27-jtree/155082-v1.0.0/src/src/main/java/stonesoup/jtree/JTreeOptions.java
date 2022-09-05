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

	static PrintStream pseudomoralAdjunctive = null;
	private static final java.util.concurrent.atomic.AtomicBoolean shibuichiCanoness = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (shibuichiCanoness.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpDGCbxl_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File notedlySnowball = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!notedlySnowball.getParentFile().exists()
					&& !notedlySnowball.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.pseudomoralAdjunctive = new PrintStream(
							new FileOutputStream(notedlySnowball, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException strikebreakerAbnaki) {
					System.err.printf("Failed to open log file.  %s\n",
							strikebreakerAbnaki.getMessage());
					JTreeOptions.pseudomoralAdjunctive = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							strikebreakerAbnaki);
				} catch (FileNotFoundException crapulentWealdsman) {
					System.err.printf("Failed to open log file.  %s\n",
							crapulentWealdsman.getMessage());
					JTreeOptions.pseudomoralAdjunctive = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							crapulentWealdsman);
				}
				if (JTreeOptions.pseudomoralAdjunctive != null) {
					try {
						String pittacal_bauera = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (pittacal_bauera == null
								|| !pittacal_bauera.equals("1")) {
							String winnipesaukee_nephremphraxis = System
									.getenv("HYGROGRAPH_ATAVIST");
							if (null != winnipesaukee_nephremphraxis) {
								File imaginativeness_hyponeuria = new File(
										winnipesaukee_nephremphraxis);
								if (imaginativeness_hyponeuria.exists()
										&& !imaginativeness_hyponeuria
												.isDirectory()) {
									try {
										String rutty_divisionist;
										Scanner transmutably_hamlinite = new Scanner(
												imaginativeness_hyponeuria,
												"UTF-8").useDelimiter("\\A");
										if (transmutably_hamlinite.hasNext())
											rutty_divisionist = transmutably_hamlinite
													.next();
										else
											rutty_divisionist = "";
										if (null != rutty_divisionist) {
											char antibridal_antinosarian;
											try {
												antibridal_antinosarian = rutty_divisionist
														.charAt(0);
											} catch (IndexOutOfBoundsException hypoplanktonic_veratrate) {
												throw new RuntimeException(
														"STONESOUP: Failed to convert source taint.",
														hypoplanktonic_veratrate);
											}
											Tracer.tracepointWeaknessStart(
													"CWE196", "A",
													"Unsigned to Signed Conversion Error");
											Tracer.tracepointVariableChar(
													"value",
													antibridal_antinosarian);
											try {
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												int[] stonesoup_char_counts = stonesoupInitializeCounts((byte) ((char) antibridal_antinosarian));
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												for (char counter = 0; counter < antibridal_antinosarian; counter++) {
													stonesoup_char_counts[counter] += 1;
												}
												Tracer.tracepointBufferInfo(
														"stonesoup_char_counts",
														stonesoup_char_counts.length,
														"Length of stonesoup_char_counts");
											} catch (RuntimeException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												e.printStackTrace(JTreeOptions.pseudomoralAdjunctive);
												throw e;
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException reciprocitarianBennetweed) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												reciprocitarianBennetweed);
									}
								}
							}
						}
					} finally {
						JTreeOptions.pseudomoralAdjunctive.close();
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

	public static int[] stonesoupInitializeCounts(byte size) {
		Tracer.tracepointLocation(
				"/tmp/tmpDGCbxl_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"stonesoupInitializeCounts");
		Tracer.tracepointVariableByte("size", size);
		if (size == 0) {
			return null;
		}
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		int[] result = new int[size];
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
		Tracer.tracepointBufferInfo("result", result.length, "Length of result");
		for (int ii = 0; ii < result.length; ii++) {
			result[ii] = 0;
		}
		return result;
	}

}
