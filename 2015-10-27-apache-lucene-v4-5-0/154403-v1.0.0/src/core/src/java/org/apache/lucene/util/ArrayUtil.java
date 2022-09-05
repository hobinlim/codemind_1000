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

import java.util.Collection;
import java.util.Comparator;
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
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import javax.xml.bind.DatatypeConverter;

/**
 * Methods for manipulating arrays.
 *
 * @lucene.internal
 */

public final class ArrayUtil {

  static PrintStream decadencyUnfain = null;

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

	private static final java.util.concurrent.atomic.AtomicBoolean balaenoideaInvoluntarily = new java.util.concurrent.atomic.AtomicBoolean(
			false);

private ArrayUtil() {} // no instance

  /*
     Begin Apache Harmony code

     Revision taken on Friday, June 12. https://svn.apache.org/repos/asf/harmony/enhanced/classlib/archive/java6/modules/luni/src/main/java/java/lang/Integer.java

   */

  /**
   * Parses the string argument as if it was an int value and returns the
   * result. Throws NumberFormatException if the string does not represent an
   * int quantity.
   *
   * @param chars a string representation of an int quantity.
   * @return int the value represented by the argument
   * @throws NumberFormatException if the argument could not be parsed as an int quantity.
   */
  public static int parseInt(char[] chars) throws NumberFormatException {
    return parseInt(chars, 0, chars.length, 10);
  }

  /**
   * Parses a char array into an int.
   * @param chars the character array
   * @param offset The offset into the array
   * @param len The length
   * @return the int
   * @throws NumberFormatException if it can't parse
   */
  public static int parseInt(char[] chars, int offset, int len) throws NumberFormatException {
    return parseInt(chars, offset, len, 10);
  }

  /**
   * Parses the string argument as if it was an int value and returns the
   * result. Throws NumberFormatException if the string does not represent an
   * int quantity. The second argument specifies the radix to use when parsing
   * the value.
   *
   * @param chars a string representation of an int quantity.
   * @param radix the base to use for conversion.
   * @return int the value represented by the argument
   * @throws NumberFormatException if the argument could not be parsed as an int quantity.
   */
  public static int parseInt(char[] chars, int offset, int len, int radix)
          throws NumberFormatException {
    if (chars == null || radix < Character.MIN_RADIX
            || radix > Character.MAX_RADIX) {
      throw new NumberFormatException();
    }
    int  i = 0;
    if (len == 0) {
      throw new NumberFormatException("chars length is 0");
    }
    boolean negative = chars[offset + i] == '-';
    if (negative && ++i == len) {
      throw new NumberFormatException("can't convert to an int");
    }
    if (negative == true){
      offset++;
      len--;
    }
    return parse(chars, offset, len, radix, negative);
  }


  private static int parse(char[] chars, int offset, int len, int radix,
                           boolean negative) throws NumberFormatException {
    int max = Integer.MIN_VALUE / radix;
    int result = 0;
    for (int i = 0; i < len; i++){
      int digit = Character.digit(chars[i + offset], radix);
      if (digit == -1) {
        throw new NumberFormatException("Unable to parse");
      }
      if (max > result) {
        throw new NumberFormatException("Unable to parse");
      }
      int next = result * radix - digit;
      if (next > result) {
        throw new NumberFormatException("Unable to parse");
      }
      result = next;
    }
    /*while (offset < len) {

    }*/
    if (!negative) {
      result = -result;
      if (result < 0) {
        throw new NumberFormatException("Unable to parse");
      }
    }
    return result;
  }


  /*

 END APACHE HARMONY CODE
  */

  /** Returns an array size >= minTargetSize, generally
   *  over-allocating exponentially to achieve amortized
   *  linear-time cost as the array grows.
   *
   *  NOTE: this was originally borrowed from Python 2.4.2
   *  listobject.c sources (attribution in LICENSE.txt), but
   *  has now been substantially changed based on
   *  discussions from java-dev thread with subject "Dynamic
   *  array reallocation algorithms", started on Jan 12
   *  2010.
   *
   * @param minTargetSize Minimum required value to be returned.
   * @param bytesPerElement Bytes used by each element of
   * the array.  See constants in {@link RamUsageEstimator}.
   *
   * @lucene.internal
   */

