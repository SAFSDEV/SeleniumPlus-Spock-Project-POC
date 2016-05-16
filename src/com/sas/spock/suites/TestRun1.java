package com.sas.spock.suites;

import org.safs.selenium.webdriver.SeleniumPlus;
import com.sas.spock.Map;

/** 
 * Used to hold a number of related testcase methods invocable from any class needing them. 
 * For such a TestRun class, this may be certain setup and teardown methods used prior to calling 
 * the testcase methods of other TestCase classes. 
 * <p>
 * Ultimately, it is the runTest() method that is important in this class. 
 * It is the runTest() method that is going to be automatically invoked at runtime to kickoff the test. 
 * <p>
 * To execute as a SeleniumPlus test, the following JARs must be in the JVM CLASSPATH:
 * <pre>
 * 	 pathTo/yourClasses/bin or yourTest.jar,
 * 	 pathTo/seleniumplus.jar,
 * 	 pathTo/JSTAFEmbedded.jar, (or JSTAF.jar if using STAF and other external tools or engines.)
 * </pre>
 * Then, you can execute this test with an invocation similar to:
 * <pre>
 * 	 java -cp %CLASSPATH% com.sas.spock.suites.TestRun1
 * </pre>
 * 
 * @see org.safs.selenium.webdriver.SeleniumPlus#main(java.lang.String[])
 */ 
public class TestRun1 extends SeleniumPlus {

	/* 
	 * Insert (generally) static testcase methods or setup/teardown methods below. 
	 * You call these from your runTest() method for normal testing, 
 	 * or from other testcases, testcase classes, or anywhere they are needed. 
	 */ 



	/** 
	 * This is the entry point for the automatic execution of a SeleniumPlus test. 
	 * This will be called automatically and is not normally invoked by the developer. 
	 * <p>
	 * Within this method, add calls to the testcase methods you wish to execute for this test. 
	 * <p>
	 * @see org.safs.selenium.webdriver.SeleniumPlus#main(java.lang.String[])
	 */
	@Override
	public void runTest() throws Throwable {











	}


	/** 
	 * This is the entry point for the automatic execution of this SeleniumPlus test 
	 * when executed from the command-line outside of the SeleniumPlus IDE. 
	 * <p>
	 * This will be called automatically by the Java JVM when this class is invoked from the command-line by Java. 
	 * <p>
	 * This method should not be altered by the user. 
	 * <p>
	 * @see org.safs.selenium.webdriver.SeleniumPlus#main(java.lang.String[])
	 */
	public static void main(String[] args) { SeleniumPlus.main(args); }
}
