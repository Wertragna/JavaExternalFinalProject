package com.javacourse.security.command;


import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.service.ServiceLoader;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
import com.javacourse.utils.MessagesManager;
import com.javacourse.utils.PathPageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingInCommandPOST implements ActionCommand {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return executeWithServiceLoader(request,response,new ServiceLoader());
    }
    Page executeWithServiceLoader(HttpServletRequest request, HttpServletResponse response, ServiceLoader serviceLoader){
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = serviceLoader.userService().findByLoginAndPassword(login, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return new Page(Page.WebPath.HOME.getPath()).setDispatchType(Page.DispatchType.REDIRECT);
        } else {
            setErrorMessages(request);
            return new Page(PathPageManager.getProperty("page.sign-in")).setDispatchType(Page.DispatchType.FORWARD);
        }
    }

    void setErrorMessages(HttpServletRequest request) {
        request.setAttribute("error",  true);
    }
}
