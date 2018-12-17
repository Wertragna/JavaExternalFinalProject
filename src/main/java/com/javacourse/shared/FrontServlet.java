package com.javacourse.shared;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "admin", urlPatterns = {"/login/*","/admin/*","/applicant/*"} )
public class FrontServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String page = new CreateNewPeriod(new DoNothing(null)).getPage();
        //
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

        Page resultPage = null;
        CommandFactory commandFactory = new CommandFactory(request);
        ActionCommand command = commandFactory.getCommand();

        resultPage = command.execute(request, response);
        if (resultPage == null) {
            //todo add error page
            resultPage = new Page( "/index.jsp", false);
            dispatch(request, response, resultPage.getName());
        } else if (resultPage.isRedirect())
            response.sendRedirect(resultPage.getName());
        else
            dispatch(request, response, resultPage.getName());
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws javax.servlet.ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
