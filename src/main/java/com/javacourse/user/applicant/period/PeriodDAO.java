package com.javacourse.user.applicant.period;

import com.javacourse.user.applicant.period.state.State;
import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.utils.DataBaseConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodDAO extends AbstractDAO<Integer, Period> {

    @Override
    public List<Period> getAll() throws UnsuccessfulDAOException {
        List<Period> periods = new ArrayList<>();
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement = con.prepareStatement("select period.id, period.name, state.name from period inner  join state  on period.state = state.id;")){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                periods.add(createPeriod(resultSet));
            }
        } catch (SQLException e) {
            // todo loging
            throw  new UnsuccessfulDAOException();
        }
        return periods;
    }

    private Period createPeriod(ResultSet resultSet) throws SQLException {
        Period period = new Period();
        period.setId(resultSet.getInt("period.id"));
        period.setName(resultSet.getString("period.name"));
        period.setState(State.valueOf( resultSet.getString("state.name").toUpperCase()));
        return period;
    }

    @Override
    public boolean update(Period v) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(Period period) throws UnsuccessfulDAOException {
        int changeNumber = 0;
        try (Connection con = DataBaseConnectionPool.getConnection();
             PreparedStatement statement =
                     con.prepareStatement
                             ("INSERT INTO period(name,state) VALUE (?,?)")) {
            statement.setString(1, period.getName());
            statement.setInt(2, period.getState().getId());
            changeNumber = statement.executeUpdate();
        } catch (SQLException e) {
            // todo logging
            throw new UnsuccessfulDAOException();
        }
        return changeNumber > 0;
    }

    @Override
    public Period getById(Integer integer) throws UnsuccessfulDAOException {
        return null;
    }

    public boolean checkAllPeriodIsEnded() throws UnsuccessfulDAOException {
        List<Period> periods = getAll();
        for (Period p :periods) {
            if(!p.getState().equals(State.ENDED))
                return false;
        }
        return true;
    }

    public boolean checkPeriodsChoiceSubjects() throws UnsuccessfulDAOException {
        List<Period> periods = getAll();
        for (Period p :periods) {
            if(!p.getState().equals(State.CHOICE_SUBJECTS))
                return false;
        }
        return true;
    }

    public List<Period> selectPeriodsChoiceSubject() throws UnsuccessfulDAOException {
        List<Period> periods = getAll();
        periods.removeIf(period -> !period.getState().equals(State.CHOICE_SUBJECTS));
        return periods;
    }

}
