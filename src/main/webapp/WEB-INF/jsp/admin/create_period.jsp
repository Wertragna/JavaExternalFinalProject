<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:page-template>
    <jsp:body>
        <h3 class="h3">Create new Period!</h3>
        <form method="POST" action="create-new-period">
            <input type="hidden" name="command" value="create_new_period"/>
            <div class="form-group">
                <label for="period">name</label>
                <input name="name" class="form-control" id="period"/>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </jsp:body>
</t:page-template>