# Microservices Lab – SE4010

## 📌 Project Overview

This project implements a simple microservices-based system using Spring Boot and Spring Cloud Gateway.

The system consists of four independent microservices:

- **Item Service**
- **Order Service**
- **Payment Service**
- **API Gateway**

The API Gateway acts as a single entry point and routes incoming requests to the appropriate microservice.

---

## 🏗️ System Architecture

Client → API Gateway → Microservices

- All external requests go through the API Gateway (Port 8084).
- Each microservice runs independently on its own port.
- Services are containerized using Docker and connected via Docker Compose.

---

## 🧩 Microservices

### 1️⃣ Item Service (Port 8081)
Handles item management.

**Responsibilities:**
- Create new items
- Retrieve all items

---

### 2️⃣ Order Service (Port 8082)
Handles customer orders.

**Responsibilities:**
- Create new orders
- Retrieve all orders

---

### 3️⃣ Payment Service (Port 8083)
Handles payment processing.

**Responsibilities:**
- Process payments
- Retrieve all payment records

---

### 4️⃣ API Gateway (Port 8084)
Routes requests to the appropriate microservice.

Example Routing:
- `/items/**` → Item Service
- `/orders/**` → Order Service
- `/payments/**` → Payment Service

---

## 🌐 Base URL

All API requests must go through: http://localhost:8084

---

## 🐳 Docker Setup

### 1️⃣ Build JAR files

Run inside each service folder:

`mvn clean package -DskipTests`

### 2️⃣ Build Docker Images

From project root:

`docker compose build`

### 3️⃣ Run All Services

`docker compose up`

Or run in background:

`docker compose up -d`

---

## 📮 API Testing Evidence

The Postman collection used for testing is available in:

📁 **postman/Microservices_Lab.postman_collection.json**
