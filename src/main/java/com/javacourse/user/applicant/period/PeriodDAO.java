package com.javacourse.user.applicant.period;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;

import java.util.List;
/**
 * Basic interface used for implementing FactoryDAO for switching easily
 */
public interface PeriodDAO extends AbstractDAO<Integer,Period> {
    List<Period> getAvailablePeriodWithStateForUserIdOrStateId(int userId, int stateIdd) throws UnsuccessfulDAOException;
}
