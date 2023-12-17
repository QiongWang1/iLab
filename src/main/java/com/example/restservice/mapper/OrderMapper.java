package com.example.restservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restservice.entity.Inventory;
import com.example.restservice.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> selectAllOrder();

    List<Order> selectOrdersByInventoryId(Long inventoryId);

    void insertOrder(Order order);
}
