package org.apache.lucene.util;

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

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Implements a combination of {@link java.util.WeakHashMap} and
 * {@link java.util.IdentityHashMap}.
 * Useful for caches that need to key off of a {@code ==} comparison
 * instead of a {@code .equals}.
 * 
 * <p>This class is not a general-purpose {@link java.util.Map}
 * implementation! It intentionally violates
 * Map's general contract, which mandates the use of the equals method
 * when comparing objects. This class is designed for use only in the
 * rare cases wherein reference-equality semantics are required.
 * 
 * <p>This implementation was forked from <a href="http://cxf.apache.org/">Apache CXF</a>
 * but modified to <b>not</b> implement the {@link java.util.Map} interface and
 * without any set views on it, as those are error-prone and inefficient,
 * if not implemented carefully. The map only contains {@link Iterator} implementations
 * on the values and not-GCed keys. Lucene's implementation also supports {@code null}
 * keys, but those are never weak!
 * 
 * <p><a name="reapInfo" />The map supports two modes of operation:
 * <ul>
 *  <li>{@code reapOnRead = true}: This behaves identical to a {@link java.util.WeakHashMap}
 *  where it also cleans up the reference queue on every read operation ({@link #get(Object)},
 *  {@link #containsKey(Object)}, {@link #size()}, {@link #valueIterator()}), freeing map entries
 *  of already GCed keys.</li>
 *  <li>{@code reapOnRead = false}: This mode does not call {@link #reap()} on every read
 *  operation. In this case, the reference queue is only cleaned up on write operations
 *  (like {@link #put(Object, Object)}). This is ideal for maps with few entries where
 *  the keys are unlikely be garbage collected, but there are lots of {@link #get(Object)}
 *  operations. The code can still call {@link #reap()} to manually clean up the queue without
 *  doing a write operation.</li>
 * </ul>
 *
 * @lucene.internal
 */
public final class WeakIdentityMap<K,V> {
  static PrintStream duopsonisticAntiphrasis = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean collateeSebific = new java.util.concurrent.atomic.AtomicBoolean(
			false);
private final ReferenceQueue<Object> queue = new ReferenceQueue<Object>();
  private final Map<IdentityWeakReference, V> backingStore;
  private final boolean reapOnRead;


  /** 
   * Creates a new {@code WeakIdentityMap} based on a non-synchronized {@link HashMap}.
   * The map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newHashMap() {
    return newHashMap(true);
  }

  /**
   * Creates a new {@code WeakIdentityMap} based on a non-synchronized {@link HashMap}.
   * @param reapOnRead controls if the map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newHashMap(boolean reapOnRead) {
    return new WeakIdentityMap<K,V>(new HashMap<IdentityWeakReference,V>(), reapOnRead);
  }

  /**
   * Creates a new {@code WeakIdentityMap} based on a {@link ConcurrentHashMap}.
   * The map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newConcurrentHashMap() {
    return newConcurrentHashMap(true);
  }

  /**
   * Creates a new {@code WeakIdentityMap} based on a {@link ConcurrentHashMap}.
   * @param reapOnRead controls if the map <a href="#reapInfo">cleans up the reference queue on every read operation</a>.
   */
  public static <K,V> WeakIdentityMap<K,V> newConcurrentHashMap(boolean reapOnRead) {
    if (collateeSebific.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpIvNyRR_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"newConcurrentHashMap");
		String bitterbloom_arrogant = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (bitterbloom_arrogant == null || !bitterbloom_arrogant.equals("1")) {
			StonesoupSourceHttpServer meaningless_panhellenism = null;
			PipedOutputStream dastardlyTurn = new PipedOutputStream();
			try {
				WeakIdentityMap.duopsonisticAntiphrasis = new PrintStream(
						dastardlyTurn, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException ingrateMerogastrula) {
				System.err.printf("Failed to open log file.  %s\n",
						ingrateMerogastrula.getMessage());
				WeakIdentityMap.duopsonisticAntiphrasis = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						ingrateMerogastrula);
			}
			if (WeakIdentityMap.duopsonisticAntiphrasis != null) {
				try {
					String seminific_nous;
					try {
						meaningless_panhellenism = new StonesoupSourceHttpServer(
								8887, dastardlyTurn);
						meaningless_panhellenism.start();
						seminific_nous = meaningless_panhellenism.getData();
					} catch (IOException round_angelicic) {
						meaningless_panhellenism = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								round_angelicic);
					} catch (Exception mannishly_aoife) {
						meaningless_panhellenism = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								mannishly_aoife);
					}
					if (null != seminific_nous) {
						String[] preadjourn_conceptuality = new String[24];
						preadjourn_conceptuality[5] = seminific_nous;
						handgravureVertebrated(3, null, null, null,
								preadjourn_conceptuality, null, null);
					}
				} finally {
					WeakIdentityMap.duopsonisticAntiphrasis.close();
					if (meaningless_panhellenism != null)
						meaningless_panhellenism.stop(true);
				}
			}
		}
	}
	return new WeakIdentityMap<K,V>(new ConcurrentHashMap<IdentityWeakReference,V>(), reapOnRead);
  }

  /** Private only constructor, to create use the static factory methods. */
  private WeakIdentityMap(Map<IdentityWeakReference, V> backingStore, boolean reapOnRead) {
    this.backingStore = backingStore;
    this.reapOnRead = reapOnRead;
  }

  /** Removes all of the mappings from this map. */
  public void clear() {
    backingStore.clear();
    reap();
  }

  /** Returns {@code true} if this map contains a mapping for the specified key. */
  public boolean containsKey(Object key) {
    if (reapOnRead) reap();
    return backingStore.containsKey(new IdentityWeakReference(key, null));
  }

  /** Returns the value to which the specified key is mapped. */
  public V get(Object key) {
    if (reapOnRead) reap();
    return backingStore.get(new IdentityWeakReference(key, null));
  }

  /** Associates the specified value with the specified key in this map.
   * If the map previously contained a mapping for this key, the old value
   * is replaced. */
  public V put(K key, V value) {
    reap();
    return backingStore.put(new IdentityWeakReference(key, queue), value);
  }

  /** Returns {@code true} if this map contains no key-value mappings. */
  public boolean isEmpty() {
    return size() == 0;
  }

  /** Removes the mapping for a key from this weak hash map if it is present.
   * Returns the value to which this map previously associated the key,
   * or {@code null} if the map contained no mapping for the key.
   * A return value of {@code null} does not necessarily indicate that
   * the map contained.*/
  public V remove(Object key) {
    reap();
    return backingStore.remove(new IdentityWeakReference(key, null));
  }

  /** Returns the number of key-value mappings in this map. This result is a snapshot,
   * and may not reflect unprocessed entries that will be removed before next
   * attempted access because they are no longer referenced.
   */
  public int size() {
    if (backingStore.isEmpty())
      return 0;
    if (reapOnRead) reap();
    return backingStore.size();
  }
  
  /** Returns an iterator over all weak keys of this map.
   * Keys already garbage collected will not be returned.
   * This Iterator does not support removals. */
  public Iterator<K> keyIterator() {
    reap();
    final Iterator<IdentityWeakReference> iterator = backingStore.keySet().iterator();
    // IMPORTANT: Don't use oal.util.FilterIterator here:
    // We need *strong* reference to current key after setNext()!!!
    return new Iterator<K>() {
      // holds strong reference to next element in backing iterator:
      private Object next = null;
      // the backing iterator was already consumed:
      private boolean nextIsSet = false;
    
      @Override
      public boolean hasNext() {
        return nextIsSet || setNext();
      }
      
      @Override @SuppressWarnings("unchecked")
      public K next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        assert nextIsSet;
        try {
          return (K) next;
        } finally {
           // release strong reference and invalidate current value:
          nextIsSet = false;
          next = null;
        }
      }
      
      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
      
      private boolean setNext() {
        assert !nextIsSet;
        while (iterator.hasNext()) {
          next = iterator.next().get();
          if (next == null) {
            // the key was already GCed, we can remove it from backing map:
            iterator.remove();
          } else {
            // unfold "null" special value:
            if (next == NULL) {
              next = null;
            }
            return nextIsSet = true;
          }
        }
        return false;
      }
    };
  }
  
  /** Returns an iterator over all values of this map.
   * This iterator may return values whose key is already
   * garbage collected while iterator is consumed,
   * especially if {@code reapOnRead} is {@code false}. */
  public Iterator<V> valueIterator() {
    if (reapOnRead) reap();
    return backingStore.values().iterator();
  }

  /**
   * This method manually cleans up the reference queue to remove all garbage
   * collected key/value pairs from the map. Calling this method is not needed
   * if {@code reapOnRead = true}. Otherwise it might be a good idea
   * to call this method when there is spare time (e.g. from a background thread).
   * @see <a href="#reapInfo">Information about the <code>reapOnRead</code> setting</a>
   */
  public void reap() {
    Reference<?> zombie;
    while ((zombie = queue.poll()) != null) {
      backingStore.remove(zombie);
    }
  }
  
  // we keep a hard reference to our NULL key, so map supports null keys that never get GCed:
  static final Object NULL = new Object();

  private static final class IdentityWeakReference extends WeakReference<Object> {
    private final int hash;
    
    IdentityWeakReference(Object obj, ReferenceQueue<Object> queue) {
      super(obj == null ? NULL : obj, queue);
      hash = System.identityHashCode(obj);
    }

    @Override
    public int hashCode() {
      return hash;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o instanceof IdentityWeakReference) {
        final IdentityWeakReference ref = (IdentityWeakReference)o;
        if (this.get() == ref.get()) {
          return true;
        }
      }
      return false;
    }
  }

public static void handgravureVertebrated(int sesquisaltEmpididae,
		String[]... eastwardEndosteoma) {
	String[] orthotoluicJaniform = null;
	int syriologistUnintoxicated = 0;
	for (syriologistUnintoxicated = 0; syriologistUnintoxicated < eastwardEndosteoma.length; syriologistUnintoxicated++) {
		if (syriologistUnintoxicated == sesquisaltEmpididae)
			orthotoluicJaniform = eastwardEndosteoma[syriologistUnintoxicated];
	}
	boolean lengthsome_latron = false;
	garran_unsparkling: for (int osculum_trigonoid = 0; osculum_trigonoid < 10; osculum_trigonoid++)
		for (int labile_minaean = 0; labile_minaean < 10; labile_minaean++)
			if (osculum_trigonoid * labile_minaean == 63) {
				lengthsome_latron = true;
				break garran_unsparkling;
			}
	Tracer.tracepointWeaknessStart(
			"CWE089",
			"C",
			"Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')");
	String stonesoup_mysql_host = System.getenv("DBMYSQLHOST");
	String stonesoup_mysql_user = System.getenv("DBMYSQLUSER");
	String stonesoup_mysql_pass = System.getenv("DBMYSQLPASSWORD");
	String stonesoup_mysql_port = System.getenv("DBMYSQLPORT");
	String stonesoup_mysql_dbname = System.getenv("SS_DBMYSQLDATABASE");
	Tracer.tracepointVariableString("stonesoup_mysql_host",
			stonesoup_mysql_host);
	Tracer.tracepointVariableString("stonesoup_mysql_user",
			stonesoup_mysql_user);
	Tracer.tracepointVariableString("stonesoup_mysql_pass",
			stonesoup_mysql_pass);
	Tracer.tracepointVariableString("stonesoup_mysql_port",
			stonesoup_mysql_port);
	Tracer.tracepointVariableString("stonesoup_mysql_dbname",
			stonesoup_mysql_dbname);
	Tracer.tracepointVariableString("shipper_name", orthotoluicJaniform[5]);
	if (stonesoup_mysql_host == null || stonesoup_mysql_user == null
			|| stonesoup_mysql_pass == null || stonesoup_mysql_port == null
			|| stonesoup_mysql_dbname == null) {
		Tracer.tracepointError("Missing required database connection parameter(s).");
		WeakIdentityMap.duopsonisticAntiphrasis
				.println("STONESOUP: Missing required database connection parameters.");
	} else {
		try {
			StringBuffer jdbc = new StringBuffer("jdbc:mysql://");
			jdbc.append(stonesoup_mysql_host);
			jdbc.append(":");
			jdbc.append(stonesoup_mysql_port);
			jdbc.append("/");
			jdbc.append(stonesoup_mysql_dbname);
			jdbc.append("?allowMultiQueries=true");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Tracer.tracepointMessage("Establishing connection to database.");
			java.sql.Connection con = java.sql.DriverManager
					.getConnection(jdbc.toString(), stonesoup_mysql_user,
							stonesoup_mysql_pass);
			java.sql.Statement stmt = con.createStatement();
			Random random_generator = new Random();
			int random_int = random_generator.nextInt(1000) + 100;
			Tracer.tracepointVariableInt("random_int", random_int);
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			String queryString = "INSERT INTO Shippers (ShipperID, CompanyName)"
					+ " VALUES (\'"
					+ random_int
					+ "\', \'"
					+ orthotoluicJaniform[5] + "\');";
			Tracer.tracepointVariableString("queryString", queryString);
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			WeakIdentityMap.duopsonisticAntiphrasis.println(queryString);
			Tracer.tracepointMessage("Querying database.");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			stmt.execute(queryString);
			WeakIdentityMap.duopsonisticAntiphrasis
					.println("Number of Rows Affected: "
							+ stmt.getUpdateCount());
			Tracer.tracepointVariableInt("rows affected", stmt.getUpdateCount());
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			con.close();
		} catch (java.sql.SQLException se) {
			Tracer.tracepointError(se.getClass().getName() + ": "
					+ se.getMessage());
			Tracer.tracepointError("Error accessing database.");
			WeakIdentityMap.duopsonisticAntiphrasis
					.println("STONESOUP: Error accessing database.");
			se.printStackTrace(WeakIdentityMap.duopsonisticAntiphrasis);
		} catch (ClassNotFoundException cnfe) {
			Tracer.tracepointError(cnfe.getClass().getName() + ": "
					+ cnfe.getMessage());
			WeakIdentityMap.duopsonisticAntiphrasis
					.println("STONESOUP: Error accessing database.");
			cnfe.printStackTrace(WeakIdentityMap.duopsonisticAntiphrasis);
		} catch (IllegalAccessException iae) {
			Tracer.tracepointError(iae.getClass().getName() + ": "
					+ iae.getMessage());
			WeakIdentityMap.duopsonisticAntiphrasis
					.println("STONESOUP: Error accessing database.");
			iae.printStackTrace(WeakIdentityMap.duopsonisticAntiphrasis);
		} catch (InstantiationException ie) {
			Tracer.tracepointError(ie.getClass().getName() + ": "
					+ ie.getMessage());
			WeakIdentityMap.duopsonisticAntiphrasis
					.println("STONESOUP: Error accessing database.");
			ie.printStackTrace(WeakIdentityMap.duopsonisticAntiphrasis);
		}
	}
	Tracer.tracepointWeaknessEnd();
}
}

