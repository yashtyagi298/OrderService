package com.example.OrderService.dto;

import com.example.OrderService.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateOrderResponseDTO {
    private long orderId;
    private OrderStatus status;
    private double totalPrice;
}
