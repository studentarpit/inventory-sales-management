package com.assignment.controller;

import com.assignment.model.Product;
import com.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sales")
public class OrderController {

    @Autowired
    OrderService service;

    @Autowired
    private RestTemplate restTemplate;

    @SuppressWarnings("rawtypes")
    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(@RequestBody Product request) {
        String response = service.placeOrder(request);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
