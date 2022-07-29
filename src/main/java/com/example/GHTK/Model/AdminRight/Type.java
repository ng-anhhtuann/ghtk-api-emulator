package com.example.GHTK.Model.AdminRight;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Type {

    @SerializedName("nameProduct")
    @Expose
    private String nameProduct;
    public Type(){}

    @Override
    public String toString() {
        return "Type{" +
                "nameProduct='" + nameProduct + '\'' +
                '}';
    }

    public Type(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

}