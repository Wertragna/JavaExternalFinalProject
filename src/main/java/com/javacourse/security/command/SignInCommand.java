package com.javacourse.security.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getParameter("error"));
        Page page = new Page(PathPageManager.getProperty("page.sign-in")).setDispatchType(Page.DispatchType.FORWARD);
        return page;
    }
}
