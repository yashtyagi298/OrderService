package com.example.OrderService.mappers;

import com.example.OrderService.dto.CreateOrderResponseDTO;
import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;
import com.example.OrderService.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto){
        return Order.builder()
                .userID(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static CreateOrderResponseDTO toCreateOrderResponseDTO(Order order){
        return CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .totalPrice(order.getItem().stream().mapToDouble(OrderItem::getTotalPrice).sum())
                .build();
    }
}
