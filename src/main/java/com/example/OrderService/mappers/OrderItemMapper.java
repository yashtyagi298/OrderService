package com.example.OrderService.mappers;

import com.example.OrderService.dto.OrderItemDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;

public class OrderItemMapper {
   public static OrderItem OrderItemRequestDTOtoOrderItemEntity(OrderItemDTO itemDTO , Order order , double pricePerUnit , double totalPrice ){
       return OrderItem.builder()
               .productId(itemDTO.getProductId())
               .quantity(itemDTO.getQuantity())
               .pricePerUnit(pricePerUnit)
               .totalPrice(totalPrice)
               .order(order)
               .build();
   }
}
