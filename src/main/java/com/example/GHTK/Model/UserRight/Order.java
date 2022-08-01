package com.example.GHTK.Model.UserRight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("idOrder")
    @Expose
    private String idOrder;
    @SerializedName("idshopOrder")
    @Expose
    private String idshopOrder;
    //    @SerializedName("idshipperOrder")
//    @Expose
//    private String idshipperOrder;
    @SerializedName("idserviceOrder")
    @Expose
    private String idserviceOrder;
    @SerializedName("idtypeOrder")
    @Expose
    private String idtypeOrder;
    @SerializedName("idtimeOrder")
    @Expose
    private String idtimeOrder;
    @SerializedName("daysendOrder")
    @Expose
    private String daysendOrder;
    @SerializedName("nameOrder")
    @Expose
    private String nameOrder;
    @SerializedName("weightOrder")
    @Expose
    private float weightOrder;
    @SerializedName("costOrder")
    @Expose
    private int costOrder;
    @SerializedName("nameReceiver")
    @Expose
    private String nameReceiver;
    @SerializedName("numberReceiver")
    @Expose
    private String numberReceiver;
    @SerializedName("addressReceiver")
    @Expose
    private String addressReceiver;
    @SerializedName("paymentOrder")
    @Expose
    private boolean paymentOrder;

    @Override
    public String toString() {
        return "{" +
                "idOrder='" + idOrder + '\'' +
                ", idshopOrder='" + idshopOrder + '\'' +
                ", idserviceOrder='" + idserviceOrder + '\'' +
                ", idtypeOrder='" + idtypeOrder + '\'' +
                ", idtimeOrder='" + idtimeOrder + '\'' +
                ", daysendOrder='" + daysendOrder + '\'' +
                ", nameOrder='" + nameOrder + '\'' +
                ", weightOrder=" + weightOrder +
                ", costOrder=" + costOrder +
                ", nameReceiver='" + nameReceiver + '\'' +
                ", numberReceiver='" + numberReceiver + '\'' +
                ", addressReceiver='" + addressReceiver + '\'' +
                ", paymentOrder=" + paymentOrder +
                '}';
    }
//    @SerializedName("approveOrder")
//    @Expose
//    private boolean approveOrder;
//    @SerializedName("statusDeliver")
//    @Expose
//    private boolean statusDeliver;
//    @SerializedName("isAvailable")
//    @Expose
//    private boolean isAvailable;

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdshopOrder() {
        return idshopOrder;
    }

    public void setIdshopOrder(String idshopOrder) {
        this.idshopOrder = idshopOrder;
    }

//    public String getIdshipperOrder() {
//        return idshipperOrder;
//    }
//
//    public void setIdshipperOrder(String idshipperOrder) {
//        this.idshipperOrder = idshipperOrder;
//    }

    public String getIdserviceOrder() {
        return idserviceOrder;
    }

    public void setIdserviceOrder(String idserviceOrder) {
        this.idserviceOrder = idserviceOrder;
    }

    public String getIdtypeOrder() {
        return idtypeOrder;
    }

    public void setIdtypeOrder(String idtypeOrder) {
        this.idtypeOrder = idtypeOrder;
    }

    public String getIdtimeOrder() {
        return idtimeOrder;
    }

    public void setIdtimeOrder(String idtimeOrder) {
        this.idtimeOrder = idtimeOrder;
    }

    public String getDaysendOrder() {
        return daysendOrder;
    }

    public void setDaysendOrder(String daysendOrder) {
        this.daysendOrder = daysendOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public float getWeightOrder() {
        return weightOrder;
    }

    public void setWeightOrder(float weightOrder) {
        this.weightOrder = weightOrder;
    }

    public int getCostOrder() {
        return costOrder;
    }

    public void setCostOrder(int costOrder) {
        this.costOrder = costOrder;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getNumberReceiver() {
        return numberReceiver;
    }

    public void setNumberReceiver(String numberReceiver) {
        this.numberReceiver = numberReceiver;
    }

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(String addressReceiver) {
        this.addressReceiver = addressReceiver;
    }

    public boolean isPaymentOrder() {
        return paymentOrder;
    }

    public void setPaymentOrder(boolean paymentOrder) {
        this.paymentOrder = paymentOrder;
    }


    public Order(String idOrder, String idshopOrder, String idserviceOrder, String idtypeOrder, String idtimeOrder, String daysendOrder, String nameOrder, float weightOrder, int costOrder, String nameReceiver, String numberReceiver, String addressReceiver, boolean paymentOrder) {
        this.idOrder = idOrder;
        this.idshopOrder = idshopOrder;
        this.idserviceOrder = idserviceOrder;
        this.idtypeOrder = idtypeOrder;
        this.idtimeOrder = idtimeOrder;
        this.daysendOrder = daysendOrder;
        this.nameOrder = nameOrder;
        this.weightOrder = weightOrder;
        this.costOrder = costOrder;
        this.nameReceiver = nameReceiver;
        this.numberReceiver = numberReceiver;
        this.addressReceiver = addressReceiver;
        this.paymentOrder = paymentOrder;
    }
}