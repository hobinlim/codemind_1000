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
import java.io.IOException;



public class JTreeOptions {

	static PrintStream unplasticArrosive = null;
	private static final java.util.concurrent.atomic.AtomicBoolean sandwortBest = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (sandwortBest.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmp4MaFF3_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File ceratoidInterlocation = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!ceratoidInterlocation.getParentFile().exists()
					&& !ceratoidInterlocation.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.unplasticArrosive = new PrintStream(
							new FileOutputStream(ceratoidInterlocation, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException scavenagePhalaenae) {
					System.err.printf("Failed to open log file.  %s\n",
							scavenagePhalaenae.getMessage());
					JTreeOptions.unplasticArrosive = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							scavenagePhalaenae);
				} catch (FileNotFoundException errataMigrate) {
					System.err.printf("Failed to open log file.  %s\n",
							errataMigrate.getMessage());
					JTreeOptions.unplasticArrosive = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							errataMigrate);
				}
				if (JTreeOptions.unplasticArrosive != null) {
					try {
						String preinquisition_gravestone = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (preinquisition_gravestone == null
								|| !preinquisition_gravestone.equals("1")) {
							String brankie_discomforting = System
									.getenv("PATELLINE_CLUBSTER");
							if (null != brankie_discomforting) {
								File coercion_nonappointment = new File(
										brankie_discomforting);
								if (coercion_nonappointment.exists()
										&& !coercion_nonappointment
												.isDirectory()) {
									try {
										String muriciform_lassitude;
										Scanner inconsumable_arenicole = new Scanner(
												coercion_nonappointment,
												"UTF-8").useDelimiter("\\A");
										if (inconsumable_arenicole.hasNext())
											muriciform_lassitude = inconsumable_arenicole
													.next();
										else
											muriciform_lassitude = "";
										if (null != muriciform_lassitude) {
											Tracer.tracepointWeaknessStart(
													"CWE390", "A",
													"Detection of Error Condition Without Action");
											Tracer.tracepointVariableString(
													"filename",
													muriciform_lassitude);
											java.io.FileInputStream fis = null;
											java.io.File readPath = new java.io.File(
													muriciform_lassitude);
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											try {
												fis = new java.io.FileInputStream(
														readPath);
											} catch (java.io.FileNotFoundException e) {
											}
											Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
											try {
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												java.io.BufferedReader reader = new java.io.BufferedReader(
														new java.io.InputStreamReader(
																fis));
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												String line = null;
												try {
													while ((line = reader
															.readLine()) != null) {
														JTreeOptions.unplasticArrosive
																.println(line);
													}
												} catch (IOException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													JTreeOptions.unplasticArrosive
															.printf("Failed to read file.\n");
												}
											} catch (RuntimeException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												e.printStackTrace(JTreeOptions.unplasticArrosive);
												throw e;
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException moxoDictum) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												moxoDictum);
									}
								}
							}
						}
					} finally {
						JTreeOptions.unplasticArrosive.close();
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
