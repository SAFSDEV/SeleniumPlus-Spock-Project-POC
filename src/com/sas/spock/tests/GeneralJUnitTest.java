package com.sas.spock.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.safs.selenium.webdriver.SeleniumPlus.Assert;

public class GeneralJUnitTest {
	private String a = null;
	private String b = null;
	private String c = null;
	
	@Before
	public void init() {
		a = "a test string";
		b = "a test string";
		c = "a different test string";
	}
	
	@Test
	public void selenium_Assert_pass() {
		boolean condition = Assert.Equals(a, b);
		org.junit.Assert.assertTrue("The string '"+a+"' doesn't match string '"+b+"'", condition);
	}
	
	/**
	 * This test (SE+ Assert) will fail. It is used to prove that SE+ test could run within JUnit Test.<br>
	 * It will only write failure message to SAFS Log. The normal JUnit test will NOT reflect this error.<br>
	 * To get a consistent JUnit test report, we test the result returned by SE+ Assert by org.junit.Assert.<br>
	 */
	@Test
	public void selenium_Assert_fail() {
		boolean condition = Assert.Equals(a, c);
		org.junit.Assert.assertTrue("The string '"+a+"' doesn't match string '"+c+"'", condition);
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
