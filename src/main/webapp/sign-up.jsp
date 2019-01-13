<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<t:page-template>
    <jsp:body>
        <fmt:bundle basename="messages">
        <div class="container">
            <form method="POST" action="sign-up" class="form-signin">

                <h1 class="h1 m-lg-3 text-center">Welcome to enrollment system!</h1>
                <c:if test="${not empty error}">
                        <div class="alert alert-danger">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="InputEmail1"><fmt:message key="msg.email"/></label>
                    <input name="login" type="email" class="form-control" id="InputEmail1" aria-describedby="emailHelp"
                           placeholder="Enter email"/>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.
                    </small>
                </div>
                <div class="form-group">
                    <label for="InputFirstName"><fmt:message key="msg.first-name"/></label>
                    <input name="firstname" type="text" class="form-control" id="InputFirstName"
                           placeholder="Enter first name"/>
                </div>
                <div class="form-group">
                    <label for="InputSurname"><fmt:message key="msg.surname"/></label>
                    <input name="surname" type="text" class="form-control" id="InputSurname"
                           placeholder="Enter surname"/>
                </div>
                <div class="form-group">
                    <label for="InputPassword1"><fmt:message key="msg.password"/></label>
                    <input name="password" type="password" class="form-control" id="InputPassword1"
                           placeholder="Password"/>
                </div>
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="msg.sign-up"/></button>
            </form>
        </div>
        </fmt:bundle>
    </jsp:body>
</t:page-template>
