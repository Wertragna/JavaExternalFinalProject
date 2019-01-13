<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<tags:page-template>
    <fmt:bundle basename="messages">
    <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap">
                <a class="text-sm-center nav-link active"
                   href="${pageContext.request.contextPath}/admin/period-info?id-period=${param["id-period"]}"><fmt:message key="msg.info"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-edit?id-period=${param["id-period"]}"><fmt:message key="msg.edit"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}"><fmt:message key="msg.mark"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/specialities?id-period=${param["id-period"]}"><fmt:message key="msg.statistics"/></a>
            </nav>
        </div>
        <div class="card-body">
            <div class="container">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row d-flex">
                        <div class="col-md-3"><b><fmt:message key="msg.name"/></b></div>
                        <div class="col-md-9">${name}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-3"><b><fmt:message key="msg.state"/></b></div>
                        <div class="col-md-9">${state}</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    </fmt:bundle>
</tags:page-template>