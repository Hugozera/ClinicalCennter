<%--
  Created by IntelliJ IDEA.
  User: hugom
  Date: 26/05/2023
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/menuTopBar.jsp"%>

<div class="content">
    <h1>Cadastro de Paciente</h1>

</div>
<div id="cadastroPaciente">
    <form action="CadastrarPessoa" method="post">
        <label> <div class="grupoForm">
            Login(CPF)
            <br> <input type="text" name="login" placeholder="Login" required>
        </div></label>
        <label> <div class="grupoForm">
            Senha
            <br> <input type="password   " name="senha" placeholder="Senha" required>
        </div></label>
        <label> <div class="grupoForm">
            Nome
            <br> <input type="text" name="nome" placeholder="Nome" required>
        </div></label>
        <label> <div class="grupoForm">
            Nome mãe
            <br> <input type="text" name="nomeMae" placeholder="Nome da Mãe" required>
        </div></label>
        <label> <div class="grupoForm">
            Endereço
            <br> <input type="text" name="endereco" placeholder="Endereço" required>
        </div></label>
        <label>
            <div class="grupoForm">
            Sexo
            <select id="sexo" name="sexo">
                <option id="masc" name="sexoM" selected>
                    Masculino
                </option>
                <option id="fem" name="sexoF">
                    Feminino
                </option>
                <option id="non" name="sexoN">
                    Prefiro não dizer
                </option>
            </select>
        </div>
        </label>
        <label> <div class="grupoForm">
            Data Nascimento
            <br> <input type="text" name="dataNascimento" placeholder="13/01/2001" required>
        </div></label>
        <label> <div class="grupoForm">
            Naturalidade Município
            <br> <input type="text" name="naturalidadeMunicipio" placeholder="Naturalidade-Município" required>
        </div></label>
        <div class="grupoForm">
            <label>
                Naturalidade Estado
                <br> <input type="text" name="naturalidadeEstado" placeholder="Naturalidade-Estado" required>
            </label>
            <fieldset>
            <div class="grupoForm">
                <label for="medicoFlag">Medico</label>
                <input type="radio" id="medicoFlag" name="flag" value="Medico" checked>
            </div>

            <div class="grupoForm">
                <label for="pacienteFlag">Paciente</label>
                <input type="radio" id="pacienteFlag" name="flag" value="Paciente">
            </div>
            </fieldset>
            <br>
            <input type="reset" value="Limpar">
            <input type="submit" value="Cadastrar">
            <%@include file="WEB-INF/mensagem.jsp"%>
        </div>
    </form>
</div>


<script src="Script/homeScript.js">
</script>
</body>
</html>


