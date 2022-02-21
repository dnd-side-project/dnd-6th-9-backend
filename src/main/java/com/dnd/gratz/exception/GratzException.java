package com.dnd.gratz.exception;

import lombok.Getter;

@Getter
public class GratzException extends RuntimeException {

    private final int status;
    private final String result;
    private final String message;

    public GratzException(int status, String result, String message) {
        super(message);
        this.status = status;
        this.result = result;
        this.message = message;
    }
}
