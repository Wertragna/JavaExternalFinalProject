package com.javacourse.user.admin_command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.period.Period;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.user.applicant.period.state.StateName;
import com.javacourse.utils.PathPageManager;
import com.javacourse.utils.ValidationManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewPeriodCommand implements ActionCommand {
    private final static Logger logger = Logger.getLogger(CreateNewPeriodCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
        String name = request.getParameter("name");
        Period period = new Period();
        period.setName(name);
        PeriodService periodService = new PeriodService();

        if (ValidationManager.isValidate(period)) {
            periodService.createWithStateName(period, StateName.CHOICE_SUBJECTS);
            request.setAttribute("msg.success", true);
        } else request.setAttribute("error", ValidationManager.getFirsErrorMessage(period));


        page = new Page(PathPageManager.getProperty("page.create-period")).setDispatchType(Page.DispatchType.FORWARD);
        return page;
    }
}
