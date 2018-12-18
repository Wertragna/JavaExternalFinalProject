package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.AbstractDAO;

import java.util.List;

public class SubjectDAO extends AbstractDAO<Integer,Subject> {
    @Override
    public List<Subject> getAll() throws UnsuccessfulDAOException {
        return null;
    }

    @Override
    public boolean update(Subject v) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public boolean create(Subject v) throws UnsuccessfulDAOException {
        return false;
    }

    @Override
    public Subject getById(Integer integer) throws UnsuccessfulDAOException {
        return null;
    }
}
