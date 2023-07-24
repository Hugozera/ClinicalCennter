<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/menuTopBar.jsp"%>
<link rel="stylesheet" href="Style/estiloPacientes.css">
<div class="content">
    <h1>Pacientes</h1>
    <%@include file="WEB-INF/mensagem.jsp"%>
    <div>
        <form action="BuscarPacientes" method="post">
        <input type="text" id="filtroNome" name="filtroNome" placeholder="Filtrar por nome">
            <input type="hidden" name="codigo" value="0">
         <button type="submit">Filtrar</button>
        </form>
        <form action="BuscarPacientes" method="post">
            <label>
                <input type="hidden" name="codigo" value="1">
            </label>
            <button type="submit">Buscar todos</button>
        </form>
    </div>
    <table>
        <thead>
        <tr>
            <th>Codigo</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data de Nascimento</th>
            <th>Sexo</th>
            <th>Nome da mãe</th>
            <th>Naturalidade Estado</th>
            <th>Naturalidade Municipio</th>
            <th>Endereço</th>
        </tr>
        </thead>
        <tbody id="tabelaPacientes">
        <c:forEach var="paciente" items="${requestScope.pacientes}">
           <tr>
               <td>${paciente.idPessoa}</td>
            <td>${paciente.nome}</td>
            <td>${paciente.login}</td>
            <td>${paciente.dataNasc}</td>
            <td>${paciente.sexo}</td>
               <td>${paciente.nomeMae}</td>
               <td>${paciente.naturalidade}</td>
               <td>${paciente.naturalidadeMun}</td>
               <td>${paciente.endereco}</td>
               <td><a href="/ProjetoFinal-1.0-SNAPSHOT/EditarPaciente?codigo=${paciente.idPessoa}">Editar</a></td>
               <td><a href="pacienteAnamneses.jsp?codigo=${paciente.idPessoa}&nome=${paciente.nome}">Anamneses</a></td>
               <td><a href="anamnese.jsp?nome=${paciente.nome}&login=${paciente.login}" class="add-button">+</a></td>
           </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="Script/homeScript.js"></script>
<script>
</script>
</body>
</html>