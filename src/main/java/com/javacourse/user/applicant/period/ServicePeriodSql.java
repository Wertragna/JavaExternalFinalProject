package com.javacourse.user.applicant.period;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.user.applicant.period.state.State;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ServicePeriodSql<K>  extends AbstractServiceSql<K,Period> implements ServicePeriod <K>  {
    private static final Logger logger = Logger.getLogger(ServicePeriodSql.class);
    FactoryDAO factoryDAO;

    public ServicePeriodSql() {
        super(PeriodDAOSql.class);
        factoryDAO= new FactoryDAOSql();
    }

    @Override
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

    //todo implement
    @Override
    public boolean checkPeriodsChoiceSubjects() throws UnsuccessfulDAOException {
        return false;
    }

    //todo implement
    @Override
    public List<Period> selectPeriodsChoiceSubject() throws UnsuccessfulDAOException {
        return null;
    }
}
