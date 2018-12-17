<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 16.12.2018
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h3 class="h3">Create new Period!</h3>
    <form method="POST" action="create-new-period">
        <input type="hidden" name="command" value="create_new_period"/>
        <div class="form-group">
            <label for="period">name</label>
            <input name="name" class="form-control" id="period" />
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
</body>
</html>
