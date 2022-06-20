package com.assignment.model;

import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDetail{
    private Stock stock;
    private AvailabilityEnum availability;
}
