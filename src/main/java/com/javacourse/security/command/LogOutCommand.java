package com.javacourse.security.command;

import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;
import com.javacourse.shared.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Redirect
public class LogOutCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {

        request.getSession().invalidate();
        Page page = new Page( request.getContextPath()+"/login",true);
        return page;
    }
}
