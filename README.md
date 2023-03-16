# Spring Boot Labs

Spring Boot remains relevant in the rapidly evolving world of web development due to its powerful features, ease of use, and extensive ecosystem. It simplifies the development process by providing opinionated defaults, auto-configuration, and embedded server options, making it quick and easy to create production-ready applications. The vast Spring Boot community contributes to a rich selection of high-quality libraries and integrations, ensuring developers can easily find support for a wide range of use cases. While newer technologies may gain popularity, Spring Boot remains a trusted, mature, and versatile choice for developing scalable and maintainable applications in Java.

This project is a Spring Boot-based web application that serves as a management system for a medicine-related program. The application allows users to manage employees, items, medicines, and orders through REST API. The application is organized into various modules and follows a clean architecture.

**REST API** is the go-to technology because it offers a standardized, scalable, and stateless architecture, enabling seamless communication between diverse applications and systems. Its simplicity and ease of use make it widely adopted and suitable for various development needs.

The application consists of the following components:

- DemoApplication.java: The main entry point of the application.
- config: Contains configuration classes for CORS, security, and other settings.
- controllers: Contains controllers for different modules, including employee, home, item, medicine, order, and user.
- model: Contains the domain model classes representing entities such as Employee, Item, Medicine, Orders, and User.
- repository: Contains the repository classes for accessing and managing the entities' data.
- resources: Contains the application properties, SQL files, and templates for the application.
- test: Contains the test classes for the application.

This project provides a robust and modular solution for managing various aspects of a medicine-related program, such as employees, items, medicines, and orders.

## H2 Database Configuration

H2 Database is a lightweight, open-source, Java-based relational database management system that provides a fast and easy-to-use data storage and retrieval solution. It is prevalent for its in-memory mode, which allows data to be stored in memory, making it suitable for development and testing environments. In Spring Boot applications, H2 Database is often used because of its simplicity, easy integration, and ability to accelerate development. Developers can rapidly prototype and test their applications without the overhead of setting up and configuring a full-fledged, production-ready database. Furthermore, H2 Database's compatibility with SQL standards and its support for the Java Persistence API (JPA) make it a natural choice for Spring Boot developers who want a quick, efficient, and seamless solution for their data storage needs.

For this project, H2 database will be used. Follow these steps to set it up:

### Add Maven Dependency

Maven is a powerful build automation tool primarily used for Java projects. It streamlines the build process, dependency management, and project organization, simplifying development and ensuring project consistency. Maven employs a standardized project structure and a Project Object Model (POM) to describe project configurations. This standardization and a vast ecosystem of plugins allow developers to easily manage complex projects and focus on writing code, making Maven a popular choice for Java-based projects, including Spring Boot applications.

Add the H2 dependency to the pom.xml file along with other Spring Boot dependencies:

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
```

For more information on adding dependencies to a Maven project, refer to the below link from IBM:

[Adding dependencies to other modules](https://www.ibm.com/docs/en/wasdtfe?topic=dependencies-adding-other-modules)

### Configure Database

Add the following configurations to the application.properties file:

```text
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

<p>These lines configure a connection to an H2 in-memory database for a Spring Boot application. The <code>spring.datasource.url</code> specifies the database's URL, while <code>spring.datasource.driverClassName</code> sets the database driver class. The <code>spring.datasource.username</code> and <code>spring.datasource.password</code> lines provide the username and password required for database access. Finally, <code>spring.jpa.database-platform</code> defines the Hibernate dialect to translate Java objects to database tables and vice versa, in this case, the H2Dialect. This configuration allows the application to interact with the H2 database seamlessly.</p>

### Seed Database

Create a data.sql file in the src/main/resources directory with your insert statements for the H2 database. Spring Boot will automatically create the table based on the entity model and execute the insert statements from the data.sql file.

Read [this article](https://www.baeldung.com/persistence-with-spring-series) for more information on persistence with Spring.

**This is a good way to seed the database for testing or initialization purposes.**

## Project Assignment

For detailed instructions on the project assignment, [click here](project-01.md)

## Code Setup

Download or clone the code and open it with your favorite editor (e.g., VSCode).

## Running the Project

cURL is famous for testing REST APIs because it's a lightweight, versatile command-line tool that supports multiple protocols and methods. It enables developers to easily send requests, inspect responses, and quickly debug or validate API functionality without additional software or tools.

Use the Spring Boot Dashboard plugin in VSCode to run the project. Test the API endpoints with the provided cURL commands:

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

### SQL Server Configuration with Docker

Requirements:

- Download Docker: visit docker.com, choose platform (Windows, Mac, Linux)
- Install: follow installer instructions
- Verify: open terminal, type "docker --version"

Once Docker is installed, just execute the below commands in Powershell:

### Pull Docker Image

```ps
docker pull mcr.microsoft.com/mssql/server:2019-latest
```

### Run Docker Container

```ps

docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=D3veLoperp@ss" `
    -p 1433:1433 --name sql1 --hostname sql1 `
    -d mcr.microsoft.com/mssql/server:2019-latest

```

Once the SQL server is up and running, we can connect with user SA in localhost; after that, we must create our database.

### Create the database

After the SQL Server is up and running, connect to the server using the SA user on localhost. Next, create the database for the project.

It is recommended to use SQL Server Management Studio (SSMS) to create the database. Follow the steps in the link below to create a new database:

[How to create a new database in Microsoft SQL Server](https://support.mailessentials.gfi.com/hc/en-us/articles/360015116400-How-to-create-a-new-database-in-Microsoft-SQL-Server)

For this example, create a database named my_temporary_db.

### Create the Employee Table

To create the Employee table, open a query editor connected to the database and execute the following SQL query:

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

This will create the Employee table with the required fields. You can now insert sample data to be used in the project.