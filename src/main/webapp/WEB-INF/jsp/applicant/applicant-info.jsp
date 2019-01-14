<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<tags:page-template>
    <fmt:bundle basename="messages">
        <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap">
                <a class="nav-link active bg-success" href="${pageContext.request.contextPath}/applicant/info"><fmt:message key="msg.application"/></a>
                <a class="nav-link" href="${pageContext.request.contextPath}/applicant/choose-subjects"><fmt:message key="msg.subjects"/></a>
                <a class="nav-link" href="${pageContext.request.contextPath}/applicant/choose-speciality"><fmt:message key="msg.speciality"/></a>
            </nav>
        </div>
        <div class="card-body">
            <div class="container">
                <h3><fmt:message key="msg.application"/></h3>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b><fmt:message key="msg.first-name"/> </b></div>
                        <div class="col-md-10">${sessionScope.user.firstname}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b><fmt:message key="msg.surname"/></b></div>
                        <div class="col-md-10">${sessionScope.user.surname}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b><fmt:message key="msg.email"/></b></div>
                        <div class="col-md-10">${sessionScope.user.email}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b><fmt:message key="msg.status"/></b></div>
                        <div class="col-md-10">${status.name}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b>
                                <fmt:message key="msg.subjects"/>
                            </b>
                        </div>
                        <div class="col-md-10">
                            <c:choose>
                                <c:when test="${not empty subjects}">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item p-0">
                                            <div class="row">
                                                <div class="col-9"><i><fmt:message key="msg.name"/></i></div>
                                                <div class="col-3>"><i><fmt:message key="msg.mark"/></i></div>
                                            </div>
                                        </li>
                                        <c:forEach items="${subjects}" var="subject">
                                            <li class="list-group-item p-0">
                                                <div class="row">
                                                    <div class="col-9"> ${subject.subjectEntity.name}</div>
                                                    <c:choose>
                                                        <c:when test="${not empty subject.mark}">
                                                            <div class="col-3>">${subject.mark}</div>
                                                        </c:when><c:otherwise>
                                                        <div class="col-3>">-</div>
                                                    </c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:when>
                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2"><b><fmt:message key="msg.speciality"/></b></div>
                        <div class="col-md-10">
                            <c:choose>
                                <c:when test="${not empty speciality}">
                                    ${speciality.name}
                                </c:when>
                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </fmt:bundle>
</tags:page-template>