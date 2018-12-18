package com.javacourse.applicant.command;

import com.javacourse.applicant.Applicant;
import com.javacourse.applicant.period.Period;
import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;
import com.javacourse.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApplicantHomeCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {

        return new Page("/WEB-INF/jsp/applicant/home_applicant.jsp", false);
    }
}
