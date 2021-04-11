package users.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.demo.model.DAO;
import users.demo.model.User;
import users.demo.model.UserDAO;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DAO<User> userDAO;

    @Override
    public List<User> getAllUsers() {
       return userDAO.getAll();
    }

    @Override
    public User getUser(int id) {
        return userDAO.get(id);
    }

    @Override
    public void createUser(User newUser) {
        userDAO.create(newUser);
    }

    @Override
    public void removeUser(int id) {
        userDAO.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }


}
