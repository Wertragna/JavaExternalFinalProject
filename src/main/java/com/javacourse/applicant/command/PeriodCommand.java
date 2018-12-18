package com.javacourse.applicant.command;

import com.javacourse.applicant.period.Period;
import com.javacourse.applicant.period.PeriodDAO;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PeriodCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Period> periods = new PeriodDAO().getAll();
            request.setAttribute("periods",periods);
        } catch (UnsuccessfulDAOException e) {
            //todo logging
        }
        return new Page("/WEB-INF/jsp/applicant/period.jsp",false);
    }
}
