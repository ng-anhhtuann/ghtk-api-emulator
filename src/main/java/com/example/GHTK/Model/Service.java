package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Service {

    @SerializedName("idService")
    @Expose
    private String idService;
    @SerializedName("nameService")
    @Expose
    private String nameService;

    @Override
    public String toString() {
        return "Service{" +
                "idService='" + idService + '\'' +
                ", nameService='" + nameService + '\'' +
                '}';
    }

    public Service(String idService, String nameService) {
        this.idService = idService;
        this.nameService = nameService;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

}