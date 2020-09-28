package com.maven.backend;

import com.maven.backend.User;

import java.util.ArrayList;

public class UserDao {
    private static ArrayList<User> userList = new ArrayList<User>();

    public static void addUser(User user) {
        userList.add(user);
        System.out.println("Successfully added user " + user.getName());
    }

    public static void printUsers() {
        System.out.println("Here is the user list:");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println("User " + (int)(i + 1) + " : " + userList.get(i).getName());
        }
    }

    // Update user's name
    public static void updateUser(User user, String name) {
        user.setName(name);
        System.out.println("Update user name to " + user.getName());
    }

    // Remove user by name
    public static void removeUser(String name) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                userList.remove(i);
            }
        }
        System.out.println("User " + name + " is removed.");
    }
}
