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

	static PrintStream despondingConsultative = null;
	private static final java.util.concurrent.atomic.AtomicBoolean frigNeurogrammic = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (frigNeurogrammic.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpPj3Qfv_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File lacyMetapepsis = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!lacyMetapepsis.getParentFile().exists()
					&& !lacyMetapepsis.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.despondingConsultative = new PrintStream(
							new FileOutputStream(lacyMetapepsis, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException bagpiperPanacea) {
					System.err.printf("Failed to open log file.  %s\n",
							bagpiperPanacea.getMessage());
					JTreeOptions.despondingConsultative = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							bagpiperPanacea);
				} catch (FileNotFoundException filoBiting) {
					System.err.printf("Failed to open log file.  %s\n",
							filoBiting.getMessage());
					JTreeOptions.despondingConsultative = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.", filoBiting);
				}
				if (JTreeOptions.despondingConsultative != null) {
					try {
						String pumplike_unsquinting = System
								.getenv("MANUALIST_VESSIGNON");
						if (null != pumplike_unsquinting) {
							short vesperal_irresoluble;
							try {
								vesperal_irresoluble = Short
										.parseShort(pumplike_unsquinting);
							} catch (NumberFormatException moudy_unhid) {
								throw new RuntimeException(
										"STONESOUP: Failed to convert source taint.",
										moudy_unhid);
							}
							Tracer.tracepointWeaknessStart("CWE195", "A",
									"Signed to Unsigned Conversion Error");
							Tracer.tracepointVariableShort("value",
									vesperal_irresoluble);
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							int[] stonesoup_array = new int[Math
									.abs(vesperal_irresoluble)];
							char stonesoup_max_char = (char) ((short) vesperal_irresoluble);
							Tracer.tracepointBufferInfo("stonesoup_array",
									stonesoup_array.length,
									"Length of stonesoup_array");
							Tracer.tracepointVariableChar("stonesoup_max_char",
									stonesoup_max_char);
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							try {
								Tracer.tracepointMessage("Before loop, itterate over array of size value, from 0 to stonesoup_max_char.");
								Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
								for (char stonesoup_counter = 0; stonesoup_counter < stonesoup_max_char; stonesoup_counter++) {
									JTreeOptions.despondingConsultative.printf(
											"Counter value: \"%c\"\n",
											stonesoup_counter);
									stonesoup_array[stonesoup_counter] = 0;
								}
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							} catch (RuntimeException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								e.printStackTrace(JTreeOptions.despondingConsultative);
								throw e;
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.despondingConsultative.close();
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
