package com.example.GHTK.Model.Status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Success {
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("message")
    @Expose
    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Success{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public Success(boolean status, String message) {
        this.status = status;
        this.message = message;
    }
}
