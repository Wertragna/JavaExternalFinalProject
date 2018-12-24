package com.javacourse.subject.command;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.subject.SubjectDAOSql;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChoiceSubjectCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idSubject"));
        System.out.println(id);
        HttpSession session = request.getSession();

        Integer applicantId = (Integer) session.getAttribute("applicantId");

        try {
            new SubjectDAOSql().addSubjectApplicant(id, applicantId);
        } catch (UnsuccessfulDAOException e) {
            //todo
        }
        return new Page(request.getContextPath() + "/applicant/choose-subjects", true);

    }
}
