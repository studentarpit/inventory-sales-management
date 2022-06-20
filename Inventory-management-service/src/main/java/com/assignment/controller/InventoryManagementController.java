package com.assignment.controller;

import com.assignment.model.Product;
import com.assignment.model.Stock;
import com.assignment.model.StockDetail;
import com.assignment.model.ViewStock;
import com.assignment.service.InventoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryManagementController {
    @Autowired
    InventoryManagementService service;

    @PostMapping("/addStock")
    public ResponseEntity addStock(@RequestBody Stock request) {
        String response = service.addStock(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/removeStock")
    public ResponseEntity removeStock(@RequestBody Product request){
        String response = service.removeStock(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/getAvailableStockSummary")
    public List<StockDetail> getAllAvailableStock() {
        return service.getAvailableStockSummary();
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/displayAvailableStock")
    public List<ViewStock> displayAvailableStock() {
        return service.displayAvailableStock();

    }
    @PostMapping("/processOrder")
    public ResponseEntity processOrder(@RequestBody Product request){
        String response = service.processOrder(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
