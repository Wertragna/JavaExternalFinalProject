package com.javacourse.user.role;

import com.javacourse.exception.UnsuccessfulDAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//todo write javadoc
public class RoleDAOSql implements RoleDAO<Integer> {
    private static final Logger logger = Logger.getLogger(RoleDAOSql.class);
    Connection connection;

    public RoleDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Role> getAll() throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public boolean update(Role entity) throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public boolean create(Role entity) throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public Role getById(Integer integer) throws UnsuccessfulDAOException {
        Role role = null;
        try (PreparedStatement statement = connection.prepareStatement("select * from role where id=?")) {
            statement.setInt(1, integer);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                role = createRole(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return role;
    }

    private Role createRole(ResultSet rs) throws SQLException {
        if (rs.getString("name").toUpperCase().equals(Role.ADMIN.name())) {
            System.out.println(Role.ADMIN);
            return Role.ADMIN;
        } else
            return Role.USER;

    }
}
