package com.example.layeredarchitecture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {

    ResultSet generateNewOrderId() throws SQLException, ClassNotFoundException;
    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
    boolean saveOrder(String orderId, LocalDate date, String customerId) throws SQLException, ClassNotFoundException;
}

