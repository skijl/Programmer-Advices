# Design Patterns
- **S** - Single Responsibility (one class or method must has only one responsibility)
- **O** - Open Closed (Classes/functions are open for extension but closed for modification)
- **L** - Liskov Substitution (Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program)
- **I** - Interface Segregation (Create interface only with methods that are required)
- **D** - Dependency Inversion (Parent module should not be dependent on the low-level module)
### Singleton
Create the object only once and use it across all the application
Use private Constructor that we can't create object from the class, and static method to retriev the same object
### Buider Design Pattern
The key idea behind the Builder Pattern is to provide a flexible and readable way to construct objects with a large number of optional parameters or configurations (@Builder in Lombok)
### Prototype Design Pattern
Create new object by extending the base object (Base class implements Clonable)
### Adapter Design Pattern
Adapter Design Pattern allows incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of one class into another interface that a client expects.
### Bridge Design Pattern 
Bridge Pattern allows to create a bridge between the abstraction and its implementation, allowing them to vary independently of each other. 
# Monolith vs Microservices
### Monolith
+ Easy to scale by having multiple copies (scale horizontaly)
+ Better for small scale apps
- Limitation in size
- Complexity grows with time
- Even small change in one module needs redeployment of whole application
- Hiring new team and making them understand whole application is tough
- Stuck in one programming language
- Single point of failure
### Microservices
+ Self Organization
+ Isolated decision making
+ Easy and quick to scale - on demand
+ Experiment with any technology
+ Loose coupling
+ Service Reusability
+ Best for large scale apps
- Additional complexity with distributed systems
- Monitoring complexity
- Complex communication between services
## Microservices Design Principles
- **Independent / Autonomous**
    - Parallel developement
    - Individual deployment
- **Resilient / Fault Tolerant / Design For Failure**
    - Avoid single point of failure
    - Avoid cascading failure
    - Consider failure as event and analyse it properly
- **Observable**
    - Centralized monitoring
    - Centralized logging
    - Health check system
- **Discoverable**
    - All services registered in one place
- **Domain Driven**
    - Focussed on business
    - Focused on core domain
    - Focus on Domain logic
- **Decentralization**
    - Choice of database depends on the nature of particular service
- **High Cohesion**
    - Single Responsibility Principle
- **Single Source of Truth**
    - One source/service to get the particular information
    - It helps to avoid the duplication
## Why do we need Microservices Design Patterns
- We need our services to be highly
    - Available
    - Scalable
    - Resilient to failures
    - Efficient
- Design patterns help solving specific microservice aechitecture challenge
- Design patterns help reducing risk of failure in microservices
# Microservices Design Patterns------------------------------------------------------
## Decomposition Patterns
- **By Bussiness Domain (How to divide a monolith?)**
    - Decompose Monolith app into Microservices by business finctionality
- **By Subdomain (How to decide the size of microservices)**
    - God Classes *(shared among different services)*
    - Sub Domain *(bounded context, divided by Domain Driven Design)*
- **Strangler Pattern**
    1. Identify the module that you want to convert to microservice
    2. Using route put old and new service to exist at the same time
    3. By the time eliminate the old flow
- **Sidecar/Sidekick Pattern**
    - Deploying a helper application, known as a sidecar, alongside the main application to provide supplementary features or services
    - Usually the sidecar application handles specific concerns, such as logging, monitoring, security, or communication with external services
- **Service Mesh**
    - A dedicated infrastructure layer for handling service-to-service communication.
    - Provides capabilities such as service discovery, load balancing, encryption, authentication, and observability.
## Database Patterns 
- **Database Per Service**
    - Free to choose any database type
- **Shared Database**
    - Simpler to operate
    - Runtime coupling
    - Services have to use the same database type
* **CQRS (Command Query Responsibility Segregation)**
    - Divide databases for create/update/delete and read <- Responsibility Segregation
    - Easy to scale
    - Data replication, events, methods
    - Replication delay
    - Extra complexity
* **SAGA**
    - Breaking down a complex transaction into a series of smaller, self-contained steps called "saga steps."
* **Event Sourcing**
### Data Consitency
- **Eventual Consistency** guarantees low latency with some stale data
- **Strong consistency** guarantees updated/latest data with some higher latency
## Communitation Among Services
- **Synchronous**
- **Asynchronous - even/messaging based**
- **Communication Medium**
    - **HTTP REST xml/json**
    - **Graphql**
    - **gRPC**
## Integration Patterns
- **API Gateway**
- **Aggregator Pattern**
- **Client Side UI Composition Patterns**
- **Chained Pattern**
- **Branch Pattern**
## Deployment Patterns
- Multiple Service Instances per Host
- Service Instance per Host
- Service Instance per VM
- Service Instance per Container
- Serverless
- Blue Green
- Canary
## Observability
- Log Aggregation
- Performance Metrics
- Distributed Tracing
- Health Check
## Cross Cutting Concern Pattern
- External Configuration
- Service Discovery Pattern
- Circuit Breaker Pattern