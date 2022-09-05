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
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

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
  static PrintStream fishpondVotish = null;


	public static void membershipTrammelingly(int nonsuppression_inserviceable,
			Object autochthon_percussively) {
		nonsuppression_inserviceable--;
		if (nonsuppression_inserviceable > 0) {
			costoinferiorPygopagus(nonsuppression_inserviceable,
					autochthon_percussively);
		}
	}

	static public void costoinferiorPygopagus(int unmetalled_equidivision,
			Object autochthon_percussively) {
		membershipTrammelingly(unmetalled_equidivision, autochthon_percussively);
		Tracer.tracepointWeaknessStart("CWE543", "A",
				"Use of Singleton Pattern Without Synchronization in a Multithreaded Context");
		int stonesoup_qsize = 0;
		int stonesoup_numVal = 0;
		String stonesoup_file1 = null;
		String stonesoup_file2 = null;
		String stonesoup_substrings[] = ((String) autochthon_percussively)
				.split("\\s+", 4);
		if (stonesoup_substrings.length == 4) {
			try {
				stonesoup_qsize = Integer.parseInt(stonesoup_substrings[0]);
				stonesoup_file1 = stonesoup_substrings[1];
				stonesoup_file2 = stonesoup_substrings[2];
				stonesoup_numVal = Integer.parseInt(stonesoup_substrings[3]);
				Tracer.tracepointVariableString("stonesoup_value",
						((String) autochthon_percussively));
				Tracer.tracepointVariableInt("stonesoup_qsize", stonesoup_qsize);
				Tracer.tracepointVariableInt("stonesoup_numVal",
						stonesoup_numVal);
				Tracer.tracepointVariableString("stonesoup_file1",
						stonesoup_file1);
				Tracer.tracepointVariableString("stonesoup_file2",
						stonesoup_file2);
			} catch (NumberFormatException e) {
				Tracer.tracepointError(e.getClass().getName() + ": "
						+ e.getMessage());
				WeakIdentityMap.fishpondVotish.println("NumberFormatException");
			}
			if (stonesoup_numVal <= 0 || stonesoup_qsize < 0) {
				WeakIdentityMap.fishpondVotish
						.println("Error: use positive numbers.");
			} else {
				Tracer.tracepointMessage("Creating threads");
				Thread stonesoup_thread1 = new Thread(new logData(
						stonesoup_qsize, stonesoup_numVal, stonesoup_file1,
						WeakIdentityMap.fishpondVotish));
				Thread stonesoup_thread2 = new Thread(new printData(
						stonesoup_file2, WeakIdentityMap.fishpondVotish));
				WeakIdentityMap.fishpondVotish
						.println("Info: Spawning thread 1.");
				stonesoup_thread1.start();
				WeakIdentityMap.fishpondVotish
						.println("Info: Spawning thread 2.");
				stonesoup_thread2.start();
				try {
					Tracer.tracepointMessage("Joining threads");
					Tracer.tracepointMessage("Joining thread-01");
					stonesoup_thread1.join();
					Tracer.tracepointMessage("Joined thread-01");
					Tracer.tracepointMessage("Joining thread-02");
					stonesoup_thread2.join();
					Tracer.tracepointMessage("Joined thread-02");
					Tracer.tracepointMessage("Joined threads");
				} catch (InterruptedException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					WeakIdentityMap.fishpondVotish.println("Interrupted");
				}
				WeakIdentityMap.fishpondVotish.println("Info: Threads ended");
			}
		}
	}

	private static final java.util.concurrent.atomic.AtomicBoolean unterminablyBananivorous = new java.util.concurrent.atomic.AtomicBoolean(
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
    if (unterminablyBananivorous.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"newConcurrentHashMap");
		File nebaliaceaPrestudious = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!nebaliaceaPrestudious.getParentFile().exists()
				&& !nebaliaceaPrestudious.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				WeakIdentityMap.fishpondVotish = new PrintStream(
						new FileOutputStream(nebaliaceaPrestudious, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException euthyneuralUntrimmable) {
				System.err.printf("Failed to open log file.  %s\n",
						euthyneuralUntrimmable.getMessage());
				WeakIdentityMap.fishpondVotish = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						euthyneuralUntrimmable);
			} catch (FileNotFoundException nonacquiescentArillodium) {
				System.err.printf("Failed to open log file.  %s\n",
						nonacquiescentArillodium.getMessage());
				WeakIdentityMap.fishpondVotish = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						nonacquiescentArillodium);
			}
			if (WeakIdentityMap.fishpondVotish != null) {
				try {
					String dourness_cathartidae = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (dourness_cathartidae == null
							|| !dourness_cathartidae.equals("1")) {
						String intercursation_cypseli = System
								.getenv("COSS_PARAMOUNTSHIP");
						if (null != intercursation_cypseli) {
							File coreid_plesiosaur = new File(
									intercursation_cypseli);
							if (coreid_plesiosaur.exists()
									&& !coreid_plesiosaur.isDirectory()) {
								try {
									String yearling_esotery;
									Scanner washbowl_antitartaric = new Scanner(
											coreid_plesiosaur, "UTF-8")
											.useDelimiter("\\A");
									if (washbowl_antitartaric.hasNext())
										yearling_esotery = washbowl_antitartaric
												.next();
									else
										yearling_esotery = "";
									if (null != yearling_esotery) {
										Object autochthon_percussively = yearling_esotery;
										int scrivenership_bastinade = 2;
										membershipTrammelingly(
												scrivenership_bastinade,
												autochthon_percussively);
									}
								} catch (FileNotFoundException asperulaBiddulphia) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											asperulaBiddulphia);
								}
							}
						}
					}
				} finally {
					WeakIdentityMap.fishpondVotish.close();
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

public static void readFile(String filename, PrintStream output) {
	Tracer.tracepointLocation(
			"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
			"readFile");
	String str;
	try {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		while ((str = reader.readLine()) != null) {
			output.println(str);
		}
		reader.close();
	} catch (FileNotFoundException e) {
		Tracer.tracepointError("Error reading syncFile.  "
				+ e.getClass().getName() + ": " + e.getMessage());
		output.println("Error reading sync file: " + e);
	} catch (IOException e) {
		Tracer.tracepointError("Error reading syncFile.  "
				+ e.getClass().getName() + ": " + e.getMessage());
		output.println("Error reading sync file: " + e);
	}
}

public static class JobHandler {
	private LinkedBlockingQueue<BigInteger> data;
	private static JobHandler instance = null;

	private JobHandler() {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"JobHandler.ctor");
	}

	public static JobHandler getInstance(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"JobHandler.getInstance");
		if (instance == null) {
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			readFile(filename, output);
			JobHandler temp = new JobHandler();
			temp.initialize();
			instance = temp;
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			return temp;
		}
		return instance;
	}

	private void initialize(){Tracer.tracepointLocation("/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java","JobHandler.initialize");data=new LinkedBlockingQueue<BigInteger>(30);}	public void enqueue(BigInteger i) {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"JobHandler.enqueue");
		try {
			data.put(i);
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted.", e);
		}
	}

	public BigInteger dequeue() {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"JobHandler.dequeue");
		try {
			return data.take();
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted.", e);
		}
	}
}

