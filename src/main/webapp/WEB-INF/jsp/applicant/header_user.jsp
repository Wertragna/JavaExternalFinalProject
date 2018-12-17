<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 17.12.2018
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/applicant">home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href = "${pageContext.request.contextPath}/applicant/apply">apply</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href = "${pageContext.request.contextPath}/applicant/choose-subjects">subject</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href = "${pageContext.request.contextPath}/login/logout">logout</a>
            </li>
        </ul>
    </div>
</nav>
