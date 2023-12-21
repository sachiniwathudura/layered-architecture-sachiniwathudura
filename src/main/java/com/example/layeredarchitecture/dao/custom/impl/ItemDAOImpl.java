package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();

        ResultSet rst = stm.executeQuery("SELECT * FROM Item");*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");

        ArrayList<ItemDTO> allItem = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
        }


        return allItem;
    }



    @Override
   public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, dto.getCode());
        pstm.setString(2, dto.getDescription());
        pstm.setBigDecimal(3, dto.getUnitPrice());
        pstm.setInt(4, dto.getQtyOnHand());
        pstm.executeUpdate();
        return false;*/
      return SQLUtil
               .execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
        dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

   @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    @Override
    public void delete(String code) throws SQLException, ClassNotFoundException {
       // return
                SQLUtil.execute("DELETE FROM Item WHERE code=?");

    }

    @Override
    public boolean exsit(String code) throws SQLException, ClassNotFoundException {

      ResultSet rst=  SQLUtil.execute("SELECT code FROM Item WHERE code=?");
      return rst.next();
    }

    @Override
    public ResultSet generateNewId() throws SQLException, ClassNotFoundException {
       ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException {

        ResultSet rst =  SQLUtil.execute("SELECT * FROM Item WHERE code=?");
        rst.next();
        return new ItemDTO(
                rst.getString(1),
                rst.getString(2),
                rst.getBigDecimal(3),
                rst.getInt(4)
        );
    }

    @Override
    public ArrayList<ItemDTO> loadAllCodes() throws SQLException, ClassNotFoundException {

      ResultSet rst=  SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItemCodes = new ArrayList<>();

        while (rst.next()) {
            allItemCodes.add(new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getBigDecimal(3),
                    rst.getInt(4)
            ));
        }
        return allItemCodes;


    }
}


