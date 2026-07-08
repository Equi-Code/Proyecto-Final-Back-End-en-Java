# 🛒 Ecommerce Código Limpio

Proyecto Full Stack desarrollado con **Spring Boot** y **React**, orientado a la comercialización de indumentaria deportiva y accesorios.

La aplicación permite visualizar productos, filtrarlos por categoría, agregarlos a un carrito de compras, generar pedidos y administrar su estado, implementando una arquitectura en capas y buenas prácticas de desarrollo.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-brightgreen)
![React](https://img.shields.io/badge/React-18-61DAFB)
![MySQL](https://img.shields.io/badge/MySQL-8-4479A1)
![License](https://img.shields.io/badge/license-MIT-blue)

---

## 📑 Tabla de contenidos

- [Descripción del proyecto](#-descripción-del-proyecto)
- [Funcionalidades](#-funcionalidades)
- [Arquitectura](#-arquitectura)
- [Tecnologías utilizadas](#-tecnologías-utilizadas)
- [Swagger](#-swagger)
- [Base de datos](#-base-de-datos)
- [Instalación](#-instalación)
- [Ejecutar el proyecto](#-ejecutar-el-proyecto)
- [Estructura del proyecto](#-estructura-del-proyecto)
- [Mejoras futuras](#-mejoras-futuras)
- [Autor](#-autor)
- [Licencia](#-licencia)

---

## 📌 Descripción del proyecto

El objetivo del proyecto fue desarrollar una aplicación web completa (Frontend + Backend) aplicando conceptos de:

- Arquitectura en capas
- API REST
- Persistencia con JPA/Hibernate
- React
- Consumo de API mediante Axios
- Manejo de estado con Context API
- DTO y Mapper
- Validaciones
- Manejo de excepciones
- Documentación con Swagger

---

## 🚀 Funcionalidades

### Productos
- Listado de productos
- Detalle de producto
- Visualización de stock y categoría
- Separación por categoría (Accesorios / Indumentaria)

### Carrito
- Agregar y eliminar productos
- Vaciar carrito
- Actualizar cantidades
- Cálculo automático del total

### Checkout
- Formulario de datos del cliente
- Resumen del pedido
- Confirmación de compra
- Generación del pedido
- Descuento automático de stock

### Pedidos
- Historial de pedidos
- Detalle del pedido y productos comprados
- Cambio de estado del pedido

**Estados disponibles:**

| Estado | Descripción |
|---|---|
| `PENDIENTE` | Pedido creado, aún no pagado |
| `PAGADO` | Pago confirmado |
| `ENVIADO` | El pedido fue despachado |
| `ENTREGADO` | El pedido llegó a destino |

---

## 🏗 Arquitectura

```
Frontend (React)
├── components
├── pages
├── context
├── hooks
├── services
└── router
        │
        │  API REST (Axios)
        ▼
Backend (Spring Boot)
├── config
├── controller
├── dto
├── service
├── repository
├── response
├── mapper
├── exception
└── model
        │
        ▼
     MySQL
```

La comunicación entre frontend y backend se realiza mediante una API REST consumida con Axios.

---

## ⚙ Tecnologías utilizadas

| Backend | Frontend | Herramientas |
|---|---|---|
| Java 21 | React | Swagger / OpenAPI |
| Spring Boot | Vite | Git y GitHub |
| Spring Data JPA | React Router DOM | Postman |
| Hibernate | Axios | VS Code |
| Maven | CSS3 | IntelliJ IDEA |
| MySQL | | |

---

## 📖 Swagger

La API REST está documentada con Swagger, disponible en:

```
http://localhost:8080/swagger-ui/index.html
```

Permite probar todos los endpoints directamente desde el navegador.

| Recurso | Métodos disponibles |
|---|---|
| Productos | `GET` `POST` `PUT` `DELETE` |
| Accesorios | `GET` `POST` `PUT` `DELETE` |
| Indumentaria | `GET` `POST` `PUT` `DELETE` |
| Pedidos | `GET` `POST` `PUT` `DELETE` |

---

## 🧪 Datos de prueba (Postman / Swagger)

Una vez iniciada la aplicación, se pueden crear productos utilizando Swagger o Postman.

### Crear un Accesorio

POST /api/accesorios

```json
{
  "nombre": "Botella Térmica",
  "precio": 18500,
  "stock": 12,
  "descripcion": "Botella deportiva de acero inoxidable de 750 ml.",
  "imagenUrl": "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=800",
  "tipo": "Hidratación"
}
```

### Crear una Indumentaria

POST /api/indumentaria

```json
{
  "nombre": "Remera Running Adidas",
  "precio": 45990,
  "stock": 8,
  "descripcion": "Remera deportiva de secado rápido.",
  "imagenUrl": "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=800",
  "marca": "Adidas",
  "talle": "M"
}
```

### Crear un Pedido

POST /api/pedidos

```json
{
  "lineas": [
    {
      "productoId": 1,
      "cantidad": 2
    },
    {
      "productoId": 3,
      "cantidad": 1
    }
  ]
}
```

### Cambiar estado de un pedido

PATCH /api/pedidos/{id}/estado

```json
{
  "estado": "PAGADO"
}
```

Estados disponibles:

- PENDIENTE
- PAGADO
- ENVIADO
- ENTREGADO
- CANCELADO

## 🗄 Base de datos

Modelo relacional compuesto por las siguientes entidades:

- `Producto` (clase base, herencia `JOINED`)
- `Accesorio`
- `IndumentariaDeportiva`
- `Pedido`
- `LineaPedido`

**Características implementadas:**
- Herencia `JOINED`
- Relaciones `@OneToMany` / `@ManyToOne`
- `Cascade`
- Validaciones con Bean Validation
- Persistencia automática vía JPA/Hibernate

---

## 🛠 Instalación

### 1. Clonar el repositorio

```bash
git clone https://github.com/Equi-Code/Proyecto-Final-Back-End-en-Java.git
cd ecommerce
```

### 2. Configurar MySQL

Crear la base de datos:

```sql
CREATE DATABASE ecommerce;
```

Editar `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=tu_password
```

### 3. Backend

```PowerShell

.\mvnw spring-boot:run

```bash
mvn clean install
mvn spring-boot:run
```

### 4. Frontend

```bash
cd frontend
npm install
npm run dev
```

### Dependencias principales

- Spring Web
- Spring Data JPA
- Spring Validation
- MySQL Driver
- SpringDoc OpenAPI (Swagger)
- Lombok *(si se utiliza)*

---

### Variables de entorno

-application.properties

-spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
-spring.datasource.username=root
-spring.datasource.password=tu_password

-spring.jpa.hibernate.ddl-auto=update

---

## ▶ Ejecutar el proyecto

| Servicio | URL |
|---|---|
| Backend | http://localhost:8080 |
| Frontend | http://localhost:5173 |
| Swagger | http://localhost:8080/swagger-ui/index.html |

---

## 🔮 Mejoras futuras

- [ ] Login de usuarios
- [ ] Roles (Administrador / Cliente)
- [ ] JWT
- [ ] Búsqueda por nombre
- [ ] Filtros avanzados
- [ ] Paginación completa
- [ ] Integración con Mercado Pago
- [ ] Panel administrativo
- [ ] Docker
- [ ] Deploy en Render + Vercel

---

## 👨‍💻 Autor

**Ezequiel Riente**
Desarrollador Full Stack Java | React

GitHub: [https://github.com/Equi-Code](https://github.com/Equi-Code)

---

## 📄 Licencia

Este proyecto se distribuye bajo la licencia **MIT**. Ver el archivo [`LICENSE`](./LICENSE) para más información.