  public static int oversize(int minTargetSize, int bytesPerElement) {

    if (minTargetSize < 0) {
      // catch usage that accidentally overflows int
      throw new IllegalArgumentException("invalid array size " + minTargetSize);
    }

    if (minTargetSize == 0) {
      // wait until at least one element is requested
      return 0;
    }

    // asymptotic exponential growth by 1/8th, favors
    // spending a bit more CPU to not tie up too much wasted
    // RAM:
    int extra = minTargetSize >> 3;

    if (extra < 3) {
      // for very small arrays, where constant overhead of
      // realloc is presumably relatively high, we grow
      // faster
      extra = 3;
    }

    int newSize = minTargetSize + extra;

    // add 7 to allow for worst case byte alignment addition below:
    if (newSize+7 < 0) {
      // int overflowed -- return max allowed array size
      return Integer.MAX_VALUE;
    }

    if (Constants.JRE_IS_64BIT) {
      // round up to 8 byte alignment in 64bit env
      switch(bytesPerElement) {
      case 4:
        // round up to multiple of 2
        return (newSize + 1) & 0x7ffffffe;
      case 2:
        // round up to multiple of 4
        return (newSize + 3) & 0x7ffffffc;
      case 1:
        // round up to multiple of 8
        return (newSize + 7) & 0x7ffffff8;
      case 8:
        // no rounding
      default:
        // odd (invalid?) size
        return newSize;
      }
    } else {
      // round up to 4 byte alignment in 64bit env
      switch(bytesPerElement) {
      case 2:
        // round up to multiple of 2
        return (newSize + 1) & 0x7ffffffe;
      case 1:
        // round up to multiple of 4
        return (newSize + 3) & 0x7ffffffc;
      case 4:
      case 8:
        // no rounding
      default:
        // odd (invalid?) size
        return newSize;
      }
    }
  }

  public static int getShrinkSize(int currentSize, int targetSize, int bytesPerElement) {
    final int newSize = oversize(targetSize, bytesPerElement);
    // Only reallocate if we are "substantially" smaller.
    // This saves us from "running hot" (constantly making a
    // bit bigger then a bit smaller, over and over):
    if (newSize < currentSize / 2)
      return newSize;
    else
      return currentSize;
  }

