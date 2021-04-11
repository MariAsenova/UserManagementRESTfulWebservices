package users.demo.service;

import users.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    void createUser(User newUser);
    void removeUser(int id);
    void updateUser(User user);
}
