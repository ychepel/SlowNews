package com.univer.slownews.service;

import com.univer.slownews.model.News;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class WireNewsReader implements NewsProvider {
    private List<News> news;

    private void parseWebSite() throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse("http://newswire.net/rssfeeds/channel/feed/rss/newsroom");

        NodeList nodeList = doc.getElementsByTagName("item");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                News currentNews = new News();
                currentNews.setBody(element.getElementsByTagName("description").item(0).getTextContent());
                currentNews.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                currentNews.setUrl(element.getElementsByTagName("link").item(0).getTextContent());

                NodeList imageList = element.getElementsByTagName("enclosure");
                Element imageNode = (Element) imageList.item(0);
                currentNews.setTeaserLink(imageNode.getAttribute("url"));

                news.add(currentNews);
            }
        }
    }

    @Override
    public List<News> getNews() {
        news = new ArrayList<>();
        try {
            parseWebSite();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }
}
