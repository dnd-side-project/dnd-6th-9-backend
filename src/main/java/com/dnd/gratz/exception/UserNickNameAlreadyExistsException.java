package com.dnd.gratz.exception;

public class UserNickNameAlreadyExistsException extends GratzException {
    public UserNickNameAlreadyExistsException() {
        super(409, "fail", "Nickname is already exists.");
    }
}
