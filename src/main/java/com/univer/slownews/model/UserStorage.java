package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> users;

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    private UserStorage() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
