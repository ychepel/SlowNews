package com.univer.slownews.service;

import com.univer.slownews.model.News;
import com.univer.slownews.model.SentenceElement;
import com.univer.slownews.model.SentenceElementStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsGenerator implements NewsReader {

    private static final String[] SENTENCE_PATTERNS = {
            "ADJECTIVE SUBJECT VERB PREPOSITION ADJECTIVE SUBJECT.",
            "VERB ADJECTIVE SUBJECT!",
            "SUBJECT: SUBJECT VERB PREPOSITION ADJECTIVE SUBJECT.",
            "ADJECTIVE SUBJECT PAST PREPOSITION ADJECTIVE SUBJECT and ADJECTIVE SUBJECT.",
            "PRONOUN PAST ADJECTIVE SUBJECT.",
            "SUBJECT VERB to VERB ADJECTIVE SUBJECT.",
            "ADJECTIVE SUBJECT MODAL VERB PREPOSITION ADJECTIVE SUBJECT.",
            "SUBJECT was PAST PREPOSITION ADJECTIVE SUBJECT.",
            "SUBJECT PAST, but SUBJECT PAST.",
            "QUESTION SUBJECT VERB SUBJECT?",
            "SUBJECT PAST SUBJECT PREPOSITION SUBJECT."
    };

    @Override
    public List<News> getNews() {
        return makeFakeNews(10);
    }

    public List<News> makeFakeNews(int count) {
        List<News> news = new ArrayList<>();
        for(int i = 0; i < count ; i++) {
            String title = makeNewsTitle();
            String body = makeNewsBody();
            String imageUrl = "http://lorempixel.com/400/200?random=" + i;
            News fakeNews = new News(title, body, imageUrl, "");
            news.add(fakeNews);
        }
        return news;
    }

    private String makeNewsTitle() {
        return makeSentences(1);
    }

    private String makeNewsBody() {
        return makeSentences(5);
    }

    private String makeSentences(int count) {
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int randomPattern = new Random().nextInt(SENTENCE_PATTERNS.length);
            String pattern = SENTENCE_PATTERNS[randomPattern];
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
}
