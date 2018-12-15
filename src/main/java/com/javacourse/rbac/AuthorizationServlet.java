package com.javacourse.rbac;



import com.javacourse.rbac.command.ActionCommand;
import com.javacourse.rbac.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login/*")
public class AuthorizationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, java.io.IOException {
        processRequest(request, response);
    }

    /**
     * This processRequest method is invoked from both
     * the servlet doGet and doPost methods
     **/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resultPage = null;
        try {
            CommandFactory commandFactory = new CommandFactory(request);
            ActionCommand command = commandFactory.getCommand();
            resultPage = command.execute(request, response);
        } catch (Exception e) {
            //todo loging
        }
        if(resultPage==null){
            resultPage = "/login.jsp";
        }
        dispatch(request, response, resultPage);
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws javax.servlet.ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
