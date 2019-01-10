package com.javacourse.user.applicant.applicant_command;

import com.javacourse.user.User;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.utils.PathPageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PeriodCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(Logger.class);
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
            PeriodService periodService = new PeriodService();
            List<Period> periods = periodService.getAvailablePeriodsByUserId(user.getId());
            request.setAttribute("periods",periods);

        return new Page(PathPageManager.getProperty("page.period")).setDispatchType(Page.DispatchType.FORWARD);
    }
}
