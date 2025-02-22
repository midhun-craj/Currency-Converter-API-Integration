📜 API_DOCS.md
md
Copy
Edit
# 🌍 Currency Converter API - API Documentation 📖

This API provides real-time exchange rates and currency conversion functionality using a public exchange rates API.

---

## 🛠 Base URL
http://localhost:8080

yaml
Copy
Edit

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
Fetches exchange rates based on the provided base currency.
Default base currency is USD if not provided.
Request Parameters
Parameter	Type	Required	Description
base	String	❌ No (Default: USD)	Base currency for exchange rates
Example Request
http
Copy
Edit
GET /api/rates?base=USD
Example Response
json
Copy
Edit
{
  "base": "USD",
  "rates": {
    "EUR": 0.945,
    "GBP": 0.82,
    "INR": 83.12
  }
}
🔄 2️⃣ Convert Currency
Endpoint
http
Copy
Edit
POST /api/convert
Converts an amount from one currency to another.
Request Body
Field	Type	Required	Description
from	String	✅ Yes	Currency code to convert from (e.g., "USD")
to	String	✅ Yes	Currency code to convert to (e.g., "EUR")
amount	Double	✅ Yes	Amount to be converted
Example Request
json
Copy
Edit
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
Example Response
json
Copy
Edit
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}
⚠️ Error Responses
Your API should handle various errors gracefully.

1️⃣ Invalid Currency Code
Response Code: 400 Bad Request

json
Copy
Edit
{
  "error": "Invalid currency code: XYZ"
}
2️⃣ External API Unavailable
Response Code: 503 Service Unavailable

json
Copy
Edit
{
  "error": "Unable to fetch exchange rates. Please try again later."
}
🧪 Testing the API
Use Postman or cURL to send GET/POST requests.
Run integration tests using:
sh
Copy
Edit
mvn test
📖 Additional Notes
Data is retrieved from an external Exchange Rate API.
Currency rates are updated dynamically.
The API follows RESTful best practices.
🛡 License
This project is licensed under the MIT License.
