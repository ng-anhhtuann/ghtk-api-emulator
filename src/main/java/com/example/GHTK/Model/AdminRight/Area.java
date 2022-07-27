package com.example.GHTK.Model.AdminRight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Area {

    @SerializedName("nameArea")
    @Expose
    private String nameArea;

    @Override
    public String toString() {
        return "{" +
                "nameArea='" + nameArea + '\'' +
                '}';
    }

    public Area(String nameArea) {
        this.nameArea = nameArea;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }
}
