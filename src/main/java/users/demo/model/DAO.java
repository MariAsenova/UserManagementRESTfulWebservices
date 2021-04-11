package users.demo.model;

import java.util.List;

public interface DAO<T> {
    List<T> getAll();
    T get(int id);
    void create(T t);
    void update(T t);
    void delete(int id);
}
