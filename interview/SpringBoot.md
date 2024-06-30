# Spring Framework
## Spring
```
Spring is a framework that provides a wide range of tools and libraries to support enterprise-level application development, focusing on aspects such as dependency injection, aspect-oriented programming, and transaction management. 
Spring Boot is a project built on top of Spring that simplifies the setup and development of Spring applications by providing default configurations, embedded servers, and production-ready features, significantly reducing the boilerplate code and configuration needed.
```
- **Serialization** is the process of converting an object into a stream of bytes to store it in a file or transmit it over a network. 
- **Transient** keyword is used to indicate that a field should not be serialized
- **Deserialization** is the reverse process, reconstructing the object from the serialized byte stream which is platform independent.
- **Externalization** provides more control over the serialization process.
* **Dependency Injection** or **Inversion of Control** is priciple where the control of object creation and lifecycle is transferred to the Spring container, rather than new objects being created by user.
* **Aspect-Oriented Programming (AOP)** is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns *(logging, security, and transaction management)*. It does this by enabling the addition of behavior to existing code without modifying the code itself, typically through the use of aspects, advice, pointcuts, and join points.
## Scopes
In Spring Boot, the main bean scopes are:
- **Singleton:** A single instance of the bean is created and shared across the entire Spring container.
- **Prototype:** A new instance of the bean is created every time it is requested.
- **Request:** A single instance of the bean is created and available for the duration of a single HTTP request.
- **Session:** A single instance of the bean is created and available for the duration of an HTTP session.
- **Application:** A single instance of the bean is created and shared across the entire ServletContext (similar to singleton but scoped to the ServletContext).
- **WebSocket:** A single instance of the bean is created and available for the duration of a WebSocket session.
## REST (Representational State Transfer)
- **REST** is an architectural style for designing networked applications, relying on stateless, client-server communication via standard HTTP methods
- In a **RESTful** system, resources are represented in a consistent format (often JSON or XML), and interactions are stateless, 
- **Stateless** - is a concept in REST meaning each request from a client to the server must contain all the information needed to understand and process the request *(RESTful web service does not keep the client's state on server)*.
- **HTTP Methods** - a way to interact with a server *(POST, GET, PUT, DELETE)*
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
### Cascade Types
- **CascadeType.ALL:** Propagates all operations (persist, merge, remove, refresh, detach) from the parent entity to the related entities.
- **CascadeType.PERSIST:** When the parent entity is persisted (saved), the related entities are also persisted. This is used to save new entities along with the parent entity.
- **CascadeType.MERGE:** When the parent entity is merged (updated), the related entities are also merged. This is useful for updating entities that already exist in the database.
- **CascadeType.REMOVE:** When the parent entity is removed (deleted), the related entities are also removed. This is used to delete the related entities when the parent entity is deleted.
- **CascadeType.REFRESH:** When the parent entity is refreshed (reloaded from the database), the related entities are also refreshed. This ensures that the entity state is synchronized with the database.
- **CascadeType.DETACH:** When the parent entity is detached (removed from the persistence context), the related entities are also detached. This stops the related entities from being managed by the persistence context.
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
## Tests
- **Spy** used for partial mocking. Calls real methods by default but allows stubbing and verification.
- **Stub** used to provide controlled responses to method calls. It doesn't verify method calls.
- **Mock** used to verify interactions. By default, all methods return default values unless stubbed.
## Team work
- Scrum: a better way of team collaboration for solving complex problems (Product Owner, Scrum master and developers)
- Agile: a project management approach that involves breaking the project into phases and and small pieces with high quality.

