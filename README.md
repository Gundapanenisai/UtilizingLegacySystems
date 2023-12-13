| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Bhargav Gundapaneni        |
| Date         | 12/04/2023                 |
| Course       | Fall                       |
| Assignment # | 6                          |

# Assignment Overview
This assignment focuses on integrating two distinct systems for accessing customer data - a legacy system that retrieves data from external disks via USB, and a modern system that uses a secure HTTPS connection and REST API. The challenge lies in creating a unified interface that allows seamless interaction with both systems, enabling the use of the new system's interface while still supporting the legacy system's API.

By developing an adapter layer, we ensure future-proof integration and maintain the usability of the legacy system without compromising on the security and efficiency of the new system. The adapter design pattern has been implemented to achieve this goal.

# GitHub Repository Link:
[https://github.com/gundapanenisai/cs-665-assignment-4](https://github.com/gundapanenisai/cs-665-assignment-4)

# Implementation Description

The flexibility of the implementation is demonstrated by the use of the Adapter design pattern, which allows for the easy addition or removal of object types representing different customer data sources. The design pattern provides a standardized interface for the application, which can be extended without altering the client code or the new system's integration points.

The implementation has been kept simple to promote understandability and maintainability. Methods and classes have a single responsibility and are well-documented, following clean code principles to ensure that future developers can easily comprehend and work with the codebase.

Duplicated code has been avoided through the use of inheritance and composition where appropriate. Utilizing interfaces for defining behaviors allows shared methods to be implemented in abstract classes or via composition, reducing the need for repeated code and enhancing maintainability.

The Adapter design pattern was chosen as it allows the old system to be adapted to the new system's interface without modifying the existing legacy system's code. This reduces the risk of introducing errors into the legacy system and allows for a more modular and scalable solution.

# UML Explanation 
CustomerDataClient would define methods like getCustomerData().
LegacyCustomerDataClient would implement these methods in a way compatible with the legacy system, perhaps by reading the binary files.
NewCustomerDataClient would also implement the getCustomerData() method, but it would retrieve the data through the REST API.
CustomerDataAdaptor is where the Adapter pattern comes into play. It would implement the CustomerDataClient interface and internally translate the calls to the methods understood by the LegacyCustomerDataClient.
CustomerDataService would be a higher-level class that other parts of your system would use to access customer data without caring whether it’s coming from the new system or the legacy system.
Customer would have properties like id, name, email, etc., with corresponding getters and setters.
CustomerDataIntegrationTest would contain methods annotated with @Test to demonstrate that both LegacyCustomerDataClient and NewCustomerDataClient can be

# Project Enhancement Summary
In this project, we focused on refining an existing system designed to bridge a legacy customer data system (using USB connections) with a newer system employing HTTPS and REST API. Our enhancements aimed to improve the system's maintainability, performance, and error handling. Here's an overview of the specific areas we addressed:

# Improved Error Handling:

In both the CustomerDataAdapter and LegacySystemImplementation classes, we implemented robust error handling mechanisms. This included catching and logging exceptions, thereby preventing the application from crashing and providing clear feedback for debugging.
The UserInputHandler class was also enhanced to gracefully handle incorrect or unexpected user inputs.
Data Conversion Optimization:

In the CustomerDataAdapter, we identified a common pattern in data conversion (from byte arrays to strings and vice versa). To avoid code duplication and enhance maintainability, we extracted this logic into separate, reusable methods. This not only streamlined the code but also prepared it for potential future changes in data handling requirements.
User Input Validation and Processing:

The UserInputHandler class was refactored to include more rigorous input validation. This enhancement ensures that the program can handle a variety of user input scenarios more robustly, providing appropriate feedback and guidance to the user in case of invalid inputs.
Reflecting Changes in UML Diagram
The UML diagram was updated to reflect these key changes:

New Methods: 
The addition of private helper methods for data conversion in the CustomerDataAdapter and the implementation of enhanced error handling in LegacySystemImplementation. 

Enhanced Class:
The UserInputHandler class was augmented to include additional methods for handling and validating user inputs.

Inter-Class Relationships:
The diagram now better illustrates the dependency of CustomerDataAdapter on the CustomerData_USB interface and its implementation of the CustomerData_HTTPS interface.
Conclusion
These enhancements have significantly improved the robustness and maintainability of the system. Error handling ensures that the system can operate reliably and continue functioning even when faced with unexpected scenarios. The optimization of data conversion processes and the improved handling of user inputs have made the system more user-friendly and easier to maintain. Overall, these changes align well with the principles of good software design, making the system more efficient and adaptable for future needs.


# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line:

```bash
mvn clean compile
```



## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```


## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`



