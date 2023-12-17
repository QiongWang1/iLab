package com.example.restservice.entity;

import lombok.Data;

@Data
public class Item {
    private Inventory inventory;
    private Order order;
}
