# 🛒 Ecommerce Código Limpio

Proyecto Full Stack desarrollado con **Spring Boot** y **React**, orientado a la comercialización de indumentaria deportiva y accesorios.

La aplicación permite visualizar productos, filtrarlos por categorías, agregarlos a un carrito de compras, generar pedidos y administrar su estado, implementando una arquitectura en capas y buenas prácticas de desarrollo.

---

# 📌 Descripción del proyecto

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

# 🚀 Funcionalidades

## Productos

- Listado de productos
- Detalle de producto
- Visualización de stock
- Visualización de categoría
- Separación por categorías
- Accesorios
- Indumentaria

---

## Carrito

- Agregar productos
- Eliminar productos
- Vaciar carrito
- Actualizar cantidades
- Cálculo automático del total

---

## Checkout

- Formulario de datos del cliente
- Resumen del pedido
- Confirmación de compra
- Generación del pedido
- Descuento automático de stock

---

## Pedidos

- Historial de pedidos
- Detalle del pedido
- Visualización de productos comprados
- Cambio de estado del pedido

Estados disponibles:

- PENDIENTE
- EN_PROCESO
- ENVIADO
- ENTREGADO
- CANCELADO

---

# 🏗 Arquitectura

```
Frontend (React)

│

├── Components
├── Pages
├── Context
├── Hooks
├── Services
└── Router

↓

Backend (Spring Boot)

│

├── Controller
├── Service
├── Repository
├── DTO
├── Mapper
├── Exception
└── Model

↓

MySQL
```

La comunicación entre Frontend y Backend se realiza mediante una API REST utilizando Axios.

---

# ⚙ Tecnologías utilizadas

## Backend

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven
- MySQL

## Frontend

- React
- Vite
- React Router DOM
- Axios
- CSS3

## Herramientas

- Swagger OpenAPI
- Git
- GitHub
- VS Code
- IntelliJ IDEA
- Postman

---

# 📖 Swagger

La API REST se encuentra documentada mediante Swagger.

Permite probar todos los endpoints del sistema directamente desde el navegador.

Endpoints principales:

## Productos

- GET
- POST
- PUT
- DELETE

## Accesorios

- GET
- POST
- PUT
- DELETE

## Indumentaria

- GET
- POST
- PUT
- DELETE

## Pedidos

- GET
- POST
- PUT
- DELETE

---

# 🗄 Base de datos

Modelo relacional compuesto por las siguientes entidades:

- Producto
- Accesorio
- IndumentariaDeportiva
- Pedido
- LineaPedido

Características implementadas:

- Herencia JOINED
- Relaciones OneToMany
- Relaciones ManyToOne
- Cascade
- Validaciones
- Persistencia automática

---

# ▶ Cómo ejecutar el proyecto

## Backend

```bash
git clone <repositorio>

cd ecommerce

mvn spring-boot:run
```

El backend se ejecutará en:

```
http://localhost:8080
```

---

## Frontend

```bash
cd frontend

npm install

npm run dev
```

La aplicación estará disponible en:

```
http://localhost:5173
```

---

# 📂 Estructura del proyecto

```
ecommerce/

│

├── backend/
│
├── controller
├── service
├── repository
├── dto
├── mapper
├── model
├── exception
│
└── frontend/
    │
    ├── components
    ├── context
    ├── hooks
    ├── layout
    ├── pages
    ├── router
    ├── services
    └── css
```

---

# 🔮 Mejoras futuras

- Login de usuarios
- Roles (Administrador / Cliente)
- JWT
- Búsqueda por nombre
- Filtros avanzados
- Paginación completa
- Integración con Mercado Pago
- Panel administrativo
- Docker
- Deploy en Render + Vercel

---

# 👨‍💻 Autor

**Ezequiel Riente**

Desarrollador Full Stack Java | React

GitHub:
https://github.com/

---