# Proyecto Integrador B1 - Sistema de Gestión Comercial

Este repositorio contiene la implementación del **Proyecto Integrador (Bloque 1 - 2026-2), desarrollado con Java, Spring Boot,  Vaadiny arquitectura orientada a objetos basada en el patrón DAO (Data Access Object).

es un proyecto académico de software desarrollado como prototipo de sistema de gestión comercial. Está enfocado en administrar el inventario, clientes y pedidos de productos artesanales y útiles elaborados a partir de materiales recuperados y sostenibles (como cartón, madera recuperada y textiles reutilizados).

El sistema implementa una arquitectura basada en el patrón **DAO (Data Access Object)** y una interfaz web interactiva para facilitar el control de las operaciones comerciales del proyecto.

##Tecnologías Utilizadas

* Lenguaje: Java 17+
* Framework Web & UI: Vaadin Flow / Spring Boot
* Gestión de Dependencias: Apache Maven
* Persistencia / Base de Datos: JDBC / DAO Pattern (MySQL/PostgreSQL)
* Despliegue & Contenedores: Docker (mediante `Dockerfile`)

---

## 📁 Estructura del Proyecto

```text
src/main/java/com/
└── example/
    ├── Application.java          # Punto de entrada principal Spring Boot
    ├── MainView.java             # Interfaz de usuario (Vaadin View)
    ├── config/
    │   └── ConexionBD.java       # Configuración y conexión JDBC a la base de datos
    ├── dao/
    │   ├── ClientesDAO.java      # Operaciones CRUD para Clientes
    │   ├── PedidosDAO.java       # Operaciones CRUD para Pedidos
    │   └── DetallePedidoDAO.java # Operaciones CRUD para Detalles de Pedido
    └── model/
        ├── Clientes.java         # Entidad Cliente
        ├── Pedidos.java          # Entidad Pedido
        ├── Productos.java        # Entidad Producto
        ├── Usuario.java          # Entidad Usuario
        └── DetallePedido.java    # Entidad Detalle de Pedido
```

---

## Instrucciones de Ejecución

### 1. Clonar el repositorio
```bash
git clone <URL_DEL_REPOSITORIO>
cd proyecto-integrador-b1-2026-2-main
```

### 2. Configurar la Base de Datos
Asegúrate de ajustar los parámetros de conexión en el archivo `src/main/resources/application.properties` o en `ConexionBD.java`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/comercio_db
spring.datasource.username=root
spring.datasource.password=tu_contraseña
```

### 3. Ejecutar la Aplicación localmente
Con el wrapper de Maven incluido en el proyecto:
```bash
./mvnw spring-boot:run
mvnw.cmd spring-boot:run
```

Una vez iniciada, abre tu navegador web e ingresa a: `http://localhost:8080`

### 4. Ejecución con Docker
Para empaquetar y levantar la aplicación en un contenedor Docker:
```bash
docker build -t proyecto-integrador .
docker run -p 8080:8080 proyecto-integrador
```

---

## Resumen de Correcciones Realizadas
1. **Normalización del paquete de modelos:** Se unificaron los modelos bajo `com.example.model` para garantizar compatibilidad con los DAO y la vista.
2. **Depuración de archivos duplicados:** Se eliminó la declaración duplicada de `DetallePedido` dentro del paquete `dao`.
3. **Conexión entre capas (MVC / DAO / View):** Se conectaron correctamente las entidades con `ClientesDAO`, `PedidosDAO`, `DetallePedidoDAO` y `MainView.java`.
