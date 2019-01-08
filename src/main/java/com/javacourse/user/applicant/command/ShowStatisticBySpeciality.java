package com.javacourse.user.applicant.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.Applicant;
import com.javacourse.user.applicant.ApplicantServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowStatisticBySpeciality implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        ApplicantServiceSql serviceSql = new ApplicantServiceSql();
        int specialityId = Integer.parseInt(request.getParameter("speciality"));
        int page = Integer.parseInt(request.getParameter("page"));
        int periodId= Integer.parseInt(request.getParameter("id-period"));
        //todo limit this query for pagination
        List<Applicant> applicants = serviceSql.getBySpecialityIdAndPeriodId(specialityId,periodId);

        request.setAttribute("applicants",applicants);
        request.setAttribute("currentPage",page);
        request.setAttribute("lastPage", 10);
        System.out.println(applicants);
        return new Page(PathPageManager.getProperty("page.statistics"),false);
    }
}
