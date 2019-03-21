package com.bob.cloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Main {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Main.class).web(true).run(args);
	}
	
}
