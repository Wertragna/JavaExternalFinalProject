package com.javacourse.security;

import com.javacourse.user.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = {"/admin/*", "/applicant/*", "/period"})
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
            ((HttpServletResponse)response).sendRedirect( ((HttpServletRequest) request).getContextPath()+"/login/sign-in");
        }
    }

    @Override
    public void destroy() {
    }

}
