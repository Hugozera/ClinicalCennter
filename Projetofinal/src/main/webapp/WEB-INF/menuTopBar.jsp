
<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${empty sessionScope.usuario || sessionScope.usuario.flagMedico != 1}">
  <c:choose>
    <c:when test="${empty sessionScope.usuario}">
      <c:redirect url="index.jsp" />
    </c:when>
    <c:otherwise>
      <c:redirect url="home.jsp" />
    </c:otherwise>
  </c:choose>
</c:if>
<html>
<head>
  <title>Center Clinica</title>
  <link rel="stylesheet" href="Style/estiloCadastro.css">
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
    <li><a href="perfil.jsp">Perfil</a></li>
    <li><a href="cadastro.jsp" style="text-decoration: none" >Cadastro de Paciente</a></li>
    <li><a href="anamnese.jsp">Anamnese</a></li>
    <li><a href="pacientes.jsp">Pacientes</a></li>
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
<div class="overlay" onclick="toggleMenu()">
</div>