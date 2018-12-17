package com.javacourse.rbac.command;

import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Type;
import com.javacourse.shared.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Redirect
public class LogOutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();
        String page =  request.getContextPath()+"/login";
        return page;
    }
}
