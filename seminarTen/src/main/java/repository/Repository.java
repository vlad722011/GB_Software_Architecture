package repository;

import java.util.List;

public interface Repository<E> {
    E getById(int id);
    List<E> getAll();
    void add(E e);
    void update(E e);
    void delete(int id);
}
