# Academic Status Calculator

## Introduction
This project is from Tekna.Rocks' technical test for a Development Internship. 

## The Challenge
Create an application in a programming language of your choice (Java was chosen for this project). The application must be able to read a Google Sheets spreadsheet, search for the necessary information, calculate, and write the result to the spreadsheet.

## Rules
- Calculate the situation of each student based on the average of the tests (P1, P2, and P3).
- In the case of the number of absences being 25% over than the total number of classes, the student should be classified as "Failed for Absence" regardless of the Average.
- In case the student's situation is " Final Test", calculate the "Final Grade for Approval" (fga) using this formula: 5 <= (avg + fga)/2.
- If the student's situation is different from the "Final Test", fill in the field "Final Grade for Approval" (fga) with zero.
- Round the result up to the next whole number (increase) if necessary.
- Use log lines to monitor application activities.
- The source code texts (attributes, classes, functions, and comments) must be written in English, except for the identifiers and texts predefined in this challenge.
- The candidate must specify the commands that should be used to run the application.
- The candidate must publish the source code in a Git repository of their choice.