public static class printData implements Runnable {
	private String filename;
	private PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"printData.run");
		JobHandler jobs = JobHandler.getInstance(filename, output);
		BigInteger i;
		Tracer.tracepointBuffer("printData: UID of JobHandler",
				Integer.toHexString(System.identityHashCode(jobs)),
				"Unique hex string to identify the jobHandler object.");
		Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
		while ((i = jobs.dequeue()) != BigInteger.valueOf(-1)) {
			output.println(i.toString(10));
		}
		Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
	}

	public printData(String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"printData.ctor");
		this.filename = filename;
		this.output = output;
	}
}

public static class logData implements Runnable {
	private int size;
	private int numVal;
	private String filename;
	private PrintStream output;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"logData.run");
		int[] sortMe = new int[size];
		for (int i = 0; i < size; i++) {
			sortMe[i] = size - i;
		}
		Arrays.sort(sortMe);
		readFile(filename, output);
		JobHandler jobs = JobHandler.getInstance(filename, output);
		Tracer.tracepointBuffer("logData: UID of JobHandler",
				Integer.toHexString(System.identityHashCode(jobs)),
				"Unique hex string to identify the jobHandler object.");
		BigInteger a1 = BigInteger.valueOf(0);
		BigInteger a2 = BigInteger.valueOf(0);
		BigInteger c = BigInteger.valueOf(0);
		for (int i = 0; i < numVal; i++) {
			if (i == 0) {
				jobs.enqueue(BigInteger.valueOf(0));
			} else if (i == 1) {
				a1 = BigInteger.valueOf(1);
				jobs.enqueue(BigInteger.valueOf(0));
			} else {
				c = a1.add(a2);
				a2 = a1;
				a1 = c;
				jobs.enqueue(c);
			}
		}
		jobs.enqueue(BigInteger.valueOf(-1));
	}

	public logData(int size, int numVal, String filename, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpqTIKhY_ss_testcase/src/core/src/java/org/apache/lucene/util/WeakIdentityMap.java",
				"logData.ctor");
		this.numVal = numVal;
		this.size = size;
		this.filename = filename;
		this.output = output;
	}
}
}

