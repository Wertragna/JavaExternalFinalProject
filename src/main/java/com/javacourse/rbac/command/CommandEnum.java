package com.javacourse.rbac.command;

public enum CommandEnum {
    SIGN_IN{
        {
            this.command = new SingInCommand();
        }
    },
    LOG_OUT{
        {
            this.command = new LogOutCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
