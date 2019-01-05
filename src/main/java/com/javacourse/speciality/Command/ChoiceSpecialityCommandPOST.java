package com.javacourse.speciality.Command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.applicant.Applicant;
import com.javacourse.user.applicant.ApplicantService;
import com.javacourse.user.applicant.ApplicantServiceSql;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoiceSpecialityCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = (Integer) request.getSession().getAttribute("applicantId");
        ApplicantService<Integer> service =new ApplicantServiceSql();
        Applicant applicant= service.getById(id);
        System.out.println(request.getParameter("idSpeciality"));
        int idSpeciality = Integer.parseInt(request.getParameter("idSpeciality"));
        applicant.setSpeciality(idSpeciality);
        service.update(applicant);
         return new Page(request.getContextPath() + "/applicant/choose-speciality", true);
    }
}
