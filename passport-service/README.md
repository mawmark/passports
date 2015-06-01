G7 Developer Task Notes
=

Technology
-
* Source code control - Local GIT repo
* IDE - Eclipse (quicker start time than IntelliJ
* Build process - Maven
* Runtime process - Tomcat 7 via Maven plugin (tomcat7:run goal)
* Testing - JUnit 4 (consideration for Mockito and Powermock)
* Framework - Spring MVC with annotations

Testing
-
Test via simple browser and url.  Follow these steps:

* mvn tomcat7:run or from eclipse run configuration
* From browser

Steps
-
Keep it simple to start with.  Use eclipse and maven to build and run a simple tomcat webapp presenting a helloworld jsp.  Use maven archetype to generate project in eclipse.  
Implement the data model as specified.  
Create a cache object which will provide the features needed by the REST api.  
Implement a test class for the cache.  


Data Model Notes
-
Given a customer can exist on their own without a passport auto generate an id and expose this on the rest api as a return from add customer.  
A passport number may only contain numerics but is probably never treated as a number.  i.e. you should not be able to do arithmetic with it.  Therefore keep it as a string for now.  
Consider thread safety.  For now use non thread safe collections.  
Consider exception handling.  What to do if passport added to non existent customer.  
Consider that exposing the collection of passports on the public api is not great, perhaps pass a copied collection. 
The passport collection could be kept as a map for removal.  Consider beyond scope for now. 

Cache Notes
-
Clearly you would not keep all this data in memory (see the cache object).  
