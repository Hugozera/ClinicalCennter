
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:if test="${not empty param.mensagem}">
    <section class="mensagem">
            ${param.mensagem}
    </section>
</c:if>
