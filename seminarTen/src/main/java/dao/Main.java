package dao;

import java.util.List;

public class Main {

    //Data Access Object (DAO)
    public static void main(String[] args) {
        UserDao userDao = new InMemoryUserDao();

        userDao.add(new User(1, "Alice"));
        userDao.add(new User(2, "Bob"));

        User user = userDao.findById(1);
        System.out.println("User with ID 1: " + user.getName());

        List<User> allUsers = userDao.findAll();
        System.out.println("All Users:");
        for (User u : allUsers) {
            System.out.println(u.getId() + ": " + u.getName());
        }

        User updatedUser = new User(1, "Alicia");
        userDao.save(updatedUser);

        userDao.delete(2);
    }
}