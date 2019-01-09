<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Choose Period</h3>




        <c:forEach items="${periods}" var="period">
            <form method="POST" action="period">
                <button type="submit" class="btn btn-outline-primary btn-block text-left">${period.name} (${period.stateEntity.name}) </button>
                <input type="hidden" value="${period.id}" name="id">
            </form>
        </c:forEach>
    </jsp:body>
</t:page-template>