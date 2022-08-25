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

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numbershop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper_order\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.available_order = 1;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numbershop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
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
    public Object queryAllOrderByIdShipper(String id) {
        Object object = null;
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String query = "SELECT B.name_shop_customer as name_shop_customer, B.number_customer as numbershop\n" +
                "\t, B.address_customer as addressShop , A.daytime_order as daytime_order\n" +
                "    , A.name_receiver_order as name_receiver_order, A.number_receiver_order as number_receiver_order\n" +
                "    , A.address_receiver_order as address_receiver_order, D.name_shipper as name_shipper\n" +
                "    , D.number_shipper as number_shipper, A.name_order as name_order\n" +
                "    , A.cost_order as cost_order, F.name_type as typeOrder\n" +
                "    , E.description_time as description_time, C.name_service as name_service\n" +
                "    , A.approve_order as approve_order, A.status_deliver_order as status_deliver_order, A.available_order as available_order\n" +
                "   FROM GHTK.orders as A INNER JOIN GHTK.customers as B ON A.id_shop_order = B.id_customer\n" +
                "\t\t\t\t\t INNER JOIN GHTK.services as C ON A.id_service_order = C.id_service\n" +
                "                     INNER JOIN GHTK.shippers as D ON A.id_shipper_order = D.id_shipper_order\n" +
                "                     INNER JOIN GHTK.timeline as E ON A.id_time_order = E.id_time\n" +
                "                     INNER JOIN GHTK.types as F ON A.id_type_order = F.id_type" +
                "   WHERE A.id_shipper_order = '" + id + "';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                OrderDetails orderDetails = new OrderDetails(resultSet.getString("name_shop_customer"),
                        resultSet.getString("numbershop"),
                        resultSet.getString("addressShop"),
                        resultSet.getString("daytime_order"),
                        resultSet.getString("name_receiver_order"),
                        resultSet.getString("number_receiver_order"),
                        resultSet.getString("address_receiver_order"),
                        resultSet.getString("name_shipper"),
                        resultSet.getString("number_shipper"),
                        resultSet.getString("name_order"),
                        resultSet.getInt("cost_order"),
                        resultSet.getString("name_type"),
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
    public Object registerOrder(String id_order, String id_shipper_order) {
        Object object = null;
        String checkAvailable = "SELECT available_order FROM GHTK.orders WHERE id_order = '" + id_order + "';";
        String register = "UPDATE GHTK.orders as A\n" +
                "SET A.id_shipper_order = '" + id_shipper_order + "' \n" +
                "WHERE A.id_order = '" + id_order + "';";

        try {
            PreparedStatement checkStatement = connection.prepareStatement(checkAvailable);
            ResultSet set = checkStatement.executeQuery();
            int available_order = set.getInt(1);
            if (available_order == 1) {
                PreparedStatement takeStatement = connection.prepareStatement(register);
                int row = takeStatement.executeUpdate();
                if (row != 0) {
                    object = new Response(true, "Order: " + id_order + "is taken by shipper: " + id_shipper_order);
                } else {
                    object = new Response(false, "No order with id: " + id_order);
                }
            } else {
                object = new Response(false, "Order: " + id_order + " was taken before :(");
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
                "SET A.address_shipper = '" + newAddress + "' \n" +
                "WHERE A.id_shipper_order = '" + id + "';";
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
    public Object updateNameShipper(String id, String newname_shipper) {
        Object object = null;
        String update = "UPDATE GHTK.shippers as A\n" +
                "SET A.name_shipper = '" + newname_shipper + "' \n" +
                "WHERE A.id_shipper_order = '" + id + "';";
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
                "SET A.number_shipper = '" + newNumber + "' \n" +
                "WHERE A.id_shipper_order = '" + id + "';";
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
                "SET A.mail_shipper = '" + newMail + "' \n" +
                "WHERE A.id_shipper_order = '" + id + "';";

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
