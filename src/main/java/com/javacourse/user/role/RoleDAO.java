package com.javacourse.user.role;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
/**
 * Basic interface used for implementing FactoryDAO for switching easily
 */
public interface RoleDAO  extends AbstractDAO<Integer, Role> {
     int getByName(String name) throws UnsuccessfulDAOException;
}
