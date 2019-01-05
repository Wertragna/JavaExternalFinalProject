package com.javacourse.user.applicant.period.state;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.speciality.SpecialityDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class StateServiceSql extends AbstractServiceSql<Integer, State> implements StateService<Integer> {
    private final Logger logger = Logger.getLogger(StateServiceSql.class);
    FactoryDAO factoryDAO;

    public StateServiceSql() {
        super(StateDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

    @Override
    public StateName getByPeriodId(int id) {
        StateName stateName = null;
        try (Connection connection = factoryDAO.createConnection()) {
            StateDAO<Integer> stateDAO = factoryDAO.createStateDAO(connection);
            State state = stateDAO.getByPeriodId(id);
            stateName= StateName.valueOf(state.getName().toUpperCase());
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return stateName;
    }


}
