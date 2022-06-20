package com.assignment.helper;

import com.assignment.model.Product;

import java.math.BigDecimal;

public class ProductHelper {

    public static Product getProduct(){
        return Product.builder().category("testCat")
                .color("testColor")
                .name("name")
                .quantity(10L)
                .build();
    }

    public static Product getNilProduct(){
        return Product.builder().category("testCat")
                .color("testColor")
                .name("name")
                .quantity(0L)
                .build();
    }

}
