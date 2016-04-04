package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsStorage {
    private static NewsStorage instance;
    private Map<String, List<News>> archiveNews;

    public static synchronized NewsStorage getInstance() {
        if (instance == null) {
            instance = new NewsStorage();
        }
        return instance;
    }

    private NewsStorage() {
        archiveNews = new HashMap<>();
    }

    public void addNews(String user, News news) {
        if(!archiveNews.containsKey(user)) {
            List<News> userNews = new ArrayList<>();
            archiveNews.put(user, userNews);
        }
        archiveNews.get(user).add(news);
    }

    public List<News> getUserNews(String user) {
        if(archiveNews.containsKey(user)) {
            return archiveNews.get(user);
        }
        else {
            return new ArrayList<>();
        }

    }
}
