package com.javacourse.user.applicant.period;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;
import com.javacourse.user.applicant.period.state.State;
import com.javacourse.user.applicant.period.state.StateDAO;
import com.javacourse.user.applicant.period.state.StateName;
import com.sun.corba.se.spi.orbutil.fsm.StateEngine;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PeriodServiceSql extends AbstractServiceSql<Integer, Period> implements Service<Integer,Period> {
    private static final Logger logger = Logger.getLogger(PeriodServiceSql.class);
    FactoryDAO factoryDAO;

    public PeriodServiceSql() {
        super(PeriodDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }


    public boolean checkAllPeriodIsEnded() throws UnsuccessfulDAOException {
        /*List<Period> periods = null;
        try (Connection connection = factoryDAO.createConnection()){
            PeriodDAO periodDAO = factoryDAO.createPeriodDAO(connection);
            periods = periodDAO.getAll();
            for (Period p :periods) {
                if(!p.getState().equals(State.ENDED))
                    return false;
            }
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }*/
        return false;
    }

    public List<Period> getAvailablePeriodsByUserId(int userID){
        List<Period> periods = null;
        try(Connection connection = factoryDAO.createConnection()){
            PeriodDAO periodDAO=  factoryDAO.createPeriodDAO(connection);
            periods= periodDAO.getAvailablePeriodWithStateForUserIdOrStateId(userID, 1);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return periods;
    }



    public Period getByIdWithState(int id) {
        Period period = null;
        try (Connection connection = factoryDAO.createConnection()) {
            PeriodDAO periodDAO = factoryDAO.createPeriodDAO(connection);
            StateDAO<Integer> stateDAO = factoryDAO.createStateDAO(connection);
            period = periodDAO.getById(id);
            State state = stateDAO.getById(period.getState());
            period.setStateEntity(state);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e);
        }
        return period;
    }


    public boolean setNextState(Period period) {
        try (Connection connection = factoryDAO.createConnection()) {
            PeriodDAO periodDAO = factoryDAO.createPeriodDAO(connection);
            StateDAO<Integer> stateDAO = factoryDAO.createStateDAO(connection);
            State currentState = stateDAO.getById(period.getState());
            StateName stateName= StateName.valueOf(currentState.getName().toUpperCase());
            stateName = stateName.getNext();
            currentState = stateDAO.getByName(stateName.name().toLowerCase());
            period.setState(currentState.getId());
            return periodDAO.update(period);
        } catch (
                UnsuccessfulDAOException | SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }
}
