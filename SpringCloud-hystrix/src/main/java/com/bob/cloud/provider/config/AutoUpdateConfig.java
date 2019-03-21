package com.bob.cloud.provider.config;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AutoUpdateConfig {
	
	@Bean
    public DynamicConfiguration dynamicConfiguration() {
        DynamicConfiguration configuration = new DynamicConfiguration(new DegradeConfigSource(), 
        		new FixedDelayPollingScheduler(2 * 1000, 10 * 1000, false));
        ConfigurationManager.install(configuration); // must install to enable configuration
        return configuration;
    }
	
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext app = new SpringApplicationBuilder(AutoUpdateConfig.class).web(true).run(args);
		DynamicConfiguration configuration = app.getBean(DynamicConfiguration.class);
		while(true){
			Thread.sleep(2000l);
			System.err.println("a:" + configuration.getString("a"));
			System.err.println("b:" + configuration.getString("b"));
			System.err.println("c:" + configuration.getString("c"));
		}
	}
	
}

	// µœ÷ ≈‰÷√≤ﬂ¬‘
	class DegradeConfigSource implements PolledConfigurationSource {
	    @Override
	    public PollResult poll(boolean initial, Object checkPoint) throws Exception {
	        Map<String, Object> complete = new HashMap<>();
	        InputStream is = null;
	        Properties ps = new Properties();
	        try{
	        	is = AutoUpdateConfig.class.getClassLoader().getResourceAsStream("config.property");
	 	        ps.load(is);
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }finally {
	        	if(is != null)
	        		is.close();
			}
	        for(Object key : ps.keySet()){
	        	complete.put(key.toString(), ps.get(key));
	        }
	        return PollResult.createFull(complete);
	    }
	}
