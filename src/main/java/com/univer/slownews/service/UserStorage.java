package com.univer.slownews.service;

import com.univer.slownews.dao.DaoException;
import com.univer.slownews.dao.UserDao;
import com.univer.slownews.entity.User;

import java.util.List;

public class UserStorage {
    public void addUser(User user) throws ServiceException {
        UserDao userDao = new UserDao();
        try {
            userDao.addUser(user);
        } catch (DaoException e) {
            throw new ServiceException("Cannot add new user", e);
        }
    }

    public boolean contains(User tmpUser) throws ServiceException {
        for (User user : getUsers()) {
            if (tmpUser.getName().equals(user.getName())) {
                if (tmpUser.getPassword().equals(user.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsUserName(String username) throws ServiceException {
        try {
            getByName(username);
        } catch (ServiceException e) {
            return false;
        }
        return true;
    }

    public List<User> getUsers() throws ServiceException {
        try {
            List<User> users = new UserDao().getUsers();
            return users;
        } catch (DaoException e) {
            throw new ServiceException("Cannot get users", e);
        }
    }


    public User getByName(String userName) throws ServiceException {
        UserDao userDao = new UserDao();
        try {
            User user = userDao.getUserByName(userName);
            return user;
        } catch (DaoException e) {
            throw new ServiceException("User not found by name.", e);
        }
    }

}
