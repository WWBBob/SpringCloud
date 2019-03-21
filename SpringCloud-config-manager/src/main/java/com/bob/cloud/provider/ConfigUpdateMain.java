package com.bob.cloud.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bob.cloud.provider.bean.TestProperBean;

@SpringBootApplication
@RestController
@RefreshScope
@ImportResource(locations = { "classpath:spring-context.xml" })
public class ConfigUpdateMain {
	
	@Value("${test}")
	private String test;
	
	@Autowired
	private TestProperBean bean;
	
	public static void main(String[] args) throws InterruptedException {
		new SpringApplicationBuilder(ConfigUpdateMain.class).web(true).run(args);
	}
	
	@RequestMapping("/port")
    public String port(){
        return test + " ========== "
        		+ bean.getName() + " ---- " + bean.getAge();
    }
	
}
