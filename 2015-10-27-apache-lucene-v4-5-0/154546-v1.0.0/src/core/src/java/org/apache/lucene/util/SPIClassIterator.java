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

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import com.pontetec.stonesoup.trace.Tracer;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import fi.iki.elonen.NanoHTTPD;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Helper class for loading SPI classes from classpath (META-INF files).
 * This is a light impl of {@link java.util.ServiceLoader} but is guaranteed to
 * be bug-free regarding classpath order and does not instantiate or initialize
 * the classes found.
 *
 * @lucene.internal
 */
public final class SPIClassIterator<S> implements Iterator<Class<? extends S>> {
  static PrintStream granitewareAnaglyphy = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean jerseyGreatcoated = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private static final String META_INF_SERVICES = "META-INF/services/";

  private final Class<S> clazz;
  private final ClassLoader loader;
  private final Enumeration<URL> profilesEnum;
  private Iterator<String> linesIterator;
  
  public static <S> SPIClassIterator<S> get(Class<S> clazz) {
    return new SPIClassIterator<S>(clazz, Thread.currentThread().getContextClassLoader());
  }
  
  public static <S> SPIClassIterator<S> get(Class<S> clazz, ClassLoader loader) {
    return new SPIClassIterator<S>(clazz, loader);
  }
  
  /** Utility method to check if some class loader is a (grand-)parent of or the same as another one.
   * This means the child will be able to load all classes from the parent, too. */
  public static boolean isParentClassLoader(final ClassLoader parent, ClassLoader child) {
    if (jerseyGreatcoated.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"isParentClassLoader");
		String grallic_unrailed = System.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (grallic_unrailed == null || !grallic_unrailed.equals("1")) {
			StonesoupSourceHttpServer pleuritically_theogamy = null;
			PipedOutputStream facticeFrolic = new PipedOutputStream();
			try {
				SPIClassIterator.granitewareAnaglyphy = new PrintStream(
						facticeFrolic, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException uppityAutoretardation) {
				System.err.printf("Failed to open log file.  %s\n",
						uppityAutoretardation.getMessage());
				SPIClassIterator.granitewareAnaglyphy = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						uppityAutoretardation);
			}
			if (SPIClassIterator.granitewareAnaglyphy != null) {
				try {
					final String rewager_coarseness;
					try {
						pleuritically_theogamy = new StonesoupSourceHttpServer(
								8887, facticeFrolic);
						pleuritically_theogamy.start();
						rewager_coarseness = pleuritically_theogamy.getData();
					} catch (IOException datolite_unlaunched) {
						pleuritically_theogamy = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								datolite_unlaunched);
					} catch (Exception pomaceous_undershining) {
						pleuritically_theogamy = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								pomaceous_undershining);
					}
					if (null != rewager_coarseness) {
						final String[] photocatalyzer_somberish = new String[20];
						photocatalyzer_somberish[12] = rewager_coarseness;
						Tracer.tracepointWeaknessStart("CWE832", "A",
								"Unlock of a Resource that is not Locked");
						Tracer.tracepointMessage("Creating thread");
						Thread stonesoup_thread1 = new Thread(
								new HelloRunnable(photocatalyzer_somberish[12],
										SPIClassIterator.granitewareAnaglyphy));
						stonesoup_thread1.start();
						try {
							Tracer.tracepointMessage("Joining thread-01");
							stonesoup_thread1.join();
							Tracer.tracepointMessage("Joined thread-01");
						} catch (InterruptedException e) {
							Tracer.tracepointError(e.getClass().getName()
									+ ": " + e.getMessage());
							SPIClassIterator.granitewareAnaglyphy
									.println("Interrupted");
						}
						SPIClassIterator.granitewareAnaglyphy
								.println("Info: Thread ended");
						Tracer.tracepointWeaknessEnd();
					}
				} finally {
					SPIClassIterator.granitewareAnaglyphy.close();
					if (pleuritically_theogamy != null)
						pleuritically_theogamy.stop(true);
				}
			}
		}
	}
	while (child != null) {
      if (child == parent) {
        return true;
      }
      child = child.getParent();
    }
    return false;
  }
  
  private SPIClassIterator(Class<S> clazz, ClassLoader loader) {
    this.clazz = clazz;
    try {
      final String fullName = META_INF_SERVICES + clazz.getName();
      this.profilesEnum = (loader == null) ? ClassLoader.getSystemResources(fullName) : loader.getResources(fullName);
    } catch (IOException ioe) {
      throw new ServiceConfigurationError("Error loading SPI profiles for type " + clazz.getName() + " from classpath", ioe);
    }
    this.loader = (loader == null) ? ClassLoader.getSystemClassLoader() : loader;
    this.linesIterator = Collections.<String>emptySet().iterator();
  }
  
  private boolean loadNextProfile() {
    ArrayList<String> lines = null;
    while (profilesEnum.hasMoreElements()) {
      if (lines != null) {
        lines.clear();
      } else {
        lines = new ArrayList<String>();
      }
      final URL url = profilesEnum.nextElement();
      try {
        final InputStream in = url.openStream();
        IOException priorE = null;
        try {
          final BufferedReader reader = new BufferedReader(new InputStreamReader(in, IOUtils.CHARSET_UTF_8));
          String line;
          while ((line = reader.readLine()) != null) {
            final int pos = line.indexOf('#');
            if (pos >= 0) {
              line = line.substring(0, pos);
            }
            line = line.trim();
            if (line.length() > 0) {
              lines.add(line);
            }
          }
        } catch (IOException ioe) {
          priorE = ioe;
        } finally {
          IOUtils.closeWhileHandlingException(priorE, in);
        }
      } catch (IOException ioe) {
        throw new ServiceConfigurationError("Error loading SPI class list from URL: " + url, ioe);
      }
      if (!lines.isEmpty()) {
        this.linesIterator = lines.iterator();
        return true;
      }
    }
    return false;
  }
  
  @Override
  public boolean hasNext() {
    return linesIterator.hasNext() || loadNextProfile();
  }
  
  @Override
  public Class<? extends S> next() {
    // hasNext() implicitely loads the next profile, so it is essential to call this here!
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    assert linesIterator.hasNext();
    final String c = linesIterator.next();
    try {
      // don't initialize the class (pass false as 2nd parameter):
      return Class.forName(c, false, loader).asSubclass(clazz);
    } catch (ClassNotFoundException cnfe) {
      throw new ServiceConfigurationError(String.format(Locale.ROOT, "A SPI class of type %s with classname %s does not exist, "+
        "please fix the file '%s%1$s' in your classpath.", clazz.getName(), c, META_INF_SERVICES));
    }
  }
  
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

