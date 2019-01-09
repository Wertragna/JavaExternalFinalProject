package com.javacourse.user.applicant.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.applicant.ApplicantService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PeriodCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int periodId = Integer.parseInt(request.getParameter("id"));
        ApplicantService applicantDAOSql = new ApplicantService();
        int applicantId = applicantDAOSql.getApplicantIdByUserIdAndPeriod(user, periodId);
        if (applicantId == -1 && applicantDAOSql.createNewByPeriodIdUserId(periodId, user.getId())) {
            applicantId = applicantDAOSql.getApplicantIdByUserIdAndPeriod(user, periodId);
        }
        session.setAttribute("applicantId", applicantId);
        Page page = new Page(request.getContextPath() + "/applicant/info", true);
        return page;
    }
}
