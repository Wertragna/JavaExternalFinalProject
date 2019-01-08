<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:page-template>
    <jsp:body>
        <style>
            .vertical-center{
                vertical-align: center !important;
            }

        </style>
        <h3>Marks</h3>
        <a class="btn-primary btn"
           href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}">back</a>
        <div class="container pt-3">

            <c:choose>
                <c:when test="${not empty applicants and access==true}">
                    <form method="post" name="period-subject-marks" class="pt-2">
                        <div class="table-responsive">
                            <table class="table table-sm">
                                <thead class="thead-light">
                                <tr>
                                    <th style="width: 75%" scope="col">name</th>
                                    <th style="width: 25%" scope="col">mark</th>
                                </tr>
                                <tbody>
                                <c:forEach items="${applicants}" var="applicant">
                                    <input type="hidden" name="period" value="${param["id-period"]}">
                                    <input type="hidden" name="subject" value="${param["subject"]}">
                                    <tr>
                                        <td class="align-middle">#${applicant.applicant}</td>
                                        <td class="p-0">
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
                        </div>
                    </form>
                </c:when>
                <c:when test="${not empty applicants and access==false}">
                    <div class="alert alert-info" role="alert">
                        Sorry, but you haven't access to this page!Please, check state of current period!
                    </div>
                    <form method="post" name="period-subject-marks" class="pt-2">
                        <fieldset disabled>
                            <div class="table-responsive">
                                <table class="table table-sm ">
                                    <thead class="thead-light">
                                    <tr>
                                        <th style="width: 75%" scope="col">name</th>
                                        <th style="width: 25%" scope="col">mark</th>
                                    </tr>
                                    <tbody>
                                    <c:forEach items="${applicants}" var="applicant">
                                        <input type="hidden" name="period" value="${param["id-period"]}">
                                        <input type="hidden" name="subject" value="${param["subject"]}">
                                        <tr>
                                            <td class="align-middle" >#${applicant.applicant}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty applicant.mark}">
                                                        <input name="mark${applicant.applicant}"
                                                               class="w-100 form-control">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input name="mark${applicant.applicant}"
                                                               class="w-100 form-control"
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
                            </div>
                        </fieldset>
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