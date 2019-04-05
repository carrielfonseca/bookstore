Project from Java III course at Concordia

bookstore website. Java Server Faces Project (JSF) in Maven

This project uses the following components: tommee as a server (extension of TOMCAT), openJPA, an open version of the Java Persistence API, and the Java Server Face framework.

1-) Run the mysql file ebook.sql in the folder src\main\resources to create the database and the tables for the application (you need mysql installed in your computer)

2-) Install the tomee server in http://tomee.apache.org/downloads.html  (get the zip file)

3-) After compiling the project, open-jpa should have been added to the project by Maven. If this is not the case, manually add the jar file. It should be in the path C:\Users\Admin\.m2\repository\org\apache\openjpa\openjpa-all\2.3.0  

4-) In the folder C:\apache-tomee-webprofile-1.6.0\conf (or whichever version you have), there will be a file named tomee.xml. This file contains resources information, such as the username and password for mysql, the path to the database created and the id of the resource (see example file in the root folder)

5-) In the folder C:\apache-tomee-webprofile-1.6.0\lib, put the additional jar files found in the folder TomEELibAdditions

6-) In the login landing page, type consumer for the user and concordia for the password

Reinstalling SQL in Windows 7:
When trying to reinstall the SQL, you may run into a problem of not having the previous databases deleted. Even if you have uninstalled Mysql, the program will show an error if these databases are not deleted. To do so, the databases are in a hidden folder called ProgramData. To show it, go in Windows Explorer ->Organize -> Folder and Search Options-> View Tab -> Check show Hidden files, folders and drivers. Click OK 

Net Beans and SQL
In the SQL part:
GRANT ALL PRIVILEGES ON JPAEXAMPLE TO "root"@"%" IDENTIFIED BY "anaefabio";
GRANT ALL PRIVILEGES ON JPAEXAMPLE TO "root"@"localhost" IDENTIFIED BY "anaefabio";
This code changes the password! 
In case that the user hasn’t really set up a password, professor has taught how to actually Grant All to everyone. 

Tomme Files:
Go to Apache Tomme on the internet and download the file 1.6.0 web profile
http://tomee.apache.org/downloads.html
Install the downloaded file and add a TomCat server in the services tab by providing the path.
The lib folder is extremely important. It is where your library is placed. Get all the extra files that Ken (professor) has provided and place it there as well. We have named this server tome. Its port is 8080.
To run the very first file, “JSPServletExample01” do a Clean and Build. This should make it executable, since Maven will bring all the necessary files for you.
The tomee.xml file
In the folder C:\apache-tomee-webprofile-1.6.0\conf, there will be a file named tomee.xml. This is an extremely important file, which contains resources information, such as the username and password for mysql, the path to the database created and the id of the resource.
I believe that the id is important so it can be referenced in the persistence file!

The welcome tag
In the WEB-INF folder, the <welcome-file> tag indicates the first file that will be displayed once you run the application
  
The Persistence Unit

Professor uses a Persistence Library that is not so popular. It is called Open JPA. This library is not built-in Net-Beans. You need to add this library before adding the Persistence Unit. Do the following steps:
•	In Class 2, there is a project in there called JPASetUpDemo. In the POM file, this project contains a dependency to bring Open JPA. Just do Clean and Build for this project and the open JPA jar should be brought to you automatically by Maven. The SQL for this project is actually in another project called JPAWebDemo (the jipdata)
•	C:\Users\Admin\.m2\repository\org\apache\openjpa\openjpa-all\2.3.0 
is the path where openJPA should be after you did the Clean and Build. In Netbeans, do:
Tools->Ant Libraries->Add JAR Folder and put it there.
•	Right-Click in the project ->Others -> Persistence Folder ->Persistence Unit.
Specify what options NetBeans provide to you and finalize. The Persistence file will be created in the Resources folder of the project.
•	Open the persistence file and see it on its xml view in the “Source” option. Include a <jta-data-source> jipdata </jta-data-source> tag AND exclude the properties. Inside the tag <jta-data-source>, you should put the id that you have specified it in the tomee.xml.
•	Delete the transaction-type="RESOURCE_LOCAL"
Adding your entity
To finally add your entity (NetBeans generate the Beans for you), 
•	Right-Click in the project ->Others -> Persistence Folder -> Entity Classes from Database.
•	The name of the package should end with entities
•	Uncheck the option generate JAXB Annotations
•	Check Fully Qualified Database Table Names
•	Put a Collection Type as a List
•	Click Finish
•	Once the entities have been generated, the persistence file might have been altered. Check if this is true and delete if you want the changes (generally it includes <class> tags

Refresh and undeploy
Always keep in mind that, once some configurations have been changed, it might be interesting for you to refresh and undeploy in Services->Servers




