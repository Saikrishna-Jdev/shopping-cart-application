package com.sca.webapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return productId == book.productId && Float.compare(book.price, price) == 0 && Objects.equals(productName, book.productName) && Objects.equals(genere, book.genere) && Objects.equals(author, book.author) && Objects.equals(publications, book.publications) && productCategory == book.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productId, productName, price, genere, author, publications, productCategory);
    }
}
