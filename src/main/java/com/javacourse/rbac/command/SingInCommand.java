package com.javacourse.rbac.command;


import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.ActionCommand;
import com.javacourse.user.User;
import com.javacourse.user.UserDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingInCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();
        User user=null;
        try {
            user = userDAO.findByLoginAndPassword(login,password);
        } catch (UnsuccessfulDAOException e) {
            //todo loging
        }
        if (user!=null) {
            request.getSession().setAttribute("user", user);
            //todo change page
            page = "/index.jsp";
        } else {
          //todo show message (incorrect password or login)
            page = "/login.jsp";
        }
        return page;
    }
}
