/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE398_Poor_Code_Quality__semicolon_02.java
Label Definition File: CWE398_Poor_Code_Quality.label.xml
Template File: point-flaw-02.tmpl.java
*/
/*
* @description
* CWE: 398 Indicator of Poor Code Quality
* Sinks: semicolon
*    GoodSink: Removed statement that has no effect
*    BadSink : A statement that has no effect
* Flow Variant: 02 Control flow: if(true) and if(false)
*
* */





public class CWE398_Poor_Code_Quality__semicolon_02 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        if (true)
        {
            ; /* FLAW: This semicolon is a statement that has no effect */
            IO.writeLine("Hello from bad()");
        }
    }

    /* good1() changes true to false */
    private void good1() throws Throwable
    {
        if (false)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            IO.writeLine("Benign, fixed string");
        }
        else
        {

            /* FIX: Do not include semicolon (statement that has no effect) */

            IO.writeLine("Hello from good()");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if (true)
        {
            /* FIX: Do not include semicolon (statement that has no effect) */
            IO.writeLine("Hello from good()");
        }
    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
