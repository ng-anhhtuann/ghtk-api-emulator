package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SignUpDeliver {

    @SerializedName("idShipper")
    @Expose
    private String idShipper;
    @SerializedName("idTimeDeliver")
    @Expose
    private String idTimeDeliver;

    @Override
    public String toString() {
        return "SignUpDeliver{" +
                "idShipper='" + idShipper + '\'' +
                ", idTimeDeliver='" + idTimeDeliver + '\'' +
                '}';
    }

    public SignUpDeliver(String idShipper, String idTimeDeliver) {
        this.idShipper = idShipper;
        this.idTimeDeliver = idTimeDeliver;
    }

    public String getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(String idShipper) {
        this.idShipper = idShipper;
    }

    public String getIdTimeDeliver() {
        return idTimeDeliver;
    }

    public void setIdTimeDeliver(String idTimeDeliver) {
        this.idTimeDeliver = idTimeDeliver;
    }

}