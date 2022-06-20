package com.assignment.interfaces.mapper;

import com.assignment.entity.OrderEntity;
import com.assignment.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface IOrderMapper {

    @Mappings({
            @Mapping(source = "product.name", target = "productName"),
            @Mapping(source = "product.category", target = "productCategory"),
            @Mapping(source = "product.color", target = "productColor"),
            @Mapping(source = "product.quantity", target = "quantity")
    })
    OrderEntity mapToEntity(Product product);
}
