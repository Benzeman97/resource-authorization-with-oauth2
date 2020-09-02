package com.benz.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class TestResourceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestResourceServerApplication.class, args);
    }

}