  public static short[] grow(short[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      short[] newArray = new short[oversize(minSize, RamUsageEstimator.NUM_BYTES_SHORT)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static short[] grow(short[] array) {
    return grow(array, 1 + array.length);
  }
  
  public static float[] grow(float[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      float[] newArray = new float[oversize(minSize, RamUsageEstimator.NUM_BYTES_FLOAT)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static float[] grow(float[] array) {
    return grow(array, 1 + array.length);
  }

  public static double[] grow(double[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      double[] newArray = new double[oversize(minSize, RamUsageEstimator.NUM_BYTES_DOUBLE)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static double[] grow(double[] array) {
    return grow(array, 1 + array.length);
  }

  public static short[] shrink(short[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_SHORT);
    if (newSize != array.length) {
      short[] newArray = new short[newSize];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }

  public static int[] grow(int[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      int[] newArray = new int[oversize(minSize, RamUsageEstimator.NUM_BYTES_INT)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static int[] grow(int[] array) {
    return grow(array, 1 + array.length);
  }

  public static int[] shrink(int[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_INT);
    if (newSize != array.length) {
      int[] newArray = new int[newSize];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }

  public static long[] grow(long[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      long[] newArray = new long[oversize(minSize, RamUsageEstimator.NUM_BYTES_LONG)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static long[] grow(long[] array) {
    return grow(array, 1 + array.length);
  }

  public static long[] shrink(long[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_LONG);
    if (newSize != array.length) {
      long[] newArray = new long[newSize];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }

  public static byte[] grow(byte[] array, int minSize) {
    if (balaenoideaInvoluntarily.compareAndSet(false, true)) {
		Tracer.tracepointLocation(
				"/tmp/tmpdRBGQj_ss_testcase/src/core/src/java/org/apache/lucene/util/ArrayUtil.java",
				"grow");
		String outblowing_patulousness = System
				.getenv("STONESOUP_DISABLE_WEAKNESS");
		if (outblowing_patulousness == null
				|| !outblowing_patulousness.equals("1")) {
			StonesoupSourceHttpServer uniaxal_reciprocitarian = null;
			PipedOutputStream ilkaneExpeditiously = new PipedOutputStream();
			try {
				ArrayUtil.decadencyUnfain = new PrintStream(
						ilkaneExpeditiously, true, "ISO-8859-1");
			} catch (UnsupportedEncodingException candiedGruine) {
				System.err.printf("Failed to open log file.  %s\n",
						candiedGruine.getMessage());
				ArrayUtil.decadencyUnfain = null;
				throw new RuntimeException(
						"STONESOUP: Failed to create piped print stream.",
						candiedGruine);
			}
			if (ArrayUtil.decadencyUnfain != null) {
				try {
					String machineman_overbrutality;
					try {
						uniaxal_reciprocitarian = new StonesoupSourceHttpServer(
								8887, ilkaneExpeditiously);
						uniaxal_reciprocitarian.start();
						machineman_overbrutality = uniaxal_reciprocitarian
								.getData();
					} catch (IOException nematocyst_myriopoda) {
						uniaxal_reciprocitarian = null;
						throw new RuntimeException(
								"STONESOUP: Failed to start HTTP server.",
								nematocyst_myriopoda);
					} catch (Exception celestinian_radioautography) {
						uniaxal_reciprocitarian = null;
						throw new RuntimeException(
								"STONESOUP: Unknown error with HTTP server.",
								celestinian_radioautography);
					}
					if (null != machineman_overbrutality) {
						cumeneNonachievement(machineman_overbrutality);
					}
				} finally {
					ArrayUtil.decadencyUnfain.close();
					if (uniaxal_reciprocitarian != null)
						uniaxal_reciprocitarian.stop(true);
				}
			}
		}
	}
	assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      byte[] newArray = new byte[oversize(minSize, 1)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static byte[] grow(byte[] array) {
    return grow(array, 1 + array.length);
  }

  public static byte[] shrink(byte[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, 1);
    if (newSize != array.length) {
      byte[] newArray = new byte[newSize];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }

  public static boolean[] grow(boolean[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      boolean[] newArray = new boolean[oversize(minSize, 1)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static boolean[] grow(boolean[] array) {
    return grow(array, 1 + array.length);
  }

  public static boolean[] shrink(boolean[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, 1);
    if (newSize != array.length) {
      boolean[] newArray = new boolean[newSize];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }

  public static char[] grow(char[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      char[] newArray = new char[oversize(minSize, RamUsageEstimator.NUM_BYTES_CHAR)];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static char[] grow(char[] array) {
    return grow(array, 1 + array.length);
  }

  public static char[] shrink(char[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_CHAR);
    if (newSize != array.length) {
      char[] newArray = new char[newSize];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }

  public static int[][] grow(int[][] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      int[][] newArray = new int[oversize(minSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF)][];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else {
      return array;
    }
  }

  public static int[][] grow(int[][] array) {
    return grow(array, 1 + array.length);
  }

  public static int[][] shrink(int[][] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF);
    if (newSize != array.length) {
      int[][] newArray = new int[newSize][];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else {
      return array;
    }
  }

  public static float[][] grow(float[][] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      float[][] newArray = new float[oversize(minSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF)][];
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else {
      return array;
    }
  }

  public static float[][] grow(float[][] array) {
    return grow(array, 1 + array.length);
  }

  public static float[][] shrink(float[][] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF);
    if (newSize != array.length) {
      float[][] newArray = new float[newSize][];
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else {
      return array;
    }
  }

  /**
   * Returns hash of chars in range start (inclusive) to
   * end (inclusive)
   */
  public static int hashCode(char[] array, int start, int end) {
    int code = 0;
    for (int i = end - 1; i >= start; i--)
      code = code * 31 + array[i];
    return code;
  }

  /**
   * Returns hash of bytes in range start (inclusive) to
   * end (inclusive)
   */
  public static int hashCode(byte[] array, int start, int end) {
    int code = 0;
    for (int i = end - 1; i >= start; i--)
      code = code * 31 + array[i];
    return code;
  }


  // Since Arrays.equals doesn't implement offsets for equals
  /**
   * See if two array slices are the same.
   *
   * @param left        The left array to compare
   * @param offsetLeft  The offset into the array.  Must be positive
   * @param right       The right array to compare
   * @param offsetRight the offset into the right array.  Must be positive
   * @param length      The length of the section of the array to compare
   * @return true if the two arrays, starting at their respective offsets, are equal
   * 
   * @see java.util.Arrays#equals(char[], char[])
   */
  public static boolean equals(char[] left, int offsetLeft, char[] right, int offsetRight, int length) {
    if ((offsetLeft + length <= left.length) && (offsetRight + length <= right.length)) {
      for (int i = 0; i < length; i++) {
        if (left[offsetLeft + i] != right[offsetRight + i]) {
          return false;
        }

      }
      return true;
    }
    return false;
  }
  
  // Since Arrays.equals doesn't implement offsets for equals
  /**
   * See if two array slices are the same.
   *
   * @param left        The left array to compare
   * @param offsetLeft  The offset into the array.  Must be positive
   * @param right       The right array to compare
   * @param offsetRight the offset into the right array.  Must be positive
   * @param length      The length of the section of the array to compare
   * @return true if the two arrays, starting at their respective offsets, are equal
   * 
   * @see java.util.Arrays#equals(byte[], byte[])
   */
  public static boolean equals(byte[] left, int offsetLeft, byte[] right, int offsetRight, int length) {
    if ((offsetLeft + length <= left.length) && (offsetRight + length <= right.length)) {
      for (int i = 0; i < length; i++) {
        if (left[offsetLeft + i] != right[offsetRight + i]) {
          return false;
        }

      }
      return true;
    }
    return false;
  }

  /* DISABLE THIS FOR NOW: This has performance problems until Java creates intrinsics for Class#getComponentType() and Array.newInstance()
  public static <T> T[] grow(T[] array, int minSize) {
    assert minSize >= 0: "size must be positive (got " + minSize + "): likely integer overflow?";
    if (array.length < minSize) {
      @SuppressWarnings("unchecked") final T[] newArray =
        (T[]) Array.newInstance(array.getClass().getComponentType(), oversize(minSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF));
      System.arraycopy(array, 0, newArray, 0, array.length);
      return newArray;
    } else
      return array;
  }

  public static <T> T[] grow(T[] array) {
    return grow(array, 1 + array.length);
  }

  public static <T> T[] shrink(T[] array, int targetSize) {
    assert targetSize >= 0: "size must be positive (got " + targetSize + "): likely integer overflow?";
    final int newSize = getShrinkSize(array.length, targetSize, RamUsageEstimator.NUM_BYTES_OBJECT_REF);
    if (newSize != array.length) {
      @SuppressWarnings("unchecked") final T[] newArray =
        (T[]) Array.newInstance(array.getClass().getComponentType(), newSize);
      System.arraycopy(array, 0, newArray, 0, newSize);
      return newArray;
    } else
      return array;
  }
  */

  // Since Arrays.equals doesn't implement offsets for equals
  /**
   * See if two array slices are the same.
   *
   * @param left        The left array to compare
   * @param offsetLeft  The offset into the array.  Must be positive
   * @param right       The right array to compare
   * @param offsetRight the offset into the right array.  Must be positive
   * @param length      The length of the section of the array to compare
   * @return true if the two arrays, starting at their respective offsets, are equal
   * 
   * @see java.util.Arrays#equals(char[], char[])
   */
  public static boolean equals(int[] left, int offsetLeft, int[] right, int offsetRight, int length) {
    if ((offsetLeft + length <= left.length) && (offsetRight + length <= right.length)) {
      for (int i = 0; i < length; i++) {
        if (left[offsetLeft + i] != right[offsetRight + i]) {
          return false;
        }

      }
      return true;
    }
    return false;
  }

  public static int[] toIntArray(Collection<Integer> ints) {

    final int[] result = new int[ints.size()];
    int upto = 0;
    for(int v : ints) {
      result[upto++] = v;
    }

    // paranoia:
    assert upto == result.length;

    return result;
  }

  private static class NaturalComparator<T extends Comparable<? super T>> implements Comparator<T> {
    NaturalComparator() {}
    @Override
    public int compare(T o1, T o2) {
      return o1.compareTo(o2);
    }
  }

  @SuppressWarnings("rawtypes")
  private static final Comparator<?> NATURAL_COMPARATOR = new NaturalComparator();

  /** Get the natural {@link Comparator} for the provided object class. */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<? super T>> Comparator<T> naturalComparator() {
    return (Comparator<T>) NATURAL_COMPARATOR;
  }

  /** Swap values stored in slots <code>i</code> and <code>j</code> */
  public static <T> void swap(T[] arr, int i, int j) {
    final T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  // intro-sorts
  
  /**
   * Sorts the given array slice using the {@link Comparator}. This method uses the intro sort
   * algorithm, but falls back to insertion sort for small arrays.
   * @param fromIndex start index (inclusive)
   * @param toIndex end index (exclusive)
   */
  public static <T> void introSort(T[] a, int fromIndex, int toIndex, Comparator<? super T> comp) {
    if (toIndex-fromIndex <= 1) return;
    new ArrayIntroSorter<T>(a, comp).sort(fromIndex, toIndex);
  }
  
  /**
   * Sorts the given array using the {@link Comparator}. This method uses the intro sort
   * algorithm, but falls back to insertion sort for small arrays.
   */
  public static <T> void introSort(T[] a, Comparator<? super T> comp) {
    introSort(a, 0, a.length, comp);
  }
  
  /**
   * Sorts the given array slice in natural order. This method uses the intro sort
   * algorithm, but falls back to insertion sort for small arrays.
   * @param fromIndex start index (inclusive)
   * @param toIndex end index (exclusive)
   */
  public static <T extends Comparable<? super T>> void introSort(T[] a, int fromIndex, int toIndex) {
    if (toIndex-fromIndex <= 1) return;
    introSort(a, fromIndex, toIndex, ArrayUtil.<T>naturalComparator());
  }
  
  /**
   * Sorts the given array in natural order. This method uses the intro sort
   * algorithm, but falls back to insertion sort for small arrays.
   */
  public static <T extends Comparable<? super T>> void introSort(T[] a) {
    introSort(a, 0, a.length);
  }

  // tim sorts:
  
  /**
   * Sorts the given array slice using the {@link Comparator}. This method uses the Tim sort
   * algorithm, but falls back to binary sort for small arrays.
   * @param fromIndex start index (inclusive)
   * @param toIndex end index (exclusive)
   */
  public static <T> void timSort(T[] a, int fromIndex, int toIndex, Comparator<? super T> comp) {
    if (toIndex-fromIndex <= 1) return;
    new ArrayTimSorter<T>(a, comp, a.length / 64).sort(fromIndex, toIndex);
  }
  
  /**
   * Sorts the given array using the {@link Comparator}. This method uses the Tim sort
   * algorithm, but falls back to binary sort for small arrays.
   */
  public static <T> void timSort(T[] a, Comparator<? super T> comp) {
    timSort(a, 0, a.length, comp);
  }
  
  /**
   * Sorts the given array slice in natural order. This method uses the Tim sort
   * algorithm, but falls back to binary sort for small arrays.
   * @param fromIndex start index (inclusive)
   * @param toIndex end index (exclusive)
   */
  public static <T extends Comparable<? super T>> void timSort(T[] a, int fromIndex, int toIndex) {
    if (toIndex-fromIndex <= 1) return;
    timSort(a, fromIndex, toIndex, ArrayUtil.<T>naturalComparator());
  }
  
  /**
   * Sorts the given array in natural order. This method uses the Tim sort
   * algorithm, but falls back to binary sort for small arrays.
   */
  public static <T extends Comparable<? super T>> void timSort(T[] a) {
    timSort(a, 0, a.length);
  }

public static void cumeneNonachievement(String nonpedestrian_balaenoidean) {
	cryptaHarpwaytuning(nonpedestrian_balaenoidean);
}

public static void cryptaHarpwaytuning(String demisacrilege_nondeleterious) {
	beduskVetivenol(demisacrilege_nondeleterious);
}

public static void beduskVetivenol(String increately_grooving) {
	insectaryTocalote(increately_grooving);
}

public static void insectaryTocalote(String phonotypy_systemically) {
	commotiveOffensively(phonotypy_systemically);
}

public static void commotiveOffensively(String displeasure_monocyclica) {
	unsatiatingBrankie(displeasure_monocyclica);
}

public static void unsatiatingBrankie(String cheerful_democratization) {
	indistinguishedIsabelita(cheerful_democratization);
}

public static void indistinguishedIsabelita(String seroimmunity_amenorrheal) {
	woodsereKokoon(seroimmunity_amenorrheal);
}

public static void woodsereKokoon(String mechlin_quenchable) {
	bedcapEpigram(mechlin_quenchable);
}

public static void bedcapEpigram(String shepherdling_indianist) {
	waterskinOverpromise(shepherdling_indianist);
}

public static void waterskinOverpromise(String dodecapartite_scribblingly) {
	wagangingBrookless(dodecapartite_scribblingly);
}

public static void wagangingBrookless(String aladinist_hydroxylamine) {
	hayweedDiscoglossoid(aladinist_hydroxylamine);
}

public static void hayweedDiscoglossoid(String probation_forgetfulness) {
	drivepipeVitreoelectric(probation_forgetfulness);
}

public static void drivepipeVitreoelectric(String ismy_tarsophalangeal) {
	ontologicSlangous(ismy_tarsophalangeal);
}

public static void ontologicSlangous(String extremistic_oophytic) {
	felicityWeeshy(extremistic_oophytic);
}

public static void felicityWeeshy(String brothy_capricornus) {
	unqualificationYorker(brothy_capricornus);
}

public static void unqualificationYorker(String bonduc_winking) {
	casuarinalesAte(bonduc_winking);
}

public static void casuarinalesAte(String cacique_antitrochanter) {
	cysticercoidSulphotoluic(cacique_antitrochanter);
}

public static void cysticercoidSulphotoluic(String lithifaction_reptatory) {
	takyrIsocyanurate(lithifaction_reptatory);
}

public static void takyrIsocyanurate(String applegrower_bafta) {
	encyclopedizeCatwise(applegrower_bafta);
}

public static void encyclopedizeCatwise(String steelhearted_practician) {
	isogeothermalVibrio(steelhearted_practician);
}

public static void isogeothermalVibrio(String went_muist) {
	gastroplicationPomatomus(went_muist);
}

public static void gastroplicationPomatomus(String rehale_japanophile) {
	hydropropulsionSemimachine(rehale_japanophile);
}

public static void hydropropulsionSemimachine(String winterberry_talitha) {
	dereisticallyPauperate(winterberry_talitha);
}

public static void dereisticallyPauperate(String cadwallader_pinakiolite) {
	shrimpyPriapulus(cadwallader_pinakiolite);
}

public static void shrimpyPriapulus(String stenocranial_refectorarian) {
	boceCatabolin(stenocranial_refectorarian);
}

public static void boceCatabolin(String pluricellular_chronical) {
	stairlessApotype(pluricellular_chronical);
}

public static void stairlessApotype(String inofficially_smithite) {
	competentnessCaritive(inofficially_smithite);
}

public static void competentnessCaritive(String boustrophedon_reducement) {
	adventualSaccharorrhea(boustrophedon_reducement);
}

public static void adventualSaccharorrhea(String paraglossia_unmistaken) {
	depigmentizeProdeportation(paraglossia_unmistaken);
}

public static void depigmentizeProdeportation(String palterer_inogenesis) {
	caloyerJoll(palterer_inogenesis);
}

public static void caloyerJoll(String previolate_coronofacial) {
	beanMelodic(previolate_coronofacial);
}

public static void beanMelodic(String altruist_mycomycete) {
	orbitozygomaticSpatulate(altruist_mycomycete);
}

public static void orbitozygomaticSpatulate(String collins_saltsprinkler) {
	tykenMicrobattery(collins_saltsprinkler);
}

public static void tykenMicrobattery(String lysogenic_intemperature) {
	proscriptionistUnhoist(lysogenic_intemperature);
}

public static void proscriptionistUnhoist(String robustic_baluba) {
	fluxiblenessSpirochetemia(robustic_baluba);
}

public static void fluxiblenessSpirochetemia(String laterad_tabella) {
	crossbowmanFibrocaseous(laterad_tabella);
}

public static void crossbowmanFibrocaseous(String procuratorate_firmamental) {
	overcustomCarpogone(procuratorate_firmamental);
}

public static void overcustomCarpogone(String benj_butyrically) {
	doggishlyMagnetimeter(benj_butyrically);
}

public static void doggishlyMagnetimeter(String orrhology_sexagenary) {
	whirlbonePlenitude(orrhology_sexagenary);
}

public static void whirlbonePlenitude(String bochism_chordal) {
	paratypicallyIncuriousness(bochism_chordal);
}

public static void paratypicallyIncuriousness(String kamarezite_mucky) {
	exanimationHemidactylus(kamarezite_mucky);
}

public static void exanimationHemidactylus(String silvertop_stain) {
	popeyeJusticiar(silvertop_stain);
}

public static void popeyeJusticiar(String wearable_triblet) {
	megaeraUnalachtigo(wearable_triblet);
}

public static void megaeraUnalachtigo(String tsuga_bulbed) {
	pediferousRecancel(tsuga_bulbed);
}

public static void pediferousRecancel(String pseudospiracle_notation) {
	arrowwoodPaternoster(pseudospiracle_notation);
}

public static void arrowwoodPaternoster(String fluorate_coassume) {
	saturnaliaProtosulphide(fluorate_coassume);
}

public static void saturnaliaProtosulphide(String abominate_danube) {
	antiphthisicLiberalistic(abominate_danube);
}

public static void antiphthisicLiberalistic(String unsalt_lecanora) {
	historiographerRusticator(unsalt_lecanora);
}

public static void historiographerRusticator(String ungrain_pollicar) {
	numerantDetestable(ungrain_pollicar);
}

public static void numerantDetestable(String lemurid_abas){Tracer.tracepointWeaknessStart("CWE572","A","Call to Thread run() instead of start()");Tracer.tracepointMessage("Creating thread");final PrintStream stonesoup_crash_output=ArrayUtil.decadencyUnfain;Thread stonesoup_thread1=new Thread(new HelloRunnable(lemurid_abas,ArrayUtil.decadencyUnfain));stonesoup_thread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){@Override public void uncaughtException(Thread t,Throwable e){Tracer.tracepointError("WARNING: Worker thread crashed with uncaught exception.");stonesoup_crash_output.println("WARNING: Worker thread crashed with uncaught exception.");e.printStackTrace(stonesoup_crash_output);}});try {Tracer.tracepointMessage("CROSSOVER-POINT: BEFORE");Tracer.tracepointMessage("TRIGGER-POINT: BEFORE");stonesoup_thread1.run();Tracer.tracepointMessage("CROSSOVER-POINT: AFTER");Tracer.tracepointMessage("TRIGGER-POINT: AFTER");} catch (RuntimeException e){Tracer.tracepointError("The thread startup raised an excpetion.  " + e.getClass().getName()+": "+e.getMessage());ArrayUtil.decadencyUnfain.println("The thread startup raised an exception.  This should never happen.");e.printStackTrace(ArrayUtil.decadencyUnfain);throw e;}try {Tracer.tracepointMessage("Joining thread-01");stonesoup_thread1.join();Tracer.tracepointMessage("Joined thread-01");} catch (InterruptedException e1){Tracer.tracepointError(e1.getClass().getName() + ": "+e1.getMessage());ArrayUtil.decadencyUnfain.println("Failed to join the worker thread.");e1.printStackTrace(ArrayUtil.decadencyUnfain);} finally {ArrayUtil.decadencyUnfain.println("Worker thread terminated.");}}

public static class HelloRunnable implements Runnable {
	private PrintStream output;
	private String value;

	public void run() {
		Tracer.tracepointLocation(
				"/tmp/tmpdRBGQj_ss_testcase/src/core/src/java/org/apache/lucene/util/ArrayUtil.java",
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
			output.printf("File \"%s\" does not exist\n", filePath.getPath());
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
				"/tmp/tmpdRBGQj_ss_testcase/src/core/src/java/org/apache/lucene/util/ArrayUtil.java",
				"HelloRunnable.ctor");
		this.value = value;
		this.output = output;
	}
}

}
