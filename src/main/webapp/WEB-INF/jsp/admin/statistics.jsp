<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Statistics</h3>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <thead>
                <tr>
                    <th>#</th>
                    <th>id</th>
                    <th>first name</th>
                    <th>second name</th>
                    <th>email</th>
                    <th>rating</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${applicants}" var="applicant" varStatus="loop">
                    <tr>
                        <td>${loop.index}</td>
                        <td>${applicant.id}</td>
                        <td>${applicant.userEntity.firstname}</td>
                        <td>${applicant.userEntity.surname}</td>
                        <td>${applicant.userEntity.email}</td>
                        <td>${applicant.rating}</td>
                    </tr>
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
                        <a class="page-link" href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${currentPage-1}"><< </a>
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
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${i}">${i}</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentPage != lastPage}">
                        <li class="page-item">
                            <a class="page-link" href="${pageContext.request.contextPath}/admin/statistic?id-period=${param["id-period"]}&speciality=${param["speciality"]}&page=${currentPage+1}">>> </a>
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
    </jsp:body>
</t:page-template>