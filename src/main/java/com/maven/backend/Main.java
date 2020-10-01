package com.maven.backend;

import com.maven.backend.accountUI;

public class Main {
    public static void main(String[] args) {
        User user = accountUI.userInput();
        //User user = new User("lixuaoj@gmail.com", "xiaomii", "xiaommmi", 1999, 1, 1, 1);
        UserDao.add(user);
        UserDao.print();

        UserDao.update(user, "xiaomiliu");
        UserDao.remove("xiaomiliu");
        UserDao.print();
    }
}
