<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/site.css"/>
    </jsp:attribute>
    <jsp:attribute name="header">
      <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <footer class="footer">
            <div class="container">
                Copyright 2018-2019, Sherstyniuk Bohdana.
            </div>
        </footer>
    </jsp:attribute>
    <jsp:body>
        <main role="main" class="container">
            <jsp:doBody/>
        </main>
    </jsp:body>
</t:genericpage>