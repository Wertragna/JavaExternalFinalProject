package com.javacourse.rbac.command;



import javax.servlet.http.HttpServletRequest;

public class CommandFactory {
    private  HttpServletRequest request;

    public CommandFactory(HttpServletRequest request) {
        this.request = request;
    }

    public ActionCommand getCommand() {
        ActionCommand current = null;
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) { // если команда не задана в текущем запросе
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();

        } catch (IllegalArgumentException e) {
            //todo
        }
        return current;

    }
}
