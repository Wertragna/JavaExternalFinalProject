<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<tags:page-template>
    <div class="card">
        <div class="card-header">
            <nav class="nav nav-pills flex-column flex-sm-row d-flex align-content-start flex-wrap">
                <a class="text-sm-center nav-link active"
                   href="${pageContext.request.contextPath}/admin/period-info?id-period=${param["id-period"]}">info</a>
                <a class="text-sm-center nav-link "
                   href="${pageContext.request.contextPath}/admin/period-edit?id-period=${param["id-period"]}">edit</a>
                <a class="text-sm-center nav-link"
                   href="${pageContext.request.contextPath}/admin/period-mark?id-period=${param["id-period"]}">mark</a>
            </nav>
        </div>
        <div class="card-body">
            <div class="container">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item row d-flex">
                        <div class="col-md-3"><b>Name</b></div>
                        <div class="col-md-9">${name}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-3"><b>State</b></div>
                        <div class="col-md-9">${state}</div>
                    </li>
                    <li class="list-group-item row d-flex">
                        <div class="col-md-3"><b>Number of applicant</b></div>
                        <div class="col-md-9">${applicants}</div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</tags:page-template>