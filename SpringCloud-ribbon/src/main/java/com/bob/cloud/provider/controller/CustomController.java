package com.bob.cloud.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomController {
	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("==========");
		return restTemplate.getForObject("http://CLOUD-PROVIDER/hello-service-remote/hello1", String.class);
	}
}
