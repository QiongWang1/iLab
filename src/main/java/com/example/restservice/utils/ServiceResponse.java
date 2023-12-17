package com.example.restservice.utils;

import lombok.Data;

@Data
public class ServiceResponse {

    private Long code;

    private Boolean success;

    private String msg;

    private Object data;

    public static ServiceResponse SUCCESS(Object data) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.code = 1L;
        serviceResponse.success = true;
        serviceResponse.msg = "success";
        serviceResponse.data = data;

        return serviceResponse;
    }

    public static ServiceResponse FAILURE(String msg) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.code = 0L;
        serviceResponse.success = false;
        serviceResponse.msg = msg;
        serviceResponse.data = null;

        return serviceResponse;
    }



}
