# Library REST API

A Spring Boot 3.2.x application for managing a library system using REST APIs.

## Features

- Create and list Authors
- Create and list Books
- Filter Books by Author
- Uses H2 in-memory database
- DTOs to avoid recursion issues

## Technologies

- Java 17
- Spring Boot 3.2.x
- Spring Data JPA
- H2 Database
- Maven

## Installation

1. Clone the repository:

```bash
git clone https://github.com/Ravikiran1981/library-rest.git
cd library-rest

API Endpoints
Authors

GET /api/authors – List all authors

POST /api/authors – Create a new author

Request Body Example:

{
  "name": "Kiran"
}

Books

GET /api/books – List all books

GET /api/books?authorId=1 – List books by author

POST /api/books?authorId=1 – Create a new book for a specific author

Request Body Example:

{
  "title": "Pride and Prejudice",
  "isbn": "111-222-333"
}


