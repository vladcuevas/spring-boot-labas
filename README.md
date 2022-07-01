# spring-boot-labs

## H2 Configuration

For the purpose of this assignment, H2 will be used, for that we must follow the below steps:

### Add Maven Dependency

This dependency must be included in the pom.xml file, we can find other dependencies there related Spring Boot.

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
```

More information on how to add dependencies for a Maven project can be found in the below link:

[Adding dependencies to other modules
](https://www.ibm.com/docs/en/wasdtfe?topic=dependencies-adding-other-modules)

### Database Configuration

In the application.property file, we must include the below configurations.

```text
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

### Database Operations

A lot of documentation about persistence can be found [here](https://www.baeldung.com/persistence-with-spring-series).

What is important is that we must create a file called data.sql in the src/main/resources directory and add our insert statements for the H2 database, Spring Boot should take care of creating the table based in the model for the Entity, then will execute the insert statements from the data.sql file.

**This is a good way to seed the database for testing or initialization purposes.**

## Assignment

[Click here to get all the details from this assignment](project-01.md)

## Code

Just download or clone the code, use your favorite editor, this one was coded with VSCode

## Run

Run the project with Spring Boot Dashboard plugging from VSCode that will do the hard work and test the below links:

## GET ALL

```PowerShell
curl -i --user "admin:admin" localhost:8080/api/admin/medicines
```

## GET

```PowerShell
curl -i --user "admin:admin" localhost:8080/api/admin/medicines/3
```

## POST

```PowerShell
curl -i --user "admin:admin" -X POST localhost:8080/api/admin/medicines -H 'Content-type:application/json' -d '{"""name""":"""Ramipril""", """companyName""":"""Company5""", """price""":7.89, """disease""":8, """expirationDate""":"""2022-08-08"""}'
```

## PUT

```PowerShell
curl -X PUT localhost:8080/medicines/3 -H 'Content-type:application/json' -d '{"""name""":"""Amlodipina""", """companyName""":"""Company5""", """price""":7.89, """disease""":8, """expirationDate""":"""2022-08-08"""}'
```

## DELETE

```PowerShell
curl -X DELETE localhost:8080/medicines/3
```


### SQL Server and Docker

### SQL Server Configuration

Once Docker is installed, just execute the below commands in Powershell:

### Pull Image

```ps
docker pull mcr.microsoft.com/mssql/server:2019-latest
```

### Run container

```ps

docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=D3veLoperp@ss" `
    -p 1433:1433 --name sql1 --hostname sql1 `
    -d mcr.microsoft.com/mssql/server:2019-latest

```

Once SQL server is up and running, we can connect with user SA in localhost, after that we need to create our database

### Create the database

In SQL Server Management Studio is super simple, better to create that way that adding the unnecessary code here, which is 114 lines
With clicks is easy following the steps from below URL:

[How to create a new database in Microsoft SQL Server](https://support.mailessentials.gfi.com/hc/en-us/articles/360015116400-How-to-create-a-new-database-in-Microsoft-SQL-Server)

In this example the database is called my_temporary_db.

### Create our Employee table

Just open a query editor connected to the database and execute the below query:

```sql
USE [my_temporary_db]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Employee](
 [id] [int] IDENTITY(1,1) NOT NULL,
 [name] [nvarchar](50) NOT NULL,
 [last_name] [nvarchar](50) NOT NULL,
 [badge_number] [int] NOT NULL
) ON [PRIMARY]
GO
```

After that we can insert some examples to get present something with the GET request, which normally is the fist request that is coded.