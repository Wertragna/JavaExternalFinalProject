<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<tags:page-template>
    <fmt:bundle basename="messages">
    <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap ">
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-info?id-period=${param["id-period"]}"><fmt:message key="msg.info"/></a>
                <a class="text-sm-center nav-link active"
                   href="${pageContext.request.contextPath}/admin/period-edit?id-period=${param["id-period"]}"><fmt:message key="msg.edit"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}"><fmt:message key="msg.mark"/></a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/specialities?id-period=${param["id-period"]}"><fmt:message key="msg.statistics"/></a>
            </nav>
        </div>
        <div class="card-body">
            <form name="period-edit" method="post">
                <h3>
                    <fmt:message key="msg.edit"/>
                </h3>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                            ${error}
                    </div>
                </c:if>
                <input type="hidden" name="type" value="update">
                <input type="hidden" name="id" value="${period.id}">
                <input type="hidden" name="state" value="${period.state}">
                <div class="input-group">
                    <div class="input-group-prepend"><span class="input-group-text"><fmt:message key="msg.name"/></span></div>
                    <input type="text" class="form-control" id="name" name="name" value="${period.name}">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="save" id="button-addon2"><fmt:message key="msg.save"/></button>
                    </div>
                </div>
            </form>


            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                <fmt:message key="msg.next-step"/>
            </button>

        </div>
    </div>
    <form name="period-edit" id="nextStep" method="post">
        <input type="hidden" name="type" value="state">
        <input type="hidden" name="id" value="${period.id}">
        <input type="hidden" name="state" value="${period.state}">
        <input type="hidden" class="form-control" name="name" value="${period.name}">
    </form>


    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalCenterTitle">Set the next step of period</h5>
                </div>
                <div class="modal-body">
                    You cant rollback this changes.
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" id="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    </fmt:bundle>
</tags:page-template>