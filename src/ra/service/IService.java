package ra.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    int getNewId();
    void save(T t);
    void update(T t);
    void delete(int id);
    T findByID(int id);

}
