package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsGenerator implements NewsReader {
    private List<News> news;
    private List<String> sentencePatterns = new ArrayList<String>() {{
            add("%ADJECTIVE SUBJECT VERB %PREPOSITION %ADJECTIVE SUBJECT.");
    }};

    @Override
    public List<News> getNews() {
        return news;
    }

    public News getOneNews() {
        News fake = new News(makeSentences(1), makeSentences(3), "", "");
        return fake;
    }

    private String makeSentences(int count) {
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int randomPattern = new Random().nextInt(sentencePatterns.size());
            String sentencePattern = sentencePatterns.get(randomPattern);
            String sentence = tranformPattern(sentencePattern);
            textBuilder.append(sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + " ");
        }
        return textBuilder.toString();
    }

    private String tranformPattern(String sentencePattern) {
        String sentence = sentencePattern;
        for(SentenceElement sentenceElement : SentenceElement.values()) {
            ElementReader elements = new ElementReader(sentenceElement.getFileName());
            while (sentence.indexOf(sentenceElement.name()) >= 0) {
                if(sentence.indexOf("%" + sentenceElement.name()) >= 0) {
                    if(Math.random() < 0.5) {
                        sentence = sentence.replaceFirst("%" + sentenceElement.name(), elements.getRandomElement());
                    }
                    else {
                        sentence = sentence.replaceFirst("%" + sentenceElement.name() + " ", "");
                    }
                }
                else {
                    sentence = sentence.replaceFirst(sentenceElement.name(), elements.getRandomElement());
                }
            }
        }
        return sentence;
    }

    public NewsGenerator() {
        news = new ArrayList<>();
    }

    public static void main(String[] args) {
        NewsGenerator generator = new NewsGenerator();
        News oneNews = generator.getOneNews();
        System.out.println("title: " + oneNews.getTitle());
        System.out.println("body : " + oneNews.getBody());
    }
}
