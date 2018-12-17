package com.javacourse.shared;


import com.javacourse.admindashboard.command.CreateNewPeriodCommand;
import com.javacourse.admindashboard.command.CreateNewPeriodCommandGet;
import com.javacourse.rbac.command.LogOutCommand;
import com.javacourse.rbac.command.SingInCommand;

public enum ActionCommandEnum {
    @Action(url = "/admin/create-new-period", method = "POST")
    CREATE_NEW_PERIOD_POST {
        {
            this.command = new CreateNewPeriodCommand();
        }
    },

    @Action(url = "/admin/create-new-period", method = "GET")
    CREATE_NEW_PERIOD_GET {
        {
            this.command = new CreateNewPeriodCommandGet();
        }
    },

    @Action(url = "/login",method = "POST")
    SIGN_IN{
        {
            this.command = new SingInCommand();
        }
    },

    @Action(url = "/login",method = "GET")
    SIGN_IN_GET{
        {
            this.command = new SingInCommand();
        }
    },

    @Action(url = "/logout", method = "GET")
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
