package com.javacourse.user.role;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.utils.DataBaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//todo write javadoc
public class RoleDAOSql implements AbstractDAO<Integer,Role> {
    @Override
    public List<Role> getAll() throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public boolean update(Role v) throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public boolean create(Role v) throws UnsuccessfulDAOException {
        throw new UnsuccessfulDAOException();
    }

    @Override
    public Role getById(Integer integer) throws UnsuccessfulDAOException {
        Role role = null;
        try(Connection con= DataBaseConnectionPool.getConnection();
            PreparedStatement statement = con.prepareStatement("select * from role where id=?")) {
            statement.setInt(1, integer);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                role = createRole(rs);
            }
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return role;
    }
    private Role createRole(ResultSet rs) throws SQLException {
        //System.out.println(rs.getString("name").toUpperCase()+" "+Role.ADMIN.name());
        if(rs.getString("name").toUpperCase().equals(Role.ADMIN.name())){
            System.out.println(Role.ADMIN);
            return Role.ADMIN;
        }
        else
            return Role.USER;

    }
}
