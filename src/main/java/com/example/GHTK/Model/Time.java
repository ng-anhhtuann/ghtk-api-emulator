package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Time {

    @SerializedName("idTimeDeliver")
    @Expose
    private String idTimeDeliver;
    @SerializedName("description")
    @Expose
    private String description;

    public String getIdTimeDeliver() {
        return idTimeDeliver;
    }

    public void setIdTimeDeliver(String idTimeDeliver) {
        this.idTimeDeliver = idTimeDeliver;
    }

    @Override
    public String toString() {
        return "Time{" +
                "idTimeDeliver='" + idTimeDeliver + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Time(String idTimeDeliver, String description) {
        this.idTimeDeliver = idTimeDeliver;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}