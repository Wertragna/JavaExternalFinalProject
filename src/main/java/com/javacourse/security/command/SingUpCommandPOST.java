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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SingUpCommandPOST implements ActionCommand {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Page page = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String surname = request.getParameter("surname");
        String firstname = request.getParameter("firstname");
        User user = new User();
        user.setRoleEntity(Role.USER);
        user.setRole(Role.USER.getId());
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setEmail(login);
        user.setSurname(surname);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        System.out.println(user);
        //Show errors
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<User> violation : constraintViolations) {
                System.out.println(violation.getPropertyPath() + violation.getMessage() + "m");
            }
        } else {
            System.out.println("Valid Object");


            UserService<Integer> userService = new UserServiceSql();//
            try {
                if (userService.create(user)) {
                    page = new Page(request.getContextPath() + "/applicant", true);
                }
            } catch (UnsuccessfulDAOException e) {
                //todo add message
                page = new Page(request.getContextPath() + "/login/sign-up", true);
            }
        }

        return page;
    }


}
