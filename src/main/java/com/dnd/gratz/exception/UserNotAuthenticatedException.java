package com.dnd.gratz.exception;

public class UserNotAuthenticatedException extends GratzException {
    public UserNotAuthenticatedException() {
        super(401, "fail", "User is not authenticated.");
    }
}
