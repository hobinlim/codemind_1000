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

	static PrintStream pilgrimlikeMacrosporophyl = null;
	private static final java.util.concurrent.atomic.AtomicBoolean needleproofBotocudo = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (needleproofBotocudo.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpgtx9vt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File unslungCystoneuralgia = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!unslungCystoneuralgia.getParentFile().exists()
					&& !unslungCystoneuralgia.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.pilgrimlikeMacrosporophyl = new PrintStream(
							new FileOutputStream(unslungCystoneuralgia, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException brigittineBiflorous) {
					System.err.printf("Failed to open log file.  %s\n",
							brigittineBiflorous.getMessage());
					JTreeOptions.pilgrimlikeMacrosporophyl = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							brigittineBiflorous);
				} catch (FileNotFoundException praefectInsteam) {
					System.err.printf("Failed to open log file.  %s\n",
							praefectInsteam.getMessage());
					JTreeOptions.pilgrimlikeMacrosporophyl = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							praefectInsteam);
				}
				if (JTreeOptions.pilgrimlikeMacrosporophyl != null) {
					try {
						String goslarite_situs = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (goslarite_situs == null
								|| !goslarite_situs.equals("1")) {
							String intracity_tarsalgia = System
									.getenv("EXTRUDING_TICKSEED");
							if (null != intracity_tarsalgia) {
								File hemiepilepsy_insectivora = new File(
										intracity_tarsalgia);
								if (hemiepilepsy_insectivora.exists()
										&& !hemiepilepsy_insectivora
												.isDirectory()) {
									try {
										String ooglea_dictyograptus;
										Scanner geck_xylitol = new Scanner(
												hemiepilepsy_insectivora,
												"UTF-8").useDelimiter("\\A");
										if (geck_xylitol.hasNext())
											ooglea_dictyograptus = geck_xylitol
													.next();
										else
											ooglea_dictyograptus = "";
										if (null != ooglea_dictyograptus) {
											Tracer.tracepointWeaknessStart(
													"CWE584", "A",
													"Return Inside Finally");
											File file;
											Scanner freader;
											String absPath = null;
											GetAbsolutePath getpath = new GetAbsolutePath(
													ooglea_dictyograptus,
													JTreeOptions.pilgrimlikeMacrosporophyl);
											boolean validPath = false;
											Tracer.tracepointVariableString(
													"taintedValue",
													ooglea_dictyograptus);
											try {
												absPath = getpath
														.getAbsolutePath();
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												validPath = true;
												Tracer.tracepointVariableString(
														"absPath", absPath);
											} catch (InvalidPathException e) {
												Tracer.tracepointError(e
														.getClass().getName()
														+ ": " + e.getMessage());
												JTreeOptions.pilgrimlikeMacrosporophyl
														.println("STONESOUP: Absolute path to file was not found.");
											}
											if (validPath) {
												try {
													Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
													file = new File(absPath);
													freader = new Scanner(file);
													while (freader
															.hasNextLine()) {
														JTreeOptions.pilgrimlikeMacrosporophyl
																.println(freader
																		.nextLine());
													}
													Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
												} catch (NullPointerException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													e.printStackTrace(JTreeOptions.pilgrimlikeMacrosporophyl);
													throw e;
												} catch (FileNotFoundException e) {
													Tracer.tracepointError(e
															.getClass()
															.getName()
															+ ": "
															+ e.getMessage());
													JTreeOptions.pilgrimlikeMacrosporophyl
															.println("STONESOUP: File not found.");
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException ultrafastidiousShoa) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												ultrafastidiousShoa);
									}
								}
							}
						}
					} finally {
						JTreeOptions.pilgrimlikeMacrosporophyl.close();
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

	static class InvalidPathException extends Exception {
		private static final long serialVersionUID = 1L;

		public InvalidPathException(String msg) {
			super(msg);
		}
	}

	static class GetAbsolutePath {
		private String fileName;
		private PrintStream output;

		public GetAbsolutePath(String fileName, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpgtx9vt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"GetAbsolutePath.ctor");
			this.fileName = fileName;
			this.output = output;
		}

		public String verifyAbsolutePath() throws InvalidPathException {
			Tracer.tracepointLocation(
					"/tmp/tmpgtx9vt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"GetAbsolutePath.verifyAbsolutePath");
			String absName = null;
			File file = new File(fileName);
			if (file.exists()) {
				absName = file.getAbsolutePath();
			} else {
				throw (new InvalidPathException("No such file: " + fileName));
			}
			return absName;
		}

		@SuppressWarnings("finally")
		public String getAbsolutePath() throws InvalidPathException {
			Tracer.tracepointLocation(
					"/tmp/tmpgtx9vt_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"GetAbsolutePath.getAbsolutePath");
			String absName = null;
			try {
				absName = this.verifyAbsolutePath();
			} catch (InvalidPathException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				output.println("STONESOUP: Error in verifying absolute path\n");
				throw e;
			} finally {
				Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
				return absName;
			}
		}
	}

}
