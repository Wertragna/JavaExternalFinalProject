package com.javacourse.user.command;

import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodDAO;
import com.javacourse.user.applicant.period.state.State;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewPeriodCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
        String name=  request.getParameter("name");
        Period period = new Period();
        period.setState(State.CHOICE_SUBJECTS);
        period.setName(name);
        try {
            if(new PeriodDAO().create(period)){
                //todo change page
                page = new Page( PathPageManager.getProperty("page.index"),false);
            }
            else
                page =new Page(PathPageManager.getProperty("page.create-period"),false);
        } catch (UnsuccessfulDAOException e) {
            //todo logging
        }
        return page;
    }
}
