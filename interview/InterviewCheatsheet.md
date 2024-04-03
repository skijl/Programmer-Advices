# Java 8 Features
### Default methods in an interface
### Static methods in an interface
### Function Interface
* Instead of object you pass a function
* Predicate is a functional interface with one abstract method 'test', that accepts 1 param, return true/false
* Types on functional interface
    - Built-in
    - User defined
### Stream
* Stream - is a sequence of Bytes (8 bit binary data)
* Functions in streams (filter, map, distinct, sort, toList)
* Byte Streams
    - FileInputStream - reads from bin file.
        - BufferedInputStream - remembers position and can move back
        - ObjectInputStream - used to deserialize Java objects from an InputStream
    - FileOutputStream - writes to bin file
        - FileOutputStream
        - BufferedOutputStream
        - ByteArrayOutputStream
        - ObjectOutputStream /Serialization/
    - Char streams
        - FileReader
        - FileWriter
### Lambda function(expression) 
* Lambda function is function that can execute some logic, you can pass it as a parameter
### Method refference
### Optional
# Features of Java
* Platform independent (we compile anywhere to bytecode and run anywhere on JVM)
* Strongly typed
* Multithreading ( > 1 task at a time)
* OO (Class/Object, encapsulation, polymorphysm, Inheritance, Abstraction)
* Compiled then interpeted
* Memory management (Garbage Collector)
* Robust exception handling
### 2 Step Execution
1) Source code compiled to bytecode
2) Run on JVM
### Terms
- **JDK** - Java Development Kit - write Java
- **JRE** - Java Runtime Environment - run Java. JRE consists of runtime libraries + JVM
- JDK consists of tools and JRE
- JVM consists of:
```
1) Class loaders:
    I - Bootstrap - JVM starts and loads all classes from libraries
    II - System - loads all user defines classes
    III - External - all classes written outside
2) Runtime memory:
    a) Heap
    b) Stack
    c) Class method area
    d) Native library
    e) Program counter registe (thread)
3) Garbage collector
4) JiT - Just in Time compiler
```
finalize() - method called after garbage collection
System.gc() - static mehtod of system class to forcefully run the garbage collector
# OOP Features
### Classes and  Objects
- Class is a blueprint to create an object
    - Object - is an intance of a class 
    - Constructor - method that initializes the state and value during object creation.
### Types of Classes
- Class A {} - concrete class (can be inherited, Object)
- abstract Class B {} - incomplete class (can be inherited, no Object)
- final Class C {} - for example String class, used for creating immutable objects (no inheritance, can be created Object)
* final method - not overrinding
* final variable - no modifications
Purpose of immutable objects:
- To not allow users to edit data
- Used in multithreading when you can view but cannot edit data (Read-only feature for user)
* static import: set of statements that is running when class is loaded. In this block we can write static members initialization code.
> Object Class: supercalss for all hierarchy. Default superclass.   
> Wrapper Class: represents a primitive data type as an object (int <=> Integer) 
**When do we need it?:**
- Clone() method
- Serialization - transfer to other place (DB, Socket)
- Collections
* Autoboxing: make an object from primitive value
* Unboxing: make a primitive from an object
### Encapsulation
- A way to hide data or methods from outsiders
- Binding data and function together through the access modifiers: public, private, dafault, protected
    - public: accessible everywhere
    - protected: accessible inside the package + children outside the package
    - default: accessible inside tha package
    - private: accessible inside the class. Cannot be inherited or children
### Polymorphysm
> **Many forms** of a method
- Overloading: parameters change leaving the same name of the method
- Overriding: change the body of function while inheriting
* **You cannot override a constructor**
### Inheritance
A feature that allows you:
- to reuse the code
- reduce effort to writingthe code
- reduce maintenance
Types of inheritance:
1) Single: Person <= Manager
2) Multilevel: Person <= Employee <= Manager
3) Hierarchical: Tree Structure
4) Multiple Inheritance (interface)
- Child constructor executes parent constructor **(super() before everyhting)**
### Abstraction
- Abstraction is a way to hide an implementation
    - Abstract class (you can't create objects from abstract classes. It can have implemented or abstract methods, doesn't support multiple inheritance)
    - Interface (We use it through child classes. Abstract methods have no bodies. Supports multiple inheritance)
    - A skeleton, a blueprint without implementation
    - Can be used to describe featured of a system entity
    - May be used to represent abstraction
    - May have methods with bodies if it is a default static method
    - All vars are public, static, final (no private, no protected)
    - No constructor
## Assosiation
- **Assosiation** - relationship between 2 not related entities(classes). For assosiation use interface:
    Class A wants to use date from class B:
    1) Inheritance
    2) Relationship
    Assotiation has two types:
    - Agregation - when 2 entities can survive individualy, ending one entity will not affect the other entity(Teacher=>College<=Student)
    - Composition - entities highly dependent on each other(Car=>Engine=>Oil)
## Annotation
- Annotation - tells to compiler somer instructions during the runtime.
- Runtime building is dynamic
- @Override while runtime decides what function to choose
## Exceptions
> How to handle
1) try/catch
2) try/catch/finally or try/finally
3) throw/throws
> Exceptions break flow of the program if not handled. The indicator that something went wrong during runtime
1) Error: beyond the control of the program (sytax error)
2) Logical error: unexpected output
3) Exception: fixable by exception handling
- Throwable is the support class for all types of exception
Types of exceptions:
- Checked: thrown during the compilation (is not a programmer fault - file not found)
- Unchecked: Runtime exception
## String
> String is an **immutable** array of chars
- Stored in a *contant pool* since it is immutable it is constant
- For contantly changing strings use:
    - StringBuffer: threadsafe, low perform
    - StringBuilder not threadsafe, high perform
## HashCode
> HashCode is an address
- We use it for hashing purposes in HashSet, HashTable, HashMap. 
- Works closely with equals method.
- To override HashCode we used to override equals(), equals(), hashcode().

