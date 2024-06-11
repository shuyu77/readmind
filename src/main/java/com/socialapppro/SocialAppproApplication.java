package com.socialapppro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.socialapppro.mapper")
public class SocialAppproApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialAppproApplication.class, args);
    }

}
