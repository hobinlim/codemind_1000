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

	static PrintStream curtsyDistrustfully = null;
	private static final java.util.concurrent.atomic.AtomicBoolean yaruraPlenty = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (yaruraPlenty.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpttqLWx_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File farerTracing = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!farerTracing.getParentFile().exists()
					&& !farerTracing.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.curtsyDistrustfully = new PrintStream(
							new FileOutputStream(farerTracing, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException cavieGummiferous) {
					System.err.printf("Failed to open log file.  %s\n",
							cavieGummiferous.getMessage());
					JTreeOptions.curtsyDistrustfully = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							cavieGummiferous);
				} catch (FileNotFoundException havingnessWrathfulness) {
					System.err.printf("Failed to open log file.  %s\n",
							havingnessWrathfulness.getMessage());
					JTreeOptions.curtsyDistrustfully = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							havingnessWrathfulness);
				}
				if (JTreeOptions.curtsyDistrustfully != null) {
					try {
						String polysemous_enanguish = System
								.getenv("HEMIDYSERGIA_CARDSHARPING");
						if (null != polysemous_enanguish) {
							Tracer.tracepointWeaknessStart("CWE253", "A",
									"Incorrect Check of Function Return Value");
							int location = polysemous_enanguish.indexOf('.');
							Tracer.tracepointVariableString(
									"stonesoup_tainted_buff",
									polysemous_enanguish);
							Tracer.tracepointVariableInt("location", location);
							Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
							if (location != 0) {
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								String substring;
								try {
									Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
									substring = polysemous_enanguish
											.substring(location);
									Tracer.tracepointVariableString(
											"substring", substring);
									Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
								} catch (RuntimeException e) {
									Tracer.tracepointError(e.getClass()
											.getName() + ": " + e.getMessage());
									e.printStackTrace(JTreeOptions.curtsyDistrustfully);
									throw e;
								}
								JTreeOptions.curtsyDistrustfully
										.println("Substring beginning with '.' is \""
												+ substring + "\"\n");
							} else {
								Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
								JTreeOptions.curtsyDistrustfully
										.println("'.' appears at start of line\n");
							}
							Tracer.tracepointWeaknessEnd();
						}
					} finally {
						JTreeOptions.curtsyDistrustfully.close();
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
