package com.assignment.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "order_details")
public class OrderEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String orderId;
    @Column(name="product_name")
    String productName;
    @Column(name="product_color")
    String productColor;
    @Column(name="product_category")
    String productCategory;
    @Column(name="quantity")
    Long quantity;
}


