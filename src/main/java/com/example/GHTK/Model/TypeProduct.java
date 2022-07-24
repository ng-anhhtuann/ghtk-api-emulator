package com.example.GHTK.Model;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TypeProduct {

    @SerializedName("idProduct")
    @Expose
    private String idProduct;
    @SerializedName("nameProduct")
    @Expose
    private String nameProduct;

    public String getIdProduct() {
        return idProduct;
    }

    @Override
    public String toString() {
        return "TypeProduct{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                '}';
    }

    public TypeProduct(String idProduct, String nameProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

}