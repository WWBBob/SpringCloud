package com.bob.cloud.provider;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Main {

	public static void main(String[] args) throws IOException {
		new SpringApplicationBuilder(Main.class).web(true).run(args);
		System.in.read();
	}
	
}
