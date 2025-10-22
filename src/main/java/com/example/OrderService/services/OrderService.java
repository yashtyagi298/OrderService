package com.example.OrderService.services;

import com.example.OrderService.clients.ProductServiceClient;
import com.example.OrderService.dto.CreateOrderResponseDTO;
import com.example.OrderService.dto.OrderItemDTO;
import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.ProductDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;
import com.example.OrderService.mappers.OrderItemMapper;
import com.example.OrderService.mappers.OrderMapper;
import com.example.OrderService.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    private final OrderRepository orderRepository;
    private final ProductServiceClient productClient;

    public OrderService(OrderRepository _orderRepository, ProductServiceClient productClient){
        this.orderRepository =_orderRepository;
        this.productClient = productClient;
    }
    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request) {
       Order order =  OrderMapper.toEntity(request);


        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : request.getItems()){
            ProductDTO product = productClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );

            items.add(item);
        }
        order.setItem(items);
        Order createdOrder = orderRepository.save(order);
        return OrderMapper.toCreateOrderResponseDTO(createdOrder);
    }
}
