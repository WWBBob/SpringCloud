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
@RefreshScope//���ˢ�µ�����,bean�ᱻ���³�ʼ��������������
public class Main {
	
	//����bean����ʼ����test��ʹ֮ǰ����ֵ��Ҳ�ᱻ���³�ʼ��
	private String test = null;
	
	public static void main(String[] args) throws InterruptedException {
		new SpringApplicationBuilder(Main.class).web(true).run(args);
	}
	
	@Value("${manager}") // git�����ļ����key
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
