<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
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
    </jsp:body>
</t:page-template>