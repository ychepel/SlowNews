package com.univer.slownews.model;

import com.univer.slownews.service.SentencePartStorage;
import com.univer.slownews.service.ServiceException;

public enum SentencePart implements SentenceElement {
    ADJECTIVE,
    SUBJECT,
    VERB,
    PAST,
    PREPOSITION,
    PRONOUN,
    MODAL,
    QUESTION;

    @Override
    public String getElementValue() throws ModelException {
        SentencePartStorage elementStorage = new SentencePartStorage();
        try {
            return " " + elementStorage.getRandomElement(this.name());
        } catch (ServiceException e) {
            throw new ModelException("Cannot receive elements value from DB.", e);
        }
    }
}
