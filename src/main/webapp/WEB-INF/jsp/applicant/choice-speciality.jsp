<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Choose speciality</h3>
        <c:if test="${not empty specialities}">
            <form action="choose-speciality" method="post">
                <input type="hidden" name="type" value="add">
                <div class="form-row align-items-center">
                    <div class="col-auto my-1">
                        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                        <select class="custom-select mr-sm-12" id="inlineFormCustomSelect" name="idSpeciality">
                            <c:forEach items="${specialities}" var="speciality">
                                <option name="idSpeciality" value="${speciality.id}">${speciality.name}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="col-auto my-1">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                </div>
            </form>
        </c:if>
    </jsp:body>
</t:page-template>
