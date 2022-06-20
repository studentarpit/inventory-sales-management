package com.assignment.helper;

import com.assignment.entity.StockDetailsEntity;
import com.assignment.model.StockDetail;

public class StockDetailsHelper {

    public static StockDetailsEntity getStockDetailsEntity(){
        return StockDetailsEntity.builder().productName("testName")
                .productColor("testColor")
                .productCategory("testCat")
                .availableQuantity(100L)
                .availability("IN_STOCK")
                .build();
    }

    public static StockDetailsEntity getStockDetailsEntityNullVals(){
        return StockDetailsEntity.builder()
                .build();
    }

    public static StockDetailsEntity getStockDetailsEntityWithUnderQuantity(){
        return StockDetailsEntity.builder().productName("testCat")
                .productColor("testColor")
                .productCategory("name")
                .availableQuantity(5L)
                .build();
    }

    public static StockDetailsEntity getStockDetailsEntityWithZeroQuantity(){
        return StockDetailsEntity.builder().productName("testCat")
                .productColor("testColor")
                .productCategory("name")
                .availableQuantity(0L)
                .build();
    }
}
