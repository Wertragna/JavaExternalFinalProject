<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <div class="form-group container container--mini">
            <form method="POST" action="sign-in" class="form-signin">
                <h1 class="h1 m-lg-5 text-center">Please sign in!</h1>
                <input type="hidden" name="command" value="sign_in"/>
                <label for="InputEmail1">Email address</label>
                <input name="login" type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp"
                       placeholder="Enter email"/>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                </small>
                <div class="form-group">
                    <label for="InputPassword1">Password</label>
                    <input name="password" type="password" class="form-control" id="InputPassword1"
                           placeholder="Password"/>
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Sing in</button>
            </form>
        </div>
    </jsp:body>
</t:page-template>
