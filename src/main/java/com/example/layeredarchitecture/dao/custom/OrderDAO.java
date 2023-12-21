package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<OrderDTO> {

    ResultSet generateNewId() throws SQLException, ClassNotFoundException;
    void selectOrderId(String orderId) throws SQLException, ClassNotFoundException;
    boolean saveOrder(String orderId, LocalDate date, String customerId) throws SQLException, ClassNotFoundException;
}

