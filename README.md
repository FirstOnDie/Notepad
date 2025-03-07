# Notepad
Aplicación Block de notas

## Descripción
Aplicación de escritorio que simula un block de notas, con las funciones básicas de guardar, abrir y editar archivos de texto.

## Funcionalidades
- Guardar nota
- Ver notas
- Editar notas
- Buscar notas
- Eliminar notas

## Tecnologías
- Java

## Llamadas API REST

- **GET** /notas
- **POST** /notas
```CURL
curl -X POST "http://localhost:8080/notas?titulo=MiNota&contenido=Aprendiendo Spring Boot"
```
- **PUT** /notas
- **DELETE** /notas
- **GET** /notas/{id}