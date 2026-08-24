# Job API - Spring Boot REST API

A RESTful Job Management API built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. This project started as an in-memory CRUD application using `ArrayList` and was progressively refactored into a layered backend following industry practices.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Bean Validation

---

## Features

- Create a Job
- Get all Jobs (with pagination)
- Get Job by ID
- Update Job
- Delete Job
- Search Job by Title *(service layer ready, REST endpoint in progress)*
- Request validation on Create/Update
- Centralized exception handling with structured error responses

---

## Project Structure

```
src
├── controller
├── dto
├── exception
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
Request DTO (validated)
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

Errors at any layer are caught by a Global Exception Handler
and returned as a structured ErrorResponse.
```

---

## DTOs

### Request DTOs

- `CreateJobRequest` — validated with `@NotBlank`, `@NotNull`, `@Positive`
- `UpDateJobRequest` — validated with `@NotBlank`, `@NotNull`, `@Positive`

### Response DTOs

- `AllJobResponse` — lightweight summary (id, title, company, salary)
- `JobDetailResponse` — full job detail

The API communicates only through DTOs while entities remain internal to the application.

---

## Exception Handling

- `JobNotFoundException` — thrown when a job ID doesn't exist (get/update/delete)
- `GlobalExceptionHandler` — `@ControllerAdvice` that maps exceptions to proper HTTP status codes
- `ErrorResponse` — consistent JSON error shape: `message`, `status`, `timestamp`

---

## Pagination

`GET /jobs` now accepts standard `Pageable` query params (`page`, `size`, `sort`), defaulting to page `0` with a size of `3`.

Example:
```
GET /jobs?page=0&size=5&sort=jobTitle,asc
```

---

## REST Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/jobs` | Get all jobs (paginated) |
| GET | `/jobs/{id}` | Get job by ID |
| POST | `/jobs` | Create new job (validated) |
| PUT | `/jobs` | Update job (validated) |
| DELETE | `/jobs/{id}` | Delete job |

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
- Bean Validation
- Global Exception Handling
- Pagination & Sorting

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
- Validation
- Global Exception Handling
- Pagination & Sorting

Upcoming improvements:

- Entity Relationships
- Spring Security + JWT Authentication
- Docker
- Deployment

---

## Author

**Yuvraj Singh Rathore**

Computer Science Student | Backend Developer (Learning)
