<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<tags:page-template>
    <fmt:bundle basename="messages">
    <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap">
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-info?id-period=${param["id-period"]}"><fmt:message key="msg.info"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-edit?id-period=${param["id-period"]}"><fmt:message key="msg.edit"/></a>
                <a class="text-sm-center nav-link active"
                   href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}"><fmt:message key="msg.mark"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/specialities?id-period=${param["id-period"]}"><fmt:message key="msg.statistics"/></a>
            </nav>
        </div>
        <div class="card-body">
            <div class="container pt-3">
                <h3><fmt:message key="msg.subjects"/></h3>
                <div class="list-group-flush">
                    <c:forEach items="${subjects}" var="subject">
                        <a href="${pageContext.request.contextPath}/admin/period-subject-marks?id-period=${param["id-period"]}&subject=${subject.id}"
                           class="list-group-item list-group-item-action">${subject.name}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    </fmt:bundle>
</tags:page-template>