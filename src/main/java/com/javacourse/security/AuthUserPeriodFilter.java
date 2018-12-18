package com.javacourse.security;

import com.javacourse.user.User;
import com.javacourse.user.role.Role;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = {"/applicant/*"})
public class AuthUserPeriodFilter extends HttpFilter {
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
        Integer applicantId = (Integer) session.getAttribute("applicantId");
        if (nonNull(session) && nonNull(user) && (user.getRole().equals(Role.USER)))
            if (applicantId == null) {
                ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/period");
            } else
                filterChain.doFilter(request, response);
        else {
            RequestDispatcher dispatcher = ((HttpServletRequest) request).getSession().getServletContext().getRequestDispatcher("/error404.jsp"); // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}