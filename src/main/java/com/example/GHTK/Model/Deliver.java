package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deliver {

    @SerializedName("idDeliver")
    @Expose
    private String idDeliver;
    @SerializedName("idCustomer")
    @Expose
    private String idCustomer;
    @SerializedName("idShipper")
    @Expose
    private String idShipper;
    @SerializedName("idService")
    @Expose
    private String idService;
    @SerializedName("idArea")
    @Expose
    private String idArea;
    @SerializedName("nameReceiver")
    @Expose
    private String nameReceiver;
    @SerializedName("addressDeliver")
    @Expose
    private String addressDeliver;
    @SerializedName("numberReceiver")
    @Expose
    private String numberReceiver;
    @SerializedName("idTimeDeliver")
    @Expose
    private String idTimeDeliver;
    @SerializedName("dateDeliver")
    @Expose
    private String dateDeliver;
    @SerializedName("paymentDeliver")
    @Expose
    private boolean paymentDeliver;
    @SerializedName("statusConfirm")
    @Expose
    private boolean statusConfirm;
    @SerializedName("statusDeliver")
    @Expose
    private boolean statusDeliver;

    public String getIdDeliver() {
        return idDeliver;
    }

    public void setIdDeliver(String idDeliver) {
        this.idDeliver = idDeliver;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdShipper() {
        return idShipper;
    }

    public void setIdShipper(String idShipper) {
        this.idShipper = idShipper;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getAddressDeliver() {
        return addressDeliver;
    }

    public void setAddressDeliver(String addressDeliver) {
        this.addressDeliver = addressDeliver;
    }

    public String getNumberReceiver() {
        return numberReceiver;
    }

    public void setNumberReceiver(String numberReceiver) {
        this.numberReceiver = numberReceiver;
    }

    public String getIdTimeDeliver() {
        return idTimeDeliver;
    }

    public void setIdTimeDeliver(String idTimeDeliver) {
        this.idTimeDeliver = idTimeDeliver;
    }

    public String getDateDeliver() {
        return dateDeliver;
    }

    public void setDateDeliver(String dateDeliver) {
        this.dateDeliver = dateDeliver;
    }

    public boolean isPaymentDeliver() {
        return paymentDeliver;
    }

    public void setPaymentDeliver(boolean paymentDeliver) {
        this.paymentDeliver = paymentDeliver;
    }

    public boolean isStatusConfirm() {
        return statusConfirm;
    }

    public void setStatusConfirm(boolean statusConfirm) {
        this.statusConfirm = statusConfirm;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "idDeliver='" + idDeliver + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idShipper='" + idShipper + '\'' +
                ", idService='" + idService + '\'' +
                ", idArea='" + idArea + '\'' +
                ", nameReceiver='" + nameReceiver + '\'' +
                ", addressDeliver='" + addressDeliver + '\'' +
                ", numberReceiver='" + numberReceiver + '\'' +
                ", idTimeDeliver='" + idTimeDeliver + '\'' +
                ", dateDeliver='" + dateDeliver + '\'' +
                ", paymentDeliver=" + paymentDeliver +
                ", statusConfirm=" + statusConfirm +
                ", statusDeliver=" + statusDeliver +
                '}';
    }

    public Deliver(String idDeliver, String idCustomer, String idShipper, String idService, String idArea, String nameReceiver, String addressDeliver, String numberReceiver, String idTimeDeliver, String dateDeliver, boolean paymentDeliver, boolean statusConfirm, boolean statusDeliver) {
        this.idDeliver = idDeliver;
        this.idCustomer = idCustomer;
        this.idShipper = idShipper;
        this.idService = idService;
        this.idArea = idArea;
        this.nameReceiver = nameReceiver;
        this.addressDeliver = addressDeliver;
        this.numberReceiver = numberReceiver;
        this.idTimeDeliver = idTimeDeliver;
        this.dateDeliver = dateDeliver;
        this.paymentDeliver = paymentDeliver;
        this.statusConfirm = statusConfirm;
        this.statusDeliver = statusDeliver;
    }

    public boolean isStatusDeliver() {
        return statusDeliver;
    }

    public void setStatusDeliver(boolean statusDeliver) {
        this.statusDeliver = statusDeliver;
    }

}