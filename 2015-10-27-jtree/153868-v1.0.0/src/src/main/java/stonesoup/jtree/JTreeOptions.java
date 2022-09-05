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



public class JTreeOptions {

	static PrintStream unrecompensableUnmoor = null;
	private static final java.util.concurrent.atomic.AtomicBoolean poemetPrerestrict = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (poemetPrerestrict.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpevr95F_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File pneumaticallyFabella = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!pneumaticallyFabella.getParentFile().exists()
					&& !pneumaticallyFabella.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.unrecompensableUnmoor = new PrintStream(
							new FileOutputStream(pneumaticallyFabella, false),
							true, "ISO-8859-1");
				} catch (UnsupportedEncodingException shieldedLecideaceous) {
					System.err.printf("Failed to open log file.  %s\n",
							shieldedLecideaceous.getMessage());
					JTreeOptions.unrecompensableUnmoor = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							shieldedLecideaceous);
				} catch (FileNotFoundException brachyrrhiniaBusheler) {
					System.err.printf("Failed to open log file.  %s\n",
							brachyrrhiniaBusheler.getMessage());
					JTreeOptions.unrecompensableUnmoor = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							brachyrrhiniaBusheler);
				}
				if (JTreeOptions.unrecompensableUnmoor != null) {
					try {
						String superdifficult_amoskeag = System
								.getenv("EGGBERRY_VOYANCE");
						if (null != superdifficult_amoskeag) {
							Tracer.tracepointWeaknessStart("CWE252", "A",
									"Unchecked Return Value");
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							String capitalized_value = stonesoup_to_upper(superdifficult_amoskeag);
							Tracer.tracepointVariableString(
									"capitalized_value", capitalized_value);
							Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
							String password = "STONESOUP";
							try {
								Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
								if (password.compareTo(capitalized_value) == 0) {
									JTreeOptions.unrecompensableUnmoor
											.println("passwords match");
								} else {
									JTreeOptions.unrecompensableUnmoor
											.println("passwords don't match");
								}
								Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
							} catch (NullPointerException e) {
								Tracer.tracepointError(e.getClass().getName()
										+ ": " + e.getMessage());
								e.printStackTrace(JTreeOptions.unrecompensableUnmoor);
								throw e;
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.unrecompensableUnmoor.close();
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

	public static String stonesoup_to_upper(final String input) {
		Tracer.tracepointLocation(
				"/tmp/tmpevr95F_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
				"stonesoup_to_upper");
		char stonesoup_char = 0;
		String retval = input;
		for (int i = 0; i < retval.length(); i++) {
			stonesoup_char = retval.charAt(i);
			if (Character.isLowerCase(stonesoup_char)) {
				retval = retval.replace(stonesoup_char,
						Character.toUpperCase(stonesoup_char));
			} else if (!Character.isUpperCase(stonesoup_char)) {
				return null;
			}
		}
		return retval;
	}

}
