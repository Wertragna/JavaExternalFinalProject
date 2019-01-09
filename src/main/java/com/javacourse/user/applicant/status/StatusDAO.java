package com.javacourse.user.applicant.status;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;

public interface StatusDAO extends AbstractDAO <Integer, Status> {
    Status getByName(String name) throws UnsuccessfulDAOException;
}
