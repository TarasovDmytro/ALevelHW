package ua.tarasov.hw18.crud;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

public class UsersDao {

    List<User> usersList = new ArrayList<>();

    public boolean existByEmail(String email) {
        usersList = getUsersFromFile();
        return usersList.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    public boolean existById(String id) {

        usersList = getUsersFromFile();
        if (CollectionUtils.isEmpty(usersList)) {
            throw new RuntimeException("Empty list of users");
        }
        return usersList.stream().noneMatch(u -> u.getId().equals(id));
    }

    public void create(User user) {

        setNewUser(user);
    }

    public User readUserById(String id) {

        return getUserById(id);
    }

    public void readAllUsers() {

        usersList = getUsersFromFile();
        if (CollectionUtils.isEmpty(usersList)) {
            throw new RuntimeException("Empty list of users");
        }
        System.out.println(usersList);
    }

    public void updateUserById(User user) {

        setUpdateUserById(user);
    }

    public void deleteUserById(String id) {

        removeUserById(id);
    }

    private void removeUserById(String id) {

        usersList = getUsersFromFile();
        usersList.removeIf(user -> user.getId().equals(id));
        writeUsersToFile();
    }

    private void setUpdateUserById(User user) {

        User currentUser = getUserById(user.getId());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setFullName(user.getFullName());
        currentUser.setEmail(user.getEmail());
        writeUsersToFile();
    }

    private void setNewUser(User user) {

        this.usersList = getUsersFromFile();
        user.setId(generateId());
        this.usersList.add(user);
        writeUsersToFile();
    }

    private void writeUsersToFile() {

        Gson gson = new Gson();
        String usersOut = gson.toJson(this.usersList);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.json"))) {
            writer.append(usersOut);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<User> getUsersFromFile() {

        try {
            String usersJson = FileUtils.readFileToString(new File("users.json"), "UTF-8");
            if (StringUtils.isBlank(usersJson)) {
                return new ArrayList<>();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(usersJson, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("some problem from file");
    }

    private User getUserById(String id) {

        usersList = getUsersFromFile();
        return usersList.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    private String generateId() {

        String id = UUID.randomUUID().toString();
        if (usersList.stream().anyMatch(u -> u.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
