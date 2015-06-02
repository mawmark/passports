G7 Developer Task Notes
=

Technology
-
* Source code control - Local GIT repo
* IDE - Eclipse (quicker start time than IntelliJ
* Build process - Maven
* Runtime process - Spring boot application (runs embedded tomcat container)
* Testing - JUnit 4 (consideration for Mockito and Powermock)
* Framework - Spring MVC with annotations

Testing
-
Test via simple browser and url cannot easily work for POST and DELETE operations.  
Therefore I downloaded a simple firefox extension which allows us to define these operations from the browser.

* run application in eclipse (or package and run as jar)
* From browser access rest client (chrome://restclient/content/restclient.html)
* The client has some saved favourites for each operation

Steps
-
Keep it simple to start with.  
Create a simple spring boot application
Implement the data model as specified.  
Create a cache object which will provide the features needed by the REST api.  
Implement a test class for the cache.  
Implement a rest controller.  
Implement a spring boot application which includes configuration.  


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

Spring Boot
-
I decided that instead of running an embedded tomcat to give SpringBoot a try; which I haven't used before.  This turned out to be quite useful purely because it was much easier to support the webapp.  Virtually no configuration was needed which seemed pretty needless for this exercise.  Its quite a large bit of Spring so needs some more reading to find out more.
