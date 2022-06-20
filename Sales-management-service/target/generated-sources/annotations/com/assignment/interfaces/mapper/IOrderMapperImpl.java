package com.assignment.interfaces.mapper;

import com.assignment.entity.OrderEntity;
import com.assignment.model.Product;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T14:08:17+0800",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class IOrderMapperImpl implements IOrderMapper {

    @Override
    public OrderEntity mapToEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setProductName( product.getName() );
        orderEntity.setProductCategory( product.getCategory() );
        orderEntity.setProductColor( product.getColor() );
        orderEntity.setQuantity( product.getQuantity() );

        return orderEntity;
    }
}
