package com.univer.slownews.dao;

import com.univer.slownews.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDAO {
    private DaoFactory daoFactory = new DaoFactory();

    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        String sql = "SELECT * FROM \"USER\"";

        try (Connection connection = daoFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASSWORD"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void createUser(User user) {
        String sql = "INSERT INTO \"USER\" (NAME, PASSWORD, EMAIL) VALUES (" +
                "'" + user.getName() + "', " +
                "'" + user.getPassword() + "', " +
                "'" + user.getEmail() + "')";

        try (Connection connection = daoFactory.getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            user.setId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        User newUser = new User();
        newUser.setName("bbb");
        newUser.setEmail("b@dsad");
        newUser.setPassword("security");

        userDAO.createUser(newUser);

        for (User user : userDAO.getUsers()) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getEmail() + " " + user.getPassword());
        }
    }
}
