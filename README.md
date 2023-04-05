### Rental Properties Booking Application REST API

- This REST API was created by me(Rajashekhara A.E) for an Online Rental Properties Booking Application. This API handles all of the basic CRUD functions of any Rental Management Application platform, including user validation at each stage.

## Tech Stack

- Core Java
- Spring Framework
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- PostMan
- Swagger
- Lombok

### Features

- Login into the Application
- Authentication and validation for Tenant using the Spring Security and JWT Token.
- Tenant Profile Management
- View All Properties
- View Properties based on location, price
- Filter Properties based on ascending or descending order of price
- Updating Property Information
- LandLord Information
- Search and book rental properties
- View Tenant application 

## Installation & Run

- You need update the database configuration in the [application.properties](https://github.com/rajshekar11/dangerous-smash-6971/blob/main/TripMaker/src/main/resources/application.properties) file before launching the API server.
- Change the port number, username, and password to match your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/tripmaker;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=dbusername
    spring.datasource.password=dbpassword

```
In railway website configure variables

DB_HOST=
DB_NAME=
DB_PORT=
DB_USERNAME=root
DB_PASSWORD=
