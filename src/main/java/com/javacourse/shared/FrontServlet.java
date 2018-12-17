package com.javacourse.shared;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin", urlPatterns = "/")
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

        String resultPage = null;
        CommandFactory commandFactory = new CommandFactory(request);
        ActionCommand command = commandFactory.getCommand();

        resultPage = command.execute(request, response);
        if (resultPage == null) {
            //todo add error page
            resultPage = "/index.jsp";
            dispatch(request, response, resultPage);
        } else if (command.getClass().isAnnotationPresent(Redirect.class))
            response.sendRedirect(resultPage);
        else
            dispatch(request, response, resultPage);
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws javax.servlet.ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
