package com.javacourse.speciality.Command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.speciality.Speciality;
import com.javacourse.speciality.SpecialityService;
import com.javacourse.speciality.SpecialityServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChoiceSpecialityCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = (Integer) request.getSession().getAttribute("applicantId");
        SpecialityService specialityService = new SpecialityServiceSql();
        List<Speciality> specialities = specialityService.getAvailableSpecialitiesByApplicantId(id);
        request.setAttribute("specialities", specialities);
        System.out.println(specialities);
        return new Page(PathPageManager.getProperty("page.choice-speciality"), false);
    }
}
