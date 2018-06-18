Feature: Admin User login to OrangeHRM system and add a new Employee to the system
Description: This is to verify login and add Employee functionalities of an Admin user

Scenario Outline: Login to the system

Given the Admin user is in login Page
And he enters "<user>" credentials
And click the login button
Then the "<user>" is logged into the system

Examples:
|user		|
|Admin      |