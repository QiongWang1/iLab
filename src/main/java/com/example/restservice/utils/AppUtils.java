package com.example.restservice.utils;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class AppUtils {

    private Environment environment;

    //当前是否为开发环境
    public  boolean isDev() {
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> activeProfileList = Arrays.asList(activeProfiles);
        return activeProfileList.contains("dev");
    }
    //是否为测试环境
    public  boolean isTest(){
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> activeProfileList = Arrays.asList(activeProfiles);
        return activeProfileList.contains("test");
    }
    //是否为生产环境
    public  boolean isProd(){
        String[] activeProfiles = environment.getActiveProfiles();
        List<String> activeProfileList = Arrays.asList(activeProfiles);
        return activeProfileList.contains("prod");
    }

    public String[] all() {
        return environment.getActiveProfiles();
    }

}
