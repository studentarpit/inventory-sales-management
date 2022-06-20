package com.assignment.mapper;

import com.assignment.entity.StockDetailsEntity;
import com.assignment.interfaces.mapper.IStockDetailMapper;

import com.assignment.model.StockDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.assignment.helper.StockDetailsHelper.getStockDetailsEntityNullVals;
import static com.assignment.helper.StockHelper.getStock;
import static com.assignment.helper.StockDetailsHelper.getStockDetailsEntity;


public class IStockDetailMapperTest {
    private static final IStockDetailMapper MAPPER = Mappers.getMapper(IStockDetailMapper.class);

    @Test
    public void test_mapToModel(){
        StockDetail stockDetail = MAPPER.mapToModel(getStockDetailsEntity());
        Assert.assertNotNull(stockDetail);
    }

    @Test
    public void test_mapToEntity(){
        StockDetailsEntity stockDetailsEntity = MAPPER.mapStockToEntity(getStock());
        Assert.assertNotNull(stockDetailsEntity);
    }
}

