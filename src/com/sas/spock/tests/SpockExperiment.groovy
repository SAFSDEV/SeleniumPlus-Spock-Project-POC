
package com.sas.spock.tests;

import org.safs.selenium.webdriver.SeleniumPlus;
import com.sas.spock.Map;

import spock.lang.*

public class SpockExperiment extends Specification{

	def "logging into google"() {
		
		given:
		
			SeleniumPlus.StartWebBrowser(Map.GoogleURL(), Map.GoogleBrowser(), "chrome")
			SeleniumPlus.WaitForGUI(com.sas.spock.Map.GoogleHome.SignInButton, 5)
			SeleniumPlus.Click(Map.GoogleHome.SignInButton)
			SeleniumPlus.WaitForGUI(Map.GoogleLogin.EmailText, 5)
		
		when:
		
			SeleniumPlus.Pause(3)
		
		then:
		
			SeleniumPlus.StopWebBrowser(Map.GoogleBrowser())
	}
	
	def "computing the maximum of two numbers"() {
		
		expect:
		
			Math.max(a, b) == c
		  
		where:
			
			a << [5, 3]
			b << [1, 9]
			c << [5, 9]
	  }	
}
