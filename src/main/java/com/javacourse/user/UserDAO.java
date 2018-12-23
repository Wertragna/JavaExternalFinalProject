package com.javacourse.user;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.user.role.RoleDAO;
import com.javacourse.utils.DataBaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
//todo write javadoc

public class UserDAO extends AbstractDAO<Integer, User> {
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
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("INSERT INTO user(firstname, surname, email, password,role) VALUE (?,?,?,?,?)")) {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setInt(5, user.getRole().getId());
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }

    @Override
    public User getById(Integer integer) throws UnsuccessfulDAOException {
        User user = null;
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("select * from user where id=?")) {
            statement.setInt(1, integer);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = createUser(rs);
            }
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return user;
    }

    public User findByLoginAndPassword(String login, String password) throws UnsuccessfulDAOException {
        User user = null;
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("select * from user where email=? and password=?")) {
            statement.setString(1, login);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = createUser(rs);
            }
        } catch (SQLException e) {
            // todo logging
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
        user.setRole(new RoleDAO().getById(rs.getInt("role")));
        return user;
    }
}
