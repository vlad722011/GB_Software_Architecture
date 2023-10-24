package dao;

import java.util.List;

public interface UserDao {
    User findById(int id);
    List<User> findAll();
    void add(User user);
    void save(User user);
    void delete(int id);
}