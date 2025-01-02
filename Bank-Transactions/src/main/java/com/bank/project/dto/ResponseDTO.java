package com.bank.project.dto;


public class ResponseDTO<T> {
    private int status;
    private T body;
    private String timestamp;

    public ResponseDTO(int status, T body, String timestamp) {
        this.status = status;
        this.body = body;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
