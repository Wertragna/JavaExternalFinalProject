<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <div class="container">
            <form method="POST" action="register" class="form-signin">
                <h1 class="h1 m-lg-3 text-center">Welcome to enrollment system!</h1>
                <div class="form-group">
                    <label for="InputEmail1">Email address</label>
                    <input name="login" type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp"
                           placeholder="Enter email"/>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                    </small>
                </div>
                <div class="form-group">
                    <label for="InputFirstName">First name</label>
                    <input name="firstname" type="text" class="form-control" id="InputFirstName"
                           placeholder="Enter first name"/>
                </div>
                <div class="form-group">
                    <label for="InputSurname">Surname</label>
                    <input name="surname" type="text" class="form-control" id="InputSurname"
                           placeholder="Enter surname"/>
                </div>
                <div class="form-group">
                    <label for="InputPassword1">Password</label>
                    <input name="password" type="password" class="form-control" id="InputPassword1"
                           placeholder="Password"/>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Sign up</button>
            </form>
        </div>
    </jsp:body>
</t:page-template>
