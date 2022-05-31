# spring-boot-labs

## SQL Server Configuration

Once Docker is installed, just execute the below commands in powershell:

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

Once SQL server is up and running, we can connect with user SA, and in localhost, after that we need to create our database

### Create the database

In SQL Server Management Studio is super simple, better to create that way that adding the unnecesary code here, which is 114 lines
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

## Assignment

Pick a data model like employee, user, etc. and 
create a RESTful API from scratch to provide

* GET
* POST
* DELETE
* PUT APIs

## Code

Just download or clone the code, use your favority editor, this one was coded with VSCode

## Run

Run the project and test the below links:

## GET ALL

curl -v localhost:8080/employees

## GET

curl -v localhost:8080/employees/3

## POST

curl -X POST localhost:8080/employees -H 'Content-type:application/json' -d '{"name":"Menga", "lastName":"Nito", "badgeNumber":12358}'

## PUT

curl -X PUT localhost:8080/employees/3 -H 'Content-type:application/json' -d '{"name":"Menga", "lastName":"Nito", "badgeNumber":12359}'

## DELETE

curl -X DELETE localhost:8080/employees/3
