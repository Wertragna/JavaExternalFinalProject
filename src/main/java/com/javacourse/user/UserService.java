package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class UserService extends AbstractServiceSql<Integer, User> implements Service<Integer,User> {
    private static final Logger logger = Logger.getLogger(UserService.class);
    FactoryDAO factoryDAO;
    public UserService() {
        super(UserDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = null;
        try (Connection connection = factoryDAO.createConnection()){
            UserDAO<Integer> userDAO = factoryDAO.createUserDAO(connection);
            user = userDAO.findByLoginAndPassword(login, password);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return user;
    }
}
