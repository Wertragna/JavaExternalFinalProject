package com.javacourse.user.applicant.period.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowPeriodsCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response){
        PeriodService periodService = new PeriodService();
        List<Period> periods = periodService.getAll();
        request.setAttribute("periods",periods);
        return new Page(PathPageManager.getProperty("page.periods"),false);
    }
}
