package com.javatechie.crud.example.validations;

import com.javatechie.crud.example.entities.tables.pojos.Cart;


public class CartValidation{
    public CartValidation() {
    }

    public boolean checkOrderDate(Cart cart){
        if(cart.getOrderdate() == null){
            return false;
        }
        return true;
    }

}
