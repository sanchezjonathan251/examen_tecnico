# 🧑‍💼 API de Gestión de Empleados

Aplicación RESTful desarrollada con Spring Boot para gestionar empleados. Incluye autenticación, documentación Swagger (OpenAPI), y buenas prácticas de arquitectura en capas.

---

## 🚀 Tecnologías Utilizadas

- Java 17+
- Spring Boot 3.4.5
- Spring Web
- Spring Security
- Spring Data JPA
- Base de datos: H2 / MySQL / PostgreSQL *(ajustar según corresponda)*
- Lombok
- Springdoc OpenAPI (Swagger)
- Maven

---

## 📦 Instalación y Ejecución

### 1. Clona el repositorio

```bash
git clone https://github.com/jonathansanchez/gestion-empleados.git
cd gestion-empleados
2. Configura application.properties (si usas base de datos externa)
properties
Copiar
Editar
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/empleados
spring.datasource.username=root
spring.datasource.password=tu_clave
spring.jpa.hibernate.ddl-auto=update
⚠️ Si usas H2, asegúrate de tener:

properties
Copiar
Editar
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
3. Compila y ejecuta
bash
Copiar
Editar
mvn clean install
mvn spring-boot:run
📚 Documentación Swagger
Una vez que la aplicación esté corriendo, accede a:

🔗 http://localhost:8080/swagger-ui/index.html#/

🔐 Seguridad
Los endpoints de /api/** están protegidos.

Swagger y la documentación se excluyen del filtro de seguridad:

java
Copiar
Editar
.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
Puedes usar autenticación básica o JWT, según tu configuración.

🧪 Endpoints principales
Método	Ruta	Descripción
GET	/api/employee	Lista todos los empleados
POST	/api/employee	Crea un nuevo empleado
GET	/api/employee/{id}	Detalles de un empleado por ID
PUT	/api/employee/{id}	Actualiza los datos del empleado
DELETE	/api/employee/{id}	Elimina un empleado

📁 Estructura del Proyecto
arduino
Copiar
Editar
src/
└── main/
    ├── java/
    │   └── com/empresa/empleados/
    │       ├── controller/
    │       ├── service/
    │       ├── repository/
    │       ├── model/
    │       └── config/
    └── resources/
        ├── application.properties
        └── static/
👨‍💻 Autor
Jonathan Sanchez

📧 sanchezjonathan251@gmail.com



📝 Licencia
Este proyecto está licenciado bajo los términos de la MIT License.
