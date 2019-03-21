package com.bob.cloud.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope//标记刷新的数据,bean会被重新初始化，丢弃旧数据
public class Main {
	
	//由于bean被初始化，test即使之前被赋值，也会被重新初始化
	private String test = null;
	
	public static void main(String[] args) throws InterruptedException {
		new SpringApplicationBuilder(Main.class).web(true).run(args);
	}
	
	@Value("${manager}") // git配置文件里的key
    String manager;
    
    @RequestMapping(value = "/hi")
    public String hi(){
        return manager + " ===== " + test;
    }
    
    @RequestMapping(value = "/set")
    public String set(){
    	test = "123";
        return test ;
    }
	
	
}
