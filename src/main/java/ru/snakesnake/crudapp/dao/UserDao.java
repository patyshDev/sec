package ru.snakesnake.crudapp.dao;

import ru.snakesnake.crudapp.model.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(long id);
    public User getUserById(long id);
    public List<User> listUsers();
    public User getUserByUsername(String username);
}
