package com.assignment.mapper;

import com.assignment.entity.OrderEntity;
import com.assignment.interfaces.mapper.IOrderMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.junit.Assert;

import static com.assignment.helper.ProductHelper.getProduct;

public class IOrderMapperTest {

    private static final IOrderMapper MAPPER = Mappers.getMapper(IOrderMapper.class);

    @Test
    public void test_mapToEntity(){
        OrderEntity orderEntity = MAPPER.mapToEntity(getProduct());
        Assert.assertNotNull(orderEntity);
    }
}
