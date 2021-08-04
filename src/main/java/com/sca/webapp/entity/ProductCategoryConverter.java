package com.sca.webapp.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductCategoryConverter implements AttributeConverter<ProductCategory,String> {

    @Override
    public String convertToDatabaseColumn(ProductCategory attribute) {
        if (attribute==null){
            return null;
        }
        String databaseValue=null;
        switch (attribute){
            case BOOK:
                databaseValue="Book";
                break;
            case APPRAL:
                databaseValue="Appral";
                break;
            default:
                databaseValue=null;
        }
        return databaseValue;
    }

    @Override
    public ProductCategory convertToEntityAttribute(String dbData) {
        if(dbData==null)
            return null;
        ProductCategory category=null;
        switch (dbData){

            case "Book":
                category=ProductCategory.BOOK;
                break;
            case "Apparal":
                category=ProductCategory.APPRAL;
                break;
            default:
                category=null;
        }
        return category;
    }
}
