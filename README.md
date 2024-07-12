### I. Write Spring Boot Restful with below conditions

## API Endpoint Breakdown

### Add a Car
- **POST**:
  - Add Hyundai Avante:
    ```
    http://localhost:8080/cars/add?name=Hyundai Avante&wheels=4
    ```
  - Add Suzuki GSX-R600:
    ```
    http://localhost:8080/cars/add?name=Suzuki GSX-R600&wheels=2
    ```

### Get Car Details
- **GET**:
  - Get details for a 4-wheel car:
    ```
    http://localhost:8080/cars/ask?name=4-wheel-car
    ```
  - Get details for a 2-wheel car:
    ```
    http://localhost:8080/cars/ask?name=2-wheel-car
    ```
  - Get details for all cars:
    ```
    http://localhost:8080/cars/ask?name=all
    ```
  - Stop IDE Program:
    ```
    http://localhost:8080/cars/ask?name=Bye
    ```

### Get Car by Name
- **GET**:
  - Get details for Hyundai Sonata:
    ```
    http://localhost:8080/cars/ask?name=Hyundai Sonata
    ```

### II. Write SQL statement


# Customer and Account Information

This repository contains two tables, `CUST_ACCOUNT_INFO` and `CUSTOMER_INFO`, detailing customer accounts and related customer information.

## CUST_ACCOUNT_INFO

| Branch Code | Account No | Account Name | Customer No | Currency Code | Account Type |
|-------------|------------|--------------|-------------|---------------|--------------|
| 001         | 55667788   | ACDESC_12345 | 0000037     | USD           | Saving       |
| 001         | 66668888   | ACDESC_12346 | 0000001     | USD           | Saving       |
| 001         | 11111831   | ACDESC_12347 | 0000036     | USD           | Saving       |
| 001         | 30041997   | ACDESC_12348 | 0000046     | USD           | VIP Saving   |
| 002         | 01031990   | ACDESC_12349 | 0000056     | USD           | VIP Saving   |
| 002         | 79608869   | ACDESC_12350 | 0000058     | USD           | Current      |
| 002         | 68117866   | ACDESC_12351 | 0000058     | KHR           | Current      |
| 002         | 77775555   | ACDESC_12352 | 0000062     | USD           | Current      |
| 003         | 56111188   | ACDESC_12353 | 0000063     | USD           | Current      |
| 003         | 51188889   | ACDESC_12354 | 0000063     | KHR           | Current      |
| 003         | 88886868   | ACDESC_12355 | 0000061     | USD           | Current      |
| 004         | 17523523   | ACDESC_12356 | 0000035     | USD           | Saving       |
| 004         | 24061999   | ACDESC_12357 | 0000042     | USD           | Saving       |
| 004         | 99998888   | ACDESC_12358 | 0000051     | USD           | Saving       |
| 004         | 88889999   | ACDESC_12359 | 0000053     | USD           | Saving       |

## CUSTOMER_INFO

| Customer No | Customer Name |
|-------------|---------------|
| 0000037     | CUST_12345    |
| 0000001     | CUST_12346    |
| 0000036     | CUST_12347    |
| 0000046     | CUST_12348    |
| 0000056     | CUST_12349    |
| 0000058     | CUST_12350    |
| 0000058     | CUST_12351    |
| 0000062     | CUST_12352    |
| 0000063     | CUST_12353    |
| 0000063     | CUST_12354    |
| 0000061     | CUST_12355    |
| 0000035     | CUST_12356    |
| 0000042     | CUST_12357    |
| 0000051     | CUST_12358    |
| 0000053     | CUST_12359    |
| 0000099     | CUST_12360    |

### Overview

The `CUST_ACCOUNT_INFO` table includes details about various accounts held by customers, such as branch code, account number, account name, customer number, currency code, and account type. The `CUSTOMER_INFO` table provides information about customers, including customer number and customer name.

### Usage

This data can be used for various purposes such as:

- Generating reports on customer accounts.
- Analyzing customer data for business insights.
- Integrating with other systems for customer relationship management.

### Questions

1. Count each branch how many accounts do they have?
2. Find customers who have more than one account?
3. Find customers who don’t have account yet?

### SQL Queries

To answer the questions above, you can use the following SQL queries:

1. **Count each branch how many accounts do they have:**

    ```sql
    SELECT branchcode, COUNT(*) AS accountCount
    FROM CUST_ACCOUNT_INFO
    GROUP BY branchcode;
    ```

2. **Find customers who have more than one account:**

    ```sql
    SELECT CustomerNo, COUNT(*) AS AccountCount
    FROM CUST_ACCOUNT_INFO
    GROUP BY CustomerNo
    HAVING COUNT(*) > 1;
    ```

3. **Find customers who don’t have an account yet:**

    ```sql
    SELECT c.CustomerNo, c.CustomerName
    FROM CUSTOMER_INFO c
    LEFT JOIN CUST_ACCOUNT_INFO a 
    ON c.CustomerNo = a.CustomerNo
    WHERE a.CustomerNo IS NULL;
    ```

For more information or contributions, please refer to the repository.
