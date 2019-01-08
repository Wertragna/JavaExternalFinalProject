package com.javacourse.user.applicant.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.speciality.Speciality;
import com.javacourse.speciality.SpecialityService;
import com.javacourse.subject.Subject;
import com.javacourse.subject.SubjectServiceSql;
import com.javacourse.user.applicant.status.Status;
import com.javacourse.user.applicant.status.StatusService;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ApplicantInfoCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {

        int id = (Integer) request.getSession().getAttribute("applicantId");
        SubjectServiceSql subjectService = new SubjectServiceSql();
        List<Subject> subjects = subjectService.getByApplicantId(id);
        request.setAttribute("subjects",subjects);
        StatusService statusService = new StatusService();
        Status status = statusService.getByApplicantId(id);
        request.setAttribute( "status",status);
        SpecialityService specialityService= new SpecialityService();
        Speciality speciality = specialityService.getByApplicantId(id);
        request.setAttribute("speciality",speciality);
        return new Page(PathPageManager.getProperty("page.applicant-info"), false);

    }
}
