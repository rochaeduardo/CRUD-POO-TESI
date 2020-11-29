package mariadbcrud.dao;

import mariadbcrud.model.User;

import java.util.List;

public interface Dao<T> {
    void insert(T t);
    T update(T t);
    void delete(Integer id);
    T findById(Integer id);
    List<T> findAll();
}
