package com.example.GHTK.Repository.Repository;

import com.example.GHTK.Model.Custom.OrderDetails;
import com.example.GHTK.Model.Status.Response;
import com.example.GHTK.Model.UserRight.Order;
import com.example.GHTK.Repository.Manager.ShopManager;
import com.example.GHTK.Ultilities.Database;
import com.example.GHTK.Ultilities.ValidateMail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopRepository implements ShopManager {
    private static final Database database = Database.getDatabase();
    private static final Connection connection = database.getConnection();

    public static ShopRepository repository;

    public static ShopRepository getRepository() {
        if (repository == null) {
            repository = new ShopRepository();
        }
        return repository;
    }

    @Override
    public Object queryAllOrderByIdCustomer(String idshopOrder) {
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
                "   FROM GHTK.Order as A INNER JOIN GHTK.Customer as B ON A.idshopOrder = B.idCustomer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.Service as C ON A.idserviceOrder = C.idService\n" +
                "                     INNER JOIN GHTK.Shipper as D ON A.idshipperOrder = D.idShipper\n" +
                "                     INNER JOIN GHTK.Time as E ON A.idtimeOrder = E.idTime\n" +
                "                     INNER JOIN GHTK.Type as F ON A.idtypeOrder = F.idType" +
                "   WHERE A.idshopOrder = '" + idshopOrder + "';";
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
    public Object createOrder(Order order) throws SQLException {
        Object object = null;
        if (order == null) {
            object = new Response(false, "We dont accept null information here");
        }

        String insert = "INSERT INTO GHTK.Order(idOrder, idshopOrder, idshipperOrder, idserviceOrder," +
                "idtypeOrder, idtimeOrder, daysendOrder, nameOrder, weightOrder, costOrder," +
                "nameReceiver, numberReceiver, addressReceiver, paymentOrder, approveOrder," +
                "statusDeliver, isAvailable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String timeCreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String lastRecord = "SELECT idOrder FROM GHTK.Order ORDER BY idOrder DESC LIMIT 1;";
        PreparedStatement lastRecordPS = connection.prepareStatement(lastRecord);
        ResultSet resultLastRecord = lastRecordPS.executeQuery();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
            if (resultLastRecord.next()) {
                String tempId = resultLastRecord.getString(1).replaceAll("[a-zA-Z]+", "");
                Integer num = Integer.parseInt(tempId) + 1;

                preparedStatement.setString(1, "DH" + num);
            } else {
                preparedStatement.setString(1, "DH1");
            }
            preparedStatement.setString(2, order.getIdshopOrder());
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, order.getIdserviceOrder());
            preparedStatement.setString(5, order.getIdtypeOrder());
            preparedStatement.setString(6, order.getIdtimeOrder());
            preparedStatement.setString(7, timeCreated);
            preparedStatement.setString(8, order.getNameOrder());
            preparedStatement.setDouble(9, order.getWeightOrder());
            preparedStatement.setInt(10, order.getCostOrder());
            preparedStatement.setString(11, order.getNameReceiver());
            preparedStatement.setString(12, order.getNumberReceiver());
            preparedStatement.setString(13, order.getAddressReceiver());
            preparedStatement.setBoolean(14, order.isPaymentOrder());
            preparedStatement.setBoolean(15, false);
            preparedStatement.setBoolean(16, false);
            preparedStatement.setBoolean(17, true);
            preparedStatement.executeUpdate();
            object = new Response(true, order);
        } catch (Exception e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateAddressCustomer(String id, String newAddress) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.addressCustomer = '" + newAddress + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
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
    public Object updateNameShopCustomer(String id, String newNameShop) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.nameShop = '" + newNameShop + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "NameShop is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNameCustomer(String id, String newNameCustomer) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.nameCustomer = '" + newNameCustomer + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "Name Customer is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateAreaCustomer(String id, String newArea) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.areaCustomer = '" + newArea + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "Area is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNumberCustomer(String id, String newNumber) {
        Object object = null;
        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.numberCustomer = '" + newNumber + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";
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
    public Object updateMailCustomer(String id, String newMail) {
        Object object = null;

        String update = "UPDATE GHTK.Customer as A\n" +
                "SET A.mailCustomer = '" + newMail + "' \n" +
                "WHERE A.idCustomer = '" + id + "';";

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
