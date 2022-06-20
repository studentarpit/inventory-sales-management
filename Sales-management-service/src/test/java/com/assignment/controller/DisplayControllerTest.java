package com.assignment.controller;

import com.assignment.service.DisplayService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
public class DisplayControllerTest {

    @InjectMocks
    private DisplayController displayController;

    @Mock
    DisplayService displayService;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(displayController).build();
    }

    @Test
    public void test_displayProduct(){
        displayController.displayProduct();
    }
}
