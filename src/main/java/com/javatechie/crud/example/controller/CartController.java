package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entities.tables.pojos.Cart;
import com.javatechie.crud.example.service.CartService;
import com.javatechie.crud.example.validations.CartValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService service;

    private CartValidation validator = new CartValidation();

    ResponseEntity<String> Errormessage(String message) {
        HttpHeaders header = new HttpHeaders();
        header.add("Description","Invalid request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(message);
    }

    @GetMapping
    public List<Cart> findAllCarts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cart findAllById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping//multipost
    public ResponseEntity<String> addCarts(@RequestBody Cart cart) {

        if(validator.checkOrderDate(cart) == false){
            return Errormessage("Order date cannot be empty");
        }else{
            HttpHeaders header = new HttpHeaders();
            header.add("Description","cart added");
            service.add(cart);
            return ResponseEntity.status(HttpStatus.OK).headers(header).body("Cart added");
        }

    }

    @PutMapping("/{id}")
    public int updateCart(@RequestBody Cart cart) {
        return service.update(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable int id) {
        service.deleteById(id);
    }

}