package com.javacourse.shared.dao;

import com.javacourse.user.UserDAO;

import java.sql.Connection;

public interface FactoryDAO {
    UserDAO createUserDAO(Connection connection);
    //todo add othe
}
