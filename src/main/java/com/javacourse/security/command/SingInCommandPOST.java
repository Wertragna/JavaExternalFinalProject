package com.javacourse.security.command;


import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.ActionCommand;
import com.javacourse.shared.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserDAO;
import com.javacourse.user.role.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingInCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
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
            if(user.getRole().equals(Role.ADMIN))
                page=  new Page( request.getContextPath()+"/admin", true);
            else
                page= new Page(request.getContextPath()+"/applicant",true);
        } else {
          //todo show message (incorrect password or login)
            page =new Page( "/login.jsp",false);
        }
        return page;
    }
}