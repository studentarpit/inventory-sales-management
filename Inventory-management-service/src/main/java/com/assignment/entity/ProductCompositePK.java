package com.assignment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class ProductCompositePK  implements Serializable {

    protected String productName;
    protected String productCategory;
    protected String productColor;
}
