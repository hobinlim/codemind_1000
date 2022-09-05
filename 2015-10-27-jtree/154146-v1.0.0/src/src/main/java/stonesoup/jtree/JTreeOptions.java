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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;



public class JTreeOptions {

	static PrintStream helicinidaeMegazoospore = null;
	private static final java.util.concurrent.atomic.AtomicBoolean peteAntiepiscopist = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (peteAntiepiscopist.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpF1YA0P_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File ephemeridaeTape = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!ephemeridaeTape.getParentFile().exists()
					&& !ephemeridaeTape.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.helicinidaeMegazoospore = new PrintStream(
							new FileOutputStream(ephemeridaeTape, false), true,
							"ISO-8859-1");
				} catch (UnsupportedEncodingException mistressdomRepeople) {
					System.err.printf("Failed to open log file.  %s\n",
							mistressdomRepeople.getMessage());
					JTreeOptions.helicinidaeMegazoospore = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							mistressdomRepeople);
				} catch (FileNotFoundException mauveineOtoblennorrhea) {
					System.err.printf("Failed to open log file.  %s\n",
							mauveineOtoblennorrhea.getMessage());
					JTreeOptions.helicinidaeMegazoospore = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							mauveineOtoblennorrhea);
				}
				if (JTreeOptions.helicinidaeMegazoospore != null) {
					try {
						String pamela_trilobated = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (pamela_trilobated == null
								|| !pamela_trilobated.equals("1")) {
							String telethermogram_reblade = System
									.getenv("NOCKET_NEURONISM");
							if (null != telethermogram_reblade) {
								File anagrammatist_nonconclusion = new File(
										telethermogram_reblade);
								if (anagrammatist_nonconclusion.exists()
										&& !anagrammatist_nonconclusion
												.isDirectory()) {
									try {
										String semideity_provability;
										Scanner pikel_habituation = new Scanner(
												anagrammatist_nonconclusion,
												"UTF-8").useDelimiter("\\A");
										if (pikel_habituation.hasNext())
											semideity_provability = pikel_habituation
													.next();
										else
											semideity_provability = "";
										if (null != semideity_provability) {
											Tracer.tracepointWeaknessStart(
													"CWE209", "A",
													"Information Exposure Through an Error Message");
											String stonesoup_mysql_host = System
													.getenv("DBMYSQLHOST");
											String stonesoup_mysql_port = System
													.getenv("DBMYSQLPORT");
											String stonesoup_mysql_user = System
													.getenv("DBMYSQLUSER");
											String stonesoup_mysql_pass = System
													.getenv("DBMYSQLPASSWORD");
											String stonesoup_mysql_dbname = System
													.getenv("SS_DBMYSQLDATABASE");
											Tracer.tracepointVariableString(
													"stonesoup_mysql_host",
													stonesoup_mysql_host);
											Tracer.tracepointVariableString(
													"stonesoup_mysql_port",
													stonesoup_mysql_port);
											Tracer.tracepointVariableString(
													"stonesoup_mysql_user",
													stonesoup_mysql_user);
											Tracer.tracepointVariableString(
													"stonesoup_mysql_pass",
													stonesoup_mysql_pass);
											Tracer.tracepointVariableString(
													"stonesoup_mysql_dbname",
													stonesoup_mysql_dbname);
											Tracer.tracepointVariableString(
													"companyName",
													semideity_provability);
											if (stonesoup_mysql_host == null
													|| stonesoup_mysql_port == null
													|| stonesoup_mysql_user == null
													|| stonesoup_mysql_pass == null
													|| stonesoup_mysql_dbname == null) {
												Tracer.tracepointError("Missing required database connection parameter(s).");
												JTreeOptions.helicinidaeMegazoospore
														.println("STONESOUP: Missing required DB connection parameters.");
											} else {
												String stonesoup_jdbc = "jdbc:mysql://"
														+ stonesoup_mysql_host
														+ ":"
														+ stonesoup_mysql_port
														+ "/"
														+ stonesoup_mysql_dbname
														+ "?dumpQueriesOnException=true";
												Tracer.tracepointVariableString(
														"stonesoup_jdbc",
														stonesoup_jdbc);
												if (semideity_provability == null) {
													JTreeOptions.helicinidaeMegazoospore
															.println("No company name provided.");
												} else {
													Connection con = null;
													try {
														Class.forName("com.mysql.jdbc.Driver");
														con = DriverManager
																.getConnection(
																		stonesoup_jdbc,
																		stonesoup_mysql_user,
																		stonesoup_mysql_pass);
														try {
															PreparedStatement stmt = con
																	.prepareStatement("INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?)");
															Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
															stmt.setString(1,
																	semideity_provability);
															stmt.setNull(2,
																	Types.NULL);
															Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
															Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
															if (stmt.executeUpdate() > 0) {
																JTreeOptions.helicinidaeMegazoospore
																		.println("Shipper added successfully.");
															} else {
																JTreeOptions.helicinidaeMegazoospore
																		.println("No rows added.");
															}
															Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
														} catch (SQLException se) {
															Tracer.tracepointError("SQLException: Printing connection details");
															JTreeOptions.helicinidaeMegazoospore
																	.println("Database Error!");
															JTreeOptions.helicinidaeMegazoospore
																	.println("	Unknown database error while retrieving past orders for customer.");
															JTreeOptions.helicinidaeMegazoospore
																	.println("");
															JTreeOptions.helicinidaeMegazoospore
																	.println("Connection Details");
															JTreeOptions.helicinidaeMegazoospore
																	.printf("    Host: %s\n",
																			stonesoup_mysql_host);
															JTreeOptions.helicinidaeMegazoospore
																	.printf("    Port: %s\n",
																			stonesoup_mysql_port);
															JTreeOptions.helicinidaeMegazoospore
																	.printf("    User: %s\n",
																			stonesoup_mysql_user);
															JTreeOptions.helicinidaeMegazoospore
																	.printf("    Pass: %s\n",
																			stonesoup_mysql_pass);
															JTreeOptions.helicinidaeMegazoospore
																	.printf("    JDBC: %s\n",
																			stonesoup_jdbc);
															JTreeOptions.helicinidaeMegazoospore
																	.println("");
															JTreeOptions.helicinidaeMegazoospore
																	.println("Error Message");
															JTreeOptions.helicinidaeMegazoospore
																	.println(se
																			.getMessage());
															JTreeOptions.helicinidaeMegazoospore
																	.println("");
															JTreeOptions.helicinidaeMegazoospore
																	.println("Stacktrace");
															se.printStackTrace(JTreeOptions.helicinidaeMegazoospore);
														}
													} catch (SQLException se) {
														Tracer.tracepointError(se
																.getClass()
																.getName()
																+ ": "
																+ se.getMessage());
														JTreeOptions.helicinidaeMegazoospore
																.println("STONESOUP: Failed to connect to DB.");
														se.printStackTrace(JTreeOptions.helicinidaeMegazoospore);
													} catch (ClassNotFoundException cnfe) {
														Tracer.tracepointError(cnfe
																.getClass()
																.getName()
																+ ": "
																+ cnfe.getMessage());
														JTreeOptions.helicinidaeMegazoospore
																.println("STONESOUP: Failed to load DB driver.");
														cnfe.printStackTrace(JTreeOptions.helicinidaeMegazoospore);
													} finally {
														try {
															if (con != null
																	&& !con.isClosed()) {
																con.close();
															}
														} catch (SQLException e) {
															Tracer.tracepointError(e
																	.getClass()
																	.getName()
																	+ ": "
																	+ e.getMessage());
															JTreeOptions.helicinidaeMegazoospore
																	.println("STONESOUP: Failed to close DB connection.");
															e.printStackTrace(JTreeOptions.helicinidaeMegazoospore);
														}
													}
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									} catch (FileNotFoundException uncloudedPostcentrum) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												uncloudedPostcentrum);
									}
								}
							}
						}
					} finally {
						JTreeOptions.helicinidaeMegazoospore.close();
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
