package com.javacourse.shared.web;


import com.javacourse.shared.annotations.Action;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.user.command.AdminHomeCommand;
import com.javacourse.user.command.CreateNewPeriodCommand;
import com.javacourse.user.command.CreateNewPeriodCommandGet;
import com.javacourse.user.applicant.command.*;
import com.javacourse.security.command.LogOutCommand;
import com.javacourse.security.command.SignUpCommand;
import com.javacourse.security.command.SingInCommandPOST;
import com.javacourse.security.command.SingUpCommandPOST;
import com.javacourse.subject.command.ChoiceSubjectCommand;
import com.javacourse.subject.command.ChoiceSubjectCommandPOST;

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

    @Action(url = "/login/sign-in",method = "POST")
    SIGN_IN{
        {
            this.command = new SingInCommandPOST();
        }
    },

    @Action(url = "/login/sign-in",method = "GET")
    SIGN_IN_GET{
        {
            this.command = new SingInCommandPOST();
        }
    },

    @Action(url = "/login/sign-up",method = "GET")
    SIGN_UP_GET{
        {
            this.command = new SignUpCommand();
        }
    },
    @Action(url = "/login/sign-up",method = "POST")
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
    },

    @Action(url = "/period", method = "GET")
    PERIOD{
        {
            this.command = new PeriodCommand();
        }
    },
    @Action(url = "/period", method = "POST")
    PERIOD_POST{
        {
            this.command = new PeriodCommandPOST();
        }
    },
    @Action(url = "/applicant/choose-subjects", method = "GET")
    CHOICE{
        {
            this.command = new ChoiceSubjectCommand();
        }
    },
    @Action(url = "/applicant/choose-subjects", method = "POST")
    CHOICE_POST{
        {
            this.command = new ChoiceSubjectCommandPOST();
        }
    };


    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
