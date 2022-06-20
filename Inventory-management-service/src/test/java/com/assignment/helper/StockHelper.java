package com.assignment.helper;

import com.assignment.model.Product;
import com.assignment.model.Stock;

import java.math.BigDecimal;
import static com.assignment.helper.ProductHelper.*;

public class StockHelper {

    public static Stock getStock(){
        return Stock.builder().product(getProduct())
                .price(BigDecimal.valueOf(1000l)).build();
    }

    public static Stock getStockNilProduct(){
        return Stock.builder().product(getNilProduct())
                .price(BigDecimal.valueOf(1000l)).build();
    }

}
