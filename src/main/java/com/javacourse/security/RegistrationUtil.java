package com.javacourse.security;

import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
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
        if (!new ValidationManager(request).isValidate(user)) {
            request.setAttribute("error", new ValidationManager(request).getFirsErrorMessage(user));
            return new Page(PathPageManager.getProperty("page.sign-up")).setDispatchType(Page.DispatchType.FORWARD);
        } else {
            if (service.create(user)) {
                return new Page ("/applicant").setDispatchType(Page.DispatchType.REDIRECT);
            }
            else {
                request.setAttribute("error", "msg.error");
                return new Page(PathPageManager.getProperty("page.sign-up")).setDispatchType(Page.DispatchType.FORWARD);
            }
        }
    }


}
