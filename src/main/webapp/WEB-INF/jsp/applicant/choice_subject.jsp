<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3>Subjects</h3>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">name</th>
            </tr>
            <tbody>
            <c:forEach items="${selectedSubjects}" var="selectedSubject">
                <tr>
                    <td>${selectedSubject.name}</td>
                </tr>
            </c:forEach>

            </tbody>
            </thead>
        </table>
        <form action="choose-subjects" method="post">
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
    </jsp:body>
</t:page-template>
