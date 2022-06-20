package com.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.View;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewStockDetails {
    private List<ViewStock> availableStock;
}
