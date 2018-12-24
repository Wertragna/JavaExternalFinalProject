package com.javacourse.shared.service;

import java.util.List;

public interface Service<K, E> {
    List<E> getAll();

    boolean update(E entity);

    boolean delete(K key);

    boolean create(E entity);

    E getById(K key);
}
