package com.assignment.controller;

import com.assignment.model.StockDetail;
import com.assignment.model.ViewStock;
import com.assignment.service.InventoryManagementService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.assignment.helper.ProductHelper.getProduct;
import static com.assignment.helper.StockHelper.getStock;
import static com.assignment.model.AvailabilityEnum.IN_STOCK;
import static org.junit.Assert.assertEquals;

@SpringBootTest
public class InventoryManagementControllerTest {

    @InjectMocks
    private InventoryManagementController stockDetailController;

    private MockMvc mockMvc;

    @Mock
    private InventoryManagementService inventoryManagementService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(stockDetailController).build();
    }

    @Test
    public void test_getAllAvailableStock() {

        List<StockDetail> stocks = new ArrayList<>();
        StockDetail stock = new StockDetail();
        stock.setAvailability(IN_STOCK);
        stocks.add(stock);

        Mockito.when(inventoryManagementService.getAvailableStockSummary()).thenReturn(stocks);
        List<StockDetail> actualStocks = stockDetailController.getAllAvailableStock();
        assertEquals(stocks.size(),actualStocks.size());
    }

    @Test
    public void test_removeStock() {
      Mockito.when(inventoryManagementService.removeStock(getProduct())).thenReturn("Product Removed Successfully");
        ResponseEntity actualResponse = stockDetailController.removeStock(getProduct());
        assertEquals("200 OK",actualResponse.getStatusCode().toString());
    }

    @Test
    public void test_processOrder() {
        Mockito.when(inventoryManagementService.processOrder(getProduct())).thenReturn("Order Placed Successfully");
        ResponseEntity actualResponse = stockDetailController.processOrder(getProduct());
        assertEquals("200 OK",actualResponse.getStatusCode().toString());
    }

    @Test
    public void test_displayAvailableStock() {
        List<ViewStock> viewStocks = new ArrayList<>();
        ViewStock viewstock = new ViewStock();
        viewstock.setProductColor("testcolor");
        viewstock.setProductPrice(BigDecimal.valueOf(2000L));
        viewstock.setProductCategory("testcat");
        viewstock.setProductName("testname");
        viewStocks.add(viewstock);

        Mockito.when(inventoryManagementService.displayAvailableStock()).thenReturn(viewStocks);
        List<ViewStock> actualViewStocks = stockDetailController.displayAvailableStock();
        assertEquals(viewStocks.size(),actualViewStocks.size());
    }

   @Test
    public void test_addStock() {
        Mockito.when(inventoryManagementService.removeStock(getProduct())).thenReturn("Product Added Successfully");
        ResponseEntity actualResponse = stockDetailController.addStock(getStock());
        assertEquals("200 OK",actualResponse.getStatusCode().toString());
    }
}
