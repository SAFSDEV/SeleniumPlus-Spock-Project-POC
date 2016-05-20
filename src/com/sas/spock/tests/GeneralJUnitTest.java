package com.sas.spock.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.safs.SAFSException;
import org.safs.model.tools.RuntimeDataAware;
import org.safs.selenium.webdriver.SeleniumPlus;
import org.safs.tools.RuntimeDataInterface;

/**
 * This JUnit test provides examples of using SeleniumPlus.Asserts, JUnit.Asserts, and pure Java asserts.
 * <p>
 * The class also implements RuntimeDataAwareness to demonstrate access to key SAFS App Map and Variables services 
 * from within the JUnit test.
 * 
 * @author Carl Nagle
 */
public class GeneralJUnitTest implements RuntimeDataAware {
	private String a = null;
	private String b = null;
	private String c = null;

	// auto-injection at SAFS/SeleniumPlus initialization should provide this
	// use it to getAppMapItem, getVariable, setVariable in SAFS services.
	static RuntimeDataInterface safsdata = null;
	
	/** 
	 * Auto-injection automatically calls this during framework initialization so that the class 
	 * already has the needed helper object at runtime.
	 */
	@Override
	public void setRuntimeDataInterface(RuntimeDataInterface helper) {
		safsdata=helper;
	}

	@Before
	public void init() {
		a = "a test string";
		b = "a test string";
		c = "a different test string";
		
		try{
			safsdata.setVariable("a", a);
			safsdata.setVariable("b", b);
			safsdata.setVariable("c", c);
		}catch(SAFSException ignore){}
	}
	
	@Test
	public void selenium_Assert_pass() {
		boolean condition = SeleniumPlus.Assert.Equals(a, b);
		Assert.assertTrue("The string '"+a+"' doesn't match string '"+b+"'", condition);		
	}
	
	@Test
	public void selenium_vars_Assert_pass() {
		try{
			String sa = safsdata.getVariable("a");
			String sb = safsdata.getVariable("b");
			boolean condition = SeleniumPlus.Assert.Equals(sa, sb);
			Assert.assertTrue("SAFSVAR ^a '"+ sa +"' did not match SAFSVAR ^b '"+ sb +"'",condition);
		}catch(SAFSException x){
			Assert.fail(x.getClass()+", "+x.getMessage()+", retrieving and comparing SAFS Variables ^a, ^b.");
		}
	}
	
	/**
	 * This test (SE+ Assert) will fail. It is used to prove that SE+ test could run within JUnit Test.<br>
	 * It will only write failure message to SAFS Log. The normal JUnit test will NOT reflect this error.<br>
	 * To get a consistent JUnit test report, we test the result returned by SE+ Assert by org.junit.Assert.<br>
	 */
	@Test
	public void selenium_Assert_fail() {
		boolean condition = SeleniumPlus.Assert.Equals(a, c);
		Assert.assertTrue("The string '"+a+"' doesn't match string '"+c+"'", condition);
	}
	
	/**
	 * This test (SE+ Assert) will fail. It is used to prove that SE+ test could run within JUnit Test.<br>
	 * It will only write failure message to SAFS Log. The normal JUnit test will NOT reflect this error.<br>
	 * To get a consistent JUnit test report, we test the result returned by SE+ Assert by org.junit.Assert.<br>
	 */
	@Test
	public void selenium_vars_Assert_fail() {
		try{
			String sa = safsdata.getVariable("a");
			String sc = safsdata.getVariable("c");
			boolean condition = SeleniumPlus.Assert.Equals(sa, sc);
			Assert.assertTrue("SAFSVAR ^a '"+ sa +"' did not match SAFSVAR ^c '"+ sc +"'",condition);
		}catch(SAFSException x){
			Assert.fail(x.getClass()+", "+x.getMessage()+", retrieving and comparing SAFSVARs ^a, ^c.");
		}	
	}
	
	/**
	 * This test using Java assert will only fail if assertions are enabled for this class:
	 * <p>
	 * requires JVM arg: -ea:com.sas.spock.tests.GeneralJUnitTest
	 * <p>
	 * Otherwise, with Java assertions disabled by default,this assert test never actually happens at all.
	 */
	@Test
	public void java_assert_fail() {
		//This test will fail if assertions are enabled
		// JVM command-line arg: -ea:com.sas.spock.tests.GeneralJUnitTest
		assert a==c:"compare a==c failed";
	}
	
	@After
	public void cleanUp() {
		a = null;
		b = null;
		c = null;
	}
}
