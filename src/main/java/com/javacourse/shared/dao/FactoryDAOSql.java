package com.javacourse.shared.dao;

import com.javacourse.shared.service.SQLConnection;
import com.javacourse.subject.SubjectDAO;
import com.javacourse.subject.SubjectDAOSql;
import com.javacourse.user.UserDAO;
import com.javacourse.user.UserDAOSql;
import com.javacourse.user.applicant.ApplicantDAO;
import com.javacourse.user.applicant.ApplicantDAOSql;
import com.javacourse.user.role.RoleDAO;
import com.javacourse.user.role.RoleDAOSql;
import com.javacourse.utils.DataBaseConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

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
    public Connection createConnection() {
        return new SQLConnection().getConnection();
    }
}
