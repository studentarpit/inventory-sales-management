package com.assignment.helper;

import com.assignment.entity.OrderEntity;
import com.assignment.model.Product;

import java.math.BigDecimal;

public class OrderHelper {

    public static OrderEntity getOrderEntity(){
        return OrderEntity.builder().productCategory("testCat")
                .productColor("testColor")
                .productName("name")
                .quantity(20L)
                .build();
    }

}
