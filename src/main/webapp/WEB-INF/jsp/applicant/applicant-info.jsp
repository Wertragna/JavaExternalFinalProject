<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:page-template>
    <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap">
                <a class="nav-link active bg-success" href="${pageContext.request.contextPath}/applicant/info">application</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/applicant/choose-subjects">subject</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/applicant/choose-speciality">speciality</a>
            </nav>
        </div>
        <div class="card-body">
            <div class="container">
                <h3>Info</h3>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b>Status:</b></div>
                        <div class="col-md-10">${status.name}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2">
                            <b>
                                Subjects:
                            </b>
                        </div>
                        <div class="col-md-10">
                            <c:choose>
                                <c:when test="${not empty subjects}">
                                    <ul class="list-group list-group-flush">
                                        <c:forEach items="${subjects}" var="subject">
                                            <li class="list-group-item">${subject.name}</li>
                                        </c:forEach>
                                    </ul>
                                </c:when>
                                <c:otherwise>
                                    You haven't chosen any subject yet.
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-2"><b>Speciality:</b></div>
                        <div class="col-md-10">
                            <c:choose>
                                <c:when test="${not empty speciality}">
                                    ${speciality.name}
                                </c:when>
                                <c:otherwise>
                                    You haven't chosen speciality yet.
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
</tags:page-template>