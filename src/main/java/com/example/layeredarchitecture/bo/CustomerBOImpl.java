package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO= new CustomerDAOImpl();

   public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
        return customerDAO.save(dto);

   }
    public ArrayList<CustomerDTO> loadAllIds() throws SQLException,ClassNotFoundException{
       return customerDAO.loadAllIds();
    }
    public  boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
       return customerDAO.update(dto);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return null;
    }


    public CustomerDTO searchCutomer(String id) throws SQLException, ClassNotFoundException{
       return customerDAO.search(id);
    }
    public String generateNewId() throws SQLException, ClassNotFoundException{
       return customerDAO.generateNewId();
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        customerDAO.delete(id);
    }


    public boolean exsitCustomer(String id) throws SQLException, ClassNotFoundException{
       return customerDAO.exsit(id);
    }
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

}
