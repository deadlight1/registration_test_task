# Registration Test Task
How to run without docker:
git clone https://github.com/deadlight1/registration_test_task.git
maven: clean, install

# Task
The purpose of this assignment is to put your Java capabilities to a test with respect to writing web based  applications, write high quality code and produce intuitive user interfaces. Your skills in Spring and Hibernate are also considered. 
We want to protect our business critical “Hello World!” web page from non-registered users. Only  registered users are granted access to the page.  
Functional requirements:  
    • Anonymous users may register by creating a user account from the login page  
    • A user account consists of a login name and a password  
    • The password of an account is required to be strong  
    • Users that login with a valid login name and password are authenticated  
    • Only authenticated users may view the “Hello World!” dummy page  
Technical requirements:  
    • Use Spring Framework as a container
    
    • Use Spring Security to handle authentication  
    
    • Store the account settings in a SQL database using Hibernate (you can use any DB either in memory - H2, HSQL or MySql)
    
    • Store passwords securely  	
    
    • Multiple browser support 	
    • Use valid XHTML and CSS  	
    • Must provide unit tests using JUnit 	
    • Use the principles of test driven development 	
    • Provide the solution as a Maven project 
    • Intuitive user interface 
    • Provide a readme file  
    • Provide a description of the project structure and the decisions made 
    
# Project structure and the decisions made
1.I wrote unit test only for service layer,
 for controller and repository layers I did not.

2.I understand that it is bad practice to contain js and html in one file,
but I am sure that this is not critical for the test task.

3.By the way I wrote integration test, just for myself.

4.Service method registerUser returns boolean, because for test task it is the easiest way, to understand exists user or not.

### Project structure
I have common structure of the project
