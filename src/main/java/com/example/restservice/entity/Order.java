package com.example.restservice.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {

    private Long id;

    private String owner;

    private String distributor;

    private String channel;

    private String unit;

    private Long qty;

    private BigDecimal unitPrice;

    private BigDecimal totalPrice;

    private String location;

    private Date dateRequest;

    private Date dateOrder;

    private Date dateReceived;

    private String link;

    private Long inventoryId;

}
