package users.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import users.demo.model.User;
import users.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("")
    public void createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.removeUser(id);
    }

    @PutMapping("")
    public void updateUser(@RequestBody User userToUpdate)
    {
        userService.updateUser(userToUpdate);
    }
}
