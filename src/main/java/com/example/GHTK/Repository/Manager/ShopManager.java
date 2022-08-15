package com.example.GHTK.Repository.Manager;

import com.example.GHTK.Model.UserRight.Order;

import java.sql.SQLException;

public interface ShopManager {
    Object createOrder(Order order) throws SQLException;

    Object updateAddressCustomer(String id, String newAddress);

    Object updateNameShopCustomer(String id, String newNameShop);

    Object updateNameCustomer(String id, String newNameCustomer);

    Object updateAreaCustomer(String id, String newArea);

    Object updateNumberCustomer(String id, String newNumber);

    Object updateMailCustomer(String id, String newMail);

    Object queryAllOrderByIdCustomer(String id);
}
