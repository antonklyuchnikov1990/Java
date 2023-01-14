package de.telran.shop.repository;

public interface CommonRepository<T> {

    T save(T entity);

    Iterable<T> save(Iterable<T> entities);

    T delete(String id);

    T findById(String id);

    Iterable<T> findAll();

}
