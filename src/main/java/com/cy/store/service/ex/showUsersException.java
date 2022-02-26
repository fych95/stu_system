package com.cy.store.service.ex;

public class showUsersException extends ServiceException{
    public showUsersException() {
    }

    public showUsersException(String message) {
        super(message);
    }

    public showUsersException(String message, Throwable cause) {
        super(message, cause);
    }

    public showUsersException(Throwable cause) {
        super(cause);
    }

    public showUsersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
