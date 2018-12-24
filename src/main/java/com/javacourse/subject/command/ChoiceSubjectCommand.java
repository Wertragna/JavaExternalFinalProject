package com.javacourse.subject.command;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.subject.Subject;
import com.javacourse.subject.SubjectDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChoiceSubjectCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
       int id = (Integer) request.getSession().getAttribute("applicantId");
       SubjectDAO subjectDAO = new SubjectDAO();
        try {
            List<Subject> subjects = subjectDAO.getAll();

            List<Subject> selectedSubjects = subjectDAO.getByApplicantId(id);
            subjects.removeAll(selectedSubjects);
            request.setAttribute("subjects",subjects);
            request.setAttribute("selectedSubjects",selectedSubjects);
        } catch (UnsuccessfulDAOException e) {
            //todo logging
        }
        return new Page("/WEB-INF/jsp/applicant/choice_subject.jsp",false);
    }
}
