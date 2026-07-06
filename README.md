# AI-Powered Smart Job Portal

An AI-powered backend Job Portal built using Java, Spring Boot, Spring Data JPA (Hibernate), MySQL, and REST APIs. The application enables job and candidate management, resume upload, and AI-based resume skill extraction using the Groq API.

## Features

- Candidate registration and management
- Job posting and management
- Resume upload and storage
- AI-powered resume skill extraction using Groq LLM API
- RESTful API architecture
- MySQL database integration
- CRUD operations using Spring Data JPA (Hibernate)
- API testing with Postman

## Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- REST APIs
- Groq API (Llama LLM)
- Maven
- Postman

## Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── config
└── resources
```

## AI Feature

The application integrates the Groq API to analyze uploaded resume content and automatically extract technical skills using a Large Language Model (LLM). This helps recruiters quickly identify candidate skills.

## API Endpoints

### Candidate APIs
- Register Candidate
- Get Candidate by ID
- Get All Candidates
- Update Candidate
- Delete Candidate

### Job APIs
- Create Job
- Get All Jobs
- Update Job
- Delete Job

### Resume APIs
- Upload Resume
- Download Resume

### AI API
- Extract Skills from Resume

## Configuration

Create an `application.properties` file and configure the following properties:

```properties
spring.datasource.url=YOUR_DATABASE_URL
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD

groq.api.key=YOUR_GROQ_API_KEY
```

**Note:** Do not commit your actual API key or database credentials to GitHub.

## How to Run

1. Clone the repository.
2. Configure MySQL and update `application.properties`.
3. Add your Groq API key.
4. Run the Spring Boot application.
5. Test the REST APIs using Postman.

## Future Enhancements

- Frontend integration (JSP/React/Angular)
- Spring Security with JWT Authentication
- Role-based access control (Admin, Recruiter, Candidate)
- AI-based resume-job matching
- Candidate recommendation system
- Email notifications
- Interview scheduling
- Docker deployment

## Author

**Shruti Dalal**
