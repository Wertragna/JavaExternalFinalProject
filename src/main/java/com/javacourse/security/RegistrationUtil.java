package com.javacourse.security;

import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
import com.javacourse.utils.PasswordHashManager;
import com.javacourse.utils.PathPageManager;
import com.javacourse.utils.ValidationManager;

import javax.servlet.http.HttpServletRequest;

public class RegistrationUtil {
    UserService service;
    HttpServletRequest request;

    public RegistrationUtil(HttpServletRequest request) {
        this.request = request;
        service = new UserService();
    }

    public Page registration(User user) {
        if (!ValidationManager.isValidate(user)) {
            request.setAttribute("error",  ValidationManager.getFirsErrorMessage(user));
            request.setAttribute("reg",user);
            user.setPassword(null);
            return new Page(PathPageManager.getProperty("page.sign-up")).setDispatchType(Page.DispatchType.FORWARD);
        } else {
            user.setPassword(PasswordHashManager.hash(user.getEmail(),user.getPassword()));
            if (service.create(user)) {
                return new Page ("/applicant").setDispatchType(Page.DispatchType.REDIRECT);
            }
            else {
                user.setPassword(null);
                request.setAttribute("error", "msg.error");
                request.setAttribute("reg",user);
                return new Page(PathPageManager.getProperty("page.sign-up")).setDispatchType(Page.DispatchType.FORWARD);
            }
        }
    }


}
