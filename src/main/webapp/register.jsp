<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 17.12.2018
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <title>Register</title>
</head>
<body>

<div class="container"><h3 class="h3">Welcome to enrollment system!</h3>
    <form method="POST" action="register">
        <div class="form-group" >
            <label for="InputEmail1">Email address</label>
            <input name="login" type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email"/>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group" >
            <label for="InputFirstName">First name</label>
            <input name="firstname" type="text" class="form-control" id="InputFirstName"
                   placeholder="Enter first name"/>
        </div>
        <div class="form-group" >
            <label for="InputSurname">Surname</label>
            <input name="surname" type="text" class="form-control" id="InputSurname"
                   placeholder="Enter surname"/>
        </div>
        <div class="form-group">
            <label for="InputPassword1">Password</label>
            <input name="password"  type ="password" class="form-control" id="InputPassword1" placeholder="Password"/>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Sign up</button>
    </form>
</div>
</body>

