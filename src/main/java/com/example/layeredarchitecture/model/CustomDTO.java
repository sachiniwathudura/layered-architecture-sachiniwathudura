package com.example.layeredarchitecture.model;


import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomDTO {

    private String id;
    private String name;
    private String orderId;
    private LocalDate orderDate;
    private BigDecimal orderTotal;

    public CustomDTO( String id, String name, String orderId, LocalDate orderDate,   BigDecimal orderTotal) {
        this.id = id;
        this.name = name;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString(){
        return "CustomDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", order Id='" + orderId + '\'' +
                ",date ="+orderDate+'\''+
                "Total ="+orderTotal+'\''+
                '}';
    }

}
