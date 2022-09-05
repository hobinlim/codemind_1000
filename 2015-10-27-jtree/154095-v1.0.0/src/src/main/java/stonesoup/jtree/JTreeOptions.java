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

	static PrintStream corseletUnrocked = null;
	private static final java.util.concurrent.atomic.AtomicBoolean raiaTotterer = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (raiaTotterer.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpNaUsK5_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File gravaminaBadiaga = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!gravaminaBadiaga.getParentFile().exists()
					&& !gravaminaBadiaga.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.corseletUnrocked = new PrintStream(
							new FileOutputStream(gravaminaBadiaga, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException acceptabilityPeakiness) {
					System.err.printf("Failed to open log file.  %s\n",
							acceptabilityPeakiness.getMessage());
					JTreeOptions.corseletUnrocked = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							acceptabilityPeakiness);
				} catch (FileNotFoundException phytographerBuzzwig) {
					System.err.printf("Failed to open log file.  %s\n",
							phytographerBuzzwig.getMessage());
					JTreeOptions.corseletUnrocked = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							phytographerBuzzwig);
				}
				if (JTreeOptions.corseletUnrocked != null) {
					try {
						String unrecognizably_nymphitis = System
								.getenv("REPRESENTABLE_MACROFARAD");
						if (null != unrecognizably_nymphitis) {
							int fleeciness_sexagesimals;
							try {
								fleeciness_sexagesimals = Integer
										.parseInt(unrecognizably_nymphitis);
							} catch (NumberFormatException biograph_nonextraditable) {
								throw new RuntimeException(
										"STONESOUP: Failed to convert source taint.",
										biograph_nonextraditable);
							}
							Tracer.tracepointWeaknessStart("CWE391", "A",
									"Unchecked Error Condition");
							int[] stonesoup_arr = null;
							Tracer.tracepointVariableInt("size",
									fleeciness_sexagesimals);
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							try {
								JTreeOptions.corseletUnrocked.printf(
										"Allocating array of size %d\n",
										fleeciness_sexagesimals);
								stonesoup_arr = new int[fleeciness_sexagesimals];
							} catch (OutOfMemoryError e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
							}
							Tracer.tracepointBufferInfo("stonesoup_arr",
									(stonesoup_arr == null) ? 0
											: stonesoup_arr.length,
									"Length of stonesoup_arr");
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							try {
								Tracer.tracepointMessage("TRIGGER-PONIT: BEFORE");
								for (int i = 0; i < stonesoup_arr.length; i++) {
									stonesoup_arr[i] = fleeciness_sexagesimals
											- i;
								}
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							} catch (RuntimeException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								e.printStackTrace(JTreeOptions.corseletUnrocked);
								throw e;
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.corseletUnrocked.close();
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
