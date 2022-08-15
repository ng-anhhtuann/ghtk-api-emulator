package com.example.GHTK.Repository.Manager;

import com.example.GHTK.Model.AdminRight.Area;
import com.example.GHTK.Model.AdminRight.Service;
import com.example.GHTK.Model.AdminRight.TimeLine;
import com.example.GHTK.Model.AdminRight.Type;
import com.example.GHTK.Model.UserRight.Order;

import java.sql.SQLException;

public interface AdminManager {
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

}
