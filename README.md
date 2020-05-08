# Registration Test Task
How to run without docker:
git clone https://github.com/deadlight1/registration_test_task.git
maven: clean, install

# Project structure and the decisions made
1.I wrote unit test only for service layer,
 for controller and repository layers I did not.

2.I understand that it is bad practice to contain js and html in one file,
but I am sure that this is not critical for the test task.

3.By the way I wrote integration test, just for myself.

4.`Visual strength indicator while setting up the password using Ajax ` 

I am more than sure that I did it wrong, so I just performed this on the client side

5.`The algorithm is so complex and business critical that it must be performed server side.  `

I understand this like "Please, add server side validation"

6.Service method registerUser returns boolean, because for test task it is the easiest way, to understand exists user or not.

### Project structure
I have common structure of the project
