package com.assignment.service;

import com.assignment.entity.StockDetailsEntity;
import com.assignment.interfaces.repository.IStockRepository;
import com.assignment.model.AvailabilityEnum;
import com.assignment.model.ViewStock;
import com.assignment.service.InventoryManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;

import static com.assignment.helper.StockDetailsHelper.*;
import static com.assignment.helper.ProductHelper.*;
import static com.assignment.helper.StockHelper.getStock;
import static com.assignment.helper.StockHelper.getStockNilProduct;
import static org.mockito.Mockito.when;
import static com.assignment.model.AvailabilityEnum.IN_STOCK;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryManagementServiceTest {

    @InjectMocks
    InventoryManagementService inventoryManagementService;

    @Mock
    IStockRepository stockRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getAllAvailableStock(){

        List<StockDetailsEntity> lists = new ArrayList<StockDetailsEntity>();
        StockDetailsEntity stock = getStockDetailsEntity();
        lists.add(stock);
        when(stockRepository.findAll()).thenReturn(lists);
        inventoryManagementService.getAvailableStockSummary();

        assertEquals(1, inventoryManagementService.getAvailableStockSummary().size());
    }

    @Test
    public void test_displayAllAvailableStock(){

        List<StockDetailsEntity> stockDetailsEntityList = new ArrayList<>();
        StockDetailsEntity stockDetailsEntity = getStockDetailsEntity();
        stockDetailsEntityList.add(stockDetailsEntity);

        List<ViewStock> viewStocks = new ArrayList<>();
        ViewStock viewstock = new ViewStock();
        viewstock.setProductColor("testColor");
        viewstock.setProductPrice(BigDecimal.valueOf(2000L));
        viewstock.setProductCategory("testCat");
        viewstock.setProductName("testName");
        viewstock.setAvailability(IN_STOCK);
        viewStocks.add(viewstock);
        when(stockRepository.findAll()).thenReturn(stockDetailsEntityList);
        List<ViewStock> actualDisplay = inventoryManagementService.displayAvailableStock();

        assertEquals(1, actualDisplay.size());
        assertEquals(viewstock.getProductCategory(), actualDisplay.get(0).getProductCategory());
    }

    @Test
    public void test_tryRemoveIfStockIsNotAvailable(){
        inventoryManagementService.removeStock(getProduct());
    }

    @Test
    public void test_tryRemoveIfStockIsAvailable(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntity()));
        String actualResponse = inventoryManagementService.removeStock(getProduct());
        assertEquals("10 Product Removed Successfully",actualResponse);
    }

    @Test
    public void test_tryRemoveStockWithInappropriateQuantity(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntityWithUnderQuantity()));
        String actualResponse = inventoryManagementService.removeStock(getProduct());
        assertEquals("Max available quantity is: 5",actualResponse);
    }

    @Test
    public void test_markAvailabilityOutOfStockOnceAllProductsAreSoldOrRemoved(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntityWithZeroQuantity()));
        String actualResponse = inventoryManagementService.removeStock(getProduct());
        assertEquals("Max available quantity is: 0",actualResponse);
    }

    @Test
    public void test_tryProcessOrder(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntity()));
        String actualResponse = inventoryManagementService.processOrder(getProduct());
        assertEquals("Order Placed Successfully",actualResponse);
    }

    @Test
    public void test_tryProcessOrderIfNoProductAvailable(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntityWithZeroQuantity()));
        String actualResponse = inventoryManagementService.processOrder(getProduct());
        assertEquals("Max available quantity is: 0",actualResponse);
    }

    @Test
    public void test_addProduct(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntity()));
        String actualResponse = inventoryManagementService.addStock(getStock());
        assertEquals("110 Product Added Successfully",actualResponse);
    }

    @Test
    public void test_addProductWithZeroProductQuantity(){
        when(inventoryManagementService.getStockDetails(getProduct())).thenReturn(Optional.of(getStockDetailsEntityWithZeroQuantity()));
        String actualResponse = inventoryManagementService.addStock(getStockNilProduct());
        assertEquals(" None Products Were Added Successfully",actualResponse);
    }

/*

    @Test
    public void test_updateAvailableStockIfPresent(){
        when(stockRepository.findByProductNameAndProductCategoryAndProductColor(anyString(), anyString(), anyString())).thenReturn(Optional.of(getStockDetailsEntity()));
        stockDetailService.updateAvailableStock(ProductHelper.getProduct());
    }

    @Test
    public void test_reduceAvailableStockIfStockIsPresent(){
        when(stockRepository.findByProductNameAndProductCategoryAndProductColor(anyString(), anyString(), anyString())).thenReturn(Optional.of(getStockDetailsEntity()));
        stockDetailService.reduceAvailableStock(ProductHelper.getProduct());
    }

    @Test
    public void test_reduceAvailableStockIfStockIsNotPresent(){
        when(stockRepository.findByProductNameAndProductCategoryAndProductColor(anyString(), anyString(), anyString())).thenReturn(Optional.of(getStockDetailsEntityWithZeroQuantity()));
        stockDetailService.reduceAvailableStock(ProductHelper.getProduct());
    }

    @Test
    public void test_removeAvailableStockIfPresent(){
        when(stockRepository.findByProductNameAndProductCategoryAndProductColor(anyString(), anyString(), anyString())).thenReturn(Optional.of(getStockDetailsEntity()));
        stockDetailService.removeAvailableStock(ProductHelper.getProduct());
    }
*/


}
