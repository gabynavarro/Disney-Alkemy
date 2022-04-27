# Disney-Alkemy
Proyecto explorar el mundo disney

# Spring Boot & Postman

Desarrollo de una API para explorar el mundo de Disney de Alkemy, la cual permite conocer y modificar los personajes que este mundo y entender en qué películas o series participan estos personajes.

## Las tecnologías ocupadas con :neckbeard:

### BACKEND

- [PostgreSQL 12.9](https://www.postgresql.org/download/) - Base de datos
- [DbVisualizer](https://www.dbvis.com/) - Herramienta de administración de datos 
- [Java 11](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html) - Lenguaje de programacion
- [Maven 4.0.0](https://maven.apache.org/index.html) - Manejador de dependencias
- [Spring-Boot](https://spring.io/projects/spring-boot) - Framework

## Link Swagger: http://localhost:8080/swagger-ui/index.html

#### Setup Environment Variables

    SendGrid API KEY to be able to send email. Web: https://sendgrid.com/

EMAIL_API_KEY = key

## SEDDERS

### USERS SEED

| email              | role  |  
|--------------------|-------|
| admin{id}@test.com | admin | 
| user{id}@test.com  | user  | 

By default, 3 users with admin role and 3 users with user role will be created where the {id} in
the email is a number from 0 to 3 per role. All the users have "12345678" as password.

### ROLES SEED

| id |  description |  name   |
|----|--------------|---------| 
| 1  |  ROLE_USER   |  USER   |
| 2  |  ROLE_ADMIN  |  ADMIN  | 

