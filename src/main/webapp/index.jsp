<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Center Clinical</title>
    <link rel="stylesheet" href="estiloLogin.css">
</head>
<body>
<div class="topbar">
    <a href="#">Contato</a>
    <a href="#">Avaliação do Sistema</a>
</div>

<div class="container">
    <h2>Faça login</h2>
    <c:if test="${empty sessionScope.usuario}">
        <form action="logar">
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
</div>

<footer>
    Desenvolvido por Hugo Martins Cavalcante
</footer>
</body>
</html>