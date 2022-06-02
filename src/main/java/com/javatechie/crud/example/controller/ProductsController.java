package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entities.tables.pojos.Products;
import com.javatechie.crud.example.service.ProductsService;
import com.javatechie.crud.example.validations.CartValidation;
import com.javatechie.crud.example.validations.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductsService service;

    private ProductValidation validator = new ProductValidation();

    ResponseEntity<String> Errormessage(String message) {
        HttpHeaders header = new HttpHeaders();
        header.add("Description","Invalid request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(message);
    }

    @GetMapping
    public List<Products> findAllProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Products findAllById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping//multipost
    public ResponseEntity<String> addProducts(@RequestBody Products product) {

        if(validator.checkIfProductNameIsEmpty(product) == false){
            return Errormessage("Name should not be empty.");
        } else if(validator.checkUniPriceGreaterThanZero(product) == false){
            return Errormessage("Price should be greater than zero");
        } else if(validator.checkUnitIsValid(product) == false){
            return Errormessage("Unit field should not be empty");
        }else{
            HttpHeaders header = new HttpHeaders();
            header.add("Description","product added");
            service.add(product);
            return ResponseEntity.status(HttpStatus.OK).headers(header).body("Product added");
        }

    }

    @PutMapping("/{id}")
    public int updateProduct(@RequestBody Products product) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        service.deleteById(id);
    }

}