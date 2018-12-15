package com.javacourse.rbac;

import com.javacourse.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = {"/admin/*", "/application/*", "/"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        if (nonNull(session) && nonNull(user)) {
            filterChain.doFilter(request, response);
        } else {
            RequestDispatcher dispatcher = ((HttpServletRequest) request).getSession().getServletContext().getRequestDispatcher("/login.jsp"); // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}
