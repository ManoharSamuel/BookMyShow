package com.projects.bookmyshow.exceptions;

public class InvalidMovieShowException extends RuntimeException{
    public InvalidMovieShowException(String message) {
        super(message);
    }
}
