package com.javacourse.user.admin_command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.user.applicant.ApplicantSubject;
import com.javacourse.user.applicant.period.state.StateName;
import com.javacourse.user.applicant.period.state.StateServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PeriodSubjectMarks implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id-period"));

        StateServiceSql stateService = new StateServiceSql();
        StateName stateName= stateService.getByPeriodId(id);
        if (StateName.CHECK_TESTS.equals(stateName)) {
            request.setAttribute("access", true);
        } else request.setAttribute("access", false);


        int subject = Integer.parseInt(request.getParameter("subject"));
        ApplicantService applicantService =  new ApplicantService();
        List<ApplicantSubject> applicantSubjectList = applicantService.getByPeriodAndSubject(id,subject);
        System.out.println(applicantSubjectList);
        request.setAttribute("applicants",applicantSubjectList);

        return new Page(PathPageManager.getProperty("page.period-subject-marks")).setDispatchType(Page.DispatchType.FORWARD);
    }
}
