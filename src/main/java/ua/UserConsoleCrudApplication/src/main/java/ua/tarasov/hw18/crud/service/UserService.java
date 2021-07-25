package ua.tarasov.hw18.crud.service;

import ua.tarasov.hw18.crud.dao.UsersDao;

public class UserService {

    private final UsersDao userDao = new UsersDao();

    public void create(User user) {
        if (!userDao.existByEmail(user.getEmail())) {
            userDao.create(user);
        } else System.out.println("\nuser with such mail already exists, please try again");
    }

    public void readAllUsers() {
        userDao.readAllUsers();
    }

    public User readUserById(String id) {
        if (userDao.existById(id)) {
            throw new RuntimeException("ID does not exist");
        }
        return userDao.readUserById(id);
    }

    public void updateUserById(User user) {
        if (userDao.existById(user.getId())) {
            throw new RuntimeException("ID does not exist");
        } else {
            userDao.updateUserById(user);
        }
    }

    public void deleteUserById(String id) {
        if (userDao.existById(id)) {
            throw new RuntimeException("ID does not exist");
        } else {
            userDao.deleteUserById(id);
        }
    }
}
