package com.bob.cloud.provider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		new SpringApplicationBuilder(Main.class).web(false).run(args);
	}
	
}
