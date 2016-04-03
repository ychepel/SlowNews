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

    private boolean isUserNameInList(String name) {
        for (User user : users) {
            if (name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    private UserStorage() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (!isUserNameInList(user.getName())) {
            users.add(user);
        }
    }

    public boolean contains(User tmpUser) {
        for (User user : users) {
            if (tmpUser.getName().equals(user.getName())) {
                if (tmpUser.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsUserName(String username) {
        for (User user : users) {
            if (username.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }


}
