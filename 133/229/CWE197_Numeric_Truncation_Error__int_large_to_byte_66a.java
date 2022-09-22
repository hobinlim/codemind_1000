/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__int_large_to_byte_66a.java
Label Definition File: CWE197_Numeric_Truncation_Error__int.label.xml
Template File: sources-sink-66a.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: large Set data to a number larger than Short.MAX_VALUE
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */




public class CWE197_Numeric_Truncation_Error__int_large_to_byte_66a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        int data;

        /* FLAW: Use a number larger than Short.MAX_VALUE */
        data = Short.MAX_VALUE + 5;

        int[] dataArray = new int[5];
        dataArray[2] = data;
        (new CWE197_Numeric_Truncation_Error__int_large_to_byte_66b()).badSink(dataArray  );
    }        

    public void good() throws Throwable
    {
        goodG2B();
    }        

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        int[] dataArray = new int[5];
        dataArray[2] = data;
        (new CWE197_Numeric_Truncation_Error__int_large_to_byte_66b()).goodG2BSink(dataArray  );
    }        

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }        
}        
