package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> users;
    private String message;

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    private boolean isUserNameInList(String name) {
        for(User user : users) {
            if(name.equals(user.getName())) {
                return true;
            }
        }
        return false;
    }

    private UserStorage() {
        users = new ArrayList<>();
        message = "";
    }

    public void addUser(User user) {
        if(!isUserNameInList(user.getName())) {
            users.add(user);
            message = "User have been created successfully.";
        }
        else {
            message = "Username is already taken. Plese try another one.";
        }
    }

    public String getMessage() {
        return message;
    }

    public List<User> getUsers() {
        return users;
    }
}
