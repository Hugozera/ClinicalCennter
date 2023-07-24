<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/menuTopBar.jsp"%>

<link rel="stylesheet" href="Style/estiloPerfil.css">

<div class="content">
  <h1>Cadastar Anamnese de Paciente</h1>
  <p>${param.nome}</p>
<div id="cadastroAnamnese">
  <form action="CadastrarAnamnese" method="post">
    <label> <div class="grupoForm">
      <br> <input type="hidden" name="medico" value="${sessionScope.usuario.idPessoa}">
    </div></label>
    <label> <div class="grupoForm">
      CPF do Paciente
      <br> <input type="text" name="cpfPaciente" required value="${param.login}">
    </div></label>
    <label> <div class="grupoForm">
      Exame Físico
      <br> <input type="text" name="exameFisico">
    </div></label>
    <label> <div class="grupoForm">
      Exames Complementáres
      <br> <input type="text" name="exameComplementar">
    </div></label>
    <label> <div class="grupoForm">
      Hipóteses Diagnósticas
      <br> <input type="text" name="hipoteseDiagnostica">
    </div></label>
    <label> <div class="grupoForm">
      Diagnóstico Definitivo
      <br> <input type="text" name="diagnosticoDefinitivo">
    </div>
    </label>
      <label> <div class="grupoForm">
        Tratamento Efetuado
        <br> <input type="text" name="tratamento">
      </div>
    </label>
    <input type="reset" value="Limpar">
    <input type="submit" value="Cadastrar">
   </form>
  <%@include file="WEB-INF/mensagem.jsp"%>
</div>
</div>

<script src="Script/homeScript.js">
</script>
</body>
</html>


