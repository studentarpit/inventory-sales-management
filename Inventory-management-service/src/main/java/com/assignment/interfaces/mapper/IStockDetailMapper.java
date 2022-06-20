package com.assignment.interfaces.mapper;

import com.assignment.entity.StockDetailsEntity;
import com.assignment.model.*;
import org.apache.commons.lang3.ObjectUtils;
import org.mapstruct.*;


@Mapper
public interface IStockDetailMapper {

    ViewStock mapToViewModel(StockDetailsEntity stockDetailsEntity);
    @AfterMapping
    default void postTargetViewStock(@MappingTarget ViewStock viewStock, StockDetailsEntity entity) {
        viewStock.setAvailability(AvailabilityEnum.valueOf(entity.getAvailability()));
    }

    StockDetail mapToModel(StockDetailsEntity stockDetailsEntity);
    @AfterMapping
    default void postTargetStock(@MappingTarget StockDetail stockDetail,  StockDetailsEntity entity) {
        if(ObjectUtils.isEmpty(entity)) return;
        Stock stock = Stock.builder().product(Product.builder().name(entity.getProductName())
                .category(entity.getProductCategory())
                .color(entity.getProductColor())
                .quantity(entity.getAvailableQuantity()).build())
                .price(entity.getProductPrice())
                .build();
        stockDetail.setStock(stock);
        stockDetail.setAvailability(AvailabilityEnum.valueOf(entity.getAvailability()));
    }

    @Mappings({
            @Mapping(source = "stock.price", target = "productPrice")
    })
    StockDetailsEntity mapStockToEntity(Stock stock);
    @AfterMapping
    default void postTarget(@MappingTarget StockDetailsEntity entity,  Stock model) {
        if(ObjectUtils.isEmpty(model.getProduct())) return;
        Product product= model.getProduct();
        entity.setProductName(product.getName());
        entity.setProductCategory(product.getCategory());
        entity.setProductColor(product.getColor());
        entity.setAvailableQuantity(product.getQuantity());
    }

}
