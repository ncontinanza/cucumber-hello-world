package com.marsrover.model.Exception;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(char command) {
        super(String.format("Command %s is not supported by this rover", command));
    }

}
