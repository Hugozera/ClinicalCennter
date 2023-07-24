<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page pageEncoding="utf-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("utf-8"); %>
<div id="anamneses">
  <c:forEach var="anamense"  items="${requestScope.anamneses}" varStatus="loop">
    <div class="card" style="width: 18rem;">
      <div class="card-body">
        <h5 class="card-title">Anamnese n° ${loop.index+1}</h5>
        <h6 class="card-subtitle mb-2 text-muted">Data e Hora</h6>
        <p class="card-text">${anamense.data}</p>
        <h6 class="card-subtitle mb-2 text-muted">Exame Fisico</h6>
        <p class="card-text">${anamense.exameFisico}</p>
        <h6 class="card-subtitle mb-2 text-muted">Exame(s) Complementar(es)</h6>
        <p class="card-text">${anamense.exameComplementar}</p>
        <h6 class="card-subtitle mb-2 text-muted">Exame(s) Diagnostico(s)</h6>
        <p class="card-text">${anamense.hipoteseDiagnostica}</p>
        <h6 class="card-subtitle mb-2 text-muted">Diagnóstico Definitivo</h6>
        <p class="card-text">${anamense.diagnosticoDefinitivo}</p>
        <h6 class="card-subtitle mb-2 text-muted">Laudo Médico</h6>
        <p class="card-text">${anamense.tratamentoEfetuado}</p>
        <h6 class="card-subtitle mb-2 text-muted">Médico Responsável</h6>
        <p class="card-text">${anamense.medicoResponsavel}</p>
      </div>
    </div>
  </c:forEach>
</div>
