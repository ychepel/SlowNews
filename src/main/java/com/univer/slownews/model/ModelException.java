package com.univer.slownews.model;

import com.univer.slownews.service.ServiceException;

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
