package com.example.GHTK.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Area {

    @SerializedName("idArea")
    @Expose
    private String idArea;
    @SerializedName("nameArea")
    @Expose
    private String nameArea;

    @Override
    public String toString() {
        return "{" +
                "idArea='" + idArea + '\'' +
                ", nameArea='" + nameArea + '\'' +
                '}';
    }

    public Area(String idArea, String nameArea) {
        this.idArea = idArea;
        this.nameArea = nameArea;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }
}
