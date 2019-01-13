<%@ page import="com.javacourse.user.role.Role" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:bundle basename="header_messages">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="${pageContext.request.contextPath}">Enrollment system</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <c:set var="ADMIN" value="<%=Role.ADMIN%>"/>
        <c:set var="USER" value="<%=Role.USER%>"/>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <c:if test="${sessionScope.user.roleEntity == ADMIN}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/"><fmt:message key="msg.home"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/create-new-period">create new
                            period</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/admin/periods"><fmt:message key="msg.periods"/></a>
                    </li>
                </c:if>
                <c:if test="${sessionScope.user.roleEntity == USER}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/"><fmt:message key="msg.home"/></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/period"><fmt:message key="msg.application"/></a>
                    </li>
                </c:if>
            </ul>
            <ul class="navbar-nav right">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login/logout"> <i
                                    data-feather="log-out"></i> <fmt:message key="msg.logout"/></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login/sign-in"> <i
                                    data-feather="log-in"></i><fmt:message key="msg.sign-in"/> </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login/sign-up"><fmt:message
                                    key="msg.sign-up"/></a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
</fmt:bundle>