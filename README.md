Multiple Database Handling Exercise

Import as maven project in eclipse.

Build Spring-Boot Application

Update below database settings in application.properties file (Need to use superadmin):

app.datasource.jdbcUrl=jdbc:postgresql://localhost:5432/postgres
app.datasource.username=postgres
app.datasource.password=postgres

Run As Java Application: MultiDBDemoApplication

Go to URL to run project: http://localhost:8080/demo

Follow Below Steps:
(1) Create New Database
	-Internally it will create new database
	-Create new user
	-Assign grant to user for this database
	
Note: Here system stores database information in class DatabaseInfoRegistry
	
(2) Create New Table
	-Internally it will create new table
	-Insert dummy record into the table
	
Note: While creating table, system stores DataSource information in class DatasourceRegistry.
Datasource will be initialized only once for each database and for subsequent requests, same object from the registry will be used.

**********

Here, Don`t directly create table schema which are pre-existing. Currently I have not handled that scenario.	

You can view images folder for reference.


