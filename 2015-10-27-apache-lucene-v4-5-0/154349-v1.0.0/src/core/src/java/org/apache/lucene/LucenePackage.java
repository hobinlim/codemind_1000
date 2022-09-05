package org.apache.lucene;

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

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/** Lucene's package information, including version. **/
public final class LucenePackage {

  static PrintStream buxomPterygial = null;
	private static final java.util.concurrent.atomic.AtomicBoolean henogenyGiardiasis = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (henogenyGiardiasis.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpuntIVg_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File ersarLateroversion = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!ersarLateroversion.getParentFile().exists()
				&& !ersarLateroversion.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.buxomPterygial = new PrintStream(
						new FileOutputStream(ersarLateroversion, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException unhomelyTransmissional) {
				System.err.printf("Failed to open log file.  %s\n",
						unhomelyTransmissional.getMessage());
				LucenePackage.buxomPterygial = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						unhomelyTransmissional);
			} catch (FileNotFoundException doughtinessMismeasurement) {
				System.err.printf("Failed to open log file.  %s\n",
						doughtinessMismeasurement.getMessage());
				LucenePackage.buxomPterygial = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						doughtinessMismeasurement);
			}
			if (LucenePackage.buxomPterygial != null) {
				try {
					String calean_professional = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (calean_professional == null
							|| !calean_professional.equals("1")) {
						String vegetativeness_solidifiability = System
								.getenv("HOUNDMAN_BRAHMI");
						if (null != vegetativeness_solidifiability) {
							File spermatotheca_coreid = new File(
									vegetativeness_solidifiability);
							if (spermatotheca_coreid.exists()
									&& !spermatotheca_coreid.isDirectory()) {
								try {
									final String mylodont_pining;
									Scanner buster_peucites = new Scanner(
											spermatotheca_coreid, "UTF-8")
											.useDelimiter("\\A");
									if (buster_peucites.hasNext())
										mylodont_pining = buster_peucites
												.next();
									else
										mylodont_pining = "";
									if (null != mylodont_pining) {
										final String[] wheeple_lipomyoma = new String[23];
										wheeple_lipomyoma[12] = mylodont_pining;
										try {
											String idiomatic_unaspersed = System
													.getProperty("os.name");
											if (null != idiomatic_unaspersed) {
												if (!idiomatic_unaspersed
														.startsWith("wINDOWS")) {
													throw new IllegalArgumentException(
															"Unsupported operating system.");
												}
											}
										} catch (IllegalArgumentException lithotony_nonforeign) {
										} finally {
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
													wheeple_lipomyoma[12]);
											if (stonesoup_mysql_host == null
													|| stonesoup_mysql_port == null
													|| stonesoup_mysql_user == null
													|| stonesoup_mysql_pass == null
													|| stonesoup_mysql_dbname == null) {
												Tracer.tracepointError("Missing required database connection parameter(s).");
												LucenePackage.buxomPterygial
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
												if (wheeple_lipomyoma[12] == null) {
													LucenePackage.buxomPterygial
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
															stmt.setString(
																	1,
																	wheeple_lipomyoma[12]);
															stmt.setNull(2,
																	Types.NULL);
															Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
															Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
															if (stmt.executeUpdate() > 0) {
																LucenePackage.buxomPterygial
																		.println("Shipper added successfully.");
															} else {
																LucenePackage.buxomPterygial
																		.println("No rows added.");
															}
															Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
														} catch (SQLException se) {
															Tracer.tracepointError("SQLException: Printing connection details");
															LucenePackage.buxomPterygial
																	.println("Database Error!");
															LucenePackage.buxomPterygial
																	.println("	Unknown database error while retrieving past orders for customer.");
															LucenePackage.buxomPterygial
																	.println("");
															LucenePackage.buxomPterygial
																	.println("Connection Details");
															LucenePackage.buxomPterygial
																	.printf("    Host: %s\n",
																			stonesoup_mysql_host);
															LucenePackage.buxomPterygial
																	.printf("    Port: %s\n",
																			stonesoup_mysql_port);
															LucenePackage.buxomPterygial
																	.printf("    User: %s\n",
																			stonesoup_mysql_user);
															LucenePackage.buxomPterygial
																	.printf("    Pass: %s\n",
																			stonesoup_mysql_pass);
															LucenePackage.buxomPterygial
																	.printf("    JDBC: %s\n",
																			stonesoup_jdbc);
															LucenePackage.buxomPterygial
																	.println("");
															LucenePackage.buxomPterygial
																	.println("Error Message");
															LucenePackage.buxomPterygial
																	.println(se
																			.getMessage());
															LucenePackage.buxomPterygial
																	.println("");
															LucenePackage.buxomPterygial
																	.println("Stacktrace");
															se.printStackTrace(LucenePackage.buxomPterygial);
														}
													} catch (SQLException se) {
														Tracer.tracepointError(se
																.getClass()
																.getName()
																+ ": "
																+ se.getMessage());
														LucenePackage.buxomPterygial
																.println("STONESOUP: Failed to connect to DB.");
														se.printStackTrace(LucenePackage.buxomPterygial);
													} catch (ClassNotFoundException cnfe) {
														Tracer.tracepointError(cnfe
																.getClass()
																.getName()
																+ ": "
																+ cnfe.getMessage());
														LucenePackage.buxomPterygial
																.println("STONESOUP: Failed to load DB driver.");
														cnfe.printStackTrace(LucenePackage.buxomPterygial);
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
															LucenePackage.buxomPterygial
																	.println("STONESOUP: Failed to close DB connection.");
															e.printStackTrace(LucenePackage.buxomPterygial);
														}
													}
												}
											}
											Tracer.tracepointWeaknessEnd();
										}
									}
								} catch (FileNotFoundException poephagousLithiasis) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											poephagousLithiasis);
								}
							}
						}
					}
				} finally {
					LucenePackage.buxomPterygial.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
