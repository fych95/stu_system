package com.cy.store.service.ex;

public class ShowAllException extends ServiceException{
    public ShowAllException() {
        super();
    }

    public ShowAllException(String message) {
        super(message);
    }

    public ShowAllException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShowAllException(Throwable cause) {
        super(cause);
    }

    protected ShowAllException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
