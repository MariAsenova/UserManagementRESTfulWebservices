package users.demo.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO implements DAO<User> {

    private List<User> users = new ArrayList<>();
    private String usersFile = "users.json";
    private ObjectMapper mapper = new ObjectMapper();

    public UserDAO() {
        readDataFromFile();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User get(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void create(User user) {
        users.add(user);
        saveChanges();
    }

    @Override
    public void update(User user) {
        boolean removeIf = users.removeIf(userIn -> userIn.getId() == user.getId());
        if (removeIf) {
            users.add(user);
            saveChanges();
        } else {
            throw new RuntimeException("User to delete not found");
        }
    }

    @Override
    public void delete(int id) {
        users.removeIf(userIn -> userIn.getId() == id);
        saveChanges();
    }

    private void readDataFromFile() {
        try {
            List<User> usersList = mapper.readValue(new File(usersFile), new TypeReference<List<User>>() {
            });
            users = usersList;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void saveChanges() {
        try {
            mapper.writeValue(new File(usersFile), users);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
