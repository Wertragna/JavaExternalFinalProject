package com.javacourse.user.applicant.status;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.exception.UnsupportedDaoOperationException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StatusDAOSql implements StatusDAO {
    Connection connection;
    private final static Logger logger = Logger.getLogger(StatusDAOSql.class);

    public StatusDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Status> getAll() throws UnsuccessfulDAOException {
        throw new UnsupportedDaoOperationException();
    }

    @Override
    public boolean update(Status entity) throws UnsuccessfulDAOException {
        throw new UnsupportedDaoOperationException();
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        throw new UnsupportedDaoOperationException();
    }

    @Override
    public boolean create(Status entity) throws UnsuccessfulDAOException {
        throw new UnsupportedDaoOperationException();
    }

    @Override
    public Status getById(Integer integer) throws UnsuccessfulDAOException {
        Status status = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from status where id=?")) {
            statement.setInt(1, integer);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = createStatus(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return status;
    }

    @Override
    public Status getByName(String name) throws UnsuccessfulDAOException {
        Status status = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from status where name=?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                status = createStatus(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return status;
    }

    private Status createStatus(ResultSet rs) throws SQLException {
        Status status = new Status();
        status.setId(rs.getInt("id"));
        status.setName(rs.getString("name"));
        return status;
    }
}
