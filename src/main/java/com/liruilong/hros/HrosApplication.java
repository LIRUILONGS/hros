package com.liruilong.hros;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication//开启组件扫描和自动配置
@MapperScan(basePackages = "com.liruilong.hros.mapper")
@EnableScheduling
public class HrosApplication {

    public static void main(String[] args) {
        // 负责启动引导应用程序
        SpringApplication.run(HrosApplication.class, args);
    }



}
