package com.example.GHTK.Repository.Repository;

import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Repository.Manager.ShipperManager;
import com.example.GHTK.Ultilities.Database;
import com.example.GHTK.Ultilities.ValidateMail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShipperRepository implements ShipperManager {
    private static final Database database = Database.getDatabase();
    private static final Connection connection = database.getConnection();

    public static ShipperRepository repository;

    public static ShipperRepository getRepository() {
        if (repository == null) {
            repository = new ShipperRepository();
        }
        return repository;
    }

    @Override
    public Object queryAllOrderAvailable() {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.types as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.isAvailable = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object queryAllOrderByIdShipper(String id) {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.nameShop as nameShop, B.numberCustomer as numberShop\n" +
                "\t, B.addressCustomer as addressShop , A.daysendOrder as daysendOrder\n" +
                "    , A.nameReceiver as nameReceiver, A.numberReceiver as numberReceiver\n" +
                "    , A.addressReceiver as addressReceiver, D.nameShipper as nameShipper\n" +
                "    , D.numberShipper as numberShipper, A.nameOrder as nameOrder\n" +
                "    , A.costOrder as costOrder, F.nameType as typeOrder\n" +
                "    , E.descriptionTime as descriptionTime, C.nameService as nameService\n" +
                "    , A.approveOrder as approveOrder, A.statusDeliver as statusDeliver, A.isAvailable as isAvailable\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.types as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.idshipperOrder = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("nameShop"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daysendOrder"),
                        resultSet.getString("nameReceiver"),
                        resultSet.getString("numberReceiver"),
                        resultSet.getString("addressReceiver"),
                        resultSet.getString("nameShipper"),
                        resultSet.getString("numberShipper"),
                        resultSet.getString("nameOrder"),
                        resultSet.getInt("costOrder"),
                        resultSet.getString("nameType"),
                        resultSet.getString("descriptionTime"),
                        resultSet.getString("nameService"),
                        resultSet.getBoolean("approveOrder"),
                        resultSet.getBoolean("statusDeliver"),
                        resultSet.getBoolean("isAvailable"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object registerOrder(String idOrder, String idShipper) {
        Object object = null;
        String checkAvailable = "SELECT isAvailable FROM GHTK.orders WHERE idOrder = '" + idOrder + "';";
        String register = "UPDATE GHTK.orders as A\n" +
                "SET A.idshipperOrder = '" + idShipper + "' \n" +
                "WHERE A.idOrder = '" + idOrder + "';";

        try {
            PreparedStatement checkStatement = connection.prepareStatement(checkAvailable);
            ResultSet set = checkStatement.executeQuery();
            int isAvailable = set.getInt(1);
            if (isAvailable == 1) {
                PreparedStatement takeStatement = connection.prepareStatement(register);
                int row = takeStatement.executeUpdate();
                if (row != 0) {
                    object = new Response(true, "Order: " + idOrder + "is taken by shipper: " + idShipper);
                } else {
                    object = new Response(false, "No order with id: " + idOrder);
                }
            } else {
                object = new Response(false, "Order: " + idOrder + " was taken before :(");
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }

        return object;
    }

    @Override
    public Object updateAddressShipper(String id, String newAddress) {
        Object object = null;
        String update = "UPDATE GHTK.shippers as A\n" +
                "SET A.addressShipper = '" + newAddress + "' \n" +
                "WHERE A.idShipper = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "Address is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNameShipper(String id, String newNameShipper) {
        Object object = null;
        String update = "UPDATE GHTK.shippers as A\n" +
                "SET A.nameShipper = '" + newNameShipper + "' \n" +
                "WHERE A.idShipper = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "Name Shipper is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNumberShipper(String id, String newNumber) {
        Object object = null;
        String update = "UPDATE GHTK.shippers as A\n" +
                "SET A.numberShipper = '" + newNumber + "' \n" +
                "WHERE A.idShipper = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "Number is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateMailShipper(String id, String newMail) {
        Object object = null;

        String update = "UPDATE GHTK.shippers as A\n" +
                "SET A.mailShipper = '" + newMail + "' \n" +
                "WHERE A.idShipper = '" + id + "';";

        if (ValidateMail.validate(newMail)) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(update);
                int rowsEffected = preparedStatement.executeUpdate();
                if (rowsEffected != 0) {
                    object = new Response(true, "Mail is updated for user " + id);
                } else {
                    object = new Response(false, "Unknown id :" + id);
                }
            } catch (SQLException e) {
                object = new Response(false, e.getMessage());
            }
        } else {
            object = new Response(false, "Invalid mail format!");
        }

        return object;
    }
}
