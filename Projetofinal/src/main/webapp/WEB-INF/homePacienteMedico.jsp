<%--
  Created by IntelliJ IDEA.
  User: hugom
  Date: 13/06/2023
  Time: 19:18
  To change this template use File | Settings | File Templates.
  <%@ page pageEncoding="utf-8" %>
--%>
<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${empty sessionScope.usuario}">
        <c:redirect url="/index.jsp" />
    </c:when>
    <c:when test="${sessionScope.usuario.flagMedico == 1}">
        <body>
        <div class="topbar">
            <div class="menu-toggle" onclick="toggleMenu()">
                <i class="fas fa-bars"></i> Menu
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
        <div class="content">
            <h1>Bem Vindo ao center Clinica <c:out value="${sessionScope.usuario.nome}"></c:out></h1>
            <div class="card-container">
                <a href="perfil.jsp" class="card">
                    <i class="fas fa-user"></i>
                    <span>Perfil</span>
                </a>
                <a href="cadastro.jsp" class="card">
                    <i class="fas fa-user-plus"></i>
                    <span>Cadastro de Paciente</span>
                </a>
                <a href="anamnese.jsp" class="card">
                    <i class="fas fa-file-alt"></i>
                    <span>Anamnese</span>
                </a>
                <a href="pacientes.jsp" class="card">
                    <i class="fas fa-users"></i>
                    <span>Pacientes</span>
                </a>
            </div>
        </div>
        <script src="Script/homeScript.js">
        </script>
        </body>

    </c:when>
    <%-- Se o usuário for um paciente ou outro tipo de usuário, exiba o conteúdo da página normalmente --%>
    <c:otherwise>
        <body>
        <div class="topbar">
            <div class="menu-toggle" onclick="toggleMenu()">
                <i class="fas fa-bars"></i> Menu
            </div>
        </div>

        <div class="menu" id="menu">
            <ul>
                <li><a href="pacientePerfil.jsp">Perfil</a></li>
                <li><a href="minhasAnamneses.jsp">Minhas Anamneses</a></li>
                <ul class="logout-menu">
                    <li>
                        <form action="sair" method="get">
                            <input type="hidden" name="logout" value="true">
                            <button type="submit" style="border: none; background: none; color: blue; cursor: pointer;">Logout</button>
                        </form>
                    </li>
                </ul>
            </ul>
        </div>

        <div class="overlay" onclick="toggleMenu()">

        </div>
        <div class="content">
            <h1>Bem Vindo ao center Clinica <c:out value="${sessionScope.usuario.nome}"></c:out></h1>
        </div>

        <script src="Script/homeScript.js">
        </script>
        </body>
    </c:otherwise>
</c:choose>