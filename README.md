# Citas Médicas

Proyecto de gestión de citas médicas desarrollado con Spring Boot, Thymeleaf y MongoDB.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Contribución](#contribución)
- [Licencia](#licencia)

## Descripción

El proyecto de Citas Médicas permite a los usuarios registrar y gestionar citas médicas, incluyendo la selección de especialidades, médicos y fechas disponibles.

## Características

- Registro de usuarios
- Validación de usuario
- Gestión de citas médicas
- Listado de citas por usuario

## Requisitos Previos

Versiones utilizadas en este proyecto 
- Java 17
- Spring 3.2.6 
- Maven 3.9.6 
- MongoDB 7.0.11 

## Instalación

Sigue estos pasos para configurar y ejecutar el proyecto localmente.

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/citas-medicas.git
    cd citas-medicas
    ```

2. Compila el proyecto con Maven:
    ```bash
    mvn clean install
    ```

## Configuración

3. Configura la base de datos MongoDB. Asegúrate de tener MongoDB en funcionamiento y configurado según tus necesidades.


Modifica el archivo `application.properties` y  `application-mongodb.properties` para configurar tu base de datos y otros parámetros de la aplicación:

```properties
spring.data.mongodb.uri=mongodb://127.0.0.1:27017/GestionarCitasMedicas
spring.profiles.active=mongodb

## Contribución

- Si deseas contribuir al proyecto, realiza un fork y envía un pull request con tus cambios.
- Asegúrate de seguir las convenciones de codificación y las prácticas recomendadas.

## Licencia

Este proyecto está bajo la licencia [MIT](https://opensource.org/licenses/MIT).

