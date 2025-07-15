Project: RehabConnect - Patient Progress Tracker

Backend: Java + Spring Boot

# RehabConnect Backend

A backend service for logging and tracking physical therapy sessions.
Built with Java + Spring Boot and designed to be deployed on AWS (Lambda + API Gateway + Cognito) with support for relational or NoSQL databases.

## Features
- Patients can log daily rehab activities
- PTs can track progress and update rehab plans
- Secure user login with AWS Cognito
- RESTful API
- Supports multiple database backends (PostgreSQL, MySQL, or DynamoDB)

---

## Tech Stack
- Java 17
- Spring Boot 3
- AWS: Lambda, API Gateway, Cognito, S3 (optional)
- Databases: PostgreSQL (default), MySQL, or DynamoDB
- Build Tool: Maven
- Deployment: SAM CLI / AWS Console / Docker

---

## Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | /log     | Log rehab activity session |
| GET    | /progress/{patientId} | Retrieve progress logs |
| PUT    | /plan/{patientId} | Update patient rehab plan |

---

## Folder Structure
```
rehabconnect-backend/
├── src/
│   └── main/java/com/rehabconnect/
│       ├── controller/
│       ├── model/
│       ├── service/
│       └── repository/
├── resources/
│   └── application.yml
├── pom.xml
└── README.md
```

---

## Basic Setup
```bash
git clone https://github.com/yourusername/rehabconnect-backend.git
cd rehabconnect-backend
./mvnw spring-boot:run
```

## Coming Soon
- React Frontend (optional)
- GraphQL migration
- Docker deployment

---

## Architecture Overview
```
[Frontend (React/HTML)]
      ↓
[API Gateway (REST)]
      ↓
[AWS Lambda (Spring Boot)]
      ↓
[Relational DB (PostgreSQL/MySQL) or NoSQL (DynamoDB)]
      ↓
[Cognito (Auth)]
```

---

## Example Data Model (SQL/JSON)
```json
{
  "patientId": "abc-123",
  "date": "2025-06-23",
  "painLevel": 4,
  "exercises": ["Bridge", "Bird Dog"],
  "repsCompleted": 20
}
```

SQL Table Example:
```sql
CREATE TABLE session_logs (
  id SERIAL PRIMARY KEY,
  patient_id VARCHAR(255),
  session_date DATE,
  pain_level INTEGER,
  exercises TEXT[],
  reps_completed INTEGER
);
```

