package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsGenerator implements NewsReader {
    private List<News> news;
    private String resourcesPath;
    private List<String> titlePatterns = new ArrayList<String>() {{
            add("ADJECTIVE(35) SUBJECT(100) VERB(100) PREPOSITION(25) ADJECTIVE(65) SUBJECT(100).");
            add("ADJECTIVE(45) SUBJECT(100): SUBJECT(100) VERB(100) PREPOSITION(15) ADJECTIVE(65) SUBJECT(100).");
            add("VERB(100) ADJECTIVE(60) SUBJECT(100)!");
    }};
    private  List<String> bodyPatterns = new ArrayList<String>() {{
        add("ADJECTIVE(35) SUBJECT(100) VERB(100) PREPOSITION(25) ADJECTIVE(65) SUBJECT(100).");
        add("ADJECTIVE(35) SUBJECT(100) VERB(100) PREPOSITION(25) ADJECTIVE(65) SUBJECT(100) and ADJECTIVE(45) SUBJECT(100).");
    }};

    @Override
    public List<News> getNews() {
        makeFakeNews(10);
        return news;
    }

    public void makeFakeNews(int count) {
        for(int i = 0; i < count ; i++) {
            String title = makeNewsTitle();
            String body = makeNewsBody();
            String imageUrl = "http://lorempixel.com/400/200?random=" + i;
            News fakeNews = new News(title, body, imageUrl, "");
            news.add(fakeNews);
        }
    }

    private String makeNewsTitle() {
        int randomPattern = new Random().nextInt(titlePatterns.size());
        String sentencePattern = titlePatterns.get(randomPattern);
        return makeSentences(sentencePattern, 1);
    }

    private String makeNewsBody() {
        System.out.println(bodyPatterns.size());
        int randomPattern = new Random().nextInt(bodyPatterns.size());
        String sentencePattern = bodyPatterns.get(randomPattern);
        return makeSentences(sentencePattern, 5);
    }

    private String makeSentences(String sentencePattern, int count) {
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String sentence = transformPattern(sentencePattern);
            textBuilder.append(sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + " ");
        }
        return textBuilder.toString();
    }

    private String transformPattern(String sentencePattern) {
        String sentence = sentencePattern;
        for(SentenceElement sentenceElement : SentenceElement.values()) {
            SentenceElementStorage elementStorage = new SentenceElementStorage(resourcesPath + "/" + sentenceElement.getFileName());
            String regex = sentenceElement.name() + "\\(\\d*\\)";
            Pattern regexPattern = Pattern.compile(regex);
            Matcher matcher = regexPattern.matcher(sentence);
            while (matcher.find()) {
                String partToReplace = matcher.group();
                String partFrequency = partToReplace.substring(partToReplace.indexOf("(") + 1, partToReplace.indexOf(")"));
                int frequency = Integer.parseInt(partFrequency);
                if(Math.random() * 100 < frequency) {
                    sentence = sentence.replaceFirst(regex, elementStorage.getRandomElement());
                }
                else {
                    sentence = sentence.replaceFirst(regex + " ", "");
                }
            }
        }
        return sentence;
    }

    public NewsGenerator(String resourcesPath) {
        news = new ArrayList<>();
        this.resourcesPath = resourcesPath;
    }
}
