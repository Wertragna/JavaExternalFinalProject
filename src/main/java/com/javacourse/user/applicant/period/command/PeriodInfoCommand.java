package com.javacourse.user.applicant.period.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PeriodInfoCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String idString = request.getParameter("id-period");
        System.out.println(idString);
        int id = Integer.parseInt(idString);
        PeriodService periodService = new PeriodService();
        Period period = periodService.getByIdWithState(id);
        request.setAttribute("name", period.getName());
        request.setAttribute("state", period.getStateEntity().getName());
        return new Page(PathPageManager.getProperty("page.period-info"), false);
    }
}
