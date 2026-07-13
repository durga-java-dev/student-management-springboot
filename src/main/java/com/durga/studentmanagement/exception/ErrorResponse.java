package com.durga.studentmanagement.exception;

public class ErrorResponse {

    private String error;
    private int status;
    private String timestamp;

    // Constructor
    public ErrorResponse(String error, int status, String timestamp) {
        this.error = error;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters
    public String getError() { return error; }
    public int getStatus() { return status; }
    public String getTimestamp() { return timestamp; }
}