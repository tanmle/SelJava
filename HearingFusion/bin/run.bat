cd D:\Sandbox\Job\HF\HearingFusion
set ProjectPath=D:\Sandbox\Job\HF\HearingFusion
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\src\resource\runTestcase.xml