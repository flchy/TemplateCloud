package com.flchy.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.flchy.cloud.**.dao*")
@SpringCloudApplication
@EnableFeignClients("com.flchy.cloud")
public class MiniAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniAppApplication.class, args);
    }
}
