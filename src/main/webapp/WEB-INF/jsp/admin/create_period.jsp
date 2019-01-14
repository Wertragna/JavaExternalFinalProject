<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<t:page-template>
    <jsp:body>
        <fmt:bundle basename="messages">
        <h3 class="h3"><fmt:message key="msg.create-new-period"/> </h3>
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    ${error}
                </div>
            </c:if>
        <form method="POST" action="create-new-period">
            <input type="hidden" name="command" value="create_new_period"/>
            <div class="form-group">
                <label for="period"><fmt:message key="msg.name"/></label>
                <input name="name" class="form-control" id="period"/>
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="msg.create"/></button>
        </form>
        </fmt:bundle>
    </jsp:body>
</t:page-template>