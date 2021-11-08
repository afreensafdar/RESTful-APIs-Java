# RESTful-APIs-Java
Module 2- Intro to REST- Multiverse
- Implementing a RESTful CRUD API for product in Spring Boot Java and integrating with MySql Workbench
- Spring Initializr https://start.spring.io/
- Dependencies : Spring Web ,Spring Data Jpa ,MySQL Driver 
- Java version 8
- Maven
- MySQL Desktop 5.6 =>MySQL workbench 6
- Test CRUD operations -Postman
- JWT to access token https://auth0.com

Create Table in MySQL workbench: 
CREATE TABLE product (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
brand varchar(45) NOT NULL,
  price float NOT NULL,
  PRIMARY KEY (`id`)
);


