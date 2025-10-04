# Online Voting System

A simple full-stack online voting system built with Spring Boot, Vue.js, and MySQL.  
It demonstrates RESTful API design, stored procedures, and transactional operations with front–back separation.

## Features

- Public Voting — users can view all items and vote for one or multiple options.
- Admin Panel — manage items (create, update, delete, enable/disable).
- Stored Procedures — all DB operations run through MySQL stored procedures.
- Transaction Safety — multi-item voting uses transactions to ensure atomicity.

## Tech Stack

| Layer | Technology |
|-------|-------------|
| Frontend | Vue 3 + Vite |
| Backend | Spring Boot (Java 17+) |
| Database | MySQL 8 with Stored Procedures |
| Tools | Maven / npm |

## Project Structure

```
onlinevote-system/
├─ DB/              # SQL schema, views, and stored procedures
├─ vote-api/        # Spring Boot backend
├─ vote-frontend/   # Vue.js frontend
└─ README.md
```

## Quick Start

### 1. Setup Database
```sql
SOURCE DB/schema.sql;
SOURCE DB/views.sql;
SOURCE DB/sp_vote.sql;
SOURCE DB/sp_cast_votes.sql;
```

### 2. Configure Backend
Edit `application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/vote_db?useSSL=false
    username: root
    password: your_password
```

Run the backend:
```bash
cd vote-api
mvn spring-boot:run
```

### 3. Start Frontend
```bash
cd vote-frontend
npm install
npm run dev
```

## Example APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| GET | /api/public/items | Get all items with current vote counts |
| POST | /api/public/vote | Submit votes (transactional) |
| POST | /api/admin/items | Add new item |
| PUT | /api/admin/items/{id} | Update item |
| DELETE | /api/admin/items/{id} | Delete item |

## Security

- Uses prepared statements via JdbcTemplate to prevent SQL injection.
- Avoids storing credentials in Git; use environment variables or local config files.
- Frontend input is validated to reduce XSS risk.

## License

MIT License © 2025
