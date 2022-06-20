package com.assignment.service;

import com.assignment.model.ViewStockDetails;
import com.assignment.model.ViewStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.assignment.constants.InventoryServiceConstant.displayProduct;

@Service
public class DisplayService {

    @Autowired
    RestTemplate restTemplate;

    public ViewStockDetails displayProducts(){
        ViewStockDetails viewStockDetails = new ViewStockDetails();
        List<ViewStock> viewStockList = new ArrayList<>();

        viewStockList = restTemplate.getForObject(displayProduct, List.class);

        viewStockDetails.setAvailableStock(viewStockList);
        return viewStockDetails;
    }
}
