package com.javacourse.rbac.command;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.user.User;
import com.javacourse.user.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();
        String page = "/index.jsp";
        return page;
    }
}
