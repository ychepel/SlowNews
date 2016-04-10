package com.univer.slownews.model;

public enum SentenceInsertion implements SentenceElement {
    POINT("."),
    EXCLAMATION("!"),
    COMMA(","),
    COLON(":"),
    QUESTION_MARK("?"),
    WORD_TO(" to"),
    WORD_WAS(" was"),
    WORD_BUT("but"),
    WORD_AND(" and");

    private String value;

    SentenceInsertion(String value) {
        this.value = value;
    }

    public String getElementValue() {
        return value;
    }
}
