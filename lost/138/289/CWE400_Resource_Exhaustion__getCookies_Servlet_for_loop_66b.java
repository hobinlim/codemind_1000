/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__getCookies_Servlet_for_loop_66b.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: getCookies_Servlet Read count from the first cookie using getCookies()
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: for_loop
 *    GoodSink: Validate count before using it as the loop variant in a for loop
 *    BadSink : Use count as the loop variant in a for loop
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */




import javax.servlet.http.*;

public class CWE400_Resource_Exhaustion__getCookies_Servlet_for_loop_66b
{
    public void badSink(int countArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count = countArray[2];

        int i = 0;

        /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
        for (i = 0; i < count; i++)
        {
            IO.writeLine("Hello");
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(int countArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count = countArray[2];

        int i = 0;

        /* POTENTIAL FLAW: For loop using count as the loop variant and no validation */
        for (i = 0; i < count; i++)
        {
            IO.writeLine("Hello");
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(int countArray[] , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int count = countArray[2];

        int i = 0;

        /* FIX: Validate count before using it as the for loop variant */
        if (count > 0 && count <= 20)
        {
            for (i = 0; i < count; i++)
            {
                IO.writeLine("Hello");
            }
        }

    }
}
