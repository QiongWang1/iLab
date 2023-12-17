package com.example.restservice;

import com.example.restservice.entity.Inventory;
import com.example.restservice.entity.User;
import com.example.restservice.mapper.InventoryMapper;
import com.example.restservice.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class MyBatisPlusTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Test
    public void testSelect() {
        List<User> users = userMapper.selectList(null);
        Assert.isTrue(6 == users.size(), "查询错误");
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectOne() {
        User query = new User();
        query.setName("Jack");

//        User user = userMapper.selectOne(query);
//        System.out.println(user);
    }

    @Test
    public void testSelectAllOrder() {
        List<Inventory> inventories = inventoryMapper.selectAllOrder();
        System.out.println(inventories);
    }

    @Test
    public void testSelectOn() {
        Inventory inventory = inventoryMapper.selectOne(null);

        System.out.println(inventory);
    }
}
