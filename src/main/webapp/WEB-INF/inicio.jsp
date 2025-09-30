<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
</head>
<body>
    <h2>Bienvenid@ de vuelta a la aplicación de Login y Registro</h2>
    <br>
    <p>Nombre de usuario: ${sessionScope.nombreUsuario}</p>
    <p>Nombre: ${sessionScope.nombre}</p>
    <p>Apellido: ${sessionScope.apellido}</p>
    <p>Correo: ${sessionScope.correo}</p>
    <p>Fecha de nacimiento: ${sessionScope.fechaDeNacimiento}</p>
    <br>
    <form action="/procesa/logout" method="POST">
        <button type="submit">Cerrar sesión</button>
    </form>
</body>
</html>