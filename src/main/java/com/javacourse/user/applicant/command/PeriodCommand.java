package com.javacourse.user.applicant.command;

import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodDAOSql;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.ServicePeriod;
import com.javacourse.user.applicant.period.ServicePeriodSql;
import com.javacourse.utils.PathPageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class PeriodCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(Logger.class);
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ServicePeriod servicePeriod  = new ServicePeriodSql();
            List<Period> periods = servicePeriod.getAll();
            request.setAttribute("periods",periods);
        } catch (UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return new Page(PathPageManager.getProperty("page.period"),false);
    }
}
