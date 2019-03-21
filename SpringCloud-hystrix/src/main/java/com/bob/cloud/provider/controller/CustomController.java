package com.bob.cloud.provider.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bob.cloud.provider.bean.User;
import com.bob.cloud.provider.custom.ComputeControllerService;

@RestController
public class CustomController {

	@Autowired
	private ComputeControllerService computeControllerService;

	@RequestMapping("/hello")
	public Map<String, Object> hello() {
		Map<String, Object> ret = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
//		String s1 = computeControllerService.hello("张三");
//		sb.append(s1).append("\n");
//		User user = null;
//		try {
//			user = computeControllerService.hello(URLEncoder.encode("李四", "UTF-8"), 30);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		sb.append(user.toString()).append("\n");
		String s3 = computeControllerService.hello(new User("王五", 19));
		sb.append(s3).append("\n");
		ret.put("show", sb.toString());
		return ret;
	}
}
