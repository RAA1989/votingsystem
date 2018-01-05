# Lunch Voting System (REST only)

REST API for choosing the restaurant where to have lunch.
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

## Install:

    git clone https://github.com/RAA1989/votingsystem

## Run (from project directory)

    $ mvn clean package org.codehaus.cargo:cargo-maven2-plugin:1.6.4:run
	
## Usage


       User login: user@yandex.ru
          password: password


       Admin login: admin@gmail.com
          password: admin
		  
The root of the aplication /votingsystem is not avaliable and HTTP Status 404 (NotFound) shows up which handled with ExceptionHandler.
As a result a user gets the Json object with URL and the caught exception.

### Voting
- <a href="http://localhost:8080/votingsystem/votes/result">Voting result</a>
- <a href="http://localhost:8080/votingsystem/votes/100000">All votes of a User</a>
- <a href="http://localhost:8080/votingsystem/votes/last">Last vote of the logged in User</a>

### Restaurant handling
- <a href="http://localhost:8080/votingsystem/restaurants/all">Restaurants list</a>
- <a href="http://localhost:8080/votingsystem/restaurants">List of restaurants with last menus</a>

### Menu handling
- <a href="http://localhost:8080/votingsystem/menus/100002">Menu for restaurant</a>

### Meal handling
- <a href="http://localhost:8080/votingsystem/meals/100012">Meal</a>

For every user the history of their votings is stored and avaliable via: /votingsystem/votes/userId.  
The history of restaurant's menus with meals is also stored: /votingsystem/menus/restaurantId.

## Running CURL tests

Curl tests can be accessed via [curl.md](https://github.com/RAA1989/votingsystem/blob/master/config/curl.md)

JUnit tests check controller handlers, including Hibernate Validation tests, XSS test, unauthorized user test.  
The application has csrf protection and this has been taken into account in JUnit tests.

CURL tests has been made disregarding csrf protection for simplicity.  
So, to make them work csrf protection has been disabled. To activate csrf protection it is necessary to **comment** the row: ```<csrf disabled="true"/>``` in ```src\main\resources\spring\spring-security.xml``` enabling this way mentioned protection.

