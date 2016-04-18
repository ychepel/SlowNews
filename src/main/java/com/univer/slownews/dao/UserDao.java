package com.univer.slownews.dao;

import com.univer.slownews.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private ConnectionProvider connectionProvider = new ConnectionProvider();

    public List<User> getUsers() throws DaoException {
        String sql = "SELECT * FROM \"USER\"";
        List<User> users = new ArrayList<>();

        try (Connection connection = connectionProvider.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("NAME"));
                user.setEmail(resultSet.getString("EMAIL"));
                user.setPassword(resultSet.getString("PASSWORD"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot add get users from DB", e);
        }
        return users;
    }

    public void addUser(User user) throws DaoException {
        String sql = "INSERT INTO \"USER\" (\"NAME\", \"PASSWORD\", \"EMAIL\") VALUES (?, ?, ?)";

        try (Connection connection = connectionProvider.getConnection();
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
