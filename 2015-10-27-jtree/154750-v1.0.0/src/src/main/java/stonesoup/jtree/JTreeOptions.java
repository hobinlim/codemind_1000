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

	static PrintStream hapticFurtherly = null;
	private static final java.util.concurrent.atomic.AtomicBoolean clavalNonterminating = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (clavalNonterminating.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmptbSwUm_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File preferrednessMiranha = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!preferrednessMiranha.getParentFile().exists()
					&& !preferrednessMiranha.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.hapticFurtherly = new PrintStream(
							new FileOutputStream(preferrednessMiranha, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException herewithalCise) {
					System.err.printf("Failed to open log file.  %s\n",
							herewithalCise.getMessage());
					JTreeOptions.hapticFurtherly = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							herewithalCise);
				} catch (FileNotFoundException belongerSheepcote) {
					System.err.printf("Failed to open log file.  %s\n",
							belongerSheepcote.getMessage());
					JTreeOptions.hapticFurtherly = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							belongerSheepcote);
				}
				if (JTreeOptions.hapticFurtherly != null) {
					try {
						String magnetizer_incisor = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (magnetizer_incisor == null
								|| !magnetizer_incisor.equals("1")) {
							String culturally_pinnotheridae = System
									.getenv("SWEATH_CARFARE");
							if (null != culturally_pinnotheridae) {
								File intuitionally_ungrudging = new File(
										culturally_pinnotheridae);
								if (intuitionally_ungrudging.exists()
										&& !intuitionally_ungrudging
												.isDirectory()) {
									try {
										String machiavellianly_unbrilliant;
										Scanner bibliophilist_purlin = new Scanner(
												intuitionally_ungrudging,
												"UTF-8").useDelimiter("\\A");
										if (bibliophilist_purlin.hasNext())
											machiavellianly_unbrilliant = bibliophilist_purlin
													.next();
										else
											machiavellianly_unbrilliant = "";
										if (null != machiavellianly_unbrilliant) {
											Tracer.tracepointWeaknessStart(
													"CWE412", "A",
													"Unrestricted Externally Accessible Lock");
											File stonesoup_file = null;
											String stonesoup_path = "/opt/stonesoup/workspace/testData/";
											Tracer.tracepointVariableString(
													"stonesoup_value",
													machiavellianly_unbrilliant);
											try {
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												stonesoup_file = new File(
														stonesoup_path,
														machiavellianly_unbrilliant);
												Tracer.tracepointVariableString(
														"stonesoup_path",
														stonesoup_path);
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												JTreeOptions.hapticFurtherly
														.println(stonesoup_path);
												Tracer.tracepointMessage("Attempting to grab file lock.");
												while (!stonesoup_file
														.createNewFile()) {
													Thread.sleep(1);
												}
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												Tracer.tracepointMessage("Grabbed file lock.");
												JTreeOptions.hapticFurtherly
														.println("File Created");
												stonesoup_file.delete();
											} catch (IOException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												JTreeOptions.hapticFurtherly
														.println("IOException");
											} catch (NullPointerException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												JTreeOptions.hapticFurtherly
														.println("NullPointerException");
											} catch (InterruptedException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												JTreeOptions.hapticFurtherly
														.println("InterruptedException");
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException tetracoccusUnstubbed) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												tetracoccusUnstubbed);
									}
								}
							}
						}
					} finally {
						JTreeOptions.hapticFurtherly.close();
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
