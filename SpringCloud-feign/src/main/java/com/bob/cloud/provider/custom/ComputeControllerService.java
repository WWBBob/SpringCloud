package com.bob.cloud.provider.custom;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.bob.cloud.provider.api.ComputeController;

@FeignClient(value = "cloud-provider")
public interface ComputeControllerService extends ComputeController{
	
}