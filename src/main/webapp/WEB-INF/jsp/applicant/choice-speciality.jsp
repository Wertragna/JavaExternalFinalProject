<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Choose speciality</h3>
        <c:if test="${not access}">
            <div class="alert alert-info" role="alert">
                Sorry, you don't have access to do changes!
            </div>
        </c:if>
        <c:if test="${not empty specialities}">
            <form action="choose-speciality" method="post">
                <c:choose>
                <c:when test="${not access}">
                    <fieldset disabled>
                        <input type="hidden" name="type" value="add">
                        <div class="form-row align-items-center">
                            <div class="col-auto my-1">
                                <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                                <select class="custom-select mr-sm-12" id="inlineFormCustomSelect"
                                        name="idSpeciality">
                                    <c:forEach items="${specialities}" var="speciality">
                                        <option name="idSpeciality"
                                                value="${speciality.id}">${speciality.name}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="col-auto my-1">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </div>

                    </fieldset>
                </c:when>
                <c:otherwise>
                <input type="hidden" name="type" value="add">
                <div class="form-row align-items-center">
                    <div class="col-auto my-1">
                        <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                        <select class="custom-select mr-sm-12" id="inlineFormCustomSelect"
                                name="idSpeciality">
                            <c:forEach items="${specialities}" var="speciality">
                                <option name="idSpeciality"
                                        value="${speciality.id}">${speciality.name}</option>
                            </c:forEach>

                        </select>
                    </div>
                    <div class="col-auto my-1">
                        <button type="submit" class="btn btn-primary">Add</button>
                    </div>
                    </c:otherwise>
                    </c:choose>
            </form>
        </c:if>
    </jsp:body>
</t:page-template>