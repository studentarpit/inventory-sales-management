package com.assignment.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    String name;
    String color;
    String category;
    BigDecimal price;
    Long quantity;
}
