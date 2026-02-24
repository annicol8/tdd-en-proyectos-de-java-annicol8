# Práctica III — TDD en Java

Proyecto de gestión de tareas pendientes (ToDo) desarrollado en Java con Maven y JUnit.

## Descripción
Aplicación de consola que permite gestionar tareas pendientes con fecha límite,
marcarlas como completadas, y enviar alertas por email cuando una tarea ha vencido.

## Estructura
- `ToDo`: JavaBean que representa una tarea
- `DBStub`: emulación de base de datos en memoria
- `Repositorio`: capa de acceso a datos
- `MailerStub`: emulación de envío de correos
- `Servicio`: lógica de negocio y punto de entrada del menú

## Tecnologías
- Java 11+
- Maven
- JUnit 5

## Cómo ejecutar
```bash
mvn compile exec:java
```