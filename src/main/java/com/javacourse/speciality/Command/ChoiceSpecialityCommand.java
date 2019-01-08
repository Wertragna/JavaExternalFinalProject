package com.javacourse.speciality.Command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.speciality.Speciality;
import com.javacourse.speciality.SpecialityService;
import com.javacourse.speciality.SpecialityServiceSql;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.user.applicant.ApplicantServiceSql;
import com.javacourse.user.applicant.period.state.StateName;
import com.javacourse.user.applicant.period.state.StateService;
import com.javacourse.user.applicant.period.state.StateServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChoiceSpecialityCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = (Integer) request.getSession().getAttribute("applicantId");

        
        ApplicantService<Integer> applicantService = new ApplicantServiceSql();
        StateService<Integer> stateService = new StateServiceSql();


        StateName stateName= stateService.getByPeriodId(applicantService.getById(id).getPeriod());
        if(!stateName.equals(StateName.CHOICE_SPECIALITY)){
            request.setAttribute("access", false);
        } else
            request.setAttribute("access", true);



        SpecialityService specialityService = new SpecialityServiceSql();
        List<Speciality> specialities = specialityService.getAvailableSpecialitiesByApplicantId(id);
        request.setAttribute("specialities", specialities);
        System.out.println(specialities);
        return new Page(PathPageManager.getProperty("page.choice-speciality"), false);
    }
}
