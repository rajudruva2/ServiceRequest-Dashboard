# IT Service Desk - Spring Boot

A Maven-based Spring Boot application for managing IT support tickets.

## Features

- Spring Boot REST API
- Spring Data JPA
- H2 database
- CRUD ticket APIs
- Pagination
- Search
- Status, priority and category filters
- Dashboard summary
- Validation
- Simple browser frontend
- H2 console
- Actuator health endpoint

## Requirements

- Java 17+
- Maven 3.9+

## Build

```bash
mvn clean package
```

## Run

```bash
mvn spring-boot:run
```

Or:

```bash
java -jar target/it-service-desk-1.0.0.jar
```

Open:

```text
http://localhost:8080/
```

## APIs

```text
GET    /api/tickets
GET    /api/tickets/{id}
POST   /api/tickets
PUT    /api/tickets/{id}
DELETE /api/tickets/{id}
GET    /api/tickets/summary
```

Examples:

```bash
curl "http://localhost:8080/api/tickets?page=0&size=10"
curl "http://localhost:8080/api/tickets?status=OPEN"
curl "http://localhost:8080/api/tickets?priority=HIGH"
curl "http://localhost:8080/api/tickets?category=NETWORK"
curl "http://localhost:8080/api/tickets?search=VPN"
```

## Create ticket

```bash
curl -X POST http://localhost:8080/api/tickets   -H "Content-Type: application/json"   -d '{
    "title": "VPN connection issue",
    "requester": "John Smith",
    "category": "NETWORK",
    "priority": "HIGH",
    "assignedTo": "IT Support"
  }'
```

## H2 Console

```text
http://localhost:8080/h2-console
```

JDBC URL:

```text
jdbc:h2:mem:servicedesk
```

Username:

```text
sa
```

Password: leave blank.
