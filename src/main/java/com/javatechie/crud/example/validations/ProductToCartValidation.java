package com.javatechie.crud.example.validations;

import com.javatechie.crud.example.entities.tables.pojos.Cart;
import com.javatechie.crud.example.entities.tables.pojos.ProductToCart;
import com.javatechie.crud.example.entities.tables.pojos.Products;
import com.javatechie.crud.example.service.CartService;
import com.javatechie.crud.example.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductToCartValidation {
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CartService cartService;

    public ProductToCartValidation() {
    }

    public boolean checkProductId(ProductToCart productToCart){
         Products product = productsService.findById(productToCart.getProductid());
         return !(product == null);

    }

    public boolean checkCartId(ProductToCart productToCart){
        Cart cart = cartService.findById(productToCart.getCartid());
        return !(cart == null);
    }

    public boolean checkProductQuantity(ProductToCart productToCart){
        return productToCart.getProductquantity() > 0 ;

    }
}
