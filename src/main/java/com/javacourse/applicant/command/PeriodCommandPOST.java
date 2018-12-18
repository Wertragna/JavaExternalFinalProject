package com.javacourse.applicant.command;

import com.javacourse.applicant.Applicant;
import com.javacourse.applicant.ApplicantDAO;
import com.javacourse.applicant.period.Period;
import com.javacourse.applicant.period.state.State;
import com.javacourse.applicant.status.Status;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;
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
        ApplicantDAO applicantDAO = new ApplicantDAO();
        String namePeriod = request.getParameter("name");
        int applicantId;
        try {
            applicantId = applicantDAO.getByUserIdAndPeriod(user, periodId);
            if (applicantId == -1) {//todo -1 mean dont exist
                Applicant applicant = new Applicant();
                applicant.setUser(user);
                applicant.setPeriod(new Period(periodId, namePeriod, State.CHOICE_SUBJECTS));
                applicant.setStatus(new Status(1, "under consideration"));
                if (applicantDAO.create(applicant)) {
                    applicantId = applicantDAO.getByUserIdAndPeriod(user, periodId);
                    session.setAttribute("applicantId", applicantId);
                }
            } else {
                session.setAttribute("applicantId", applicantId);
            }
        } catch (UnsuccessfulDAOException e) {
            //todo logging
        }

        page = new Page(request.getContextPath() + "/applicant", true);
        return page;
    }
}
