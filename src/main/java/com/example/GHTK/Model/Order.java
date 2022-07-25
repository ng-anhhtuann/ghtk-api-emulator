package com.example.GHTK.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Order {

    @SerializedName("idDeliver")
    @Expose
    private String idDeliver;
    @SerializedName("nameOrder")
    @Expose
    private String nameOrder;
    @SerializedName("amountOrder")
    @Expose
    private int amountOrder;
    @SerializedName("weightOrder")
    @Expose
    private float weightOrder;
    @SerializedName("idProduct")
    @Expose
    private String idProduct;
    @SerializedName("priceOrder")
    @Expose
    private int priceOrder;

    @Override
    public String toString() {
        return "Order{" +
                "idDeliver='" + idDeliver + '\'' +
                ", nameOrder='" + nameOrder + '\'' +
                ", amountOrder=" + amountOrder +
                ", weightOrder=" + weightOrder +
                ", idProduct='" + idProduct + '\'' +
                ", priceOrder=" + priceOrder +
                '}';
    }

    public Order(String idDeliver, String nameOrder, int amountOrder, float weightOrder, String idProduct, int priceOrder) {
        this.idDeliver = idDeliver;
        this.nameOrder = nameOrder;
        this.amountOrder = amountOrder;
        this.weightOrder = weightOrder;
        this.idProduct = idProduct;
        this.priceOrder = priceOrder;
    }

    public String getIdDeliver() {
        return idDeliver;
    }

    public void setIdDeliver(String idDeliver) {
        this.idDeliver = idDeliver;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public int getAmountOrder() {
        return amountOrder;
    }

    public void setAmountOrder(int amountOrder) {
        this.amountOrder = amountOrder;
    }

    public float getWeightOrder() {
        return weightOrder;
    }

    public void setWeightOrder(float weightOrder) {
        this.weightOrder = weightOrder;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public int getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(int priceOrder) {
        this.priceOrder = priceOrder;
    }

}