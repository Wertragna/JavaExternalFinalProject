package com.javacourse.user.applicant.command;

import com.javacourse.user.applicant.Applicant;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PeriodCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int periodId = Integer.parseInt(request.getParameter("id"));
        ApplicantService applicantDAOSql = new ApplicantService();
        String namePeriod = request.getParameter("name");
        int applicantId;
        try {
            applicantId = applicantDAOSql.getApplicantIdByUserIdAndPeriod(user, periodId);
            if (applicantId == -1) {//todo -1 mean dont exist
                Applicant applicant = new Applicant();
                applicant.setUser(user.getId());
                applicant.setPeriod(periodId);
                applicant.setStatus(1);
                if (applicantDAOSql.create(applicant)) {
                    applicantId = applicantDAOSql.getApplicantIdByUserIdAndPeriod(user, periodId);
                    session.setAttribute("applicantId", applicantId);
                }
            } else {
                session.setAttribute("applicantId", applicantId);
            }
        } catch (UnsuccessfulDAOException e) {
            //todo logging
        }

        page = new Page(request.getContextPath() + "/applicant/info", true);
        return page;
    }
}
