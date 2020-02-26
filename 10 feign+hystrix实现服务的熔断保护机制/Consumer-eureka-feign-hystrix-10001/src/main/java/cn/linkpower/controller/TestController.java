package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.linkpower.feignService.ConsumerFeignClient;

@RestController
public class TestController {
	
	@Autowired
	private ConsumerFeignClient consumerFeignClient;
	
	//采用feign调用方式，进行服务和服务之间的请求
	@RequestMapping("/test1")
	public String test1(String name){
		return consumerFeignClient.getTest1ByFeign(name);
	}
}
