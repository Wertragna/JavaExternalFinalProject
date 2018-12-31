package com.javacourse.shared.dao;

import com.javacourse.shared.service.SQLConnection;
import com.javacourse.subject.SubjectDAO;
import com.javacourse.subject.SubjectDAOSql;
import com.javacourse.user.UserDAO;
import com.javacourse.user.UserDAOSql;
import com.javacourse.user.applicant.ApplicantDAO;
import com.javacourse.user.applicant.ApplicantDAOSql;
import com.javacourse.user.applicant.period.PeriodDAO;
import com.javacourse.user.applicant.period.PeriodDAOSql;
import com.javacourse.user.applicant.period.state.StateDAO;
import com.javacourse.user.applicant.period.state.StateDAOSql;
import com.javacourse.user.role.RoleDAO;
import com.javacourse.user.role.RoleDAOSql;

import java.sql.Connection;

public class FactoryDAOSql implements FactoryDAO {

    @Override
    public UserDAO createUserDAO(Connection connection) {
        return new UserDAOSql(connection);
    }

    @Override
    public RoleDAO createUserRoleDAO(Connection connection) {
        return new RoleDAOSql(connection);
    }

    @Override
    public SubjectDAO createSubjectDAO(Connection connection) {
        return new SubjectDAOSql(connection);
    }

    @Override
    public ApplicantDAO createApplicantDAO(Connection connection) {
        return new ApplicantDAOSql(connection);
    }

    @Override
    public PeriodDAO createPeriodDAO(Connection connection) {
        return new PeriodDAOSql(connection);
    }

    @Override
    public StateDAO createStateDAO(Connection connection) {
        return new StateDAOSql(connection);
    }

    @Override
    public Connection createConnection() {
        return new SQLConnection().getConnection();
    }
}
