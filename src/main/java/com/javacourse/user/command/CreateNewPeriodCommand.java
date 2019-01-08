package com.javacourse.user.command;

import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.utils.PathPageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewPeriodCommand implements ActionCommand {
    private final static Logger logger = Logger.getLogger(CreateNewPeriodCommand.class);
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
        String name=  request.getParameter("name");
        Period period = new Period();
        period.setState(1/* todo magic number */);
        period.setName(name);
        PeriodService periodService = new PeriodService();
        try {
            if(periodService.create(period)){
                //todo change page
                page = new Page( PathPageManager.getProperty("page.index"),false);
            }
            else
                page =new Page(PathPageManager.getProperty("page.create-period"),false);
        } catch (UnsuccessfulDAOException e) {
           logger.error(e.getMessage());
        }
        return page;
    }
}