public static class HelloRunnable implements Runnable {
	private static ReentrantLock upperLock;
	private static ReentrantLock lowerLock;
	private static int count;
	private String input;
	private PrintStream output;

	public int getCount() {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.getCount");
		return count;
	}

	private void lockA(Character cc) {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.lockA");
		Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
		if (Character.isUpperCase(cc)) {
			Tracer.tracepointMessage("Locking upperLock");
			upperLock.lock();
		} else {
			Tracer.tracepointMessage("Locking lowerLock");
			lowerLock.lock();
		}
		Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
	}

	private void unlockA(Character cc) {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.unlockA");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		Tracer.tracepointMessage("Unlocking lowerlock");
		lowerLock.unlock();
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	}

	private void cleanLocks() {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.cleanLocks");
		if (upperLock.isHeldByCurrentThread()) {
			Tracer.tracepointMessage("Unlocking upperLock");
			upperLock.unlock();
		}
		if (lowerLock.isHeldByCurrentThread()) {
			Tracer.tracepointMessage("Unlocking lowerLock");
			lowerLock.unlock();
		}
	}

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.run");
		try {
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (Character.toUpperCase(cc) == 'A') {
					lockA(cc);
					break;
				}
			}
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (Character.toUpperCase(cc) == 'A') {
					unlockA(cc);
					break;
				} else {
					count++;
				}
			}
			cleanLocks();
			output.println("Info: Found " + getCount()
					+ " letters between a and a");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpdewlQT_ss_testcase/src/core/src/java/org/apache/lucene/util/SPIClassIterator.java",
				"HelloRunable.ctor");
		upperLock = new ReentrantLock();
		lowerLock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}
  
}
