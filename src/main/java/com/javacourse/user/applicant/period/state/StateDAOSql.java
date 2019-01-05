package com.javacourse.user.applicant.period.state;

import com.javacourse.exception.UnsuccessfulDAOException;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class StateDAOSql implements StateDAO<Integer> {
    private static final Logger logger = Logger.getLogger(StateDAOSql.class);
    Connection connection;

    public StateDAOSql(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<State> getAll() throws UnsuccessfulDAOException {
        return null;
    }

    @Override
    public boolean update(State entity) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(State entity) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public State getById(Integer integer) throws UnsuccessfulDAOException {
        State state = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from state where id=?")) {
            statement.setInt(1, integer);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                state = createState(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return state;
    }
    @Override
    public State getByName(String name) throws UnsuccessfulDAOException {
        State state = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from state where name=?")) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                state = createState(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return state;
    }

    private State createState(ResultSet rs) throws SQLException {
        State state = new State();
        state.setId(rs.getInt("id"));
        state.setName(rs.getString("name"));
        return state;
    }

    @Override
    public State getByPeriodId(int id) throws UnsuccessfulDAOException {
        State state = null;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "select * from state inner join period on state.id = period.state where period.id= ?")) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                state = createState(rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new UnsuccessfulDAOException();
        }
        return state;
    }
}
