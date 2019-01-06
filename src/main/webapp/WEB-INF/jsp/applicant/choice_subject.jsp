<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Subjects</h3>
        <c:if test="${not access}">
            <div class="alert alert-info" role="alert">
                Sorry, you don't have access to do changes!
            </div>
        </c:if>
        <ul class="list-group list-group-flush">
            <c:forEach items="${selectedSubjects}" var="selectedSubject">
                <li class="list-group-item ">
                    <form method="post" name="choose-subjects">
                        <input type="hidden" name="type" value="delete">
                        <c:choose>

                            <c:when test="${not access}">
                                <fieldset disabled>
                                    <input type="hidden" name="idSelectedSubject" value="${selectedSubject.id}">
                                    <div class="row">
                                        <div class="col-md-10">
                                            <div class="vertical-center">${selectedSubject.name}</div>
                                        </div>
                                        <div class="col-md-2 ">
                                            <button type="submit" class="btn btn-primary">delete
                                            </button>
                                        </div>
                                    </div>
                                </fieldset>
                            </c:when>
                            <c:otherwise>
                                <input type="hidden" name="idSelectedSubject" value="${selectedSubject.id}">
                                <div class="row">
                                    <div class="col-md-10">${selectedSubject.name}</div>
                                    <div class="col-md-2">
                                        <button type="submit" class="btn btn-primary vertical-center">delete</button>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </form>
                </li>
            </c:forEach>
        </ul>
        <c:if test="${not empty subjects}">
            <form action="choose-subjects" method="post">
                <c:choose>
                    <c:when test="${not access}">
                        <fieldset disabled>
                            <input type="hidden" name="type" value="add">
                            <div class="form-row align-items-center">
                                <div class="col-auto my-1">
                                    <label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Preference</label>
                                    <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="idSubject">

                                        <c:forEach items="${subjects}" var="subject">
                                            <option name="idSubject" value="${subject.id}">${subject.name}</option>
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
                                <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="idSubject">

                                    <c:forEach items="${subjects}" var="subject">
                                        <option name="idSubject" value="${subject.id}">${subject.name}</option>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="col-auto my-1">
                                <button type="submit" class="btn btn-primary">Add</button>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>
        </c:if>
    </jsp:body>
</t:page-template>
