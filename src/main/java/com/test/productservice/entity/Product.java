package com.test.productservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Timestamp manufactureDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Timestamp expiryDate;


}