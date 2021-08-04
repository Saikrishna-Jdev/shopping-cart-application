package com.sca.webapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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


}
