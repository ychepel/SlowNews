package com.univer.slownews.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsGenerator implements NewsReader {
    private List<News> news;
    private List<String> sentencePatterns = new ArrayList<String>() {{
            add("ADJECTIVE(35) SUBJECT(100) VERB(100) PREPOSITION(25) ADJECTIVE(65) SUBJECT(100).");
            add("ADJECTIVE(45) SUBJECT(100): SUBJECT(100) VERB(100) PREPOSITION(15) ADJECTIVE(65) SUBJECT(100).");
    }};

    @Override
    public List<News> getNews() {
        for(int i = 0; i < 10 ; i++) {
            news.add(getOneNews());
        }
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
            String sentence = transformPattern(sentencePattern);
            textBuilder.append(sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + " ");
        }
        return textBuilder.toString();
    }

    private String transformPattern(String sentencePattern) {
        String sentence = sentencePattern;
        for(SentenceElement sentenceElement : SentenceElement.values()) {
            SentenceElementStorage elementStorage = new SentenceElementStorage(sentenceElement.getFileName());
            String regex = sentenceElement.name() + "\\(\\d*\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(sentence);
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

    public NewsGenerator() {
        news = new ArrayList<>();
    }

    public static void main(String[] args) {
        NewsReader newsReader = new NewsGenerator();
        for(News news : newsReader.getNews()) {
            System.out.println(news.getTitle());
        }
    }
}
