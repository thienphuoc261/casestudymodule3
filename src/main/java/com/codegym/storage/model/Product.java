package com.codegym.storage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class Product {
    private int id;
    private String productName;
    private int quantity;
    private int unitPriceOfProduct;
    private String manufactureDate;
    private String expirationDate;
    private String unit;
    private String importDate;

    public Product(String productName, int quantity, int unitPriceOfProduct, String manufactureDate, String expirationDate, String unit, String importDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.unitPriceOfProduct = unitPriceOfProduct;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.unit = unit;
        this.importDate = importDate;
    }

    public Product(int id, String productName, int quantity, int unitPriceOfProduct, String manufactureDate, String expirationDate, String unit, String importDate) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPriceOfProduct = unitPriceOfProduct;
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.unit = unit;
        this.importDate = importDate;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", unitPriceOfProduct=" + unitPriceOfProduct +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", unit='" + unit + '\'' +
                ", importDate='" + importDate + '\'' +
                '}';
    }
}
