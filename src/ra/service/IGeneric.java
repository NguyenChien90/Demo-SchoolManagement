package ra.service;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();
    void save(T t);
    void update(T t);
    void delete(int id);
    T findByID(int id);

}
