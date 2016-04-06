package com.univer.slownews.service;

import com.univer.slownews.model.News;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class WireNewsProvider {

    public List<News> getNews() {
        List<News> news = new ArrayList<>();

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://newswire.net").path("rssfeeds/channel/feed/rss/newsroom");
        News jsonAnswer = target.request(MediaType.APPLICATION_XML_TYPE).get(News.class);
        news.add(jsonAnswer);

        return news;
    }

    public static void main(String[] args) {
        for(News news : new WireNewsProvider().getNews()) {
            System.out.println("Title: " + news.getTitle());
            System.out.println("Body : " + news.getBody());
            System.out.println("Image: " + news.getTeaserLink());
            System.out.println("URL  : " + news.getUrl());
        }
    }
}
