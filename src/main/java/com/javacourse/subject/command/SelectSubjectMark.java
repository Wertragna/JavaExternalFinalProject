package com.javacourse.subject.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.subject.Subject;
import com.javacourse.subject.SubjectService;
import com.javacourse.subject.SubjectServiceSql;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SelectSubjectMark implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        SubjectService<Integer> subjectService = new SubjectServiceSql();
        List<Subject> subjects = subjectService.getAll();
        request.setAttribute("subjects",subjects);
        return new Page(PathPageManager.getProperty("page.period-mark"),false);
    }
}
