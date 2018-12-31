package com.javacourse.user.applicant.command;

import com.javacourse.user.applicant.period.Period;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.user.applicant.period.PeriodServiceSql;
import com.javacourse.utils.PathPageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PeriodCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(Logger.class);
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {

            PeriodService periodService = new PeriodServiceSql();
            List<Period> periods = periodService.getAll();
            request.setAttribute("periods",periods);

        return new Page(PathPageManager.getProperty("page.period"),false);
    }
}
