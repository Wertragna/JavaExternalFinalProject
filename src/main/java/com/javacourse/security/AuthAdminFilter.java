package com.javacourse.security;

import com.javacourse.user.User;
import com.javacourse.user.role.Role;
import com.javacourse.utils.PathPageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebFilter(filterName = "admin-security")
public class AuthAdminFilter extends HttpFilter {

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        if (nonNull(session) && nonNull(user)&&(user.getRoleEntity().equals(Role.ADMIN)))
                filterChain.doFilter(request, response);
         else {
            RequestDispatcher dispatcher = ((HttpServletRequest) request).getSession().getServletContext().getRequestDispatcher(PathPageManager.getProperty("page.error404")); // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
        }
    }
}
