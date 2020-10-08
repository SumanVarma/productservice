package com.test.productservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @NotNull
    private String productType;
    @NotNull
    private String productName;
    private String productSKU;
    private String productBrand;
    private BigDecimal weight;
    @NotNull
    private BigDecimal price;
    private boolean active;
    private boolean primeAvailable;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date manufactureDate;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING, timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date expiryDate;

    public Product() {
    }

    public Product(Long id, @NotNull String productType, @NotNull String productName, String productSKU, String productBrand, BigDecimal weight, @NotNull BigDecimal price, boolean active,
                   boolean primeAvailable, @NotNull Date manufactureDate, @NotNull Date expiryDate) {
        this.id = id;
        this.productType = productType;
        this.productName = productName;
        this.productSKU = productSKU;
        this.productBrand = productBrand;
        this.weight = weight;
        this.price = price;
        this.active = active;
        this.primeAvailable = primeAvailable;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isPrimeAvailable() {
        return primeAvailable;
    }

    public void setPrimeAvailable(boolean primeAvailable) {
        this.primeAvailable = primeAvailable;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", productSKU='" + productSKU + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", active=" + active +
                ", primeAvailable=" + primeAvailable +
                ", manufactureDate=" + manufactureDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}