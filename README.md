# Lunch Voting System

A REST API for choosing the restaurant to have a lunch at.
# Task

Design and implement a REST API using Hibernate/Spring/SpringMVC (or Spring-Boot) **without frontend**.

Build a voting system for deciding where to have lunch.

 * 2 types of users: admin and regular users
 * Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
 * Menu changes each day (admins do the updates)
 * Users can vote on which restaurant they want to have lunch at
 * Only one vote counted per user
 * If user votes again the same day:
    - If it is before 11:00 we asume that he changed his mind.
    - If it is after 11:00 then it is too late, vote can't be changed

Each restaurant provides new menu each day.

As a result, provide a link to github repository. It should contain the code, README.md with API documentation and couple curl commands to test it.

Asume that your API will be used by a frontend developer to build frontend on top of that.


## Built with

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring MVC](https://projects.spring.io/spring-framework/) - main framework
* [Spring Security](https://projects.spring.io/spring-security/) - security framework
* [Hibernate](http://hibernate.org/) - used for validation
* [REST(Jackson)](https://github.com/FasterXML/jackson) - Json for Java
* Java 8 Stream and Time API
* [Spring Data](https://projects.spring.io/spring-data/) - to provide data access
* [HSQLDB](http://hsqldb.org/) - database


## Usage

The application returns Json objects for any requests.

/votingsystem is an Application context.

The list of the restaurants for choosing is avaliable via URL: /votingsystem/restaurants.
To look at the result of the voting one should go /votingsystem/votes/result.

For every user the history of their votings is stored and avaliable via: /votingsystem/votes/userId.
The history of restaurant's menus with meals is also stored: /votingsystem/menus/restaurantId.

Meals are created via POST requests with Json objects passed into the body: /votingsystem/meals.

The root of the aplication /votingsystem is not avaliable and HTTP Status 404 (NotFound) shows up which handled with ExceptionHandler.
As a result a user gets Json object with URL and the caught exception.

## Running the tests

JUnit tests check controller handlers, including Hibernate Validation tests, XSS test, unauthorized user test.
The application has csrf protection and it has been taken into account in JUnit tests.

There are also some curl tests that has been made disregarding csrf protection for simplicity.
So, to make them work it is necessary to **uncomment** the row: ```<csrf disabled="true"/>``` in spring-security.xml disabling this way mentioned protection.

Curl tests can be accessed via [curl.md](https://github.com/RAA1989/votingsystem/blob/master/config/curl.md)
