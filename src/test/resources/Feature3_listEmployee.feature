Feature: Employees can be searched, selected for view, edit or delete.

Scenario Outline: Employee search

Given the "<user>" is in Employee List page
When he enters "<search_criteria>"
And hit Search button
Then relevant employees are listed in the results

Examples: 
|user |search_criteria  |
|Admin|1				|
|Admin|2				|

Scenario Outline: Employee Delete

Given the "<user>" is in Employee List page
When he selects an "<employee>" 
And hit delete button
Then the choosen employee is deleted from the system

Examples:
|user |employee |
|Admin|0054	|
