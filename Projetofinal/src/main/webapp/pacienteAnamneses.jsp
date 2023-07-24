<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="WEB-INF/menuTopBar.jsp"%>
<link rel="stylesheet" href="Style/estiloCadastro.css">
<link rel="stylesheet" href="Style/estiloHome.css">
<section class="content">
    <h1>Pacientes</h1>
    <div>
        <form action="BuscarAnamneses" method="post" >
            <input type="text" id="dataI" name="dataI" placeholder="Data Inicial" OnKeyPress="formatar('##-##-####', this)">
            <input type="text" id="dataF" name="dataF" placeholder="Data Final"OnKeyPress="formatar('##-##-####', this)">
            <input type="hidden" name="codigo" value="${param.codigo}">
            <input type="hidden"  name="filtrar" value="alguns">
            <button type="submit">Filtrar</button>
            <button type="submit" id="filtrar" name="filtrar" value="todos">Todas</button>
        </form>
                <h1>${param["nome"]}</h1>
        <c:out value=""></c:out>
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