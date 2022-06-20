package com.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewStock {
    String productName;
    String productCategory;
    String productColor;
    BigDecimal productPrice;
    AvailabilityEnum availability;
}
