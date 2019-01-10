package com.javacourse.user.applicant.applicant_command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.speciality.Speciality;
import com.javacourse.user.speciality.SpecialityService;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.user.applicant.period.state.StateName;
import com.javacourse.user.applicant.period.state.StateServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChoiceSpecialityCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = (Integer) request.getSession().getAttribute("applicantId");

        
        ApplicantService applicantService = new ApplicantService();
        StateServiceSql stateService = new StateServiceSql();


        StateName stateName= stateService.getByPeriodId(applicantService.getById(id).getPeriod());
        if(!stateName.equals(StateName.CHOICE_SPECIALITY)){
            request.setAttribute("access", false);
        } else
            request.setAttribute("access", true);



        SpecialityService specialityService = new SpecialityService();
        List<Speciality> specialities = specialityService.getAvailableSpecialitiesByApplicantId(id);
        request.setAttribute("specialities", specialities);
        System.out.println(specialities);
        return new Page(PathPageManager.getProperty("page.choice-speciality")).setDispatchType(Page.DispatchType.FORWARD);
    }
}
