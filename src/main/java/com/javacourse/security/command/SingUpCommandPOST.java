package com.javacourse.security.command;

import com.javacourse.security.RegistrationUtil;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
import com.javacourse.user.role.Role;

import javax.servlet.Registration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SingUpCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new RegistrationUtil(request).registration(createUsingByRequest(request));
    }

    User createUsingByRequest( HttpServletRequest  request){
        User user = new User();
        user.setRoleEntity(Role.USER);
        user.setRole(2);
        user.setPassword(request.getParameter("password"));
        user.setFirstname( request.getParameter("firstname"));
        user.setEmail(request.getParameter("login"));
        user.setSurname(request.getParameter("surname"));
        return user;
    }
}
