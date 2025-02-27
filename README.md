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

## Technologies
- Java 23
- Gradle 8.12.1
- GoogleSheets API
- JUnit 5
- [IntelliJ IDEA Ultimate](https://www.jetbrains.com/pt-br/idea/download/)

## Project Setup

### Requirements
- [JDK 23](https://www.oracle.com/br/java/technologies/downloads/)
- [Gradle](https://gradle.org/install/)
- [Google Account with Google Cloud Access](https://developers.google.com/sheets/api/quickstart/java?hl=pt-br)
- [Google Spreadsheet](https://docs.google.com/spreadsheets/d/1XvWJcRLj2WAeXO3ULQ_GxGm9---3SZkjMbGcXMJtt70/edit?gid=0#gid=0)

### Google Spreadsheet
1. Click on the [link](https://docs.google.com/spreadsheets/d/1XvWJcRLj2WAeXO3ULQ_GxGm9---3SZkjMbGcXMJtt70/edit?gid=0#gid=0)
2. Make a copy of the spreadsheet and save it to your drive
3. Copy the ID (on the example below, it's shown where the ID is)
   - Example: docs.google.com/spreadsheets/d/SPREADSHEET_ID/
4. Paste the id on src/main/java/com/academicstatuscalculator/util/Constants.java on the SPREADSHEET_ID

### Google Cloud Setup
1. Create a new Project in Google Cloud
2. Enable Google Sheets API
3. Create OAuth credentials
4. Download the credentials.json

### Development Environment Setup
1. Clone the repository:<br>
`git clone https://github.com/christianodavid/academic-status-calculator.git` <br>
2. Paste credentials.json in src/main/resources/
3. Update SPREADSHEET_ID in Constants.java if necessary

## Operation Flow
1. Application reads student data from Google Sheets
2. For each student, calculates average and determines academic status
3. Updates spreadsheets

## Testing
- Unit tests cover:
    - Checking Setters and Getters
    - Result Calculation
    - Final Grade For Approval Calculation

## Project Execution
- After setting up [Google Sheets API](#google-cloud-setup) and [Environment Setup](#development-environment-setup), open the terminal and use the following commands: <br>
`gradle build` <br>
`gradle run`
