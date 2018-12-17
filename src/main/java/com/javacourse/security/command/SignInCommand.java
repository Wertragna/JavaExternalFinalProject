package com.javacourse.security.command;

import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInCommand implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page( "/login.jsp",false);
    }
}