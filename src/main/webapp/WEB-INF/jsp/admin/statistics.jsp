<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<t:page-template>
    <jsp:body>
        <fmt:bundle basename="messages">
        <style>
            .bg-green {
                background-color: palegreen !important;
            }

            .bg-red {
                background-color: salmon !important;
            }

            table.table-bordered {
                border: 1px solid black;
                margin-top: 20px;
            }

            table.table-bordered > thead > tr > th {
                border: 1px solid black;
            }

            table.table-bordered > tbody > tr > td {
                border: 1px solid black;
            }

            hr.style1 {
                border-top: 3px solid #F1C40F;
            }
        </style>
        <a class="btn-primary btn"
           href="${pageContext.request.contextPath}/admin/specialities?id-period=${param["id-period"]}"><fmt:message key="msg.back"/> </a>
        <div class="container pt-3" >
        <h3 style="background-color: #FEF9E7" class="mb-0">Statistics</h3>
        <hr class="style1 mt-0 mb-0" style= "background-color: #FEF9E7"/>
        <c:set var="accept" scope="request" value="accepted"/>
        <c:set var="derived" scope="request" value="derived"/>

        <div class="table-responsive">
            <table class="table table-striped table-sm table-bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th>id</th>
                    <th>first name</th>
                    <th>second name</th>
                    <th>email</th>
                    <th>rating</th>
                    <th>status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${applicants}" var="applicant" varStatus="loop">
                    <c:choose>
                        <c:when test="${applicant.statusEntity.name eq accept}">
                            <tr class="bg-green">
                                <td>${loop.index}</td>
                                <td>${applicant.id}</td>
                                <td>${applicant.userEntity.firstname}</td>
                                <td>${applicant.userEntity.surname}</td>
                                <td>${applicant.userEntity.email}</td>
                                <td>${applicant.rating}</td>
                                <td>${applicant.statusEntity.name}</td>
                            </tr>
                        </c:when>
                        <c:when test="${applicant.statusEntity.name eq derived}">
                            <tr class="bg-red">
                                <td>${loop.index}</td>
                                <td>${applicant.id}</td>
                                <td>${applicant.userEntity.firstname}</td>
                                <td>${applicant.userEntity.surname}</td>
                                <td>${applicant.userEntity.email}</td>
                                <td>${applicant.rating}</td>
                                <td>${applicant.statusEntity.name}</td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td>${loop.index}</td>
                                <td>${applicant.id}</td>
                                <td>${applicant.userEntity.firstname}</td>
                                <td>${applicant.userEntity.surname}</td>
                                <td>${applicant.userEntity.email}</td>
                                <td>${applicant.rating}</td>
                                <td>${applicant.statusEntity.name}</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>

                </c:forEach>
                </tbody>
            </table>
        </div>
        <c:choose>
            <c:when test="${currentPage gt 1}">
                <c:set var="startPage" scope="request" value="${currentPage -1}"/>
            </c:when>
            <c:otherwise>
                <c:set var="startPage" scope="request" value="${1}"/>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${lastPage gt currentPage+1}">
                <c:set var="endPage" scope="request" value="${currentPage +2}"/>
            </c:when>
            <c:otherwise>
                <c:set var="endPage" scope="request" value="${lastPage}"/>
            </c:otherwise>
        </c:choose>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <c:choose>
                    <c:when test="${currentPage != 1}">
                        <li class="page-item">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${currentPage-1}"><< </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a class="page-link disabled" href="#"><< </a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:forEach begin="${startPage}" end="${requestScope.endPage}" var="i">
                    <c:choose>
                        <c:when test="${currentPage == i}">
                            <li class="page-item active">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link"
                                   href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPage != lastPage}">
                        <li class="page-item">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${currentPage+1}">>> </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled">
                            <a class="page-link disabled" href="#}">>> </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
        </fmt:bundle>
    </jsp:body>
</t:page-template>