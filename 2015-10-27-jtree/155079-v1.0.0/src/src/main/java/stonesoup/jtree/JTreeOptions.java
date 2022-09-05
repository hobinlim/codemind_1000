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



public class JTreeOptions {

	static PrintStream lignicolineLiliaceae = null;
	private static final java.util.concurrent.atomic.AtomicBoolean alcoholizationNeosalvarsan = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (alcoholizationNeosalvarsan.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpS6_boT_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File egestiveWisdomship = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!egestiveWisdomship.getParentFile().exists()
					&& !egestiveWisdomship.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.lignicolineLiliaceae = new PrintStream(
							new FileOutputStream(egestiveWisdomship, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException epigastricCometographical) {
					System.err.printf("Failed to open log file.  %s\n",
							epigastricCometographical.getMessage());
					JTreeOptions.lignicolineLiliaceae = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							epigastricCometographical);
				} catch (FileNotFoundException poltophagicTheridiidae) {
					System.err.printf("Failed to open log file.  %s\n",
							poltophagicTheridiidae.getMessage());
					JTreeOptions.lignicolineLiliaceae = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							poltophagicTheridiidae);
				}
				if (JTreeOptions.lignicolineLiliaceae != null) {
					try {
						String alcaligenes_fissipalmate = System
								.getenv("EIGHTY_TOWELRY");
						if (null != alcaligenes_fissipalmate) {
							char preconvict_termlessly;
							try {
								preconvict_termlessly = alcaligenes_fissipalmate
										.charAt(0);
							} catch (IndexOutOfBoundsException autocratical_candymaker) {
								throw new RuntimeException(
										"STONESOUP: Failed to convert source taint.",
										autocratical_candymaker);
							}
							Tracer.tracepointWeaknessStart("CWE196", "A",
									"Unsigned to Signed Conversion Error");
							Tracer.tracepointVariableChar("value",
									preconvict_termlessly);
							try {
								Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
								int[] stonesoup_char_counts = stonesoupInitializeCounts((byte) ((char) preconvict_termlessly));
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								for (char counter = 0; counter < preconvict_termlessly; counter++) {
									stonesoup_char_counts[counter] += 1;
								}
								Tracer.tracepointBufferInfo(
										"stonesoup_char_counts",
										stonesoup_char_counts.length,
										"Length of stonesoup_char_counts");
							} catch (RuntimeException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								e.printStackTrace(JTreeOptions.lignicolineLiliaceae);
								throw e;
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.lignicolineLiliaceae.close();
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
				"/tmp/tmpS6_boT_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
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
