package com.javacourse.shared.service;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.utils.DataBaseConnectionPool;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbstractServiceSql<K, E> implements Service<K, E> {
    private static Logger logger = Logger.getLogger(AbstractServiceSql.class);
    private Class<? extends AbstractDAO> abstractDaoClass;

    public AbstractServiceSql(Class<? extends AbstractDAO> clazz) {
        this.abstractDaoClass = clazz;
    }

    @Override
    public List<E> getAll() {
        List<E> entities = new ArrayList<>();
        AbstractDAO abstractDAO = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            entities = abstractDAO.getAll();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SQLException | UnsuccessfulDAOException e) {
           logger.error(e.getMessage());
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
            logger.error(e.getMessage());
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
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean create(E entity) throws UnsuccessfulDAOException {
        AbstractDAO abstractDAO = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            return abstractDAO.create(entity);
        } catch (InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                NoSuchMethodException |
                SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public E getById(K key) throws UnsuccessfulDAOException {
        AbstractDAO abstractDAO = null;
        E entity = null;
        try (Connection connection = DataBaseConnectionPool.getConnection()) {
            abstractDAO = abstractDaoClass.getDeclaredConstructor(Connection.class).newInstance(connection);
            entity = (E) abstractDAO.getById(key);
        } catch (InstantiationException
                | IllegalAccessException
                | InvocationTargetException
                | NoSuchMethodException
                | SQLException e) {
            logger.error(e.getMessage());
        }
        return entity;
    }
}
