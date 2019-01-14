<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 15.12.2018
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<t:page-template>
    <jsp:body>

        <div class="jumbotron p-3 p-md-5   rounded bg-light border-info border">
            <h1 class="text-center display-4 pb-5 font-weight-bold">Welcome to the Application Platform!</h1>
            <hr class="mb-5"/>
            Below are the application and enrollment process steps:
            <ol>
                <li> Students apply and choose subject</li>
                <li> We notify each applicant of their marks of subject</li>
                <li> Applicants may be asked at any time during the matching process to interview with host professors</li>
                <li> Select applicants receive an internship offer by February 2019 and results are finalize</li>
            </ol>
            We reserve the right to remove an intern from the ane Period at any time for any reason, including (but not limited to):
            <ul>
                <li>Any aspect of an intern’s application is fraudulent</li>
                <li>An intern has uncompleted application</li>
            </ul>
        </div>


    </jsp:body>
</t:page-template>
