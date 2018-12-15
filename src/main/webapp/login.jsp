<%--
  Created by IntelliJ IDEA.
  User: Bohdana
  Date: 15.12.2018
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <title>Title</title>
</head>
<body>

<div class="container"><h3 class="h3">Welcome to enrollment system!</h3>
    <form method="POST" action="login">
        <input type="hidden" name="command" value="sign_in"/>
        <div class="form-group" >
            <label for="InputEmail1">Email address</label>
            <input name="login" type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter email"/>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="InputPassword1">Password</label>
            <input name="password"  type ="password" class="form-control" id="InputPassword1" placeholder="Password"/>
        </div>
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
