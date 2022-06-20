package com.assignment.helper;

import com.assignment.model.Product;

import java.math.BigDecimal;

public class ProductHelper {

    public static Product getProduct(){
        return Product.builder().category("testCat")
                .color("testColor")
                .name("name")
                .price(new BigDecimal(20))
                .build();
    }

}
