<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/menuTopBar.jsp"%>
<div class="content">
    <h2>Perfil de Configuração do Paciente</h2>
    <form action="EditarPaciente" method="post">
        <label for="login" contenteditable="false">Login:</label>
        <input type="text" id="login" name="login" value="<c:out value="${sessionScope.pacientes.login}"></c:out>" readonly><br>

        <label for="nome" contenteditable="false">Nome:</label>
        <input type="text" id="nome" name="nome" value="<c:out value="${sessionScope.pacientes.nome}"></c:out>" readonly><br>

        <label for="nomeMae" contenteditable="false">Nome da Mãe:</label>
        <input type="text" id="nomeMae" name="nomeMae" value="<c:out value="${sessionScope.pacientes.nomeMae}"></c:out>" readonly><br>

        <label for="naturalidade" contenteditable="false">Naturalidade:</label>
        <input type="text" id="naturalidade" name="naturalidade" value="<c:out value="${sessionScope.pacientes.naturalidade}"></c:out>" readonly><br>

        <label for="naturalidadeMun" contenteditable="false">Município da Naturalidade:</label>
        <input type="text" id="naturalidadeMun" name="naturalidadeMun" value="<c:out value="${sessionScope.pacientes.naturalidadeMun}"></c:out>" readonly><br>

        <label for="endereco" contenteditable="false">Endereço:</label>
        <input type="text" id="endereco" name="endereco" value="<c:out value="${sessionScope.pacientes.endereco}"></c:out>" readonly><br>

        <label for="dataNasc" contenteditable="false">Data de nascimento:</label>
        <input type="text" id="dataNasc" name="dataNasc" value="<c:out value="${sessionScope.pacientes.dataNasc}"></c:out>" readonly><br>

        <label for="sexo" contenteditable="false">Sexo:</label>
        <input type="text" id="sexo" name="sexo" value="<c:out value="${sessionScope.pacientes.sexo}"></c:out>" readonly><br>
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
        <label for="senha" contenteditable="false">Data de nascimento:</label>
        <input type="password" id="senha" name="senha" value="<c:out value="${sessionScope.pacientes.senha}"></c:out>" readonly><br>
        <fieldset>
            <div class="grupoForm">
                <label for="medicoFlag">Medico</label>
                <input type="radio" id="medicoFlag" name="flag" value="1" >
            </div>

            <div class="grupoForm">
                <label for="pacienteFlag">Paciente</label>
                <input type="radio" id="pacienteFlag" name="flag" value="0" checked>
            </div>
        </fieldset>

        <label>
            <input type="hidden" name="codigo" value="${sessionScope.pacientes.idPessoa}">
        </label>
        <button type="button" onclick="editarPerfil()">Editar</button>
        <button type="submit">Atualizar Perfil</button>
    </form>
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