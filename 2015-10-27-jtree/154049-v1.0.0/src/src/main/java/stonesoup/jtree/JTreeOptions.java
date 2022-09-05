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
import java.lang.Character;



public class JTreeOptions {

	static PrintStream recriminativeUndefectiveness = null;
	private static final java.util.concurrent.atomic.AtomicBoolean paracarmineParanuclein = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (paracarmineParanuclein.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpsVgIGP_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File demipiqueThundershower = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!demipiqueThundershower.getParentFile().exists()
					&& !demipiqueThundershower.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.recriminativeUndefectiveness = new PrintStream(
							new FileOutputStream(demipiqueThundershower, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException ludditismUneconomizing) {
					System.err.printf("Failed to open log file.  %s\n",
							ludditismUneconomizing.getMessage());
					JTreeOptions.recriminativeUndefectiveness = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							ludditismUneconomizing);
				} catch (FileNotFoundException responsiveUndispose) {
					System.err.printf("Failed to open log file.  %s\n",
							responsiveUndispose.getMessage());
					JTreeOptions.recriminativeUndefectiveness = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							responsiveUndispose);
				}
				if (JTreeOptions.recriminativeUndefectiveness != null) {
					try {
						String symbolaeography_maculated = System
								.getenv("NEWLANDITE_INTEMERATELY");
						if (null != symbolaeography_maculated) {
							Tracer.tracepointWeaknessStart("CWE248", "A",
									"Uncaught Exception");
							final String stonesoup_input_for_print = symbolaeography_maculated;
							Tracer.tracepointVariableString("value",
									symbolaeography_maculated);
							Thread.UncaughtExceptionHandler stonesoup_ueh = Thread
									.getDefaultUncaughtExceptionHandler();
							Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
								public void uncaughtException(Thread t,
										Throwable e) {
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
							char[] stonesoup_characters = symbolaeography_maculated
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
							JTreeOptions.recriminativeUndefectiveness
									.println(String
											.valueOf(stonesoup_characters));
							Thread.setDefaultUncaughtExceptionHandler(stonesoup_ueh);
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.recriminativeUndefectiveness.close();
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
