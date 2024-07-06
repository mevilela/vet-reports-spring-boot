# Vet Reports

## Introduction

Welcome to Vet Reports, your partner in veterinary excellence. Vet Reports is a web application built with Spring Boot and Thymeleaf, designed for managing veterinary ultrasound reports using an H2 in-memory database for initial development.

## Technologies Used

- **Spring Boot**: Framework for building APIs and web applications in Java.
- **Thymeleaf**: Server-side Java template engine for rendering HTML templates.
- **H2 Database**: In-memory database for initial development and testing.
- **Spring Data JPA**: Persistence layer for interacting with databases.
- **Swagger**: API documentation tool for easy endpoint exploration.

## Endpoints

### Vet Controller

- **GET** `/vets/create`: Display form for creating a new vet.
- **POST** `/vets/create`: Process submission of a new vet.
- **GET** `/vets/list`: Retrieve a list of all vets.
- **DELETE** `/vets/{id}`: Delete a vet by ID.

### Report Controller

- **GET** `/reports/create`: Display form for creating a new report.
- **POST** `/reports/create`: Process submission of a new report.
- **GET** `/reports/list`: Retrieve a list of all reports.
- **GET** `/reports/list/{id}`: Retrieve details of a report by ID.
- **GET** `/reports/details/{id}`: Retrieve detailed information of a report by ID.
- **DELETE** `/reports/{id}`: Delete a report by ID.

### Client Controller

- **GET** `/clients/create`: Display form for creating a new client.
- **POST** `/clients/create`: Process submission of a new client.
- **GET** `/clients/list`: Retrieve a list of all clients.
- **GET** `/clients/details/{id}`: Retrieve details of a client by ID.
- **DELETE** `/clients/{id}`: Delete a client by ID.

### Animal Controller

- **GET** `/animals/edit/{id}`: Display form for editing an animal by ID.
- **POST** `/animals/edit/{id}`: Process submission of edited animal details.
- **GET** `/animals/create`: Display form for creating a new animal.
- **POST** `/animals/create`: Process submission of a new animal.
- **GET** `/animals/list`: Retrieve a list of all animals.
- **DELETE** `/animals/{id}`: Delete an animal by ID.

### Home Controller

- **GET** `/`: Displays the home page of the application.

## Limitations

- **No Spring Security**: Currently lacks authentication and authorization mechanisms.
- **Basic Error Handling**: Limited custom error handling for specific use cases.
- **Lack of PUT Operations**: PUT operations are currently not implemented for updating resources.


Accessing Thymeleaf Templates
-----------------------
After starting the application, navigate to the following URLs in your browser to access Thymeleaf templates:

- [http://localhost:8080](http://localhost:8080) (Home Page)

Accessing Swagger API Documentation
-----------------------
Swagger API documentation provides interactive documentation for the API endpoints. After starting the application, navigate to the following URL in your browser to access Swagger:

- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Usage
Before using the API, make sure to set up the necessary configurations and dependencies.
Refer to the provided endpoint documentation for details on each endpoint's functionality and required parameters.

## How To Run
### Running the application Locally
`mvn clean install`
`mvn spring-boot:run`

### Prerequisites
- JDK 8 or higher installed
- Maven 3.x installed