<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/site.css"/>
         <script type="text/javascript" src="${pageContext.request.contextPath}/feather-icons/dist/feather.min.js"></script>
    </jsp:attribute>
    <jsp:attribute name="header">
      <jsp:include page="/WEB-INF/jsp/shared/header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
       <%-- <div class="footer">
            <p>Copyright 2018-2019, Sherstyniuk Bohdana.</p>
        </div>--%>
    </jsp:attribute>
    <jsp:body>
        <main roleEntity="main" class="container pt-3">
            <jsp:doBody/>
        </main>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-slim.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            feather.replace()
        </script>
        <script>
            $('#submit').click(function(){
                $('#nextStep').submit();
            });
        </script>
    </jsp:body>
</t:genericpage>