# Job API - Spring Boot REST API

A RESTful Job Management API built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. This project started as an in-memory CRUD application using `ArrayList` and was progressively refactored into a layered backend following industry practices.

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## Features

- Create a Job
- Get all Jobs
- Get Job by ID
- Update Job
- Delete Job
- Search Job by Title

---

## Project Structure

```
src
├── controller
├── dto
├── model
├── repository
├── service
└── resources
```

---

## Architecture

```
Client
   │
   ▼
Controller
   │
   ▼
Request DTO
   │
   ▼
Service
   │
   ▼
Entity
   │
   ▼
Repository
   │
   ▼
MySQL Database
   │
   ▼
Entity
   │
   ▼
Response DTO
   │
   ▼
Client
```

---

## DTOs

### Request DTOs

- CreateJobRequest
- UpdateJobRequest

### Response DTOs

- AllJobResponse
- JobDetailResponse

The API communicates only through DTOs while entities remain internal to the application.

---

## REST Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/jobs` | Get all jobs |
| GET | `/jobs/{id}` | Get job by ID |
| POST | `/jobs` | Create new job |
| PUT | `/jobs` | Update job |
| DELETE | `/jobs/{id}` | Delete job |
| GET | `/jobs/search/{title}` | Search job by title |

---

## Concepts Practiced

- REST API Design
- Layered Architecture
- Dependency Injection
- Spring MVC
- Spring Data JPA
- Hibernate
- DTO Pattern
- Object Mapping
- CRUD Operations
- Repository Pattern
- ResponseEntity
- MySQL Integration

---

## Learning Journey

This project was developed incrementally:

- Java OOP
- REST APIs
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- DTO Pattern

Upcoming improvements:

- Validation
- Global Exception Handling
- Entity Relationships
- Spring Security + JWT Authentication
- Pagination & Sorting
- Docker
- Deployment

---

## Author

**Yuvraj Singh Rathore**

Computer Science Student | Backend Developer (Learning)