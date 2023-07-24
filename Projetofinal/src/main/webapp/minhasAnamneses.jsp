<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty sessionScope.usuario || sessionScope.usuario.flagMedico != 1}">
    <c:choose>
        <c:when test="${empty sessionScope.usuario}">
            <c:redirect url="index.jsp" />
        </c:when>
    </c:choose>
</c:if>
<html>
<head>
    <meta charset="UTF-8">
    <title>Center Clinica - Perfil</title>
    <link rel="stylesheet" href="Style/estiloHome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>
<div class="topbar">
    <div class="menu-toggle" onclick="toggleMenu()">
        <i class="fas fa-bars"></i> Menu
    </div>
    <div class="homebutton">
        <a href="home.jsp"><i class="fas fa-home"></i> Home</a>
    </div>
</div>

<div class="menu" id="menu">
    <ul>
        <li class="active">
        <li><a href="perfil.jsp">Perfil</a></li>
        <li><a href="minhasAnamneses.jsp">Minhas Anamneses</a></li>
        <ul class="logout-menu">
            <li>
                <form action="sair">
                    <input type="hidden" name="logout" value="true">
                    <button type="submit" style="border: none; background: none; color: blue; cursor: pointer;">Logout</button>
                </form>
            </li>
        </ul>
    </ul>
</div>

<div class="overlay" onclick="toggleMenu()"></div>
<section class="content">
    <h1>Pacientes</h1>
    <div>
        <form action="BuscarAnamneses" method="post" >
            <input type="text" id="dataI" name="dataI" placeholder="Data Inicial" OnKeyPress="formatar('##-##-####', this)">
            <input type="text" id="dataF" name="dataF" placeholder="Data Final" OnKeyPress="formatar('##-##-####', this)">
            <input type="hidden" name="codigo" value="${sessionScope.usuario.codigo}">
            <button type="submit">Filtrar</button>

        </form>
    </div>
    <%@include file="WEB-INF/anamneses.jsp"%>
</section>
</div>
<script src="Script/homeScript.js"></script>
<script>
    function formatar(mascara, documento) {
        var i = documento.value.length;
        var saida = mascara.substring(0, 1);
        var texto = mascara.substring(i);

        if (texto.substring(0, 1) != saida) {
            documento.value += texto.substring(0, 1);
        }
    }
</script>

</body>
</html>