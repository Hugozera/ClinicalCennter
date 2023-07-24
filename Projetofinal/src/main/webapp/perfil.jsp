<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/menuTopBar.jsp"%>
<link rel="stylesheet" href="Style/estiloPerfil.css">

<div class="content">
    <h2>Perfil de Configuração do Usuário</h2>
    <form action="EditarPerfil" method="post">

    <label for="nome" contenteditable="false">Nome:</label>

    <input type="text" id="nome" name="nome" value="<c:out value="${sessionScope.usuario.nome}"></c:out>" readonly><br>

    <label for="nomeMae" contenteditable="false">Nome da Mãe:</label>
    <input type="text" id="nomeMae" name="nomeMae" value="<c:out value="${sessionScope.usuario.nomeMae}"></c:out>" readonly><br>

    <label for="naturalidade" contenteditable="false">Naturalidade:</label>
    <input type="text" id="naturalidade" name="naturalidade" value="<c:out value="${sessionScope.usuario.naturalidade}"></c:out>" readonly><br>

    <label for="naturalidadeMun" contenteditable="false">Município da Naturalidade:</label>
    <input type="text" id="naturalidadeMun" name="naturalidadeMun" value="<c:out value="${sessionScope.usuario.naturalidadeMun}"></c:out>" readonly><br>

    <label for="endereco" contenteditable="false">Endereço:</label>
    <input type="text" id="endereco" name="endereco" value="<c:out value="${sessionScope.usuario.endereco}"></c:out>" readonly><br>

    <label for="endereco" contenteditable="false">Data de nascimento:</label>
    <input type="text" id="dataNasc" name="dataNasc" value="<c:out value="${sessionScope.usuario.dataNasc}"></c:out>" readonly><br>

        <label for="endereco" contenteditable="false">Sexo:</label>
        <select id="sexoOpcao" name="sexoOpcao">
            <option id="masc" name="sexoM" selected>
                Masculino
            </option>
            <option id="fem" name="sexoF">
                Feminino
            </option>
            <option id="non" name="sexoN">
                Prefiro não dizer
            </option>
        </select> <br>

        <label for="endereco" contenteditable="false">Senha:</label>
        <input type="password" id="senha" name="senha" value="<c:out value="${sessionScope.usuario.senha}"></c:out>" readonly><br>

         <input type="hidden" name="flag" value="${sessionScope.usuario.flagMedico}">

        <label>
        <input type="hidden" name="codigo" value="${sessionScope.usuario.idPessoa}">
            <input type="hidden" name="metodoEditar" value="1">
     </label>
    <button type="button" onclick="editarPerfil()">Editar</button>
    <button type="submit">Atualizar Perfil</button>
</form>
    <%@include file="WEB-INF/mensagem.jsp"%>
</div>

</div>
<script src="Script/homeScript.js"></script>
<script>
    function editarPerfil() {
        var inputs = document.querySelectorAll("input");
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].readOnly = false;
        }
    }
</script>
</body>
</html>