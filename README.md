bookstore website. Java Server Faces Project (JSF) in Maven

This project uses the following components: tommee as a server (extension of TOMCAT), openJPA, an open version of the Java Persistence API, and the Java Server Face framework.

1-) Run the mysql file ebook.sql in the folder src\main\resources to create the database and the tables for the application (you need mysql installed in your computer)

2-) Install the tomee server in http://tomee.apache.org/downloads.html  (get the zip file)

3-) After compiling the project, open-jpa should have been added to the project by Maven. If this is not the case, manually add the jar file. It should be in the path C:\Users\Admin\.m2\repository\org\apache\openjpa\openjpa-all\2.3.0  

4-) In the folder C:\apache-tomee-webprofile-1.6.0\conf (or whichever version you have), there will be a file named tomee.xml. This file contains resources information, such as the username and password for mysql, the path to the database created and the id of the resource (see example file in the root folder)

5-) In the folder C:\apache-tomee-webprofile-1.6.0\lib, put the additional jar files found in the folder TomEELibAdditions


