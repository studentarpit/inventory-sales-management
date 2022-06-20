package com.assignment.controller;

import com.assignment.model.ViewStockDetails;
import com.assignment.service.DisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory/display")
public class DisplayController {

    @Autowired
    DisplayService service;

    @SuppressWarnings("rawtypes")
    @PostMapping("/displayAvailableStock")
    public ResponseEntity<ViewStockDetails> displayProduct() {
        return new ResponseEntity<ViewStockDetails>(service.displayProducts(), HttpStatus.OK);
    }

}
