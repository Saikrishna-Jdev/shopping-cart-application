package com.sca.webapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonFormat
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
@DiscriminatorValue("1")
public class Book extends Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   int productId;
    private String productName;
    private float price;
    @Column
    private String genere;

    @Column
    private String author;


    @Column
    private String publications;

    //@Column
    //@Enumerated(EnumType.STRING)
    @Convert(converter = ProductCategoryConverter.class)
    private ProductCategory productCategory;

}
