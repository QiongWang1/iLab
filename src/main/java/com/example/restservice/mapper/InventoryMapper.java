package com.example.restservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.restservice.entity.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InventoryMapper extends BaseMapper<Inventory> {
    List<Inventory> selectAllOrder();

    List<Inventory> selectInventory(Inventory query);


    void insertOrQuery(Inventory inventory);
}
