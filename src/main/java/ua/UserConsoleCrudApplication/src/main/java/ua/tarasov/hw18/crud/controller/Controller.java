package ua.tarasov.hw18.crud.controller;

import ua.tarasov.hw18.crud.service.User;
import ua.tarasov.hw18.crud.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    User user = new User();
    UserService userService = new UserService();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void run() {

        String action = "";
        while (!action.equals("0")) {

            System.out.println("""
                     
                     Select an action, please:
                     _______________________________________
                     enter 1  if you want to create user
                     enter 2  if you want to update user
                     enter 3  if you want to delete user
                     enter 4  if you want to find user by ID
                     enter 5  if you want to view all users
                     enter 0  if you want to exit
                     _______________________________________
                    """);

            try {
                action = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\n");

            switch (action) {
                case "1" -> createUser(bufferedReader);
                case "2" -> updateUserById(bufferedReader);
                case "3" -> deleteUserById(bufferedReader);
                case "4" -> readUserById(bufferedReader);
                case "5" -> readAllUsers();
            }
        }
    }

    private void createUser(BufferedReader bufferedReader) {

        System.out.println("Create user:\n");
        System.out.println("Please, enter your first name");
        try {
            String firstName = bufferedReader.readLine();
            System.out.println("Please, enter your last name");
            String lastName = bufferedReader.readLine();
            System.out.println("Please, enter your email");
            String email = bufferedReader.readLine();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setFullName(firstName + " " + lastName);
            user.setEmail(email);
            userService.create(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nUser created");
    }

    private void readAllUsers() {

        System.out.println("All users:\n");
        userService.readAllUsers();
    }

    private void readUserById(BufferedReader bufferedReader) {

        System.out.println("Find user by ID :\n");
        System.out.println("Please, enter ID of user:");
        String id = null;
        try {
            id = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nUser = " + userService.readUserById(id));
    }

    private void updateUserById(BufferedReader bufferedReader) {

        System.out.println("Update user by ID:\n");
        try {
            System.out.println("Please, enter ID of user:");
            String id = bufferedReader.readLine();
            System.out.println("\nPlease, enter new first name:");
            String firstName = bufferedReader.readLine();
            System.out.println("Please, enter new last name");
            String lastName = bufferedReader.readLine();
            System.out.println("Please, enter new email");
            String email = bufferedReader.readLine();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setFullName(firstName + " " + lastName);
            user.setEmail(email);
            user.setId(id);
            userService.updateUserById(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nUser updated");
    }

    private void deleteUserById(BufferedReader bufferedReader) {

        System.out.println("Delete user by ID:\n");
        System.out.println("Please, enter ID of user, who must be delete:");
        try {
            String id = bufferedReader.readLine();
            userService.deleteUserById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nUser deleted");
    }
}
