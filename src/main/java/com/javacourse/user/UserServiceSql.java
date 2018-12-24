package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.SQLConnection;
import com.javacourse.utils.DataBaseConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class UserServiceSql extends AbstractServiceSql<Integer, User> implements UserService<Integer> {
    private static final Logger logger = Logger.getLogger(UserServiceSql.class);
    FactoryDAO factoryDAO;
    public UserServiceSql() {
        super(UserDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

    @Override
    public User findByLoginAndPassword(String login, String password) throws UnsuccessfulDAOException {
        User user = null;
        try (Connection connection = factoryDAO.createConnection()){
            UserDAO<Integer> userDAO = factoryDAO.createUserDAO(connection);
            user = userDAO.findByLoginAndPassword(login, password);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return user;
    }
}
