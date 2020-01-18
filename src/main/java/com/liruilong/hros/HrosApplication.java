package com.liruilong.hros;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.liruilong.hros.mapper" )

public class HrosApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrosApplication.class, args);
    }

}
