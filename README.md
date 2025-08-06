// Project: RehabConnect - Patient Progress Tracker
// Backend: Java + Spring Boot

# RehabConnect Backend – Java + Spring Boot + PostgreSQL

A backend service for logging and tracking physical therapy sessions. Built with Java + Spring Boot and designed to be deployed on AWS (Lambda + API Gateway + Cognito) with support for relational or NoSQL databases.

---

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
- Databases: PostgreSQL (default),
- Build Tool: Maven
- Deployment: Docker

---
##  Project Management

- **Version Control:** Git + GitHub (repo used to manage all source code and version history)
- **Task Management:** Trello was used to plan the app, track feature development, and document progess https://trello.com/b/xohwri5Z/daily-task-management-template-for-project 

---

## Endpoints
| Method | Endpoint                 | Description                         |
|--------|--------------------------|-------------------------------------|
| POST   | `/log`                   | Log rehab activity session          |
| GET    | `/progress/{patientId}` | Retrieve progress logs              |
| PUT    | `/plan/{patientId}`     | Update patient rehab plan           |

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

## Setup Instructions
```bash
git clone https://github.com/yourusername/rehabconnect-backend.git
cd rehabconnect-backend
./mvnw spring-boot:run
```

Ensure PostgreSQL is running and the `rehabconnect` database is created.

---

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

### SQL Table Example
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
---
## Tested EndPoints August 6, 2025
### Endpoints For RehabPlan
POST /api/plan 
Creates a new rehab plan with patient id.
![Post:api:plan.png](..%2F..%2FPost%3Aapi%3Aplan.png)
GET /api/plan/{patientId}
Fetches a rehab Plan by patient id
![Get:api:plan:p123.png](..%2F..%2FGet%3Aapi%3Aplan%3Ap123.png)
PUT /api/plan/{patientId}
Update an existing rehab plan that exists 
![Put:api:plan:p123.png](..%2F..%2FPut%3Aapi%3Aplan%3Ap123.png)

### Endpoints For SessionLog

POST /api/log 
Log a new Session for a patient 
![Post:api:log.png](..%2F..%2FPost%3Aapi%3Alog.png)
GET /api/progress/{patientId}
Get all session logs for a patient from Id
![Get:api:progress:p123.png](..%2F..%2FGet%3Aapi%3Aprogress%3Ap123.png)
---

## License
MIT
