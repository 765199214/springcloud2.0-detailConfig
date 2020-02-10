package cn.linkpower.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.linkpower.feignService.ConsumerFeignClient;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ConsumerFeignClient consumerFeignClient;
	
	@RequestMapping("/test1")
	public String getTest1(String name){
		log.error("name--->{}",name);
		String result = consumerFeignClient.getTest1ByFeign(name);
		return "this is consumer project ,get product result = "+result;
	}
}
