package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;

public interface UserDAO <K> extends AbstractDAO<K ,User> {
     User findByLoginAndPassword(String login, String password) throws UnsuccessfulDAOException;
}
