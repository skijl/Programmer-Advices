# Spring Framework
- **Serialization** is the process of converting an object into a stream of bytes to store it in a file or transmit it over a network. 
- **Transient** keyword is used to indicate that a field should not be serialized
- **Deserialization** is the reverse process, reconstructing the object from the serialized byte stream which is platform independent.
- **Externalization** provides more control over the serialization process.
- **Dependency Injection** or **Inversion of Control** is priciple where the control of object creation and lifecycle is transferred to the Spring container, rather than new objects being created by user.
## REST (Representational State Transfer)
- **REST** is an architectural style for designing networked applications, relying on stateless, client-server communication via standard HTTP methods
- In a **RESTful** system, resources are represented in a consistent format (often JSON or XML), and interactions are stateless, meaning each request from a client to the server must contain all the information needed to understand and process the request.
## JDBC - Java Database Connectivity
> JDBC is an interface that defines how the client have may connect to database and helps avoid common errors
- Connectivity with database
- Loads the driver
- Execute the query
### JPA/Hibernate - Java Persistence API
- **Lazy initialization** in Hibernate is a mechanism used to defer the loading of associated entities or collections until they are explicitly accessed, optimizing performance by fetching only the required data when needed, thereby reducing memory consumption and improving application efficiency.
- **Cache levels:**
    - **1st level** - session cache - stores objects within the current session (enabled by default, cannot be disabled)
    - **2nd level** - session factory cache - caches objects across sessions (disnabled by default, can be enabled programaticaly)
    - **Query cache** - stores results of queries to avoid repeated execution, improving performance by reducing database access and query execution time.
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

