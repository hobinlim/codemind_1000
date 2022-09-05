// This file has been automatically generated, DO NOT EDIT

package org.apache.lucene.util.packed;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;
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

/**
 * Efficient sequential read/write of packed integers.
 */
final class BulkOperationPacked2 extends BulkOperationPacked {

  static PrintStream estampedeVenialness = null;

	public void papooseUnsecularized(int cloisterliness_nonsystematic,
			final String radiohumeral_calalu) {
		if (cloisterliness_nonsystematic > 10) {
			papooseUnsecularized(cloisterliness_nonsystematic++,
					radiohumeral_calalu);
		}
		Tracer.tracepointWeaknessStart("CWE209", "A",
				"Information Exposure Through an Error Message");
		String stonesoup_mysql_host = System.getenv("DBMYSQLHOST");
		String stonesoup_mysql_port = System.getenv("DBMYSQLPORT");
		String stonesoup_mysql_user = System.getenv("DBMYSQLUSER");
		String stonesoup_mysql_pass = System.getenv("DBMYSQLPASSWORD");
		String stonesoup_mysql_dbname = System.getenv("SS_DBMYSQLDATABASE");
		Tracer.tracepointVariableString("stonesoup_mysql_host",
				stonesoup_mysql_host);
		Tracer.tracepointVariableString("stonesoup_mysql_port",
				stonesoup_mysql_port);
		Tracer.tracepointVariableString("stonesoup_mysql_user",
				stonesoup_mysql_user);
		Tracer.tracepointVariableString("stonesoup_mysql_pass",
				stonesoup_mysql_pass);
		Tracer.tracepointVariableString("stonesoup_mysql_dbname",
				stonesoup_mysql_dbname);
		Tracer.tracepointVariableString("companyName", radiohumeral_calalu);
		if (stonesoup_mysql_host == null || stonesoup_mysql_port == null
				|| stonesoup_mysql_user == null || stonesoup_mysql_pass == null
				|| stonesoup_mysql_dbname == null) {
			Tracer.tracepointError("Missing required database connection parameter(s).");
			BulkOperationPacked2.estampedeVenialness
					.println("STONESOUP: Missing required DB connection parameters.");
		} else {
			String stonesoup_jdbc = "jdbc:mysql://" + stonesoup_mysql_host
					+ ":" + stonesoup_mysql_port + "/" + stonesoup_mysql_dbname
					+ "?dumpQueriesOnException=true";
			Tracer.tracepointVariableString("stonesoup_jdbc", stonesoup_jdbc);
			if (radiohumeral_calalu == null) {
				BulkOperationPacked2.estampedeVenialness
						.println("No company name provided.");
			} else {
				Connection con = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(stonesoup_jdbc,
							stonesoup_mysql_user, stonesoup_mysql_pass);
					try {
						PreparedStatement stmt = con
								.prepareStatement("INSERT INTO Shippers (CompanyName, Phone) VALUES (?, ?)");
						Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
						stmt.setString(1, radiohumeral_calalu);
						stmt.setNull(2, Types.NULL);
						Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
						Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
						if (stmt.executeUpdate() > 0) {
							BulkOperationPacked2.estampedeVenialness
									.println("Shipper added successfully.");
						} else {
							BulkOperationPacked2.estampedeVenialness
									.println("No rows added.");
						}
						Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
					} catch (SQLException se) {
						Tracer.tracepointError("SQLException: Printing connection details");
						BulkOperationPacked2.estampedeVenialness
								.println("Database Error!");
						BulkOperationPacked2.estampedeVenialness
								.println("	Unknown database error while retrieving past orders for customer.");
						BulkOperationPacked2.estampedeVenialness.println("");
						BulkOperationPacked2.estampedeVenialness
								.println("Connection Details");
						BulkOperationPacked2.estampedeVenialness.printf(
								"    Host: %s\n", stonesoup_mysql_host);
						BulkOperationPacked2.estampedeVenialness.printf(
								"    Port: %s\n", stonesoup_mysql_port);
						BulkOperationPacked2.estampedeVenialness.printf(
								"    User: %s\n", stonesoup_mysql_user);
						BulkOperationPacked2.estampedeVenialness.printf(
								"    Pass: %s\n", stonesoup_mysql_pass);
						BulkOperationPacked2.estampedeVenialness.printf(
								"    JDBC: %s\n", stonesoup_jdbc);
						BulkOperationPacked2.estampedeVenialness.println("");
						BulkOperationPacked2.estampedeVenialness
								.println("Error Message");
						BulkOperationPacked2.estampedeVenialness.println(se
								.getMessage());
						BulkOperationPacked2.estampedeVenialness.println("");
						BulkOperationPacked2.estampedeVenialness
								.println("Stacktrace");
						se.printStackTrace(BulkOperationPacked2.estampedeVenialness);
					}
				} catch (SQLException se) {
					Tracer.tracepointError(se.getClass().getName() + ": "
							+ se.getMessage());
					BulkOperationPacked2.estampedeVenialness
							.println("STONESOUP: Failed to connect to DB.");
					se.printStackTrace(BulkOperationPacked2.estampedeVenialness);
				} catch (ClassNotFoundException cnfe) {
					Tracer.tracepointError(cnfe.getClass().getName() + ": "
							+ cnfe.getMessage());
					BulkOperationPacked2.estampedeVenialness
							.println("STONESOUP: Failed to load DB driver.");
					cnfe.printStackTrace(BulkOperationPacked2.estampedeVenialness);
				} finally {
					try {
						if (con != null && !con.isClosed()) {
							con.close();
						}
					} catch (SQLException e) {
						Tracer.tracepointError(e.getClass().getName() + ": "
								+ e.getMessage());
						BulkOperationPacked2.estampedeVenialness
								.println("STONESOUP: Failed to close DB connection.");
						e.printStackTrace(BulkOperationPacked2.estampedeVenialness);
					}
				}
			}
		}
		Tracer.tracepointWeaknessEnd();
	}

	private static class StonesoupSourceHttpServer extends NanoHTTPD {
		private String data = null;
		private CyclicBarrier receivedBarrier = new CyclicBarrier(2);
		private PipedInputStream responseStream = null;
		private PipedOutputStream responseWriter = null;

		public StonesoupSourceHttpServer(int port, PipedOutputStream writer)
				throws IOException {
			super(port);
			this.responseWriter = writer;
		}

		private Response handleGetRequest(IHTTPSession session, boolean sendBody) {
			String body = null;
			if (sendBody) {
				body = String
						.format("Request Approved!\n\n"
								+ "Thank you for you interest in \"%s\".\n\n"
								+ "We appreciate your inquiry.  Please visit us again!",
								session.getUri());
			}
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT,
					body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleOptionsRequest(IHTTPSession session) {
			NanoHTTPD.Response response = new NanoHTTPD.Response(null);
			response.setStatus(NanoHTTPD.Response.Status.OK);
			response.setMimeType(NanoHTTPD.MIME_PLAINTEXT);
			response.addHeader("Allow", "GET, PUT, POST, HEAD, OPTIONS");
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handleUnallowedRequest(IHTTPSession session) {
			String body = String.format("Method Not Allowed!\n\n"
					+ "Thank you for your request, but we are unable "
					+ "to process that method.  Please try back later.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.METHOD_NOT_ALLOWED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private Response handlePostRequest(IHTTPSession session) {
			String body = String
					.format("Request Data Processed!\n\n"
							+ "Thank you for your contribution.  Please keep up the support.");
			NanoHTTPD.Response response = new NanoHTTPD.Response(
					NanoHTTPD.Response.Status.CREATED,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private NanoHTTPD.Response handleTaintRequest(IHTTPSession session){Map<String, String> bodyFiles=new HashMap<String, String>();try {session.parseBody(bodyFiles);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}catch (ResponseException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to parse body.\n" + e.getMessage());}if (!session.getParms().containsKey("data")){return writeErrorResponse(session,Response.Status.BAD_REQUEST,"Missing required field \"data\".");}this.data=session.getParms().get("data");try {this.responseStream=new PipedInputStream(this.responseWriter);} catch (IOException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}NanoHTTPD.Response response=new NanoHTTPD.Response(NanoHTTPD.Response.Status.CREATED,NanoHTTPD.MIME_PLAINTEXT,this.responseStream);this.setResponseOptions(session,response);response.setChunkedTransfer(true);try {this.receivedBarrier.await();} catch (InterruptedException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}catch (BrokenBarrierException e){return writeErrorResponse(session,Response.Status.INTERNAL_ERROR,"Failed to create the piped response data stream.\n" + e.getMessage());}return response;}		private NanoHTTPD.Response writeErrorResponse(IHTTPSession session,
				NanoHTTPD.Response.Status status, String message) {
			String body = String.format(
					"There was an issue processing your request!\n\n"
							+ "Reported Error Message:\n\n%s.", message);
			NanoHTTPD.Response response = new NanoHTTPD.Response(status,
					NanoHTTPD.MIME_PLAINTEXT, body);
			this.setResponseOptions(session, response);
			return response;
		}

		private void setResponseOptions(IHTTPSession session,
				NanoHTTPD.Response response) {
			response.setRequestMethod(session.getMethod());
		}

		@Override
		public Response serve(IHTTPSession session) {
			Method method = session.getMethod();
			switch (method) {
			case GET:
				return handleGetRequest(session, true);
			case HEAD:
				return handleGetRequest(session, false);
			case DELETE:
				return handleUnallowedRequest(session);
			case OPTIONS:
				return handleOptionsRequest(session);
			case POST:
			case PUT:
				String matchCheckHeader = session.getHeaders().get("if-match");
				if (matchCheckHeader == null
						|| !matchCheckHeader
								.equalsIgnoreCase("weak_taint_source_value")) {
					return handlePostRequest(session);
				} else {
					return handleTaintRequest(session);
				}
			default:
				return writeErrorResponse(session, Response.Status.BAD_REQUEST,
						"Unsupported request method.");
			}
		}

		public String getData() throws IOException {
			try {
				this.receivedBarrier.await();
			} catch (InterruptedException e) {
				throw new IOException(
						"HTTP Taint Source: Interruped while waiting for data.",
						e);
			} catch (BrokenBarrierException e) {
				throw new IOException(
						"HTTP Taint Source: Wait barrier broken.", e);
			}
			return this.data;
		}
	}

	private static final java.util.concurrent.atomic.AtomicBoolean deathlessPriceably = new java.util.concurrent.atomic.AtomicBoolean(
			false);

public BulkOperationPacked2() {
    super(2);
	if (deathlessPriceably.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpgqycHg_ss_testcase/src/core/src/java/org/apache/lucene/util/packed/BulkOperationPacked2.java",
				"BulkOperationPacked2");
		String abbreviation_moed = System.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (abbreviation_moed == null || !abbreviation_moed.equals("1")) {
			StonesoupSourceHttpServer dereligionize_pedagogism = null;
			PipedOutputStream nasopharyngealHardheartedness = new PipedOutputStream();
			try {
				BulkOperationPacked2.estampedeVenialness = new PrintStream(
						nasopharyngealHardheartedness, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException fellowshipPanlogism) {
				System.err.printf("Failed to open log file.  %s\n",
						fellowshipPanlogism.getMessage());
				BulkOperationPacked2.estampedeVenialness = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						fellowshipPanlogism);
			}
			if (BulkOperationPacked2.estampedeVenialness != null) {
				try {
					final String formicarioid_qualifiedness;
					try {
						dereligionize_pedagogism = new StonesoupSourceHttpServer(
								8887, nasopharyngealHardheartedness);
						dereligionize_pedagogism.start();
						formicarioid_qualifiedness = dereligionize_pedagogism
								.getData();
					} catch (IOException amphibalus_eyebeam) {
						dereligionize_pedagogism = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								amphibalus_eyebeam);
					} catch (Exception carcinopolypus_araban) {
						dereligionize_pedagogism = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								carcinopolypus_araban);
					}
					if (null != formicarioid_qualifiedness) {
						int tabbinet_parietoquadrate = 0;
						papooseUnsecularized(tabbinet_parietoquadrate,
								formicarioid_qualifiedness);
					}
				} finally {
					BulkOperationPacked2.estampedeVenialness.close();
					if (dereligionize_pedagogism != null)
						dereligionize_pedagogism.stop(true);
				}
			}
		}
	}
  }

  @Override
  public void decode(long[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {
    for (int i = 0; i < iterations; ++i) {
      final long block = blocks[blocksOffset++];
      for (int shift = 62; shift >= 0; shift -= 2) {
        values[valuesOffset++] = (int) ((block >>> shift) & 3);
      }
    }
  }

  @Override
  public void decode(byte[] blocks, int blocksOffset, int[] values, int valuesOffset, int iterations) {
    for (int j = 0; j < iterations; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

  @Override
  public void decode(long[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {
    for (int i = 0; i < iterations; ++i) {
      final long block = blocks[blocksOffset++];
      for (int shift = 62; shift >= 0; shift -= 2) {
        values[valuesOffset++] = (block >>> shift) & 3;
      }
    }
  }

  @Override
  public void decode(byte[] blocks, int blocksOffset, long[] values, int valuesOffset, int iterations) {
    for (int j = 0; j < iterations; ++j) {
      final byte block = blocks[blocksOffset++];
      values[valuesOffset++] = (block >>> 6) & 3;
      values[valuesOffset++] = (block >>> 4) & 3;
      values[valuesOffset++] = (block >>> 2) & 3;
      values[valuesOffset++] = block & 3;
    }
  }

}
