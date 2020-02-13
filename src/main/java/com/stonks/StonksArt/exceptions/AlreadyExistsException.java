package com.stonks.StonksArt.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message){
        super(message);
    }
}
