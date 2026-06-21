# Book Catalog & Review API

A Spring Boot REST API for managing a library catalog and book reviews. The project utilizes Spring Data JPA for persistence and an in-memory H2 database for development.

## Tech Stack
* **Java 21** (LTS)
* **Spring Boot 3.x**
* **Spring Data JPA** (Hibernate ORM)
* **H2 Database** (In-Memory)
* **Lombok**
* **Jakarta Validation**

## Features
* **Full CRUD Operations:** Support for creating, reading, updating, and deleting books.
* **Relational Mapping:** A bidirectional One-to-Many relationship mapping books to reviews.
* **Request Validation:** Inputs are validated at the controller level (e.g., non-blank fields, rating bounds between 1-5, and valid publication years).
* **Database Constraint Handling:** Prevents duplicate ISBN records in the database.
* **In-IDE API Testing:** Includes an `.http` test script to execute requests directly inside IntelliJ.

## API Endpoints

### Books
* `GET /api/books` - Retrieve all books.
* `GET /api/books/{id}` - Retrieve a specific book by its ID (returns 404 if not found).
* `POST /api/books` - Add a new book (returns 201 Created).
* `PUT /api/books/{id}` - Update details of an existing book.
* `DELETE /api/books/{id}` - Delete a book (returns 204 No Content).

### Reviews
* `POST /api/books/{bookId}/reviews` - Add a review to a specific book.

---

### Request Payloads (Examples)

**Add a Book (`POST /api/books`):**
```json
{
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "isbn": "978-0261102217",
  "publishedYear": 1937
}
```

**Add a Review (`POST /api/books/{bookId}/reviews`):**
```json
{
  "reviewerName": "Alan",
  "rating": 5,
  "comment": "An absolute classic."
}
```

---

## How to Run

1. Clone this repository:
   ```bash
   git clone <repository-url>
   cd book-catalog-api
   ```
2. Run the application using the Maven Wrapper:
   * **Windows:**
     ```powershell
     .\mvnw.cmd spring-boot:run
     ```
   * **macOS/Linux:**
     ```bash
     ./mvnw spring-boot:run
     ```
3. The server will start on port `8080`.
4. Access the H2 Database Console at `http://localhost:8080/h2-console`
   * **JDBC URL:** `jdbc:h2:mem:bookdb`
   * **Username:** `sa`
   * **Password:** `password`

## Testing
You can test the endpoints using the provided [api-tests.http](api-tests.http) file directly within IntelliJ IDEA.
