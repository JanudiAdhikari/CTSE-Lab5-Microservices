# 🧩 Microservices Lab – SE4010

## Project Overview
This project is a simple microservices system built using Spring Boot and Spring Cloud Gateway.

It includes 4 services:
- Item Service
- Order Service
- Payment Service
- API Gateway

The API Gateway is the single entry point. It forwards requests to the correct microservice.

---

## System Architecture
Client → API Gateway → Microservices

- All requests go through the API Gateway (Port 8080)
- Each microservice runs on its own port
- All services run using Docker + Docker Compose

---

## Services and Ports

### 1) Item Service (Port 8081)
Handles item management.

Endpoints:
- `GET /items` : get all items
- `POST /items` : add a new item
- `GET /items/{id}` : get item by index

Example POST body:
```json
{ "name": "Headphones" }
```

### 2) Order Service (Port 8082)
Handles order management.

Endpoints:
- `GET /orders` : get all orders
- `POST /orders` : place a new order
- `GET /orders/{id}` : get order by id

Example POST body:
```json
{ "item": "Laptop", "quantity": 2, "customerId": "C001" }
```

### 3) Payment Service (Port 8083)
Handles payment processing.

Endpoints:
- `GET /payments` : get all payments
- `POST /payments/process` : process a payment
- `GET /payments/{id}` : get payment by id

Example POST body:
```json
{ "orderId": 1, "amount": 1299.99, "method": "CARD" }
```

### 4) API Gateway (Port 8080)
Routes requests to the correct microservice.

Routing:
- `/items/**` → Item Service
- `/orders/**` → Order Service
- `/payments/**` → Payment Service

## Base URL
All requests should be sent through the gateway:
```
http://localhost:8080
```

## Docker Setup

### Step 1: Build JAR files
Run this inside each service folder:
```bash
mvn clean package -DskipTests
```

Do this for:
- `item-service`
- `order-service`
- `payment-service`
- `api-gateway`

### Step 2: Build Docker images
From the project root folder:
```bash
docker compose build
```

### Step 3: Run all services
From the project root folder:
```bash
docker compose up
```

To run in background:
```bash
docker compose up -d
```

To stop:
```bash
docker compose down
```

## API Testing (Postman)
Postman collection is included in:
```
postman/Microservices_Lab.postman_collection.json
```

You can import it and test all endpoints through the gateway.