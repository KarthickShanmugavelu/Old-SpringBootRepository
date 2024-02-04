package com.code.rest.api.entity;

public class StudentNotFoundException extends RuntimeException{
    private String message;

    public StudentNotFoundException(String message) {
        super(message);
        this.message=message;
    }

    public StudentNotFoundException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public StudentNotFoundException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public StudentNotFoundException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
