Feature: Add single of multiple employees to the system

Scenario Outline: Add Single New Employee

Given the "<user>" is in Add Employee Page
When he enters "<employee>" information
And submits form
Then that Employee is shown in the list

Examples:
|user |employee|
|Admin|Yashika2|