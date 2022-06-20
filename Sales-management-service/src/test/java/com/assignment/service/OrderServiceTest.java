package com.assignment.service;


import com.assignment.interfaces.repository.IOrderRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import static com.assignment.helper.ProductHelper.getProduct;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_placeOrder(){
        when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(), Mockito.any())).thenReturn("Order Placed successfully");
        orderService.placeOrder(getProduct());
    }
}
