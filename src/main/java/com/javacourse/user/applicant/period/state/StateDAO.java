package com.javacourse.user.applicant.period.state;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
/**
 * Basic interface used for implementing FactoryDAO for switching easily
 */
public interface StateDAO extends AbstractDAO<Integer,State> {
    State getByName(String name) throws UnsuccessfulDAOException;
    State getByPeriodId(int id) throws UnsuccessfulDAOException;
}
