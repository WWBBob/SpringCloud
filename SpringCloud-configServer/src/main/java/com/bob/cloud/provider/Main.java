package com.bob.cloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		new SpringApplicationBuilder(Main.class).web(true).run(args);
	}
	
	
}
