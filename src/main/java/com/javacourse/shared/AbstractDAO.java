package com.javacourse.shared;

import java.util.List;

/**
 *
 * @param <K> key of the database table
 * @param <V> entity of model
 */
public abstract class AbstractDAO<K, V> {

    abstract List<V> getAll();

    abstract boolean update(V v);

    abstract boolean delete(K k);

    abstract boolean create(V v);

    abstract V getById(K k);
}
