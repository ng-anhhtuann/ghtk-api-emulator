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
    public Object queryAllOrderByIdCustomer(String id_shop_order) {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numberShop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.nameType as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.id_shop_order = '" + id_shop_order + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numberShop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("nameType"),
                        resultSet.getString("description_time"),
                        resultSet.getString("name_service"),
                        resultSet.getBoolean("approve_order"),
                        resultSet.getBoolean("status_deliver_order"),
                        resultSet.getBoolean("available_order"));
                orderDetailsList.add(orderDetails);
            }
            object = new Response(true, orderDetailsList);
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object createOrder(String id, Order order) throws SQLException {
        Object object = null;
        if (order == null) {
            object = new Response(false, "We dont accept null information here");
        }

        String insert = "INSERT INTO GHTK.orders(id_order, id_shop_order, id_shipper_order, id_service_order," +
                "id_type_order, id_time_order, daytime_order, name_order, weight_order, cost_order," +
                "name_receiver_order, number_receiver_order, address_receiver_order, payment_order, approve_order," +
                "status_deliver_order, available_order) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String timecreated = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH").format(new Date());

        String lastRecord = "SELECT id_order FROM GHTK.orders ORDER BY id_order DESC LIMIT 1;";
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
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, order.getIdserviceOrder());
            preparedStatement.setString(5, order.getIdtypeOrder());
            preparedStatement.setString(6, order.getIdtimeOrder());
            preparedStatement.setString(7, timecreated);
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
        String update = "UPDATE GHTK.customers as A\n" +
                "SET A.address_customer = '" + newAddress + "' \n" +
                "WHERE A.id_customer = '" + id + "';";
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
    public Object updateNameShopCustomer(String id, String newname_shop_customer) {
        Object object = null;
        String update = "UPDATE GHTK.customers as A\n" +
                "SET A.name_shop_customer = '" + newname_shop_customer + "' \n" +
                "WHERE A.id_customer = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            int rowsEffected = preparedStatement.executeUpdate();
            if (rowsEffected != 0) {
                object = new Response(true, "name_shop_customer is updated for user " + id);
            } else {
                object = new Response(false, "Unknown id :" + id);
            }
        } catch (SQLException e) {
            object = new Response(false, e.getMessage());
        }
        return object;
    }

    @Override
    public Object updateNameCustomer(String id, String newname_customer) {
        Object object = null;
        String update = "UPDATE GHTK.customers as A\n" +
                "SET A.name_customer = '" + newname_customer + "' \n" +
                "WHERE A.id_customer = '" + id + "';";
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
        String update = "UPDATE GHTK.customers as A\n" +
                "SET A.area_customer = '" + newArea + "' \n" +
                "WHERE A.id_customer = '" + id + "';";
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
        String update = "UPDATE GHTK.customers as A\n" +
                "SET A.number_customer = '" + newNumber + "' \n" +
                "WHERE A.id_customer = '" + id + "';";
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

        String update = "UPDATE GHTK.customers as A\n" +
                "SET A.mailCustomer = '" + newMail + "' \n" +
                "WHERE A.id_customer = '" + id + "';";

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
