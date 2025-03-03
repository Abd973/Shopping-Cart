package com.projects.shoppingcart.dto;
import com.projects.shoppingcart.model.Category;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String brand;
    private int inventory;
    private String description;
    private Category category;
    private List<ImageDto> images;
}
