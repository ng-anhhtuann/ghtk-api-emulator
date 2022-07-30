package com.example.GHTK.Model.AdminRight;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Service {

    @SerializedName("nameService")
    @Expose
    private String nameService;
    public Service(){}
    @Override
    public String toString() {
        return "Service{" +
                "nameService='" + nameService + '\'' +
                '}';
    }

    public Service(String nameService) {
        this.nameService = nameService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

}