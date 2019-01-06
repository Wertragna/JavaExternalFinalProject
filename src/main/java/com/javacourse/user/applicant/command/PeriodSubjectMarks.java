package com.javacourse.user.applicant.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.user.applicant.ApplicantServiceSql;
import com.javacourse.user.applicant.ApplicantSubject;
import com.javacourse.user.applicant.period.state.StateName;
import com.javacourse.user.applicant.period.state.StateService;
import com.javacourse.user.applicant.period.state.StateServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PeriodSubjectMarks implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id-period"));

        StateService<Integer> stateService = new StateServiceSql();
        StateName stateName= stateService.getByPeriodId(id);
        if (StateName.CHECK_TESTS.equals(stateName)) {
            request.setAttribute("access", true);
        } else request.setAttribute("access", false);


        int subject = Integer.parseInt(request.getParameter("subject"));
        ApplicantService<Integer> applicantService =  new ApplicantServiceSql();
        List<ApplicantSubject> applicantSubjectList = applicantService.getByPeriodAndSubject(id,subject);
        request.setAttribute("applicants",applicantSubjectList);

        return new Page(PathPageManager.getProperty("page.period-subject-marks"), false);
    }
}
