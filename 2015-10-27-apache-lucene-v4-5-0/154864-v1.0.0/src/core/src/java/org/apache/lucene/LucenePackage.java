package org.apache.lucene;

import com.pontetec.stonesoup.trace.Tracer;
import java.io.PrintStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

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

  private static final int chilostomata_titilate = 10;
	static PrintStream secretiveParaboloid = null;
	private static final java.util.concurrent.atomic.AtomicBoolean doubletsKatabolically = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private LucenePackage() {}                      // can't construct

  /** Return Lucene's package, including version information. */
  public static Package get() {
    if (doubletsKatabolically.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpzQ2R4b_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"get");
		File undersleepUnembodied = new File(
				"/opt/stonesoup/workspace/testData/logfile.txt");
		if (!undersleepUnembodied.getParentFile().exists()
				&& !undersleepUnembodied.getParentFile().mkdirs()) {
			System.err.println("Failed to create parent log directory!");
			throw new RuntimeException(
					"STONESOUP: Failed to create log directory.");
		} else {
			try {
				LucenePackage.secretiveParaboloid = new PrintStream(
						new FileOutputStream(undersleepUnembodied, false),
						true, "ISO-8859-1");
			} catch (UnsupportedEncodingException ficklewiseProtriaene) {
				System.err.printf("Failed to open log file.  %s\n",
						ficklewiseProtriaene.getMessage());
				LucenePackage.secretiveParaboloid = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						ficklewiseProtriaene);
			} catch (FileNotFoundException chalkerPleuropterygii) {
				System.err.printf("Failed to open log file.  %s\n",
						chalkerPleuropterygii.getMessage());
				LucenePackage.secretiveParaboloid = null;
				throw new RuntimeException(
						"STONESOUP: Failed to open log file.",
						chalkerPleuropterygii);
			}
			if (LucenePackage.secretiveParaboloid != null) {
				try {
					String epicrates_phenanthridone = System
							.getenv("STONESOUP_DISABLE_WEAKNESS");
					if (epicrates_phenanthridone == null
							|| !epicrates_phenanthridone.equals("1")) {
						String subglottic_equisided = System
								.getenv("BROCHO_MENSURATIONAL");
						if (null != subglottic_equisided) {
							File deplaceable_intimater = new File(
									subglottic_equisided);
							if (deplaceable_intimater.exists()
									&& !deplaceable_intimater.isDirectory()) {
								try {
									String scrutinously_wesselton;
									Scanner pendulate_carrara = new Scanner(
											deplaceable_intimater, "UTF-8")
											.useDelimiter("\\A");
									if (pendulate_carrara.hasNext())
										scrutinously_wesselton = pendulate_carrara
												.next();
									else
										scrutinously_wesselton = "";
									if (null != scrutinously_wesselton) {
										Object attendantly_parly = scrutinously_wesselton;
										Object[] serration_chloralize = new Object[23];
										serration_chloralize[chilostomata_titilate] = attendantly_parly;
										boolean shamba_quantum = false;
										baggit_respirable: for (int mitotic_monstrosity = 0; mitotic_monstrosity < 10; mitotic_monstrosity++)
											for (int interlocular_oedemeridae = 0; interlocular_oedemeridae < 10; interlocular_oedemeridae++)
												if (mitotic_monstrosity
														* interlocular_oedemeridae == 63) {
													shamba_quantum = true;
													break baggit_respirable;
												}
										Tracer.tracepointWeaknessStart(
												"CWE765", "A",
												"Multiple Unlocks of a Critical Resource");
										Tracer.tracepointMessage("Creating thread");
										Thread stonesoup_thread1 = new Thread(
												new HelloRunnable(
														((String) serration_chloralize[chilostomata_titilate]),
														LucenePackage.secretiveParaboloid));
										stonesoup_thread1.start();
										try {
											Tracer.tracepointMessage("Joining thread-01");
											stonesoup_thread1.join();
											Tracer.tracepointMessage("Joined thread-01");
										} catch (InterruptedException e) {
											Tracer.tracepointError(e.getClass()
													.getName()
													+ ": "
													+ e.getMessage());
											LucenePackage.secretiveParaboloid
													.println("Interrupted");
										}
										LucenePackage.secretiveParaboloid
												.println("Info: Threads ended");
										Tracer.tracepointWeaknessEnd();
									}
								} catch (FileNotFoundException hoydenismIncontinent) {
									throw new RuntimeException(
											"STONESOUP: Could not open file",
											hoydenismIncontinent);
								}
							}
						}
					}
				} finally {
					LucenePackage.secretiveParaboloid.close();
				}
			}
		}
	}
	return LucenePackage.class.getPackage();
  }

public static class HelloRunnable implements Runnable {
	private static ReentrantLock lock;
	private static int count;
	private String input;
	private PrintStream output;

	public int getCount() {
		return count;
	}

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpzQ2R4b_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"HelloRunnable.run");
		Tracer.tracepointVariableString("input", input);
		try {
			int index = 0;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (cc == '1') {
					Tracer.tracepointMessage("Locking lock");
					Tracer.tracepointVariableInt("index", index);
					lock.lock();
					break;
				}
			}
			Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
			Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
			boolean found1 = false;
			while (index < input.length()) {
				char cc = input.charAt(index);
				index++;
				if (!found1) {
					count++;
				}
				if (cc == '1') {
					Tracer.tracepointMessage("Unlocking lock");
					lock.unlock();
					found1 = true;
				}
			}
			if (lock.isHeldByCurrentThread()) {
				Tracer.tracepointMessage("Unlocking lock");
				lock.unlock();
			}
			Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
			Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
			output.println("Info: Found " + getCount()
					+ " letters between 1 and 1");
		} catch (java.lang.RuntimeException e) {
			e.printStackTrace(output);
			throw e;
		}
	}

	public HelloRunnable(String input, PrintStream output) {
		Tracer.tracepointLocation(
				"/tmp/tmpzQ2R4b_ss_testcase/src/core/src/java/org/apache/lucene/LucenePackage.java",
				"HelloRunnable.ctor");
		lock = new ReentrantLock();
		count = 0;
		this.input = input;
		this.output = output;
	}
}
}
