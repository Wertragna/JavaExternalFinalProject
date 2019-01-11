package com.javacourse.security.command;

import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
import com.javacourse.user.role.Role;

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
        Page page = null;
       User user = createUsingByRequest(request);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        if(constraintViolations.iterator().hasNext())
            System.out.println(constraintViolations.iterator().next().getMessage());
       /* if (constraintViolations.size()>0) {
            for (ConstraintViolation<User> violation : constraintViolations) {
                System.out.println(violation.getPropertyPath() + violation.getMessage() + "m");
            }
        } */
        else {
            System.out.println("Valid Object");
            UserService userService = new UserService();
            if (userService.create(user)) {
                page = new Page ("/applicant").setDispatchType(Page.DispatchType.REDIRECT);
            }
        }
        return page;
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
