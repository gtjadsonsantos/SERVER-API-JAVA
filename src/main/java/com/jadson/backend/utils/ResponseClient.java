package com.jadson.backend.utils;

public class ResponseClient {

    private String message;

    public ResponseClient() {
    }

    public ResponseClient(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}