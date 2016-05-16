# SeleniumPlus-Spock-Project-POC
SeleniumPlus Project Example for Core groovy_spock_support_poc

SeleniumPlus installation must be customized/modified as shown below:

1. Eclipse PlugIn for Groovy must be installed: 
   SeleniumPlus Eclipse is KEPLER.
   Groovy Eclipse Plugin 2.9.1.xx with Groovy Runtime Plugin 2.3.7.xx for KEPLER

2. SeleniumPlus\libs needs:
   groovy-2.3.11.jar
   spock-core-1.0-groovy-2.3.jar
   (optional/future) groovy-jsr223-2.3.11.jar
   
There currently appear to be intermittent issues with the Project's Groovy and Selenium+ Natures butting heads.
For example, sometimes the automatic code completion really wants to stick with Groovy assets and SeleniumPlus 
assets have to be dutifully coerced into code completion.

The -script:classname command-line parameter to make this work in SeleniumPlus is subject to change.
For example, initially it was intended to assume a spock/groovy class, but since the current implementation 
is to just go run a JUnitCore test with that Class name, it can be ANY type of JUnit test.

So, the command-line parameter will likely be changed in the near future to show this.
