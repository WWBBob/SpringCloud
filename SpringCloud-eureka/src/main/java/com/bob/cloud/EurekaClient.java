package com.bob.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClient {
    public static void main(String[] args) {
//        SpringApplication.run(EurekaClient.class, args);
        new SpringApplication(EurekaClient.class).run(args);
    }
}
