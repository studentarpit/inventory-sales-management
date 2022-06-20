package com.assignment.interfaces.mapper;

import com.assignment.entity.StockDetailsEntity;
import com.assignment.model.AvailabilityEnum;
import com.assignment.model.Stock;
import com.assignment.model.StockDetail;
import com.assignment.model.ViewStock;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-20T14:07:31+0800",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class IStockDetailMapperImpl implements IStockDetailMapper {

    @Override
    public ViewStock mapToViewModel(StockDetailsEntity stockDetailsEntity) {
        if ( stockDetailsEntity == null ) {
            return null;
        }

        ViewStock viewStock = new ViewStock();

        viewStock.setProductName( stockDetailsEntity.getProductName() );
        viewStock.setProductCategory( stockDetailsEntity.getProductCategory() );
        viewStock.setProductColor( stockDetailsEntity.getProductColor() );
        viewStock.setProductPrice( stockDetailsEntity.getProductPrice() );
        if ( stockDetailsEntity.getAvailability() != null ) {
            viewStock.setAvailability( Enum.valueOf( AvailabilityEnum.class, stockDetailsEntity.getAvailability() ) );
        }

        postTargetViewStock( viewStock, stockDetailsEntity );

        return viewStock;
    }

    @Override
    public StockDetail mapToModel(StockDetailsEntity stockDetailsEntity) {
        if ( stockDetailsEntity == null ) {
            return null;
        }

        StockDetail stockDetail = new StockDetail();

        if ( stockDetailsEntity.getAvailability() != null ) {
            stockDetail.setAvailability( Enum.valueOf( AvailabilityEnum.class, stockDetailsEntity.getAvailability() ) );
        }

        postTargetStock( stockDetail, stockDetailsEntity );

        return stockDetail;
    }

    @Override
    public StockDetailsEntity mapStockToEntity(Stock stock) {
        if ( stock == null ) {
            return null;
        }

        StockDetailsEntity stockDetailsEntity = new StockDetailsEntity();

        stockDetailsEntity.setProductPrice( stock.getPrice() );

        postTarget( stockDetailsEntity, stock );

        return stockDetailsEntity;
    }
}
