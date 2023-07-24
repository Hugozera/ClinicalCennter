<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Center Clinical</title>
    <link rel="stylesheet" href="Style/estiloLogin.css">
</head>
<body>
<div class="topbar">
    <a href="#">Contato</a>
    <a href="#">Avaliação do Sistema</a>
</div>

<div class="container">
    <h2>Faça login</h2>
    <c:if test="${empty sessionScope.usuario}">
        <form action="logar" method="post">
        <label>
            Login
            <input type="text" name="login" placeholder="Login" required>
        </label>
        <label>
            Senha
            <input type="password" name="senha" placeholder="Senha">
        </label>
        <input type="submit" value="Logar">
        </form>
    </c:if>
    <%@include file="WEB-INF/mensagem.jsp"%>
</div>

<footer>
    Desenvolvido por Hugo Martins Cavalcante
</footer>
</body>
</html>