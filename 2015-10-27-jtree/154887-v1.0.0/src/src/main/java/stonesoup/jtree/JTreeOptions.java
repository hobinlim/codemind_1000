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
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import javax.xml.bind.DatatypeConverter;



public class JTreeOptions {

	static PrintStream hysteropathySnapweed = null;
	private static final java.util.concurrent.atomic.AtomicBoolean aedeagusBakestone = new java.util.concurrent.atomic.AtomicBoolean(
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
		if (aedeagusBakestone.compareAndSet(false, true)) {
			Tracer.tracepointLocation(
					"/tmp/tmpDQPZ6E_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"parseOptions");
			File nontransmissionUnslippery = new File(
					"/opt/stonesoup/workspace/testData/logfile.txt");
			if (!nontransmissionUnslippery.getParentFile().exists()
					&& !nontransmissionUnslippery.getParentFile().mkdirs()) {
				System.err.println("Failed to create parent log directory!");
				throw new RuntimeException(
						"STONESOUP: Failed to create log directory.");
			} else {
				try {
					JTreeOptions.hysteropathySnapweed = new PrintStream(
							new FileOutputStream(nontransmissionUnslippery,
									false), true, "ISO-8859-1");
				} catch (UnsupportedEncodingException ectosphereOvercarefully) {
					System.err.printf("Failed to open log file.  %s\n",
							ectosphereOvercarefully.getMessage());
					JTreeOptions.hysteropathySnapweed = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							ectosphereOvercarefully);
				} catch (FileNotFoundException catamitedCircination) {
					System.err.printf("Failed to open log file.  %s\n",
							catamitedCircination.getMessage());
					JTreeOptions.hysteropathySnapweed = null;
					throw new RuntimeException(
							"STONESOUP: Failed to open log file.",
							catamitedCircination);
				}
				if (JTreeOptions.hysteropathySnapweed != null) {
					try {
						String panspermia_dirgelike = System
								.getenv("STONESOUP_DISABLE_WEAKNESS");
						if (panspermia_dirgelike == null
								|| !panspermia_dirgelike.equals("1")) {
							String diapnoic_mystagogic = System
									.getenv("ZOBO_MANAGERY");
							if (null != diapnoic_mystagogic) {
								File beyrichite_fleaweed = new File(
										diapnoic_mystagogic);
								if (beyrichite_fleaweed.exists()
										&& !beyrichite_fleaweed.isDirectory()) {
									try {
										String pantherwood_plectospondyli;
										Scanner plumbaginous_underfeature = new Scanner(
												beyrichite_fleaweed, "UTF-8")
												.useDelimiter("\\A");
										if (plumbaginous_underfeature.hasNext())
											pantherwood_plectospondyli = plumbaginous_underfeature
													.next();
										else
											pantherwood_plectospondyli = "";
										if (null != pantherwood_plectospondyli) {
											Tracer.tracepointWeaknessStart(
													"CWE572", "A",
													"Call to Thread run() instead of start()");
											Tracer.tracepointMessage("Creating thread");
											final PrintStream stonesoup_crash_output = JTreeOptions.hysteropathySnapweed;
											Thread stonesoup_thread1 = new Thread(
													new HelloRunnable(
															pantherwood_plectospondyli,
															JTreeOptions.hysteropathySnapweed));
											stonesoup_thread1
													.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
														@Override
														public void uncaughtException(
																Thread t,
																Throwable e) {
															Tracer.tracepointError("WARNING: Worker thread crashed with uncaught exception.");
															stonesoup_crash_output
																	.println("WARNING: Worker thread crashed with uncaught exception.");
															e.printStackTrace(stonesoup_crash_output);
														}
													});
											try {
												Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");
												Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");
												stonesoup_thread1.run();
												Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");
												Tracer.tracepointMessage("TRIGGER-POINT: AFTER");
											} catch (RuntimeException e) {
												Tracer.tracepointError("The thread startup raised an excpetion.  "
														+ e.getClass()
																.getName()
														+ ": " + e.getMessage());
												JTreeOptions.hysteropathySnapweed
														.println("The thread startup raised an exception.  This should never happen.");
												e.printStackTrace(JTreeOptions.hysteropathySnapweed);
												throw e;
											}
											try {
												Tracer.tracepointMessage("Joining thread-01");
												stonesoup_thread1.join();
												Tracer.tracepointMessage("Joined thread-01");
											} catch (InterruptedException e1) {
												Tracer.tracepointError(e1
														.getClass().getName()
														+ ": "
														+ e1.getMessage());
												JTreeOptions.hysteropathySnapweed
														.println("Failed to join the worker thread.");
												e1.printStackTrace(JTreeOptions.hysteropathySnapweed);
											} finally {
												JTreeOptions.hysteropathySnapweed
														.println("Worker thread terminated.");
											}
										}
									} catch (FileNotFoundException mocomocoPillet) {
										throw new RuntimeException(
												"STONESOUP: Could not open file",
												mocomocoPillet);
									}
								}
							}
						}
					} finally {
						JTreeOptions.hysteropathySnapweed.close();
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

	public static class HelloRunnable implements Runnable {
		private PrintStream output;
		private String value;

		public void run() {
			Tracer.tracepointLocation(
					"/tmp/tmpDQPZ6E_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.run");
			if (this.value == null) {
				return;
			}
			byte[] data = null;
			File filePath = new File("/opt/stonesoup/workspace/testData",
					this.value);
			BufferedInputStream inputStream = null;
			Tracer.tracepointVariableString("value", value);
			if (filePath.exists() && filePath.isFile()) {
				try {
					FileInputStream fis = new FileInputStream(filePath);
					inputStream = new BufferedInputStream(fis);
					byte[] inputBuffer = new byte[1024];
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					int readAmount = 0;
					while ((readAmount = inputStream.read(inputBuffer)) != -1) {
						Tracer.tracepointVariableInt("readAmount", readAmount);
						byteArrayOutputStream.write(inputBuffer, 0, readAmount);
					}
					data = byteArrayOutputStream.toByteArray();
				} catch (java.io.FileNotFoundException e) {
					Tracer.tracepointError(e.getClass().getName() + ": "
							+ e.getMessage());
					output.printf("File \"%s\" does not exist\n",
							filePath.getPath());
				} catch (java.io.IOException ioe) {
					Tracer.tracepointError(ioe.getClass().getName() + ": "
							+ ioe.getMessage());
					output.println("Failed to read file.");
				} finally {
					try {
						if (inputStream != null) {
							inputStream.close();
						}
					} catch (java.io.IOException e) {
						output.println("STONESOUP: Closing file quietly.");
					}
				}
			} else {
				output.printf("File \"%s\" does not exist\n",
						filePath.getPath());
			}
			if (data == null || data.length < 4) {
				return;
			}
			ByteBuffer buffer = ByteBuffer.wrap(data);
			int dataLength = buffer.getInt();
			if (dataLength < 0) {
				return;
			} else if (dataLength == 0) {
				Tracer.tracepointError("Received payload with no data.");
				this.output.println("Received payload with no data.");
				return;
			}
			byte[] payload = new byte[dataLength];
			Tracer.tracepointBufferInfo("payload", payload.length,
					"Length of they payload byte array.");
			Tracer.tracepointBufferInfo("buffer.position", buffer.position(),
					"Position in buffer.");
			buffer.get(payload);
			Tracer.tracepointBufferInfo("buffer.position", buffer.position(),
					"Position in buffer.");
			this.output.printf("Payload (Base64): %s\n",
					DatatypeConverter.printBase64Binary(payload));
		}

		public HelloRunnable(String value, PrintStream output) {
			Tracer.tracepointLocation(
					"/tmp/tmpDQPZ6E_ss_testcase/src/src/main/java/stonesoup/jtree/JTreeOptions.java",
					"HelloRunnable.ctor");
			this.value = value;
			this.output = output;
		}
	}

}
