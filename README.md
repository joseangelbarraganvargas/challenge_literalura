# challenge_literalura
Practicando Spring Boot Challenge Literalura

# Literalura Application
Literalura es una aplicación de consola desarrollada en Java como parte del desafío de Alura-Latam. Su propósito es gestionar y consultar información sobre libros y autores utilizando los datos proporcionados por la API de Gutendex. La aplicación emplea Spring Boot y JPA para la interacción con la base de datos y la realización de consultas.

# 🚀  Funcionalidades
La aplicación ofrece un menú principal con las siguientes opciones:

Buscar libro por título
Permite buscar un libro ingresando su título.

Listar todos los libros
Muestra una lista de todos los libros almacenados en la base de datos.

Lista de autores
Proporciona una lista de todos los autores registrados en la base de datos.

Listar autores vivos en un año específico
Muestra los autores que estaban vivos durante un año determinado.

Cantidad de libros por autor
Indica cuántos libros ha escrito un autor específico.

Listar libros por idioma
Filtra y muestra los libros disponibles en un idioma específico.

Cantidad de libros por idioma
Muestra el número total de libros disponibles en un idioma seleccionado.

Buscar libro por etiqueta
Permite realizar búsquedas de libros por etiquetas específicas.

Top 5 libros más descargados
Muestra una lista con los 5 libros más descargados.

Salir
Finaliza la ejecución de la aplicación.

# 🛠️ Estructura del Proyecto
El proyecto sigue una arquitectura bien definida basada en capas, organizada de la siguiente manera:

Entities
Clases que representan las tablas de la base de datos.

DTOs (Data Transfer Objects)
Clases utilizadas para transferir datos entre las distintas capas de la aplicación.

Repositories
Interfaces que extienden JpaRepository para facilitar las operaciones con la base de datos.

Services
Clases que contienen la lógica de negocio de la aplicación.

Controllers
Clases responsables de gestionar la entrada del usuario y coordinar las acciones con los servicios.

# 📋 Requisitos
Para ejecutar la aplicación, asegúrate de tener instalados los siguientes elementos:

Java 21
Spring Boot 3.0.0 o superior
Base de datos PostgreSQL

# 📄 Licencia
Este proyecto se desarrolló exclusivamente con fines educativos y como parte del desafío de Alura-Latam. Para cualquier consulta o mejora, no dudes en contribuir.
