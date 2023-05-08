package b.orrar.service;

import java.util.List;

public interface ICRUD<T, I> {
    
    List<T> findAll();
    T findById(I id);

    T save(T t);

    T update(I id, T t);

    void delete(I id);
}
