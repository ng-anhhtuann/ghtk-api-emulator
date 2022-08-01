package com.example.GHTK.Model.Custom;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderDetails {
    @SerializedName("nameShop")
    @Expose
    public String nameShop;
    @SerializedName("numberShop")
    @Expose
    public String numberShop;
    @SerializedName("addressShop")
    @Expose
    public String addressShop;
    @SerializedName("daySendOrder")
    @Expose
    public String daySendOrder;
    @SerializedName("nameReceiver")
    @Expose
    public String nameReceiver;
    @SerializedName("numberReceiver")
    @Expose
    public String numberReceiver;
    @SerializedName("addressReceiver")
    @Expose
    public String addressReceiver;
    @SerializedName("nameShipper")
    @Expose
    public String nameShipper;
    @SerializedName("numberShipper")
    @Expose
    public String numberShipper;
    @SerializedName("nameOrder")
    @Expose
    public String nameOrder;
    @SerializedName("costOrder")
    @Expose
    public int costOrder;
    @SerializedName("typeOrder")
    @Expose
    public String typeOrder;
    @SerializedName("timeOrder")
    @Expose
    public String timeOrder;
    @SerializedName("serviceOrder")
    @Expose
    public String serviceOrder;
    @SerializedName("approveOrder")
    @Expose
    public boolean approveOrder;
    @SerializedName("isAvailable")
    @Expose
    public boolean isAvailable;
    @SerializedName("statusDeliver")
    @Expose
    public boolean statusDeliver;



    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getNumberShop() {
        return numberShop;
    }

    public void setNumberShop(String numberShop) {
        this.numberShop = numberShop;
    }

    public String getAddressShop() {
        return addressShop;
    }

    public void setAddressShop(String addressShop) {
        this.addressShop = addressShop;
    }

    public String getDaySendOrder() {
        return daySendOrder;
    }

    public void setDaySendOrder(String daySendOrder) {
        this.daySendOrder = daySendOrder;
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

    public String getNameShipper() {
        return nameShipper;
    }

    public void setNameShipper(String nameShipper) {
        this.nameShipper = nameShipper;
    }

    public String getNumberShipper() {
        return numberShipper;
    }

    public void setNumberShipper(String numberShipper) {
        this.numberShipper = numberShipper;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public int getCostOrder() {
        return costOrder;
    }

    public void setCostOrder(int costOrder) {
        this.costOrder = costOrder;
    }

    public String getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(String typeOrder) {
        this.typeOrder = typeOrder;
    }

    public String getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(String timeOrder) {
        this.timeOrder = timeOrder;
    }

    public String getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(String serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean Available) {
        isAvailable = Available;
    }

    public boolean isStatusDeliver() {
        return statusDeliver;
    }

    public void setStatusDeliver(boolean statusDeliver) {
        this.statusDeliver = statusDeliver;
    }

    public boolean isApproveOrder() {
        return approveOrder;
    }

    public void setApproveOrder(boolean approveOrder) {
        this.approveOrder = approveOrder;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "nameShop='" + nameShop + '\'' +
                ", numberShop='" + numberShop + '\'' +
                ", addressShop='" + addressShop + '\'' +
                ", daySendOrder='" + daySendOrder + '\'' +
                ", nameReceiver='" + nameReceiver + '\'' +
                ", numberReceiver='" + numberReceiver + '\'' +
                ", addressReceiver='" + addressReceiver + '\'' +
                ", nameShipper='" + nameShipper + '\'' +
                ", numberShipper='" + numberShipper + '\'' +
                ", nameOrder='" + nameOrder + '\'' +
                ", costOrder=" + costOrder +
                ", typeOrder='" + typeOrder + '\'' +
                ", timeOrder='" + timeOrder + '\'' +
                ", serviceOrder='" + serviceOrder + '\'' +
                ", approveOrder=" + approveOrder +
                ", isAvailable=" + isAvailable +
                ", statusDeliver=" + statusDeliver +
                '}';
    }

    public OrderDetails(String nameShop, String numberShop, String addressShop, String daySendOrder, String nameReceiver, String numberReceiver, String addressReceiver, String nameShipper, String numberShipper, String nameOrder, int costOrder, String typeOrder, String timeOrder, String serviceOrder, boolean approveOrder, boolean isAvailable, boolean statusDeliver) {
        this.nameShop = nameShop;
        this.numberShop = numberShop;
        this.addressShop = addressShop;
        this.daySendOrder = daySendOrder;
        this.nameReceiver = nameReceiver;
        this.numberReceiver = numberReceiver;
        this.addressReceiver = addressReceiver;
        this.nameShipper = nameShipper;
        this.numberShipper = numberShipper;
        this.nameOrder = nameOrder;
        this.costOrder = costOrder;
        this.typeOrder = typeOrder;
        this.timeOrder = timeOrder;
        this.serviceOrder = serviceOrder;
        this.approveOrder = approveOrder;
        this.isAvailable = isAvailable;
        this.statusDeliver = statusDeliver;
    }
}
