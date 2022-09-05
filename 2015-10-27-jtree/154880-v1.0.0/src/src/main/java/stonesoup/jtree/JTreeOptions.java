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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class JTreeOptions {

	static PrintStream phalangiidPhonometry = null;
	private static final java.util.concurrent.atomic.AtomicBoolean flaglikeDistally = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (flaglikeDistally.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpUo2UOS_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File tonsuratePol = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!tonsuratePol.getParentFile().exists()
					&& !tonsuratePol.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.phalangiidPhonometry = new PrintStream(
							new FileOutputStream(tonsuratePol, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException bridalRedeemableness) {
					System.err.printf("Failed to open log file.  %s\n",
							bridalRedeemableness.getMessage());
					JTreeOptions.phalangiidPhonometry = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							bridalRedeemableness);
				} catch (FileNotFoundException stevedoreEthnologist) {
					System.err.printf("Failed to open log file.  %s\n",
							stevedoreEthnologist.getMessage());
					JTreeOptions.phalangiidPhonometry = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							stevedoreEthnologist);
				}
				if (JTreeOptions.phalangiidPhonometry != null) {
					try {
						String outbirth_multiradiate = System
								.getenv("PILOCARPUS_PROSTEMMATE");
						if (null != outbirth_multiradiate) {
							Tracer.tracepointWeaknessStart("CWE363", "A",
									"Race Condition Enabling Link Following");
							String stonesoup_syncfile = null;
							String stonesoup_fileName = null;
							String stonesoup_substrings[] = outbirth_multiradiate
									.split("\\s+", 2);
							if (stonesoup_substrings.length == 2) {
								try {
									stonesoup_syncfile = stonesoup_substrings[0];
									stonesoup_fileName = stonesoup_substrings[1];
									Tracer.tracepointVariableString(
											"stonesoup_value",
											outbirth_multiradiate);
									Tracer.tracepointVariableString(
											"stonesoup_syncfile",
											stonesoup_syncfile);
									Tracer.tracepointVariableString(
											"stonesoup_fileNmae",
											stonesoup_fileName);
								} catch (NumberFormatException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									JTreeOptions.phalangiidPhonometry
											.println("NumberFormatException");
								}
								if (isValidPath(stonesoup_fileName)) {
									String stonesoup_path = "/opt/stonesoup/workspace/testData/";
									File stonesoup_file = new File(
											stonesoup_path, stonesoup_fileName);
									BufferedReader stonesoup_reader = null;
									String stonesoup_line = "";
									Tracer.tracepointVariableString(
											"stonesoup_file",
											stonesoup_file.getAbsolutePath());
									if (stonesoup_file.exists()) {
										try {
											if (!isSymlink(stonesoup_file)) {
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												waitForChange(
														stonesoup_path,
														stonesoup_fileName,
														stonesoup_syncfile,
														JTreeOptions.phalangiidPhonometry);
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												stonesoup_reader = new BufferedReader(
														new FileReader(
																stonesoup_file
																		.getAbsolutePath()));
												while ((stonesoup_line = stonesoup_reader
														.readLine()) != null) {
													JTreeOptions.phalangiidPhonometry
															.println(stonesoup_line);
												}
												stonesoup_reader.close();
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
											} else {
												Tracer.tracepointError("ERROR: File is a symlink!");
												JTreeOptions.phalangiidPhonometry
														.println("ERROR: File is a symlink!");
											}
										} catch (IOException e) {
											Tracer.tracepointError("ERROR: File got deleted.");
											JTreeOptions.phalangiidPhonometry
													.println("ERROR: File got deleted.");
										}
									} else {
										Tracer.tracepointError("ERROR: File doesn't exist!");
										JTreeOptions.phalangiidPhonometry
												.println("ERROR: File doesn't exist!");
									}
								} else {
									Tracer.tracepointError("ERROR: Filename isn't valid!");
									JTreeOptions.phalangiidPhonometry
											.println("ERROR: Filename isn't valid!");
								}
							} else {
								Tracer.tracepointError("ERROR: Input isn't valid!");
								JTreeOptions.phalangiidPhonometry
										.println("ERROR: Input isn't valid!");
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.phalangiidPhonometry.close();
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

	public static void readFile(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpUo2UOS_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"readFile");
		String str;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while ((str = reader.readLine()) != null) {
				output.println(str);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			Tracer.tracepointError("Error reading syncFile.  "
					+ e.getClass().getName() + ": " + e.getMessage());
			output.println("Error reading sync file: " + e);
		} catch (IOException e) {
			Tracer.tracepointError("Error reading syncFile.  "
					+ e.getClass().getName() + ": " + e.getMessage());
			output.println("Error reading sync file: " + e);
		}
	}

	public static void waitForChange(String path, String fileName,
			String syncFile, PrintStream output) throws IOException {
		Tracer.tracepointLocation(
				"/tmp/tmpUo2UOS_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"waitForChange");
		PrintWriter writer = new PrintWriter(path + fileName + ".pid");
		writer.close();
		Tracer.tracepointVariableString(".pid file", path + fileName + ".pid");
		Tracer.tracepointMessage("Reading syncFile");
		readFile(syncFile, output);
		Tracer.tracepointMessage("Finished reading syncFile");
	}

	public static boolean isValidPath(String file) {
		Tracer.tracepointLocation(
				"/tmp/tmpUo2UOS_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"isValidPath");
		return !file.contains("/");
	}

	public static boolean isSymlink(File file) throws IOException {
		Tracer.tracepointLocation(
				"/tmp/tmpUo2UOS_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"isSymlink");
		return !file.getCanonicalFile().equals(file.getAbsoluteFile());
	}

}
