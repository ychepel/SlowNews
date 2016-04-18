package com.univer.slownews.dao;

import com.univer.slownews.model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDao {
    private ConnectionProvider connectionProvider = new ConnectionProvider();

    public List<News> getNewsByUser(String userName) throws DaoException {
        String sql = "SELECT N.* FROM \"NEWS\" N INNER JOIN \"USER\" U ON N.\"USER_ID\"=U.\"ID\" WHERE U.\"NAME\"=?";
        List<News> news = new ArrayList<>();

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, userName);

            try (ResultSet resultSet = statement.executeQuery();) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String title = resultSet.getString("TITLE");
                    String body = resultSet.getString("BODY");
                    String imageLink = resultSet.getString("TEASER_LINK");
                    String sourceLink = resultSet.getString("SOURCE_LINK");
                    News currentNews = new News(id, title, body, imageLink, sourceLink);
                    news.add(currentNews);
                }
            }
        } catch (SQLException e) {
            throw new DaoException("Cannot add get news for user from DB", e);
        }
        return news;
    }

    public void addNews(String userName, News news) throws DaoException {
        String sql = "INSERT INTO \"NEWS\" (\"USER_ID\", \"TITLE\", \"BODY\", \"TEASER_LINK\", \"SOURCE_LINK\") " +
                "(SELECT \"ID\", ?, ?, ?, ? FROM \"USER\" WHERE \"NAME\"=?)";

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, news.getTitle());
            statement.setString(2, news.getBody());
            statement.setString(3, news.getTeaserLink());
            statement.setString(4, news.getUrl());
            statement.setString(5, userName);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Cannot add news to DB", e);
        }
    }

    public void removeNewsById(List<Integer> newsId) throws DaoException {
        String sql = "DELETE FROM \"NEWS\" WHERE \"ID\"=?";

        try (Connection connection = connectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
        ) {
//            statement.setInt(1, newsId.get(0));
//            statement.executeUpdate();
            for(Integer id : newsId) {
                statement.setInt(1, id);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new DaoException("Cannot delete news by ID from DB", e);
        }
    }
}
