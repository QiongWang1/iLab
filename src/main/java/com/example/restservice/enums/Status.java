package com.example.restservice.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum Status {
    DISABLE("0"), ENABLE("1");

    @EnumValue
    private String code;

    Status(String code) {
        this.code = code;
    }
}
