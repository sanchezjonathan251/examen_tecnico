# 🧑‍💼 API de Gestión de Empleados

Aplicación RESTful desarrollada con Spring Boot para gestionar empleados. Incluye autenticación, documentación Swagger (OpenAPI), y buenas prácticas de arquitectura en capas.

---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.4.5
- Spring Web
- Spring Security
- Spring Data JPA
- Base de datos: H2
- Lombok
- Springdoc OpenAPI (Swagger)
- Maven

---

## 📦 Instalación y Ejecución

### 1. Clona el repositorio
Dentro del repositorio se encuentra parte de las evidencias de funcionamiento del Api así como la colección de endpoints en POSTMAN
Además se encuentra el código realizado en la carpeta (empleados)

```bash
git clone https://github.com/sanchezjonathan251/examen_tecnico.git
cd gestion-empleados


2. Configura application.properties, el puerto por default es el 8080
-/empleados/src/main/resources


spring.application.name=empleados


--La conexión a base de datos es a H2 en memoria
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true



logging.level.root=INFO
logging.level.com.prueba.empleados.service=DEBUG
logging.file.name=logs/app.log 
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} [%level] - %msg%n


3. Compila y ejecuta
bash

mvn clean install
mvn spring-boot:run




📚 Documentación Swagger
Una vez que la aplicación esté corriendo, accede a:

🔗 http://localhost:8080/swagger-ui/index.html#/

🔐 Seguridad
Los endpoints de /api/** están protegidos.

Swagger y la documentación se excluyen del filtro de seguridad:

java
.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()

🧪 Endpoints principales
Método	Ruta	Descripción
GET	/api/getAll/employee	Lista todos los empleados
POST	/api/register/employees	Crea un nuevo empleado
GET	/api/update/employees	Detalles de un empleado por ID
PUT	/api/delete/{id}	Actualiza los datos del empleado
DELETE	/security/login 	Elimina un empleado

📁 Estructura del Proyecto

Editar
├── main
│   ├── java
│   │   └── com
│   │       └── prueba
│   │           └── empleados
│   │               ├── config
│   │               ├── controller
│   │               ├── entity
│   │               ├── exceptions
│   │               ├── mapper
│   │               ├── record
│   │               ├── repository
│   │               ├── security
│   │               ├── service
│   │               └── utils
│   └── resources
│       ├── application.properties
│       ├── data.sql
│       ├── messages
│       │   └── messages.properties
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── prueba
                └── empleados
                    └── EmpleadosApplicationTests.java
👨‍💻 Autor
Jonathan Sanchez

📧 sanchezjonathan251@gmail.com



📝 Licencia
Este proyecto está licenciado bajo los términos de la MIT License.
