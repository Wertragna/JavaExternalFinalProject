package com.javacourse.user.applicant.command;

import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodDAO;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.utils.PathPageManager;

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
        return new Page(PathPageManager.getProperty("page.period"),false);
    }
}
