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
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;



public class JTreeOptions {

	static PrintStream rebindRoadstead = null;
	private static final java.util.concurrent.atomic.AtomicBoolean laglastFootsoreness = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (laglastFootsoreness.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpxSZDmX_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File disembellishEmblazon = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!disembellishEmblazon.getParentFile().exists()
					&& !disembellishEmblazon.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.rebindRoadstead = new PrintStream(
							new FileOutputStream(disembellishEmblazon, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException flirtatiousDisaffiliation) {
					System.err.printf("Failed to open log file.  %s\n",
							flirtatiousDisaffiliation.getMessage());
					JTreeOptions.rebindRoadstead = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							flirtatiousDisaffiliation);
				} catch (FileNotFoundException snakelingUnbaized) {
					System.err.printf("Failed to open log file.  %s\n",
							snakelingUnbaized.getMessage());
					JTreeOptions.rebindRoadstead = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							snakelingUnbaized);
				}
				if (JTreeOptions.rebindRoadstead != null) {
					try {
						String bulrushlike_outwork = System
								.getenv("BEACHMASTER_BOOTLEG");
						if (null != bulrushlike_outwork) {
							long bloody_polyterpene;
							try {
								bloody_polyterpene = Long
										.parseLong(bulrushlike_outwork);
							} catch (NumberFormatException neopaleozoic_trotyl) {
								throw new RuntimeException(
										"STONESOUP: Failed to convert source taint.",
										neopaleozoic_trotyl);
							}
							Tracer.tracepointWeaknessStart("CWE197", "A",
									"Numeric Trucation Error");
							Tracer.tracepointVariableLong("value",
									bloody_polyterpene);
							if (bloody_polyterpene > 0) {
								Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
								int stonesoup_max_value = (int) ((long) bloody_polyterpene);
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								Tracer.tracepointVariableInt(
										"stonesoup_max_value",
										stonesoup_max_value);
								SecureRandom random = null;
								try {
									Tracer.tracepointMessage("Creating PRNG.");
									random = SecureRandom
											.getInstance("SHA1PRNG");
								} catch (NoSuchAlgorithmException e) {
									JTreeOptions.rebindRoadstead
											.println("STONESOUP: Failed to create PRNG.");
									e.printStackTrace(JTreeOptions.rebindRoadstead);
								}
								if (random != null) {
									Tracer.tracepointMessage("Generating random variable between 0 and stonesoup_max_value");
									try {
										JTreeOptions.rebindRoadstead
												.printf("Generating random value between %d (inclusive) and %d (exclusive).\n",
														0, stonesoup_max_value);
										Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
										JTreeOptions.rebindRoadstead
												.printf("Random choice: %d\n",
														random.nextInt(stonesoup_max_value));
										Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
									} catch (RuntimeException e) {
										Tracer.tracepointError(e.getClass()
												.getName()
												+ ": "
												+ e.getMessage());
										e.printStackTrace(JTreeOptions.rebindRoadstead);
										throw e;
									}
									Tracer.tracepointMessage("After random value generation.");
								}
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.rebindRoadstead.close();
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
