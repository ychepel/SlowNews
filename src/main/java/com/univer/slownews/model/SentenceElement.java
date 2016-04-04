package com.univer.slownews.model;

public enum SentenceElement {
    ADJECTIVE("adjective.txt"),
    SUBJECT("subject.txt"),
    VERB("verb.txt"),
    PAST("pastverb.txt"),
    PREPOSITION("preposition.txt"),
    PRONOUN("pronoun.txt"),
    MODAL("modalverb.txt"),
    QUESTION("question.txt");

    private String fileName;
    SentenceElement(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
