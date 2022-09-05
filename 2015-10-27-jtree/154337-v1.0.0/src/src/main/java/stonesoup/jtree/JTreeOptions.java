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

	static PrintStream iodationBispinous = null;
	private static final java.util.concurrent.atomic.AtomicBoolean esoneuralPalpitatingly = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (esoneuralPalpitatingly.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpDSlLC8_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File basketworkPaunch = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!basketworkPaunch.getParentFile().exists()
					&& !basketworkPaunch.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.iodationBispinous = new PrintStream(
							new FileOutputStream(basketworkPaunch, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException qualmyishStichic) {
					System.err.printf("Failed to open log file.  %s\n",
							qualmyishStichic.getMessage());
					JTreeOptions.iodationBispinous = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							qualmyishStichic);
				} catch (FileNotFoundException psychomanticBipont) {
					System.err.printf("Failed to open log file.  %s\n",
							psychomanticBipont.getMessage());
					JTreeOptions.iodationBispinous = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							psychomanticBipont);
				}
				if (JTreeOptions.iodationBispinous != null) {
					try {
						String plotinical_ornithomantic = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (plotinical_ornithomantic == null
								|| !plotinical_ornithomantic.equals("1")) {
							String ludwig_tetrachloro = System
									.getenv("FITCH_BUSHONGO");
							if (null != ludwig_tetrachloro) {
								File clothbound_bureaux = new File(
										ludwig_tetrachloro);
								if (clothbound_bureaux.exists()
										&& !clothbound_bureaux.isDirectory()) {
									try {
										String libate_templar;
										Scanner minuetish_ancylus = new Scanner(
												clothbound_bureaux, "UTF-8")
												.useDelimiter("\\A");
										if (minuetish_ancylus.hasNext())
											libate_templar = minuetish_ancylus
													.next();
										else
											libate_templar = "";
										if (null != libate_templar) {
											int paca_dichromat;
											try {
												paca_dichromat = Integer
														.parseInt(libate_templar);
											} catch (NumberFormatException frontoparietal_cneoraceae) {
												throw new RuntimeException(
														"STONESOUP: Failed to convert source taint.",
														frontoparietal_cneoraceae);
											}
											Tracer.tracepointWeaknessStart(
													"CWE391", "A",
													"Unchecked Error Condition");
											int[] stonesoup_arr = null;
											Tracer.tracepointVariableInt(
													"size", paca_dichromat);
											Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
											try {
												JTreeOptions.iodationBispinous
														.printf("Allocating array of size %d\n",
																paca_dichromat);
												stonesoup_arr = new int[paca_dichromat];
											} catch (OutOfMemoryError e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
											}
											Tracer.tracepointBufferInfo(
													"stonesoup_arr",
													(stonesoup_arr == null) ? 0
															: stonesoup_arr.length,
													"Length of stonesoup_arr");
											Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
											try {
												Tracer.tracepointMessage("TRIGGER-PONIT: BEFORE");
												for (int i = 0; i < stonesoup_arr.length; i++) {
													stonesoup_arr[i] = paca_dichromat
															- i;
												}
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
											} catch (RuntimeException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												e.printStackTrace(JTreeOptions.iodationBispinous);
												throw e;
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException unscandalousSarwan) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												unscandalousSarwan);
									}
								}
							}
						}
					} finally {
						JTreeOptions.iodationBispinous.close();
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
