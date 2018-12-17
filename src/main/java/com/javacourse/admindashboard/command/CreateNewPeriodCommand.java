package com.javacourse.admindashboard.command;

import com.javacourse.applicant.period.Period;
import com.javacourse.applicant.period.PeriodDAO;
import com.javacourse.applicant.period.state.State;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewPeriodCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String name=  request.getParameter("name");
        Period period = new Period();
        period.setState(State.CHOICE_SUBJECTS);
        period.setName(name);
        try {
            if(new PeriodDAO().create(period)){
                page = "/index.jsp";
            }
            else
                page ="/WEB-INF/jsp/admin/create_period.jsp";
        } catch (UnsuccessfulDAOException e) {
            //todo logging
        }
        return page;
    }
}
