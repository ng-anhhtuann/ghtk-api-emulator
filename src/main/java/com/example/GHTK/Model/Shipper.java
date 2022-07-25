package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipper {

    @SerializedName("idShipper")
    @Expose
    private String idShipper;
    @SerializedName("nameShipper")
    @Expose
    private String nameShipper;
    @SerializedName("bornShipper")
    @Expose
    private String bornShipper;
    @SerializedName("genderShipper")
    @Expose
    private boolean genderShipper;
    @SerializedName("numberShipper")
    @Expose
    private String numberShipper;
    @SerializedName("addressShipper")
    @Expose
    private String addressShipper;

    @Override
    public String toString() {
        return "Shipper{" +
                "idShipper='" + idShipper + '\'' +
                ", nameShipper='" + nameShipper + '\'' +
                ", bornShipper='" + bornShipper + '\'' +
                ", genderShipper=" + genderShipper +
                ", numberShipper='" + numberShipper + '\'' +
                ", addressShipper='" + addressShipper + '\'' +
                '}';
    }

    public Shipper(String idShipper, String nameShipper, String bornShipper, boolean genderShipper, String numberShipper, String addressShipper) {
        this.idShipper = idShipper;
        this.nameShipper = nameShipper;
        this.bornShipper = bornShipper;
        this.genderShipper = genderShipper;
        this.numberShipper = numberShipper;
        this.addressShipper = addressShipper;
    }

    public String getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(String idShipper) {
        this.idShipper = idShipper;
    }

    public String getNameShipper() {
        return nameShipper;
    }

    public void setNameShipper(String nameShipper) {
        this.nameShipper = nameShipper;
    }

    public String getBornShipper() {
        return bornShipper;
    }

    public void setBornShipper(String bornShipper) {
        this.bornShipper = bornShipper;
    }

    public boolean isGenderShipper() {
        return genderShipper;
    }

    public void setGenderShipper(boolean genderShipper) {
        this.genderShipper = genderShipper;
    }

    public String getNumberShipper() {
        return numberShipper;
    }

    public void setNumberShipper(String numberShipper) {
        this.numberShipper = numberShipper;
    }

    public String getAddressShipper() {
        return addressShipper;
    }

    public void setAddressShipper(String addressShipper) {
        this.addressShipper = addressShipper;
    }

}