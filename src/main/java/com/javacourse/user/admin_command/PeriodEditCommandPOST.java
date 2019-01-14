package com.javacourse.user.admin_command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.user.applicant.period.state.StateName;
import com.javacourse.utils.PathPageManager;
import com.javacourse.utils.ValidationManager;

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
            if (!ValidationManager.isValidate(period)) {
                request.setAttribute("error", ValidationManager.getFirsErrorMessage(period));
                request.setAttribute("period",period);
                return new Page(PathPageManager.getProperty("page.period-edit")).setDispatchType(Page.DispatchType.FORWARD);
            } else
            periodService.update(period);
        }

        return new Page("/admin/period-edit"+'?'+request.getQueryString()).setDispatchType(Page.DispatchType.REDIRECT);
    }
}
