package com.sca.webapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity(name="products")
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type",discriminatorType = DiscriminatorType.STRING)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})

public class Product implements Serializable,Comparable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected  int productId;

    protected String productName;
    protected float price;

    @Convert(converter = ProductCategoryConverter.class)
    protected ProductCategory productCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && Float.compare(product.price, price) == 0 && Objects.equals(productName, product.productName) && productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, productCategory);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
