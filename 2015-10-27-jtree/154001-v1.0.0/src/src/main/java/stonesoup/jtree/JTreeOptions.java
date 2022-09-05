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
import java.io.IOException;



public class JTreeOptions {

	static PrintStream drapetomaniaGalvanometry = null;
	private static final java.util.concurrent.atomic.AtomicBoolean annoyanceOryza = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (annoyanceOryza.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpe6Ga7H_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File shrewdEjector = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!shrewdEjector.getParentFile().exists()
					&& !shrewdEjector.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.drapetomaniaGalvanometry = new PrintStream(
							new FileOutputStream(shrewdEjector, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException recokeKinepox) {
					System.err.printf("Failed to open log file.  %s\n",
							recokeKinepox.getMessage());
					JTreeOptions.drapetomaniaGalvanometry = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							recokeKinepox);
				} catch (FileNotFoundException pseudosiphonalFlamboyer) {
					System.err.printf("Failed to open log file.  %s\n",
							pseudosiphonalFlamboyer.getMessage());
					JTreeOptions.drapetomaniaGalvanometry = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							pseudosiphonalFlamboyer);
				}
				if (JTreeOptions.drapetomaniaGalvanometry != null) {
					try {
						String dysyntribite_collectanea = System
								.getenv("COLLARBIRD_HOLOTONIC");
						if (null != dysyntribite_collectanea) {
							Tracer.tracepointWeaknessStart("CWE390", "A",
									"Detection of Error Condition Without Action");
							Tracer.tracepointVariableString("filename",
									dysyntribite_collectanea);
							java.io.FileInputStream fis = null;
							java.io.File readPath = new java.io.File(
									dysyntribite_collectanea);
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							try {
								fis = new java.io.FileInputStream(readPath);
							} catch (java.io.FileNotFoundException e) {
							}
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							try {
								Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
								java.io.BufferedReader reader = new java.io.BufferedReader(
										new java.io.InputStreamReader(fis));
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
								String line = null;
								try {
									while ((line = reader.readLine()) != null) {
										JTreeOptions.drapetomaniaGalvanometry
												.println(line);
									}
								} catch (IOException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.drapetomaniaGalvanometry
											.printf("Failed to read file.\n");
								}
							} catch (RuntimeException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								e.printStackTrace(JTreeOptions.drapetomaniaGalvanometry);
								throw e;
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.drapetomaniaGalvanometry.close();
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
