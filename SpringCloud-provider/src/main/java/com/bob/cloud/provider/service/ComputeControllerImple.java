package com.bob.cloud.provider.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bob.cloud.provider.api.ComputeController;
import com.bob.cloud.provider.bean.User;

@RestController
public class ComputeControllerImple implements ComputeController {

	@Override
	public String hello(String name) {
		return "hello " + name;
	}
	
	@Override
	public User hello(String name, Integer age) {
		try {
			if(name == null) name = "json bob";
			name = URLDecoder.decode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("====name : " + name + "  age:" + age);
		return new User(name, age);
	}

	@Override
	public String hello(@RequestBody User user) {
		if (user == null) {
			return "未知";
		}
		try{
//			Thread.currentThread().sleep(3000);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====" + user.toString());
		return user.getName() + " ==== " + user.getAge() ;
	}

	// private final Logger logger = Logger.getLogger(getClass());
	//
	// @Autowired
	// private DiscoveryClient client;
	//
	// @RequestMapping(value = "/add" ,method = RequestMethod.GET)
	// public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
	// ServiceInstance instance = client.getLocalServiceInstance();
	// Integer r = a + b;
	// logger.info("/add, host:" + instance.getHost() + ", service_id:" +
	// instance.getServiceId() + ", result:" + r);
	// return r;
	// }

}