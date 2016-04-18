package com.univer.slownews.service;

import com.univer.slownews.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.univer.slownews.model.SentenceConstantElement.*;
import static com.univer.slownews.model.SentenceRandomElement.*;

public class NewsGenerator implements NewsProvider {

    private static final List<List<SentenceElement>> SENTENCE_PATTERNS = new ArrayList(){{
        add(Arrays.asList(ADJECTIVE, SUBJECT, VERB, PREPOSITION, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(VERB, ADJECTIVE, SUBJECT, EXCLAMATION));
        add(Arrays.asList(SUBJECT, COLON, SUBJECT, VERB, PREPOSITION, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(ADJECTIVE, SUBJECT, PAST, PREPOSITION, ADJECTIVE, SUBJECT, WORD_AND, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(PRONOUN, PAST, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(SUBJECT, VERB, WORD_TO, VERB, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(ADJECTIVE, SUBJECT, MODAL, VERB, PREPOSITION, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(SUBJECT, WORD_WAS, PAST, PREPOSITION, ADJECTIVE, SUBJECT, POINT));
        add(Arrays.asList(SUBJECT, PAST, COMMA, WORD_BUT, SUBJECT, PAST, POINT));
        add(Arrays.asList(QUESTION, SUBJECT, VERB, SUBJECT, QUESTION_MARK));;
        add(Arrays.asList(SUBJECT, PAST, SUBJECT, PREPOSITION, SUBJECT, POINT));
    }};

    @Override
    public List<News> getNews() throws ServiceException {
        return makeFakeNews(10);
    }

    public List<News> makeFakeNews(int count) throws ServiceException {
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

    private String makeNewsTitle() throws ServiceException {
        return makeSentences(1);
    }

    private String makeNewsBody() throws ServiceException {
        return makeSentences(5);
    }

    private String makeSentences(int count) throws ServiceException {
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int randomPattern = new Random().nextInt(SENTENCE_PATTERNS.size());
            List<SentenceElement> pattern = SENTENCE_PATTERNS.get(randomPattern);
            textBuilder.append(transformPattern(pattern) + " ");
        }
        return textBuilder.toString();
    }

    private String transformPattern(List<SentenceElement> pattern) throws ServiceException {
        StringBuilder builder = new StringBuilder();
        for(SentenceElement element : pattern) {
            try {
                builder.append(element.getElementValue());
            } catch (ModelException e) {
                throw new ServiceException("Cannot transform string pattern.", e);
            }
        }
        return clearingSentence(builder.toString());
    }

    private String clearingSentence(String sentence) {
        String clear = sentence.substring(1, 2).toUpperCase() + sentence.substring(2);
        clear.replace("  ", " ");
        return clear;
    }
}
