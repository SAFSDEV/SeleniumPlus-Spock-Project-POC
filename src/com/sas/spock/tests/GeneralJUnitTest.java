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
		Assert.Equals(a, b);
	}
	
	@Test
	public void selenium_Assert_fail() {
		//This test will fail
		Assert.Equals(a, c);
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
