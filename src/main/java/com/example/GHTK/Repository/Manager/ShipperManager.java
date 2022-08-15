package com.example.GHTK.Repository.Manager;

public interface ShipperManager {
    Object queryAllOrderAvailable();

    Object queryAllOrderByIdShipper(String id);

    Object registerOrder(String idOrder, String idShipper);

    Object updateAddressShipper(String id, String newAddress);

    Object updateNameShipper(String id, String newNameCustomer);

    Object updateNumberShipper(String id, String newNumber);

    Object updateMailShipper(String id, String newMail);
}
