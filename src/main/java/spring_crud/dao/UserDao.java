package spring_crud.dao;

import spring_crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    User show(int id);

    void update(User user);

    void delete(int id);
}