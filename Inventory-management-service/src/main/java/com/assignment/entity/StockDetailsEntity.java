package com.assignment.entity;

import com.assignment.model.AvailabilityEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "stock_details")
@IdClass(ProductCompositePK.class)
public class StockDetailsEntity implements Serializable {
    @Id
    private String productName;
    @Id
    private String productCategory;
    @Id
    private String productColor;
    private BigDecimal productPrice;
    private Long availableQuantity;
    private String availability;
}
