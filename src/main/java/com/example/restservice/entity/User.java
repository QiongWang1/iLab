package com.example.restservice.entity;

import com.example.restservice.enums.Active;
import com.example.restservice.enums.Sex;
import com.example.restservice.enums.Status;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Sex sex;
    private Status status;
    private Active active;
}
