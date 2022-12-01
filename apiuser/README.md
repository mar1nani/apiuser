# Spring Boot API

Spring Boot for a User API

## 1. Getting started

### 1.1. Retrieve Sources

```
$ git clone git@github.com:mar1nani/apiuser.git
```

### 1.2. Launch the application
```
$ mvn spring-boot:run
```
### 1.3. API

Method | Path           | Description                    |
-------|----------------|--------------------------------|
GET    | /users         | retrieve all the users         |
GET    | /users/{id}    | retrieve one user by its ID    |
POST   | /users         | store a new user               |
PUT    | /users         | update an existing user        |
DELETE | /users/{id}    | remove a user by its ID        |

```
// GET /users
$ curl -X GET http://localhost:8080/api/users -i -H "Content-Type: application/json"

// GET /users/{id}
$ curl -X GET http://localhost:8080/api/users/1 -i -H "Content-Type: application/json"

// POST /users
$ curl -X POST http://{host}:{port}/api/users -i
    -H "Accept: application/json"
    -H "Content-Type: application/json"
    -d '{
    "username": "Olivia",
    "birthDate": "2000-09-09",
    "country": "french",
    "phoneNumber": "0673534487",
    "gender": "FEMALE"
}'

// PUT /users
$ curl -X PUT http://{host}:{port}/api/users -i -H "Accept: application/json" -H "Content-Type: application/json"

// DELETE /users/{id}
$ curl -X DELETE http://{host}:{port}/api/users/{id} -i
```

## 2. Tutorial

### 2.1. Introduction

Spring Boot is a framework for quickly building rich Java/JEE applications (web or standalone).

Spring Boot accelerates software development by providing an out-of-the-box set of conventions, abstractions, and mechanisms.

Concretely, Spring Boot comes in the form of a parent POM and dependencies -- a.k.a. "starters" -- (Maven or Gradle).

### 2.2. Purpose of this tutorial

In this tutorial, we will see how:

- set up, configure and start a REST API with Spring Boot
- declare a JPA Entity (for persistence) as well as a complete associated Repository.
- define a REST/JSON/HTTP Resource (GET, POST, PUT, DELETE)
- do unit and integration tests with Spring Test and MockMVC
- package the application for external J2E servers (ex: Tomcat / Jetty)

### 2.3. Initialize a web project with Spring Boot

In the directory of your choice, create the following tree structure:
```
spring-boot-sample 
  |
  +-- src
     |
     +-- main
     .  |
     .  +-- java
     .    |
     .    + com.api.springboot
     .
     |
     +-- test
     .  |
     .  +-- java
     .    |
     .    + com.api.springboot
     
## 3. POSTMAN collection

In this link, there were 11 test runs of this User API using different methods and paths

https://www.postman.com/grey-equinox-677568/workspace/user-api/example/24677749-a41c97c1-8ca2-4c51-b030-332c99dd5a3b

This shared link in POSTMAN contains 11 requests and their 11 responses on how to:

+ List all users
+ Show user with id = 1
+ Show user with id = 2
+ Add new user with no validation error
+ Add new user with exception messages in Null values (country, birthday and username)
+ Add new user with exception handler message "the country must be french"
+ Add new user with exception handler message "The age must be greater than 18"
+ Add a User after all requirements are met
+ Update values of User When id = 6
+ List all users to see new users added
+ Delete User when id = 7






