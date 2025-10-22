package com.example.OrderService.services;

import com.example.OrderService.dto.CreateOrderResponseDTO;
import com.example.OrderService.dto.OrderRequestDTO;

public interface IOrderService {

   public  CreateOrderResponseDTO createOrder (OrderRequestDTO requestDTO);
}
