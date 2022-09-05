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
import java.lang.Character;



public class JTreeOptions {

	static PrintStream aquiculturalVolumenometry = null;
	private static final java.util.concurrent.atomic.AtomicBoolean verminerDecarch = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (verminerDecarch.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpEKp32G_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File potamochoerusRelationship = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!potamochoerusRelationship.getParentFile().exists()
					&& !potamochoerusRelationship.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.aquiculturalVolumenometry = new PrintStream(
							new FileOutputStream(potamochoerusRelationship,
									false), true, "ISO-8859-1");
				} catch (UnsupportedEncodingException vengefulnessConfessional) {
					System.err.printf("Failed to open log file.  %s\n",
							vengefulnessConfessional.getMessage());
					JTreeOptions.aquiculturalVolumenometry = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							vengefulnessConfessional);
				} catch (FileNotFoundException annalismSiphonophora) {
					System.err.printf("Failed to open log file.  %s\n",
							annalismSiphonophora.getMessage());
					JTreeOptions.aquiculturalVolumenometry = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							annalismSiphonophora);
				}
				if (JTreeOptions.aquiculturalVolumenometry != null) {
					try {
						String dizzard_wassailer = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (dizzard_wassailer == null
								|| !dizzard_wassailer.equals("1")) {
							String maxwell_niyoga = System
									.getenv("UXORIOUSLY_SEMIREBELLION");
							if (null != maxwell_niyoga) {
								File whitefoot_sympatry = new File(
										maxwell_niyoga);
								if (whitefoot_sympatry.exists()
										&& !whitefoot_sympatry.isDirectory()) {
									try {
										String temperamental_miswed;
										Scanner punnage_titulus = new Scanner(
												whitefoot_sympatry, "UTF-8")
												.useDelimiter("\\A");
										if (punnage_titulus.hasNext())
											temperamental_miswed = punnage_titulus
													.next();
										else
											temperamental_miswed = "";
										if (null != temperamental_miswed) {
											Tracer.tracepointWeaknessStart(
													"CWE248", "A",
													"Uncaught Exception");
											final String stonesoup_input_for_print = temperamental_miswed;
											Tracer.tracepointVariableString(
													"value",
													temperamental_miswed);
											Thread.UncaughtExceptionHandler stonesoup_ueh = Thread
													.getDefaultUncaughtExceptionHandler();
											Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
												public void uncaughtException(
														Thread t, Throwable e) {
													Tracer.tracepointLocation(
															"STONESOUP_INJECTED_FILE",
															"uncaughtException");
													Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
													Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
													System.err
															.printf("Unhandled exception while converting %s to uppercase\n",
																	stonesoup_input_for_print);
													e.printStackTrace(System.err);
													Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												}
											});
											char[] stonesoup_characters = temperamental_miswed
													.toCharArray();
											for (int i = 0; i < stonesoup_characters.length; i++) {
												if (Character
														.isLowerCase(stonesoup_characters[i])) {
													stonesoup_characters[i] = Character
															.toUpperCase(stonesoup_characters[i]);
												} else if (!Character
														.isUpperCase(stonesoup_characters[i])) {
													Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
													throw new java.lang.IllegalArgumentException(
															"Not a valid character");
												}
											}
											Tracer.tracepointVariableString(
													"stonesoup_characters",
													String.valueOf(stonesoup_characters));
											JTreeOptions.aquiculturalVolumenometry
													.println(String
															.valueOf(stonesoup_characters));
											Thread.setDefaultUncaughtExceptionHandler(stonesoup_ueh);
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException interlibraryPointing) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												interlibraryPointing);
									}
								}
							}
						}
					} finally {
						JTreeOptions.aquiculturalVolumenometry.close();
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
