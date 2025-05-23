# Overview
The application under test is [QTrip](https://qtripdynamic-qa-frontend.vercel.app/), a travel website. 

### During the course of this project
- Executed manual End to End API testing for APIs of different web pages using Postman.
- Automated the API tests using Rest Assured Framework and Java.
- Created a TestNG project for easily running automated testing and used XML file to selectively run tests.

# Analyze QTrip API 
### Scope of work
1. Analyzed the QTrip application and its API Documentation.
2. Designed API Tests for different functional modules of the application.
3. Executed manual API tests using Postman.
   
### Skills Used
- Test Case Design, Test Data Enumeration, API Testing, Postman

# Automate QTrip API test cases with Rest Assured and TestNG
### Scope of work
1. Automated the API tests using Rest Assured Framework.
2. Modified the structure of the project using TestNG.
3. Executed Test Cases

### Skills Used
- Java, Rest Assured, TestNG

## Test Cases:

| # | Flow | Test Case | Steps | Expected Result |
| :-------- | :-------- | :-------- | :--------- | :---------- |
| 1 | User Registration | Verify that a new user can be registered and login using APIs of QTrip | 1. Use the register API to register a new user 2. Use the Login API to login using the registered user 3. Validate that the login was successful 4. Verify that the token and user id is returned for login | 1. The Register API should return a status code for 201 2. After successful login, status code 201 must be returned. The Response body should contain :Success = true, user ID and token details |
| 2 | Search City | Verify that the search City API Returns the correct number of results | 1. Search for "beng" using the cities search API 2. Verify the count of results being returned | 1.After successful search, the status code must be 200 2. The Result should be an array of length 1 3. The Description should contain "100+ Places" |
| 3 | booking Flow | Verify that a reservation can be made using the QTrip API | 1. Create a new user using API and login 2. Perform a booking using a post call 3. Ensure that the booking goes fine | 1. On a successful booking, status code 200 should be returned 2. Perform a GET Reservations call for the user and ensure that the successful bookin is listed there |
| 4 | User Registration | Verify that a duplicate user account cannot be created on the Qtrip Website | 1.register a new user 2. Again register a new user with the same email Id | The second registration ( duplicate ) should not succeed. The application should throw an appropriate error message |
