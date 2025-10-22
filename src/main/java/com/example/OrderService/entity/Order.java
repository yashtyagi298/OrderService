package com.example.OrderService.entity;

import com.example.OrderService.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order extends BaseEntity{

    private long userID;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    private List<OrderItem> item;
}
