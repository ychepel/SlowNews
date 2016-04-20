package com.univer.slownews.entity;

public class ModelException extends Exception {
    public ModelException() {
        super();
    }

    public ModelException(String message) {
        super(message);
    }

    public ModelException(String message, Throwable cause) {
        super(message, cause);
    }
}
