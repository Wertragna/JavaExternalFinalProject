<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap">
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-info?id-period=${param["id-period"]}">info</a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-edit?id-period=${param["id-period"]}">edit</a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}">mark</a>
                <a class="text-sm-center nav-link active"
                   href="${pageContext.request.contextPath}/admin/specialities?id-period=${param["id-period"]}">statistics</a>
            </nav>
        </div>
        <div class="card-body">
            <div class="container pt-3">
                <h3>Choose Speciality</h3>
                <c:forEach items="${specialities}" var="speciality">
                    <form method="GET" action="statistic">
                        <button type="submit"
                                class="btn btn-outline-primary btn-block text-left">${speciality.name}</button>
                        <input type="hidden" value="${param["id-period"]}" name="id-period">
                        <input type="hidden" value="${speciality.id}" name="speciality">
                        <input type="hidden" value=1 name="page">
                    </form>
                </c:forEach>
            </div>
        </div>
    </jsp:body>
</t:page-template>