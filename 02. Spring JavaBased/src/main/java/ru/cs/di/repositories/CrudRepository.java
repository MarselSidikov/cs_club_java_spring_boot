package ru.cs.di.repositories;

public interface CrudRepository<T, ID> {
    void save(T model);
    T findById(ID id);
}
