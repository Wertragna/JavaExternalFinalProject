package com.javacourse.user.applicant.period.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PeriodEditCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int state = Integer.parseInt(request.getParameter("state"));
        int id = Integer.parseInt(request.getParameter("id"));
        PeriodService periodService = new PeriodService();
        Period period = new Period();
        period.setName(name);
        period.setState(state);
        period.setId(id);
        if (request.getParameter("type").equals("state")) {
            periodService.setNextState(period);
        } else {
            periodService.update(period);
        }

        return new Page(request.getRequestURL().append('?').append(request.getQueryString()).toString(), true);
    }
}
