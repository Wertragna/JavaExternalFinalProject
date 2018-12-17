package com.javacourse.shared;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
    Page execute(HttpServletRequest request, HttpServletResponse response);
}
