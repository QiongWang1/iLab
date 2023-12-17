package com.example.restservice.controller;


import com.example.restservice.entity.Inventory;
import com.example.restservice.entity.Item;
import com.example.restservice.entity.Order;
import com.example.restservice.service.InventoryService;
import com.example.restservice.service.OrderService;
import com.example.restservice.utils.ServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {

    private InventoryService inventoryService;

    private OrderService orderService;

    @PostMapping("/login")
    public ServiceResponse login(@RequestBody String username, String password) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        map.put("roles", roles);
        map.put("token", "eyJhbGciOiJIUzUxMiJ9");
        map.put("refreshToken", "eyJhbGciOiJIUzUxMiJ9.refreshToken");
        map.put("expires", "2025/10/30 23:59:59");
        return ServiceResponse.SUCCESS(map);
    }

    @PostMapping("/refreshToken")
    public ServiceResponse refreshToken(@RequestBody String refreshToken) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", "eyJhbGciOiJIUzUxMiJ9");
        map.put("refreshToken", "eyJhbGciOiJIUzUxMiJ9.refreshToken");
        map.put("expires", "2025/10/30 23:59:59");

        return ServiceResponse.SUCCESS(map);

    }

    @GetMapping("/inventories")
    public ServiceResponse listAll() {
        return ServiceResponse.SUCCESS(inventoryService.getAllList());
    }

    @GetMapping("/inventories/search")
    public ServiceResponse search(@RequestParam String keyword) {
        return ServiceResponse.SUCCESS(inventoryService.search(keyword));
    }

    @GetMapping("/inventory")
    public ServiceResponse list(@RequestParam String item) {
        Inventory query = new Inventory();
        query.setItem(item);
        return ServiceResponse.SUCCESS(inventoryService.getList(query));
    }

    @GetMapping("/inventory/{id}")
    public ServiceResponse inventoryItem(@PathVariable Long id) {
        Inventory query = new Inventory();
        query.setId(id);
        Inventory inventory = inventoryService.getOneById(query);

        return ServiceResponse.SUCCESS(inventory);
    }

    @PostMapping("/add-item")
    public ServiceResponse addItem(@RequestBody Item item) {
        // 先处理 inventory
        Long inventoryId = inventoryService.insertOrQuery(item.getInventory());

        // 再处理 order
        Order order = item.getOrder();
        order.setInventoryId(inventoryId);
        orderService.insertOrder(order);

        return ServiceResponse.SUCCESS(new HashMap());
    }


    @GetMapping("/orders")
    public ServiceResponse orders(@RequestParam Long id) {
        return ServiceResponse.SUCCESS(orderService.getOrdersByInventoryId(id));
    }

}
