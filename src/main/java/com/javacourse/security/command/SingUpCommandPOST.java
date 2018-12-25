package com.javacourse.security.command;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
import com.javacourse.user.UserServiceSql;
import com.javacourse.user.role.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingUpCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String surname =request.getParameter("surname");
        String firstname = request.getParameter("firstname");
        User user = new User();
        user.setRole(Role.USER);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setEmail(login);
        user.setSurname(surname);
//todo add validate input data

        UserService<Integer> userService =new UserServiceSql();//
         try {
           if( userService.create(user)){
               page = new Page(request.getContextPath()+"/applicant",true);
           }
        } catch (UnsuccessfulDAOException e) {
             page =  new Page(request.getContextPath()+"/login/register",true);
        }

        return page;
    }
}
