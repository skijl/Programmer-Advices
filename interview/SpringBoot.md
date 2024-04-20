# Spring Framework
## SOLID
//TODO
- **S** - Single Responsibility (one class or method must has only one responsibility)
- **O** - Open Closed (Add the modification to the class by adding extension)
- **L** - Liskov Substitution (Parent and Child class have to be substitutable and interchangable)
- **I** - Interface Segregation (Create interface only with methods that are required)
- **D** - Dependency Inversion (Higher level module should not have a dependency on the lower level module)
### Singleton
Create the object only once and use it across all the application
Use private Constructor that we can't create object from the class, and static method to retriev the same object
### Buider Design Pattern
Use different contstructors to create different objects (@Builder in Lombok)
### Prototype Design Pattern
Create new object by extending the base object (Base class implements Clonable)
###
## JDBC - Java Database Connectivity
> JDBC is an interface that defines how the client have may connect to database and helps avoid common errors
- Connectivity with database
- Loads the driver
- Execute the query
**JDBC task** - to write and execute SQL queries from Java app
Java application talks to Database through the JDBC (We use JDBC Driver as a middleware that converts JDBC calls to SQL calls)
### 4 Types of JDBC Drivers
1) Type-1 driver or JDBC-ODBC bridge driver uses ODBC driver to connect to the database. The JDBC-ODBC bridge driver converts JDBC method calls into the ODBC function calls. Type-1 driver is also called Universal driver because it can be used to connect to any of the databases.
2) Type-2 Native-API driver, is a database driver implementation that uses the client-side libraries of the database. The driver converts JDBC method calls into native calls of the database API. For example: Oracle OCI driver is a type 2 driver.
3) Type-3 driver (Extension or Gateway)is a network-protocol, all-Java driver. This style of driver translates JDBC calls into the middleware vendor's protocol, which is then translated to a DBMS protocol by a middleware server.
4) Type-4 - pure Java Driver. This driver interacts directly with the database. It does not require any native database library
### Database Management System
> Database Management System: orginized data / relationship / CRUD operations
- Database: is a storage (collection of tables/schema/stored procedures)
- Table - is a collection of records (rows and columns). Row represent 1 instance of a record. Collumns are attributes.
- SQL is a standart for giving instructions to database servers
- If we want to use more complicated queries we use Prepared Statements
> Stayed Procedure - is a reusable function written in PL/SQL.
> Stored Procedure - faster to execute compared to SQL queries
### Types of SQL Statements
1) DDL (Data Definition Language) - create, alter, drop
2) DML (Data Manipulation Language) - insert, update, delete, select
3) DCL (Data Control Language) - grant, revoke
4) TCL (Transaction Control Language) - commit, rollback, savepoint
5) DQL (Data Query Language) - SELECT, WHERE, JOIN, GROUP BY, HAVING, ORDER BY
### Transactions
> Transaction is a set of activity that either fully executed or fully not
**All the transactions have to be ACID:**
- **A** - atomicity - Either the entire statement is executed, or none of it is executed.
- **C** - consistency - Ensures that errors do not create unintended consequences for the integrity of your table.
- **I** - isolation - Isolation of their transactions for multiple users
- **D** - durability - Changes to your data made by successfully executed transactions will be saved, even in the event of system failure.
### Database normalization
Normal forms:
1. Each object in the table has to be unique 
2. If 1 and all the object has to have a primary key 
3. If 2 and no dependecies between non-key atributes. 
4. Only one primary key for one table. 
5. If 4 and removing all the reduntancy
## Team work
- Scrum: a better way of team collaboration for solving complex problems (Product Owner, Scrum master and developers)
- Agile: a project management approach that involves breaking the project into phases and and small pieces with high quality.
