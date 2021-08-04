package com.sca.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="products")
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type",discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})

public class Product implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected  int productId;

    protected String productName;
    protected float price;

    @Convert(converter = ProductCategoryConverter.class)
    protected ProductCategory productCategory;


}
