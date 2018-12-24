package com.javacourse.shared.command;

import com.javacourse.shared.web.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
    Page execute(HttpServletRequest request, HttpServletResponse response);
}
