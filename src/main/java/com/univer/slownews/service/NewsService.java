package com.univer.slownews.service;

import com.univer.slownews.dao.DaoException;
import com.univer.slownews.dao.NewsDao;
import com.univer.slownews.entity.News;

import java.util.List;

public class NewsService {
    public void addNews(News news) throws ServiceException {
        NewsDao newsDao = new NewsDao();
        try {
            newsDao.addNews(news);
        } catch (DaoException e) {
            throw new ServiceException("Cannot add news into DB", e);
        }
    }

    public List<News> getUserNews(String userName) throws ServiceException {
        NewsDao newsDao = new NewsDao();
        try {
            List<News> news = newsDao.getNewsByUser(userName);
            return news;
        } catch (DaoException e) {
            throw new ServiceException("Cannot get news for user from DB", e);
        }
    }

    public void removeNews(List<Integer> newsId) throws ServiceException {
        NewsDao newsDao = new NewsDao();
        try {
            newsDao.removeNewsById(newsId);
        } catch (DaoException e) {
            throw new ServiceException("Cannot remove archive news from DB", e);
        }
    }

}
