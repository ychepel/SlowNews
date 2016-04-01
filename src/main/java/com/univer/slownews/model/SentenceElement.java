package com.univer.slownews.model;

public enum SentenceElement {
    ADJECTIVE("adjective.txt"), SUBJECT("subject.txt"), VERB("verb.txt"), PREPOSITION("preposition.txt");

    private String fileName;
    SentenceElement(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
