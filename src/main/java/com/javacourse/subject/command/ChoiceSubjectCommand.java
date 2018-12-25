package com.javacourse.subject.command;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.subject.Subject;
import com.javacourse.subject.SubjectDAOSql;
import com.javacourse.subject.SubjectService;
import com.javacourse.subject.SubjectServiceSql;
import com.javacourse.utils.PathPageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChoiceSubjectCommand implements ActionCommand {
    private static final Logger logger = Logger.getLogger(SubjectServiceSql.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        int id = (Integer) request.getSession().getAttribute("applicantId");
        SubjectService subjectService = new SubjectServiceSql();
        try {
            List<Subject> subjects = subjectService.getAll();
            List<Subject> selectedSubjects = subjectService.getByApplicantId(id);
            subjects.removeAll(selectedSubjects);
            request.setAttribute("subjects", subjects);
            request.setAttribute("selectedSubjects", selectedSubjects);
        } catch (UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return new Page(PathPageManager.getProperty("page.choice-subjects"), false);
    }
}
