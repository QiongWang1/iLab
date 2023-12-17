package com.example.restservice.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum Active implements IEnum<Integer> {
    NO, YES;

    @Override
    public Integer getValue() {
        return this.ordinal();
    }
}
