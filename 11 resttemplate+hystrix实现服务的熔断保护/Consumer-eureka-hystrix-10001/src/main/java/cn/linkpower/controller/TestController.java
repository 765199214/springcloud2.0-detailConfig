package cn.linkpower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/test1")
	@HystrixCommand(fallbackMethod="testfallback")
	public String test1(@RequestParam String name){
		String memberUrl = "http://app-bunana-product/product/getProduct?name="+String.valueOf(name);
		String result = restTemplate.getForObject(memberUrl, String.class);
		return "this is Consumer,get result is ==="+String.valueOf(result);
	}
	
	public String testfallback(@RequestParam String name){
		return "请求异常，请联系开发者";
	}
}
