# Currency Converter API Integration 🌍💰

A Spring Boot application that integrates with an external currency conversion API to fetch real-time exchange rates.

## Features 🚀
✔ Fetch real-time exchange rates from an external API  
✔ Convert currency values dynamically  
✔ REST API endpoints for easy integration  
✔ Built using **Spring Boot**, **Java**, and **Maven**  

---

## 🛠 Prerequisites
Before running the project, ensure you have the following installed:
- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) or any IDE of choice
- Internet connection (for API requests)

---

## 🚀 How to Run Locally

### **Step 1: Clone the Repository**
```sh
git clone https://github.com/midhun-craj/Currency-Converter-API-Integration.git
cd Currency-Converter-API-Integration
```

### **Step 2: Set Up API Key**
This project requires an API key for fetching exchange rates. Update application.properties with your API key and API url:
```sh
exchange.api.url=YOUR_API_URL_HERE
exchange.api.key=YOUR_API_KEY_HERE
```

### **Step 3: Build and Run the Application**
Using Maven (Recommended)
```sh
mvn clean install
mvn spring-boot:run
```
Using IntelliJ IDEA
1. Open the project in IntelliJ or Eclipse or or any IDE of choice.
2. Navigate to CurrencyConverterApplication.java.
3. Click Run or use the shortcut Shift + F10 (F11 in case if you're using eclipse).

---

## 📌 API Endpoints

### **1️⃣ Fetch Exchange Rates**
**GET** `/api/rates?base=USD`

Returns exchange rates for the given base currency (default: `USD`).

#### Example Response:
```json
{
  "base": "USD",
  "rates": {
    "EUR": 0.945,
    "GBP": 0.82,
    "INR": 83.12
  }
}
```

### **2️⃣ Convert Currency**
POST /api/convert

Converts an amount from one currency to another.

Request Body:
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
```
Response:
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}
```

---

## **⚠️ Error Handling**
This application includes centralized error handling for common issues:

1. **Invalid Currency Codes** (`400 Bad Request`)  
   - If an unsupported or incorrect currency code is provided, the API returns:
     ```json
     {
       "error": "Invalid currency code: `INVALID_CODE`",
       "status": 400
     }
     ```

2. **Unexpected Errors** (`500 Internal Server Error`)  
   - If an unknown error occurs, the API returns:
     ```json
     {
       "error": "An unexpected error occurred",
       "status": 500
     }
     ```

---

## **🛠 Setup & Run Locally**
### **1️⃣ Clone the Repository**

```sh
git clone https://github.com/yourusername/currency-converter-api.git
cd currency-converter-api
```

### **2️⃣ Build & Run the Application**

For Mac/Linux:
```sh
./mvnw spring-boot:run
```

For Windows:
```sh
mvnw.cmd spring-boot:run
```

### **3️⃣ Run Tests**
```sh
mvn test
```

## **🛑 Stopping the Application**
To stop the application, press Ctrl + C in the terminal.

## **🏗 Technology Stack**
Java 17 <br/>
Spring Boot 3 <br/>
Spring WebFlux (WebClient) <br/>
JUnit 5 & Reactor Test <br/>
Maven for Dependency Management <br/>

## **🛡 License**
This project is licensed under the MIT License.
