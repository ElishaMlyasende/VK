# VK – Enterprise Spring Boot Microservices System

## 📌 Overview

**VK** is an enterprise-grade backend system built using **Spring Boot and Spring Cloud Microservices architecture**.
The system is designed to support **modular business operations**, secure authentication, document management, financial tracking, and scalable service integration.

This architecture is suitable for **government systems, enterprise platforms, and decision-support (wizard-based) applications** such as agriculture advisory systems.

---

## 🏗️ System Architecture

The project follows a **Microservices Architecture** with centralized routing and service discovery.

```
Client (Web / Mobile)
        |
   API Gateway
        |
-------------------------
|        |        |     |
Auth   User   Office  Case
Svc    Svc    Ops     Mgmt
        |
     MySQL DB
```

### Key Architectural Components:

* **API Gateway** – Central entry point for all services
* **Eureka Server** – Service discovery and registration
* **Independent Microservices** – Loosely coupled and scalable
* **Shared DTO Module** – Consistent data transfer between services

---

## 🧩 Modules Description

### 🔐 AUTH-SERVICE

* Handles authentication and authorization
* JWT-based security
* Role-based access control (ADMIN, USER, OFFICER)

### 👤 UserService

* User management
* Profile and role handling
* Integrated with Auth Service

### 🌐 apigateway

* Routes requests to appropriate services
* Centralized security & request filtering

### 🏢 OfficeOperation

* Manages internal office workflows
* Supports document tracking and operational processes

### ⚖️ caseManagement

* Case registration and tracking
* Status management and reporting

### 💰 cashBook

* Financial record management
* Supports income and expense tracking

### 📁 uploads

* File upload and document storage service

### 📦 shareDTO

* Shared Data Transfer Objects
* Ensures consistency across microservices

### 📡 eureka-server

* Service registry and discovery server
* Enables dynamic microservice communication

---

## 🛠️ Technology Stack

### Backend

* Java 17+
* Spring Boot
* Spring Cloud (Eureka, Gateway)
* Spring Security (JWT)
* Spring Data JPA / Hibernate

### Database

* MySQL / MariaDB

### Tools & Environment

* Maven
* Git & GitHub
* Linux / Windows
* REST APIs

---

## ▶️ How to Run the Project (Local Setup)

### 1️⃣ Clone Repository

```bash
git clone https://github.com/ElishaMlyasende/VK.git
cd VK
```

### 2️⃣ Start Eureka Server

```bash
cd eureka-server
mvn spring-boot:run
```

### 3️⃣ Start API Gateway

```bash
cd apigateway
mvn spring-boot:run
```

### 4️⃣ Start Services

Run each service individually:

```bash
mvn spring-boot:run
```

> ⚠️ Ensure MySQL is running and database credentials are correctly configured in `application.yml`

---

## 🔐 Security

* JWT Authentication
* Centralized authorization via API Gateway
* Secure inter-service communication

---

Wizard logic can be implemented using:

* Config-driven rules
* Database-based decision flows
* REST APIs for frontend integration

---

## 📈 Future Enhancements

* Docker & Kubernetes deployment
* Centralized logging (ELK Stack)
* Configuration Server (Spring Cloud Config)
* Automated tests (JUnit & Mockito)

---

## 👨‍💻 Author

**Elisha Mlyasende**
Backend Developer – Spring Boot | Microservices | APIs
GitHub: [https://github.com/ElishaMlyasende](https://github.com/ElishaMlyasende)

---

## 📄 License

This project is licensed for educational and enterprise demonstration purposes.
