# fms-automation

Dependency :
1. JDK, JRE 17 verision
2. Maven 3.8.6 version
Above dependency needs to be install 


Test NG, Log4j, ExtentReport, Selenium, Apache POI, RestAssured Dependency Already Added in Project 


Check the version 
Open Command prompt 
for Java version : java -version
it will show jdk and jre version

for Maven version : mvn -version
it will show maven version


To access Project :
1. Clone the Repository
2. Open IDE(like Eclipse)
3. Change workspace and select Repository folder which created after clone
4. Import project using import and root folder path
5. Project will appear in Project Explorer


Project Structure : 
Package : Src/main/java 
1. Project.Config : It contains Log4j and RunConfig properties file
                    Log4j consist the logger configuration
                    RunConfig contains browser and URL where test script will run
                    
2. Project.Constant : It constains overall variable required through out script
                      like file name etc
                      
3. Project.Report : It contains ExtendReport Listners which will track test case result and events
                    It is also reposible to capture screenshot and trigger mail
                    
4. Project.Utility : It contains overall utility required for test script
                     Configuration Setup class contains before and after suite where browser setup and other configuration done
                     WebPage Object Creation class contains the creation of web page objects
                     Object Repository class will hold the WebPage Object Creation instance through out script inorder to access different page object using same instance
                     Excel Utility class is configured to perform excel operation
                     Page Load Time class will hold the instance which contains all pages loading time data so at the end we can push that data into excel
                     Email Cofig, Uitlity and Attachement sender files responsible to configure mail body and attachement and sent mail
                     
5. Project.WebPage : It contains all web pages classes and each class contains the overall functionality of that page
                     like login page contains login functionality
                     
    
Package : Src/test/java    
1. Project.testscenarios : It contains all the script which contains test cases

Folders :
1. Excel Input : It contains excel file which will be use as input data for test script
2. Excel Output: It contains excel file which has page loading time data
3. Logs        : It contains application.log file which consist the logs 
4. Reports     : It contains extent Report where we can visualize test reports and its status and time taken
5. Screenshot  : It contains fail test cases screenshot


Files :
1. pom.xml    : It contains the all dependency required for project and plugins to generate build
2. testng.xml : It contains the test suite which contains test script name in order to execute


Run the Project

First way, Right click on pom.xml -> Run As -> Maven Clean
           Right click on pom.xml -> Run As -> Maven install

Second way, open command project and go to project directory
           hit command as :  mvn clean install

