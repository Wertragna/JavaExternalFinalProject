<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Subjects</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">name</th>
                <th scope="col"></th>
            </tr>
            <tbody>
            <c:forEach items="${selectedSubjects}" var="selectedSubject">
                <form method="post" name="choose-subjects">
                    <tr><input type="hidden" name="type" value="delete">
                        <input type="hidden" name="idSelectedSubject" value="${selectedSubject.id}">
                        <td class="col-sm-9">${selectedSubject.name}</td>
                        <td class="col-sm-3">
                            <button type="submit" class="btn btn-primary">delete</button>
                        </td>
                    </tr>
                </form>
            </c:forEach>

            </tbody>
            </thead>
        </table>
        <c:if test="${not empty subjects}">
            <form action="choose-subjects" method="post">
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
            </form>
        </c:if>
    </jsp:body>
</t:page-template>
