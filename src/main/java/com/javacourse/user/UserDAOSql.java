package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.user.role.RoleDAOSql;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//todo write javadoc

public class UserDAOSql implements UserDAO <Integer> {
    private final static Logger logger = Logger.getLogger(UserDAOSql.class);
    Connection connection;

    public UserDAOSql(Connection connection) {
        this.connection = connection;
    }

    //todo implement
    @Override
    public List<User> getAll() throws UnsuccessfulDAOException {
        return null;
    }

    //todo implement
    @Override
    public boolean update(User v) throws UnsuccessfulDAOException {
        return false;
    }

    //todo implement
    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    //todo add hash for password
    @Override
    public boolean create(User user) throws UnsuccessfulDAOException {

        int changeNumber = 0;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "INSERT INTO user(firstname, surname, email, password,role) " +
                                     "VALUE (?,?,?,?,?)")) {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRole().getId());
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }

    @Override
    public User getById(Integer integer) throws UnsuccessfulDAOException {
        User user = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from user where id=?")) {
            statement.setInt(1, integer);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = createUser(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return user;
    }
    @Override
    public User findByLoginAndPassword(String login, String password) throws UnsuccessfulDAOException {
        User user = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from user where email=? and password=?")) {
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = createUser(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return user;
    }

    private User createUser(ResultSet rs) throws SQLException, UnsuccessfulDAOException {
        User user;
        user = new User();
        user.setEmail(rs.getString("email"));
        user.setFirstname(rs.getString("firstname"));
        user.setId(rs.getInt("id"));
        user.setPassword(rs.getString("password"));
        user.setRole(new RoleDAOSql().getById(rs.getInt("role")));
        return user;
    }
}
