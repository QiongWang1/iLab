package com.example.restservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.restservice.entity.Inventory;
import com.example.restservice.mapper.InventoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {
    private InventoryMapper inventoryMapper;

    public List<Inventory> getAllList() {
        return inventoryMapper.selectList(new QueryWrapper<Inventory>());
    }

    public List<Inventory> getList(Inventory query) {
        return inventoryMapper.selectInventory(query);
    }

    public Inventory getOneById(Inventory query) {
        QueryWrapper<Inventory> wrapper = new QueryWrapper<>();
        wrapper.eq("id", query.getId());
        return  inventoryMapper.selectOne(wrapper);
    }

    public Long insertOrQuery(Inventory inventory) {
        inventoryMapper.insertOrQuery(inventory);
//        inventoryMapper.insert(inventory);

        return inventory.getId();
    }

    public List<Inventory> search(String keyword) {
        Inventory query = new Inventory();
        query.setItem(keyword);
        return inventoryMapper.selectInventory(query);
    }
}
