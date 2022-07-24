
package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("idCustomer")
    @Expose
    private String idCustomer;
    @SerializedName("idArea")
    @Expose
    private String idArea;
    @SerializedName("nameCustomer")
    @Expose
    private String nameCustomer;
    @SerializedName("shopCustomer")
    @Expose
    private String shopCustomer;
    @SerializedName("numberCustomer")
    @Expose
    private String numberCustomer;
    @SerializedName("emailCustomer")
    @Expose
    private String emailCustomer;
    @SerializedName("addressCustomer")
    @Expose
    private String addressCustomer;

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", idArea='" + idArea + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", shopCustomer='" + shopCustomer + '\'' +
                ", numberCustomer='" + numberCustomer + '\'' +
                ", emailCustomer='" + emailCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                '}';
    }

    public Customer(String idCustomer, String idArea, String nameCustomer, String shopCustomer, String numberCustomer, String emailCustomer, String addressCustomer) {
        this.idCustomer = idCustomer;
        this.idArea = idArea;
        this.nameCustomer = nameCustomer;
        this.shopCustomer = shopCustomer;
        this.numberCustomer = numberCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getShopCustomer() {
        return shopCustomer;
    }

    public void setShopCustomer(String shopCustomer) {
        this.shopCustomer = shopCustomer;
    }

    public String getNumberCustomer() {
        return numberCustomer;
    }

    public void setNumberCustomer(String numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

}