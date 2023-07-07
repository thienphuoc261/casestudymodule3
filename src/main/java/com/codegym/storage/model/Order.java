package com.codegym.storage.model;


public class Order {
    private int id;
    private int userId;
    private String orderDate;
    private String destination;
    private String message;
    private boolean isDelevered;
    private boolean isConfirmed;
    private boolean isDelete;
    private int totalPrice;


    public Order(int id, int userId, String orderDate, String destination, String message, boolean isDelevered,boolean isConfirmed, int totalPrice) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.destination = destination;
        this.message = message;
        this.isDelevered = isDelevered;
        this.isConfirmed = isConfirmed;
        this.isDelete = false;
        this.totalPrice = totalPrice;
    }

    public Order(int userId, String orderDate, String destination, String message, boolean isDelevered, int totalPrice) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.destination = destination;
        this.message = message;
        this.isDelevered = isDelevered;
        this.totalPrice = totalPrice;
    }

    public Order(int userId, String orderDate, String destination, String message, boolean isDelevered, boolean isConfirmed, int totalPrice) {
        this.userId = userId;
        this.orderDate = orderDate;
        this.destination = destination;
        this.message = message;
        this.isDelevered = isDelevered;
        this.isConfirmed = isConfirmed;
        this.totalPrice = totalPrice;
    }

    public Order(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean getIsDelevered() {
        return isDelevered;
    }

    public void setDelevered(boolean delevered) {
        isDelevered = delevered;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDelevered() {
        return isDelevered;
    }

    public boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
