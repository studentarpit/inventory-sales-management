package com.assignment.service;

import com.assignment.entity.OrderEntity;
import com.assignment.interfaces.repository.IOrderRepository;
import com.assignment.interfaces.mapper.IOrderMapper;
import com.assignment.model.Product;
import com.assignment.model.exception.DataPersistenceError;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.assignment.constants.InventoryServiceConstant.*;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    IOrderRepository repository;

    private static final String MSG ="Order Placed successfully";

    private static final IOrderMapper MAPPER = Mappers.getMapper(IOrderMapper.class);

    public String placeOrder(Product product) {
        OrderEntity orderEntity = MAPPER.mapToEntity(product);
        String response = restTemplate.postForObject(reduceProduct, product, String.class);
        if(MSG.equalsIgnoreCase(response)) {
            try {
                repository.save(orderEntity);
            } catch (Exception e) {
                new DataPersistenceError("Unable to save in DB", e.toString());
            }
        }
        return response;
    }
}
