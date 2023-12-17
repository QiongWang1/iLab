package com.example.restservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.restservice.entity.Order;
import com.example.restservice.mapper.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderMapper orderMapper;

    public List<Order> getAllOrders() {
        return orderMapper.selectList(null);
    }

    public List<Order> getOrdersByInventoryId(Long inventoryId) {
        return orderMapper.selectOrdersByInventoryId(inventoryId);
    }

    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
