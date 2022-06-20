/*
package com.assignment.controller;

import com.assignment.controller.InventoryManagementController;
import com.assignment.model.StockDetail;
import com.assignment.service.InventoryManagementService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.model.AvailabilityEnum.IN_STOCK;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
public class StockDetailControllerTest {

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
        stockDetailController.getAllAvailableStock();
    }
}
*/
