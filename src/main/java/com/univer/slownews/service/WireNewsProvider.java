package com.univer.slownews.service;

import com.univer.slownews.model.News;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WireNewsProvider {

    public static void getOne() {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(News.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            News news = (News) jaxbUnmarshaller.unmarshal(new URL("http://newswire.net/rssfeeds/channel/feed/rss/newsroom"));
            System.out.println("Title: " + news.getTitle());
            System.out.println("Body : " + news.getBody());
            System.out.println("Image: " + news.getTeaserLink());
            System.out.println("URL  : " + news.getUrl());

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public List<News> getNews() {
        List<News> news = new ArrayList<>();

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://newswire.net").path("rssfeeds/channel/feed/rss/newsroom");
        News currentNews = target.request(MediaType.APPLICATION_XML).get(News.class);
        news.add(currentNews);

        return news;
    }

    public static void main(String[] args) {
        getOne();
//        for(News news : new WireNewsProvider().getNews()) {
//            System.out.println("Title: " + news.getTitle());
//            System.out.println("Body : " + news.getBody());
//            System.out.println("Image: " + news.getTeaserLink());
//            System.out.println("URL  : " + news.getUrl());
//        }
    }
}
