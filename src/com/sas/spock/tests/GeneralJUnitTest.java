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
	public void test1() {
		Assert.Equals(a, b);
	}
	
	@Test
	public void test2() {
		//This test will fail
		Assert.Equals(a, c);
	}
	
	@After
	public void cleanUp() {
		a = null;
		b = null;
		c = null;
	}

}
