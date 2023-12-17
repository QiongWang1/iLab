package com.example.restservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Inventory {

    private Long id;
    private String item;
    private String fullName;
    private String vendor;
    private String catalog;
    private Date lastOrderedDate;
    private Date lastReceivedDate;
}
