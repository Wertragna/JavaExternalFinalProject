package com.javacourse.user.applicant.period.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.user.applicant.period.PeriodServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PeriodEditCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id-period");
        int id = Integer.parseInt(idString);
        PeriodService periodService = new PeriodServiceSql();
        Period period = periodService.getByIdWithState(id);
        request.setAttribute("period",period);
        return new Page(PathPageManager.getProperty("page.period-edit"), false);
    }
}
