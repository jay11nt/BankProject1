
# Bank Customer API

🔸 A Spring Boot RESTful API for managing bank customer information with address details.

## Overview-
This project provides a comprehensive solution for managing customer records in a banking application. It follows REST principles and includes validation, exception handling, and entity relationships.

## Features-
- Customer management with comprehensive personal details
- Address management with one-to-one relationship to customers
- Input validation for all customer fields
- Global exception handling
- RESTful API design
- Database integration with JPA/Hibernate

## Tech Stack-

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- Jakarta Validation API
- MySQL Database
- Lombok
- Maven

## Data Models- 

### Customer:

The Customer entity includes the following attributes:

- customerId (auto-generated)
- firstName (3-15 characters, required)
- maidenName (3-15 characters, required)
- lastName (3-15 characters, required)
- gender (required)
- motherName (3-15 characters, required)
- fatherName (3-15 characters, required)
- dateofBirth (format: dd/MM/yyyy, required)
- panNumber (exactly 5 capital letters, required)
- mobNumber (10 digits, required)
- aadharNumber (12 digits, required)
- occupationType (must be one of: Student, Self-Employed, Service, Business, Retired, Housewife, Other)

### Address:

The Address entity includes:

- addressId (auto-generated)
- addressType (required, e.g., "Permanent", "Temporary")
- homeNo
- pincode
- street
- city
- state
- country
- customer (one-to-one relationship with Customer)

### API Endpoints

| Method | Endpoint                        | Description                                   |
|--------|---------------------------------|-----------------------------------------------|
| POST   | /api/customers/save             | Create a new customer record                  |
| GET    | /api/customers/get/{id}         | Retrieve a specific customer by ID            |
| GET    | /api/customers/getall           | Retrieve all customers                        |
| PUT    | /api/customers/update/{id}      | Update a customer record by ID                |
| DELETE | /api/customers/delete/{id}      | Delete a customer record by ID                |

### Request/Response Format:

**Create Customer:**

**Request:**

    POST /api/customers/save
    {
      "firstName": "John",
      "maidenName": "Smith",
      "lastName": "Doe",
      "gender": "Male",
      "motherName": "Jane",
      "fatherName": "James",
      "dateofBirth": "15/05/1990",
      "panNumber": "ABCDE",
      "mobNumber": 9876543210,
      "aadharNumber": "123456789012",
      "occupationType": "Service",
      "address": {
        "addressType": "Permanent",
        "homeNo": "42",
        "pincode": "560001",
        "street": "MG Road",
        "city": "Bangalore",
        "state": "Karnataka",
        "country": "India"
      }
    }

**Response:**

        {
          "customerId": 1,
          "firstName": "John",
          "maidenName": "Smith",
          "lastName": "Doe",
          "gender": "Male",
          "motherName": "Jane",
          "fatherName": "James",
          "dateofBirth": "15/05/1990",
          "panNumber": "ABCDE",
          "mobNumber": 9876543210,
          "aadharNumber": "123456789012",
          "occupationType": "Service",
          "address": {
            "addressId": 1,
            "addressType": "Permanent",
            "homeNo": "42",
            "pincode": "560001",
            "street": "MG Road",
            "city": "Bangalore",
            "state": "Karnataka",
            "country": "India"
          }
        }

**Error Handling:**

The application implements a global exception handler for several types of exceptions:

**CustomerNotFound:** When a requested customer ID doesn't exist

**MethodArgumentNotValidException:** Input validation errors

**IllegalArgumentException:** Invalid argument types
**NoHandlerFoundException:** Endpoint not found
Generic exceptions

**Error responses include:**

- Timestamp
Error message
Error details
