package com.javacourse.shared.service;

import com.javacourse.shared.dao.AbstractDAO;

import java.util.List;

public class AbstractService<K, E> implements Service<K,E > {
    private AbstractDAO<K, E> abstractDAO;
    public AbstractService(AbstractDAO<K, E> abstractDAO) {
        this.abstractDAO = abstractDAO;
    }

    @Override
    public List<E> getAll() {
        return null;
    }

    @Override
    public boolean update(E entity) {
        return false;
    }

    @Override
    public boolean delete(K k) {
        return false;
    }

    @Override
    public boolean create(E entity) {
        return false;
    }

    @Override
    public E getById(K k) {
        return null;
    }
}
