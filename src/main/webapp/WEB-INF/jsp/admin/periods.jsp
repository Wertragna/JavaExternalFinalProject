<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<t:page-template>
    <jsp:body>
        <fmt:bundle basename="messages">
        <h3><fmt:message key="msg.choose-period"/></h3>
        <c:forEach items="${periods}" var="period">
            <form method="GET" action="period-info">
                <button type="submit" class="btn btn-outline-primary btn-block text-left">${period.name}</button>
                <input type="hidden" value="${period.id}" name="id-period">
            </form>
        </c:forEach>
        </fmt:bundle>
    </jsp:body>
</t:page-template>