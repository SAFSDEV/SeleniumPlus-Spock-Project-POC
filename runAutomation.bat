:: 
::  -------- General BAT System Setting --------
:: 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
@echo off
setlocal enableDelayedExpansion
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



:: 
::  -------- Integrate complicated Java commands into BAT variable --------
:: 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
::  Get the directory of remote selenium server, i.e. selenium-standalone*.jar.
set max=0
for /f "tokens=1* delims=-.0" %%A in ('dir /b /a-d %SELENIUM_PLUS%\libs\selenium-server-standalone*.jar') do if %%B gtr !max! set max=%%B
set SELENIUM_SERVER_JAR_LOC=%SELENIUM_PLUS%\libs\selenium-%max%

::  Get the 3 JAR files, which are used to run the SeleniumPlus test case from java command line:
::  	1. seleniumplus.jar
::  	2. JSTAFEmbedded.jar
::  	3. selenium-standalone*.jar.
::  The 'seleniumplus.jar' should be always at the first position.
::  
set CMDCLASSPATH="%SELENIUM_PLUS%\libs\seleniumplus.jar;%SELENIUM_PLUS%\libs\JSTAFEmbedded.jar;%SELENIUM_SERVER_JAR_LOC%"

:: Get the directory of Java, which is included in the directory of 'SeleniumPlus'.
set EXECUTE=%SELENIUM_PLUS%/Java/bin/java
:: DON'T MODIFY ABOVE SETTING UNLESS NECESSARY
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



:: 
::  -------- Compile the project --------
:: 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
REM set COMPILE=%SELENIUM_PLUS%\Java\bin\javac.exe
REM rmdir /s /q bin
REM mkdir bin
REM :: caret ^ is just used to escape the newline so that we can write a dos command in multiple lines
REM "%COMPILE%" -cp %CMDCLASSPATH% -encoding UTF-8 -d bin -nowarn src/com/sas/spock/safs/runner/tests/*.java ^
REM                                                               src/com/sas/spock/suites/*.java ^
REM 															  src/com/sas/spock/tests/*.java
REM Echo "Project has been compiled." 
REM 
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



:: 
::  -------- Examples with all kinds of parameters --------
:: 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: How to override App Map variable
:: EXAMPLE:  %EXECUTE% -cp %CMDCLASSPATH%;bin sample.testruns.TestRun1 -safsvar:GoogleUser=email@gmail.com

:: How to load external App Map order or Map file
:: EXAMPLE:  %EXECUTE% -cp %CMDCLASSPATH%;bin -Dtestdesigner.appmap.order=AppMap_en.order <package name>.TestRun1
:: EXAMPLE:  %EXECUTE% -cp bin;%CMDCLASSPATH% -Dtestdesigner.appmap.files=AppMap.map,AppMap_en.map <package name>.TestRun1

:: How to send email result
:: EXAMPLE:  %EXECUTE% -cp %CMDCLASSPATH% org.safs.tools.mail.Mailer -host mail.server.host -port 25 -from from@exmaple.com -to to1@exmaple.com;to2@example.com -subject "Test" -msg "Check msg in details" -attachment c:\seleniumplus\sample\logs\testcase1.xml;logs\testcase1.txt
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



:: 
::  -------- Running the project --------
:: 
::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
::
:: For example, the '<package.name>' below can be 'com.sas.spock.tests'.
%EXECUTE% -cp %CMDCLASSPATH%;bin <package.name>.TestCase1
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
