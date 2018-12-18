package com.javacourse.admindashboard.command;

import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewPeriodCommandGet implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {

        return  new Page("/WEB-INF/jsp/admin/create_period.jsp",false);
    }
}
