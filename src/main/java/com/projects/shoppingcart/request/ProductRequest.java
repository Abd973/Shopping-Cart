package com.projects.shoppingcart.request;

import com.projects.shoppingcart.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
public class ProductRequest {
    private Long id;
    private String name;
    private BigDecimal price;
    private String brand;
    private int inventory;
    private String description;
    private Category category;

}
