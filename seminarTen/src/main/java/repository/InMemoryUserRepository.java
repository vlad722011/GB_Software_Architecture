package repository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements Repository<User> {
    private List<User> users = new ArrayList<>();
    private int nextId = 1;

    @Override
    public User getById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void add(User user) {
        user.setId(nextId++);
        users.add(user);
    }

    @Override
    public void update(User user) {
        //TODO
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
