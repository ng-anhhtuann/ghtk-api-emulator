package com.example.GHTK.Repository;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.UserRight.Order;

import java.sql.SQLException;

public interface RepoManager {
    Object insert(Area area) throws SQLException;

    Object insert(Service service) throws SQLException;

    Object insert(TimeLine timeLine) throws SQLException;

    Object insert(Type type) throws SQLException;

    Object queryArea();

    Object queryAreaById(String idArea);

    Object queryTime();

    Object queryTimeById(String id);

    Object queryService();

    Object queryServiceById(String id);

    Object queryType();

    Object queryTypeById(String id);

    Object queryCustomer();

    Object queryCustomerById(String id);

    Object queryShipper();

    Object queryShipperById(String id);

    Object queryOrder();

    Object queryOrderByIdOrder(String idOrder);

    Object queryAllOrderByIdCustomer(String idshopOrder);

    Object queryAllOrderByIdShipper(String idshipperOrder);

    Object queryAllOrderNotApproved();

    Object queryAllOrderApproved();

    Object approveAllOrder();

    Object approveOneOrder(String id);

    Object createOrder(Order order) throws SQLException;

    Object updateAddressCustomer(String id, String newAddress);

    Object updateNameShopCustomer(String id, String newNameShop);

    Object updateNameCustomer(String id, String newNameCustomer);

    Object updateAreaCustomer(String id, String newArea);

    Object updateNumberCustomer(String id, String newNumber);

    Object updateMailCustomer(String id, String newMail);

    Object queryAllOrderAvailable();

    Object registerOrder(String idOrder, String idShipper);

    Object updateAddressShipper(String id, String newAddress);

    Object updateNameShipper(String id, String newNameCustomer);

    Object updateNumberShipper(String id, String newNumber);

    Object updateMailShipper(String id, String newMail);
}
