package com.example.GHTK.Model.AdminRight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TimeLine {

    @SerializedName("description")
    @Expose
    private String description;
    public TimeLine(){}

    @Override
    public String toString() {
        return "Time{" +
                "description='" + description + '\'' +
                '}';
    }

    public TimeLine(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}