package com.javatechie.crud.example.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<String> errorMessage(String message) {
        HttpHeaders header = new HttpHeaders();
        header.add("Description","Invalid request");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(header).body(message);
    }
}
