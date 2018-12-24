package com.javacourse.shared.dao;

import com.javacourse.subject.SubjectDAO;
import com.javacourse.user.UserDAO;
import com.javacourse.user.role.RoleDAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface FactoryDAO {
    UserDAO createUserDAO(Connection connection);
    RoleDAO createUserRoleDAO(Connection connection);
    SubjectDAO createSubjectDAO(Connection connection);
    Connection createConnection();
}
