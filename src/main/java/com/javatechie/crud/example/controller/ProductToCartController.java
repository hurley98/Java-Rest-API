package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entities.tables.pojos.ProductToCart;
import com.javatechie.crud.example.response.ResponseHandler;
import com.javatechie.crud.example.service.ProductToCartService;
import com.javatechie.crud.example.validations.ProductToCartValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-to-cart")
public class ProductToCartController {
    @Autowired
    private ProductToCartService service;

    @Autowired
    private ProductToCartValidation validator;



@GetMapping
public List<ProductToCart> findAllProductsInTheCart() {
    return service.findAll();
}

    @GetMapping("/test/{id}")
    public String findTotalSumOfCart(@PathVariable int id) {
        return service.findTotalSumOfCart(id);
    }

    @PostMapping
    public ResponseEntity<String> addProductInTheCart(@RequestBody ProductToCart productToCart) {
        if (!validator.checkProductId(productToCart))
            return ResponseHandler.errorMessage("No product with that id");

        if (!validator.checkCartId(productToCart))
            return ResponseHandler.errorMessage("No cart with that id");

        if(!validator.checkProductQuantity(productToCart))
            return ResponseHandler.errorMessage("Please enter a valid  quantity");

            service.add(productToCart);
            HttpHeaders header = new HttpHeaders();
            header.add("Description","cart added");
            service.add(productToCart);
            return ResponseEntity.status(HttpStatus.OK).headers(header).
                    body("ProductToCart added");


    }

    @GetMapping("/{id}")
    public ProductToCart viewCartContent(@PathVariable int id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public int updateProductInTheCart(@RequestBody ProductToCart productToCart) {
        return service.update(productToCart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable int id) {
        service.deleteById(id);
    }


}
