package org.apache.lucene;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
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

  private static final int contravariant_sabertooth = 17;
	static PrintStream plateryAtimon = null;
	private static final java.util.concurrent.atomic.AtomicBoolean unbarbedSupersecure = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (unbarbedSupersecure.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmp9pBeB2_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File drosserSpogel = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!drosserSpogel.getParentFile().exists()
				&& !drosserSpogel.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.plateryAtimon = new PrintStream(
						new FileOutputStream(drosserSpogel, false), true,
						"ISO-8859-1");
			} catch (UnsupportedEncodingException aleyrodidPew) {
				System.err.printf("Failed to open log file.  %s\n",
						aleyrodidPew.getMessage());
				LucenePackage.plateryAtimon = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.", aleyrodidPew);
			} catch (FileNotFoundException catalepsyFluorination) {
				System.err.printf("Failed to open log file.  %s\n",
						catalepsyFluorination.getMessage());
				LucenePackage.plateryAtimon = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						catalepsyFluorination);
			}
			if (LucenePackage.plateryAtimon != null) {
				try {
					String enunciatory_egyptianization = System
							.getenv("DORSOVENTRAD_FLORIGRAPHY");
					if (null != enunciatory_egyptianization) {
						String[] artlessly_unresumptive = new String[31];
						artlessly_unresumptive[contravariant_sabertooth] = enunciatory_egyptianization;
						Tracer.tracepointWeaknessStart("CWE209", "A",
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
						Tracer.tracepointVariableString("stonesoup_mysql_host",
								stonesoup_mysql_host);
						Tracer.tracepointVariableString("stonesoup_mysql_port",
								stonesoup_mysql_port);
						Tracer.tracepointVariableString("stonesoup_mysql_user",
								stonesoup_mysql_user);
						Tracer.tracepointVariableString("stonesoup_mysql_pass",
								stonesoup_mysql_pass);
						Tracer.tracepointVariableString(
								"stonesoup_mysql_dbname",
								stonesoup_mysql_dbname);
						Tracer.tracepointVariableString(
								"companyName",
								artlessly_unresumptive[contravariant_sabertooth]);
						if (stonesoup_mysql_host == null
								|| stonesoup_mysql_port == null
								|| stonesoup_mysql_user == null
								|| stonesoup_mysql_pass == null
								|| stonesoup_mysql_dbname == null) {
							Tracer.tracepointError("Missing required database connection parameter(s).");
							LucenePackage.plateryAtimon
									.println("STONESOUP: Missing required DB connection parameters.");
						} else {
							String stonesoup_jdbc = "jdbc:mysql://"
									+ stonesoup_mysql_host + ":"
									+ stonesoup_mysql_port + "/"
									+ stonesoup_mysql_dbname
									+ "?dumpQueriesOnException=true";
							Tracer.tracepointVariableString("stonesoup_jdbc",
									stonesoup_jdbc);
							if (artlessly_unresumptive[contravariant_sabertooth] == null) {
								LucenePackage.plateryAtimon
										.println("No company name provided.");
							} else {
								Connection con = null;
								try {
									Class.forName("com.mysql.jdbc.Driver");
									con = DriverManager.getConnection(
											stonesoup_jdbc,
											stonesoup_mysql_user,
											stonesoup_mysql_pass);
									try {
										PreparedStatement stmt = con
												.prepareStatement("INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?)");
										Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
										stmt.setString(
												1,
												artlessly_unresumptive[contravariant_sabertooth]);
										stmt.setNull(2, Types.NULL);
										Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
										Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
										if (stmt.executeUpdate() > 0) {
											LucenePackage.plateryAtimon
													.println("Shipper added successfully.");
										} else {
											LucenePackage.plateryAtimon
													.println("No rows added.");
										}
										Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
									} catch (SQLException se) {
										Tracer.tracepointError("SQLException: Printing connection details");
										LucenePackage.plateryAtimon
												.println("Database Error!");
										LucenePackage.plateryAtimon
												.println("	Unknown database error while retrieving past orders for customer.");
										LucenePackage.plateryAtimon.println("");
										LucenePackage.plateryAtimon
												.println("Connection Details");
										LucenePackage.plateryAtimon.printf(
												"    Host: %s\n",
												stonesoup_mysql_host);
										LucenePackage.plateryAtimon.printf(
												"    Port: %s\n",
												stonesoup_mysql_port);
										LucenePackage.plateryAtimon.printf(
												"    User: %s\n",
												stonesoup_mysql_user);
										LucenePackage.plateryAtimon.printf(
												"    Pass: %s\n",
												stonesoup_mysql_pass);
										LucenePackage.plateryAtimon.printf(
												"    JDBC: %s\n",
												stonesoup_jdbc);
										LucenePackage.plateryAtimon.println("");
										LucenePackage.plateryAtimon
												.println("Error Message");
										LucenePackage.plateryAtimon.println(se
												.getMessage());
										LucenePackage.plateryAtimon.println("");
										LucenePackage.plateryAtimon
												.println("Stacktrace");
										se.printStackTrace(LucenePackage.plateryAtimon);
									}
								} catch (SQLException se) {
									Tracer.tracepointError(se.getClass()
											.getName() + ": " + se.getMessage());
									LucenePackage.plateryAtimon
											.println("STONESOUP: Failed to connect to DB.");
									se.printStackTrace(LucenePackage.plateryAtimon);
								} catch (ClassNotFoundException cnfe) {
									Tracer.tracepointError(cnfe.getClass()
											.getName()
											+ ": "
											+ cnfe.getMessage());
									LucenePackage.plateryAtimon
											.println("STONESOUP: Failed to load DB driver.");
									cnfe.printStackTrace(LucenePackage.plateryAtimon);
								} finally {
									try {
										if (con != null && !con.isClosed()) {
											con.close();
										}
									} catch (SQLException e) {
										Tracer.tracepointError(e.getClass()
												.getName()
												+ ": "
												+ e.getMessage());
										LucenePackage.plateryAtimon
												.println("STONESOUP: Failed to close DB connection.");
										e.printStackTrace(LucenePackage.plateryAtimon);
									}
								}
							}
						}
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					LucenePackage.plateryAtimon.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }
}
