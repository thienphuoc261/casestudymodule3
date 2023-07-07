package com.codegym.storage.model;

public class OrderDetail {
    private int id;
    private int productId;
    private int orderId;
    private int unitPrice;
    private int quantity;
    private int subTotalPrice;
    private boolean isDeleted;

    public OrderDetail(int id, int productId, int orderId, int unitPrice, int quantity, int subTotalPrice) {
        this.id = id;
        this.productId = productId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subTotalPrice = subTotalPrice;
    }

    public OrderDetail(int productId, int orderId, int unitPrice, int quantity, int subTotalPrice) {
        this.productId = productId;
        this.orderId = orderId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subTotalPrice = subTotalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(int subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
