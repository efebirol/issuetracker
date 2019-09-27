# REST API - Scrum Issue Tracker

## Introduction

Build a very small scale web application.

## Endpoints
```
http://localhost:8080/h2-console
```
- Login to the database at http://localhost:8080/h2-console and enter

```
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Pasword: <leave this empty>
```

## Technical requirements for the application

```
The application should work and be implemented in Java. You are free to choose any fitting Java based framework. 
Preferably Spring, RESTEasy orsimiliar JavaEE REST framework in combination with Hibernate, EclipseLink, etc. for persisting data.
```
## Functional requirements for the application:

The goal is to develop a very simple REST API for an issue tracker of a small team of developers. The requirements of the team are basic:

```
- There should be a list of developers. Functionality to add or remove developers. A developer just has a name as the only attribute.
   - The application should be able to handle two different kinds of issues: Stories and Bugs
        -Both Types have an issue-ID, as well as a title, a description a creation date and an assigned developer
            - ussue-ID must be unique
        - Stories also have an estimated point value, as well as a status that can switch between "New", "Estimated" and "Completed"
        - Bugs have a priority ("Critical", "Major" or "Minor") as well as a status ("New", "Verified" or "Resolved")
    - The team wants some help with planning their stories. The goal is to know what stories will be worked on in which week.
        - The team has learned that on average one developer can complete 10 story points a week
        - The goal is to complete all the stories in the minimum amount of weeks.
        - It is not necessary to find a truly optimal solution, but the solution should not have any glaring flaws.
        - The total amount of story points in a week should not exceed <developer count> * 10. It is not important to consider which
developer a task is assigned to.
            - stories are not assigned beforehand
            - assignment is done in the planning
        - No other constraints on the ordering of the stories exists.
        - Bugs are completely ignored in calculation.
        - As long as no new stories are created, the distribution should remain the same.
```
## Additional: create a user interface for managing developers, stories, bug and

## showing the plan it would be a plus

## ToDo:

```
- The source code of your project.
- A short explanation on how we can build and run your project.
- How to access the application (the URL)
- A short description on the technical choices you made and why you made them. If you had problems completing the project, a short
description of the problems you faced and how you would continue to resolve them if you had more time.
```

