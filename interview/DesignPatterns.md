## Design Patterns
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
