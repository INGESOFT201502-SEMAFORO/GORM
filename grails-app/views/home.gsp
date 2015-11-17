<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 16/11/2015
  Time: 10:49 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main2"/>
    <title>AppForo Home</title>
</head>

<body>
<div class="container">
    <div class="col-md-4">
        <h3>Bienvenido a la Aplicacion Forum 2.0</h3>
        <h4>Consultar</h4>

        <ul>
            <li><g:link controller="forum" action="index">Foros</g:link></li>
            <li><g:link controller="userser" action="index">Usuarios</g:link></li>
            <li><g:link controller="postost" action="index">Posts</g:link></li>
            <li><g:link controller="file" action="index">Foros</g:link></li>
        </ul>
    </div>
    <div class="col-md-4">
        <h3>Ultimas Entradas</h3>


    </div>
    <div class="col-md-4">
        <h3>Foros con mas entradas</h3>
    </div>
</div>
</body>
</html>