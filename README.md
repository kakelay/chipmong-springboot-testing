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
