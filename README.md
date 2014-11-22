Group-8
=======

22nd November 2014
-------------------------------
All uml diagrams in folder uml
All test cases in src/test/java/bits/ewallet/
All source packages in src/main/java/bits/ewallet
All view pages(JSP's) in  src/main/webapp/WEB-INF/view
All dependencies added to pom.xml file
Spring loaded via web.xml in src/main/webapp/WEB-INF

Description of source packages:
--------------------------------------------
entity - contains all View Objects(entities) as they appear in database tables. All entities contain fields corresponding to columns and getters and setters.

repository - contains all crud methods for respective entities.

service - contains business logic of code

controller - contains all controller methods for rendering model and view to JSP's

Requirements
------------------------
Tomcat server
Postgresql Database

Instructions to run the project
---------------------------------------
Make a database in postgresql and enter the database credentials in the properties file in home folder.
Open the project in IDE (Netbeans preferably) and click on build project.
Maven will download all required dependencies in the dependencies directory.
When all dependencies are added, go to tomcat properties and in VM options, mention the location of the ewallet.properties file.
Now run the project and the war will be deployed on the server on localhost and the specified port.

-----------------------------------------------------------------------------------------------------------------------


9th November 2014
-------------------------------
All uml diagrams moved to folder uml
All test cases in src/test/java/bits/ewallet/
All dependencies added to pom.xml file
Spring loaded via web.xml in src/main/webapp/WEB-INF
TO run the project edit the ewallet.properties file. Remove comments and give username and password and database name at appropriate places. Then set path of the file in tomcat(or any other server) VM options.

Test Cases
All tests are in the package src/test/java/bits/ewallet/
All entity Test cases will run unconditionally
To run test cases for repository, database setting is required along with the following changes in the source code:
As properties file is loaded from tomcat environment, Test cases will not work with this setting. To run tests, open the spring-data.xml file in src/main/resources/spring and edit the following lines.

p:driverClass="${app.jdbc.driverClassName}"
p:jdbcUrl="${app.jdbc.url}"
p:user="${app.jdbc.username}"
p:password="${app.jdbc.password}"

enter the values directly instead of reading from properties file.
