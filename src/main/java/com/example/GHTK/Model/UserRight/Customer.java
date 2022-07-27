
package com.example.GHTK.Model.UserRight;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("idCustomer")
    @Expose
    private String idCustomer;
    @SerializedName("nameCustomer")
    @Expose
    private String nameCustomer;
    @SerializedName("nameShop")
    @Expose
    private String nameShop;
    @SerializedName("idArea")
    @Expose
    private String idArea;
    @SerializedName("areaCustomer")
    @Expose
    private String areaCustomer;
    @SerializedName("numberCustomer")
    @Expose
    private String numberCustomer;
    @SerializedName("addressCustomer")
    @Expose
    private String addressCustomer;
    @SerializedName("mailCustomer")
    @Expose
    private String mailCustomer;
    @SerializedName("taxCodeCustomer")
    @Expose
    private String taxCodeCustomer;

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", nameShop='" + nameShop + '\'' +
                ", idArea='" + idArea + '\'' +
                ", areaCustomer='" + areaCustomer + '\'' +
                ", numberCustomer='" + numberCustomer + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                ", mailCustomer='" + mailCustomer + '\'' +
                ", taxCodeCustomer='" + taxCodeCustomer + '\'' +
                '}';
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getAreaCustomer() {
        return areaCustomer;
    }

    public void setAreaCustomer(String areaCustomer) {
        this.areaCustomer = areaCustomer;
    }

    public String getNumberCustomer() {
        return numberCustomer;
    }

    public void setNumberCustomer(String numberCustomer) {
        this.numberCustomer = numberCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getMailCustomer() {
        return mailCustomer;
    }

    public void setMailCustomer(String mailCustomer) {
        this.mailCustomer = mailCustomer;
    }

    public String getTaxCodeCustomer() {
        return taxCodeCustomer;
    }

    public void setTaxCodeCustomer(String taxCodeCustomer) {
        this.taxCodeCustomer = taxCodeCustomer;
    }

    public Customer(String idCustomer, String nameCustomer, String nameShop, String idArea, String areaCustomer, String numberCustomer, String addressCustomer, String mailCustomer, String taxCodeCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.nameShop = nameShop;
        this.idArea = idArea;
        this.areaCustomer = areaCustomer;
        this.numberCustomer = numberCustomer;
        this.addressCustomer = addressCustomer;
        this.mailCustomer = mailCustomer;
        this.taxCodeCustomer = taxCodeCustomer;
    }
}