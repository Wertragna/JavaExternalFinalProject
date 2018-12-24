package com.javacourse.shared.service;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.utils.DataBaseConnectionPool;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbstractServiceSql<K, E> implements Service<K, E> {
    private Class<? extends AbstractDAO> abstractDaoClass;

    public AbstractServiceSql(Class<? extends AbstractDAO> abstractDaoClass) {
        this.abstractDaoClass = abstractDaoClass;
    }

    @Override
    public List<E> getAll() {
        List<E> entities = new ArrayList<>();
        AbstractDAO abstractDAO = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            entities = abstractDAO.getAll();
        } catch (InstantiationException |
                UnsuccessfulDAOException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                SQLException e) {
            //todo
        }
        return entities;
    }

    @Override
    public boolean update(E entity) {
        AbstractDAO abstractDAO = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            return abstractDAO.update(entity);
        } catch (InstantiationException |
                UnsuccessfulDAOException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                SQLException e) {
            //todo
        }
        return false;
    }

    @Override
    public boolean delete(K key) {
        AbstractDAO abstractDAO = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            return abstractDAO.delete(key);
        } catch (InstantiationException |
                UnsuccessfulDAOException |
                InvocationTargetException |
                NoSuchMethodException |
                SQLException |
                IllegalAccessException e) {
            //todo
        }
        return false;
    }

    @Override
    public boolean create(E entity) {
        AbstractDAO abstractDAO = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            return abstractDAO.create(entity);
        } catch (InstantiationException |
                UnsuccessfulDAOException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                SQLException e) {
            //todo
        }
        return false;
    }

    @Override
    public E getById(K key) {
        AbstractDAO abstractDAO = null;
        E entity = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            entity = (E) abstractDAO.getById(key);
        } catch (InstantiationException |
                UnsuccessfulDAOException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                SQLException e) {
            //todo
        }
        return entity;
    }
}
