package com.univer.slownews.dao;

import com.univer.slownews.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private ConnectionFactory connectionFactory = new ConnectionFactory();

    public List<User> getUsers() throws DaoException {
        String sql = "SELECT * FROM \"user\"";
        List<User> users = new ArrayList<>();

        try (Connection connection = connectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot add get users from DB", e);
        }
        return users;
    }

    public void addUser(User user) throws DaoException {
        String sql = "INSERT INTO \"user\" (name, password, email) VALUES (?, ?, ?)";

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot add user to DB", e);
        }
    }

}
