# 🌍 Currency Converter API - API Documentation 📖

This API provides real-time exchange rates and currency conversion functionality using a public exchange rates API.

---

## 🛠 Base URL
```
http://localhost:8080
```

---

## 📌 Endpoints Overview

| Method | Endpoint            | Description |
|--------|---------------------|-------------|
| GET    | `/api/rates?base=USD`  | Fetch exchange rates for the given base currency (default: `USD`) |
| POST   | `/api/convert`      | Convert an amount from one currency to another |

---

## 📡 **1️⃣ Fetch Exchange Rates**
### **Endpoint**
```http
GET /api/rates?base=USD
```
1. Fetches exchange rates based on the provided base currency.
2. Default base currency is USD if not provided.

### **Example Request**
```http
GET /api/rates?base=INR
```
### **Example Response**
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

## **🔄 2️⃣ Convert Currency**
### **Endpoint**
```http
POST /api/convert
```
1. Converts an amount from one currency to another.

### **Example Request**
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
```
### **Example Response**
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}
```

## **⚠️ Error Responses**
Your API should handle various errors gracefully.

### **1️⃣ Invalid Currency Code**
Response Code: 400 Bad Request
```json
{
  "error": "Invalid currency code: XYZ"
}
```
### **2️⃣ External API Unavailable**
Response Code: 503 Service Unavailable

```json
{
  "error": "Unable to fetch exchange rates. Please try again later."
}
```

## **🧪 Testing the API**
1. Use Postman or URL to send GET/POST requests.
2. Run integration tests using
```sh
mvn test
```

---

## **📖 Additional Notes**
1. Data is retrieved from an external Exchange Rate API.
2. Currency rates are updated dynamically.
3. The API follows RESTful best practices.

---

## **🛡 License**
This project is licensed under the MIT License.
