I. Project Goal
The goal of this code is to show you how Spring IOC implements the IOC Design Pattern.
You will understand how Spring implements:
• Modifier injection.
• Constructor injection.
• Factory injection.

II. Prerequisites
• IntelliJ IDEA or other IDE;
• JDK version 17;
• An Internet connection to allow Maven to download libraries.

III. What is IOC
• IOC (Inversion Of Control), is a Design Pattern that corrects the tight coupling problem.
• IOC allows not to use concrete classes.
• In IOC, the relationship between classes is done by interfaces.
• IOC allows to inject objects using three methods:
◦ Modifier injection;
◦ Constructor injection;
◦ Factory injection.

IV. What is Spring IOC
• Spring IOC or Spring Core is the core of the Spring Framework:
◦ Is based on the IOC Design Pattern
◦ Takes care of instantiating all the objects of the application and resolving dependencies between them.

• Two very important APIs in this module:
◦ org.springframework.beans
◦ org.springframework.context

• Provide the bases for the IOC Design Pattern.
• BeanFatory (org.springframework.beans.factory.BeanFactory) allows you to configure Beans (in an XML file or via annotations) and manage them (instantiation, dependency management).

• ApplicationContext (org.springframework.context.ApplicationContext) adds advanced features to the BeanFactory (facilitates integration with Spring AOP, etc.).
