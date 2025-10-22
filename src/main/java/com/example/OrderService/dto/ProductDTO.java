package com.example.OrderService.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private long id;
    private String name;
    private double price;
    private String description;
    private long categoryId;
    private String image;
}
