package com.codermine.cookbook.exception;

public class CookbookException extends RuntimeException{

    public CookbookException(String message) {
        super(message);
    }

    public CookbookException(String message, Throwable cause) {
        super(message, cause);
    }
}
