package com.javacourse.subject.command;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.subject.SubjectService;
import com.javacourse.subject.SubjectServiceSql;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChoiceSubjectCommandPOST implements ActionCommand {
    private static final Logger logger = Logger.getLogger(SubjectServiceSql.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Integer applicantId = (Integer) session.getAttribute("applicantId");
        String type = request.getParameter("type");
        if (type.equals("delete")) {
            int subjectId = Integer.parseInt( request.getParameter("idSelectedSubject"));
            deleteSubjectBySubjectIdAndApplicactId(subjectId, applicantId);
        } else {
            int id = Integer.parseInt(request.getParameter("idSubject"));
            System.out.println(id);

            try {
                new SubjectServiceSql().addSubjectApplicant(id, applicantId);
            } catch (UnsuccessfulDAOException e) {
                logger.error(e.getMessage());
            }
        }
        return new Page(request.getContextPath() + "/applicant/choose-subjects", true);

    }

    public boolean deleteSubjectBySubjectIdAndApplicactId(int subjectId, int applicantId) {
        SubjectService subjectService = new SubjectServiceSql();
        return subjectService.deleteSubjectBySubjectIdAndApplicantId(subjectId,applicantId);
    }

}
