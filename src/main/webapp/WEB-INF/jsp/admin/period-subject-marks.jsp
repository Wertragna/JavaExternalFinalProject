<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:page-template>
    <jsp:body>
        <h3>Marks</h3>
        <a class="btn-primary btn"
           href="${pageContext.request.contextPath}/admin/period-mark?id=${param["id"]}">back</a>
        <div class="container pt-3">
        <c:choose>
            <c:when test="${not empty applicants}">
                <form method="post" name="period-subject-marks" class="pt-2">

                    <table class="table table-hover table-bordered">
                        <thead class="thead-light">
                        <tr>
                            <th style="width: 75%" scope="col">name</th>
                            <th style="width: 25%" scope="col">mark</th>
                        </tr>
                        <tbody>

                        <c:forEach items="${applicants}" var="applicant">
                            <input type="hidden" name="period" value="${param["id"]}">
                            <input type="hidden" name="subject" value="${param["subject"]}">
                            <tr>

                                <td>#${applicant.applicant}</td>
                                <td>

                                    <c:choose>
                                        <c:when test="${empty applicant.mark}">
                                            <input name="mark${applicant.applicant}" class="w-100 form-control">
                                        </c:when>
                                        <c:otherwise>
                                            <input name="mark${applicant.applicant}" class="w-100 form-control"
                                                   value="${applicant.mark}">
                                        </c:otherwise>

                                    </c:choose>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        </thead>
                    </table>
                    <button type="submit" class="btn btn-primary"> submit</button>
                </form>
            </c:when>
            <c:otherwise>
                <div class="alert alert-info" role="alert">
                    Applicants haven't pass test of this subject!
                </div>
            </c:otherwise>
        </c:choose>
        </div>
    </jsp:body>
</tags:page-template>