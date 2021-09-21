package com.sca.webapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@DiscriminatorValue("2")

public class Apparal extends Product implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   int productId;


    private String productName;


    private float price;

    @Column
    private String type;

    @Column
    private String brand;

    @Column
    private String design;

    @Convert(converter = ProductCategoryConverter.class)
    private ProductCategory productCategory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Apparal apparal = (Apparal) o;
        return productId == apparal.productId && Float.compare(apparal.price, price) == 0 && Objects.equals(productName, apparal.productName) && Objects.equals(type, apparal.type) && Objects.equals(brand, apparal.brand) && Objects.equals(design, apparal.design) && productCategory == apparal.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productId, productName, price, type, brand, design, productCategory);
    }
}
