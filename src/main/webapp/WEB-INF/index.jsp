<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro / Login</title>
</head>
<body>
    <h2>Registro</h2>
    <form:form method="POST" action="/procesa/registro" modelAttribute="usuario">
        <label>Nombre de Usuario:</label>
        <form:input path="nombreUsuario"/>
        <form:errors path="nombreUsuario" cssClass="error"/>
        <br>

        <label>Contraseña:</label>
        <form:password path="contrasena"/>
        <form:errors path="contrasena" cssClass="error"/>
        <br>

        <label>Confirmar Contraseña:</label>
        <form:password path="confirmacionContrasena"/>
        <form:errors path="confirmacionContrasena" cssClass="error"/>
        <br>

        <label>Email:</label>
        <form:input path="correo"/>
        <form:errors path="correo" cssClass="error"/>
        <br>

        <label>Nombre:</label>
        <form:input path="nombre"/>
        <form:errors path="nombre" cssClass="error"/>
        <br>

        <label>Apellido:</label>
        <form:input path="apellido"/>
        <form:errors path="apellido" cssClass="error"/>
        <br>

        <label>Fecha de Nacimiento:</label>
        <form:input path="fechaDeNacimiento" type="date"/>
        <form:errors path="fechaDeNacimiento" cssClass="error"/>
        <br>

        <button type="submit">Registrarse</button>
    </form:form>

    <hr>

    <h2>Login</h2>
    <form:form method="POST" action="/procesa/login" modelAttribute="login">
        <label>Email:</label>
        <form:input path="correo"/>
        <form:errors path="correo" cssClass="error"/>
        <br>

        <label>Contraseña:</label>
        <form:password path="contrasena"/>
        <form:errors path="contrasena" cssClass="error"/>
        <br>
        <c:if test="${not empty errorLogin}">
        <span class="error">${errorLogin}</span>
        </c:if>
        <button type="submit">Ingresar</button>
    </form:form>
</body>
</html>

