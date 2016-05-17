# SeleniumPlus-Spock-Project-POC

This Project is intended to be a temporary playground for the developers and other interested parties of the SAFS/SeleniumPlus Spock/Groovy integration project.  Because this Spock/Groovy integration project is relatively new, it is subject to spectacular breaking changes to an evolving API and implementation.

The instructions for preparing an existing SeleniumPlus install are subject to change and can result in PlugIns being added, removed, or modified.  This is something normal SeleniumPlus users should NOT do to their normal "production" SeleniumPlus systems as it is entirely possible to "break" these Eclipse installations.

The SeleniumPlus JARS associated with this Spock/Groovy integration project are NOT the production SeleniumPlus JARS from 'master'.  The SeleniumPlus system is modified with SAFSDEV/Core BRANCH 'groovy_spock_support_poc'.

SeleniumPlus installation must be customized/modified as shown below:

1. Eclipse PlugIn for Groovy must be installed: <br>
   SeleniumPlus Eclipse is KEPLER.<br>
   Groovy Eclipse Plugin Groovy Runtime 2.4.3 for KEPLER<br>
   Eclipse PlugIn Software Site: http link: dist.springsource.org/snapshot/GRECLIPSE/e4.3/<br>


2. SeleniumPlus\libs needs:<br>
   spock-core-1.0-groovy-2.4.jar

There currently appear to be intermittent issues with the Project's Groovy and Selenium+ Natures butting heads.
For example, sometimes the automatic code completion really wants to stick with Groovy assets and SeleniumPlus 
assets have to be dutifully coerced into code completion.

The -script:classname command-line parameter to make this work in SeleniumPlus is subject to change.
For example, initially it was intended to assume a spock/groovy class, but since the current implementation 
is to just go run a JUnitCore test with that Class name, it can be ANY type of JUnit test.

So, the command-line parameter will likely be changed in the near future to show this.

In the POC project, there is TestCase1 setup as a Run Configuration with a command-line argument to use –script to run the Spock test.

Without the command-line –script setting it is just a normal SeleniumPlus test.  With it, runTest() is bypassed in favor of the Junit test class 'com.sas.spock.tests.SpockExperiment'

In the Project src, this is a .groovy file, but Groovy compiles it into the SpockExperiment class file.
