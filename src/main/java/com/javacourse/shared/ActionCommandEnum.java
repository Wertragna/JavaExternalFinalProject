package com.javacourse.shared;


import com.javacourse.admindashboard.command.AdminHomeCommand;
import com.javacourse.admindashboard.command.CreateNewPeriodCommand;
import com.javacourse.admindashboard.command.CreateNewPeriodCommandGet;
import com.javacourse.applicant.command.ApplicantHomeCommand;
import com.javacourse.security.command.LogOutCommand;
import com.javacourse.security.command.SignUpCommand;
import com.javacourse.security.command.SingInCommandPOST;
import com.javacourse.security.command.SingUpCommandPOST;

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
            this.command = new SingInCommandPOST();
        }
    },

    @Action(url = "/login",method = "GET")
    SIGN_IN_GET{
        {
            this.command = new SingInCommandPOST();
        }
    },

    @Action(url = "/login/register",method = "GET")
    SIGN_UP_GET{
        {
            this.command = new SignUpCommand();
        }
    },
    @Action(url = "/login/register",method = "POST")
    SIGN_UP_POST{
        {
            this.command = new SingUpCommandPOST();
        }
    },

    @Action(url = "/login/logout", method = "GET")
    LOG_OUT{
        {
            this.command = new LogOutCommand();
        }
    },
    @Action(url = "/applicant", method = "GET")
    APPLICANT_HOME{
        {
            this.command = new ApplicantHomeCommand();
        }
    },
    @Action(url = "/admin", method = "GET")
    ADMIN_HOME{
        {
            this.command = new AdminHomeCommand();
        }
    };


    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
