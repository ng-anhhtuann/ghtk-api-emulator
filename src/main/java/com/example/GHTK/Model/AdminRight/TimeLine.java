package com.example.GHTK.Model.AdminRight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TimeLine {

//    @SerializedName("idTimeDeliver")
//    @Expose
//    private String idTimeDeliver;
    @SerializedName("description")
    @Expose
    private String description;

//    public String getIdTimeDeliver() {
//        return idTimeDeliver;
//    }

//    public void setIdTimeDeliver(String idTimeDeliver) {
//        this.idTimeDeliver = idTimeDeliver;
//    }


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