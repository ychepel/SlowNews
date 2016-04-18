package com.univer.slownews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SentencePartDao {
    private ConnectionProvider connectionProvider = new ConnectionProvider();

    public List<String> getParts(String type) throws DaoException {
        String sql = "SELECT * FROM \"SENTENCE_PART\" WHERE \"TYPE\"=?;";
        List<String> parts = new ArrayList<>();

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, type);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    String part = resultSet.getString("VALUE");
                    parts.add(part);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot add get sentence parts from DB", e);
        }
        return parts;
    }
}
