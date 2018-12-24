package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.Service;

public interface UserService <K> extends Service<K, User> {
    User findByLoginAndPassword(String login, String password) throws UnsuccessfulDAOException;
}
