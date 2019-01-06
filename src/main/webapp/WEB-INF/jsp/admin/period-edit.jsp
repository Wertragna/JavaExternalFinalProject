<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:page-template>
    <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap ">
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-info?id-period=${param["id-period"]}">info</a>
                <a class="text-sm-center nav-link active"
                   href="${pageContext.request.contextPath}/admin/period-edit?id-period=${param["id-period"]}">edit</a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}">mark</a>
            </nav>
        </div>
        <div class="card-body">
            <form name="period-edit" method="post">
                <h3>
                    Edit
                </h3>
                <input type="hidden" name="type" value="update">
                <input type="hidden" name="id" value="${period.id}">
                <input type="hidden" name="state" value="${period.state}">
                <div class="input-group">
                    <div class="input-group-prepend"><span class="input-group-text">name</span></div>
                    <input type="text" class="form-control" id="name" name="name" value="${period.name}">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="save" id="button-addon2">submit</button>
                    </div>
                </div>
            </form>

            <form name="period-edit" method="post">
                <h3>Set the next stage of period</h3>
                <input type="hidden" name="type" value="state">
                <input type="hidden" name="id" value="${period.id}">
                <input type="hidden" name="state" value="${period.state}">
                <input type="hidden" class="form-control" name="name" value="${period.name}">

                <input type="submit" class="btn btn-primary">
            </form>
        </div>
    </div>
</tags:page-template>