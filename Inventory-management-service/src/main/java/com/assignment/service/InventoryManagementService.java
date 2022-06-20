package com.assignment.service;

import com.assignment.entity.StockDetailsEntity;
import com.assignment.interfaces.mapper.IStockDetailMapper;
import com.assignment.interfaces.repository.IStockRepository;
import com.assignment.model.*;
import com.assignment.model.exception.DataPersistenceError;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.assignment.model.AvailabilityEnum.IN_STOCK;
import static com.assignment.model.AvailabilityEnum.OUT_OF_STOCK;
import static com.assignment.constants.InventoryManagementConstant.*;

@Service
public class InventoryManagementService {

    @Autowired
    IStockRepository stockRepository;
    private static final IStockDetailMapper MAPPER = Mappers.getMapper(IStockDetailMapper.class);
    private String responseMsg = StringUtils.EMPTY;


    public String addStock(Stock stock) {
        responseMsg = StringUtils.EMPTY;
        if(ObjectUtils.isEmpty(stock)) return PRODUCT_NOT_AVAILABLE;
        Product product = stock.getProduct();
        if(isValidProductRequest(product)) return PRODUCT_NOT_AVAILABLE;

        StockDetailsEntity entity = MAPPER.mapStockToEntity(stock);

        Optional<StockDetailsEntity> availableProductStock= getStockDetails(product);

        if(availableProductStock.isPresent() && product.getQuantity()!=null){
            entity = availableProductStock.get();
            entity.setAvailableQuantity(entity.getAvailableQuantity()+product.getQuantity());
        }

        if(entity.getAvailableQuantity()!=0){
            entity.setAvailability(IN_STOCK.name());
            responseMsg = entity.getAvailableQuantity() + PRODUCT_ADDED;
        }
        else{
            responseMsg = NONE_PRODUCT_ADDED;
        }

        try {
            stockRepository.saveAndFlush(entity);
        } catch (Exception e) {
            new DataPersistenceError(DB_EXCEPTION, e.toString());
        }
/*
        StockDetailsEntity entity = MAPPER.mapToEntity(product); //taken product INSTEAD OF stock
        StockDetailsEntity entityforprice = MAPPER.mapToEntity(stock); //It is just to FETCH price separately

        Optional<StockDetailsEntity> availableProductStock= getStockDetails(product);

        if(availableProductStock.isPresent() && product.getQuantity()!=null){
            entity = availableProductStock.get();
            entity.setAvailableQuantity(entity.getAvailableQuantity()+product.getQuantity());
        }

        if(entity.getAvailableQuantity()!=0){
            entity.setProductPrice(entityforprice.getProductPrice()); // Setting prices separately
            entity.setAvailability(IN_STOCK.name());
            responseMsg = entity.getAvailableQuantity() + PRODUCT_ADDED;
        }
        try {
            if(entity.getAvailability().equals(IN_STOCK.name())) { // This is to handle 0 quantity scenarios
                stockRepository.saveAndFlush(entity);
            }
        } catch (Exception e) {
            new DataPersistenceError(DB_EXCEPTION, e.toString());
        }*/

        return responseMsg;
    }

    @Transactional
    public String removeStock(Product product) {
        responseMsg = StringUtils.EMPTY;
        if(isValidProductRequest(product)) return PRODUCT_NOT_AVAILABLE;

        StockDetailsEntity entity = StockDetailsEntity.builder().build();

        Optional<StockDetailsEntity> availableProductStock= getStockDetails(product);
        if(availableProductStock.isPresent() && product.getQuantity()!=null){
            entity = availableProductStock.get();
            if (entity.getAvailableQuantity()>= product.getQuantity() ) {
                entity.setAvailableQuantity(entity.getAvailableQuantity() - product.getQuantity());
                responseMsg = product.getQuantity() + PRODUCT_REMOVED;
                if(entity.getAvailableQuantity()==0){
                    entity.setAvailability(OUT_OF_STOCK.name());
                }
                try {
                    stockRepository.saveAndFlush(entity);
                } catch (Exception e) {
                    new DataPersistenceError(DB_EXCEPTION, e.toString());
                }
            }
            else{
                responseMsg = EXCEPTION_MSG + entity.getAvailableQuantity();
            }
        }else responseMsg = PRODUCT_NOT_FOUND;
        return responseMsg;
    }

    public List<StockDetail> getAvailableStockSummary() {
        List<StockDetailsEntity> stockDetailsEntityList= stockRepository.findAll();
        List<StockDetail> stockDetailList = new ArrayList<>();
        for(StockDetailsEntity entity : stockDetailsEntityList){
            stockDetailList.add(MAPPER.mapToModel(entity));
        }
        return stockDetailList;
    }

    public List<ViewStock> displayAvailableStock() {
        List<StockDetailsEntity> stockDetailsEntityList= stockRepository.findAll();
        List<ViewStock> stockDetailList = new ArrayList<>();
        for(StockDetailsEntity entity : stockDetailsEntityList){
            stockDetailList.add(MAPPER.mapToViewModel(entity));
        }
        return stockDetailList;
    }

    public String processOrder(Product product){
        responseMsg = StringUtils.EMPTY;
        if(isValidProductRequest(product)) return PRODUCT_NOT_AVAILABLE;

        StockDetailsEntity entity = StockDetailsEntity.builder().build();
        Optional<StockDetailsEntity> availableProductStock= getStockDetails(product);
        if(availableProductStock.isPresent() && product.getQuantity()!=null){
            entity = availableProductStock.get();
            if (entity.getAvailableQuantity() >= product.getQuantity()) {
                entity.setAvailableQuantity(entity.getAvailableQuantity() - product.getQuantity());
                responseMsg = ORDER_PLACED;
            }
            else{
                responseMsg = EXCEPTION_MSG + entity.getAvailableQuantity();
            }
        }
        try {
            stockRepository.saveAndFlush(entity);
        } catch (Exception e) {
            new DataPersistenceError(DB_EXCEPTION, e.toString());
        }
        return responseMsg;
    }

    public Optional<StockDetailsEntity> getStockDetails(Product product) {
        return stockRepository.findByProductNameAndProductCategoryAndProductColor(product.getName(), product.getCategory(), product.getColor());
    }

    private boolean isValidProductRequest(Product product) {
        return ObjectUtils.isEmpty(product) ||
                StringUtils.isBlank(product.getCategory()) ||
                StringUtils.isBlank(product.getColor()) ||
                StringUtils.isBlank(product.getName());
    }
}
