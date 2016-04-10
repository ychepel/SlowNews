package com.univer.slownews.model;

public enum SentencePart implements SentenceElement {
    ADJECTIVE("adjective.txt"),
    SUBJECT("subject.txt"),
    VERB("verb.txt"),
    PAST("pastverb.txt"),
    PREPOSITION("preposition.txt"),
    PRONOUN("pronoun.txt"),
    MODAL("modalverb.txt"),
    QUESTION("question.txt");

    private String fileName;
    SentencePart(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getElementValue() {
        SentencePartStorage elementStorage = new SentencePartStorage(fileName);
        return " " + elementStorage.getRandomElement();
    }
}
