package com.example.GHTK.Model.UserRight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {

    @SerializedName("idshopOrder")
    @Expose
    private String idshopOrder;
    @SerializedName("idserviceOrder")
    @Expose
    private String idserviceOrder;
    @SerializedName("idtypeOrder")
    @Expose
    private String idtypeOrder;
    @SerializedName("idtimeOrder")
    @Expose
    private String idtimeOrder;
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
    private boolean paymentOrder;           //0: banking ~ 1:cash


    public String getIdshopOrder() {
        return idshopOrder;
    }

    public void setIdshopOrder(String idshopOrder) {
        this.idshopOrder = idshopOrder;
    }

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

    @Override
    public String toString() {
        return "Order{" +
                "idshopOrder='" + idshopOrder + '\'' +
                ", idserviceOrder='" + idserviceOrder + '\'' +
                ", idtypeOrder='" + idtypeOrder + '\'' +
                ", idtimeOrder='" + idtimeOrder + '\'' +
                ", nameOrder='" + nameOrder + '\'' +
                ", weightOrder=" + weightOrder +
                ", costOrder=" + costOrder +
                ", nameReceiver='" + nameReceiver + '\'' +
                ", numberReceiver='" + numberReceiver + '\'' +
                ", addressReceiver='" + addressReceiver + '\'' +
                ", paymentOrder=" + paymentOrder +
                '}';
    }

    public Order(String idshopOrder, String idserviceOrder, String idtypeOrder, String idtimeOrder, String nameOrder, float weightOrder, int costOrder, String nameReceiver, String numberReceiver, String addressReceiver, boolean paymentOrder) {
        this.idshopOrder = idshopOrder;
        this.idserviceOrder = idserviceOrder;
        this.idtypeOrder = idtypeOrder;
        this.idtimeOrder = idtimeOrder;
        this.nameOrder = nameOrder;
        this.weightOrder = weightOrder;
        this.costOrder = costOrder;
        this.nameReceiver = nameReceiver;
        this.numberReceiver = numberReceiver;
        this.addressReceiver = addressReceiver;
        this.paymentOrder = paymentOrder;
    }
}