** This assisgnment gives about opening the google page and focus on searching with two city searches **
Note: This assignment can be tested only with windows

** Pre-requisite installation**
Java 1.8 or higher
Maven 3.x

** Environment variables to be set - Preferably System Variables**
JAVA_HOME = <Path to Java Home>
<M2_HOME> = <Path to Maven Home>
Path = %JAVA_HOME%\bin;%M2_HOME%\bin;%PATH%


Commands to run the assignment

** This assignment opens a browser with google and makes a seach with 2 values **
mvn verify -Pgoogle-search-runner

** This assignment opens a browser with expedia.com and makes a sample booking and banking page is validated **
mvn verify -Pflight-search-runner


Alternate way to run

Run the GoogleRunner.java file in Eclipse/Intellij IDE and test the google search feature
Run the FlightRunner.java file in Eclipse/Intellij IDE and test the flight search feature




