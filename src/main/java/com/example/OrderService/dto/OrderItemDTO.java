package com.example.OrderService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDTO {

    private long productId;
    private int quantity;

}
