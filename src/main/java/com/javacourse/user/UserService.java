package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;

public interface UserService <K>{
    User findByLoginAndPassword(String login, String password) throws UnsuccessfulDAOException;
}
