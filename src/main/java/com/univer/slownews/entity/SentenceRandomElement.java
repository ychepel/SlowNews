package com.univer.slownews.entity;

import com.univer.slownews.service.SentenceRandomElementService;
import com.univer.slownews.service.ServiceException;

public enum SentenceRandomElement implements SentenceElement {
    ADJECTIVE,
    SUBJECT,
    VERB,
    PAST,
    PREPOSITION,
    PRONOUN,
    MODAL,
    QUESTION;

    @Override
    public String getElementValue() throws EntityException {
        SentenceRandomElementService elementStorage = new SentenceRandomElementService();
        try {
            return " " + elementStorage.getRandomElement(this.name());
        } catch (ServiceException e) {
            throw new EntityException("Cannot receive elements value from DB.", e);
        }
    }
}
