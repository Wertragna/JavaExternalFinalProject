package com.javacourse.shared.web;


import com.javacourse.security.command.LogOutCommand;
import com.javacourse.security.command.SignUpCommand;
import com.javacourse.security.command.SingInCommandPOST;
import com.javacourse.security.command.SingUpCommandPOST;
import com.javacourse.shared.annotations.Action;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.subject.command.ChoiceSubjectCommand;
import com.javacourse.subject.command.ChoiceSubjectCommandPOST;
import com.javacourse.subject.command.SelectSubjectMark;
import com.javacourse.user.applicant.command.*;
import com.javacourse.user.applicant.period.command.PeriodEditCommand;
import com.javacourse.user.applicant.period.command.PeriodEditCommandPOST;
import com.javacourse.user.applicant.period.command.PeriodInfoCommand;
import com.javacourse.user.applicant.period.command.ShowPeriodsCommand;
import com.javacourse.user.command.AdminHomeCommand;
import com.javacourse.user.command.CreateNewPeriodCommand;
import com.javacourse.user.command.CreateNewPeriodCommandGet;

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

    @Action(url = "/login/sign-in", method = "POST")
    SIGN_IN {
        {
            this.command = new SingInCommandPOST();
        }
    },

    @Action(url = "/login/sign-in", method = "GET")
    SIGN_IN_GET {
        {
            this.command = new SingInCommandPOST();
        }
    },

    @Action(url = "/login/sign-up", method = "GET")
    SIGN_UP_GET {
        {
            this.command = new SignUpCommand();
        }
    },
    @Action(url = "/login/sign-up", method = "POST")
    SIGN_UP_POST {
        {
            this.command = new SingUpCommandPOST();
        }
    },
    @Action(url = "/login/logout", method = "GET")
    LOG_OUT {
        {
            this.command = new LogOutCommand();
        }
    },
    @Action(url = "/applicant", method = "GET")
    APPLICANT_HOME {
        {
            this.command = new ApplicantHomeCommand();
        }
    },
    @Action(url = "/admin", method = "GET")
    ADMIN_HOME {
        {
            this.command = new AdminHomeCommand();
        }
    },
    @Action(url = "/period", method = "GET")
    PERIOD {
        {
            this.command = new PeriodCommand();
        }
    },
    @Action(url = "/period", method = "POST")
    PERIOD_POST {
        {
            this.command = new PeriodCommandPOST();
        }
    },
    @Action(url = "/applicant/choose-subjects", method = "GET")
    CHOICE {
        {
            this.command = new ChoiceSubjectCommand();
        }
    },
    @Action(url = "/applicant/choose-subjects", method = "POST")
    CHOICE_POST {
        {
            this.command = new ChoiceSubjectCommandPOST();
        }
    },
    @Action(url = "/admin/periods", method = "GET")
    PERIODS {
        {
            this.command = new ShowPeriodsCommand();
        }
    },
    @Action(url = "/admin/period-info", method = "GET")
    PERIOD_INFO {
        {
            this.command = new PeriodInfoCommand();
        }
    },
    @Action(url = "/admin/period-mark", method = "GET")
    PERIOD_MARK {
        {
            this.command = new SelectSubjectMark();
        }
    },
    @Action(url = "/admin/period-edit", method = "GET")
    PERIOD_EDIT {
        {
            this.command = new PeriodEditCommand();
        }
    },
    @Action(url = "/admin/period-edit", method = "POST")
    PERIOD_EDIT_POST {
        {
            this.command = new PeriodEditCommandPOST();
        }
    },
    @Action(url = "/applicant/info", method = "GET")
    APPLICATION_INFO {
        {
            this.command = new ApplicantInfoCommand();
        }
    },
    @Action(url = "/admin/period-subject-marks", method = "GET")
    PERIOD_SUBJECT_MARKS {
        {
            this.command = new PeriodSubjectMarks();
        }
    },
    @Action(url = "/admin/period-subject-marks", method = "POST")
    PERIOD_SUBJECT_MARKS_POST {
        {
            this.command = new PeriodSubjectMarksPOST();
        }
    };


    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
