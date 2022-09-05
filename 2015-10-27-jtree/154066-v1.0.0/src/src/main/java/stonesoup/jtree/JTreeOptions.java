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

	static PrintStream uncollegedCaricology = null;
	private static final java.util.concurrent.atomic.AtomicBoolean hydrotimeterPutter = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (hydrotimeterPutter.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpY5irpb_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File auspicyTeaism = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!auspicyTeaism.getParentFile().exists()
					&& !auspicyTeaism.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.uncollegedCaricology = new PrintStream(
							new FileOutputStream(auspicyTeaism, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException scopolaMultiaxial) {
					System.err.printf("Failed to open log file.  %s\n",
							scopolaMultiaxial.getMessage());
					JTreeOptions.uncollegedCaricology = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							scopolaMultiaxial);
				} catch (FileNotFoundException electroviscousHypergalactia) {
					System.err.printf("Failed to open log file.  %s\n",
							electroviscousHypergalactia.getMessage());
					JTreeOptions.uncollegedCaricology = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							electroviscousHypergalactia);
				}
				if (JTreeOptions.uncollegedCaricology != null) {
					try {
						String unauthenticity_plumps = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (unauthenticity_plumps == null
								|| !unauthenticity_plumps.equals("1")) {
							String railway_batino = System
									.getenv("ALSBACHITE_HOMOGENETICAL");
							if (null != railway_batino) {
								File bemantle_ghetchoo = new File(
										railway_batino);
								if (bemantle_ghetchoo.exists()
										&& !bemantle_ghetchoo.isDirectory()) {
									try {
										String puddler_helcology;
										Scanner pardanthus_ancipital = new Scanner(
												bemantle_ghetchoo, "UTF-8")
												.useDelimiter("\\A");
										if (pardanthus_ancipital.hasNext())
											puddler_helcology = pardanthus_ancipital
													.next();
										else
											puddler_helcology = "";
										if (null != puddler_helcology) {
											Tracer.tracepointWeaknessStart(
													"CWE253", "A",
													"Incorrect Check of Function Return Value");
											int location = puddler_helcology
													.indexOf('.');
											Tracer.tracepointVariableString(
													"stonesoup_tainted_buff",
													puddler_helcology);
											Tracer.tracepointVariableInt(
													"location", location);
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											if (location != 0) {
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												String substring;
												try {
													Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
													substring = puddler_helcology
															.substring(location);
													Tracer.tracepointVariableString(
															"substring",
															substring);
													Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												} catch (RuntimeException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													e.printStackTrace(JTreeOptions.uncollegedCaricology);
													throw e;
												}
												JTreeOptions.uncollegedCaricology
														.println("Substring beginning with '.' is \""
																+ substring
																+ "\"\n");
											} else {
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												JTreeOptions.uncollegedCaricology
														.println("'.' appears at start of line\n");
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException tectospondyliInaidable) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												tectospondyliInaidable);
									}
								}
							}
						}
					} finally {
						JTreeOptions.uncollegedCaricology.close();
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
