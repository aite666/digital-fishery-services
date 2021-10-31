package com.digital.fishery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动入口
 * Created by macro on 2018/4/26.
 */
@EnableScheduling
@SpringBootApplication
public class DigitalFisheryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalFisheryApplication.class, args);
    }
}
