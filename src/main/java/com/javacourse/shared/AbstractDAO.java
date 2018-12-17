package com.javacourse.shared;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.utils.DataBaseConnectionPool;

import java.util.List;

/**
 *
 * @param <K> key of the database table
 * @param <E> entity of model
 */
public abstract class AbstractDAO<K, E> {

    public abstract List<E> getAll()throws UnsuccessfulDAOException;

    public abstract boolean update(E v)throws UnsuccessfulDAOException;

    public abstract boolean delete(K k)throws UnsuccessfulDAOException;

    public abstract boolean create(E v) throws UnsuccessfulDAOException;

    public abstract E getById(K k)throws UnsuccessfulDAOException;



}
