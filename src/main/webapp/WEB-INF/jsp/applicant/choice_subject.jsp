<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 18.12.2018
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="header_user.jsp"/>
<div class="container">
    <h3>Subjects</h3>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">name</th>
        </tr>
        <tbody>
        <c:forEach items="${selectedSubjects}" var="selectedSubject">
            <tr>
                <td>${selectedSubject.name}</td>
            </tr>
        </c:forEach>

        </tbody>
        </thead>
    </table>
    <form action="choose-subjects" method="post">
        <div class="form-row align-items-center">
            <div class="col-auto my-1">
                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name ="idSubject">

                    <c:forEach items="${subjects}" var="subject">
                        <option name="idSubject" value="${subject.id}">${subject.name}</option>
                    </c:forEach>

                </select>
            </div>
            <div class="col-auto my-1">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
