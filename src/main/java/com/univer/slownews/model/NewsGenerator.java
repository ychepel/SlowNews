package com.univer.slownews.model;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsGenerator implements NewsReader {
    private List<News> news;
    private static final String[] TITLE_PATTERNS = {
            "ADJECTIVE SUBJECT VERB PREPOSITION ADJECTIVE SUBJECT.",
            "VERB ADJECTIVE SUBJECT!",
            "SUBJECT: SUBJECT VERB PREPOSITION ADJECTIVE SUBJECT."
    };
    private static final String[] BODY_PATTERNS = {
            "ADJECTIVE SUBJECT VERB PREPOSITION ADJECTIVE SUBJECT.",
            "ADJECTIVE SUBJECT VERB PREPOSITION ADJECTIVE SUBJECT and ADJECTIVE SUBJECT.",
            "PRONOUN VERB ADJECTIVE SUBJECT."
    };

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
        return makeSentences(TITLE_PATTERNS, 1);
    }

    private String makeNewsBody() {
        return makeSentences(BODY_PATTERNS, 5);
    }

    private String makeSentences(String[] sentencePatterns, int count) {
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int randomPattern = new Random().nextInt(sentencePatterns.length);
            String pattern = sentencePatterns[randomPattern];
            String sentence = transformPattern(pattern);
            textBuilder.append(sentence.substring(0, 1).toUpperCase() + sentence.substring(1) + " ");
        }
        return textBuilder.toString();
    }

    private String transformPattern(String sentencePattern) {
        String sentence = sentencePattern;
        for(SentenceElement sentenceElement : SentenceElement.values()) {
            SentenceElementStorage elementStorage = new SentenceElementStorage(sentenceElement.getFileName());
            while (sentence.indexOf(sentenceElement.name()) >= 0) {
                sentence = sentence.replaceFirst(sentenceElement.name(), elementStorage.getRandomElement());
            }
        }
        return sentence;
    }

    public NewsGenerator() {
        news = new ArrayList<>();
    }
}
