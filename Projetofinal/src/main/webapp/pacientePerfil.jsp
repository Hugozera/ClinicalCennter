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
    <link rel="stylesheet" href="Style/estiloPerfil.css">
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
        <li class="active"><a href="#">Perfil</a></li>
        <li><a href="cadastro.jsp" style="text-decoration: none">Cadastro de Paciente</a></li>
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

<div class="overlay" onclick="toggleMenu()"></div>
<div class="content">
    <h2>Perfil de Configuração do Usuário</h2>
    <form action="EditarPerfilPaciente" method="post">
        <label for="nome" contenteditable="false">Nome:</label>
        <input type="text" id="nome" name="nome" value="${sessionScope.usuario.nome}" class="readonly" readonly><br>

        <label for="nomeMae" contenteditable="false">Nome da Mãe:</label>
        <input type="text" id="nomeMae" name="nomeMae" value="${sessionScope.usuario.nomeMae}" class="readonly" readonly><br>

        <label for="naturalidade" contenteditable="false">Naturalidade:</label>
        <input type="text" id="naturalidade" name="naturalidade" value="${sessionScope.usuario.naturalidade}" class="readonly" readonly><br>

        <label for="naturalidadeMun" contenteditable="false">Município da Naturalidade:</label>
        <input type="text" id="naturalidadeMun" name="naturalidadeMun" value="${sessionScope.usuario.naturalidadeMun}" class="readonly" readonly><br>

        <label for="dataNasc" contenteditable="false">Data de nascimento:</label>
        <input type="text" id="dataNasc" name="dataNasc" value="${sessionScope.usuario.dataNasc}" class="readonly" readonly><br>

        <label for="sexo" contenteditable="false">Sexo:</label>
        <input type="text" id="sexo" name="sexo" value="${sessionScope.usuario.sexo}" class="readonly"  readonly><br>>

        <label for="endereco" contenteditable="false">Endereço:</label>
        <input type="text" id="endereco" name="endereco" value="<c:out value="${sessionScope.usuario.endereco}"></c:out>" readonly><br>
        <label for="senha" contenteditable="false">Senha:</label>
        <input type="password" id="senha" name="senha" value="<c:out value="${sessionScope.usuario.senha}"></c:out>" readonly><br>
        <input type="hidden" name="codigo" value="${sessionScope.usuario.idPessoa}">
        <button type="button" onclick="editarPerfil()">Editar</button>
        <button type="submit">Atualizar Perfil</button>
        <%@include file="WEB-INF/mensagem.jsp"%>
    </form>
</div>
</div>
<script src="Script/homeScript.js"></script>
<script>
    function editarPerfil() {
        var inputs = document.querySelectorAll("input:not(.readonly)");
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].readOnly = false;
        }
    }
</script>
</body>
</html>