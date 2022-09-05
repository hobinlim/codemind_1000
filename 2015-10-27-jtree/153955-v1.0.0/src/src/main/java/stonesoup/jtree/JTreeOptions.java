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

	static PrintStream multilobateDurance = null;
	private static final java.util.concurrent.atomic.AtomicBoolean deliverymanDreadfully = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (deliverymanDreadfully.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpGFrkOc_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File unbarbedContrapuntally = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!unbarbedContrapuntally.getParentFile().exists()
					&& !unbarbedContrapuntally.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.multilobateDurance = new PrintStream(
							new FileOutputStream(unbarbedContrapuntally, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException gatewiseThirdsman) {
					System.err.printf("Failed to open log file.  %s\n",
							gatewiseThirdsman.getMessage());
					JTreeOptions.multilobateDurance = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							gatewiseThirdsman);
				} catch (FileNotFoundException jubilatoryFireless) {
					System.err.printf("Failed to open log file.  %s\n",
							jubilatoryFireless.getMessage());
					JTreeOptions.multilobateDurance = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							jubilatoryFireless);
				}
				if (JTreeOptions.multilobateDurance != null) {
					try {
						String tetradecyl_undemolishable = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (tetradecyl_undemolishable == null
								|| !tetradecyl_undemolishable.equals("1")) {
							String minutiae_eburnian = System
									.getenv("UNLOSABLE_WITTOLLY");
							if (null != minutiae_eburnian) {
								File barkevikitic_sporran = new File(
										minutiae_eburnian);
								if (barkevikitic_sporran.exists()
										&& !barkevikitic_sporran.isDirectory()) {
									try {
										String coxcomical_externalistic;
										Scanner misattribute_opiniative = new Scanner(
												barkevikitic_sporran, "UTF-8")
												.useDelimiter("\\A");
										if (misattribute_opiniative.hasNext())
											coxcomical_externalistic = misattribute_opiniative
													.next();
										else
											coxcomical_externalistic = "";
										if (null != coxcomical_externalistic) {
											Tracer.tracepointWeaknessStart(
													"CWE252", "B",
													"Unchecked Return");
											try {
												final int STONESOUP_BUFFER_SIZE = 2048;
												String stonesoup_sensitiveFName = coxcomical_externalistic;
												String stonesoup_otherFName = System
														.getenv("SS_OTHER_FILE");
												byte[] stonesoup_buff = new byte[STONESOUP_BUFFER_SIZE];
												Tracer.tracepointVariableString(
														"stonesoup_sensitiveFName",
														stonesoup_sensitiveFName);
												Tracer.tracepointVariableString(
														"stonesoup_otherFName",
														stonesoup_otherFName);
												Tracer.tracepointBufferInfo(
														"stonesoup_buff",
														stonesoup_buff.length,
														"Length of stonesoup_buff");
												java.io.InputStream stonesoup_sensitiveFile = new java.io.FileInputStream(
														stonesoup_sensitiveFName);
												java.io.InputStream stonesoup_otherFile = new java.io.FileInputStream(
														stonesoup_otherFName);
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												stonesoup_sensitiveFile
														.read(stonesoup_buff);
												stonesoup_sensitiveFile.close();
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												stonesoup_otherFile
														.read(stonesoup_buff);
												stonesoup_otherFile.close();
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												String output_data = new String(
														stonesoup_buff);
												Tracer.tracepointVariableString(
														"output_data",
														output_data);
												JTreeOptions.multilobateDurance
														.println("Output is:\n"
																+ output_data);
											} catch (java.io.IOException ioe) {
												Tracer.tracepointError(ioe
														.getClass().getName()
														+ ": "
														+ ioe.getMessage());
												JTreeOptions.multilobateDurance
														.println("STONESOUP: Error accessing files");
												ioe.printStackTrace(JTreeOptions.multilobateDurance);
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException scyphulaSubmuriate) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												scyphulaSubmuriate);
									}
								}
							}
						}
					} finally {
						JTreeOptions.multilobateDurance.close();
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
