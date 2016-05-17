package com.sas.spock.tests;

import org.safs.IndependantLog;
import org.safs.selenium.webdriver.SeleniumPlus;

import com.sas.spock.Map;

/** 
 * Used to hold a number of related testcase methods invocable from any class needing them. 
 * <p>
 * To execute as a SeleniumPlus Unit testfor this class, the runTest() method must exist and 
 * should contain appropriate testcase method invocations. 
 * The following JARs must be in the JVM CLASSPATH for such a Unit test invocation. 
 * This is the same as any other SeleniumPlus test invocation: 
 * <pre>
 * 	 pathTo/yourClasses/bin or yourTest.jar,
 * 	 pathTo/seleniumplus.jar,
 * 	 pathTo/JSTAFEmbedded.jar, (or JSTAF.jar if using STAF and other external tools or engines.)
 * </pre>
 * Then, you can execute this test with an invocation similar to:
 * <pre>
 * 	 java -cp %CLASSPATH% com.sas.spock.tests.TestCase1
 * </pre>
 * 
 * @see org.safs.selenium.webdriver.SeleniumPlus#main(java.lang.String[])
 */ 
public class TestCase1 extends SeleniumPlus {


	/* 
	 * Insert (generally) static testcase methods below. 
	 * You call these from your TestRun runTest() method for normal testing, 
 	 * your TestCase runTest() method for Unit testing, 
	 * or from other testcases, testcase classes, or anywhere they are needed. 
	 */ 



	/** 
	 * Normally not used for TestCase classes. 
	 * Can be used to implement a Unit test for this TestCase class, or as a test suite. 
	 * <p>
	 * Within this method, add calls to the testcase methods you wish to execute. 
	 * You are not limited to calling methods in this class only. 
	 * <p>
	 * @see org.safs.selenium.webdriver.SeleniumPlus#main(java.lang.String[])
	 */
	@Override
	public void runTest() throws Throwable {

		Logging.LogMessage("Normal runTest() execution.");
		IndependantLog.info("Normal runTest() execution.");
		
		//TODO In SpockExperiment, we call SeleniumPlus API, then the TestRecord of keyword CallScript
		//will be over wrote by the last SE+ execution in SpockExperiment.
		//We need to find a way to fix this.
		Misc.CallScript("com.sas.spock.tests.SpockExperiment");

		//Test to run with general JUnit test
		Misc.CallScript("com.sas.spock.tests.GeneralJUnitTest");
		
	}
	
	/** 
	 * Normally not used for TestCase classes. 
	 * This is the entry point for the automatic execution of this SeleniumPlus test 
	 * when executed from the command-line outside of the SeleniumPlus IDE. 
	 * <p>
	 * This will be called automatically by the Java JVM if this class is invoked from the command-line by Java. 
	 * <p>
	 * This method should not be altered by the user. 
	 * <p>
	 * @see org.safs.selenium.webdriver.SeleniumPlus#main(java.lang.String[])
	 */
	public static void main(String[] args) { SeleniumPlus.main(args); }
}
