<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 18.12.2018
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<body>
<jsp:include page="/WEB-INF/jsp/applicant/header_user.jsp"/>
<div class="container">
    <h3>Choose Period</h3>
    <c:forEach items="${periods}" var="period">
        <form method="POST" action="period">
            <div class="input-group mb-3 card">
                <div class="card-header">

                    <input type="text" readonly class="form-control-plaintext" value="${period.name}"
                           aria-label="Recipient's username"
                           aria-describedby="button-addon2">
                </div>
                <div class="card-body">
                    <input type="hidden" value="${period.id}" name="id">
                    <button class="btn btn-primary" type="submit" id="button-addon2">Go!</button>
                </div>
            </div>
        </form>
    </c:forEach>
</div>
</body>
</html>
