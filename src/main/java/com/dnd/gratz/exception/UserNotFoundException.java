package com.dnd.gratz.exception;

public class UserNotFoundException extends GratzException {
    public UserNotFoundException() {
        super(404, "fail", "User not found exception.");
    }
}
