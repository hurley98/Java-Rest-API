package com.javatechie.crud.example.validations;

import com.javatechie.crud.example.entities.tables.pojos.Products;

public class ProductValidation {
    public ProductValidation() {
    }

    public boolean checkIfProductNameIsEmpty(Products product){
        if(product.getProductname().isEmpty()){
            return false;
        }
        return true;
    }

    public boolean checkUniPriceGreaterThanZero(Products product){
        if(product.getUnitprice() == 0 || product.getUnitprice() < 0){
            return false;
        }
        return true;
    }
    public boolean checkUnitIsValid(Products product){
        if(product.getUnit().isEmpty()){
            return false;
        }
        return true;
    }

}
