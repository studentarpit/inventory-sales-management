package com.assignment.controller;

import com.assignment.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

import static com.assignment.helper.ProductHelper.getProduct;

@SpringBootTest
public class OrderControllerTest {

    @InjectMocks
    OrderController orderController;

    @Mock
    OrderService orderService;

    @Mock
    RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_placeOrder(){
        Mockito.when(orderService.placeOrder(getProduct())).thenReturn("Order Placed Successfully");
        ResponseEntity actualResponse = orderController.placeOrder(getProduct());
        assertEquals("200 OK",actualResponse.getStatusCode().toString());
    }
}
